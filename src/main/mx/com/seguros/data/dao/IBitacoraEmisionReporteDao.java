/**
 * 
 */
package mx.com.seguros.data.dao;

import mx.com.seguros.model.BitacoraEmisionReporte;

/**
 * Definición de la interfaz del objeto de acceso a datos a la tabla de BitacoraEmisionReporte
 * @author Emigdio Hernández
 *
 */
public interface IBitacoraEmisionReporteDao {

	/**
	 * Inserta un nuevo registro en la bitácora de emisión de reportes
	 * @param datosEntrada Datos origen
	 */
	void insertarBitacoraEmisionReporte(BitacoraEmisionReporte datosEntrada);
}
