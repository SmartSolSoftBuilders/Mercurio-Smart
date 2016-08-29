/*
 * RegistroBonoEmpleadoController.java
 *
 * Created on 23 de mayo de 2008, 09:39 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.bonos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;
import mx.com.seguros.business.prestamos.IPrestamosBusiness;
/**
 *
 * @author QTX
 */
public class RegistroBonoEmpleadoController extends AbstractWizardFormController{
    private IPrestamosBusiness prestamosBusiness;
    /** Creates a new instance of RegistroBonoEmpleadoController */
    public RegistroBonoEmpleadoController() {
        this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroBonosEmpleados/registroBonosEmpleados"});
        setCommandClass(RegistroBonoEmpleadoCommand.class);
        setCommandName("bonos");
        setSessionForm(true);
        setValidator(new RegistroBonoEmpleadoValidator());
        setValidateOnBinding(false);
    }
    
    protected void validatePage(Object command, Errors errors, int page) {
       /* ConsultaPolizaCommand datosPoliza = (ConsultaPolizaCommand) command;
        ConsultaPolizaValidator validator = (ConsultaPolizaValidator) getValidator();
        switch (page) {
            case 0:
                validator.validatePage0(datosPoliza, errors);
                break;
            }*/
    }
    
      protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        RegistroBonoEmpleadoCommand bonos = (RegistroBonoEmpleadoCommand) command;
        prestamosBusiness.registrarBono(bonos);
        ModelAndView mav = new ModelAndView("registroBonosEmpleados/registroBonoExitoso");
        //mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }
    
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("registroBonosEmpleadoController"));
    }

    public IPrestamosBusiness getPrestamosBusiness() {
        return prestamosBusiness;
    }

    public void setPrestamosBusiness(IPrestamosBusiness prestamosBusiness) {
        this.prestamosBusiness = prestamosBusiness;
    }
    
}
