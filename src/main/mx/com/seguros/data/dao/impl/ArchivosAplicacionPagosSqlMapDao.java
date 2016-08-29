/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import mx.com.seguros.data.dao.ArchivosAplicacionPagosDao;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivosAplicacionCargados;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del objeto de acceso a datos para la manipulación de registros
 * de los archivos de aplicación cargados
 * @author Emigdio Hernandez
 *
 */
public class ArchivosAplicacionPagosSqlMapDao extends SqlMapClientDaoSupport implements ArchivosAplicacionPagosDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#findArchivosAplicacionCargados(mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ArchivosAplicacionCargados> findArchivosAplicacionCargados(CriteriosConsultaArchivosAplicacionCargadosDTO criterios) {
		return (List<ArchivosAplicacionCargados>)getSqlMapClientTemplate().queryForList("findArchivosAplicacionCargados",criterios);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#insertarArchivoAplicacion(mx.com.seguros.model.ArchivosAplicacionCargados)
	 */
	@Override
	public void insertarArchivoAplicacion(ArchivosAplicacionCargados archivo) {
		getSqlMapClientTemplate().insert("insertarArchivoAplicacion", archivo);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#findArchivoAplicacionCargadosPorId(java.lang.Long)
	 */
	@Override
	public ArchivosAplicacionCargados findArchivoAplicacionCargadosPorId(Long idArchivo) {
		return  (ArchivosAplicacionCargados)getSqlMapClientTemplate().queryForObject("findArchivosAplicacionCargadosPorId",idArchivo);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#actualizarArchivoAplicacion(mx.com.seguros.model.ArchivosAplicacionCargados)
	 */
	@Override
	public void actualizarArchivoAplicacion(ArchivosAplicacionCargados archivo) {
		getSqlMapClientTemplate().update("actualizarArchivoAplicacion", archivo);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#eliminarArchivoAplicacion(java.lang.Long)
	 */
	@Override
	public void eliminarArchivoAplicacion(Long idArchivosAplicacionCargados) {
		getSqlMapClientTemplate().delete("eliminarArchivoAplicacion",idArchivosAplicacionCargados);		
	}

}
