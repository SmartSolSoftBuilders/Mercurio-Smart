/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: ArchivoPolizaBusiness.java
 * Fecha de creación: 17/06/2011
 * Última Modificación: 17/06/2011
 */

package mx.com.seguros.business.archivopolizas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mx.com.seguros.data.dao.IAseguradoDao;
import mx.com.seguros.data.dao.IContratanteDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.IRegistroArchivoPolizasDao;
import mx.com.seguros.data.dao.ISolicitanteDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.model.Asegurado;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.EstadoRegistroPoliza;
import mx.com.seguros.model.PaqueteVidaDxN;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.model.ResumenCargaArchivoPolizas;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.DistribucionCamposArchivoPolizasInbursa;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * Implementación del servico de negocio para la consulta de los registros de pólizas cargados desde archivo
 * @author Emigdio Hernández
 */
public class ArchivoPolizasBusiness implements IArchivoPolizasBusiness {

    private IRegistroArchivoPolizasDao registroArchivoPolizasDao;

    private ISolicitudDao solicitudDao;

    private IContratanteDao contratanteDao;

    private ISolicitanteDao solicitanteDao;

    private IPolizaDao polizaDao;

    private IAseguradoDao aseguradoDao;
    
    private SeguridadUtil seguridadUtil;
    
    private static String BANDERA_FIN = "Termino";
   
    @Override
    public void consultarRegistroArchivoPolizasPorEstatus(Integer estadoRegistroPoliza, ResultadoPaginadoDTO resultado) {
       registroArchivoPolizasDao.consultarRegistroArchivoPolizasPorEstatus(estadoRegistroPoliza, resultado);
    }
    @Override
    public PolizaIndividual copiarRegistroArchivoPolizaASistema(Long idRegistroArchivoPolizas) {
        
        PolizaIndividual poliza = null;
        
         
        RegistroArchivoPolizas registroFuente = registroArchivoPolizasDao.consultarPorId(idRegistroArchivoPolizas);
        
        if(registroFuente != null){
        	poliza = copiarDatosPoliza(registroFuente);
        	poliza.setSolicitud(copiarDatosSolicitud(registroFuente));
            
        }


        return poliza;
        
    }

    /**
     * @return the registroArchivoPolizasDao
     */
    public IRegistroArchivoPolizasDao getRegistroArchivoPolizasDao() {
        return registroArchivoPolizasDao;
    }

    /**
     * @param registroArchivoPolizasDao the registroArchivoPolizasDao to set
     */
    public void setRegistroArchivoPolizasDao(IRegistroArchivoPolizasDao registroArchivoPolizasDao) {
        this.registroArchivoPolizasDao = registroArchivoPolizasDao;
    }

    /**
     * @return the solicitudDao
     */
    public ISolicitudDao getSolicitudDao() {
        return solicitudDao;
    }

