/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.web.consulta;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.dto.HistoricoTarifaDTO;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.XMLUtil;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller dedicado a atender las solicitudes de una consulta del historial de tarifas
 * de una solicitud, puede retornar una respuesta en XML con las tarifas
 * @author Emigdio Hernández
 */
public class ConsultarTarifasController extends AbstractController{

  
    private ISolicitudBusiness solicitudBusiness;
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	Integer folioSolicitud = FormatUtil.parseIntNull(request.getParameter("folioSolicitud"));
    	String formatoSolicitud = request.getParameter("formatoSolicitud");
    	Solicitud solParam = new Solicitud();
    	solParam.setFolioSolicitud(folioSolicitud);
    	solParam.setFormatoSolicitud(formatoSolicitud);
    	List<HistoricoTarifa> tarifas = solicitudBusiness.consultarHistoricoTarifaSolicitud(solParam);
    	List<HistoricoTarifaDTO> historicoFormateado = new ArrayList<HistoricoTarifaDTO>();
    	for(HistoricoTarifa tarifa:tarifas){
    		historicoFormateado.add(new HistoricoTarifaDTO(tarifa));
    	}
    	response.getWriter().write(
    	XMLUtil.converter.toXML(historicoFormateado)
    	);
        return null;
    }

       
    

    /**
     * @param solicitudBusiness the solicitudBusiness to set
     */
    public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
        this.solicitudBusiness = solicitudBusiness;
    }

    

}
