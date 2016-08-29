/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao;
import mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza;
import mx.com.seguros.model.ArchivoTramitePoliza;

/**
 * Implementación del DAO para las operaciones sobre la entidad de Archivos de Cambio de Estatus de Pagos de Poliza
 * @author Emigdio Hernández
 *
 */
public class ArchivoCambioEstatusPagosPolizaSqlMapDao extends SqlMapClientDaoSupport implements ArchivoCambioEstatusPagosPolizaDao  {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao#obtenerArchivosCambioEstatusPagosPoliza()
	 */
	@Override
	public List<ArchivoCambioEstatusPagosPoliza> obtenerArchivosCambioEstatusPagosPoliza() {
		return (List<ArchivoCambioEstatusPagosPoliza>)getSqlMapClientTemplate().queryForList("obtenerArchivosCambioEstatusPagosPoliza");
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao#obtenerArchivosCambioEstatusPagosPolizaPorId(java.lang.Integer)
	 */
	@Override
	public ArchivoCambioEstatusPagosPoliza obtenerArchivosCambioEstatusPagosPolizaPorId(Integer idArchivoCambioEstatusPagosPoliza) {
		return (ArchivoCambioEstatusPagosPoliza)getSqlMapClientTemplate().queryForObject("obtenerArchivoCambioEstatusPagosPolizaPorId",idArchivoCambioEstatusPagosPoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao#insertarArchivoCambioEstatusPagosPoliza(mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza)
	 */
	@Override
	public void insertarArchivoCambioEstatusPagosPoliza(ArchivoCambioEstatusPagosPoliza archivoCambioEstatusPagosPoliza) {
		getSqlMapClientTemplate().insert("insertarArchivoCambioEstatusPagosPoliza",archivoCambioEstatusPagosPoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao#actualizarArchivoCambioEstatusPagosPoliza(mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza)
	 */
	@Override
	public void actualizarArchivoCambioEstatusPagosPoliza(ArchivoCambioEstatusPagosPoliza archivoCambioEstatusPagosPoliza) {
		getSqlMapClientTemplate().update("actualizarArchivoCambioEstatusPagosPoliza",archivoCambioEstatusPagosPoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoCambioEstatusPagosPolizaDao#eliminarArchivoCambioEstatusPagosPoliza(java.lang.Integer)
	 */
	@Override
	public void eliminarArchivoCambioEstatusPagosPoliza(Integer idArchivoCambioEstatusPagosPoliza) {
		getSqlMapClientTemplate().update("eliminarArchivoCambioEstatusPagosPoliza",idArchivoCambioEstatusPagosPoliza);

	}

}
