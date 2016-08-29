/*
 * EstatusPolizaPagosSqlMapDao.java
 *
 * Created on 30 de marzo de 2010, 05:19 AM
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import mx.com.seguros.data.dao.EstatusPolizaPagosDao;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.PolizaIndividual;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 
 * @author Cesar Garcia Mauricio
 */
public class EstatusPolizaPagosSqlMapDao extends SqlMapClientDaoSupport
        implements EstatusPolizaPagosDao {

    @Override
    public EstatusPolizaPagos obtenerEstatusPolizaPagosById(int statusId) {
        return (EstatusPolizaPagos) getSqlMapClientTemplate().queryForObject(
                "obtenEstatusPolizaPagosPorId", statusId);
    }

    @Override
    public EstatusPolizaPagos obtenerEstatusPolizaPagosByDescripcion(
            String descripcion) {
        return (EstatusPolizaPagos) getSqlMapClientTemplate().queryForObject(
                "obtenEstatusPolizaPagosPorDescripcion", descripcion);
    }

    @Override
    public Integer obtenerEstatusPolizaPagosByPoliza(PolizaIndividual poliza) {
    Integer idEstatusPagosPolizaConsultada = (Integer) getSqlMapClientTemplate().queryForObject("obtenerEstatusPolizaPagosByPoliza", poliza);
    return idEstatusPagosPolizaConsultada;
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.EstatusPolizaPagosDao#consultarEstatusPolizaPagos()
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<EstatusPolizaPagos> consultarEstatusPolizaPagos() {
		return getSqlMapClientTemplate().queryForList("consultarEstatusPolizaPagos");
	}

}
