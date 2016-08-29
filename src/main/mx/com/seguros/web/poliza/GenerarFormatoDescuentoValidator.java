/*
 * GenerarFormatoDescuentoValidator.java
 *
 * Created on 30 de enero de 2008, 12:33 PM
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
public class GenerarFormatoDescuentoValidator implements Validator {
    
    /** Creates a new instance of GenerarFormatoDescuentoValidator */
    public GenerarFormatoDescuentoValidator() {
    }
    
    public boolean supports(Class clazz) {
        return GenerarFormatoDescuentoCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
}
