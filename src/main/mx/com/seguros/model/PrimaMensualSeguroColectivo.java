/*
 * PrimaMensualSeguroColectivo.java
 *
 * Created on 4 de octubre de 2007, 01:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author Cesar
 */
public class PrimaMensualSeguroColectivo {
    
    /** Creates a new instance of PrimaMensualSeguroColectivo */
    public PrimaMensualSeguroColectivo() {
    }
private int importePrimaColectiva;
private double sumaAseguradaColectiva;

    public double getSumaAseguradaColectiva() {
        return sumaAseguradaColectiva;
    }

    public void setSumaAseguradaColectiva(double sumaAseguradaColectiva) {
        this.sumaAseguradaColectiva = sumaAseguradaColectiva;
    }

}
