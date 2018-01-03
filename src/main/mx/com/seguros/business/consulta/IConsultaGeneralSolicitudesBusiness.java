/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.business.consulta;

import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoCarteraSolicitudDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Interface del servicio de negocio para realiza la consulta general de solicitudes
 * de seguro
 * @author Emigdio Hernández
 */
public interface IConsultaGeneralSolicitudesBusiness {

     /**
     * Realiza la consulta general de solicitudes de seguro utilizando
     * el objeto de criterios enviado como parámetro al método
     * @param criterios Criterios a utiliza
     * @param resultado Banderas de control y resultado de la ejecucion
     */
    void consultarSolicitudes(CriteriosConsultaSolicitudesDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado);

    /**
     * Realiza la consulta de polizas individuales para realizar su baja
     * @param criterios Criterios de búsqueda
     * @param resultado resultado de la consulta
     */
    void consultarPolizasPorBaja(CriteriosConsultaPolizaPorBajaDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado);
    
    
    /**
     * Realiza consulta cartera general sólo con parametro resultado
     */
    void consultarCarteraSolicitudes(ResultadoPaginadoDTO<ResultadoCarteraSolicitudDTO> resultado);
}
