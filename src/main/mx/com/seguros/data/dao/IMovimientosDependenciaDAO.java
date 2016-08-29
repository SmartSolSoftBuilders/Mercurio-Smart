/*
 * IPrestamosDao.java
 *
 * Created on 22 de mayo de 2008, 01:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;
import java.util.List;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.MovimientosDependencia;
/** 
 *
 * @author QTX
 */
public interface IMovimientosDependenciaDAO {
    
    /** Creates a new instance of IMovimientosDependenciaDAO */
    public List obtenerDatosArchivo(MovimientosDependencia movDependencia);
    public Object obtenerPolizaConIndicadorEnvioArchivo(HistorialMovimientosContratante historial);
    public Integer obtenerContadorPolizaConIndicadorEnvioArchivo(HistorialMovimientosContratante historial);
    public void actualizarIndicadorEnvioArchivo(HistorialMovimientosContratante historialIndicadorEnvio);
}
