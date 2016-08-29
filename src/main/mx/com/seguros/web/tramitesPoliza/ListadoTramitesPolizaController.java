/**
 * 
 */
package mx.com.seguros.web.tramitesPoliza;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.TramitePoliza;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller que atiende las solicitudes de búsqueda de trámites de póliza
 * @author Emigdio Hernandez
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})

public class ListadoTramitesPolizaController extends SimpleFormController{

	private IPolizaBusiness polizaBusiness;
	private SeguridadUtil seguridadUtil;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		ListadoTramitesPolizaCommand tramiteCommand = (ListadoTramitesPolizaCommand)command;
		
		TramitePoliza tramite = new TramitePoliza();
		tramite.setIdTipoTramiteInicial(tramiteCommand.getIdTipoTramiteInicial());
		tramite.setIdTipoTramiteFinal(tramiteCommand.getIdTipoTramiteFinal());
		tramite.setIdOficina(tramiteCommand.getIdOficina());
		tramite.setNumPoliza(tramiteCommand.getNumPoliza());
		tramite.setNumConsignatario(tramiteCommand.getNumConsignatario());
		tramite.setFecha(tramiteCommand.getFechaTramite());
		tramite.setUsuario(seguridadUtil.getUsuario().getUsername());
		tramite.setTelefono(tramiteCommand.getTelefono());
		tramite.setComentariosAsegurado(tramiteCommand.getComentariosAsegurado());
		tramite.setComentariosAsesor(tramiteCommand.getComentariosAsesor());
		tramite.setObservaciones(tramiteCommand.getObservaciones());
		
		polizaBusiness.insertarTramitePoliza(tramite);
		
		tramiteCommand.setIdTipoTramiteInicial(null);
		tramiteCommand.setIdTipoTramiteFinal(null);
		tramiteCommand.setFechaTramite(null);
		tramiteCommand.setComentariosAsegurado(null);
		tramiteCommand.setComentariosAsesor(null);
		tramiteCommand.setIdOficina(null);
		tramiteCommand.setFechaTramite(null);
		tramiteCommand.setTelefono(null);
		tramiteCommand.setObservaciones(null);
		
		
		mv.addObject(getCommandName(), tramiteCommand);
		mv.addAllObjects(referenceData(null, command, null));
		return mv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	
	
	@Override
    public Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        ListadoTramitesPolizaCommand tramiteCommand = (ListadoTramitesPolizaCommand)command;
        PolizaIndividual poliza = polizaBusiness.obtenerDetallePolizaPorNumero(tramiteCommand.getNumPoliza(), tramiteCommand.getNumConsignatario());
		if(poliza != null){
			data.put("poliza",poliza);
			data.put("listaTramites",polizaBusiness.obtenerTramitesDePoliza(tramiteCommand.getNumPoliza(), tramiteCommand.getNumConsignatario()));
		}
		data.put("listaTiposTramite", polizaBusiness.obtenerCatalogTipoTramite());
		data.put("listaOficinas", polizaBusiness.obtenerCatalogOficinas());
        return data;
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public Object formBackingObject(HttpServletRequest request)throws Exception{
		ListadoTramitesPolizaCommand tramiteCommand = new ListadoTramitesPolizaCommand();
		tramiteCommand.setNumPoliza(NumberUtils.toInt(request.getParameter("numPoliza")));
    	tramiteCommand.setNumConsignatario(NumberUtils.toInt(request.getParameter("numConsignatario")));
    	return tramiteCommand;
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

}
