/*
 * IHistorialDao.java
 *
 * Created on 14 de noviembre de 2008, 05:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import mx.com.seguros.model.HistorialMovimientosContratante;

/**
 *
 * @author QTX
 */
public interface IHistorialDao {
    
    public void insertarHistorial(HistorialMovimientosContratante historial);
    
   
}
