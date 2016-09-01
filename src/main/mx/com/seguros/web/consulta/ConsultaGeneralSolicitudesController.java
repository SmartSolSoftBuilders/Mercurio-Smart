/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.web.consulta;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.consulta.GeneraArchivoConsultaGeneralExcel;
import mx.com.seguros.business.consulta.GeneraArchivoConsultaGeneralExcelImpl;
import mx.com.seguros.business.consulta.IConsultaGeneralSolicitudesBusiness;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller que atiende las solicitudes de consulta de solicitudes
 * @author Emigdio Hernández
 */
public class ConsultaGeneralSolicitudesController extends SimpleFormController{
    private Integer registrosPorPagina;

    private IConsultaGeneralSolicitudesBusiness consultaGeneralSolicitudesBusiness;
    private GeneraArchivoConsultaGeneralExcel generaArchivoConsultaGeneralExcel;

    private SeguridadUtil seguridadUtil;
    @Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        //verificación de los roles del usuario
        
        data.put("rolVentas",new Boolean(seguridadUtil.isRolVentas()));
        data.put("rolAdministrador",new Boolean(seguridadUtil.isRolAdministrador()));
        Usuario usuario = seguridadUtil.getUsuario();
        if(seguridadUtil.isRolVentas()){
        	data.put("cveAgente",seguridadUtil.getAgente().getCveAgente());
        }
        
        return data;
    }
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

    	CriteriosConsultaSolicitudesDTO  command = new CriteriosConsultaSolicitudesDTO();
        
    	
        if(seguridadUtil.isRolVentas()){
        	command.setCveAgente(seguridadUtil.getAgente().getCveAgente());
        }
        
        if(seguridadUtil.isRolOperacionesNoCentrales()){
        	command.setIdPlaza(seguridadUtil.getEmpleado().getIdPlaza());
        }
        

        return command;

    }
    
    
    @Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(new Date());
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
    /**
     * Atiende las solicitudes de búsqueda desde la pantalla de consulta general de solicitudes
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response,
            Object command,BindException errors) throws Exception{
        
        ModelAndView mav = new ModelAndView (getFormView());
        mav.addObject(getCommandName(), command);
        
        
        
        ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado = new ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO>();
        resultado.setPaginaActual(1);
        resultado.setRegistrosPorPagina(getRegistrosPorPagina());
        if(StringUtils.isNotBlank(request.getParameter("paginaActual"))){
            resultado.setPrimerVez(false);
            resultado.setPaginaActual(NumberUtils.toInt(request.getParameter("paginaActual"), 1));
            resultado.setTotalResultados(NumberUtils.toInt(request.getParameter("totalResultados"), 1));
            resultado.setTotalPaginas(NumberUtils.toInt(request.getParameter("totalPaginas"), 1));
            resultado.setTotalPrima(NumberUtils.toDouble(request.getParameter("totalPrima"), 0));
        }
        CriteriosConsultaSolicitudesDTO criterios = (CriteriosConsultaSolicitudesDTO)command;
        int indiceOrden = NumberUtils.toInt(request.getParameter("indiceOrden"),-1);
        if(indiceOrden >=0 ){
        	if(StringUtils.isBlank(criterios.getOrden()[indiceOrden])){
        		criterios.getOrden()[indiceOrden] = "asc";
        	}else if(criterios.getOrden()[indiceOrden].equals("asc")){
        		criterios.getOrden()[indiceOrden] = "desc";
        	}else{
        		criterios.getOrden()[indiceOrden] = "";
        	}
        }
        if(StringUtils.isNotBlank(criterios.getStrFechaSolicitudInicial())){
            criterios.setFechaSolicitudInicial(DateUtils.parseDate(criterios.getStrFechaSolicitudInicial(), new String[]{"dd/MM/yyyy"}));
        }
        if(StringUtils.isNotBlank(criterios.getStrFechaSolicitudFinal())){
            criterios.setFechaSolicitudFinal(DateUtils.parseDate(criterios.getStrFechaSolicitudFinal(), new String[]{"dd/MM/yyyy"}));
        }
        
        
        //Verificar si se desea exportar en Excel La consulta
        System.out.println(request.getParameter("formato"));
        System.out.println(resultado.getResultados());

        consultaGeneralSolicitudesBusiness.consultarSolicitudes(criterios, resultado);

        if(request.getParameter("formato") != null && "xlsx".equals(request.getParameter("formato"))){
        	resultado.setPaginaActual(1);
        	resultado.setRegistrosPorPagina(65525);
        	//System.out.println(resultado);
        	File archivo= this.generaArchivoConsultaGeneralExcel.generaArchivoExcel(resultado);
        	System.out.println(archivo);
        	InputStream inputstream = new FileInputStream(archivo);
        	//-no va-mav.setViewName("/consulta/consultaExcel");
        	response.setContentType("application/force-download");
            response.setHeader("Content-Disposition",
            		"attachment; filename= " +  "consultaGeneral.xlsx");
            IOUtils.copy(inputstream, response.getOutputStream());
            response.flushBuffer();
        }
        
       // consultaGeneralSolicitudesBusiness.consultarSolicitudes(criterios, resultado);
        
        
        mav.addObject("resultado", resultado);
        
        mav.addObject("rolVentas",new Boolean(seguridadUtil.isRolVentas()));
        mav.addObject("rolAdministrador",new Boolean(seguridadUtil.isRolAdministrador()));

        return mav;
    }

    


    /**
     * @return the registrosPorPagina
     */
    public Integer getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    /**
     * @param registrosPorPagina the registrosPorPagina to set
     */
    public void setRegistrosPorPagina(Integer registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    /**
     * @return the consultaGeneralSolicitudesBusiness
     */
    public IConsultaGeneralSolicitudesBusiness getConsultaGeneralSolicitudesBusiness() {
        return consultaGeneralSolicitudesBusiness;
    }

    /**
     * @param consultaGeneralSolicitudesBusiness the consultaGeneralSolicitudesBusiness to set
     */
    public void setConsultaGeneralSolicitudesBusiness(IConsultaGeneralSolicitudesBusiness consultaGeneralSolicitudesBusiness) {
        this.consultaGeneralSolicitudesBusiness = consultaGeneralSolicitudesBusiness;
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
	public GeneraArchivoConsultaGeneralExcel getGeneraArchivoConsultaGeneralExcel() {
		return generaArchivoConsultaGeneralExcel;
	}
	public void setGeneraArchivoConsultaGeneralExcel(GeneraArchivoConsultaGeneralExcel generaArchivoConsultaGeneralExcel) {
		this.generaArchivoConsultaGeneralExcel = generaArchivoConsultaGeneralExcel;
	}
	
	
}
