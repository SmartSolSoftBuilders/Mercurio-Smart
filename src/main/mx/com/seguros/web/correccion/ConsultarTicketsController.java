/**
 * 
 */
package mx.com.seguros.web.correccion;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.correccion.IProcesoCorreccionDatosBusiness;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.TicketCorreccion;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para atender las peticiones de búsqueda de tickets de corrección
 * @author Emigdio Hernández
 *
 */
public class ConsultarTicketsController extends AbstractController {
	
	private IProcesoCorreccionDatosBusiness procesoCorreccionDatosBusiness;    
	private SeguridadUtil seguridadUtil;
	
	
	 @Override
	 protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		List<EstadoTicketCorreccion> estados = procesoCorreccionDatosBusiness.consultarEstadosTicketCorreccion();
        EstadoTicketCorreccion todos = new EstadoTicketCorreccion();
        todos.setIdEstadoTicketCorreccion(0);
        todos.setDescripcionEstadoTicketCorreccion("Todos");
        estados.add(0, todos);
       
        ModelAndView mv = new ModelAndView();
		mv.addObject("estadosTicketCorreccion", estados);
        mv.setViewName("correccion/listadoTickets");
		
        Integer idEstadoCorreccion = FormatUtil.parseIntNull(request.getParameter("idEstadoTicketCorreccion"));
        Date fechaInicial = FormatUtil.stringToDate(request.getParameter("fechaInicioConsulta"));
        Date fechaFinal = FormatUtil.stringToDate(request.getParameter("fechaFinConsulta"));
        
        mv.addObject("idEstadoTicketCorreccion",request.getParameter("idEstadoTicketCorreccion"));
        mv.addObject("fechaInicioConsulta",request.getParameter("fechaInicioConsulta"));
        mv.addObject("fechaFinConsulta",request.getParameter("fechaFinConsulta"));
		
		ResultadoPaginadoDTO<TicketCorreccion> resultado = new ResultadoPaginadoDTO<TicketCorreccion>();
		resultado.setResultados(procesoCorreccionDatosBusiness.consultarTicketsCorreccion(
				idEstadoCorreccion!=null && idEstadoCorreccion>0?idEstadoCorreccion:null, 
				fechaInicial, 
				fechaFinal, 
				seguridadUtil.isRolDireccion() || seguridadUtil.isRolAdministrador()?null:seguridadUtil.getUsuario().getUsername()));
		resultado.setPaginaActual(1);
		resultado.setTotalPaginas(1);
		resultado.setTotalResultados(resultado.getResultados().size());
		mv.addObject("resultado",resultado);
		mv.addObject("mensaje", request.getParameter("mensaje"));
		return mv;

		 
	 }
	
	
	
	
	/**
	 * @param procesoCorreccionDatosBusiness the procesoCorreccionDatosBusiness to set
	 */
	public void setProcesoCorreccionDatosBusiness(
			IProcesoCorreccionDatosBusiness procesoCorreccionDatosBusiness) {
		this.procesoCorreccionDatosBusiness = procesoCorreccionDatosBusiness;
	}
	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}
}
