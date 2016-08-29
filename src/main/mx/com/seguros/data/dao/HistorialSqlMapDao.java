/*
 * HistorialSqlMapDao.java
 *
 * Created on 14 de noviembre de 2008, 05:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.HistorialMovimientosContratante;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author QTX
 */
public class HistorialSqlMapDao extends SqlMapClientDaoSupport implements IHistorialDao{
    
    /** Creates a new instance of HistorialSqlMapDao */
    public HistorialSqlMapDao() {
    }

    public void insertarHistorial(HistorialMovimientosContratante historial) {
        this.getSqlMapClientTemplate().insert("insertarHistorial", historial);
    }
}
