package mx.com.seguros.web.pagos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.business.pagos.exception.ArchivoAntesCargadoException;
import mx.com.seguros.business.pagos.exception.PagosBusinessException;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.CargaArchivoVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PagosBusinessController extends SimpleFormController {

	public PagosBusinessController() {
		String formView;
		formView = "CargaArchivos/cargaArchivoPagos";
		setFormView(formView);
		setSuccessView(successView);
		setCommandClass(CargaArchivoVO.class);
	}

	//@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		logger.info("Inicia carga de archivo de pagos del retenedor...");
		CargaArchivoVO cargaArchivoVO = (CargaArchivoVO) command;
		logger.debug("cargaArchivoVO: " + cargaArchivoVO);
		MultipartFile file = cargaArchivoVO.getFile();
		CargaArchivo cargaArchivo = new CargaArchivo();
		List<List<String>> datosArchivo;
		datosArchivo = cargaArchivo.cargaInformacionArchivo(file
				.getInputStream());
		ArrayList<List<String>> datosArchivoL = (ArrayList<List<String>>) datosArchivo;
		List<String> firstRow = datosArchivoL.get(0);
		String numQnaStr;
		numQnaStr = firstRow.get(0);
		logger.debug("numQnaStr: " + numQnaStr);
		String error;
		try {
			pagosBusiness.readPayFile(datosArchivoL);
			error = null;
			setSuccessView(successView);
		} catch (PagosBusinessException pbe) {
			error = pbe.getMessage();
			setSuccessView(errorView);
		} catch (ArchivoAntesCargadoException e) {
			// TODO: definir a que vista debe irse
			error = e.getMessage();
			setSuccessView(errorView);
		}

		// String[] error=pagosBusiness.getError().split("-");
		// valores.put("mensajeError",error[0]);
		// valores.put("archivoError",error[1]);

		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("numQna", numQnaStr);
		mav.addObject("error", error);
		// mav.addObject(getCommandName(), command);
		return mav;
		// return super.onSubmit(command);
	}

	//@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		logger.debug("Entra!!");
		return super.referenceData(request);
	}
	
	public void setPagosBusiness(PagosBusiness pagosBusiness) {
		this.pagosBusiness = pagosBusiness;
	}

	private PagosBusiness pagosBusiness;

	private static final String successView;
	private static final String errorView;
	private static final Logger logger;

	static {
		successView = "CargaArchivos/operacionCorrecta";
		errorView = "CargaArchivos/operacionCorrecta2";
		logger = LoggerFactory.getLogger(PagosBusinessController.class);
	}

}
