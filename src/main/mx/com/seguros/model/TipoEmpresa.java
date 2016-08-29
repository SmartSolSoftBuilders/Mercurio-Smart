/*
 * TipoEmpresa.java
 *
 * Created on 28 de noviembre de 2007, 03:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author IGNACIO
 */
public class TipoEmpresa {
    
    /** Creates a new instance of TipoEmpresa */
    public TipoEmpresa() {
    }
    private int tipoEmpresa;
    private String descripcionEmpresa;

    public int getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(int tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }
    
}
