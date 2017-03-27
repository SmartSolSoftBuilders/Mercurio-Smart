package mx.com.seguros.business.consulta;

import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

public interface IConsultaEspecialBusiness {

    /**
    * Realiza la consulta general de solicitudes de seguro utilizando
    * el objeto de criterios enviado como par�metro al m�todo
    * @param criterios Criterios a utiliza
    * @param resultado Banderas de control y resultado de la ejecucion
    */
   void consultarSolicitudesEsp(CriteriosConsultaSolicitudesDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado);

   /**
    * Realiza la consulta de polizas individuales para realizar su baja
    * @param criterios Criterios de b�squeda
    * @param resultado resultado de la consulta
    */
   void consultarPolizasPorBaja(CriteriosConsultaPolizaPorBajaDTO criterios, ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado);
}