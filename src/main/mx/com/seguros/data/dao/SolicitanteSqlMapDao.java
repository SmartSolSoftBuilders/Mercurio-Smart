/*
 * SolicitanteSqlMapDap.java
 *
 * Created on 29 de agosto de 2007, 03:05 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Solicitante;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author QTX
 */
public class SolicitanteSqlMapDao extends SqlMapClientDaoSupport implements ISolicitanteDao{
    
    /** Creates a new instance of SolicitanteSqlMapDap */
    public SolicitanteSqlMapDao() {
    }

    public void insertarSolicitanteDao(Solicitante solicitante) {
        getSqlMapClientTemplate().insert("insertarSolicitante",solicitante);
    }
    
    public Solicitante recuperarSolicitantePorRFC(String RFCsolicitante) {
        Solicitante solicitanteExistente = new Solicitante();
        return (Solicitante)this.getSqlMapClientTemplate().queryForObject("recuperarSolicitantePorRFC", RFCsolicitante);
     //    return (String)this.getSqlMapClientTemplate().queryForObject("seleccionarPolizaRFC",RFCasegurado);
    }

    @Override
    public void actualizarSolicitante(Solicitante solicitante) {
        getSqlMapClientTemplate().update("actualizarSolicitante",solicitante);
    }
    
}
