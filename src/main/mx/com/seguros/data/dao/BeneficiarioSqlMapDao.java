/*
 * BeneficiarioSqlMapDao.java
 *
 * Created on 29 de agosto de 2007, 03:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.model.Beneficiario;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 *
 * @author QTX
 */
public class BeneficiarioSqlMapDao extends SqlMapClientDaoSupport implements IBeneficiarioDao{
    
    /** Creates a new instance of BeneficiarioSqlMapDao */
    public BeneficiarioSqlMapDao() {
    }

    public void insertarBeneficiario(Beneficiario beneficiario) {
       getSqlMapClientTemplate().insert("insertarBeneficiario", beneficiario);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IBeneficiarioDao#eliminarBeneficiariosSolicitud(java.lang.Integer, java.lang.String)
     */
	@Override
	public void eliminarBeneficiariosSolicitud(Integer folioSolicitud,
			String formatoSolicitud) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("folioSolicitud", folioSolicitud);
		params.put("formatoSolicitud", formatoSolicitud);
		getSqlMapClientTemplate().delete("eliminarBeneficiariosSolicitud",params);
		
	}
    
}
