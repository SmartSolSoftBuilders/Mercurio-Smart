package mx.com.seguros.web.tramitesPoliza;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.dto.HistoricoTarifaDTO;
import mx.com.seguros.dto.TramitePolizaDTO;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.model.TramitePoliza;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.XMLUtil;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller dedicado a atender las solicitudes de una consulta del listato de
 * trámites de póliza y enviarlos en formato XML de regreso al cliente
 * @author Emigdio Hernández
 */
public class ConsultarListaTramitesController extends AbstractController{

  
    private IPolizaBusiness polizaBusiness;
    private SeguridadUtil seguridadUtil;
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	Integer numPoliza = FormatUtil.parseIntNull(request.getParameter("numPoliza"));
    	Integer numConsignatario = FormatUtil.parseIntNull(request.getParameter("numConsignatario"));
    	List<TramitePoliza> tramites = polizaBusiness.obtenerTramitesDePoliza(numPoliza, numConsignatario);
    	List<TramitePolizaDTO> tramitesFinal = new ArrayList<TramitePolizaDTO>();
    	TramitePolizaDTO tramiteFinal = null;
    	for (TramitePoliza tramite : tramites) {
    		tramiteFinal = new TramitePolizaDTO();
    		
    		tramiteFinal.setFecha(FormatUtil.dateToString(tramite.getFecha()));
    		tramiteFinal.setTipoTramiteInicial(tramite.getTipoTramiteInicial().getNombre());
    		tramiteFinal.setTipoTramiteFinal(tramite.getTipoTramiteFinal().getNombre());
    		tramiteFinal.setOficina(tramite.getOficina().getNombre());
    		tramiteFinal.setUsuario(tramite.getUsuario());
    		tramiteFinal.setTelefono(tramite.getTelefono());
    		tramiteFinal.setComentariosAsegurado(tramite.getComentariosAsegurado());
    		tramiteFinal.setComentariosAsesor(tramite.getComentariosAsesor());
    		tramiteFinal.setObservaciones(tramite.getObservaciones());
    		
    		tramitesFinal.add(tramiteFinal);
		}
    	response.getWriter().write(
    	XMLUtil.converter.toXML(tramitesFinal)
    	);
        return null;
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
