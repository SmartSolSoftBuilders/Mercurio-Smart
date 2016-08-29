/*
 * RegistroPolizaValidator.java
 *
 * Created on 25 de septiembre de 2007, 10:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;
import java.util.Date;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
/**
 *
 * @author Cesar
 */
public class RegistroPolizaValidator implements Validator{
    
    /** Creates a new instance of RegistroPolizaValidator */
    public RegistroPolizaValidator() {
    }
    
    public boolean supports(Class clazz) {
        return RegistroPolizaCommand.class.isAssignableFrom(clazz);
    }
    
    public void validate(Object target, Errors errors) {
    }

    int validatePage0(Object command, Errors errors) {
        RegistroPolizaCommand datosPoliza = (RegistroPolizaCommand)command;
        if(datosPoliza.getPolizaIndividual().getSolicitud().getFolioSolicitud()==0){
            errors.rejectValue("polizaIndividual.solicitud.folioSolicitud","campo-vacio",new Object[]{"Folio Solicitud"},"Mensaje default");
        }
        return 0;
    }

    int validatePage1(Object command, Errors errors) {
        RegistroPolizaCommand datosPoliza = (RegistroPolizaCommand)command;
        if(datosPoliza.getPolizaIndividual().getNumConsignatario()==0){
            errors.rejectValue("polizaIndividual.numConsignatario","campo-vacio",new Object[]{"El campo Numero de Consignatario"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getNumPoliza()==0){
            errors.rejectValue("polizaIndividual.numPoliza","campo-vacio",new Object[]{"El campo Numero de Póliza"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getFechaExpedicion()==null||datosPoliza.getPolizaIndividual().getFechaExpedicion().toString()==""){
            errors.rejectValue("polizaIndividual.fechaExpedicion","campo-vacio",new Object[]{"El campo Fecha de expedición"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getFechaInicioVigencia()==null){
            errors.rejectValue("polizaIndividual.fechaInicioVigencia","campo-vacio",new Object[]{"El campo Fecha Inicio de vigencia"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getFechaFinVigencia()==null){
            errors.rejectValue("polizaIndividual.fechaFinVigencia","campo-vacio",new Object[]{"El campo Fecha Fin de vigencia"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getTipoSeguro()==""){
            errors.rejectValue("polizaIndividual.tipoSeguro","campo-vacio",new Object[]{"El campo Tipo de seguro"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getSumaAseguradaIndividual()==0){
            errors.rejectValue("polizaIndividual.sumaAseguradaIndividual","campo-vacio",new Object[]{"El campo Suma asegurada individual"},"Mensaje default");
        }
        return 0;
    }
}
