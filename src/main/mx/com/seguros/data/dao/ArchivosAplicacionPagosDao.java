/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaArchivosAplicacionCargadosDTO;
import mx.com.seguros.model.ArchivosAplicacionCargados;

/**
 * Interfaz del Objeto de Acceso a Datos para la consulta, registro y modificación
 * del registro de los archivos de aplicación cargados
 * @author Emigdio Hernandez
 *
 */
public interface ArchivosAplicacionPagosDao {
	/**
	 * Consulta un conjunto de archivos de aplicación cargados en base a los criterios
	 * enviados como parámetro
	 * @param criterios Conjunto de criterios a tomar en cuenta
	 * @return Lista de los registros obtenidos
	 */
	List<ArchivosAplicacionCargados> findArchivosAplicacionCargados(CriteriosConsultaArchivosAplicacionCargadosDTO criterios);
	/**
	 * Inserta un nuevo registro en la tabla de Archivos de Aplicacion Cargados
	 * @param archivo Datos de origen del archivo
	 */
	void insertarArchivoAplicacion(ArchivosAplicacionCargados archivo);
	/**
	 * Consulta de forma completa un registro de archivo de aplicación cargado
	 * de la BD
	 * @param idArchivo Identificador del registro
	 * @return Resultado, null en caso de no econtrarlo
	 */
	ArchivosAplicacionCargados findArchivoAplicacionCargadosPorId(Long idArchivo);
	/**
	 * Actualiza los datos de nombre del archivo, fecha de hora de inicio y fin y 
	 * log de la carga
	 * @param archivo
	 */
	void actualizarArchivoAplicacion(ArchivosAplicacionCargados archivo);
	/**
	 * Elimina el registro de la BD del archivo de aplicación indicado por el parámetro
	 * @param idArchivosAplicacionCargados
	 */
	void eliminarArchivoAplicacion(Long idArchivosAplicacionCargados);

}
