/*
 * CancelarPolizaValidator.java
 *
 * Created on 11 de febrero de 2008, 10:01 AM
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
public class CancelarPolizaValidator implements Validator {
    
    /** Creates a new instance of CancelarPolizaValidator */
    public CancelarPolizaValidator() {
    }
    
    public boolean supports(Class clazz) {
        return CancelarPolizaCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
    
}
