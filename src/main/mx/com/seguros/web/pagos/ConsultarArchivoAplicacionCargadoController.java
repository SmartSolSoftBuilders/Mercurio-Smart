/**
 * 
 */
package mx.com.seguros.web.pagos;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.model.ArchivosAplicacionCargados;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller para atender la petición de consultar el archivo cargado
 * de un Archivo de Aplicación de Pagos
 * @author Emigdio Hernandez
 *
 */
public class ConsultarArchivoAplicacionCargadoController extends AbstractController {

	private PagosBusiness pagosBusiness;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idArchivo = request.getParameter("idArchivosAplicacionCargados");
		
		ArchivosAplicacionCargados archivo = pagosBusiness.consultaArcivoAplicacionCargadoPorId(Long.parseLong(idArchivo));
		
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
	 * 
	 * @param pagosBusiness
	 */
	public void setPagosBusiness(PagosBusiness pagosBusiness) {
		this.pagosBusiness = pagosBusiness;
	}

}
