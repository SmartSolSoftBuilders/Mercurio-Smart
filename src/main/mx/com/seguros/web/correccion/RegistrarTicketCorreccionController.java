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
 * Controller para atender las peticiones de guardar una nuevo ticket de corrección o
 * actualizar los datos de alguno existente.
 * @author Emigdio Hernández
 *
 */
public class RegistrarTicketCorreccionController extends SimpleFormController {
	private ISolicitudBusiness solicitudBusiness;
    private IPolizaBusiness polizaBusiness;
    private SeguridadUtil seguridadUtil;
	private IProcesoCorreccionDatosBusiness procesoCorreccionDatosBusiness;    
	
	
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
        
        Integer numPoliza = NumberUtils.toInt(request.getParameter("numPoliza"),-1);
        Integer numConsignatario = NumberUtils.toInt(request.getParameter("numConsignatario"),-1);
        Integer folioSolicitud = NumberUtils.toInt(request.getParameter("folioSolicitud"),-1);
        String formatoSolicitud = request.getParameter("formatoSolicitud");
        PolizaIndividual pol = polizaBusiness.obtenerDetallePolizaPorNumero(numPoliza, numConsignatario);
        
        List <BeneficioAdicional> beneficios = polizaBusiness.consultarCatalogoBeneficiosAdicionales();
        List <BeneficioAdicionalPoliza> beneficiosPoliza = new ArrayList<BeneficioAdicionalPoliza>();
        
        BeneficioAdicionalPoliza beneficioEnPoliza = null;
        for(BeneficioAdicional beneficio:beneficios){
        	beneficioEnPoliza = new BeneficioAdicionalPoliza();
        	beneficioEnPoliza.setDescripcionBeneficio(beneficio.getDescripcionBeneficioAdicional());
        	beneficioEnPoliza.setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
        	asignarMontosDeBeneficio(beneficioEnPoliza,pol.getBeneficiosAdicionales());
        	beneficiosPoliza.add(beneficioEnPoliza);
     	   
        }
        pol.setBeneficiosAdicionales(beneficiosPoliza);
        
        Solicitud sol = null;
        sol = solicitudBusiness.obtenerDetalleSolicitudPorFolio(folioSolicitud,formatoSolicitud);
        if(sol.getCveAgente() != null){
        	Agente agente = solicitudBusiness.obtenerAgentePorCveAgente(sol.getCveAgente());
            sol.setAgente(agente);
            if(sol.getAgente() != null){
            	sol.getAgente().setEmpleado(solicitudBusiness.obtenerEmpleadoPorCveEmpleado(agente.getCveEmpleado()));
            }
        }
        
        sol.setBeneficiario(solicitudBusiness.consultarBeneficiarios(folioSolicitud, formatoSolicitud));
        sol.setPromotor(solicitudBusiness.buscarPromotor(sol.getCvePromotor()));
        
        pol.setSolicitud(sol);
        
        cmd.setDatosOriginales(pol);
        cmd.setDatosNuevos(new PolizaIndividual());
        for(int iBenefNuevo = 0;iBenefNuevo < cmd.getDatosNuevos().getSolicitud().getBeneficiario().length;iBenefNuevo++){
        	cmd.getDatosNuevos().getSolicitud().getBeneficiario()[iBenefNuevo] = new Beneficiario();
        }
        beneficiosPoliza = new ArrayList<BeneficioAdicionalPoliza>();
        for(BeneficioAdicional beneficio:beneficios){
        	beneficioEnPoliza = new BeneficioAdicionalPoliza();
        	beneficioEnPoliza.setDescripcionBeneficio(beneficio.getDescripcionBeneficioAdicional());
        	beneficioEnPoliza.setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
        	beneficiosPoliza.add(beneficioEnPoliza);
        }
        cmd.getDatosNuevos().setBeneficiosAdicionales(beneficiosPoliza);
        	
