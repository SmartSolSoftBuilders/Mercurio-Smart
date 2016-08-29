/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.ArchivoCambioEstatusPagosPoliza;

/**
 * Interfaz para el objeto de acceso a datos para las operaciones sobre la entidad
 * de archivos de cambio de estatus de pagos de p�liza cargados en el sistema
 * @author Emigdio Hernandez
 *
 */
public interface ArchivoCambioEstatusPagosPolizaDao {
	/**
	 * Obtiene todos los registros de los archivos de estatus de pagos de p�liza cargados
	 * en el sistema
	 * Nota este m�todo no retorna el archivo cargado, para obtener el archivo cargado
	 * se debe utilizar el m�todo de consultar por ID el registro de estatus
	 * @return
	 */
	List<ArchivoCambioEstatusPagosPoliza> obtenerArchivosCambioEstatusPagosPoliza();
	/**
	 * Obtiene los datos completos, incluyendo el archivo de un registro
	 * de archivo de estatus de cambio de pagos de p�liza
	 * @return
	 */
	ArchivoCambioEstatusPagosPoliza obtenerArchivosCambioEstatusPagosPolizaPorId(Integer idArchivoCambioEstatusPagosPoliza);
	/**
	 * Inserta un nuevo registro del archivo de cambios de estatus de pago de p�liza
	 * @param archivoCambioEstatusPagosPoliza Datos para insertar
	 */
	void insertarArchivoCambioEstatusPagosPoliza(ArchivoCambioEstatusPagosPoliza archivoCambioEstatusPagosPoliza);
	/**
	 * Actualiza los datos de un registro de archivo de cambios de estatus de pago de p�liza
	 * @param archivoTramitePoliza Datos para la actualizaci�n
	 */
	void actualizarArchivoCambioEstatusPagosPoliza(ArchivoCambioEstatusPagosPoliza archivoCambioEstatusPagosPoliza);
	/**
	 * Eliminar un registor de archiv0 de tr�mites de cambios de estatus de pago de p�liza en base
	 * a su PK
	 * @param idArchivoCambioEstatusPagosPoliza PK a eliminar
	 */
	void eliminarArchivoCambioEstatusPagosPoliza(Integer idArchivoCambioEstatusPagosPoliza);
	
}
