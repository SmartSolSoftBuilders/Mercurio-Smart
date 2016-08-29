/*
 * RegistroPrestamosEmpladoController.java
 *
 * Created on 22 de mayo de 2008, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.movimientosdependencia;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.movimientosdependencia.ArchivoTXT;
import mx.com.seguros.business.movimientosdependencia.GenerarArchivoMovDepBusiness;
//import mx.com.seguros.web.prestamos.GenerarArchivoMovimientosDependenciaCommand;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author QTX
 */
public class GenerarArchivoMovimientosDependenciaController extends AbstractWizardFormController{
    private GenerarArchivoMovDepBusiness generarArchivoMovDepBusiness;
    /** Creates a new instance of RegistroPrestamosEmpladoController */
    public GenerarArchivoMovimientosDependenciaController() {
        this.setSupportedMethods(new String[] {METHOD_POST, METHOD_GET});
        setPages(new String[]{"generarArchivoMovimientosDependencia/generarArchivoMovDep",
        "generarArchivoMovimientosDependencia/agregarPersonasArchivo"});
        setCommandClass(GenerarArchivoMovimientosDependenciaCommand.class);
        setCommandName("movimientosDependencia");
        setSessionForm(true);
        //setValidator(new GenerarArchivoMovimientosDependenciaValidator());
        setValidateOnBinding(false);
        
    }
    
    @Override
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
        GenerarArchivoMovimientosDependenciaCommand movimientosDependencia = (GenerarArchivoMovimientosDependenciaCommand) command;
        List listaDatos = generarArchivoMovDepBusiness.obtenerDatosArchivo(movimientosDependencia);
        String nombreArchivo = generarArchivoMovDepBusiness.crearArchivoTXT(listaDatos);
        ArchivoTXT archivoGenerado = new ArchivoTXT();        
        archivoGenerado.setNombre(nombreArchivo);
        movimientosDependencia.setArchivoTXT(archivoGenerado);
        System.out.println("ruta archivo movimientos dependencia "+movimientosDependencia.getArchivoTXT().getNombre());
        request.getSession().setAttribute("ArchivoTXT",movimientosDependencia.getArchivoTXT().getNombre());
        ModelAndView mav = new ModelAndView("generarArchivoMovimientosDependencia/generarArchivoMovDepExitoso");
        //mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }
    
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("registroPrestamosEmpleadoController"));
    }    

    public GenerarArchivoMovDepBusiness getGenerarArchivoMovDepBusiness() {
        return generarArchivoMovDepBusiness;
    }

    public void setGenerarArchivoMovDepBusiness(GenerarArchivoMovDepBusiness generarArchivoMovDepBusiness) {
        this.generarArchivoMovDepBusiness = generarArchivoMovDepBusiness;
    }
    
    
}
