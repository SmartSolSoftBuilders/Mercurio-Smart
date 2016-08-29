/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.business.test;

import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.web.solicitud.DatosSolicitudCommand;

/**
 * Clase de pruebas unitarias para el método de actualizar solicitud
 * @author Emigdio
 */
public class SolicitudBusinessTest  extends BaseServiceTest{


    public void testActualizarSolicitud(){

        ISolicitudBusiness solicitudBusiness = (ISolicitudBusiness)getBean("solicitudBusiness");

        Solicitud solicitud = solicitudBusiness.obtenerDetalleSolicitudPorFolio(9933950,"FSP");
        DatosSolicitudCommand datos = new DatosSolicitudCommand();
        solicitud.getSolicitante().setEstadoCivilSolicitante(""+FormatUtil.transformarEstadoCivilDeDescripcion(solicitud.getSolicitante().getEstadoCivilSolicitante()));
        datos.setSolicitud(solicitud);
        solicitud.setCveTarifa(solicitud.getTarifa().getCveTarifa());
        solicitudBusiness.actualizarSolicitud(datos);
        

    }

}
