/*
 * PolizaSqlMapDao.java
 *
 * Created on 25 de septiembre de 2007, 11:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.dto.SolicitudPKParamDTO;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.CalendarioEnvioMovimientosDependencias;
import mx.com.seguros.model.EstatusPolizaGeneral;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.PaqueteVidaDxN;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.model.Retenedor;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author Cesar
 */

public class PolizaSqlMapDao extends SqlMapClientDaoSupport implements IPolizaDao {
    
    /** Creates a new instance of PolizaSqlMapDao */
    public PolizaSqlMapDao() {
    }
    
    @Override
    public void autofinarciarPolizaCancel(PolizaIndividual polizaIndividual){
        this.getSqlMapClientTemplate().update("autofinanciarPolizaPorCancel",polizaIndividual);
    }

     @Override
    public void cancelarPoliza(PolizaIndividual polizaIndividual){
        this.getSqlMapClientTemplate().update("cancelarPoliza",polizaIndividual);
    }

    @Override
    public void insertarPoliza(PolizaIndividual polizaIndividual) {
        /*return (Integer)*/ this.getSqlMapClientTemplate().insert("insertarPoliza", polizaIndividual);
    }

    @Override
    public void actualizaPolizaCambio(PolizaIndividual polizaIndividual){
        this.getSqlMapClientTemplate().update("actualizaPolizaCambio", polizaIndividual);
    }

