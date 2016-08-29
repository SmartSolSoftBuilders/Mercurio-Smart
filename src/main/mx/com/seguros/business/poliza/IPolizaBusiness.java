/*
 * IPolizaBusiness.java
 *
 * Created on 24 de septiembre de 2007, 07:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.poliza;

import java.util.Date;
import java.util.List;

import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.EstatusPolizaGeneral;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.EstatusPolizaSeguimiento;
import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.TipoTramite;
import mx.com.seguros.model.TramitePoliza;
import mx.com.seguros.web.poliza.AutofinanciarPolizaCancelCommand;
import mx.com.seguros.web.poliza.CancelarPolizaCommand;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;
import mx.com.seguros.web.poliza.GenerarEntregaPolizaCommand;
import mx.com.seguros.web.poliza.GenerarFormatoAplicDescCommand;
import mx.com.seguros.web.poliza.GenerarFormatoDescuentoCommand;
import mx.com.seguros.web.poliza.RegistroPolizaCommand;
/**
 *
 * @author Cesar
 */
public interface IPolizaBusiness {
    /** Creates a new instance of IPolizaBusiness */
    void autofinanciarPoliza(AutofinanciarPolizaCancelCommand datosPoliza);
    void actualizarPoliza(CancelarPolizaCommand datosPoliza);
    void registrarPoliza(RegistroPolizaCommand datosPoliza);
    void registrarAsegurado(RegistroPolizaCommand datosPoliza);
    void generarReportes(RegistroPolizaCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados (RegistroPolizaCommand datosPoliza);
    String generarReportes2(GenerarEntregaPolizaCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados2 (GenerarEntregaPolizaCommand datosPoliza);
    String generarReportes3(GenerarFormatoDescuentoCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados3 (GenerarFormatoDescuentoCommand datosPoliza);
    String generarReportes4(GenerarFormatoAplicDescCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados4 (GenerarFormatoAplicDescCommand datosPoliza);
    String generarReportes5(ConsultaPolizaCommand datosPoliza);
    ReportesPDF obtenerReportesGenerados5 (ConsultaPolizaCommand datosPoliza);
    List obtenerEstatusPoliza();
    List obtenerPolizaEntregadaEmitidaAgente(String agente);
    void actualizaEstatusPoliza (int poliza,int numConsignatario,int estatus);
    void actualizaEstatusPolizaPago(int poliza,int numConsignatario,int estatus);
    void actualizaEstatusPolizaSeguimiento(int poliza,int numConsignatario,int estatus);
    void actualizaEstatusPolizaAmbos(int poliza,int numConsignatario,int estatusPago,int estatusSeguimiento);
    List obtenerPolizasPorEntregarAsegurado(String agente);
    void actualizaPolizaEntregadaAsegurado(int poliza,int numConsignatario,int estatus,String nombreReceptor, Date fechaRecepcion);
    /**
     * Mantenimieto: QTX Noviembre 2011 se agrega el formato de la solicitud a la llave primaria de la solicitud
     */
    Object obtenerPolizasPorFolioSolicitudNoCancelada(int folioSolicitud,String formatoSolicitud);
    /**
     * Obtiene el detalle de una póliza
     * @param numPoliza numero de poliza
     * @param emisor numero de consignatario
     * @return
     */
    PolizaIndividual obtenerDetallePolizaPorNumero(int numPoliza,int emisor);
    
    void actualizarPolizaIndividual(PolizaIndividual poliza);
    
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
	 * Guardar los beneficios adicionales para una póliza, se recalcularán los valores
	 * de tarifa total y de suma asegurada total
	 * @param poliza Poliza Individual para la cuál almacenar los beneficios adicionales, los beneficios adicionales
	 * se deben de encontrar dentro de este objeto de solicitud para ser almacenados
	 */
	void guardarBeneficiosAdicionales(PolizaIndividual poliza);
    
    //Smart solutions diciembre 2011
    //Integración del módulo de pagos
	List<PolizaIndividual> obtenerPolizasVigentesContratante(String numNominaContratante, Date fechaLimiteCarga);
    
    Integer recuperarQnaPrimerIntentoPago(PolizaIndividual poliza);
    
    void insertarFechaPrimerIntentoPago(PolizaIndividual poliza, Integer qnaPrimerIntentoPago);
    
    /**
	 * Consulta el catálogo de estados de póliza de seguimiento
	 * @return Lista de estados de póliza
	 */
	List<EstatusPolizaSeguimiento> consultarEstatusPolizaSeguimiento();
	/**
     * Consulta el catálogo de estatus de pagos de póliza    
     * @return Lista de valores del catálogo de pólizas
     */
    List<EstatusPolizaPagos>  consultarEstatusPolizaPagos();
    
    public PolizaIndividual findPolizaById(PolizaIndividual poliza);
   /**
    * Engloba los proceso de alta de póliza para incluirlas en una sola transacción
    * @param datosPoliza
    */
    void registrarPolizaCompleto(RegistroPolizaCommand datosPoliza);
    
    /**
	 * Consulta el catálgo de tipos de trámites
	 * @return Los tipos de trámite disponibles en el sistema
	 */
	List<TipoTramite> obtenerCatalogTipoTramite();
	/**
	 * Obtiene un registro del tipo de trámite por su llave primara
	 * @param idTipoTramite Llave primaria del tipo de trámite a buscar
	 * @return Tipo de Trámite encontrado
	 */
	TipoTramite obtenerTipoTramitePorId(Integer idTipoTramite);
	/**
	 * Consulta la bitácora de trámites relacionados con una póliza ordenados por fecha
	 * @param numPoliza Criterio de búsqueda
	 * @param numConsignatario Criterio de búqueda
	 * @return Lista de trámites relacionados a una póliza
	 */
	List<TramitePoliza> obtenerTramitesDePoliza(Integer numPoliza, Integer numConsignatario);
	/**
	 * Consulta la bitácora de trámites relacionados con una póliza ordenados por fecha
	 * @param numPoliza Criterio de búsqueda
	 * @param numConsignatario Criterio de búqueda
	 * @return Lista de trámites relacionados a una póliza
	 */
	List<TramitePoliza> obtenerTramitesDePoliza(Date fechaInicial, Date fechaFinal, Integer Oficina);	
	/**
	 * Inserta en la base de datos un nuevo registro de trámite póliza con los datos
	 * enviados como parámetro.
	 * @param tramite Datos del trámite
	 */
	void insertarTramitePoliza(TramitePoliza tramite);
    
	/**
	 * Consulta el catálgo de oficinas de estrategas
	 * @return Las oficinas disponibles en el sistema
	 */
	List<Oficina> obtenerCatalogOficinas();
	
	/**
	 * Refresca y actualiza en BD la tarifa total de la solicitud de la poliza considerando todos los elementos
	 * También actualiza la suma asegurada
	 * @param numPoliza Numero de poliza
	 * @param numConsignatario Numero de consignatario
	 * @return Tarifa actualizada
	 */
	double actualizarTarifaTotalPoliza(Integer numPoliza, Integer numConsignatario,String cveUsuario);
	/**
	 * Obtiene al catálogo de estatus generales de la póliza
	 * @return Listado de estatus generales de póliza
	 */
	List<EstatusPolizaGeneral> consultarEstatusPolizaGeneral();
	
	/**
	 * Realiza las actualizaciones de los datos de la poliza que pueden ser modificados por atención a clientes
	 * @param poliza
	 */
	void actualizarDatosPolizaAtencionClientes(PolizaIndividual poliza);
	/**
	 * Obtiene el estatus general de la poliza en base a su estatus de pago
	 * @param idEstatusPolizaPago Estatus de pago
	 * @return Estatus general, null si no se puede determinar
	 */
	Integer obtenerEstatusPolizaGeneral(int idEstatusPolizaPago);
	/**
	 * Consulta las plazas registrada en el sistema
	 */
	List<Plaza> consultarPlazas();
	
}
