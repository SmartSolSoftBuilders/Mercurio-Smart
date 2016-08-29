/**
 * 
 */
package mx.com.seguros.business.comisiones.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;
import mx.com.seguros.business.pagos.exception.PagosBusinessException;
import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao;
import mx.com.seguros.data.dao.IDescuetosAplicadosDao;
import mx.com.seguros.dto.BonoPolizaPorCalcularDTO;
import mx.com.seguros.dto.ResultadoCalculoBonoPolizaAgenteDTO;
import mx.com.seguros.model.CalculoBonoPolizaAgente;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Implementación del servicio de negocio para el cálculo, consulta y registro de
 * bonos de póliza a agentes
 * @author Emigdio Hernandez
 *
 */
public class CalculoBonoPolizaBusinessImpl implements CalculoBonoPolizaBusiness {
	/**
	 * Dao para operaciones de los bonos
	 */
	private ICalculoBonoPolizaAgenteDao calculoBonoPolizaAgenteDao = null;
	/**
	 * Dao para la consulta de los datos del agente
	 */
	private IAgenteDao agenteDao = null;
	/**
	 * Manejador de transacciones
	 */
	private PlatformTransactionManager transactionManager;
	/**
	 * Dao para consultas a los descuentos aplicados de la póliza
	 */
	private IDescuetosAplicadosDao descuentosAplicadosDao = null;
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness#obtenerCalculoDeBonosAFechaActual(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<ResumenCalculoBonoPolizaAgente>  obtenerCalculoDeBonosAFechaActual(Integer numPoliza, Integer numConsignatario, Integer idPlaza) {
		/*
		 * Se calculará bono de conservación para todas las pólizas excepto las que tengan en Estatus de Pago igual a Autofinanciamiento por 
		 * Cancelación, Cancelada por Cliente y Sin Pagos Aplicados
		 * 
		 */
		List<BonoPolizaPorCalcularDTO> listaPorCalcular = calculoBonoPolizaAgenteDao.consultarBonosPendientesPorCalcular(numPoliza, numConsignatario,idPlaza);
		//Recorrer la lista de polizas por calcular y realizar el cálculo del bono
		Date fechaCalculo = new Date();
		CalculoBonoPolizaAgente calculoBono = null;
		int quincenasConBono = 0;
		int quincenasPagadas = 0;
		int quincenasPorCalcular = 0;
		//agrupar los cálculos por agente
		Map<Integer,List<CalculoBonoPolizaAgente>> calculoBonoPorAgente = new HashMap<Integer, List<CalculoBonoPolizaAgente>>();
		List<DescuentosAplicados> descuentosConPrima = null;
		for(BonoPolizaPorCalcularDTO bonoPorCalcular:listaPorCalcular){
			//System.out.println(bonoPorCalcular);
			
			calculoBono = new CalculoBonoPolizaAgente();
			calculoBono.setNumPoliza(bonoPorCalcular.getNumPoliza());
			calculoBono.setNumConsignatario(bonoPorCalcular.getNumConsignatario());
			calculoBono.setCveAgente(bonoPorCalcular.getCveAgente());
			calculoBono.setFechaCalculo(fechaCalculo);
			//calcular el número de quincenas para calcular de la póliza
			
			quincenasConBono = bonoPorCalcular.getNumQuincenasPagadas() != null?bonoPorCalcular.getNumQuincenasPagadas():0;
			quincenasPagadas = bonoPorCalcular.getDescuentosAplicados();
			quincenasPorCalcular = (quincenasPagadas>24?24:quincenasPagadas) - quincenasConBono;
			
			//System.out.println("Quincenas por pagar bono = " + (quincenasPorCalcular) );
			//obtener los descuentos aplicados con pago a prima para calcular los montos de pago mensual y su porcentaje para bono
			descuentosConPrima = descuentosAplicadosDao.obtenerDescuentosAplicadosConPagoPrima(calculoBono.getNumPoliza(), calculoBono.getNumConsignatario());
			//contar a partir del primer año
			if(descuentosConPrima.size()>(12+quincenasConBono)){
				int iDescuento = 12+quincenasConBono;
				int numeroQuincenas = 0;
				double montoBono = 0.0;
				boolean primerAnio = false;
				calculoBono.setQuincenaInicial(descuentosConPrima.get(iDescuento).getNumQuincenaPagada());
				for(int bonosCalculados = 1;iDescuento<descuentosConPrima.size() && bonosCalculados<=quincenasPorCalcular;
						iDescuento++,bonosCalculados++){
					//calcular el bono del descuento actual
					//Enero 2014 -> Todo el cálculo se estandariza a 5 %
					//primer año de cálculo de bono 7%
					if(iDescuento < 24){
						montoBono += descuentosConPrima.get(iDescuento).getImpRealPagoPrima() * .05;
						//System.out.println("Monto quincena  "+ (quincenasConBono+bonosCalculados) + " (7%) = " + (descuentosConPrima.get(iDescuento).getImpRealPagoPrima() * .07) );
						primerAnio = true;
						calculoBono.setPorcentaje(.05);
						calculoBono.setTarifa(descuentosConPrima.get(iDescuento).getImpRealPagoPrima());
					}else{
						//si venimos de calcular el primero año y saltamos al segundo año de bonos, hacer un corte
						if(primerAnio){
							primerAnio = false;
							calculoBono.setQuincenaFinal(descuentosConPrima.get(iDescuento-1).getNumQuincenaPagada());
							calculoBono.setNumeroQuincenas(numeroQuincenas);
							
							calculoBono.setMontoBono(montoBono);
							
							//System.out.println("Monto total  = "+ montoBono );
							//agregar el cálculo a la bolsa del agente
							if(calculoBonoPorAgente.get(calculoBono.getCveAgente()) == null){
								calculoBonoPorAgente.put(calculoBono.getCveAgente(), new ArrayList<CalculoBonoPolizaAgente>());
							}
							calculoBonoPorAgente.get(calculoBono.getCveAgente()).add(calculoBono);
							
							calculoBono = new CalculoBonoPolizaAgente();
							calculoBono.setQuincenaInicial(descuentosConPrima.get(iDescuento).getNumQuincenaPagada());
							calculoBono.setNumPoliza(bonoPorCalcular.getNumPoliza());
							calculoBono.setNumConsignatario(bonoPorCalcular.getNumConsignatario());
							calculoBono.setCveAgente(bonoPorCalcular.getCveAgente());
							calculoBono.setFechaCalculo(fechaCalculo);
							montoBono = 0;
							numeroQuincenas = 0;
						}
						
						
						//segundo año 5%
						
						montoBono += descuentosConPrima.get(iDescuento).getImpRealPagoPrima() * .05;
						//System.out.println("Monto quincena  "+ (quincenasConBono+bonosCalculados) + " (5%) = " + (descuentosConPrima.get(iDescuento).getImpRealPagoPrima() * .05) );
						calculoBono.setPorcentaje(.05);
						calculoBono.setTarifa(descuentosConPrima.get(iDescuento).getImpRealPagoPrima());
					}
					numeroQuincenas++;
				}
				
				calculoBono.setQuincenaFinal(descuentosConPrima.get(iDescuento-1).getNumQuincenaPagada());
				calculoBono.setNumeroQuincenas(numeroQuincenas);
				calculoBono.setMontoBono(montoBono);
				//agregar el cálculo a la bolsa del agente
				if(calculoBonoPorAgente.get(calculoBono.getCveAgente()) == null){
					calculoBonoPorAgente.put(calculoBono.getCveAgente(), new ArrayList<CalculoBonoPolizaAgente>());
				}
				calculoBonoPorAgente.get(calculoBono.getCveAgente()).add(calculoBono);
				
				
			}
			
			
		}
		
		
		//construir el resultado final para mostrar en pantalla
		List<ResumenCalculoBonoPolizaAgente> listaResumenCalculo = new ArrayList<ResumenCalculoBonoPolizaAgente>();
		ResumenCalculoBonoPolizaAgente resumenCalculo = null;
		double montoBonoPorAgente = 0;
		for(Entry<Integer, List<CalculoBonoPolizaAgente>> elementoCalculo:calculoBonoPorAgente.entrySet()){
			resumenCalculo = new ResumenCalculoBonoPolizaAgente();
			resumenCalculo.setCveAgente(elementoCalculo.getKey());
			resumenCalculo.setFechaCalculo(fechaCalculo);
			//acumlar el monto de los bonos por póliza
			montoBonoPorAgente = 0;
			for(CalculoBonoPolizaAgente calculoBonoPorPoliza:elementoCalculo.getValue()){
				montoBonoPorAgente += calculoBonoPorPoliza.getMontoBono();
			}
			resumenCalculo.setMontoBono(new BigDecimal(montoBonoPorAgente));
			resumenCalculo.setAgente(agenteDao.obtenerAgentePorCveAgente(resumenCalculo.getCveAgente()));
			resumenCalculo.getAgente().setEmpleado(agenteDao.obtenerEmpleadoPorClave(resumenCalculo.getAgente().getCveEmpleado()));
			resumenCalculo.setListaDetalleCalculo(elementoCalculo.getValue());
			listaResumenCalculo.add(resumenCalculo);
		}
		return listaResumenCalculo;
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness#registrarCalculoBonoFinal(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer)
	 */
	@Override
	public ResumenProcesoCalculoBono registrarCalculoBonoFinal(Integer numPoliza, Integer numConsignatario, String usuario, Integer idPlaza) throws PagosBusinessException{
		
		List<ResumenCalculoBonoPolizaAgente> listaCalculo = obtenerCalculoDeBonosAFechaActual(numPoliza,numConsignatario,idPlaza);
		double montoFinal = 0;
		ResumenProcesoCalculoBono resumenProceso = new ResumenProcesoCalculoBono();
		
		//Realiza la inserción de cada resumen de cálculo con su detalle
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
		try{
			//insertar el resumen del proceso de cálculo
			resumenProceso.setFechaCalculo(new Date());
			resumenProceso.setMontoTotal(null);
			resumenProceso.setCveUsuario(usuario);
			resumenProceso.setIdPlaza(idPlaza);
			for(ResumenCalculoBonoPolizaAgente resumen:listaCalculo){
				montoFinal+=resumen.getMontoBono().doubleValue();
			}
			resumenProceso.setMontoTotal(new BigDecimal(montoFinal));
			calculoBonoPolizaAgenteDao.insertarResumenProcesoCalculoBono(resumenProceso);
				
			for(ResumenCalculoBonoPolizaAgente resumen:listaCalculo){
				resumen.setIdResumenProcesoCalculoBono(resumenProceso.getIdResumenProcesoCalculoBono());
				calculoBonoPolizaAgenteDao.insertarResumenCalculoBonoPolizaAgente(resumen);
				for(CalculoBonoPolizaAgente calculoBono:resumen.getListaDetalleCalculo()){
					calculoBono.setIdResumenCalculoBonoPolizaAgente(resumen.getIdResumenCalculoBonoPolizaAgente());
					calculoBonoPolizaAgenteDao.insertarCalculoBonoPolizaAgente(calculoBono);
					
				}
			}
		    transactionManager.commit(status);
		}catch(Exception ex){
			transactionManager.rollback(status);
			throw new PagosBusinessException(ex.getMessage());
		}
		
		return resumenProceso;
	}
	/**
	 * @return the calculoBonoPolizaAgenteDao
	 */
	public ICalculoBonoPolizaAgenteDao getCalculoBonoPolizaAgenteDao() {
		return calculoBonoPolizaAgenteDao;
	}
	/**
	 * @param calculoBonoPolizaAgenteDao the calculoBonoPolizaAgenteDao to set
	 */
	public void setCalculoBonoPolizaAgenteDao(
			ICalculoBonoPolizaAgenteDao calculoBonoPolizaAgenteDao) {
		this.calculoBonoPolizaAgenteDao = calculoBonoPolizaAgenteDao;
	}
	/**
	 * @return the descuentosAplicadosDao
	 */
	public IDescuetosAplicadosDao getDescuentosAplicadosDao() {
		return descuentosAplicadosDao;
	}
	/**
	 * @param descuentosAplicadosDao the descuentosAplicadosDao to set
	 */
	public void setDescuentosAplicadosDao(
			IDescuetosAplicadosDao descuentosAplicadosDao) {
		this.descuentosAplicadosDao = descuentosAplicadosDao;
	}
	/**
	 * @return the agenteDao
	 */
	public IAgenteDao getAgenteDao() {
		return agenteDao;
	}
	/**
	 * @param agenteDao the agenteDao to set
	 */
	public void setAgenteDao(IAgenteDao agenteDao) {
		this.agenteDao = agenteDao;
	}
	/**
	 * @return the transactionManager
	 */
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	/**
	 * @param transactionManager the transactionManager to set
	 */
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness#consultarResumenProcesosCalculoBono()
	 */
	@Override
	public List<ResumenProcesoCalculoBono> consultarResumenProcesosCalculoBono() {
		return calculoBonoPolizaAgenteDao.consultarResumenProcesosCalculoBono();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness#consultaDetalleProcesoCalculoBono(java.lang.Integer)
	 */
	@Override
	public ResumenProcesoCalculoBono consultaDetalleProcesoCalculoBono(
			Integer idResumenProcesoCalculoBono) {
		ResumenProcesoCalculoBono resumenProceso = calculoBonoPolizaAgenteDao.consultarResumenProcesoCalculoBonoPorId(idResumenProcesoCalculoBono);
		if(resumenProceso != null){
			//consultar los resumenes por agente involucrados
			resumenProceso.setListaDetalleAgente(calculoBonoPolizaAgenteDao.consultarResumenCalculoBonoPolizaAgentePorIdResumenCalculo(idResumenProcesoCalculoBono));
			//colocar los elementos de resumen por agente en un mapa para posteriormente ir acomodando sus detalles
			Map<Integer,ResumenCalculoBonoPolizaAgente> mapaAgentes = new HashMap<Integer, ResumenCalculoBonoPolizaAgente>();
			for(ResumenCalculoBonoPolizaAgente resumenPorAgente:resumenProceso.getListaDetalleAgente()){
				mapaAgentes.put(resumenPorAgente.getCveAgente(),resumenPorAgente);
				resumenPorAgente.setAgente(agenteDao.obtenerAgentePorCveAgente(resumenPorAgente.getCveAgente()));
				resumenPorAgente.getAgente().setEmpleado(agenteDao.obtenerEmpleadoPorClave(resumenPorAgente.getAgente().getCveEmpleado()));
			}
			//obtener todos los detalles de cálculo
			List<ResultadoCalculoBonoPolizaAgenteDTO> detallesCalculo = calculoBonoPolizaAgenteDao.consultarDetalleCalculoBonoPolizaAgentePorIdResumenProcesoCalculoBono(idResumenProcesoCalculoBono);
			//Organizar los resultados
			for(ResultadoCalculoBonoPolizaAgenteDTO detalleCalculo:detallesCalculo){
				mapaAgentes.get(detalleCalculo.getCveAgente()).getResultadoDetalleCalculo().add(detalleCalculo);
			}
		}
		return resumenProceso;
	}
	

}
