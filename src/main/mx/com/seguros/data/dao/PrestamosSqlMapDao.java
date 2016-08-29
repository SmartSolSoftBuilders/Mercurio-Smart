/*
 * PrestamosSqlMapDao.java
 *
 * Created on 22 de mayo de 2008, 01:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;
import mx.com.seguros.model.PrestamoEmpleado;
import mx.com.seguros.model.PagoPrestamoEmpleado;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import mx.com.seguros.model.BonoExtraEmpleado;
import java.util.List;
/** 
 *
 * @author QTX
 */
public class PrestamosSqlMapDao extends SqlMapClientDaoSupport implements IPrestamosDao{
    
    /** Creates a new instance of PrestamosSqlMapDao */
    public PrestamosSqlMapDao() {
    }
     public void insertarPrestamo(PrestamoEmpleado prestamoEmpleado) {
        this.getSqlMapClientTemplate().insert("insertarPrestamo", prestamoEmpleado);
    }
      
    public void insertarBonoExtraEmpleado(BonoExtraEmpleado bonoExtraEmpleado){
        this.getSqlMapClientTemplate().insert("insertarBonoEmpleado",bonoExtraEmpleado);
    }
    
    public void insertarNuevoPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl){
        this.getSqlMapClientTemplate().insert("insertarNuevoPagoPrestamoEmpleado",pagoPrestEmpl);
    }
    
    public void actualizaPrestamoEmpleado(PrestamoEmpleado prestEmpl){
        this.getSqlMapClientTemplate().update("actualizaPrestamoEmpleado",prestEmpl);
    }
    
     public Object obtenerUltimoPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl){
        return getSqlMapClientTemplate().queryForObject("obtenerUltimoPagoPrestamoEmpleado",pagoPrestEmpl);
    }
     
    
    
    public void actualizaPagoPrestamoEmpleado(PagoPrestamoEmpleado pagoPrestEmpl){
        this.getSqlMapClientTemplate().update("actualizaPagoPrestamoEmpleado",pagoPrestEmpl);
    }
}
