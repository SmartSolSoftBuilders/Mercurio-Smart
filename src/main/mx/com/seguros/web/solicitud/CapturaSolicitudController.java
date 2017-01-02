package mx.com.seguros.web.solicitud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.EstadoRegistroPoliza;
import mx.com.seguros.model.EstatusSolicitud;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.web.poliza.RegistroPolizaCommand;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;

public class CapturaSolicitudController extends AbstractWizardFormController {
    
    private ISolicitudBusiness solicitudBusiness;

    private IArchivoPolizasBusiness archivoPolizaBusiness;

    private IPolizaBusiness polizaBusiness;
    
    private SeguridadUtil seguridadUtil;
    
    public CapturaSolicitudController() {
        this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(
                new String[]{
            "registroSolicitud/w01_IdentificarSolicitudSeguroVida",
            "registroSolicitud/w02_RegistroContratante",
            "registroSolicitud/w03_IdentificarGrupoAsegurado",
            "registroSolicitud/w04_RegistroSolicitante",
            "registroSolicitud/w05_RegistroDomicilioSolicitante",
            "registroSolicitud/w06_RegistroBeneficiarios",
            "registroSolicitud/w07_RegistroPolizasSeguroEmitidas"

        }
        );
        setCommandClass(DatosSolicitudCommand.class);
        setCommandName("datosSolicitud");
        setValidator(new DatosSolicitudValidator());
        setSessionForm(true);
        setValidateOnBinding(false);
    }
    
    @Override
    protected Map referenceData(HttpServletRequest request, int page) throws Exception {
        Map data = new HashMap();
        // Especifica los valores para el combo de estado civil del solicitante.
        ArrayList<String> edoCivilList = new ArrayList<String>(){
            {
                add("Soltero");
                add("Casado");
                add("Divorciado");
                add("Viudo");
                add("Separado");
                add("Unión Libre");
            }
        };
        List<EstatusSolicitud> estadoSolicitud = solicitudBusiness.consultarEstatusSolicitud();
        
        data.put("opcionesComboEstadoCivil", edoCivilList);
        data.put("estatusSolicitud", estadoSolicitud);
        data.put("rolOperaciones", seguridadUtil.isRolOperaciones());
        
        

        return data;
    }
    
    private Double obtenerSumaDeBeneficio(
			List<BeneficioAdicionalPoliza> beneficiosPoliza,
			Integer idBeneficioAdicional) {
		for(BeneficioAdicionalPoliza beneficio:beneficiosPoliza){
			if(beneficio.getIdBeneficioAdicional().intValue() == idBeneficioAdicional.intValue()){
				return beneficio.getSumaBeneficio();
			}
		}
		return 0.0;
	}
    
    private Double obtenerMontoCobertura(
			List<BeneficioAdicionalPoliza> beneficiosPoliza,
			Integer idBeneficioAdicional) {
		for(BeneficioAdicionalPoliza beneficio:beneficiosPoliza){
			if(beneficio.getIdBeneficioAdicional().intValue() == idBeneficioAdicional.intValue()){
				return beneficio.getMontoCobertura();
			}
		}
		return 0.0;
	}
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        DatosSolicitudCommand cmd = new DatosSolicitudCommand();
        

        Integer folioSolicitud = NumberUtils.toInt(request.getParameter("folioSolicitud"),-1);
        String formatoSolicitud = request.getParameter("formatoSolicitud");
        Integer idRegistro = NumberUtils.toInt(request.getParameter("idRegistro"),0);
        Integer numPoliza =  NumberUtils.toInt(request.getParameter("numPoliza"),0);
        Integer numConsignatario = NumberUtils.toInt(request.getParameter("numConsignatario"),0);
        Solicitud sol = null;
        
