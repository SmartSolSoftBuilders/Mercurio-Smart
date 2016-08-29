/*
 * RegistroPrestamosEmpleadoValidator.java
 *
 * Created on 22 de mayo de 2008, 11:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.prestamos;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
/**
 *
 * @author QTX
 */
public class RegistroPrestamosEmpleadoValidator implements Validator{
    
    /** Creates a new instance of RegistroPrestamosEmpleadoValidator */
    public RegistroPrestamosEmpleadoValidator() {
    }
    
    public boolean supports(Class clazz) {
        return RegistroPrestamosEmpleadoCommand.class.isAssignableFrom(clazz);
    }
 
 public void validate(Object target, Errors errors) {
    }
 
 int validatePage0(Object command, Errors errors) {
        RegistroPrestamosEmpleadoCommand prestamos = (RegistroPrestamosEmpleadoCommand)command;
        if(prestamos.getPrestamoEmpleado().getIdPrestamo()==0){
            errors.rejectValue("prestamoEmpleado.idPrestamo","campo-vacio",new Object[]{"El campo Numero de Prestamo"},"Mensaje default");
        }
        if(prestamos.getPrestamoEmpleado().getCondicionPrestamo()==null){
            errors.rejectValue("prestamoEmpleado.condicionPrestamo","campo-vacio",new Object[]{"El area de texto"},"Mensaje default");
        }
        if(prestamos.getPrestamoEmpleado().getTotalPrestamo()==0){
            errors.rejectValue("prestamoEmpleado.totalPrestamo","campo-vacio",new Object[]{"El campo Total del prestamo"},"Mensaje default");
        }
        if(prestamos.getPrestamoEmpleado().getNumPagosTotales()==0){
            errors.rejectValue("prestamoEmpleado.numPagosTotales","campo-vacio",new Object[]{"El campo No. de pagos regulares"},"Mensaje default");
        }
        if(prestamos.getPrestamoEmpleado().getImportePagosRegular()==0){
            errors.rejectValue("prestamoEmpleado.importePagosRegular","campo-vacio",new Object[]{"El campo Importe pago regular"},"Mensaje default");
        }
       
        return 0;
    }
}
