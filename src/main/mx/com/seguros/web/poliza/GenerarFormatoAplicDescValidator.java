/*
 * GenerarFormatoAplicDescValidator.java
 *
 * Created on 7 de febrero de 2008, 11:25 AM
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
public class GenerarFormatoAplicDescValidator implements Validator{
    
    /** Creates a new instance of GenerarFormatoAplicDescValidator */
    public GenerarFormatoAplicDescValidator() {
    }
    
     public boolean supports(Class clazz) {
        return GenerarFormatoAplicDescCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
    
}
