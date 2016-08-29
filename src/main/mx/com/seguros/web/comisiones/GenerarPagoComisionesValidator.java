/*
 * GenerarPagoComisionesValidator.java
 *
 * Created on 13 de marzo de 2008, 09:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.comisiones;
import java.util.Date;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
/**
 *
 * @author QTX
 */
public class GenerarPagoComisionesValidator implements Validator{
    
    /** Creates a new instance of GenerarPagoComisionesValidator */
    public GenerarPagoComisionesValidator() {
    }
    public boolean supports(Class clazz) {
        return GenerarPagoComisionesCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
    
}