    /**
     * @param solicitudDao the solicitudDao to set
     */
    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;
    }
    /**
     * Copia los datos de la solicitud que existen en el registro cargado del
     * archivo de pólizas a la estructura de solicitud
     * @param registroFuente Datos de origen del registro
     * @return Objeto de solicitud creado
     */
    private Solicitud copiarDatosSolicitud(RegistroArchivoPolizas registroFuente) {
       Solicitud sol = null;
       if(registroFuente != null){

           //Solicitud
           sol = new Solicitud();
           sol.setRFCsolicitante(registroFuente.getRFCasegurado());
           sol.setNumNominaContratante(registroFuente.getNumNominaAsegurado());
           sol.setFechaSolicitud(
        		   registroFuente.getFechaSolicitud()!=null?
        				   new java.sql.Date(registroFuente.getFechaSolicitud().getTime()):null);
           sol.setCvePromotor(registroFuente.getCvePromotor());
           sol.setFolioSolicitud(registroFuente.getFolioSolicitud());
           sol.setFechaCaptura(new Date());
           sol.setAgente(null);
           TarifaAportMensual tarifa = buscarTarifa(registroFuente.getImporteTarifa());
           sol.setCveTarifa(tarifa!=null?tarifa.getCveTarifa():1);
           sol.setTarifa(tarifa!=null?tarifa:new TarifaAportMensual());
           sol.setIdEstatusSolicitud(ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA);

           //Contratante
           Contratante contratante = new Contratante();
           
           contratante.setNumNominaContratante(registroFuente.getNumNominaAsegurado()!=null?
        		   registroFuente.getNumNominaAsegurado().trim():StringUtils.EMPTY);
           contratante.setApPaternoContratante(registroFuente.getApPaternoContratante()!=null?
        		   registroFuente.getApPaternoContratante().trim():StringUtils.EMPTY);
           contratante.setApMaternoContratante(registroFuente.getApMaternoContratante()!=null?
        		   registroFuente.getApMaternoContratante().trim():StringUtils.EMPTY);
           contratante.setNombre1Contratante(registroFuente.getNombre1Contratante()!=null?
        		   registroFuente.getNombre1Contratante().trim():StringUtils.EMPTY);
           contratante.setNombre2Contratante(registroFuente.getNombre2Contratante()!=null?
        		   registroFuente.getNombre2Contratante().trim():StringUtils.EMPTY);

           sol.setContratante(contratante);

           //Solicitante

           Solicitante solicitante = new Solicitante();

           solicitante.setApPaternoSolicitante(registroFuente.getApPaternoAsegurado()!=null?
        		   registroFuente.getApPaternoAsegurado().trim():StringUtils.EMPTY);
           solicitante.setApMaternoSolicitante(registroFuente.getApMaternoAsegurado()!=null?
        		   registroFuente.getApPaternoAsegurado().trim():StringUtils.EMPTY);
           solicitante.setNombre1Solicitante(registroFuente.getNombre1Asegurado()!=null?
        		   registroFuente.getApPaternoAsegurado().trim():StringUtils.EMPTY);
           solicitante.setNombre2Solicitante(registroFuente.getNombre2Asegurado()!=null?
        		   registroFuente.getApPaternoAsegurado().trim():StringUtils.EMPTY);
           solicitante.setRFCsolicitante(registroFuente.getRFCasegurado());
           solicitante.setFechaNacimientoSolicitante(registroFuente.getFechaNacimientoAsegurado());
           solicitante.setSexoSolicitanteMasculino(FormatUtil.esSexoMasculino(registroFuente.getCveSexoAsegurado()));
           solicitante.setEsFumadorAsegurado(FormatUtil.tranformarBoolean(registroFuente.getEsFumadorAsegurado()));
           solicitante.setEstadoCivilSolicitante(FormatUtil.transformarEstadoCivil(registroFuente.getCveEstadoCivilAsegurado()));
           solicitante.setCalle(registroFuente.getCalle());
           solicitante.setNumExtInt(registroFuente.getNumExterior());
           solicitante.setEdificio(registroFuente.getNumInterior());
           solicitante.setCodPostal(NumberUtils.toInt(registroFuente.getCodPostal(),0));
           solicitante.setColonia(registroFuente.getColonia());
           solicitante.setEntidadFederativa(registroFuente.getEntidadFederativa());
           solicitante.setDelegacionMpio(registroFuente.getDelegacionMpio());
           sol.setClaveUsuarioRegistro(seguridadUtil.getUsuario().getUsername());
           sol.setFechaRegistro(new Date());

           sol.setSolicitante(solicitante);
           
           Beneficiario[] beneficiario = new Beneficiario[Solicitud.NUM_MAX_BENEFICIARIOS];
           
           for(int i=0; i<Solicitud.NUM_MAX_BENEFICIARIOS; i++)
               beneficiario[i] = new Beneficiario();
           sol.setBeneficiario(beneficiario);

           
       }


       return sol;
    }
    /**
     * Busca una clave de tarifa en base al importe enviado como parámetro
     * @param importeTarifa Importe a buscar
     * @returns Tarifa localizada, null en caso de no localizarla
     */
    private TarifaAportMensual buscarTarifa(Double importeTarifa) {
       return solicitudDao.obtenerTarifaMensualPorImporte(importeTarifa!=null?importeTarifa:0.00);
    }

    /**
     * @return the contratanteDao
     */
    public IContratanteDao getContratanteDao() {
        return contratanteDao;
    }

    /**
     * @param contratanteDao the contratanteDao to set
     */
    public void setContratanteDao(IContratanteDao contratanteDao) {
        this.contratanteDao = contratanteDao;
    }

    /**
     * @return the solicitanteDao
     */
    public ISolicitanteDao getSolicitanteDao() {
        return solicitanteDao;
    }

    /**
     * @param solicitanteDao the solicitanteDao to set
     */
    public void setSolicitanteDao(ISolicitanteDao solicitanteDao) {
        this.solicitanteDao = solicitanteDao;
    }
    /**
     * Copia los datos del registro de archivo de polizas en la entidad
     * de poliza individual
     * @param registroFuente Datos fuente
     * @return Poliza creada
     */
    private PolizaIndividual copiarDatosPoliza(RegistroArchivoPolizas registroFuente) {
       PolizaIndividual poliza = null;
       if(registroFuente != null){
            poliza = new PolizaIndividual();
            poliza.setNumPoliza(NumberUtils.toInt(registroFuente.getNumPoliza()));
            poliza.setNumConsignatario(NumberUtils.toInt(registroFuente.getNumConsignatario()));
            poliza.setAgrupacionCIS(NumberUtils.toInt(registroFuente.getAgrupacionCIS()));
            poliza.setAgrupacion(registroFuente.getAgrupacion());
            poliza.setFechaInicioVigencia(registroFuente.getFechaInicioVigencia());
            poliza.setSumaAseguradaIndividual(registroFuente.getSumaAseguradaIndividual());
            poliza.setSumaBAF(registroFuente.getSumaBAF());
            poliza.setSumaDIPM(registroFuente.getSumaDIPM());
            poliza.setSumaDIPMC(registroFuente.getSumaDIPMC());
            poliza.setSumaBITP(registroFuente.getSumaBITP());
            poliza.setSumaSEVI(registroFuente.getSumaSEVI());
            poliza.setSumaGastosFunerarios(registroFuente.getSumaGastosFunerarios());
            poliza.setSumaCPF(registroFuente.getSumaCPF());
            PaqueteVidaDxN paquete = polizaDao.obtenerPaqueteSeguroPorNombre(registroFuente.getNombrePaquete());
            if(paquete != null){
            	poliza.setTipoSeguro(String.valueOf(paquete.getIdPaqueteVidaDxN()));
            	poliza.setDescripcionPaqueteVidadxn(paquete.getNombrePaquete());
            }
            
            poliza.setPlazoSeguro(registroFuente.getPlazoSeguro());
            poliza.setFolioSolicitud(registroFuente.getFolioSolicitud());
            Calendar calFechaFin = Calendar.getInstance();
            calFechaFin.setTime(poliza.getFechaInicioVigencia());
            calFechaFin.add(Calendar.YEAR, poliza.getPlazoSeguro());
            poliza.setFechaFinVigencia(calFechaFin.getTime());
            poliza.setFechaExpedicion(registroFuente.getResumenCargaArchivoPolizas().getFechaCarga());

            Asegurado asegurado = new Asegurado();
            asegurado.setApPaternoAsegurado(registroFuente.getApPaternoAsegurado()!=null?
            		registroFuente.getApPaternoAsegurado().trim():StringUtils.EMPTY);
            asegurado.setApMaternoAsegurado(registroFuente.getApMaternoAsegurado()!=null?
            		registroFuente.getApMaternoAsegurado().trim():StringUtils.EMPTY);
            asegurado.setNombre1Asegurado(registroFuente.getNombre1Asegurado()!=null?
            		registroFuente.getNombre1Asegurado().trim():StringUtils.EMPTY);
            asegurado.setNombre2Asegurado(registroFuente.getNombre2Asegurado()!=null?
            		registroFuente.getNombre2Asegurado().trim():StringUtils.EMPTY);
            asegurado.setRFCasegurado(registroFuente.getRFCasegurado());
            asegurado.setNumNominaAsegurado(registroFuente.getNumNominaAsegurado());
            asegurado.setFechaNacimientoAsegurado(registroFuente.getFechaNacimientoAsegurado());
            asegurado.setSexoAseguradoMasculino(FormatUtil.esSexoMasculino(registroFuente.getCveSexoAsegurado()));
            asegurado.setEsFumadorAsegurado(FormatUtil.tranformarBoolean(registroFuente.getEsFumadorAsegurado()));
            asegurado.setEstadoCivilAsegurado(FormatUtil.transformarEstadoCivil(registroFuente.getCveEstadoCivilAsegurado()));
            asegurado.setCalle(registroFuente.getCalle());
            asegurado.setNumExtInt(registroFuente.getNumExterior());
            asegurado.setEdificio(registroFuente.getNumInterior());
            asegurado.setCodPostal(NumberUtils.toInt(registroFuente.getCodPostal(),0));
            asegurado.setColonia(registroFuente.getColonia());
            asegurado.setEntidadFederativa(registroFuente.getEntidadFederativa());
            asegurado.setDelegacionMpio(registroFuente.getDelegacionMpio());
            asegurado.setNumConsignatario(NumberUtils.toInt(registroFuente.getNumConsignatario()));
            asegurado.setNumPoliza(NumberUtils.toInt(registroFuente.getNumPoliza()));
            asegurado.setIngresoMensualAsegurado("0");
            asegurado.setCiudadPoblacion(registroFuente.getDelegacionMpio());
            poliza.setAsegurado(asegurado);
            poliza.setIdEstatusPagosPoliza(1);
            poliza.setIdEstatusPolizaSeguimiento(1);





       }
       return poliza;
    }

    /**
     * @return the polizaDao
     */
    public IPolizaDao getPolizaDao() {
        return polizaDao;
    }

    /**
     * @param polizaDao the polizaDao to set
     */
    public void setPolizaDao(IPolizaDao polizaDao) {
        this.polizaDao = polizaDao;
    }

    /**
     * @return the aseguradoDao
     */
    public IAseguradoDao getAseguradoDao() {
        return aseguradoDao;
    }

    /**
     * @param aseguradoDao the aseguradoDao to set
     */
    public void setAseguradoDao(IAseguradoDao aseguradoDao) {
        this.aseguradoDao = aseguradoDao;
    }

    @Override
    public RegistroArchivoPolizas consultarRegistroArchivoPolizaPorId(Integer idArchivoPoliza) {
        return registroArchivoPolizasDao.consultarPorId(idArchivoPoliza.longValue());
    }
	/**
	 * Método de acceso al campo seguridadUtil.
	 * @return El valor del campo seguridadUtil
	 */
	public SeguridadUtil getSeguridadUtil() {
		return seguridadUtil;
	}
	/**
	 * Asigna el valor al campo seguridadUtil.
	 * @param seguridadUtil el valor seguridadUtil a asignar
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}
	@Override
	public void actualizarEstatusRegistro(Long registroId, Integer estatus) {
		registroArchivoPolizasDao.actualizarEstatusRegistro(registroId, estatus);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness#insertarResumenCargaArchivoPolizas(mx.com.seguros.model.ResumenCargaArchivoPolizas)
	 */
	@Override
	public void insertarResumenCargaArchivoPolizas(
			ResumenCargaArchivoPolizas resumenCarga) {
		registroArchivoPolizasDao.insertarResumenCargaArchivoPolizas(resumenCarga);		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness#consultarArchivosCargados()
	 */
	@Override
	public List<ResumenCargaArchivoPolizas> consultarArchivosCargados() {
		return registroArchivoPolizasDao.consultarArchivosCargados();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness#consultarRegistrosArchivoPolizaPorArchivoCargado(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<RegistroArchivoPolizas> consultarRegistrosArchivoPolizaPorArchivoCargado(
			Integer IdResumenCargaArchivoPolizas, Integer idEstadoRegistroPoliza) {
		return registroArchivoPolizasDao.consultarRegistrosArchivoPolizaPorArchivoCargado(IdResumenCargaArchivoPolizas, idEstadoRegistroPoliza);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness#procerArchivoInbursa(java.io.InputStream, java.lang.String, java.lang.String)
	 */
	@Override
	public ResumenCargaArchivoPolizas procesarArchivoInbursa(InputStream streamArchivo,
			String nombreArchivo, String usuarioCarga) throws Exception {
		List<RegistroArchivoPolizas> registros = new ArrayList<RegistroArchivoPolizas>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(streamArchivo));
		String linea = reader.readLine();
		RegistroArchivoPolizas registroActual = null;
		while(linea != null){
			registroActual = llenarRegistroArchivoPolizas(linea);
			if(registroActual != null){
				registros.add(registroActual);
			}
			
			linea = reader.readLine();
		}
		//Crear resumen
		ResumenCargaArchivoPolizas resumen = new ResumenCargaArchivoPolizas();
		resumen.setFechaCarga(new Date());
		resumen.setNombreArchivo(nombreArchivo);
		resumen.setRegistrosValidos(registros.size());
		resumen.setTotalRegistros(registros.size());
		resumen.setUsuario(usuarioCarga);
		
		insertarResumenCargaArchivoPolizas(resumen);
		for(RegistroArchivoPolizas registro:registros){
			registro.setIdResumenCargaArchivoPolizas(resumen.getIdResumenCargaArchivoPolizas());
			registroArchivoPolizasDao.insertarRegistroArchivoPolizas(registro);
		}
		return resumen;
	}
	
	/**
	 * Popula las propiedades de un registro de archivo de pólizas para ser insertado en BD en base
	 * a la línea leída del archivo de inbursa
	 * @param linea Línea leida del archivo inbrsa
	 * @return Registro creado
	 */
	private RegistroArchivoPolizas llenarRegistroArchivoPolizas(String linea) {
		String datosSeparados[] = linea.split("\\|");
		RegistroArchivoPolizas registro = new RegistroArchivoPolizas();
		registro.setIdEstadoRegistroPoliza(EstadoRegistroPoliza.PENDIENTE);
		registro.setNombreGrupoAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.GRUPO_ASEGURADO));
		
		if(registro.getNombreGrupoAsegurado().indexOf(BANDERA_FIN) >= 0){
			//ultimo registro no se carga
			return null;
		}
		
		registro.setNombre1Asegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NOMBRE_ASEGURADO));
		
		registro.setApPaternoAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.AP_PATERNO_ASEGURADO));
		
		registro.setApMaternoAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.AP_MATERNO_ASEGURADO));
		
		registro.setRFCasegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.RFC_ASEGURADO));
		
		registro.setNumNominaAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NUM_NOMINA_ASEGURADO));
		
		registro.setFechaNacimientoAsegurado(obtenerFecha(datosSeparados,DistribucionCamposArchivoPolizasInbursa.FECHA_NACIMIENTO,ConstantesGenerales.FORMATO_FECHA_ARCHIVO));
		
		registro.setCveSexoAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SEXO_ASEGURADO));
		
		registro.setEsFumadorAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.ES_FUMADOR_ASEGURADO));
		
		//registro.setCveEstadoCivilAsegurado(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.ESTADO_CIVIL_ASEGURADO));
		
		registro.setCalle(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.CALLE));
		
		registro.setNumExterior(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NUM_EXTERIOR));
		
		registro.setNumInterior(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NUM_INTERIOR));
		
		registro.setCodPostal(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.COD_POSTAL));
		
		registro.setColonia(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.COLONIA));
		
		registro.setEntidadFederativa(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.ENTIDAD_FEDERATIVA));
		
		registro.setDelegacionMpio(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.DELEGACION_MPIO));
		
		registro.setApPaternoContratante(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.AP_PATERNO_CONTRATANTE));
		
		registro.setApMaternoContratante(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.AP_MATERNO_CONTRATANTE));
		
		registro.setNombre1Contratante(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NOMBRE_1_CONTRATANTE));
		
		registro.setNombre2Contratante(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NOMBRE_2_CONTRATANTE));
		
		registro.setNumConsignatario(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.EMISOR));
		
		registro.setNumPoliza(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NUM_POLIZA));
		
		registro.setAgrupacion(obtenerInteger(datosSeparados,DistribucionCamposArchivoPolizasInbursa.AGRUPACION));
		
		registro.setAgrupacionCIS(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.AGRUPACION_CIS));
		
		registro.setFechaInicioVigencia(obtenerFecha(datosSeparados,DistribucionCamposArchivoPolizasInbursa.FECHA_INCIO_VIGENCIA,"yyyyMMdd"));
		
		registro.setFechaSolicitud(obtenerFecha(datosSeparados,DistribucionCamposArchivoPolizasInbursa.FECHA_SOLICITUD,"dd/MM/yyyy hh:mm:ss"));
		
		registro.setSumaAseguradaIndividual(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_ASEGURADA_IND));
		
		registro.setSumaBAF(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_BAF));
		
		registro.setSumaDIPM(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_DIPM));
		
		registro.setSumaDIPMC(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_DIPMC));
		
		registro.setSumaBITP(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_BITP));
		
		registro.setSumaSEVI(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_SEVI));
		
		registro.setSumaGastosFunerarios(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_GASTOS_FUNERARIOS));
		
		registro.setSumaCPF(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.SUMA_CPF));
		
		registro.setNombrePaquete(obtenerCadena(datosSeparados,DistribucionCamposArchivoPolizasInbursa.NOMBRE_PAQUETE));
		
		registro.setPlazoSeguro(obtenerInteger(datosSeparados,DistribucionCamposArchivoPolizasInbursa.PLAZO_SEGURO));
		
		
		
		registro.setImporteTarifa(obtenerDouble(datosSeparados,DistribucionCamposArchivoPolizasInbursa.IMPORTE_TARIFA));
		
		registro.setCvePromotor(obtenerInteger(datosSeparados,DistribucionCamposArchivoPolizasInbursa.CVE_PROMOTOR));
		
		registro.setFolioSolicitud(obtenerInteger(datosSeparados,DistribucionCamposArchivoPolizasInbursa.FOLIO_SOLICITUD));
		
		return registro;
		
		
	}
	/**
	 * Obtiene de forma segura un dato entero de los datos leídos del archivo de pólizas
	 * @param datosSeparados Conjunto de datos
	 * @param posicionDato Posicion del dato deseado
	 * @return Integer con el dato, null si no se puede realizar la conversión
	 */
	private Integer obtenerInteger(String[] datosSeparados, int posicionDato) {
		String datoCadena = obtenerCadena(datosSeparados, posicionDato);
		Integer dato = null;
		if(datoCadena != null){
			dato = FormatUtil.parseIntNull(datoCadena);
		}
		return dato;
	}
	/**
	 * Obtiene un número decimal de forma segura de los datos leídos del archivo de pólizas.
	 * El número obtenido lo redondea hacia abajo
	 * @param datosSeparados Conjunto de datos 
	 * @param posicionDato Posición del dato deseado
	 * @return Número obtenido, null en caso de no lograr convertirlo
	 */
	private Double obtenerDouble(String[] datosSeparados, int posicionDato) {
		Double numero = null;
		String datoCadena = obtenerCadena(datosSeparados, posicionDato);
		try{
			numero = Double.parseDouble(datoCadena);
			numero = Math.floor(numero);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return numero;
	}
	/**
	 * Obtiene una fecha de forma segura de los datos leídos del archivo de pólizas,
	 * intenta formatear la fecha con el patrón enviado como parámetro.
	 * @param datosSeparados Conjunto de datos
	 * @param posicionDato Posición del dato deseado
	 * @param patronFecha Formato de fecha deseado
	 * @return Fecha obtenida, null en caso de no lograr obtenerla
	 */
	private Date obtenerFecha(String[] datosSeparados, int posicionDato,
			String patronFecha) {
		Date datoDate = null;
		String datoCadena = obtenerCadena(datosSeparados, posicionDato);
		if(datoCadena != null){
			datoDate = FormatUtil.stringToDate(datoCadena,patronFecha);
		}
		return datoDate;
	}
	/**
	 * Obtiene una cadena de forma segura del índice de la posicion del dato indicado en el parámetro, realiza
	 * validación por nulo, tamaño del arreglo y recorta los espacios sobrantes a la izquierda y derecha.
	 * @param datosSeparados Arreglo con los datos separados
	 * @param posicionDato Posición del dato buscado en el arreglo
	 * @return Cadena obenida de los datos, null en caso de no poder obtener la cadena
	 */
	private String obtenerCadena(String[] datosSeparados, int posicionDato) {
		String dato = null;
		if(datosSeparados != null && posicionDato<datosSeparados.length){
			dato = datosSeparados[posicionDato];
			if(dato != null){
				dato = dato.trim();
			}
				
		}
		
		return dato;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness#consultarArchivoPolizasPorId(java.lang.Integer)
	 */
	@Override
	public ResumenCargaArchivoPolizas consultarArchivoPolizasPorId(Integer id) {
		return registroArchivoPolizasDao.consultarArchivoPolizasPorId(id);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness#eliminarRegistroArchivoPolizas(java.lang.Integer)
	 */
	@Override
	public void eliminarRegistroArchivoPolizas(Integer idRegistro) {
		registroArchivoPolizasDao.eliminarRegistroArchivoPolizas(idRegistro);
		
	}


}
