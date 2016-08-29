/**
 * 
 */
package mx.com.seguros.business.archivoretiros.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness;
import mx.com.seguros.business.pagos.CuentaClienteBusiness;
import mx.com.seguros.business.pagos.TransaccionCuentaClienteBusiness;
import mx.com.seguros.data.dao.ArchivoRetirosCargadoDao;
import mx.com.seguros.data.dao.CuentaClienteDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.TramiteRetiroDao;
import mx.com.seguros.model.ArchivoRetirosCargado;
import mx.com.seguros.model.ArchivoTramitePoliza;
import mx.com.seguros.model.CuentaCliente;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.TipoTransaccionCuentaCliente;
import mx.com.seguros.model.TramiteRetiro;
import mx.com.seguros.model.TransaccionCuentaCliente;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.FormatUtil;

/**
 * Implementación del servicio de negocio para las operaciones de carga, consulta y procesamiento del 
 * archivo de aplicación de trámites de retiro
 * @author Emigdio Hernandez
 *
 */
public class ArchivoTramiteRetirosBusinessImpl implements ArchivoTramiteRetirosBusiness {
	/**
	 * DAO para las operaciones sobre los registros de los archivos de retiros cargados
	 */
	private ArchivoRetirosCargadoDao archivoRetirosCargadoDao = null;
	/**
	 * DAO para la consulta de la póliza
	 */
	private IPolizaDao polizaDao = null;
	/**
	 * DAO para la consulta y actualización de la cuenta del cliente
	 */
	private CuentaClienteDao cuentaClienteDao = null;
	/**
	 * Servicio para las transacciones de la cuenta del cliente
	 */
	TransaccionCuentaClienteBusiness transaccionCuentaClienteBusiness = null;
	
