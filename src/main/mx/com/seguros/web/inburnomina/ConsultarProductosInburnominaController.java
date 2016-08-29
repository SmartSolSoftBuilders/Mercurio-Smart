package mx.com.seguros.web.inburnomina;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.XMLUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller dedicado a atender las solicitudes de una consulta de los
 * datos de productos inburnomina, puede retornar una respuesta en XML con los datos
 * @author Emigdio Hernández
 */
public class ConsultarProductosInburnominaController extends AbstractController{

	/**
	 * Servicio para la consulta de los productos inburnomina
	 */
    private AdministrarProductosInburnominaService administrarProductosInburnominaService;
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	Integer numPoliza = FormatUtil.parseIntNull(request.getParameter("numPoliza"));
    	Integer numConsignatario = FormatUtil.parseIntNull(request.getParameter("numConsignatario"));
    	
    	if(numPoliza != null && numConsignatario != null){
    		ProductosInburnomina prod = administrarProductosInburnominaService.obtenerProductosInburnominaDePoliza(numPoliza, numConsignatario);
    		if(prod != null){
    			response.getWriter().write(
        		    	XMLUtil.converter.toXML(prod)
        		    	);
    		}
    		
    	}
        return null;
    }
	/**
	 * @param administrarProductosInburnominaService the administrarProductosInburnominaService to set
	 */
	public void setAdministrarProductosInburnominaService(
			AdministrarProductosInburnominaService administrarProductosInburnominaService) {
		this.administrarProductosInburnominaService = administrarProductosInburnominaService;
	}

}
