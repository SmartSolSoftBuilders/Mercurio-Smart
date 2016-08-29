/**
 * 
 */
package mx.com.seguros.web.bonos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.utils.FormatUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller para la generación de los reportes referentes al cálculo de Bonos
 * @author Emigdio Hernandez
 *
 */
public class GenerarReportesBonoController extends AbstractController{
	/**
	 * Servicio para generación de reportes
	 */
	private ReporteBusiness reporteBusiness = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView("reportes/reporteGeneradoPopUp");
		
		Integer idResumenProcesoCalculoBono = FormatUtil.parseIntNull(request.getParameter("idResumenProcesoCalculoBono"));
		Integer idResumenCalculoBonoPolizaAgente = FormatUtil.parseIntNull(request.getParameter("idResumenCalculoBonoPolizaAgente"));
		String ruta = null;
		String nombre = null;
		if(idResumenProcesoCalculoBono != null){
			//se emite el reporte del resumen del proceso
			ruta = reporteBusiness.generarReporteResumenProcesoCalculoBono(idResumenProcesoCalculoBono);
			nombre = "Reporte de Resumen del Proceso de Cálculo de Bono";
		}else{
			//se emite el reporte del resumen del cálculo para un agente
			ruta = reporteBusiness.generarReporteResumenCalculoBonoAgente(idResumenCalculoBonoPolizaAgente);
			nombre = "Reporte de Resumen de Cálculo de Bono de Agente";
		}
		mv.addObject("rutaReporte", ruta);
		mv.addObject("nombreReporte", nombre);
		return mv;
	}
	/**
	 * @return the reporteBusiness
	 */
	public ReporteBusiness getReporteBusiness() {
		return reporteBusiness;
	}
	/**
	 * @param reporteBusiness the reporteBusiness to set
	 */
	public void setReporteBusiness(ReporteBusiness reporteBusiness) {
		this.reporteBusiness = reporteBusiness;
	}

}