        if(folioSolicitud != null && folioSolicitud >= 0){
        	//Smart Solutions Noviembre 2011 Mantenimiento para agregar el formato de solicitud a la llave primaria de Solicitud
        	sol = solicitudBusiness.obtenerDetalleSolicitudPorFolio(folioSolicitud,formatoSolicitud);
            if(idRegistro!=null && idRegistro >0){
            	//Si viene de archivo cargado entonces se sube la información al comando para ser editada
	    	
	            if(idRegistro != null && idRegistro >0){
	               cmd.setPolizaIndividual(archivoPolizaBusiness.copiarRegistroArchivoPolizaASistema(idRegistro.longValue()));
	               cmd.setSolicitud(cmd.getPolizaIndividual().getSolicitud());
	               cmd.setRegistroArchivoPolizaOrigen(idRegistro);
	               //Carga de los beneficios adicionale 	
	               List <BeneficioAdicional> beneficios = polizaBusiness.consultarCatalogoBeneficiosAdicionales();
	               System.out.println("beneficios desde el controller");
	               System.out.println(beneficios.size());
	               List <BeneficioAdicionalPoliza> beneficiosPoliza = polizaBusiness.consultarBeneficiosAdicionalesDePoliza(cmd.getPolizaIndividual().getNumPoliza(), cmd.getPolizaIndividual().getNumConsignatario());
	               cmd.setBeneficiosPoliza(new BeneficioAdicionalPoliza[beneficios.size()]);
	               System.out.println(beneficiosPoliza.size());

	               int i=0;
	               if (beneficiosPoliza.size()>0){
		               for(BeneficioAdicionalPoliza beneficio:beneficiosPoliza){
		            	   cmd.getBeneficiosPoliza()[i] = new BeneficioAdicionalPoliza();
		            	   cmd.getBeneficiosPoliza()[i].setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
		            	   cmd.getBeneficiosPoliza()[i].setNumPoliza(beneficio.getNumPoliza());
		            	   cmd.getBeneficiosPoliza()[i].setNumConsignatario(beneficio.getNumConsignatario());
		            	   cmd.getBeneficiosPoliza()[i].setSumaBeneficio(obtenerSumaDeBeneficio(beneficiosPoliza,beneficio.getIdBeneficioAdicional()));
		            	   cmd.getBeneficiosPoliza()[i].setMontoCobertura(obtenerMontoCobertura(beneficiosPoliza,beneficio.getIdBeneficioAdicional()));
		            	   cmd.getBeneficiosPoliza()[i].setDescripcionBeneficio(beneficio.getDescripcionBeneficio());
		               i++;
		               }
	               }
	               else{
	            	   for(BeneficioAdicional beneficio:beneficios){
		            	   cmd.getBeneficiosPoliza()[i] = new BeneficioAdicionalPoliza();
		            	   cmd.getBeneficiosPoliza()[i].setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
		            	   cmd.getBeneficiosPoliza()[i].setNumPoliza(numPoliza);
		            	   cmd.getBeneficiosPoliza()[i].setNumConsignatario(numConsignatario);
		            	   cmd.getBeneficiosPoliza()[i].setSumaBeneficio(obtenerSumaDeBeneficio(beneficiosPoliza,beneficio.getIdBeneficioAdicional()));
		            	   cmd.getBeneficiosPoliza()[i].setMontoCobertura(obtenerMontoCobertura(beneficiosPoliza,beneficio.getIdBeneficioAdicional()));
		            	   cmd.getBeneficiosPoliza()[i].setDescripcionBeneficio(beneficio.getDescripcionBeneficioAdicional());
		            	   i++;
		               }
	               }
	            	   
	               
	               cmd.setModificacion(false);
	               
	           }
              
            	
            }else{
            	//Cargar los datos de BD para edición
            	if(sol != null && 
                		(sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA
                				|| 
                		 sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_REQUERIMIENTO_MEDICO)){
                	cmd.setModificacion(true);
                    cmd.setSolicitud(sol);
                    if(sol.getAgente() == null){
                        sol.setAgente(new Agente());
                    }
                    if(sol.getEmpresa() == null){
                        sol.setEmpresa(new Empresa());
                    }
                    if(sol.getSolicitante()!= null && sol.getSolicitante().getEstadoCivilSolicitante()!=null){
                        sol.getSolicitante().setEstadoCivilSolicitante(FormatUtil.
                                transformarEstadoCivilDeDescripcion(sol.getSolicitante().getEstadoCivilSolicitante())+"");
                    }
                    if(sol.getBeneficiario() == null || (sol.getBeneficiario().length>0 && sol.getBeneficiario()[0] == null) ){
                        Beneficiario[] beneficiario = new Beneficiario[Solicitud.NUM_MAX_BENEFICIARIOS];

                         for(int i=0; i<Solicitud.NUM_MAX_BENEFICIARIOS; i++)
                             beneficiario[i] = new Beneficiario();
                         sol.setBeneficiario(beneficiario);
                    }
                    PolizaIndividual pol = polizaBusiness.obtenerDetallePolizaPorNumero(numPoliza, numConsignatario);
                    if(pol != null){
                        cmd.setPolizaIndividual(pol);
                    }
                    //Si es del rol operaciones entonces el estatus de la solicitud debe ser Poliza Emitidas
                    if(seguridadUtil.isRolOperaciones()){
                    	sol.setIdEstatusSolicitud(ConstantesGenerales.ESTATUS_SOLICITUD_POLIZA_EMITIDA);
                    }

                }
            }

        }

