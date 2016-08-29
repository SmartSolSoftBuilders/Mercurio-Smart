/*
 * HelperDaoIbatisImpl.java
 *
 * Created on 23 de agosto de 2007, 11:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package qtx.component.front.helper.data.ibatis;

import java.util.HashMap;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import qtx.component.front.helper.data.HelperDao;

/**
 *
 * @author QTX
 */
public class HelperDaoIbatisImpl extends SqlMapClientDaoSupport implements HelperDao{
    
    /** Creates a new instance of HelperDaoIbatisImpl */
    public HelperDaoIbatisImpl() {
    }

    public List getData(String id) {
        return getSqlMapClientTemplate().queryForList(id);
    }

    public List getData(String id, Object parametros) {
        
        return getSqlMapClientTemplate().queryForList(id, parametros);
    }

    public List getData(String id, HashMap parametros) {
        return getSqlMapClientTemplate().queryForList(id, parametros);
    }
    
}
