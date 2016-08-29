/**
 * 
 */
package mx.com.seguros.business.inburnomina;

import java.util.List;

import mx.com.seguros.model.HistoricoProductosInburnomina;
import mx.com.seguros.model.ProductosInburnomina;

/**
 * Servicio para la administración de los productos extra de inburnomina integral
 * que están asociados a una póliza de seguro de vida
 * @author Emigdio Hernandez
 *
 */
public interface AdministrarProductosInburnominaService {
	/**
	 * Registra los datos de los productos inburnómina. Si no existen
	 * los registra como nuevos, si existen los actualiza e inserta en el histórico
	 * @param datos Datos a insertar
	 */
	void registrarProductosInburnomina(ProductosInburnomina datos);
	/**
	 * Recupera los datos de productos inburnómina de una póliza.
	 * @param numPoliza
	 * @param numConsignatario
	 * @return Datos de inburnomina, null si no se encuentran datos todavía
	 */
	ProductosInburnomina obtenerProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Consulta una lista de los registros históricos de inburnómina de una póliza de seguros de vida
	 * @param numPoliza
	 * @param numConsignatario
	 * @return
	 */
	List<HistoricoProductosInburnomina> obtenerHistoricoDeProductosInburnomina(Integer numPoliza, Integer numConsignatario);

}
