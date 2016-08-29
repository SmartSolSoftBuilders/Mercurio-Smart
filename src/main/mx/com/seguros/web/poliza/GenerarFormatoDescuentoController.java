/*
 * GenerarFormatoDescuentoController.java
 *
 * Created on 30 de enero de 2008, 12:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.reporte.ReportesPDF;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author QTX
 */
public class GenerarFormatoDescuentoController extends AbstractWizardFormController{
    private IPolizaBusiness polizaBusiness;
    /** Creates a new instance of GenerarFormatoDescuentoController */
    public GenerarFormatoDescuentoController() {
        this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroPoliza/GenerarFormatoDescuentoAsegurados"});
        setCommandClass(GenerarFormatoDescuentoCommand.class);
        setCommandName("datosPoliza");
        setSessionForm(true);
        setValidator(new GenerarFormatoDescuentoValidator());
        setValidateOnBinding(false);
    }
    
    @Override
    protected void validatePage(Object command, Errors errors, int page) {
       /* GenerarEntregaPolizaCommand datosPoliza = (GenerarEntregaPolizaCommand) command;
        GenerarEntregaPolizaValidator validator = (GenerarEntregaPolizaValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosPoliza, errors);
                break;
        }*/
    }
    
    @Override
     protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        GenerarFormatoDescuentoCommand datosPoliza = (GenerarFormatoDescuentoCommand) command;
        String numQuincena=request.getParameter("polizaIndividual.numQuincena");
        datosPoliza.getPolizaIndividual().setNumQuincena(Integer.parseInt(numQuincena));
        String anoQuincena=request.getParameter("polizaIndividual.anoQuincena").toString();
        datosPoliza.getPolizaIndividual().setAnoQuincena(Integer.parseInt(anoQuincena));
        polizaBusiness.generarReportes3(datosPoliza);
        final ReportesPDF reportePDF = polizaBusiness.obtenerReportesGenerados3(datosPoliza);
        logger.debug("RutaFormatoDescuentoAsegurados: " + reportePDF.getRutaFormatoDescuentoAsegurados());
        request.getSession().setAttribute("ReportesPDF", reportePDF);
        ModelAndView mav = new ModelAndView("registroPoliza/reporteDescuentoGeneradoExitosamente");
        //mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }
     
    @Override
      protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("generarFormatoDescuentoController"));
    }
      
       public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }
    
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
    
}
