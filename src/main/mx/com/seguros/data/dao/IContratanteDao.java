/*
 * IContratanteDao.java
 *
 * Created on 29 de agosto de 2007, 02:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.Contratante;

/**
 *
 * @author QTX
 */
public interface IContratanteDao {
    
    void insertarContratante(Contratante contratante);

    Contratante recuperarContratantePorNumNomina(String numNominaContratante);
    /**
     * Actualiza la información de un contratante existente en BD
     * @param contratante Datos origen
     */
    void actualizarContratante(Contratante contratante);
}
