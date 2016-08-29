/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.seguros.business.test;

import mx.com.seguros.business.consulta.IConsultaGeneralSolicitudesBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Clase de pruebas
 * @author Emigdio
 */
public class ConsultaGeneralSolicitudesBusinessTest extends BaseServiceTest {

  /*
        IConsultaGeneralSolicitudesBusiness instance = (IConsultaGeneralSolicitudesBusiness) getBean("consultaGeneralSolicitudesBusiness");

        CriteriosConsultaSolicitudesDTO criterios = new CriteriosConsultaSolicitudesDTO();
        ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultados = new ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO>();
        resultados.setRegistrosPorPagina(50);
        instance.consultarSolicitudes(criterios, resultados);
        System.out.println("Total de resultados = " + resultados.getTotalResultados());

        assertNotNull(resultados);

    }*/

    public void testSolicitudInsertada(){
        ISolicitudBusiness solB = (ISolicitudBusiness)getBean("solicitudBusiness");

        Solicitud sol = solB.obtenSolicitudPorFolioSolicitud(999457507,"FSP");
        assertNotNull(sol);

    }
}