    @Override
    public void actualizarSolicitud(int folioSolicitud,String formatoSolicitud){
        this.getSqlMapClientTemplate().update("actualizarSolicitud",
        		new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }

    @Override
    public String obtenerPlaza(int folioSolicitud, String formatoSolicitud) {
        return (String) this.getSqlMapClientTemplate().queryForObject("obtenerCvePlaza", 
        		new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }

    @Override
    public List obtenerPolizaNumPoliza (Map params){
        return this.getSqlMapClientTemplate().
        		queryForList("seleccionarPolizaNum",params);
      
    }

    @Override
    public List obtenerPolizaNumContratante (Map params){
        return this.getSqlMapClientTemplate().queryForList("seleccionarPolizaNumContratante",params);
    }

    @Override
    public List obtenerPolizaApPaternoContratante (Map params){
        return this.getSqlMapClientTemplate().queryForList("seleccionarPolizaApPaternoContratante",params);
    }

    @Override
    public List obtenerPolizaCertificado (Map params){
        return this.getSqlMapClientTemplate().queryForList("seleccionarPolizaNumeroCertificado",params);
    }

    @Override
    public List obtenerRfcAsegurado (Map params){
        return this.getSqlMapClientTemplate().queryForList("seleccionarPolizaRFC",params);
    }

    @Override
    public List obtenerApellidoAsegurado (Map params){
        return this.getSqlMapClientTemplate().queryForList("seleccionarPolizaApPaterno",params);
    }

    @Override
    public List obtenerPolizaEntregadaEmitidaAgente(String agente){
        return (List)this.getSqlMapClientTemplate().queryForList("seleccionarPolizaEntregadaEmitidaAgente",agente);
    }

    @Override
    public void actualizaEstatusPoliza (PolizaIndividual polizaIndividual){
        if(polizaIndividual.getFechaRecepcionPoliza()!=null)
            this.getSqlMapClientTemplate().update("actualizaPolizasEntregadas",polizaIndividual);
        else
            this.getSqlMapClientTemplate().update("actualizaPolizas",polizaIndividual);
    }

    @Override
    public int actualizaEstatusPolizaPago(PolizaIndividual polizaIndividual){
       return this.getSqlMapClientTemplate().update("actualizaEstatusPolizaPago",polizaIndividual);
    }


    @Override
   public int actualizaEstatusPolizaSeguimiento(PolizaIndividual polizaIndividual){
        return this.getSqlMapClientTemplate().update("actualizaEstatusPolizaSeguimiento",polizaIndividual);
    }

    @Override
   public void actualizaEstatusPolizaAmbos(PolizaIndividual polizaIndividual){
        this.getSqlMapClientTemplate().update("actualizaEstatusPolizaAmbos",polizaIndividual);
    }

    @Override
    public List obtenerEstatusPoliza(){
        return (List)this.getSqlMapClientTemplate().queryForList("obtenerEstatusPoliza");
    }

    @Override
    public List obtenerPolizasPorEntregarAsegurado(String agente){
        return (List)this.getSqlMapClientTemplate().queryForList("obtenPolizaPorEntregarAsegurado",agente);
    }

    @Override
    public void actualizaIndicadorPagoComisionEntregaPoliza(PolizaIndividual polizaIndividual){
        this.getSqlMapClientTemplate().update("actualizaIndicadorPagoComisionEntregaPoliza",polizaIndividual);
    }

    @Override
    public void actualizaIndicadorDescuentoComision(PolizaIndividual polizaIndividual){
        this.getSqlMapClientTemplate().update("actualizaIndicadorDescuentoComision",polizaIndividual);
    }

    @Override
    public Object obtenerPolizaPorSolicitud(int folioSolicitud, String formatoSolicitud){
        List res = this.getSqlMapClientTemplate().queryForList("obtenerPolizaPorSolicitud",
        		new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    	return res!=null && !res.isEmpty()?res.get(0):null;
    }

    @Override
    public List obtenListaDescuentosAplicados( int numPoliza){
        return (List)this.getSqlMapClientTemplate().queryForList("obtenListaDescuentosAplicados",numPoliza);
    }

    @Override
    public String contarListaDescuentosAplicados(int numPoliza){
        return (String)this.getSqlMapClientTemplate().queryForObject("contarListaDescuentosAplicados",numPoliza);
    }

    @Override
    public List buscarFechaCalendario(CalendarioEnvioMovimientosDependencias calendario){
        return (List)this.getSqlMapClientTemplate().queryForList("buscarFechaCalendario",calendario);
    }

    @Override
    public List obtenerListaHistorialMovContratante(String contratante){
        return (List)this.getSqlMapClientTemplate().queryForList("obtenerListaHistorialMovContratante",contratante);
    }

    @Override
    public Retenedor obtenerRetenedor(int folioSolicitud, String formatoSolicitud){
        return (Retenedor)this.getSqlMapClientTemplate().queryForObject("obtenerRetenedor",
        		new SolicitudPKParamDTO(folioSolicitud,formatoSolicitud));
    }

    @Override
    public Integer obtenerPolizasPorNumNominaContratante(String numNominaContratante){
        return (Integer)this.getSqlMapClientTemplate().queryForObject("obtenerPolizasPorNumNominaContratante",numNominaContratante);
    }

    @Override
    public Integer consultaContadorPolizasVigentes(String numNominaContratante) {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("consultaContadorPolizasVigentes",numNominaContratante);
    }

    @Override
    public List consultaPolizasVigentes(String numNominaContratante) {
        return (List)this.getSqlMapClientTemplate().queryForList("consultaPolizasVigentes",numNominaContratante);
    }

    @Override
    public Integer consultaContadorPolizasMvtoQnaCliente(HistorialMovimientosContratante historial) {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("consultaContadorPolizasMvtoQnaCliente",historial);
    }

    @Override
    public List consultaPolizasMvtoQnaCliente(HistorialMovimientosContratante historial) {
        return (List)this.getSqlMapClientTemplate().queryForList("consultaPolizasMvtoQnaCliente",historial);
    }

@Override
    public String consultarClaveDescuentoPorSolicitud(int folioSolicitud, String formatoSolicitud) {
        return (String)this.getSqlMapClientTemplate().queryForObject("consultarClaveDescuentoPorSolicitud", 
        			new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    }

    @Override
    public void insertarHistorial(HistorialMovimientosContratante historial) {
        this.getSqlMapClientTemplate().insert("insertarHistorial",historial);
    }

    @Override
    public Object obtenerPolizaNumPolizaNumConsignatario(PolizaIndividual poliza) {
        return (Object)this.getSqlMapClientTemplate().queryForObject("obtenerPolizaNumPolizaNumConsignatario",poliza);
    }

    @Override
    public void actualizarQnaProgEnvioPoliza(PolizaIndividual poliza){
        this.getSqlMapClientTemplate().update("actualizarQnaProgEnvioPoliza", poliza);
    }

     @Override
    public Object obtenerPolizasPorFolioSolicitudNoCancelada(int folioSolicitud, String formatoSolicitud){
        List res =  getSqlMapClientTemplate().queryForList("obtenPolizaPorFolioSolicitud",
        		new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud));
    	 return res!=null && !res.isEmpty()?res.get(0):null;
    }
    
    @Override
    public List obtenListaPolizasCambio(String numNominaContratante){
        return (List)this.getSqlMapClientTemplate().queryForList("obtenListaPolizasCambio",numNominaContratante);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IPolizaDao#obtenerDetallePolizaPorNumero(int, int)
     */
    @Override
    public PolizaIndividual obtenerDetallePolizaPorNumero(int numPoliza,int emisor) {
        Map params = new HashMap();
        params.put("numPoliza",numPoliza);
        params.put("numConsignatario",emisor);
        return (PolizaIndividual)getSqlMapClientTemplate().queryForObject("seleccionarPolizaNumConsignatario",params);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IPolizaDao#actuzalizarPoliza(mx.com.seguros.model.PolizaIndividual)
     */
	@Override
	public void actuzalizarPoliza(PolizaIndividual poliza) {
		
		getSqlMapClientTemplate().update("actualizarPoliza",poliza);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#consultarCatalogoBeneficiosAdicionales()
	 */
	@Override
	public List<BeneficioAdicional> consultarCatalogoBeneficiosAdicionales() {
		return getSqlMapClientTemplate().queryForList("consultarCatalogoBeneficiosAdicionales");
	}

	@Override
	public List<BeneficioAdicionalPoliza> consultarBeneficiosAdicionalesDePoliza(
			int numPoliza, int numConsignatario) {
		Map params = new HashMap();
		params.put("numPoliza",numPoliza);
		params.put("numConsignatario", numConsignatario);
		return getSqlMapClientTemplate().queryForList("consultarBeneficiosAdicionalesDePoliza",params);
	}

	@Override
	public void eliminarBeneficiosAdicionalesDePoliza(int numPoliza,
			int numConsignatario) {
		Map params = new HashMap();
		params.put("numPoliza",numPoliza);
		params.put("numConsignatario", numConsignatario);
		getSqlMapClientTemplate().delete("eliminarBeneficiosAdicionalesDePoliza",params);
		
	}

	@Override
	public void guardarBeneficiosAdicionales(
			List<BeneficioAdicionalPoliza> beneficios) {
		
		for(BeneficioAdicionalPoliza benf:beneficios){
			getSqlMapClientTemplate().insert("guardarBeneficioAdicionalPoliza",benf);
			
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#obtenerPaqueteSeguroPorNombre(java.lang.String)
	 */
	@Override
	public PaqueteVidaDxN obtenerPaqueteSeguroPorNombre(String nombrePaquete) {
		return (PaqueteVidaDxN)getSqlMapClientTemplate().queryForObject("obtenerTipoSeguroPorNombre",nombrePaquete);
	}
    
    
	//Smart Solutions diciembre 2011
	//Inclusión del módulo de pagos

	@Override
    public PolizaIndividual obtenerPolizaById(PolizaIndividual poliza) {
        return (PolizaIndividual) getSqlMapClientTemplate().queryForObject("obtenerPolizaById", poliza);
    }
	
	@Override
    public List<PolizaIndividual> consultaPolizasVigentesNew(String numNominaContratante, Date fechaLimiteCarga) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("numNominaContratante", numNominaContratante);
        paramMap.put("fechaLimiteCarga", fechaLimiteCarga);

        List<PolizaIndividual> polizasVigentes;
        polizasVigentes = (List) getSqlMapClientTemplate().queryForList(
                "consultaPolizasVigentesNew", paramMap);
        List<PolizaIndividual> polizasVigentesLinked;
        polizasVigentesLinked = new LinkedList<PolizaIndividual>(
                polizasVigentes);
        return polizasVigentesLinked;

    }
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#recuperarQnaPrimerIntentoPago(mx.com.seguros.model.PolizaIndividual)
	 */
	
	@Override
    public Integer recuperarQnaPrimerIntentoPago(PolizaIndividual poliza) {
        Integer qnaPrimerIntentoPago;
        qnaPrimerIntentoPago = (Integer) getSqlMapClientTemplate().queryForObject("recuperarQnaPrimerIntentoPago", poliza);
        return qnaPrimerIntentoPago;
    }

    @Override
    public void insertarQnaPrimerIntentoPago(PolizaIndividual poliza, Integer qnaPrimerIntentoPago) {
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("qnaPrimerIntentoPago", qnaPrimerIntentoPago);
        parameterMap.put("numPoliza", poliza.getNumPoliza());
        parameterMap.put("numConsignatario", poliza.getNumConsignatario());
        getSqlMapClientTemplate().update("insertarQnaPrimerIntentoPago",
                parameterMap);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IPolizaDao#actualizarSumaAseguradaTotal(mx.com.seguros.model.PolizaIndividual)
     */
	@Override
	public void actualizarSumaAseguradaTotal(PolizaIndividual poliza) {
		getSqlMapClientTemplate().update("actualizarSumaAseguradaTotal",poliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#actualizarPkPolizaIndividual(mx.com.seguros.model.PolizaIndividual, mx.com.seguros.model.PolizaIndividual)
	 */
	@Override
	public void actualizarPkPolizaIndividual(PolizaIndividual datosOriginales,
			PolizaIndividual datosNuevos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("numPolizaNuevo", datosNuevos.getNumPoliza()!=null?datosNuevos.getNumPoliza():datosOriginales.getNumPoliza());
		params.put("numConsignatarioNuevo", datosNuevos.getNumConsignatario()!=null?datosNuevos.getNumConsignatario():datosOriginales.getNumConsignatario());
		params.put("numPoliza", datosOriginales.getNumPoliza());
		params.put("numConsignatario", datosOriginales.getNumConsignatario());
		getSqlMapClientTemplate().update("actualizarPkPolizaIndividual",params);
		
	}

	
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#cargarPolizasPorPKBatch(java.util.List, java.util.List)
	 */
	@Override
	public List<PolizaIndividual> cargarPolizasPorPKBatch(
			List<Integer> numerosPoliza, List<Integer> numerosConsignatario) {
		List<PolizaIndividual> resultados = new ArrayList<PolizaIndividual>();
		Map<String,String> params = null;;
		if(numerosPoliza != null && numerosConsignatario != null && numerosPoliza.size() == numerosConsignatario.size()){
			int iActual = 0;
			int iBatch = 0;
			while(iActual < numerosPoliza.size() ){
				//juntar 50 id's
				params = new HashMap<String,String>();
				for(iBatch = 0; iBatch < 50 && iActual<numerosPoliza.size(); iBatch++, iActual++){
					params.put("id"+iBatch, numerosPoliza.get(iActual)+ "-"+numerosConsignatario.get(iActual));
				}
				//Realizar la consulta y agregarla a los resultados
				resultados.addAll(getSqlMapClientTemplate().queryForList("consultaPolizaCompletaBatch", params));
			}
			
		}
		return resultados;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#consultarPolizasParaAutofinanciar(mx.com.seguros.utils.ResultadoPaginadoDTO, java.lang.Integer)
	 */
	@Override
	public void consultarPolizasParaAutofinanciar(ResultadoPaginadoDTO<PolizaIndividual> resultado,Integer idPlaza, Integer idEstatusPolizaPagos) {
		Map param =  new HashMap();
		param.put("fecha", new Date());
		param.put("idPlaza", idPlaza);
		param.put("idEstatusPolizaPagos", idEstatusPolizaPagos); 
		if(resultado.isPrimerVez()){
            //obtener el total de registros de la consulta
            Integer totalResultados = (Integer)getSqlMapClientTemplate().queryForObject("countConsultaPolizasBatchPorAutofinanciar",param);
            resultado.setTotalResultados(totalResultados);
            resultado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultado.getRegistrosPorPagina()) ));
            resultado.setPrimerVez(false);
            resultado.setPaginaActual(1);
        }

        resultado.setResultados(getSqlMapClientTemplate().queryForList("consultaPolizasBatchPorAutofinanciar",param,
                (resultado.getPaginaActual()-1)*resultado.getRegistrosPorPagina() 
                ,resultado.getRegistrosPorPagina() ));
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#obtenerResumenPoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public PolizaIndividual obtenerResumenPoliza(Integer numPoliza,	Integer numConsignatario) {
		Map param =  new HashMap();
		param.put("numPoliza", numPoliza);
		param.put("numConsignatario", numConsignatario);
		return (PolizaIndividual)getSqlMapClientTemplate().queryForObject("consultarResumenPoliza",param);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#actualizarFechasCancelacionPoliza(mx.com.seguros.model.PolizaIndividual)
	 */
	@Override
	public int actualizarFechasCancelacionPoliza(PolizaIndividual poliza) {
		return getSqlMapClientTemplate().update("actualizarFechasCancelacionPoliza",poliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#insertarProductosInburnomina(mx.com.seguros.model.ProductosInburnomina)
	 */
	@Override
	public void insertarProductosInburnomina(ProductosInburnomina datosProductos) {
		getSqlMapClientTemplate().insert("guardarProductosInburnomina",datosProductos);		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#actualizarDatosPrductosInburnomina(mx.com.seguros.model.ProductosInburnomina)
	 */
	@Override
	public void actualizarDatosPrductosInburnomina(ProductosInburnomina datosProductos) {
		getSqlMapClientTemplate().update("actualizarProductosInburnomina",datosProductos);		
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#consultarProductosInburnominaDePoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public ProductosInburnomina consultarProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario) {
		Map param =  new HashMap();
		param.put("numPoliza", numPoliza);
		param.put("numConsignatario", numConsignatario);
		return (ProductosInburnomina)getSqlMapClientTemplate().queryForObject("consultaProductosInburnominaPorPoliza",param);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#actualizarEstatusPolizaGeneral(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void actualizarEstatusPolizaGeneral(Integer numPoliza, Integer numConsignatario, Integer idEstatusPolizaGeneral) {
		Map param =  new HashMap();
		param.put("numPoliza", numPoliza);
		param.put("numConsignatario", numConsignatario);
		param.put("idEstatusPolizaGeneral", idEstatusPolizaGeneral);
		getSqlMapClientTemplate().update("actualizarEstatusPolizaGeneral",param);		
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#obtenerEstatusPolizaGeneral()
	 */
	@Override
	public List<EstatusPolizaGeneral> obtenerEstatusPolizaGeneral() {
		return getSqlMapClientTemplate().queryForList("consultaEstatusPolizaGeneral");
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#actualizarDatosPolizaAtencionClientes(mx.com.seguros.model.PolizaIndividual)
	 */
	@Override
	public void actualizarDatosPolizaAtencionClientes(PolizaIndividual poliza) {
		
		getSqlMapClientTemplate().update("actualizarDatosPolizaAtencionClientes",poliza);
		
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#consultarPolizasPorBaja(mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO, mx.com.seguros.utils.ResultadoPaginadoDTO)
	 */
	@Override
	public void consultarPolizasPorBaja(CriteriosConsultaPolizaPorBajaDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado) {
		
		
		if(resultado.isPrimerVez()){
            //obtener el total de registros de la consulta
            Long totalResultados = (Long)getSqlMapClientTemplate().queryForObject("countConsultaPolizasPorBaja", criterios);
            resultado.setTotalResultados(totalResultados);
            resultado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultado.getRegistrosPorPagina()) ));
                     
        }
        resultado.setResultados(getSqlMapClientTemplate().queryForList("consultaPolizasPorBaja",criterios,
                (resultado.getPaginaActual()-1)*resultado.getRegistrosPorPagina()
                ,resultado.getRegistrosPorPagina() ));
		
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IPolizaDao#consultarPlazas()
	 */
	@Override
	public List<Plaza> consultarPlazas() {
		return getSqlMapClientTemplate().queryForList("selectPlazas");
	}
    

    
    

   
    
}
