/*
 * RegistroPolizaController.java
 *
 * Created on 24 de septiembre de 2007, 07:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.web.poliza;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;

public class RegistroPolizaController extends AbstractWizardFormController {

    private IPolizaBusiness polizaBusiness;

    
    
    public RegistroPolizaController() {
        this.setSupportedMethods(new String[]{METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroPoliza/w01_ParamConsultaSolicitudesSeguroCapturadas",
                    "registroPoliza/w02_RegistroPolizasSeguroEmitidas"});
        setCommandClass(RegistroPolizaCommand.class);
        
        setCommandName("datosPoliza");
        setSessionForm(true);
        setValidator(new RegistroPolizaValidator());
        setValidateOnBinding(false);
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

       RegistroPolizaCommand cmd = new RegistroPolizaCommand();
        
       List <BeneficioAdicional> beneficios = polizaBusiness.consultarCatalogoBeneficiosAdicionales();
       
       cmd.setBeneficiosPoliza(new BeneficioAdicionalPoliza[beneficios.size()]);
       int i=0;
       for(BeneficioAdicional beneficio:beneficios){
    	   cmd.getBeneficiosPoliza()[i] = new BeneficioAdicionalPoliza();
    	   cmd.getBeneficiosPoliza()[i].setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
    	   cmd.getBeneficiosPoliza()[i].setDescripcionBeneficio(beneficio.getDescripcionBeneficioAdicional());
    	   i++;
       }

              
         

        return cmd;

    }
    
    @Override
    protected void validatePage(Object command, Errors errors, int page) {
        RegistroPolizaCommand datosPoliza = (RegistroPolizaCommand) command;
        RegistroPolizaValidator validator = (RegistroPolizaValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosPoliza, errors);
                break;
            case 1:
                validator.validatePage1(datosPoliza, errors);
                break;
        }
    }

    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        RegistroPolizaCommand datosPoliza = (RegistroPolizaCommand) command;
        
        polizaBusiness.registrarPolizaCompleto(datosPoliza);
        polizaBusiness.generarReportes(datosPoliza);
       
        //System.out.println("ruta rep cert" + polizaBusiness.obtenerReportesGenerados(datosPoliza).getRutaReporteCertInd());
        System.out.println("ruta rep carta" + polizaBusiness.obtenerReportesGenerados(datosPoliza).getRutaReporteCartaResumen());
        System.out.println("ruta rep acuse" + polizaBusiness.obtenerReportesGenerados(datosPoliza).getRutaReporteAcuseRecibo());
        request.getSession().setAttribute("ReportesPDF", polizaBusiness.obtenerReportesGenerados(datosPoliza));
        ModelAndView mav = new ModelAndView("registroPoliza/registroPolizaExitoso");
        mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }

    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("registroPolizaController"));
    }

    @Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
}