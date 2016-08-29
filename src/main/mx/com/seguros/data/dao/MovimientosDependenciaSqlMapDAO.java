/*
 * MovimientosDependenciaSqlMapDAO.java
 *
 * Created on 31 de octubre de 2008, 04:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.MovimientosDependencia;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author QTX
 */
public class MovimientosDependenciaSqlMapDAO extends SqlMapClientDaoSupport implements IMovimientosDependenciaDAO{
    
    /** Creates a new instance of MovimientosDependenciaSqlMapDAO */
    public MovimientosDependenciaSqlMapDAO() {
    }

    public List obtenerDatosArchivo(MovimientosDependencia movDependencia) {        
        return (List) this.getSqlMapClientTemplate().queryForList("obtenerDatosArchivo",movDependencia);        
    }

    public Object obtenerPolizaConIndicadorEnvioArchivo(HistorialMovimientosContratante historial) {
        return (Object)this.getSqlMapClientTemplate().queryForObject("obtenerPolizaConIndicadorEnvioArchivo",historial);
    }

    public void actualizarIndicadorEnvioArchivo(HistorialMovimientosContratante historialIndicadorEnvio) {
        this.getSqlMapClientTemplate().update("actualizarIndicadorEnvioArchivo",historialIndicadorEnvio);
    }
    
    
    public Integer obtenerContadorPolizaConIndicadorEnvioArchivo(HistorialMovimientosContratante historial) {
        return (Integer)this.getSqlMapClientTemplate().queryForObject("obtenerContadorPolizaConIndicadorEnvioArchivo",historial);
    }
    
}
