package mx.com.seguros.business.solicitud;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import mx.com.seguros.data.dao.IAgenteDao;
import mx.com.seguros.data.dao.IBeneficiarioDao;
import mx.com.seguros.data.dao.ICertificadoIndividualDao;
import mx.com.seguros.data.dao.IContratanteDao;
import mx.com.seguros.data.dao.IEmpresaDao;
import mx.com.seguros.data.dao.ISolicitanteDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.CertificadoIndividual;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.EstatusSolicitud;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.Promotor;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.solicitud.DatosSolicitudCommand;
/**
 *
 * @author QTX
 */
public class SolicitudBusiness implements ISolicitudBusiness {
    
    private IBeneficiarioDao beneficiarioDao;
    private ICertificadoIndividualDao certificadoIndividualDao;
    private IContratanteDao contratanteDao;
    private IEmpresaDao empresaDao;
    private ISolicitanteDao solicitanteDao;
    private ISolicitudDao solicitudDao;
    private IAgenteDao agenteDao;
    private SeguridadUtil seguridadUtil;
    /** Creates a new instance of SolicitudBusiness */
    
    
    public SolicitudBusiness() {
    }
    
    @Override
    public List obtenSolicitudPorEstatusYnumNominaContratante(int estatus,String numNominaContratante){
        Solicitud solicitud=new Solicitud();
        solicitud.setIdEstatusSolicitud(estatus);
        solicitud.setNumNominaContratante(numNominaContratante);
        return solicitudDao.obtenSolicitudPorEstatusYnumNominaContratante(solicitud);
    }
    
    
    
    @Override
    public void registrarSolicitud(DatosSolicitudCommand datosSolicitud) {
        boolean tipoBenef;
        Solicitud solicitud = datosSolicitud.getSolicitud();
        Contratante contratante = solicitud.getContratante();
        Solicitante solicitante = solicitud.getSolicitante();
        Beneficiario[] beneficiario = solicitud.getBeneficiario();
        int folioSolicitud = solicitud.getFolioSolicitud();
      //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        String formatoSolicitud = solicitud.getFormatoSolicitud();
        String numNominaContratante = solicitud.getContratante().getNumNominaContratante();
        String RFCsolicitante=solicitud.getSolicitante().getRFCsolicitante();
        // contratante.setNumNominaContratante(numNominaContratante);
        solicitud.setNumNominaContratante(numNominaContratante);
        solicitud.setRFCsolicitante(RFCsolicitante);
        solicitud.setFechaCaptura(new Date());
        solicitud.setRFCsolicitante(solicitante.getRFCsolicitante());
        //  solicitud.setIdEstatusSolicitud(solicitud.getIdEstatusSolicitud());
        solicitud.setCveEmpresa(solicitud.getEmpresa().getCveEmpresa());
        solicitud.setIdEstatusSolicitud(1);
        // Paso del código numérico del estado civil a una cadena descriptiva:
        int cveEstadoCivil = Integer.parseInt(solicitante.getEstadoCivilSolicitante());
        solicitante.setEstadoCivilSolicitante(estadoCivil(cveEstadoCivil));
        if(StringUtils.isBlank(solicitante.getIngresoMensualSolicitante())){
        	solicitante.setIngresoMensualSolicitante(String.valueOf(0));
        }
        
        
        if(contratanteDao.recuperarContratantePorNumNomina(numNominaContratante) == null){
            contratanteDao.insertarContratante(contratante);
        }else{
        	contratanteDao.actualizarContratante(contratante);
        }
        
        Solicitante solicitanteExistente = new Solicitante();
        solicitanteExistente=solicitanteDao.recuperarSolicitantePorRFC(RFCsolicitante);
        if(solicitanteExistente != null){
            solicitanteDao.actualizarSolicitante(solicitante);
        }else{
            solicitanteDao.insertarSolicitanteDao(solicitante);
        }
        
        solicitudDao.insertarSolicitud(solicitud);
        
        
        // Sustituir por cuenta de numero de beneficiarios registrados a la 2a cond.
        for(int i = 0; i < beneficiario.length &&
                beneficiario[i].getFechaNacimientoBeneficiario() != null; i++){
            tipoBenef = beneficiario[i].getTipoBeneficiario();
            System.out.println("Tipo benef_" + i + ": " + tipoBenef);
            if(tipoBenef)
                beneficiario[i].getTipoBeneficiario();//R
            else
                beneficiario[i].getTipoBeneficiario();//I
            beneficiario[i].setFolioSolicitud(folioSolicitud);
            beneficiario[i].setFormatoSolicitud(formatoSolicitud);
            beneficiarioDao.insertarBeneficiario(beneficiario[i]);
        }
      //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        CertificadoIndividual certificadoIndividual =
        generarCertificado(folioSolicitud,formatoSolicitud);
        solicitud.setCertificadoindividual(certificadoIndividual);
    }
    
