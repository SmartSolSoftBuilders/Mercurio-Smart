/*
 * Smart Solutions 2012
 */
package mx.com.seguros.web.pagos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.CargaArchivoVO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 * Controller para la atención a las solicitudes del usuario de cargar un archivo de aplicación de pagos 
 * Excel 2003-2007 con las siguientes columnas:
 * QUINCENA QUE SE ESTÁ PAGANDO: Almacenada como cadena con los datos del número de quincena y el año, separadas por un espacio ejemplo: '20 2012' quincena 20 del 2012 -- campo que será leído
 * INICIO DE VIGENCIA: Fecha con el formato yyyyMMdd ejemplo: 20110615 -- campo que será leído
 * EMISIOR: Número entero
 * CARPETA: número entero -- campo que será leído
 * PÓLIZA: número entero -- campo que será leído
 * RFC: informativo
 * RFC: informativo
 * NOMBRE: informativo
 * PAGO: número decimal  --- Campo que será leído
 * OV: número decimal
 * COLECTIVO : número decimal
 * El primero renglón será desechado, en este renglón deben de ir los títulos
 * Se leera únicamente la primera hoja del libro
 * 
 * @author Emigdio Hernandez
 *
 */
public class CargaArchivoAplicacionPagosController extends SimpleFormController {

	public CargaArchivoAplicacionPagosController() {
		setFormView("CargaArchivos/cargaArchivoAplicacion");
		setSuccessView(successView);
		setCommandClass(CargaArchivoVO.class);
	}

	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		SeguridadUtil utl = new SeguridadUtil();
		logger.info("Inicia carga de archivo de pagos del retenedor...");
		CargaArchivoVO cargaArchivoVO = (CargaArchivoVO) command;
		logger.debug("cargaArchivoVO: " + cargaArchivoVO);
		MultipartFile file = cargaArchivoVO.getFile();
		CargaArchivo cargaArchivo = new CargaArchivo();
		List<List<String>> datosArchivo = null;
		String error = null;
		
	
		try {
			datosArchivo = cargaArchivo.cargaInformacionArchivo(file.getInputStream());
			if(pagosBusiness.validarContenidoArchivoAplicacion(datosArchivo)){
				pagosBusiness.cargarArchivoAplicacionPagos(datosArchivo, file.getBytes(),utl.getUsuario().getUsername(),file.getOriginalFilename() );
				error = "Archivo de Aplicación de Pagos Cargado Exitósamente";
			}else{
				error = "El archivo de aplicación contiene registros de aplicación de descuentos que ya han sido aplicados en el sistema, no se cargó el archivo.";
			}
			
			setSuccessView(successView);
		} catch (Exception pbe) {
			pbe.printStackTrace();
			error = "Error al cargar el archivo de aplicación de pagos: " + pbe.getMessage();
			setSuccessView(errorView);
		}

		
		ModelAndView mav = new ModelAndView(getSuccessView());
	
		mav.addObject("error", error);
		mav.addObject("listaArchivosAplicacion", pagosBusiness.consultarArchivosAplicacionCargados(new CriteriosConsultaArchivosAplicacionCargadosDTO()));
		return mav;
		
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();

        data.put("listaArchivosAplicacion", pagosBusiness.consultarArchivosAplicacionCargados(new CriteriosConsultaArchivosAplicacionCargadosDTO()));
        
        
        return data;
	}
	
	
	public void setPagosBusiness(PagosBusiness pagosBusiness) {
		this.pagosBusiness = pagosBusiness;
	}

	private PagosBusiness pagosBusiness;

	private static final String successView;
	private static final String errorView;
	private static final Logger logger;

	static {
		successView = "CargaArchivos/cargaArchivoAplicacion";
		errorView = "CargaArchivos/cargaArchivoAplicacion";
		logger = LoggerFactory.getLogger(CargaArchivoAplicacionPagosController.class);
	}

}
