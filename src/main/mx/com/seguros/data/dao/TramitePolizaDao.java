/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.Date;
import java.util.List;

import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.TipoTramite;
import mx.com.seguros.model.TramitePoliza;

/**
 * Definición de la interfaz del objeto de acceso a datos
 * para las operaciones relacionadas con la bitácora de trámites
 * de póliza
 * @author Emigdio HErnández
 *
 */
public interface TramitePolizaDao {
	/**
	 * Consulta el catálgo de tipos de trámites
	 * @return Los tipos de trámite disponibles en el sistema
	 */
	List<TipoTramite> obtenerCatalogTipoTramite();
	
	/**
	 * Consulta el catálgo de oficinas de estrategas
	 * @return Las oficinas disponibles en el sistema
	 */
	List<Oficina> obtenerCatalogOficinas();
	/**
	 * Obtiene un registro del tipo de trámite por su llave primara
	 * @param idTipoTramite Llave primaria del tipo de trámite a buscar
	 * @return Tipo de Trámite encontrado
	 */
	TipoTramite obtenerTipoTramitePorId(Integer idTipoTramite);
	/**
	 * Consulta la bitácora de trámites relacionados con una póliza ordenados por fecha
	 * @param numPoliza Criterio de búsqueda
	 * @param numConsignatario Criterio de búqueda
	 * @return Lista de trámites relacionados a una póliza
	 */
	List<TramitePoliza> obtenerTramitesDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Inserta en la base de datos un nuevo registro de trámite póliza con los datos
	 * enviados como parámetro.
	 * @param tramite Datos del trámite
	 */
	void insertarTramitePoliza(TramitePoliza tramite);
	/**
	 * Consulta la bitácora de trámites relacionados con una póliza ordenados por fecha
	 * @param fechaInicial Criterio de búsqueda
	 * @param fechaFinal Criterio de búqueda
	 * @return idOficina de trámites relacionados a una póliza
	 */
	List<TramitePoliza> obtenerTramitesDePoliza(Date fechaInicial, Date fechaFinal, Integer idOficina);
}
