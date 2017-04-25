/**
 * 
 */
package mx.com.seguros.web.reportes;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.utils.FormatUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller que atiende las peticiones para volver a generar los reportes relacionados con una póliza
 * @author Emigdio Hernández
 *
 */
public class GenerarReportesPolizaController extends AbstractController {
	
	private ReporteBusiness reporteBusiness;
	public static String CARTA_RESUMEN = "carta";
	public static String ACUSE_RECIBO = "acuse";
	public static String CERTIFICADO_INDIVIDUAL = "certificado";
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	 protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("reportes/reporteGenerado");
		Map datos = new HashMap();
		Integer numCertificado = FormatUtil.parseIntNull(request.getParameter("numCertificado"));
		Integer numPoliza = FormatUtil.parseIntNull(request.getParameter("numPoliza"));
		Integer numConsignatario = FormatUtil.parseIntNull(request.getParameter("numConsignatario"));
		String cvePlaza = request.getParameter("cvePlaza");
		String reporte = request.getParameter("tipoReporte");
		String folioSolicitud = request.getParameter("folioSolicitud");
		String formatoSolicitud = request.getParameter("formatoSolicitud");
		
		String rutaReporte = null;
		if(numPoliza != null){
			if(CARTA_RESUMEN.equals(reporte)){
				rutaReporte = reporteBusiness.generarReporteCartaResumenPoliza(numCertificado, numPoliza, numConsignatario, cvePlaza);
				mv.addObject("nombreReporte", "Carta Resumen de Póliza");
			}
			if(ACUSE_RECIBO.equals(reporte)){
				rutaReporte = reporteBusiness.generarReporteAcuseReciboPoliza(numCertificado, numPoliza, cvePlaza);
				mv.addObject("nombreReporte", "Acuse de Recibo de Póliza");
			}
			if(CERTIFICADO_INDIVIDUAL.equals(reporte)){
				rutaReporte = reporteBusiness.
						generarReporteCertificadoIndividual(Integer.parseInt(folioSolicitud), formatoSolicitud, numPoliza, numCertificado, cvePlaza);
			}
			mv.addObject("rutaReporte", rutaReporte);
		}
		
		
		return mv;
	}
	
	/**
	 * @param reporteBusiness the reporteBusiness to set
	 */
	public void setReporteBusiness(ReporteBusiness reporteBusiness) {
		this.reporteBusiness = reporteBusiness;
	}

}
