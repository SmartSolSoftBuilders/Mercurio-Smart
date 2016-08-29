/*
 * IPrestamosBusiness.java
 *
 * Created on 22 de mayo de 2008, 01:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.prestamos;
import mx.com.seguros.data.dao.IPrestamosDao;
 import mx.com.seguros.model.PrestamoEmpleado;
 import mx.com.seguros.model.Empleado;
 import mx.com.seguros.web.prestamos.RegistroPrestamosEmpleadoCommand;
 import mx.com.seguros.web.bonos.RegistroBonoEmpleadoCommand;
 import mx.com.seguros.model.BonoExtraEmpleado;
/**
 *
 * @author QTX
 */
public interface IPrestamosBusiness {
    
    /** Creates a new instance of IPrestamosBusiness */
    void registrarPrestamo(RegistroPrestamosEmpleadoCommand prestamos);
    void registrarBono(RegistroBonoEmpleadoCommand bonos);
}
