package mx.com.seguros.business.solicitud;

import java.util.Date;
import java.util.List;

import mx.com.seguros.model.Agente;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.CertificadoIndividual;
import mx.com.seguros.model.Empleado;
import mx.com.seguros.model.EstatusSolicitud;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.Promotor;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.web.solicitud.DatosSolicitudCommand;

public interface ISolicitudBusiness {
    
    void registrarSolicitud(DatosSolicitudCommand datosSolicitud);
    public List obtenSolicitudPorEstatusYnumNominaContratante(int estatus,String numNominaContratante);
    boolean validarVigenciaSolicitud(Date fechaSolicitud);
    public Object obtenTarifaMensualPorClaveTarifa(int cveTarifa);
  //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
    public Solicitud obtenSolicitudPorFolioSolicitud (int folioSolicitud, String formatoSolicitud);

     /**
     * Consulta el detalle completo de una solicitud de seguro en base a su folio
     * @param folioSolicitud Folio de la solicitud a consultar
     * @return folio
     */
  //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
    Solicitud obtenerDetalleSolicitudPorFolio(int folioSolicitud, String formatoSolicitud);
    /**
     * Actualiza una solicitud de seguro en base a los datos enviados
     * @param datosSolicitud Datos origen
     */
    void actualizarSolicitud(DatosSolicitudCommand datosSolicitud);
    
    /**
     * Consulta un certificado individual de una solicitud en base al folio de la solicitud
     * @param folioSolicitud Folio a buscar
     * @return Certificado encontrado
     */
  //Smart Solutions Noviembre 2011 Mantenimiento, se agrega el campo de formato Solicitud para formar el ID compuesto de Solicitud
    CertificadoIndividual consultarCertificadoPorFolio(Integer folioSolicitud, String formatoSolicitud);
    
    /**
     * Consulta el catálogo de estados solicitudes
     * @return Lista de estados de solicitud
     */
    List<EstatusSolicitud> consultarEstatusSolicitud();
    /**
     * Obtiene un objeto de Agente por clave única del agente
     * @param cveAgente Clave del agente buscar
     * @return Objeto de agente lleno
     */
    Agente obtenerAgentePorCveAgente(int cveAgente);
    /**
     * Obtiene un objeto de Empleado en base a su llave primaria
     * @param cveEmpleado Clave del empleado a buscar
     * @return Empleado encontrado, null en caso de no encontrarse
     */
    Empleado obtenerEmpleadoPorCveEmpleado(int cveEmpleado);
    /**
     * Realiza una consulta de los beneficiarios de una solicitud
     * @param foliosSolicitud Folio de la solicitud para buscar sus beneficiarios
     * @param formatoSolicitud Formato de la solicitus para buscar sus beneficiarios
     * @return Lista de beneficiarios asociados a la solicitud
     */
    Beneficiario[] consultarBeneficiarios(Integer foliosSolicitud, String formatoSolicitud);
    
    /**
     * Consulta el promotor por su llave primaria 
     * @param cvePromotor PK del promotor a buscar
     * @return El promotor encontrado, null en otro caso
     */
    Promotor buscarPromotor(Integer cvePromotor);
    /**
     * Inserta un nuevo registro de HistoricoTarifa
     * @param historico Datos para relizar la inserción
     */
    void insertarHistoricoTarifa(HistoricoTarifa historico);
    /**
     * Consulta el histórico de tarifas de una solicitud
     * @param solicitud Solicitud para la cuál consultar el histórico de tarifas
     * @return Lista con el histórico de tarifas de solicitud
     */
    List<HistoricoTarifa> consultarHistoricoTarifaSolicitud(Solicitud solicitud);
    /**
     * Determina la tarifa a aplicar para la solicitud en cierta fecha,
     * si no tiene histórico se utilizará la tarifa total de la solicitud
     * @param sol Solicitud
     * @param fecha Fecha de consulta
     * @return importe de la tarifa
     */
    Double consultarTarifaEnFecha(Solicitud sol,Date fecha);
    /**
     * Consulta el catálogo de las plazas disponibles en el sistema
     * @return Listado de Plazas
     */
    List<Plaza> consultarPlazas();
}
