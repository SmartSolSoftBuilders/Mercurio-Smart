/*
 * GenerarEntregaPolizaController.java
 *
 * Created on 16 de enero de 2008, 04:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;
/**
 *
 * @author QTX
 */
public class GenerarEntregaPolizaAdminController extends AbstractWizardFormController {
    private IPolizaBusiness polizaBusiness;
    /** Creates a new instance of GenerarEntregaPolizaController */
    public GenerarEntregaPolizaAdminController() {
        this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroPoliza/entregaPolizasAdmin"});
        setCommandClass(GenerarEntregaPolizaCommand.class);
        setCommandName("datosPoliza");
        setSessionForm(true);
        setValidator(new GenerarEntregaPolizaValidator());
        setValidateOnBinding(false);
    }
    
    protected void validatePage(Object command, Errors errors, int page) {
       /* GenerarEntregaPolizaCommand datosPoliza = (GenerarEntregaPolizaCommand) command;
        GenerarEntregaPolizaValidator validator = (GenerarEntregaPolizaValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosPoliza, errors);
                break;
        }*/
    }
    
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        GenerarEntregaPolizaCommand datosPoliza = (GenerarEntregaPolizaCommand) command;
        String valorCombo=request.getParameter("polizaIndividual.estatusPolizaSeguimiento.idEstatusPolizaSeguimiento").toString();
        datosPoliza.getPolizaIndividual().setIdEstatusPolizaSeguimiento(Integer.parseInt(valorCombo));
        polizaBusiness.generarReportes2(datosPoliza);
        System.out.println("ruta rep polizas"+polizaBusiness.obtenerReportesGenerados2(datosPoliza).getRutaReportePolizasEmitidas());
        request.getSession().setAttribute("ReportesPDF",polizaBusiness.obtenerReportesGenerados2(datosPoliza));
        ModelAndView mav = new ModelAndView("registroPoliza/reporteGeneradoExitosamente");
        //mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }
    
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("generarEntregaPolizaController"));
    }
    
    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }
    
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
}
