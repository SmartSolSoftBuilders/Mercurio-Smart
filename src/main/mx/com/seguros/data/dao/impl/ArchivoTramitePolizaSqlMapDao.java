/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import mx.com.seguros.data.dao.ArchivoTramitePolizaDao;
import mx.com.seguros.model.ArchivoTramitePoliza;

/**
 * Implementación del objeto de acceso a datos para las operaciones
 * sobre la tabla de archivos de trámites de póliza
 * @author Emigdio Hernandez
 *
 */
@SuppressWarnings("unchecked")
public class ArchivoTramitePolizaSqlMapDao extends SqlMapClientDaoSupport implements ArchivoTramitePolizaDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoTramitePolizaDao#obtenerArchivosTramitePoliza()
	 */
	
	@Override
	public List<ArchivoTramitePoliza> obtenerArchivosTramitePoliza() {
		return (List<ArchivoTramitePoliza>)getSqlMapClientTemplate().queryForList("obtenerArchivosTramitePoliza");
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoTramitePolizaDao#obtenerArchivosTramitePolizaPorId(java.lang.Integer)
	 */
	@Override
	public ArchivoTramitePoliza obtenerArchivosTramitePolizaPorId(Integer idArchivoTramitePoliza) {
		return (ArchivoTramitePoliza)getSqlMapClientTemplate().queryForObject("obtenerArchivosTramitePolizaPorId",idArchivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoTramitePolizaDao#insertarArchivoTramitePoliza(mx.com.seguros.model.ArchivoTramitePoliza)
	 */
	@Override
	public void insertarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza) {
		getSqlMapClientTemplate().insert("insertarArchivoTramitePoliza",archivoTramitePoliza);

	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoTramitePolizaDao#actualizarArchivoTramitePoliza(mx.com.seguros.model.ArchivoTramitePoliza)
	 */
	@Override
	public void actualizarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza) {
		getSqlMapClientTemplate().update("actualizarArchivoTramitePoliza",archivoTramitePoliza);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivoTramitePolizaDao#eliminarArchivoTramitePoliza(java.lang.Integer)
	 */
	@Override
	public void eliminarArchivoTramitePoliza(Integer idArchivoTramitePoliza) {
		getSqlMapClientTemplate().update("eliminarArchivoTramitePoliza",idArchivoTramitePoliza);
	}

}
