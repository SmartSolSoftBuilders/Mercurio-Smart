/**
 * 
 */
package mx.com.seguros.web.archivopolizas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Atiende las solicitudes para la consulta de archivos de carga e inicia el flujo para cargar un nuevo archivo
 * @author Emigdio Hernández
 *
 */
public class ConsultarArchivosPolizasCargadosController extends SimpleFormController{
	
	
	IArchivoPolizasBusiness archivoPolizaBusiness;
	SeguridadUtil seguridadUtil;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();

        data.put("listaResumenCarga", archivoPolizaBusiness.consultarArchivosCargados());
        
        
        return data;
    }
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
    public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,
            Object command,BindException errors) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		
		CargarArchivoPolizasInbursaCommand comando = (CargarArchivoPolizasInbursaCommand)command;
		
		if(comando.getArchivoInbursa().isEmpty()){
			mv.setViewName(getFormView());
			comando.setMensajeError("El archivo de carga está vacío");
			
		}else{
			mv.addObject("resumen",archivoPolizaBusiness.procesarArchivoInbursa(comando.getArchivoInbursa().getInputStream(), 
					comando.getArchivoInbursa().getOriginalFilename(), seguridadUtil.getUsuario().getUsername()));
		}	
		
		return mv;

		
		
	}

	/**
	 * @param archivoPolizaBusines the archivoPolizaBusines to set
	 */
	public void setArchivoPolizaBusiness(IArchivoPolizasBusiness archivoPolizaBusines) {
		this.archivoPolizaBusiness = archivoPolizaBusines;
	}

	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}
}