        cmd.setTicket(new TicketCorreccion());
        cmd.getTicket().setEstadoTicketCorreccion(new EstadoTicketCorreccion());
        cmd.getTicket().getEstadoTicketCorreccion().setIdEstadoTicketCorreccion(EstadoTicketCorreccion.NUEVO);
        cmd.getTicket().getEstadoTicketCorreccion().setDescripcionEstadoTicketCorreccion(EstadoTicketCorreccion.DESCRIPCION[EstadoTicketCorreccion.NUEVO]);
        cmd.getTicket().setUsuarioSolicitante(seguridadUtil.getUsuario().getUsername());    
        cmd.getTicket().setFechaSolicitud(new Date());    
        cmd.getTicket().setFolioSolicitud(folioSolicitud);
		cmd.getTicket().setFormatoSolicitud(formatoSolicitud);
		cmd.getTicket().setNumPoliza(numPoliza);
		cmd.getTicket().setNumConsignatario(numConsignatario);
       	cmd.setAseguradoInexistente(pol.getAsegurado().getIdAsegurado() == null || pol.getAsegurado().getIdAsegurado() == 0);
        
       	cmd.setExistenPagosAplicados(procesoCorreccionDatosBusiness.polizaCuentaConPagosAplicados(pol));
        
        
        return cmd;

    }
	/**
	 * Asigna los montos de un beneficio adicional buscando el id de beneficioEnPoliza en la lista
	 * de beneficios adicionales para obtener sus montos.
	 * @param beneficioEnPoliza Beneficio para asignar sus montos
	 * @param beneficiosAdicionales Lista de beneficios adicionales de donde buscar
	 */
	private void asignarMontosDeBeneficio(
			BeneficioAdicionalPoliza beneficioEnPoliza,
			List<BeneficioAdicionalPoliza> beneficiosAdicionales) {
		if(beneficiosAdicionales != null){
			for(BeneficioAdicionalPoliza benefLista:beneficiosAdicionales){
				if(benefLista.getIdBeneficioAdicional().equals(beneficioEnPoliza.getIdBeneficioAdicional())){
					beneficioEnPoliza.setSumaBeneficio(benefLista.getSumaBeneficio());
					beneficioEnPoliza.setMontoCobertura(benefLista.getMontoCobertura());
				}
			}
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
    public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,
            Object command,BindException errors) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(getSuccessView());
		
		RegistrarTicketCorreccionCommand comando = (RegistrarTicketCorreccionCommand)command;
		TicketCorreccion ticket = comando.getTicket();
		ticket.setDatosOriginales(XMLUtil.toXML(comando.getDatosOriginales()));
		ticket.setDatosNuevos(XMLUtil.toXML(comando.getDatosNuevos()));
		
		ticket.setFechaSolicitud(new Date());
		ticket.setIdEstadoTicketCorreccion(EstadoTicketCorreccion.NUEVO);
		
		procesoCorreccionDatosBusiness.guardarTicketCorreccion(ticket);
		if(StringUtils.isNotBlank(comando.getComentarioNuevo())){
			//Agregar comentario
			ComentarioTicket comentario = new ComentarioTicket();
			comentario.setIdTicketCorreccion(ticket.getIdTicketCorreccion());
			comentario.setUsuario(seguridadUtil.getUsuario().getUsername());
			comentario.setComentario(comando.getComentarioNuevo());
			comentario.setFecha(new Date());
			procesoCorreccionDatosBusiness.agregarComentarioTicket(comentario);
		}
		
		mv.addObject("idTicketCorreccion",ticket.getIdTicketCorreccion());
		mv.addObject("mensaje","El ticket con el folio "+ticket.getIdTicketCorreccion()+" fué registrado exitósamente.");
		return mv;

		
		
	}

	/**
	 * @param solicitudBusiness the solicitudBusiness to set
	 */
	public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
		this.solicitudBusiness = solicitudBusiness;
	}

	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}

	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

	/**
	 * @param procesoCorreccionDatosBusiness the procesoCorreccionDatosBusiness to set
	 */
	public void setProcesoCorreccionDatosBusiness(
			IProcesoCorreccionDatosBusiness procesoCorreccionDatosBusiness) {
		this.procesoCorreccionDatosBusiness = procesoCorreccionDatosBusiness;
	}
}
