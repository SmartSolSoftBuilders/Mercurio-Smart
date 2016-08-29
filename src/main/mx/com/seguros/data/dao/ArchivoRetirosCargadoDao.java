/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivoRetirosCargado;

/**
 * Interfaz del Objeto de Acceso a Datos para la consulta, registro y modificación
 * de los archivos cargados de trámite de retiros
 * @author Emigdio Hernandez
 *
 */
public interface ArchivoRetirosCargadoDao {
	/**
	 * Consulta un conjunto de archivos de aplicación cargados en base a los criterios
	 * enviados como parámetro
	 * @param criterios Conjunto de criterios a tomar en cuenta
	 * @return Lista de los registros obtenidos
	 */
	List<ArchivoRetirosCargado> findArchivosAplicacionCargados(CriteriosConsultaArchivosAplicacionCargadosDTO criterios);
	/**
	 * Inserta un nuevo registro en la tabla de Archivos de Retiros Cargados
	 * @param archivo Datos de origen del archivo
	 */
	void insertarArchivoRetiros(ArchivoRetirosCargado archivo);
	/**
	 * Consulta de forma completa un registro de archivo de retiros cargado
	 * de la BD
	 * @param idArchivo Identificador del registro
	 * @return Resultado, null en caso de no econtrarlo
	 */
	ArchivoRetirosCargado findArchivoRetirosCargadoPorId(Long idArchivo);
	/**
	 * Actualiza los datos de nombre del archivo, fecha de hora de inicio y fin y 
	 * log de la carga
	 * @param archivo
	 */
	void actualizarArchivoRetiros(ArchivoRetirosCargado archivo);
	/**
	 * Elimina el registro de la BD del archivo de aplicación indicado por el parámetro
	 * @param idArchivo ID a eliminar
	 */
	void eliminarArchivoRetiros(Long idArchivo);


}
