package mx.com.seguros.web.poliza;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;


public class ConsultaPolizaController extends AbstractWizardFormController {
    private IPolizaBusiness polizaBusiness;
    /** Creates a new instance of ConsultaPolizaController */
    public ConsultaPolizaController() {
    this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroPoliza/Poliza"});
        setCommandClass(ConsultaPolizaCommand.class);
        setCommandName("datosPoliza");
        setSessionForm(true);
        setValidator(new ConsultaPolizaValidator());
        setValidateOnBinding(false);
    }
    
    
    @Override
   protected void validatePage(Object command, Errors errors, int page) {
        /*ConsultaPolizaCommand datosPoliza = (ConsultaPolizaCommand) command;
        ConsultaPolizaValidator validator = (ConsultaPolizaValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosPoliza, errors);
                break;
        }*/
    }
    
    protected ModelAndView cancelarPoliza (HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException)throws Exception {
     ModelAndView mav = new ModelAndView("registroPoliza/polizaCancelada");
     return mav;
    }
    
    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        ConsultaPolizaCommand datosPoliza = (ConsultaPolizaCommand) command;
        polizaBusiness.generarReportes5(datosPoliza);
        System.out.println("ruta rep descuentos"+polizaBusiness.obtenerReportesGenerados5(datosPoliza).getRutaFormatoAplicacionDescuentos2());
        request.getSession().setAttribute("ReportesPDF",polizaBusiness.obtenerReportesGenerados5(datosPoliza));
        ModelAndView mav = new ModelAndView("registroPoliza/reporteAplicDescExitoso");
        //mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }
    
    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("consultaPolizaController"));
    }
    
    
 /*   @Override
   protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("dd/MM/yyyy"), true));
    }*/
    
    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }
    
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
}