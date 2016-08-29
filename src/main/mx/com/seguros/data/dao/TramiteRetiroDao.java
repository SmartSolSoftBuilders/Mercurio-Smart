/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.TramiteRetiro;

/**
 * Interfaz del objeto de acceso a datos para la manipulación
 * de los registors de trámites de retiros realizados por asegurados
 * @author Emigdio Hernández
 *
 */
public interface TramiteRetiroDao {
	/**
	 * Inserta un nuevo registro de trámite de retiro en la BD
	 * @param tramite
	 */
	void insertarTramiteRetiro(TramiteRetiro tramite);
	/**
	 * Consulta la lista de trámites de retiro asociados a un asegurado en específico
	 * @param numNominaContratante
	 * @return
	 */
	List<TramiteRetiro> consultarTramitesRetiroPorAsegurado(Integer numPoliza, Integer numConsignatario);
}
