/*
 * CertificadoIndividualSqlMapDao.java
 *
 * Created on 3 de octubre de 2007, 16:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.HashMap;
import java.util.Map;

import mx.com.seguros.dto.SolicitudPKParamDTO;
import mx.com.seguros.model.CertificadoIndividual;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author CGM
 */
public class CertificadoIndividualSqlMapDao extends SqlMapClientDaoSupport implements ICertificadoIndividualDao {
    
    /**
     * Creates a new instance of CertificadoIndividualSqlMapDao
     */
    public CertificadoIndividualSqlMapDao() {
    }
    @Override
    public int recuperarCvePlaza(int folioSolicitud, String formatoSolicitud) {
        return (Integer) getSqlMapClientTemplate().queryForObject("recuperarCvePlaza",new SolicitudPKParamDTO(folioSolicitud,formatoSolicitud));
    }

    public int recuperarUltimoCertificadoPorPlaza(int idPlaza) {
        Object resultado = getSqlMapClientTemplate().queryForObject("recuperarUltimoCertificadoPorPlaza", idPlaza);
        Integer resultado1=(Integer)resultado;
        if(resultado1 != null)
            return resultado1+1;
        else
            return resultado1=1;
    }
    
    public int insertarCertificadoIndividual(CertificadoIndividual certificadoIndividual) {
    	getSqlMapClientTemplate().insert("insertarCertificadoIndividual", certificadoIndividual);
        return certificadoIndividual.getNumCertificado() ;
    }

	@Override
	public CertificadoIndividual consultarCertificadoPorFolio(
			Integer folioSolicitud, String formatoSolicitud) {
		return (CertificadoIndividual)getSqlMapClientTemplate().queryForObject("buscarCertificadoPorFolioSolicitud",
				new SolicitudPKParamDTO(folioSolicitud, formatoSolicitud)
				);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICertificadoIndividualDao#buscarCertificadoPorCertificadoYPlaza(java.lang.Integer, java.lang.String)
	 */
	@Override
	public CertificadoIndividual buscarCertificadoPorCertificadoYPlaza(
			Integer numCertificado, String cvePlaza) {
		Map params = new HashMap();
		params.put("numCertificado", numCertificado);
		params.put("cvePlaza", cvePlaza);
		return (CertificadoIndividual)getSqlMapClientTemplate().queryForObject("buscarCertificadoPorCertificadoYPlaza", params);
	}
    
    
}
