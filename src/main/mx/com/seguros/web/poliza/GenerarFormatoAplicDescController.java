/*
 * GenerarFormatoAplicDescController.java
 *
 * Created on 7 de febrero de 2008, 11:24 AM
 *
 * Modificado por CGM en Julio de 2010
 */
package mx.com.seguros.web.poliza;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.data.dao.exception.DescuentoAplicadoException;

import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.reporte.descuento.DescuentoReporte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Cesar Garcia Mauricio
 */
// @Controller()
// @RequestMapping(value = "/generarFormatoAplicDescController")
// TODO - A fin de que el binding sea sencillo si debo extender de
// SimpleFormController, aun cuando este deprecated
// @SuppressWarnings("deprecation")
public class GenerarFormatoAplicDescController extends SimpleFormController {

    public GenerarFormatoAplicDescController() {
        setFormView("registroPoliza/GenerarFormatoAplicacionDescuentos");
        //del módulo de pagos - setSuccessView("formatoAplicacionDescuentos");
        setSuccessView("registroPoliza/reporteAplicDescGeneradoExitosamente");
        //anterior- ModelAndView mav = new ModelAndView("registroPoliza/reporteAplicDescGeneradoExitosamente");
        setCommandName("datosPoliza");
        setCommandClass(GenerarFormatoAplicDescCommand.class);
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        LOG.info("Redireccionando a vista " + getFormView());
        return super.formBackingObject(request);
    }

    // @RequestMapping(value = "/", method = RequestMethod.POST)
    // public ModelAndView handleRequest(
    // @RequestBody GenerarFormatoAplicDescCommand datosPoliza,
    // HttpServletRequest request) {
    @Override
    protected ModelAndView onSubmit(Object command) {//throws Exception {
        
    	/*
    	 * Del modulo de pagos usaba report1.xml - usar el formato nuevo: formatoAplicacionDescuentos.jasper
    	 
    	GenerarFormatoDescuentoCommand comm;
        comm = (GenerarFormatoDescuentoCommand) command;
        PolizaIndividual poliza;
        poliza = comm.getPolizaIndividual();
        LOG.debug("Poliza: " + poliza);
        ModelAndView mav = new ModelAndView(getSuccessView());
        //mav.addObject("dataSource", descuentoReporte.calcularRegistrosReporteDescuentosAplicados(poliza));
        try {
            // Paso de parametros:
            final Map<String, Object> paramMap =
                    descuentoReporte.findParametrosReporteDescuentos(poliza);
            Set<Entry<String, Object>> paramEntrySet = paramMap.entrySet();
            for (Entry<String, Object> entry : paramEntrySet) {
                mav.addObject(entry.getKey(), entry.getValue());
            }
            
            String rutaReporte = descuentoReporte.generarReporte(poliza);
            mav.addObject("nombreReporte",rutaReporte);
        } catch (DescuentoAplicadoException dae) {
            if ("Se esperaba un solo objeto, se han encontrado 0".equals(dae.getMessage())) {
                String viewName = "registroPoliza/GenerarFormatoAplicacionDescuentos";
                setFormView(viewName);
                mav.setViewName(viewName);
                mav.addObject("errorMsg", "No se ha encontrado la p\u00F3liza.");
                mav.addObject("datosPoliza", new GenerarFormatoDescuentoCommand());
            }
        }
        LOG.info("ViewName: " + mav.getViewName());
        return mav;
        **/
        
        /*
         * Antes de la integración del módulo de pagos
         * usar el formato nuevo: formatoAplicacionDescuentos.jasper
         * **/
        GenerarFormatoAplicDescCommand datosPoliza = (GenerarFormatoAplicDescCommand) command;
        polizaBusiness.generarReportes4(datosPoliza);
        System.out.println("ruta rep descuentos"+polizaBusiness.obtenerReportesGenerados4(datosPoliza).getRutaFormatoAplicacionDescuentos());
        
        ModelAndView mav = new ModelAndView("registroPoliza/reporteAplicDescGeneradoExitosamente");
        
        mav.addObject("ReportesPDF",polizaBusiness.obtenerReportesGenerados4(datosPoliza));
        return mav;
    }

    public void setDescuentoReporte(DescuentoReporte descuentoReporte) {
        this.descuentoReporte = descuentoReporte;
    }
    private DescuentoReporte descuentoReporte;
    private IPolizaBusiness polizaBusiness;
    private static Logger LOG;

    static {
        LOG = LoggerFactory.getLogger(GenerarFormatoAplicDescController.class);
    }
    /*
     * public ModelAndView handleRequest(HttpServletRequest request,
     * HttpServletResponse response) throws Exception { LOG.debug("There!");
     * // RequestUtils.logParameters(request); ModelAndView mav = new
     * ModelAndView(); GenerarFormatoDescuentoCommand datosPoliza;
     * PolizaIndividual poliza; if (request.getParameter("submit") == null) { //
     * Trata el caso de despliegue de formulario. // Proporciona el command a
     * fin de enviar la peticion al server: poliza = new PolizaIndividual();
     * datosPoliza = new GenerarFormatoDescuentoCommand();
     * datosPoliza.setPolizaIndividual(poliza); mav.addObject("datosPoliza",
     * datosPoliza); String viewName; viewName =
     * "registroPoliza/GenerarFormatoAplicacionDescuentos";
     * mav.setViewName(viewName); } else { // Envio del formulario: generacion
     * del reporte datosPoliza = ((GenerarFormatoDescuentoCommand) request
     * .getAttribute("datosPoliza")); poliza =
     * datosPoliza.getPolizaIndividual(); mav = onSubmit(poliza); } return mav;
     * }
     */

	/**
	 * @return the polizaBusiness
	 */
	public IPolizaBusiness getPolizaBusiness() {
		return polizaBusiness;
	}

	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}
}
