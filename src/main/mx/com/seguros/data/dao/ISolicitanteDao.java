/*
 * ISolicitanteDao.java
 *
 * Created on 29 de agosto de 2007, 03:03 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Solicitante;

/**
 *
 * @author QTX
 */
public interface ISolicitanteDao {
    
    void insertarSolicitanteDao(Solicitante solicitante);
    Solicitante recuperarSolicitantePorRFC(String RFCsolicitante);
    /**
     * Actualiza los datos de un solicitante en la BD
     * @param solicitante Datos de origen
     */
    void actualizarSolicitante(Solicitante solicitante);
}
