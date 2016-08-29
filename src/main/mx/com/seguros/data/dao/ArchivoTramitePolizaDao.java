/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.ArchivoTramitePoliza;

/**
 * Interfaz para el objeto de acceso a datos para las operaciones sobre la entidad
 * de archivos de trámites de póliza cargados en el sistema
 * @author Emigdio Hernandez
 *
 */
public interface ArchivoTramitePolizaDao {
	/**
	 * Obtiene todos los registros de los archivos de trámite de póliza cargados
	 * en el sistema
	 * Nota este método no retorna el archivo cargado, para obtener el archivo cargado
	 * se debe utilizar el método de consultar por ID nu registro de ArchivoTramitePoliza
	 * @return
	 */
	List<ArchivoTramitePoliza> obtenerArchivosTramitePoliza();
	/**
	 * Obtiene los datos completos, incluyendo el archivo de un registro
	 * de archivo de trámtes de póliza
	 * @return
	 */
	ArchivoTramitePoliza obtenerArchivosTramitePolizaPorId(Integer idArchivoTramitePoliza);
	/**
	 * Inserta un nuevo registro del archivo de trámites de póliza cargdos en el sistema
	 * @param archivoTramitePoliza Datos para insertar
	 */
	void insertarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza);
	/**
	 * Actualiza los datos de un registro de archivo de trámites de póliza existente
	 * @param archivoTramitePoliza Datos para la actualización
	 */
	void actualizarArchivoTramitePoliza(ArchivoTramitePoliza archivoTramitePoliza);
	/**
	 * Eliminar un registor de archivi de trámites de póliza en base 
	 * a su PK
	 * @param idArchivoTramitePoliza PK a eliminar
	 */
	void eliminarArchivoTramitePoliza(Integer idArchivoTramitePoliza);
	
}
