/*
 * AutofinanciarPolizaCancelValidator.java
 *
 * Created on 4 de marzo de 2008, 01:12 PM
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
public class AutofinanciarPolizaCancelValidator implements Validator {
    
    /** Creates a new instance of AutofinanciarPolizaCancelValidator */
    public AutofinanciarPolizaCancelValidator() {
    }
    public boolean supports(Class clazz) {
        return AutofinanciarPolizaCancelCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
}
