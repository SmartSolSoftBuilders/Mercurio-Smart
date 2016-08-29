/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.List;

import mx.com.seguros.data.dao.ArchivoRetirosCargadoDao;
import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivoRetirosCargado;
import mx.com.seguros.model.ArchivosAplicacionCargados;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del objeto de acceso a datos para la manipulación de registros
 * de los archivos de retiros cargados
 * @author Emigdio Hernandez
 *
 */
public class ArchivoRetirosCargadoSqlMapDao extends SqlMapClientDaoSupport implements ArchivoRetirosCargadoDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#findArchivosAplicacionCargados(mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ArchivoRetirosCargado> findArchivosAplicacionCargados(CriteriosConsultaArchivosAplicacionCargadosDTO criterios) {
		return (List<ArchivoRetirosCargado>)getSqlMapClientTemplate().queryForList("obtenerArchivosRetiros",criterios);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#insertarArchivoAplicacion(mx.com.seguros.model.ArchivosAplicacionCargados)
	 */
	@Override
	public void insertarArchivoRetiros(ArchivoRetirosCargado archivo) {
		getSqlMapClientTemplate().insert("insertarArchivoRetiros", archivo);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#findArchivoAplicacionCargadosPorId(java.lang.Long)
	 */
	@Override
	public ArchivoRetirosCargado findArchivoRetirosCargadoPorId(Long idArchivo) {
		return  (ArchivoRetirosCargado)getSqlMapClientTemplate().queryForObject("obtenerArchivosRetirosPorId",idArchivo);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#actualizarArchivoAplicacion(mx.com.seguros.model.ArchivosAplicacionCargados)
	 */
	@Override
	public void actualizarArchivoRetiros(ArchivoRetirosCargado archivo) {
		getSqlMapClientTemplate().update("actualizarArchivoRetiros", archivo);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ArchivosAplicacionPagosDao#eliminarArchivoAplicacion(java.lang.Long)
	 */
	@Override
	public void eliminarArchivoRetiros(Long idArchivo) {
		getSqlMapClientTemplate().delete("eliminarArchivoRetiros",idArchivo);		
	}

}
