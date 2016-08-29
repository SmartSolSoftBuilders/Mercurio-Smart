/*
 * RegistroPrestamosEmpladoController.java
 *
 * Created on 22 de mayo de 2008, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.movimientosdependencia;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.movimientosdependencia.GenerarArchivoMovDepBusiness;
import mx.com.seguros.business.movimientosdependencia.GenerarArchivoPagosRetenedorBusiness;
import mx.com.seguros.business.movimientosdependencia.IGenerarArchivoMovDepBusiness;
//import mx.com.seguros.web.prestamos.GenerarArchivoMovimientosDependenciaCommand;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author QTX
 */
public class GenerarArchivoPagosRetenedorController extends AbstractWizardFormController{
    private GenerarArchivoPagosRetenedorBusiness generarArchivoPagosRetenedorBusiness;
    /** Creates a new instance of RegistroPrestamosEmpladoController */
    public GenerarArchivoPagosRetenedorController() {
        this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"generarArchivoPagosRetenedor/generarArchivoPagosRetenedor"});
        setCommandClass(GenerarArchivoPagosRetenedorCommand.class);
        setCommandName("generarArchivoPagosRetenedor");
        setSessionForm(true);
        //setValidator(new GenerarArchivoMovimientosDependenciaValidator());
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
        GenerarArchivoPagosRetenedorCommand generarArchivoPagosRetenedor = (GenerarArchivoPagosRetenedorCommand) command;        
        
        if(generarArchivoPagosRetenedor.getFile() != null && !generarArchivoPagosRetenedor.getFile().isEmpty()){
        	generarArchivoPagosRetenedorBusiness.leerArchivoPagoRetenedores(generarArchivoPagosRetenedor.getFile().getInputStream());
        }
        
        //generarArchivoPagosRetenedor = generarArchivoPagosRetenedorBusiness.generarArchivoPagosRetenedor(generarArchivoPagosRetenedor);
        ModelAndView mav = new ModelAndView("generarArchivoPagosDependencia/generarArchivoPagDepExitoso");
        //mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }
    
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("registroPrestamosEmpleadoController"));
    }    

    public GenerarArchivoPagosRetenedorBusiness getGenerarArchivoPagosRetenedorBusiness() {
        return generarArchivoPagosRetenedorBusiness;
    }

    public void setGenerarArchivoPagosRetenedorBusiness(GenerarArchivoPagosRetenedorBusiness generarArchivoPagosRetenedorBusiness) {
        this.generarArchivoPagosRetenedorBusiness = generarArchivoPagosRetenedorBusiness;
    }
    
    
}
