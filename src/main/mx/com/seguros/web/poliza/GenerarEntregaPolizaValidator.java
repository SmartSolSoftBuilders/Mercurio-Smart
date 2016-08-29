/*
 * GenerarEntregaPolizaValidator.java
 *
 * Created on 16 de enero de 2008, 04:31 PM
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
 * @author QTX
 */
public class GenerarEntregaPolizaValidator implements Validator {
    
    /** Creates a new instance of GenerarEntregaPolizaValidator */
    public GenerarEntregaPolizaValidator() {
    }
           
 public boolean supports(Class clazz) {
        return GenerarEntregaPolizaCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
 
 /*int validatePage0(Object command, Errors errors) {
        GenerarEntregaPolizaCommand datosPoliza = (GenerarEntregaPolizaCommand) command;
        if(datosPoliza.getPolizaIndividual().getSolicitud().getCveAgente()==0){
            errors.rejectValue("polizaIndividual.solicitud.cveAgente","campo-vacio",new Object[]{"Clave Agente"},"Mensaje default");
        }
        return 0;
    }*/
}
