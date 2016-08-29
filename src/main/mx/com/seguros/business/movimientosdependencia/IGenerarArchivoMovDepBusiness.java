/*
 * IGenerarArchivoMovDepBusiness.java
 *
 * Created on 28 de octubre de 2008, 10:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.movimientosdependencia;

import java.util.List;
import mx.com.seguros.web.movimientosdependencia.GenerarArchivoMovimientosDependenciaCommand;


/**
 *
 * @author QTX
 */
public interface IGenerarArchivoMovDepBusiness {
    
    /** Creates a new instance of IGenerarArchivoMovDepBusiness */        
        List obtenerDatosArchivo(GenerarArchivoMovimientosDependenciaCommand movimientosDependencia);
        String crearArchivoTXT(List listaDatos);
}
