/**
 * 
 */
package mx.com.seguros.web.correccion;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.correccion.IProcesoCorreccionDatosBusiness;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.ComentarioTicket;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.GrupoAsegurado;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TicketCorreccion;
import mx.com.seguros.utils.XMLUtil;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Controller para atender las peticiones de consulta y modificación de tickets.
 * @author Emigdio Hernández
 *
 */
public class ConsultarDetalleTickeController extends SimpleFormController {
	
	private IProcesoCorreccionDatosBusiness procesoCorreccionDatosBusiness;   
	private IPolizaBusiness polizaBusiness;
	private SeguridadUtil seguridadUtil;
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();

        data.put("listaEstatusPolizaSeguimiento",polizaBusiness.consultarEstatusPolizaSeguimiento());
        data.put("listaEstatusPolizaPagos",polizaBusiness.consultarEstatusPolizaPagos());
        return data;
    }
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(new Date());
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        RegistrarTicketCorreccionCommand cmd = new RegistrarTicketCorreccionCommand();
        
        
        cmd.setTicket(procesoCorreccionDatosBusiness.consultarDetalleTicketCorreccion(Integer.parseInt(request.getParameter("idTicketCorreccion"))));
        cmd.setDatosOriginales(XMLUtil.formXML(cmd.getTicket().getDatosOriginales()));
        cmd.setDatosNuevos(XMLUtil.formXML(cmd.getTicket().getDatosNuevos()));
        cmd.setMostrarBotonGuardar( !EstadoTicketCorreccion.APLICADO.equals(cmd.getTicket().getIdEstadoTicketCorreccion()) && 
                !(seguridadUtil.isRolDireccion() || seguridadUtil.isRolAdministrador()) 
                );
        cmd.setMostrarBotonAplicarRechazar(
        (seguridadUtil.isRolDireccion() || seguridadUtil.isRolAdministrador()) &&
        !EstadoTicketCorreccion.APLICADO.equals(cmd.getTicket().getIdEstadoTicketCorreccion()) 
        );
        cmd.setExistenPagosAplicados(procesoCorreccionDatosBusiness.polizaCuentaConPagosAplicados(cmd.getDatosOriginales()));
        return cmd;

    }
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
    public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,
            Object command,BindException errors) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		mv.setView(new RedirectView("consultarTicketsCorreccion"));
		RegistrarTicketCorreccionCommand comando = (RegistrarTicketCorreccionCommand)command;
		comando.getTicket().setDatosOriginales(XMLUtil.toXML(comando.getDatosOriginales()));
		comando.getTicket().setDatosNuevos(XMLUtil.toXML(comando.getDatosNuevos()));
		
		if(EstadoTicketCorreccion.APLICADO.equals(comando.getTicket().getIdEstadoTicketCorreccion())){
			comando.getTicket().setUsuarioAutoriza(seguridadUtil.getUsuario().getUsername());
			comando.getTicket().setFechaAutorizacion(new Date());
			procesoCorreccionDatosBusiness.aplicarCambiosTicketCorreccion(comando);
			
		}
		procesoCorreccionDatosBusiness.actualizarTicketCorreccion(comando.getTicket());
		
		if(StringUtils.isNotBlank(comando.getComentarioNuevo())){
			//Agregar comentario
			ComentarioTicket comentario = new ComentarioTicket();
			comentario.setIdTicketCorreccion(comando.getTicket().getIdTicketCorreccion());
			comentario.setUsuario(seguridadUtil.getUsuario().getUsername());
			comentario.setComentario(comando.getComentarioNuevo());
			comentario.setFecha(new Date());
			procesoCorreccionDatosBusiness.agregarComentarioTicket(comentario);
		}
		
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
	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}
}