    public boolean validarVigenciaSolicitud(Date fechaSolicitud) {
        return true;
    }
    
    public void setBeneficiarioDao(IBeneficiarioDao beneficiarioDao) {
        this.beneficiarioDao = beneficiarioDao;
    }
    
    public void setCertificadoIndividualDao(ICertificadoIndividualDao certificadoIndividualDao) {
        this.certificadoIndividualDao = certificadoIndividualDao;
    }
    
    public void setContratanteDao(IContratanteDao contratanteDao) {
        this.contratanteDao = contratanteDao;
    }
    
    public void setEmpresaDao(IEmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }
    
    public void setSolicitanteDao(ISolicitanteDao solicitanteDao) {
        this.solicitanteDao = solicitanteDao;
    }
    
    public void setSolicitudDao(ISolicitudDao solicitudDao) {
        this.solicitudDao = solicitudDao;
    }
    
    /** A partir del folio de la solicitud, genera al certificado individual
     */
  //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
    private CertificadoIndividual generarCertificado(int folioSolicitud, String formatoSolicitud) {
        Integer nuevoCertificado= new Integer(1);
        
        CertificadoIndividual certificadoIndividual = new CertificadoIndividual();
        certificadoIndividual.setFechaExpedicion(new Date());
        certificadoIndividual.setFolioSolicitud(folioSolicitud);
        certificadoIndividual.setFormatoSolicitud(formatoSolicitud);
      //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        certificadoIndividual.setIdPlaza(certificadoIndividualDao.recuperarCvePlaza(folioSolicitud, formatoSolicitud));
        nuevoCertificado=certificadoIndividualDao.recuperarUltimoCertificadoPorPlaza(certificadoIndividual.getIdPlaza());
        System.out.println("valor de ultimoCertificado"+nuevoCertificado);
        certificadoIndividual.setNumCertificado(nuevoCertificado);
        certificadoIndividualDao.insertarCertificadoIndividual(certificadoIndividual);
        return certificadoIndividual;
    }//*/
    
    
//    /*
//      Genera y muestra el reporte de Certififcado Individual. El archivo se
//      guarda en formato PDF, y la visualización se realiza usando al visor
//      interno (JasperViewer).
//     */
//    public void generarReporteCertificadoIndividual(int folioSolicitud, int numPoliza, int numCertificado) {
//        //certificadoIndividual.setFechaExpedicion(new Date());
//        Connection con = null;
//        try {
////            JasperReport jasperReport =
////                    (JasperReport) JRLoader.loadObjectFromLocation(
////                    "C:/Documents and Settings/Pedro/Mis documentos/proyectos NetBeans/02oct2007/SegurosApp/web/WEB-INF/reportes/reporteCertificadoIndividual.jasper");
//            //String reporteResourcePath =  ApplicationContext getRealPath("/");
////            File reporte = new File(".");//En total: 8 niveles arriba y algunos mios hacia abajo
////            System.out.println("reportePath = " + reporte.getAbsolutePath());
////            System.out.println("padre: " + reporte.getParent());
////            System.out.println("abuelo: " + reporte.getParentFile().getParent());
////            System.out.println("bisabuelo: " + reporte.getParentFile().getParentFile().getParent());
////            System.out.println("tatarabuelo: " + reporte.getParentFile().getParentFile().getParentFile().getParent());
//            JasperReport jasperReport =
//                    (JasperReport) JRLoader.loadObjectFromLocation(
//                    "C:/Documents and Settings/Pedro/Mis documentos/proyectos NetBeans/02oct2007/SegurosApp/web/WEB-INF/reportes/reporteCertificadoIndividual.jasper");
//            Map<String, Object> parametros = new HashMap<String, Object>();
//            parametros.put("FolioSolicitudParam", folioSolicitud);
//            parametros.put("NumPolizaParam", numPoliza);
//            parametros.put("NumCertificadoParam", numCertificado);
//            con = getConnection();
//            //con = SoporteDatos.getConnection();
//            JasperPrint jasperPrint = JasperFillManager.fillReport(
//                    jasperReport, parametros, con);
//            JasperExportManager.exportReportToPdfFile(jasperPrint,
//                    "ReporteCertificadoIndividual_" + numCertificado + ".pdf");
//            JasperViewer.viewReport(jasperPrint);
//        } catch (JRException e) {
//            e.printStackTrace();
//        } finally {
//            if(con != null){
//                try {
//                    con.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//
//    } // generarReporteCertificadoIndividual() //*/
//
//    public Connection getConnection() {
//        Connection conexion = null;
//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            conexion = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/segurosinbursa", "root", "root");
//            return conexion;
//        } catch (SQLException sqle) {
//            if(conexion != null){
//                try {
//                    conexion.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            return null;
//        }
//    } // getConnection() //*/
//
    public static String estadoCivil(int cveEstadoCivil) {
        switch(cveEstadoCivil){
            case 1: return "Soltero";
            case 2: return "Casado";
            case 3: return "Divorciado";
            case 4: return "Viudo";
            case 5: return "Separado";
            case 6: return "Uni�n Libre";
            default: return "Soltero";
        }
    }
    
