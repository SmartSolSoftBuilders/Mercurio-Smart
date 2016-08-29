/**
 * 
 */
package mx.com.seguros.web.archivoretiros;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness;
import mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.model.ArchivoRetirosCargado;
import mx.com.seguros.model.ArchivoTramitePoliza;
import mx.com.seguros.model.ArchivosAplicacionCargados;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller para atender la petición de consultar el archivo de 
 * trámite de retiros
 * @author Emigdio Hernandez
 *
 */
public class ConsultarArchivoRetirosController extends AbstractController {

	private ArchivoTramiteRetirosBusiness archivoTramiteRetirosBusiness;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idArchivo = request.getParameter("idArchivo");
		
		ArchivoRetirosCargado archivo = archivoTramiteRetirosBusiness.obtenerArchivoRetirosPorId(NumberUtils.toLong(idArchivo));
		
		if(archivo != null && archivo.getArchivo() != null){
			response.setContentType("application/ms-excel");
            response.setHeader("Content-Disposition",
            		"attachment; filename=" +  archivo.getNombreArchivo());
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("pragma","no-cache");
            response.setContentLength(archivo.getArchivo().length);
            ServletOutputStream sos = response.getOutputStream();
            sos.write(archivo.getArchivo());
            sos.flush();
		}
		
		return null;
	}

	/**
	 * @param archivoTramiteRetirosBusiness the archivoTramiteRetirosBusiness to set
	 */
	public void setArchivoTramiteRetirosBusiness(
			ArchivoTramiteRetirosBusiness archivoTramiteRetirosBusiness) {
		this.archivoTramiteRetirosBusiness = archivoTramiteRetirosBusiness;
	}
	

}
