/*
 * IPolizaDao.java
 *
 * Created on 25 de septiembre de 2007, 11:41 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.CalendarioEnvioMovimientosDependencias;
import mx.com.seguros.model.EstatusPolizaGeneral;
import mx.com.seguros.model.HistorialMovimientosContratante;
import mx.com.seguros.model.PaqueteVidaDxN;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.model.Retenedor;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 *
 * @author Cesar
 */
public interface IPolizaDao {
    public void autofinarciarPolizaCancel(PolizaIndividual polizaIndividual);
    public void cancelarPoliza(PolizaIndividual polizaIndividual);
    void insertarPoliza(PolizaIndividual poliza);
    void actualizaPolizaCambio(PolizaIndividual poliza);
    public void actualizarSolicitud(int folioSolicitud, String formatoSolicitud);
    public String obtenerPlaza(int folioSolicitud, String formatoSolicitud);
    public List obtenerPolizaNumPoliza(Map params);
    public List obtenerPolizaNumContratante(Map params);
    public List obtenerPolizaApPaternoContratante(Map params);
    public List obtenerPolizaCertificado (Map params);
    public List obtenerRfcAsegurado (Map params);
    public List obtenerApellidoAsegurado (Map params);
    public List obtenerPolizaEntregadaEmitidaAgente(String agente);
    public void actualizaEstatusPoliza (PolizaIndividual polizaIndividual);
    int actualizaEstatusPolizaPago(PolizaIndividual polizaIndivididual);
    int actualizaEstatusPolizaSeguimiento(PolizaIndividual polizaIndivididual);
    void actualizaEstatusPolizaAmbos(PolizaIndividual polizaIndivididual);
    public List obtenerEstatusPoliza ();
    public List obtenerPolizasPorEntregarAsegurado(String agente);
    public void actualizaIndicadorPagoComisionEntregaPoliza(PolizaIndividual polizaIndividual);
    public void actualizaIndicadorDescuentoComision(PolizaIndividual polizaIndividual);
    public Object obtenerPolizaPorSolicitud(int folioSolicitud, String formatoSolicitud);
    public List obtenListaDescuentosAplicados(int numPoliza);
    public String contarListaDescuentosAplicados(int numPoliza);
    public List buscarFechaCalendario(CalendarioEnvioMovimientosDependencias calendario);
    public List obtenerListaHistorialMovContratante(String contratante);
    public Retenedor obtenerRetenedor(int folioSolicitud, String formatoSolicitud);
    public Integer obtenerPolizasPorNumNominaContratante(String numNominaContratante);
    public Integer consultaContadorPolizasVigentes(String numNominaContratante);
    public List consultaPolizasVigentes(String numNominaContratante);
    public Integer consultaContadorPolizasMvtoQnaCliente(HistorialMovimientosContratante historial);
    public List consultaPolizasMvtoQnaCliente(HistorialMovimientosContratante historial);
    public String consultarClaveDescuentoPorSolicitud(int folioSolicitud, String formatoSolicitud);
    public void insertarHistorial(HistorialMovimientosContratante historial);
    public Object obtenerPolizaNumPolizaNumConsignatario(PolizaIndividual poliza);    
    public void actualizarQnaProgEnvioPoliza(PolizaIndividual poliza);
    public Object obtenerPolizasPorFolioSolicitudNoCancelada(int folioSolicitud, String formatoSolicitud);
    public List obtenListaPolizasCambio(String numNominaContratante);

    /**
     * Obtiene el detalle de una póliza
     * @param numPoliza
     * @return
     */
    PolizaIndividual obtenerDetallePolizaPorNumero(int numPoliza,int emisor);
    /**
     * Actualiza la información general de una póliza 
     * @param poliza Datos de origen de la póliza
     */
	void actuzalizarPoliza(PolizaIndividual poliza);
	/**
	 * Obtiene el catálogo de beneficios adicionales
	 * @return Lista de beneficios adicionales encontrados
	 */
	List<BeneficioAdicional> consultarCatalogoBeneficiosAdicionales();
	
	/**
	 * Obtiene el conjunto de beneficios adicionales capturados para una póliza
	 * @param numPoliza Número de póliza a buscar sus beneficios
	 * @param numConsignatario Número de consignatario de la póliza a buscar sus beneficios
	 * @return Lista de beneficios adicionales
	 */
	List<BeneficioAdicionalPoliza> consultarBeneficiosAdicionalesDePoliza(int numPoliza,int numConsignatario);
	/**
	 * Elimina todos los beneficios adicionales asociados a una póliza
	 * @param numPoliza Núemro de la póliza a eliminar sus beneficios
	 * @param numConsignatario Número de consignatarios de la póliza para 
	 * eliminar sus benficiarios
	 */
	void eliminarBeneficiosAdicionalesDePoliza(int numPoliza,int numConsignatario);
	/**
	 * Guardar los beneficios adicionales para una póliza
	 * @param beneficios Lista de beneficios a insertar
	 */
	void guardarBeneficiosAdicionales(List<BeneficioAdicionalPoliza> beneficios);
	/**
	 * Obtiene el nombre del paquete del seguro de vida en base a su nombre clave
	 * @param nombrePaquete Nombre del paquete a buscar
	 * @return Paquete encontrado, null en caso de no encontrar
	 */
	PaqueteVidaDxN obtenerPaqueteSeguroPorNombre(String nombrePaquete);
	