    /*HEFS*/
    
    @Override
    public TarifaAportMensual obtenTarifaMensualPorClaveTarifa(int cveTarifa){
        Solicitud solicitud=new Solicitud();
        solicitud.setCveTarifa(cveTarifa);
        return (TarifaAportMensual)solicitudDao.obtenTarifaMensualPorClaveTarifa(cveTarifa);
    }

    @Override
    public Solicitud obtenSolicitudPorFolioSolicitud(int folioSolicitud, String formatoSolicitud) {
    	//Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        return (Solicitud)solicitudDao.obtenSolicitudPorFolioSolicitud(folioSolicitud, formatoSolicitud);
    }

    @Override
    public Solicitud obtenerDetalleSolicitudPorFolio(int folioSolicitud, String formatoSolicitud) {
    	//Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        return solicitudDao.obtenerDetalleSolicitudPorFolio(folioSolicitud, formatoSolicitud);
    }

    @Override
    public void actualizarSolicitud(DatosSolicitudCommand datosSolicitud) {
        boolean tipoBenef;
        Solicitud solicitud = datosSolicitud.getSolicitud();
        Contratante contratante = solicitud.getContratante();
        Solicitante solicitante = solicitud.getSolicitante();
        Beneficiario[] beneficiario = solicitud.getBeneficiario();
        int folioSolicitud = solicitud.getFolioSolicitud();
      //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        String formatoSolicitud = solicitud.getFormatoSolicitud();
        String numNominaContratante = solicitud.getContratante().getNumNominaContratante();
        String RFCsolicitante=solicitud.getSolicitante().getRFCsolicitante();

        solicitud.setNumNominaContratante(numNominaContratante);
        solicitud.setRFCsolicitante(RFCsolicitante);
        solicitud.setFechaCaptura(new Date());
        solicitud.setRFCsolicitante(solicitante.getRFCsolicitante());

        solicitud.setCveEmpresa(solicitud.getEmpresa().getCveEmpresa());
        
        
        int cveEstadoCivil = Integer.parseInt(solicitante.getEstadoCivilSolicitante());
        solicitante.setEstadoCivilSolicitante(estadoCivil(cveEstadoCivil));


        if(contratanteDao.recuperarContratantePorNumNomina(numNominaContratante) == null){
            contratanteDao.insertarContratante(contratante);
        }else{
            contratanteDao.actualizarContratante(contratante);
        }

        Solicitante solicitanteExistente = new Solicitante();
        solicitanteExistente=solicitanteDao.recuperarSolicitantePorRFC(RFCsolicitante);
        if(solicitanteExistente != null){
            solicitanteDao.actualizarSolicitante(solicitante);
        }
        else{
            solicitanteDao.insertarSolicitanteDao(solicitante);
        }
        //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        if(solicitudDao.obtenSolicitudPorFolioSolicitud(solicitud.getFolioSolicitud(),solicitud.getFormatoSolicitud()) != null){
            
        	solicitudDao.actualizarSolicitud(solicitud);
        }else{
            solicitudDao.insertarSolicitud(solicitud);
        }
        


