/*
 * RegistroPrestamosEmpleadoValidator.java
 *
 * Created on 22 de mayo de 2008, 11:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.bonos;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
/**
 *
 * @author QTX
 */
public class RegistroBonoEmpleadoValidator implements Validator{
    
    /** Creates a new instance of RegistroPrestamosEmpleadoValidator */
    public RegistroBonoEmpleadoValidator() {
    }
    
    public boolean supports(Class clazz) {
        return RegistroBonoEmpleadoCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
}
