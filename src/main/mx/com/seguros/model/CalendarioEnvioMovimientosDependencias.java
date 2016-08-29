/*
 * CalendarioEnvioMovimientosDependencias.java
 *
 * Created on 13 de noviembre de 2008, 10:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

import java.util.Date;

/**
 *
 * @author QTX
 */
public class CalendarioEnvioMovimientosDependencias {
    
    /**
     * Creates a new instance of CalendarioEnvioMovimientosDependencias
     */
    public CalendarioEnvioMovimientosDependencias() {
    }
    
    private int anioQuincenaDescuento;
    private int numQnaDescuento;
    private Date inicioVigencia;
    private int cveRetenedor;
    private String fechaBusqueda;

    public int getAnioQuincenaDescuento() {
        return anioQuincenaDescuento;
    }

    public void setAnioQuincenaDescuento(int anioQuincenaDescuento) {
        this.anioQuincenaDescuento = anioQuincenaDescuento;
    }

    public int getNumQnaDescuento() {
        return numQnaDescuento;
    }

    public void setNumQnaDescuento(int numQnaDescuento) {
        this.numQnaDescuento = numQnaDescuento;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public int getCveRetenedor() {
        return cveRetenedor;
    }

    public void setCveRetenedor(int cveRetenedor) {
        this.cveRetenedor = cveRetenedor;
    }

    public String getFechaBusqueda() {
        return fechaBusqueda;
    }

    public void setFechaBusqueda(String fechaBusqueda) {
        this.fechaBusqueda = fechaBusqueda;
    }
    
}