        // Sustituir por cuenta de numero de beneficiarios registrados a la 2a cond.
        for(int i = 0;beneficiario!=null &&  i < beneficiario.length &&
                beneficiario[i]!= null && beneficiario[i].getFechaNacimientoBeneficiario() != null; i++){
            tipoBenef = beneficiario[i].getTipoBeneficiario();
            System.out.println("Tipo benef_" + i + ": " + tipoBenef);
            if(tipoBenef)
                beneficiario[i].getTipoBeneficiario();//R
            else
                beneficiario[i].getTipoBeneficiario();//I
            beneficiario[i].setFolioSolicitud(folioSolicitud);
           
            beneficiarioDao.insertarBeneficiario(beneficiario[i]);
        }
      //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        CertificadoIndividual certificadoInd = consultarCertificadoPorFolio(folioSolicitud, formatoSolicitud);
        if(certificadoInd == null){
        	//Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
        	certificadoInd =
            generarCertificado(folioSolicitud,formatoSolicitud);
        	
        }
        datosSolicitud.getSolicitud().setCertificadoindividual(certificadoInd);
        
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#consultarCertificadoPorFolio(java.lang.Integer)
     */
    @Override
	public CertificadoIndividual consultarCertificadoPorFolio(
			Integer folioSolicitud, String formatoSolicitud) {
    	//Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
		return certificadoIndividualDao.consultarCertificadoPorFolio(folioSolicitud, formatoSolicitud);
	}
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#consultarEstatusSolicitud()
     */
	@Override
	public List<EstatusSolicitud> consultarEstatusSolicitud() {
		return solicitudDao.consultarEstatusSolicitud();
	}

	@Override
	public Agente obtenerAgentePorCveAgente(int cveAgente) {
		return agenteDao.obtenerAgentePorCveAgente(cveAgente);
	}

	/**
	 * Asigna el valor al campo agenteDao.
	 * @param agenteDao el valor agenteDao a asignar
	 */
	public void setAgenteDao(IAgenteDao agenteDao) {
		this.agenteDao = agenteDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#obtenerEmpleadoPorCveEmpleado(int)
	 */
	@Override
	public Empleado obtenerEmpleadoPorCveEmpleado(int cveEmpleado) {
		return agenteDao.obtenerEmpleadoPorClave(cveEmpleado);
	}

	/**
	 * Asigna el valor al campo seguridadUtil.
	 * @param seguridadUtil el valor seguridadUtil a asignar
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

	@Override
	public Beneficiario[] consultarBeneficiarios(Integer foliosSolicitud,
			String formatoSolicitud) {
		Beneficiario[] beneficiarios = new Beneficiario[Solicitud.NUM_MAX_BENEFICIARIOS];
		int iBenef = 0;
		for(Beneficiario benef: solicitudDao.consultarBeneficiarios(foliosSolicitud, formatoSolicitud)){
			beneficiarios[iBenef++] = benef;
		}
		for(;iBenef<beneficiarios.length;iBenef++){
			beneficiarios[iBenef] = new Beneficiario();
		}
		return beneficiarios;
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#buscarPromotor(java.lang.Integer)
	 */
	@Override
	public Promotor buscarPromotor(Integer cvePromotor) {
		return solicitudDao.buscarPromotor(cvePromotor);
				
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#insertarHistoricoTarifa(mx.com.seguros.model.HistoricoTarifa)
	 */
	@Override
	public void insertarHistoricoTarifa(HistoricoTarifa historico) {
		solicitudDao.insertarHistoricoTarifa(historico);		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#consultarHistoricoTarifaSolicitud(mx.com.seguros.model.Solicitud)
	 */
	@Override
	public List<HistoricoTarifa> consultarHistoricoTarifaSolicitud(
			Solicitud solicitud) {
		return solicitudDao.consultarHistoricoTarifaSolicitud(solicitud);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#consultarTarifaEnFecha(mx.com.seguros.model.Solicitud, java.util.Date)
	 */
	@Override
	public Double consultarTarifaEnFecha(Solicitud sol, Date fecha) {
		Double tarifaFinal = 0.0;
		HistoricoTarifa historico = solicitudDao.consultarHistoricoTarifaEnFecha(sol, fecha);
		if(historico == null){
			//retornar la tarifa de la solicitud
			tarifaFinal = sol.getTarifaTotal()!=null?sol.getTarifaTotal():sol.getTarifa().getImporteTarifa();
		}else{
			tarifaFinal = historico.getTarifaTotal() != null?historico.getTarifaTotal():historico.getTarifa().getImporteTarifa();
		}
		return tarifaFinal;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.solicitud.ISolicitudBusiness#consultarPlazas()
	 */
	@Override
	public List<Plaza> consultarPlazas() {
		return empresaDao.consultarPlazas();
	}
    
    
    
        
}