	/**
	 * DAO para el registro de los trámites de los retiros
	 */
	TramiteRetiroDao tramiteRetiroDao = null;
	/**
	 * @param archivoRetirosCargadoDao the archivoRetirosCargadoDao to set
	 */
	public void setArchivoRetirosCargadoDao(ArchivoRetirosCargadoDao archivoRetirosCargadoDao) {
		this.archivoRetirosCargadoDao = archivoRetirosCargadoDao;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#obtenerArchivosRetiroCargados()
	 */
	@Override
	public List<ArchivoRetirosCargado> obtenerArchivosRetiroCargados() {
		return archivoRetirosCargadoDao.findArchivosAplicacionCargados(null);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#obtenerArchivoRetirosPorId(java.lang.Long)
	 */
	@Override
	public ArchivoRetirosCargado obtenerArchivoRetirosPorId(Long idArchivo) {
		return archivoRetirosCargadoDao.findArchivoRetirosCargadoPorId(idArchivo);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#insertarArchivoRetiros(mx.com.seguros.model.ArchivoRetirosCargado)
	 */
	@Override
	public void insertarArchivoRetiros(ArchivoRetirosCargado archivo) {
		archivoRetirosCargadoDao.insertarArchivoRetiros(archivo);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#actualizarArchivoRetiros(mx.com.seguros.model.ArchivoRetirosCargado)
	 */
	@Override
	public void actualizarArchivoRetiros(ArchivoRetirosCargado archivo) {
		archivoRetirosCargadoDao.actualizarArchivoRetiros(archivo);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#eliminarArchivoRetiros(java.lang.Long)
	 */
	@Override
	public void eliminarArchivoRetiros(Long idArchivo) {
		archivoRetirosCargadoDao.eliminarArchivoRetiros(idArchivo);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#cargarArchivoRetiros(java.util.List, byte[], java.lang.String, java.lang.String)
	 */
	@Override
	public void cargarArchivoRetiros(List<String[]> datosArchivo,byte[] contenidoArchivo, String usuario, String nombreArchivo)	throws Exception {
		
		StringBuffer log = new StringBuffer();
		if(datosArchivo != null){
			Integer numPoliza  = 0;
			Integer numConsignatario = 0;
			int numRegistro = 0;
			int numRegistrosActualizados = 0;
			PolizaIndividual poliza = new PolizaIndividual();
			TransaccionCuentaCliente transaccion = null;
			CuentaCliente cuentaCliente = null;
			ArchivoRetirosCargado archivo = new ArchivoRetirosCargado();
			TramiteRetiro tramite = null;
			archivo.setFechaCarga(new Date());
			archivo.setFechaHoraInicio(new Date());
			
			archivo.setFechaHoraFin(new Date());
			archivo.setArchivo(contenidoArchivo);
			archivo.setLog(log.toString());
			archivo.setNombreArchivo(nombreArchivo);
			archivo.setUsername(usuario);
			archivo.setNumeroRegistros(datosArchivo.size());
			insertarArchivoRetiros(archivo);
			
			
			for(String[] registro : datosArchivo){
				//Validar contenido del registro
				if(registro != null && registro.length > 6){
					numRegistro++;
					numPoliza = NumberUtils.toInt(registro[1], 0);
					numConsignatario = NumberUtils.toInt(registro[0], 0);
					//validar formatos
					if(numPoliza <= 0 || numConsignatario <=0 ){
						log.append("Registro " + numRegistro + ": Formato no reconocido de póliza o emisor ("+registro[0]+"-"+registro[1]+")\n");
					}else{
						poliza = polizaDao.obtenerDetallePolizaPorNumero(numPoliza, numConsignatario);
						if(poliza!=null){
							
								//Obtener la cuenta del cliente
								cuentaCliente = cuentaClienteDao.obtenerCuentaClienteByPoliza(poliza.getNumPoliza(), poliza.getNumConsignatario());
								//14/11/2014 si la cuenta cliente no existe, crearla
								if(cuentaCliente == null){
							        cuentaCliente = new CuentaCliente(numPoliza,numConsignatario);
							        cuentaCliente.setSaldoCuenta(BigDecimal.ZERO);
							        cuentaCliente.setFechaCalculoSaldo(new Date());
							        cuentaCliente.setNumNominaContratante(poliza.getSolicitud().getNumNominaContratante());
							        cuentaClienteDao.createCuentaCliente(cuentaCliente);
								}
								tramite = new TramiteRetiro();
								tramite.setIdArchivoRetirosCargado(archivo.getIdArchivoRetirosCargado());
								tramite.setImporteOriginal(obtenerDouble(registro[3]));
								tramite.setNombreOperador(registro[4]);
								tramite.setNombreSucursal(registro[5]);
								tramite.setNumNominaContratante(cuentaCliente.getNumNominaContratante());
								tramite.setNumPoliza(cuentaCliente.getNumPoliza());
								tramite.setNumConsignatario(cuentaCliente.getNumConsignatario());
								tramite.setObservacionConcepto(registro[2]);
								tramite.setUsername(usuario);
								tramite.setFechaTramite(parseFechaTramite(registro[6]));
								//Verificar el monto del retiro
								if(tramite.getImporteOriginal() > 0){
									tramite.setImporteAplicado(tramite.getImporteOriginal());
									if(cuentaCliente.getSaldoCuenta().doubleValue() >= tramite.getImporteOriginal()){
										//Aplicación normal
									}else{
										//Aplicación para dejar el saldo negativo
										log.append("Registro " + numRegistro + " ("+ poliza.getNumConsignatario() +" - " + poliza.getNumPoliza() +") : Importe de retiro mayor al saldo, saldo: "+cuentaCliente.getSaldoCuenta().doubleValue()+
												"  - Se aplica importe completo y se deja saldo de: " + (cuentaCliente.getSaldoCuenta().doubleValue() - tramite.getImporteAplicado() )  + "\n");
									}
									transaccion = transaccionCuentaClienteBusiness.realizarTransaccion(new BigDecimal(tramite.getImporteAplicado()*-1), 
											TipoTransaccionCuentaCliente.CVE_TIPO_MOV_RETIRO, cuentaCliente);
									numRegistrosActualizados++;
									tramite.setTransaccionId(transaccion.getTransaccionId());
									
									tramiteRetiroDao.insertarTramiteRetiro(tramite);
								}else{
									log.append("Registro " + numRegistro +  " ("+ poliza.getNumConsignatario() +" - " + poliza.getNumPoliza()+ " :  Importe de retiro no válido ("+registro[3]+")\n");
								}
						}else{
							log.append("Registro " + numRegistro + ": Póliza no localizada ("+registro[0]+"-"+registro[1]+")\n");
						}
					}
				}else{
					log.append("Registro " + numRegistro + ": Columnas incompletas\n");
				}
				
			}
			log.append("Proceso Finalizado --\n\nNúmero de registros con retiros aplicados: " + numRegistrosActualizados + "\n");
			archivo.setLog(log.toString());
			archivo.setFechaHoraFin(new Date());
			actualizarArchivoRetiros(archivo);
		}
		
	}
	/**
	 * Intenta parsear un número a double haciendo trim y quitando posibles comas
	 * @param string
	 * @return
	 */
	private double obtenerDouble(String numCadena) {
		double resultado = 0;
		if(numCadena != null){
			String numTmp = numCadena.trim();
			numTmp = numTmp.replaceAll(",","");
			numTmp = numTmp.replaceAll(" ","");
			resultado = NumberUtils.toDouble(numTmp,0);
			
		}
		
		return resultado;
	}

	/**
	 * Intenta hacer el parseo de fecha, si no lo logra, null se retorna
	 * @param string
	 * @return
	 */
	private Date parseFechaTramite(String string) {
		Date fecha = FormatUtil.stringToDate(string, "dd/MM/yy");
		
		if(fecha == null){
			fecha = FormatUtil.stringToDate(string, "yy/MM/dd");
		}
		if(fecha == null){
			fecha = FormatUtil.stringToDate(string, "yy-MM-dd");
		}
		if(fecha == null){
			fecha = FormatUtil.stringToDate(string, "yyyy-MM-dd");
		}
		if(fecha == null){
			fecha = FormatUtil.stringToDate(string, "yyyy/MM/dd");
		}
		if(fecha == null){
			fecha = FormatUtil.stringToDate(string, "dd/MM/yyyy");
		}
		
		return fecha;
	}

	/**
	 * @param polizaDao the polizaDao to set
	 */
	public void setPolizaDao(IPolizaDao polizaDao) {
		this.polizaDao = polizaDao;
	}

	/**
	 * @param cuentaClienteDao the cuentaClienteDao to set
	 */
	public void setCuentaClienteDao(CuentaClienteDao cuentaClienteDao) {
		this.cuentaClienteDao = cuentaClienteDao;
	}

	/**
	 * @param transaccionCuentaClienteBusiness the transaccionCuentaClienteBusiness to set
	 */
	public void setTransaccionCuentaClienteBusiness(
			TransaccionCuentaClienteBusiness transaccionCuentaClienteBusiness) {
		this.transaccionCuentaClienteBusiness = transaccionCuentaClienteBusiness;
	}

	/**
	 * @param tramiteRetiroDao the tramiteRetiroDao to set
	 */
	public void setTramiteRetiroDao(TramiteRetiroDao tramiteRetiroDao) {
		this.tramiteRetiroDao = tramiteRetiroDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness#consultarTramitesDeRetiroDeAsegurado(java.lang.String)
	 */
	@Override
	public List<TramiteRetiro> consultarTramitesDeRetiroDeAsegurado(Integer numPoliza, Integer numConsignatario) {
		return tramiteRetiroDao.consultarTramitesRetiroPorAsegurado(numPoliza,numConsignatario);
	}
}
