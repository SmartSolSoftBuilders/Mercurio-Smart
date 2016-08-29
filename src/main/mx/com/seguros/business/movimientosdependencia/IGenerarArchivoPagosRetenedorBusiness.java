/*
 * IGenerarArchivoPagosRetenedorBusiness.java
 *
 * Created on 14 de noviembre de 2008, 01:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.movimientosdependencia;

import java.io.InputStream;

/**
 *
 * @author QTX
 */
public interface IGenerarArchivoPagosRetenedorBusiness {
    
    void leerArchivoPagoRetenedores(InputStream archivoEntrada);
    String generarArchivoPagosRetenedor();
    String generarArchivoAltaAsegurados(int cveRetenedor);
        
}