	//Smart Solutions diciembre 2011
	//Inclusión del módulo de pagos
	
	PolizaIndividual obtenerPolizaById(PolizaIndividual poliza);
	
	List<PolizaIndividual> consultaPolizasVigentesNew(String numNominaContratante, Date fechaLimiteCarga);
	
	Integer recuperarQnaPrimerIntentoPago(PolizaIndividual poliza);

    void insertarQnaPrimerIntentoPago(PolizaIndividual poliza, Integer qnaPrimerIntentoPago);
    
    /**
     * Actualiza el campo de Suma Asegurada Total de una cierta póliza
     * @param poliza Objeto de póliza con el valor de la suma asegurada total a actualizar
     * y los valores de numero de póliza y número de consignatario de la póliza a actualizar
     */
    void actualizarSumaAseguradaTotal(PolizaIndividual poliza);
    /**
     * Actualiza únicamente la PK de póliza individual
     * @param datosOriginales PK original
     * @param datosNuevos PK nueva
     */
    void actualizarPkPolizaIndividual(PolizaIndividual datosOriginales, PolizaIndividual datosNuevos);
    /**
     * Carga de la BD un conjunto de póliza por su llave primaria en bloques de 50 pólizas
     * @param numerosPoliza Números de póliza a cargar
     * @param numerosConsignatario Números de emisor de pólizas a cargar que corresponden a los números de póliza a cargar
     * @return
     */
    List<PolizaIndividual> cargarPolizasPorPKBatch(List<Integer> numerosPoliza, List<Integer> numerosConsignatario);
    /**
     * Realiza una consulta paginada para obtener en forma de batch los resultados de todas
     * aquellas pólizas candidatas al autofinanciamiento
     * @param resultados Configuración de paginación
     * @param idPlaza Parámetro opcional de plaza a procesar
     */
    void consultarPolizasParaAutofinanciar(ResultadoPaginadoDTO<PolizaIndividual> resultados,Integer idPlaza, Integer idEstatusPolizaPagos);
    /**
     * Consulta únicamente los campos de la tabla de póliza sin hacer ningún cruce con otra tabla
     * @param numPoliza Número de póliza
     * @param numConsignatario Número de consignatario
     * @return Objeto de póliza encontrado
     */
    PolizaIndividual obtenerResumenPoliza(Integer numPoliza,Integer numConsignatario);
    /**
     * Actualiza la fecha de solicitud de cancelación y la fecha de cancelación de descuentos de una póliza
     * @param poliza Datos de la póliza
     * @return Número de registros actualizados
     */
    int actualizarFechasCancelacionPoliza(PolizaIndividual poliza);
    /**
     * Inserta un nuevo registro de productos inburnomina para una poliza individual
     * @param datosProductos Datos de los productos a insertar
     */
    void insertarProductosInburnomina(ProductosInburnomina datosProductos);
    /**
     * Actualiza un registro de productos inburnomina de una poliza individual
     * @param datosProductos
     */
    void actualizarDatosPrductosInburnomina(ProductosInburnomina datosProductos);
    /**
     * Consulta un registro de productos inburnomina correspondiente a una poliza de vida individual
     * @param numPoliza Número de póliza buscada
     * @param numConsignatario Número de consignatario buscado
     * @return
     */
    ProductosInburnomina consultarProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario);
    
    /**
     * Actualiza el estatus general de una poliza
     * @param numPoliza Número de poliza
     * @param numConsignatario Número de consignatario
     * @param idEstatusPolizaGeneral ID del estatus a actualizar
     */
    void actualizarEstatusPolizaGeneral(Integer numPoliza, Integer numConsignatario, Integer idEstatusPolizaGeneral);
    
    /**
	 * Obtiene al catálogo de estatus generales de la póliza
	 * @return Listado de estatus generales de póliza
	 */
	List<EstatusPolizaGeneral> obtenerEstatusPolizaGeneral();
    
	/**
	 * Realiza las actualizaciones de los datos de la poliza que pueden ser modificados por atención a clientes
	 * @param poliza
	 */
	void actualizarDatosPolizaAtencionClientes(PolizaIndividual poliza);
	
	/**
	 * Consulta un conjunto de polizas para su posible baja
	 * @param criterios Criterios de busqueda
	 * @param resultado Resultados
	 */
	void consultarPolizasPorBaja(CriteriosConsultaPolizaPorBajaDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado);
	
	/**
	 * Consulta las plazas registrada en el sistema
	 */
	List<Plaza> consultarPlazas();
}

