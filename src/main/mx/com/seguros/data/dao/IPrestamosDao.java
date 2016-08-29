/*
 * IPrestamosDao.java
 *
 * Created on 22 de mayo de 2008, 01:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;
import mx.com.seguros.model.PagoPrestamoEmpleado;
import mx.com.seguros.model.PrestamoEmpleado;
import mx.com.seguros.model.BonoExtraEmpleado;
import java.util.List;
/** 
 *
 * @author QTX
 */
public interface IPrestamosDao {
    
    /** Creates a new instance of IPrestamosDao */
    public void insertarPrestamo(PrestamoEmpleado prestamoEmpleado);
    public void insertarBonoExtraEmpleado(BonoExtraEmpleado bonoExtraEmpleado);
    public void insertarNuevoPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl);
    public void actualizaPrestamoEmpleado(PrestamoEmpleado prestEmpl);
    public Object obtenerUltimoPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl);
    
    
     public void actualizaPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl);
}
