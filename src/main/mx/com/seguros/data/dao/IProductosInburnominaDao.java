/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.model.HistoricoProductosInburnomina;
import mx.com.seguros.model.ProductosInburnomina;

/**
 * Interfaz del DAO para la administración de los productos inburnómina de 
 * un seguro de vida
 * @author Emigdio Hernandez
 *
 */
public interface IProductosInburnominaDao {
	/**
	 * Inserta un nuevo registro de los prodcutos inburnómina de una póliza
	 * de seguro de vida
	 * @param datos Datos a insertar
	 */
	void insertarProductosInburnomina(ProductosInburnomina datos);
	/**
	 * Actualiza los datos de un registro de procutos inburnomina de una póliza
	 * de seguro de vida
	 * @param datos Datos a actualizar
	 */
	void actualizarProductosInburnomina(ProductosInburnomina datos);
	/**
	 * Inserta un nuevo registro del histórico de productos inburnomina
	 * @param historicoDatos
	 * @return Identificador generado por la operación de inserción
	 */
	Integer insertarHistoricoProductosInburnomina(HistoricoProductosInburnomina historicoDatos);
	/**
	 * Consulta el registro de detalle de productos inburnomina de una poliza de vida, null en caso
	 * de que no existe tovadía el registro
	 * @param numPoliza Poliza buscada
	 * @param numConsignatario Poliza buscada
	 * @return Datos del registro, null si no existe
	 */
	ProductosInburnomina consultarProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Verifica si existen los datos de detalle de productos inburnomina para cierta poliza
	 * @param numPoliza Poliza a buscar
	 * @param numConsignatario Poliza a buscar
	 * @return true si existe, false en otro caso
	 */
	boolean eixsteProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Obtiene el listado de los registros históricos de los productos inburnomina de una póliza
	 * @param numPoliza Número de Póliza a buscar
	 * @param numConsignatario Número de consignatario
	 * @return Lista de registros históricos de inburnomina por póliza, lista vacía si todavía no existen registros
	 */
	List<HistoricoProductosInburnomina> consultarHistoricoProductosInburnominaPorPoliza(Integer numPoliza, Integer numConsignatario);

}
