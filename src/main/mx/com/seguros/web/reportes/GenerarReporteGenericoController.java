/**
 * 
 */
package mx.com.seguros.web.reportes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Clase Controller para atender las peticiones de generar cualquier reporte
 * @author Emigdio Hernández
 *
 */
public class GenerarReporteGenericoController extends SimpleFormController{
	
	SeguridadUtil seguridadUtil = null;
	List<Map> inventarioReportes = null;
	private ReporteBusiness reporteBusiness = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map<String, Object> datos = new HashMap<String, Object>();
		
        datos.put("inventarioReportes", inventarioReportes);
        if(request.getParameter("claveReporteTmp") != null){
        	for(Map rep:inventarioReportes){
        		if(request.getParameter("claveReporteTmp").equals(rep.get("claveReporte"))){
        			String parametros[] = rep.get("params").toString().split(",");
        			String descParams[] = rep.get("nombreParams").toString().split(",");
        			for(int i=0;i<parametros.length;i++){
        				parametros[i] = parametros[i].trim();
        				descParams[i] = descParams[i].trim();
        			}
        			datos.put("listaParams", parametros);
        			datos.put("nombreParams", descParams);
        			((GenerarReporteGenericoCommand)command).setClaveReporte(request.getParameter("claveReporteTmp"));
        			break;
        		}
        	}
        }
		
		return datos;
    }
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
    public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,
            Object command,BindException errors) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		GenerarReporteGenericoCommand comando = (GenerarReporteGenericoCommand)command;
		Map parametros = new HashMap();
		Enumeration paramsNames = req.getParameterNames();
		String key = null;
		while(paramsNames.hasMoreElements()){
			key = paramsNames.nextElement().toString();
			parametros.put(key, req.getParameter(key));
		}
		
		
		mv.addObject("rutaReporte",reporteBusiness.emitirReporteGenerico(comando.getClaveReporte(), parametros, 
				seguridadUtil.getUsuario().getUsername(), comando.getComentario()));
		comando.setClaveReporte(null);
		mv.addObject("command",comando);
		mv.addAllObjects(referenceData(req,command,errors));
		return mv;

		
		
	}

	
	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

	/**
	 * @param inventarioReportes the inventarioReportes to set
	 */
	public void setInventarioReportes(List<Map> inventarioReportes) {
		this.inventarioReportes = inventarioReportes;
	}

	/**
	 * @param reporteBusiness the reporteBusiness to set
	 */
	public void setReporteBusiness(ReporteBusiness reporteBusiness) {
		this.reporteBusiness = reporteBusiness;
	}
}
