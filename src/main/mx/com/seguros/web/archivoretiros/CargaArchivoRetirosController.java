/*
 * Smart Solutions 2013
 */
package mx.com.seguros.web.archivoretiros;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.archivoestatus.ArchivoCambioEstatusPolizaBusiness;
import mx.com.seguros.business.archivoretiros.ArchivoTramiteRetirosBusiness;
import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.CargaArchivoCambioEstatusPoliza;
import mx.com.seguros.utils.CargaArchivoTramiteRetiros;
import mx.com.seguros.utils.CargaArchivoVO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 * Controller que muestra la lista de los archivos de cambio de trámite de retiros cargados, permite ver su detalle
 * y permite cargar un nuevo archivo.
 * 
 * @author Emigdio Hernandez
 *
 */
public class CargaArchivoRetirosController extends SimpleFormController {

	private ArchivoTramiteRetirosBusiness archivoTramiteRetirosBusiness;
	private SeguridadUtil seguridadUtil;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		
		
		CargaArchivoVO cargaArchivoVO = (CargaArchivoVO) command;
		
		MultipartFile file = cargaArchivoVO.getFile();
		CargaArchivoTramiteRetiros cargaArchivo = new CargaArchivoTramiteRetiros();
		List<String[]> datosArchivo = null;
		String error = null;
	
		try {
				datosArchivo = cargaArchivo.cargaInformacionArchivo(file.getInputStream());
				archivoTramiteRetirosBusiness.cargarArchivoRetiros(datosArchivo, file.getBytes(),seguridadUtil.getUsuario().getUsername(),file.getOriginalFilename());
				error = "Archivo de Trámites de Retiro Cargado Exitósamente";
		} catch (Throwable pbe) {
			pbe.printStackTrace();
			error = "Error al cargar el archivo de Trámites de Retiros: " + pbe.getMessage();
		}
		
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("error", error);
		mav.addAllObjects(referenceData(null, command, null));
		return mav;
		
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        data.put("listaArchivos", archivoTramiteRetirosBusiness.obtenerArchivosRetiroCargados());
        return data;
	}
	
	
	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}
	/**
	 * @param archivoTramiteRetirosBusiness the archivoTramiteRetirosBusiness to set
	 */
	public void setArchivoTramiteRetirosBusiness(
			ArchivoTramiteRetirosBusiness archivoTramiteRetirosBusiness) {
		this.archivoTramiteRetirosBusiness = archivoTramiteRetirosBusiness;
	}

}
