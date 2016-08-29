/*
 * RegistroPrestamosEmpleadoCommand.java
 *
 * Created on 22 de mayo de 2008, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.prestamos;
import mx.com.seguros.model.PrestamoEmpleado;
/**
 *
 * @author QTX
 */
public class RegistroPrestamosEmpleadoCommand {
    
    /** Creates a new instance of RegistroPrestamosEmpleadoCommand */
    public RegistroPrestamosEmpleadoCommand() {
    }
    
    private PrestamoEmpleado prestamoEmpleado=new PrestamoEmpleado();

    public PrestamoEmpleado getPrestamoEmpleado() {
        return prestamoEmpleado;
    }

    public void setPrestamoEmpleado(PrestamoEmpleado prestamoEmpleado) {
        this.prestamoEmpleado = prestamoEmpleado;
    }
}
