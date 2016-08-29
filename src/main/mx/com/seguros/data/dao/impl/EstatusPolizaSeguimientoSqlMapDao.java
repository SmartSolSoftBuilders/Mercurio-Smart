/*
 * EstatusPolizaPagosSqlMapDao.java
 *
 * Created on 30 de marzo de 2010, 05:19 AM
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import mx.com.seguros.data.dao.EstatusPolizaSeguimientoDao;
import mx.com.seguros.model.EstatusPolizaSeguimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 
 * @author Cesar Garcia Mauricio
 */
@SuppressWarnings("unchecked")
public class EstatusPolizaSeguimientoSqlMapDao extends SqlMapClientDaoSupport
		implements EstatusPolizaSeguimientoDao {

	public EstatusPolizaSeguimientoSqlMapDao() {
		// logger.debug("Inicializando a " + getClass());
	}

	public EstatusPolizaSeguimiento find(Integer statusId) {
		estatusPolizaSeguimiento = (EstatusPolizaSeguimiento) getSqlMapClientTemplate()
				.queryForObject("obtenEstatusPolizaSeguimientoPorId", statusId);
		logger.debug("estatusPolizaSeguimiento: " + estatusPolizaSeguimiento);
		return estatusPolizaSeguimiento;
	}

	public EstatusPolizaSeguimiento findByDescripcion(
			String descripcion) {
		estatusPolizaSeguimiento = (EstatusPolizaSeguimiento) getSqlMapClientTemplate()
				.queryForObject("obtenEstatusPolizaSeguimientoPorDescripcion",
						descripcion);
		logger.debug("estatusPolizaSeguimiento: " + estatusPolizaSeguimiento);
		return estatusPolizaSeguimiento;
	}

	private EstatusPolizaSeguimiento estatusPolizaSeguimiento;
	private static final Logger logger;

	static {
		logger = LoggerFactory.getLogger(EstatusPolizaSeguimientoSqlMapDao.class);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.EstatusPolizaSeguimientoDao#consultarEstatusPolizaSeguimiento()
	 */
	
	@Override
	public List<EstatusPolizaSeguimiento> consultarEstatusPolizaSeguimiento() {
		return getSqlMapClientTemplate().queryForList("consultarEstatusPolizaSeguimiento");
	}
	
}