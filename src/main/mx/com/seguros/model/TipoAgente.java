/*
 * TipoAgente.java
 *
 * Created on 24 de marzo de 2008, 03:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class TipoAgente {
    
    private int tipoAgente;
    private double produccionMinimaPuntos;
    private String descripcionTipoAgente;
    /** Creates a new instance of TipoAgente */
    public TipoAgente() {
    }

    

    public double getProduccionMinimaPuntos() {
        return produccionMinimaPuntos;
    }

    public void setProduccionMinimaPuntos(double produccionMinimaPuntos) {
        this.produccionMinimaPuntos = produccionMinimaPuntos;
    }

    public String getDescripcionTipoAgente() {
        return descripcionTipoAgente;
    }

    public void setDescripcionTipoAgente(String descripcionTipoAgente) {
        this.descripcionTipoAgente = descripcionTipoAgente;
    }

    public int getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(int tipoAgente) {
        this.tipoAgente = tipoAgente;
    }
    
}
