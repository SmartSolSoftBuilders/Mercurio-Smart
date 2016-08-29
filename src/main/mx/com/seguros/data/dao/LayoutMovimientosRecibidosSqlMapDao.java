/*
 * LayoutMovimientosRecibidosSqlMapDao.java
 *
 * Created on 14 de noviembre de 2008, 04:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.List;
import mx.com.seguros.model.LayoutMovimientosRecibidos;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author QTX
 */
public class LayoutMovimientosRecibidosSqlMapDao extends SqlMapClientDaoSupport implements ILayoutMovimientosRecibidosDao{
    
    /** Creates a new instance of LayoutMovimientosRecibidosSqlMapDao */
    public LayoutMovimientosRecibidosSqlMapDao() {
    }

    public void insertarLayoutMovimientosRecibidos(LayoutMovimientosRecibidos layout) {
        this.getSqlMapClientTemplate().insert("insertarLayoutMovimientosRecibidos",layout);
    }

    public List obtenerDatosLista() {
        return (List)this.getSqlMapClientTemplate().queryForList("obtenerDatosLista");
    }

    public void eliminarRegistrosListaColumnas() {
        this.getSqlMapClientTemplate().delete("eliminarRegistrosListaColumnas");
    }

    public String obtenerSiglasRetenedor(String cveDescuento) {
        return(String)this.getSqlMapClientTemplate().queryForObject("obtenerSiglasRetenedor",cveDescuento);
    }
    
}
