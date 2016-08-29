/*
 * IBeneficiarioDao.java
 *
 * Created on 29 de agosto de 2007, 03:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Beneficiario;

/**
 *
 * @author QTX
 */
public interface IBeneficiarioDao {
    
    void insertarBeneficiario(Beneficiario beneficiario);
    
    /** 
     * Elimina los beneficiarios de una solicitud
     * @param folioSolicitud Folio de la solicitud
     * @param formatoSolicitud Formato de la solicitud
     */
    void eliminarBeneficiariosSolicitud(Integer folioSolicitud, String formatoSolicitud);
}
