/**
 * 
 */
package mx.com.seguros.business.archivoestatus.impl;

import java.util.Date;
import java.util.List;

import mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness;
import mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao;
import mx.com.seguros.data.dao.ArchivoTramitePolizaDao;
import mx.com.seguros.data.dao.EstatusPolizaPagosDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza;
import mx.com.seguros.model.ArchivoTramitePoliza;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.FormatUtil;

import org.apache.commons.lang.math.NumberUtils;

/**
 * Implementación del servicio de negocio para la manipulación y carga
 * de archivos de cambio de estatus de póliza.
 * @author Emigdio Hernández
 * 
 *
 */
public class ArchivoCambioEstatusPolizaBusinessImpl implements	ArchivoCambioEstatusPolizaBusiness {

	private ArchivoTramitePolizaDao archivoTramitePolizaDao;
	private ArchivoCambioEstatusPagosPolizaDao archivoCambioEstatusPagosPolizaDao;
	private EstatusPolizaPagosDao estatusPolizaPagosDao;
	private IPolizaDao polizaDao;
	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#obtenerArchivosTramitePoliza()
	 */
	@Override
	public List<ArchivoTramitePoliza> obtenerArchivosTramitePoliza() {
		return archivoTramitePolizaDao.obtenerArchivosTramitePoliza();
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#obtenerArchivosTramitePolizaPorId(java.lang.Integer)
	 */
	@Override
	public ArchivoTramitePoliza obtenerArchivosTramitePolizaPorId(Integer idArchivoTramitePoliza) {
		return archivoTramitePolizaDao.obtenerArchivosTramitePolizaPorId(idArchivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#insertarArchivoTramitePoliza(mx.com.seguros.model.ArchivoTramitePoliza)
	 */
	@Override
	public void insertarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza) {
		archivoTramitePolizaDao.insertarArchivoTramitePoliza(archivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#actualizarArchivoTramitePoliza(mx.com.seguros.model.ArchivoTramitePoliza)
	 */
	@Override
	public void actualizarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza) {
		archivoTramitePolizaDao.actualizarArchivoTramitePoliza(archivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#eliminarArchivoTramitePoliza(java.lang.Integer)
	 */
	@Override
	public void eliminarArchivoTramitePoliza(Integer idArchivoTramitePoliza) {
		archivoTramitePolizaDao.eliminarArchivoTramitePoliza(idArchivoTramitePoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#cargarArchivoCambioEstatusPoliza(java.util.List, byte[], java.lang.String, java.lang.String)
	 */
	@Override
	public void cargarArchivoCambioEstatusPoliza(List<String[]> datosArchivo,byte[] contenidoArchivo, String usuario, String nombreArchivo)	throws Exception {
		StringBuffer log = new StringBuffer();
		if(datosArchivo != null){
			Integer numPoliza  = 0;
			Integer numConsignatario = 0;
			int numRegistro = 0;
			int numRegistrosActualizados = 0;
			PolizaIndividual polizaActualizar = new PolizaIndividual();
			ArchivoTramitePoliza archivo = new ArchivoTramitePoliza();
			archivo.setFechaCarga(new Date());
			archivo.setFechaHoraInicio(new Date());
			for(String[] registro : datosArchivo){
				//Validar contenido del registro
				if(registro != null && registro.length > 2){
					numRegistro++;
					numPoliza = NumberUtils.toInt(registro[0], 0);
					numConsignatario = NumberUtils.toInt(registro[1], 0);
					//validar formatos
					if(numPoliza <= 0 || numConsignatario <=0 ){
						log.append("Registro " + numRegistro + ": Formato no reconocido de póliza o emisor ("+registro[0]+"-"+registro[1]+")\n");
					}else{
						polizaActualizar.setIdEstatusPolizaSeguimiento(0);
						polizaActualizar.setNumConsignatario(numConsignatario);
						polizaActualizar.setNumPoliza(numPoliza);
						//Procesar el registro
						if(ENTREGADO_AGENTE.equalsIgnoreCase(registro[2]!=null?registro[2].trim():null)){
							polizaActualizar.setIdEstatusPolizaSeguimiento(ConstantesGenerales.ESTATUS_SEGUIMIENTO_POLIZA_ENTREGADA_AGENTE);
						}
						if(ENTREGADO_CLIENTE.equalsIgnoreCase(registro[2]!=null?registro[2].trim():null)){
							polizaActualizar.setIdEstatusPolizaSeguimiento(ConstantesGenerales.ESTATUS_SEGUIMIENTO_POLIZA_ENTREGADA_ASEGURADO);
						}
						if(polizaActualizar.getIdEstatusPolizaSeguimiento() > 0){
							if(polizaDao.actualizaEstatusPolizaSeguimiento(polizaActualizar)>0){
								numRegistrosActualizados ++;
							}else{
								log.append("Registro " + numRegistro + ": Póliza no encontrada ("+numPoliza+"-"+numConsignatario+")\n");
							}
						}
					}
					
				}else{
					log.append("Registro " + numRegistro + ": Columnas incompletas\n");
				}
				
			}
			log.append("Proceso Finalizado --\n\nNúmero de registros con cambio de estatus: " + numRegistrosActualizados + "\n");
			
			archivo.setFechaHoraFin(new Date());
			archivo.setArchivo(contenidoArchivo);
			archivo.setLog(log.toString());
			archivo.setNombreArchivo(nombreArchivo);
			archivo.setUsuario(usuario);
			archivo.setNumeroRegistros(numRegistro);
			insertarArchivoTramitePoliza(archivo);
		}
		
	}
	/**
	 * @param archivoTramitePolizaDao the archivoTramitePolizaDao to set
	 */
	public void setArchivoTramitePolizaDao(ArchivoTramitePolizaDao archivoTramitePolizaDao) {
		this.archivoTramitePolizaDao = archivoTramitePolizaDao;
	}

	/**
	 * @param polizaDao the polizaDao to set
	 */
	public void setPolizaDao(IPolizaDao polizaDao) {
		this.polizaDao = polizaDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#obtenerArchivosCambioEstatusPagosPoliza()
	 */
	@Override
	public List<ArchivoCambioEstatusPagosPoliza> obtenerArchivosCambioEstatusPagosPoliza() {
		return archivoCambioEstatusPagosPolizaDao.obtenerArchivosCambioEstatusPagosPoliza();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#obtenerArchivosCambioEstatusPagosPolizaPorId(java.lang.Integer)
	 */
	@Override
	public ArchivoCambioEstatusPagosPoliza obtenerArchivosCambioEstatusPagosPolizaPorId(Integer idArchivoCambioEstatusPagosPoliza) {
		return archivoCambioEstatusPagosPolizaDao.obtenerArchivosCambioEstatusPagosPolizaPorId(idArchivoCambioEstatusPagosPoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#insertarArchivoCambioEstatusPagosPoliza(mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza)
	 */
	@Override
	public void insertarArchivoCambioEstatusPagosPoliza(ArchivoCambioEstatusPagosPoliza archivoCambioEstatusPagosPoliza) {
		archivoCambioEstatusPagosPolizaDao.insertarArchivoCambioEstatusPagosPoliza(archivoCambioEstatusPagosPoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#actualizarArchivoCambioEstatusPagosPoliza(mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza)
	 */
	@Override
	public void actualizarArchivoCambioEstatusPagosPoliza(ArchivoCambioEstatusPagosPoliza archivoCambioEstatusPagosPoliza) {
		archivoCambioEstatusPagosPolizaDao.actualizarArchivoCambioEstatusPagosPoliza(archivoCambioEstatusPagosPoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#eliminarArchivoCambioEstatusPagosPoliza(java.lang.Integer)
	 */
	@Override
	public void eliminarArchivoCambioEstatusPagosPoliza(Integer idArchivoCambioEstatusPagosPoliza) {
		archivoCambioEstatusPagosPolizaDao.eliminarArchivoCambioEstatusPagosPoliza(idArchivoCambioEstatusPagosPoliza);
	}

	/**
	 * @param archivoCambioEstatusPagosPolizaDao the archivoCambioEstatusPagosPolizaDao to set
	 */
	public void setArchivoCambioEstatusPagosPolizaDao(
			ArchivoCambioEstatusPagosPolizaDao archivoCambioEstatusPagosPolizaDao) {
		this.archivoCambioEstatusPagosPolizaDao = archivoCambioEstatusPagosPolizaDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness#cargarArchivoCambioEstatusPagosPoliza(java.util.List, byte[], java.lang.String, java.lang.String)
	 */
	@Override
	public void cargarArchivoCambioEstatusPagosPoliza(List<String[]> datosArchivo, byte[] contenidoArchivo,	String usuario, String nombreArchivo) throws Exception {
		StringBuffer log = new StringBuffer();
		if(datosArchivo != null){
			Integer numPoliza  = 0;
			Integer numConsignatario = 0;
			int numRegistro = 0;
			int numRegistrosActualizados = 0;
			EstatusPolizaPagos estatusNuevo = null;
			PolizaIndividual polizaActualizar = new PolizaIndividual();
			ArchivoCambioEstatusPagosPoliza archivo = new ArchivoCambioEstatusPagosPoliza();
			
			archivo.setFechaCarga(new Date());
			archivo.setFechaHoraInicio(new Date());
			for(String[] registro : datosArchivo){
				//Validar contenido del registro
				if(registro != null && registro.length > 2){
					numRegistro++;
					numPoliza = NumberUtils.toInt(registro[0], 0);
					numConsignatario = NumberUtils.toInt(registro[1], 0);
					//validar formatos
					if(numPoliza <= 0 || numConsignatario <=0 ){
						log.append("Registro " + numRegistro + ": Formato no reconocido de póliza o emisor ("+registro[0]+"-"+registro[1]+")\n");
					}else{
						polizaActualizar.setIdEstatusPagosPoliza(0);
						polizaActualizar.setNumConsignatario(numConsignatario);
						polizaActualizar.setNumPoliza(numPoliza);
						//Procesar el registro
						
						//Buscar el identificador del estatus de acuerdo a su descripció
						
						if(registro[2] != null){
							estatusNuevo = estatusPolizaPagosDao.obtenerEstatusPolizaPagosByDescripcion(registro[2]);
							if(estatusNuevo != null){
								
								polizaActualizar.setIdEstatusPagosPoliza(estatusNuevo.getIdEstatusPagosPoliza());
								//Verificar los estatus si es:
								/*i.	Sin Pagos Aplicados
								ii.	Cancelada por Falta de Pago
								iii.	Cancelada por Sustitución
								iv.	Cancelada por Petición Cliente
								*/ 
								//Pasar a cancelada, si no, vigente
								int estatusPago = estatusNuevo.getIdEstatusPagosPoliza();
								if(estatusPago == ConstantesGenerales.ESTATUS_PAGOS_POLIZA_SIN_PAGOS_APLICADOS ||
										estatusPago == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_FALTA_DE_PAGO ||
										estatusPago == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_CLIENTE ||
										estatusPago == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_SUSTITUCION){
									polizaActualizar.setIdEstatusPolizaGeneral(ConstantesGenerales.ESTATUS_POLIZA_GENERAL_CANCELADA);
								}else{
									polizaActualizar.setIdEstatusPolizaGeneral(ConstantesGenerales.ESTATUS_POLIZA_GENERAL_CANCELADA);
								}
								
								
								//SI es cancelada por el cliente, leer las fechas de cancelación
								if(estatusNuevo.getIdEstatusPagosPoliza() == ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_CLIENTE){
									polizaActualizar.setFechaSolicitudCancelacion(FormatUtil.stringToDate(registro[3],"dd/MM/yy"));
									polizaActualizar.setFechaCancelacionDescuento(FormatUtil.stringToDate(registro[4],"dd/MM/yy"));
								}
								
							}
						}
						
						
						if(polizaActualizar.getIdEstatusPagosPoliza() > 0){
							if(polizaDao.actualizaEstatusPolizaPago(polizaActualizar)>0){
								numRegistrosActualizados ++;
								polizaDao.actualizarFechasCancelacionPoliza(polizaActualizar);
								polizaDao.actualizarEstatusPolizaGeneral(polizaActualizar.getNumPoliza(), polizaActualizar.getNumConsignatario(), polizaActualizar.getIdEstatusPolizaGeneral());
							}else{
								log.append("Registro " + numRegistro + ": Póliza no encontrada ("+numPoliza+"-"+numConsignatario+")\n");
							}
						}
					}
					
				}else{
					log.append("Registro " + numRegistro + ": Columnas incompletas\n");
				}
				
			}
			log.append("Proceso Finalizado --\n\nNúmero de registros con cambio de estatus en pagos: " + numRegistrosActualizados + "\n");
			
			archivo.setFechaHoraFin(new Date());
			archivo.setArchivo(contenidoArchivo);
			archivo.setLog(log.toString());
			archivo.setNombreArchivo(nombreArchivo);
			archivo.setUsuario(usuario);
			archivo.setNumeroRegistros(numRegistro);
			insertarArchivoCambioEstatusPagosPoliza(archivo);
		}
	}
	

		/**
		 * @param estatusPolizaPagosDao the estatusPolizaPagosDao to set
		 */
		public void setEstatusPolizaPagosDao(EstatusPolizaPagosDao estatusPolizaPagosDao) {
			this.estatusPolizaPagosDao = estatusPolizaPagosDao;
		}

}

	
