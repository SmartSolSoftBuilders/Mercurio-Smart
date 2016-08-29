/*
 * RegistroPrestamosEmpleadoCommand.java
 *
 * Created on 22 de mayo de 2008, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.bonos;
import mx.com.seguros.model.BonoExtraEmpleado;
/**
 *
 * @author QTX
 */
public class RegistroBonoEmpleadoCommand {
    
    /** Creates a new instance of RegistroPrestamosEmpleadoCommand */
    public RegistroBonoEmpleadoCommand() {
    }
    
    private BonoExtraEmpleado bonoExtraEmpleado=new BonoExtraEmpleado();

    public BonoExtraEmpleado getBonoExtraEmpleado() {
        return bonoExtraEmpleado;
    }

    public void setBonoExtraEmpleado(BonoExtraEmpleado bonoExtraEmpleado) {
        this.bonoExtraEmpleado = bonoExtraEmpleado;
    }

    
}
