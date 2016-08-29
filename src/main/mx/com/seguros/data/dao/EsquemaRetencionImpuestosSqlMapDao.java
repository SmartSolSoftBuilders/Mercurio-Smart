/*
 * EsquemaRetencionImpuestosSqlMapDao.java
 *
 * Created on 18 de junio de 2008, 17:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import java.util.List;
/**
 *
 * @author root
 */
public class EsquemaRetencionImpuestosSqlMapDao  extends SqlMapClientDaoSupport implements IEsquemaRetencionImpuestosDao{
    
    /** Creates a new instance of EsquemaRetencionImpuestosSqlMapDao */
    public EsquemaRetencionImpuestosSqlMapDao() {
    }
    
    public List obtenerListaEsquemasRetencion(){
        return getSqlMapClientTemplate().queryForList("obtenTodosEsquemasRetencion");
    } 
    
}
