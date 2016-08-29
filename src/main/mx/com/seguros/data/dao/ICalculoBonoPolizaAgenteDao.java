package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.BonoPolizaPorCalcularDTO;
import mx.com.seguros.dto.ResultadoCalculoBonoPolizaAgenteDTO;
import mx.com.seguros.model.CalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;

/**
 * Interfaz del objeto de acceso a datos para las operaciones
 * sobre la tabla de calculo de bono de póliza
 * @author Emigdio Hernández
 *
 */
public interface ICalculoBonoPolizaAgenteDao {
	/**
	 * Consulta el conjunto de pólizas con descuentos aplicados suficientes para calcular bonos y cuyos bonos
	 * no han sido calculados aún.
	 * Se puede enviar opcionalmente como parámetro la póliza para obtener sus bonos por calcular
	 * @param numPoliza Opcionalmente parámetro de número de póliza
	 * @param numConsignatario Opcionalmente parámetro de número de consignatario
	 * @param idPlaza parámetro opcional para limitar a cierta plaza el cálculo del bono
	 * @return
	 */
	List<BonoPolizaPorCalcularDTO> consultarBonosPendientesPorCalcular(Integer numPoliza, Integer numConsignatario, Integer idPlaza);
	/**
	 * Insertar un registro de resumen de proceso de cálculo de bono
	 * @param resumenProceso Datos de origen
	 */
	void insertarResumenProcesoCalculoBono(ResumenProcesoCalculoBono resumenProceso);
	/**
	 * Inserta un registro de resumen de cálculo de bono de póliza para agente
	 * @param resumenCalculo Datos de origen
	 */
	void insertarResumenCalculoBonoPolizaAgente(ResumenCalculoBonoPolizaAgente resumenCalculo);
	/**
	 * Inserta un registro de cálculo de bono de póliza a agente
	 * @param calculo Datos de origen
	 */
	void insertarCalculoBonoPolizaAgente(CalculoBonoPolizaAgente calculo);
	
	/**
	  * Consulta todos los resúmenes de proces de cálculo de bonos registrados en el sistema
	  * ordenados por fecha de cálculo
	  * @return Lista de resumenes de proceso de cálculo de bonos
	  */
	 List<ResumenProcesoCalculoBono> consultarResumenProcesosCalculoBono();
	 /**
	  * Consulta los resúmenes de cálculo de bonos por agente de un proceso de cálculo de bonos
	  * @param idResumenProcesoCalculoBono ID del proceso de cálculo a filtrar
	  * @return Lista de resúmenes de cálculo de bono por agente
	  */
	 List<ResumenCalculoBonoPolizaAgente> consultarResumenCalculoBonoPolizaAgentePorIdResumenCalculo(Integer idResumenProcesoCalculoBono);
	 /**
	  * Consulta todos los detalles de cálculo de bono de un cierto proceso de cálculo ordenados por agente
	  * @param idResumenProcesoCalculoBono ID del proceso de cálculo a filtrar
	  * @return Lista de detalle de cálculo de bono de póliza
	  */
	 List<ResultadoCalculoBonoPolizaAgenteDTO> consultarDetalleCalculoBonoPolizaAgentePorIdResumenProcesoCalculoBono(Integer idResumenProcesoCalculoBono);
	 /**
	  * Consulta un registro de resumen de proceso de cálculo por llave primaria
	  * @param idResumenProcesoCalculoBono ID a filtrar
	  * @return Resumen de cálculo encontrado
	  */
	 ResumenProcesoCalculoBono consultarResumenProcesoCalculoBonoPorId(Integer idResumenProcesoCalculoBono);
}
