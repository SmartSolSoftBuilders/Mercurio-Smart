/**
 * 
 */
package mx.com.seguros.business.inburnomina;

import java.util.List;

import mx.com.seguros.model.HistoricoProductosInburnomina;
import mx.com.seguros.model.ProductosInburnomina;

/**
 * Servicio para la administraci�n de los productos extra de inburnomina integral
 * que est�n asociados a una p�liza de seguro de vida
 * @author Emigdio Hernandez
 *
 */
public interface AdministrarProductosInburnominaService {
	/**
	 * Registra los datos de los productos inburn�mina. Si no existen
	 * los registra como nuevos, si existen los actualiza e inserta en el hist�rico
	 * @param datos Datos a insertar
	 */
	void registrarProductosInburnomina(ProductosInburnomina datos);
	/**
	 * Recupera los datos de productos inburn�mina de una p�liza.
	 * @param numPoliza
	 * @param numConsignatario
	 * @return Datos de inburnomina, null si no se encuentran datos todav�a
	 */
	ProductosInburnomina obtenerProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Consulta una lista de los registros hist�ricos de inburn�mina de una p�liza de seguros de vida
	 * @param numPoliza
	 * @param numConsignatario
	 * @return
	 */
	List<HistoricoProductosInburnomina> obtenerHistoricoDeProductosInburnomina(Integer numPoliza, Integer numConsignatario);

}
