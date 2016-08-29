/**
 * 
 */
package mx.com.seguros.web.archivoretiros;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller para atender la petición de consultar el detalle de retiros de un asegurado
 * @author Emigdio Hernandez
 *
 */
public class ConsultarDetalleRetirosController extends AbstractController {

	private ArchivoTramiteRetirosBusiness archivoTramiteRetirosBusiness;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("archivoRetiros/detalleRetiros");
		String numPoliza = request.getParameter("numPoliza");
		String numConsignatario = request.getParameter("numConsignatario");
		mv.addObject("numPoliza", numPoliza);
		mv.addObject("numConsignatario", numConsignatario);
		mv.addObject("listaTramites", archivoTramiteRetirosBusiness.consultarTramitesDeRetiroDeAsegurado(Integer.valueOf(numPoliza),Integer.valueOf(numConsignatario)));
		return mv;
	}

	/**
	 * @param archivoTramiteRetirosBusiness the archivoTramiteRetirosBusiness to set
	 */
	public void setArchivoTramiteRetirosBusiness(
			ArchivoTramiteRetirosBusiness archivoTramiteRetirosBusiness) {
		this.archivoTramiteRetirosBusiness = archivoTramiteRetirosBusiness;
	}
	

}
