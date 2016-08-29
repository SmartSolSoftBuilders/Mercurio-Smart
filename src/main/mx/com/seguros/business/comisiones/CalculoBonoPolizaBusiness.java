/**
 * 
 */
package mx.com.seguros.business.comisiones;

import java.util.List;

import mx.com.seguros.business.pagos.exception.PagosBusinessException;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;

/**
 * Interfaz del servicio para las operaciones  del cálculo de bono de comisiones de pólizas
 * @author Emigdio Hernandez
 *
 */
public interface CalculoBonoPolizaBusiness {
	
	/**
	 * Obtiene el cálculo de los bonos nuevos para las pólizas que tengan suficientes pagos 
	 * y que no tengan completamente calculados los bonos
	 * Opcionalmente se puede enviar el número de póliza y número de consignatario 
	 * para obtener el cálculo de sólo una póliza.
	 * Este cálculo no se almacena en BD, únicamente es calculado
	 * @param numPoliza Número opcional de póliza
	 * @param numConsignatario Númro opcional de consignatario
	 * @param Identificador opcional de la plaza que debe ser considerada para el cálculo
	 */
	 List<ResumenCalculoBonoPolizaAgente>  obtenerCalculoDeBonosAFechaActual(Integer numPoliza, Integer numConsignatario, Integer idPlaza);
	 /**
	  * Calcula y registra de forma definitiva el bono de conservación a la fecha actual.
	  * Opcionalmente se puede enviar el número de póliza y número de consignatario 
	  * para obtener el cálculo de sólo una póliza.
	  * @param numPoliza Número opcional de póliza
	  * @param numConsignatario Númro opcional de consignatario
	  * @return Objeto creado y registrado ya en BD
	  */
	 ResumenProcesoCalculoBono registrarCalculoBonoFinal(Integer numPoliza, Integer numConsignatario,String usuario, Integer idPlaza) throws PagosBusinessException;
	 /**
	  * Consulta todos los resúmenes de proces de cálculo de bonos registrados en el sistema
	  * ordenados por fecha de cálculo
	  * @return Lista de resumenes de proceso de cálculo de bonos
	  */
	 List<ResumenProcesoCalculoBono> consultarResumenProcesosCalculoBono();
	 /**
	  * Consulta los detalles por agente y por póliza de un proceso de cálculo de bono
	  * @param idResumenProcesoCalculoBono ID del proceso a consultar
	  * @return Objeto de resumen de proceso de cálculo con las lista de detalle llenas
	  */
	 ResumenProcesoCalculoBono consultaDetalleProcesoCalculoBono(Integer idResumenProcesoCalculoBono);
	
}
