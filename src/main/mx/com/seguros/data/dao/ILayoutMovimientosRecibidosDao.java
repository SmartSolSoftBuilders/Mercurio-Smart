/*
 * ILayoutMovimientosRecibidosDao.java
 *
 * Created on 14 de noviembre de 2008, 03:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.List;
import mx.com.seguros.model.LayoutMovimientosRecibidos;

/**
 *
 * @author QTX
 */
public interface ILayoutMovimientosRecibidosDao {
    
    public void eliminarRegistrosListaColumnas();
    public void insertarLayoutMovimientosRecibidos(LayoutMovimientosRecibidos layout);
    public List obtenerDatosLista();
    public String obtenerSiglasRetenedor(String cveDescuento);
    
}
