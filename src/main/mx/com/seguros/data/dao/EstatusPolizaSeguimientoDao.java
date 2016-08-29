/*
 * EstatusPolizaPagosDao.java
 *
 * Created on 07 de Abril de 2010, 09:02 AM
*/
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.EstatusPolizaSeguimiento;

/**
 * 
 * @author Cesar Garcia Mauricio
 */
public interface EstatusPolizaSeguimientoDao {
	EstatusPolizaSeguimiento find(Integer id);
	EstatusPolizaSeguimiento findByDescripcion(String descripcion);
	/**
	 * Consulta el catálogo de estados de póliza de seguimiento
	 * @return Lista de estados de póliza
	 */
	List<EstatusPolizaSeguimiento> consultarEstatusPolizaSeguimiento();
}