/*
 * ConsultaPolizaValidator.java
 *
 * Created on 10 de enero de 2008, 10:29 AM
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
public class ConsultaPolizaValidator implements Validator {
    
    /** Creates a new instance of ConsultaPolizaValidator */
    public ConsultaPolizaValidator() {
    }
    
 public boolean supports(Class clazz) {
        return ConsultaPolizaCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
 
 
}