        return cmd;

    }
    
    /**
     * protected Map referenceData(HttpServletRequest request) throws Exception {
     * Map<String> comboEstadoCivil = new HashMap<String>();
     * comboEstadoCivil.put("Soltero");
     * comboEstadoCivil.put("Casado");
     * comboEstadoCivil.put("Divorciado");
     * comboEstadoCivil.put("Viudo");
     * comboEstadoCivil.put("Separado");
     * comboEstadoCivil.put("Union Libre");
     * Map<String, Map<String> referenceData = new HashMap<String, Map<String>();
     * referenceData.put("comboEstadoCivil", comboEstadoCivil);
     * return referenceData;
     * }//* /
     *
     * /*protected Map referenceData(HttpServletRequest request) throws Exception {
     * Map data = new HashMap();
     * ArrayList<String> list = new ArrayList<String>();
     * list.add(1,"Soltero");
     * list.add(2,"Casado");
     * list.add(3,"Divorciado");
     * list.add(4,"Viudo");
     * list.add(5,"Separado");
     * list.add(6,"Union Libre");
     * data.put("optionsComboEstadoCivil",list);
     * return data;
     * }*/
    
    public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
        this.solicitudBusiness = solicitudBusiness;
    }
    
    @Override
    protected void validatePage(Object command, Errors errors, int page) {
        DatosSolicitudCommand datosSolicitud = (DatosSolicitudCommand) command;
        DatosSolicitudValidator validator = (DatosSolicitudValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosSolicitud, errors);
                break;
            case 1:
                validator.validatePage1(datosSolicitud, errors);
                break;
            case 2:
                validator.validatePage2(datosSolicitud, errors);
                break;
            case 3:
                validator.validatePage3(datosSolicitud, errors);
                break;
            case 4:
                validator.validatePage4(datosSolicitud, errors);
                break;
            case 5:
                validator.validatePage5(datosSolicitud, errors);
                break;
             case 6:
            	if(datosSolicitud.getRegistroArchivoPolizaOrigen() != null && datosSolicitud.getRegistroArchivoPolizaOrigen() > 0)
            		validator.validatePage6(datosSolicitud, errors);
                break;
            default:
                System.out.println("Problemas en CapturaSolicitudController.validatePage");
        }
    }
    
    @Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(new Date());
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
    
    @Override
    protected ModelAndView processFinish(
            HttpServletRequest request, HttpServletResponse response,
            Object command, BindException bindException) throws Exception {
        DatosSolicitudCommand datosSolicitud = (DatosSolicitudCommand) command;
        if(datosSolicitud.isModificacion()){
        	 datosSolicitud.getSolicitud().setClaveUsuarioModificacion(seguridadUtil.getUsuario().getUsername());
        	 datosSolicitud.getSolicitud().setFechaModificacion(new Date());
             solicitudBusiness.actualizarSolicitud(datosSolicitud);
             polizaBusiness.actualizarPolizaIndividual(datosSolicitud.getPolizaIndividual());
             RegistroPolizaCommand datosPoliza = new RegistroPolizaCommand();
             datosPoliza.setPolizaIndividual(datosSolicitud.getPolizaIndividual());
             datosPoliza.getPolizaIndividual().setSolicitud(datosSolicitud.getSolicitud());
             try{
            	 polizaBusiness.generarReportes(datosPoliza);
             }catch(Exception e){
            	 e.printStackTrace();
            	 logger.error(e);
             }
             try{
            	 request.setAttribute("ReportesPDF", polizaBusiness.obtenerReportesGenerados(datosPoliza));
            	             	 
             }catch(Exception e){
            	 e.printStackTrace();
            	 logger.error(e);
             }
             
             
        }else{
        	datosSolicitud.getSolicitud().setClaveUsuarioRegistro(seguridadUtil.getUsuario().getUsername());
       	 	datosSolicitud.getSolicitud().setFechaRegistro(new Date());
            solicitudBusiness.registrarSolicitud(datosSolicitud);
            if(datosSolicitud.getRegistroArchivoPolizaOrigen()!=null && datosSolicitud.getRegistroArchivoPolizaOrigen()>0){
            	//Se está insertando desde archivo
            	RegistroPolizaCommand datosPoliza = new RegistroPolizaCommand();
                datosPoliza.setPolizaIndividual(datosSolicitud.getPolizaIndividual());
                datosPoliza.getPolizaIndividual().setSolicitud(datosSolicitud.getSolicitud());
                datosPoliza.setBeneficiosPoliza(datosSolicitud.getBeneficiosPoliza());
                polizaBusiness.registrarPoliza(datosPoliza);
                polizaBusiness.registrarAsegurado(datosPoliza);
                archivoPolizaBusiness.actualizarEstatusRegistro(datosSolicitud.getRegistroArchivoPolizaOrigen().longValue(), 
            			EstadoRegistroPoliza.PROCESADO);
            	try{
               	 	polizaBusiness.generarReportes(datosPoliza);
                }catch(Exception e){
	               	 e.printStackTrace();
	               	 logger.error(e);
                }
                try{
               	 	request.setAttribute("ReportesPDF", polizaBusiness.obtenerReportesGenerados(datosPoliza));
                }catch(Exception e){
	               	 e.printStackTrace();
	               	 logger.error(e);
                }
            }
        }
       
        request.getSession().setAttribute("message", "Registro de solicitud exitoso.");
        return new ModelAndView("registroSolicitud/registroSolicitudExitoso",
                "datosSolicitud",
                datosSolicitud);
    }
    
    @Override
    protected ModelAndView processCancel(
            HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("capturaSolicitudController"));
    }
    
    public ModelAndView reporteCertificadoIndividual(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map modelo = new HashMap();
//        String reportResourcePath =  getServletContext().getRealPath("/");
        
        //new org.springframework.web.servlet.view.jasperreports.
        //new JRDataSource();
        //Collection datosReporte = getDatosReporte();
        //Collection otherData = getOtherData();
        //->model.put("jasperData", datosReporte);
        //model.put("otherData", otherData);
        //model.put("dataSource", getUserManager().getUsers(new User()));
        return new ModelAndView("reporteCertificadoIndividual", modelo);
    }

    /**
     * @return the archivoPolizaBusiness
     */
    public IArchivoPolizasBusiness getArchivoPolizaBusiness() {
        return archivoPolizaBusiness;
    }

    /**
     * @param archivoPolizaBusiness the archivoPolizaBusiness to set
     */
    public void setArchivoPolizaBusiness(IArchivoPolizasBusiness archivoPolizaBusiness) {
        this.archivoPolizaBusiness = archivoPolizaBusiness;
    }

    /**
     * @return the polizaBusiness
     */
    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    /**
     * @param polizaBusiness the polizaBusiness to set
     */
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
    /**
    protected void onBindAndValidate(
            HttpServletRequest request,
            Object command,
            BindException errors,
            int page) throws Exception {
    
    }*/

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
    
}