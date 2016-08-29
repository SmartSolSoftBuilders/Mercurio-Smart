/*
 * ContratanteSqlMapDao.java
 *
 * Created on 29 de agosto de 2007, 02:54 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Contratante;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author QTX
 */


public class ContratanteSqlMapDao extends SqlMapClientDaoSupport implements IContratanteDao{
    
    /** Creates a new instance of ContratanteSqlMapDao */
    public ContratanteSqlMapDao() {
    }
    
    public void insertarContratante(Contratante contratante) {
        getSqlMapClientTemplate().insert("insertarContratante", contratante);
    }
    
    public Contratante recuperarContratantePorNumNomina(String numNominaContratante) {
        Object resultado = getSqlMapClientTemplate().queryForObject("recuperarContratantePorNumNomina", numNominaContratante);
        if(resultado != null)
            return (Contratante) resultado;
        else
            return null;
    }
    @Override
    public void actualizarContratante(Contratante contratante) {
        getSqlMapClientTemplate().update("actualizaContratante", contratante);
    }
}
