/*
 * LayoutMovimientosRecibidos.java
 *
 * Created on 14 de noviembre de 2008, 02:03 PM
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
public class LayoutMovimientosRecibidos {
    
    /** Creates a new instance of LayoutMovimientosRecibidos */
    public LayoutMovimientosRecibidos() {
    }
    
    private int constante;
    private String espacios;
    private String numCertificado;
    private String anioQuincena;
    private String cveDescuento;
    private String tipoMovimiento;
    private double importeDescuento;
    private String RFC;
    private String nombre;
    private String siglasRetenedor;

    public int getConstante() {
        return constante;
    }

    public void setConstante(int constante) {
        this.constante = constante;
    }

    public String getEspacios() {
        return espacios;
    }

    public void setEspacios(String espacios) {
        this.espacios = espacios;
    }

    public String getNumCertificado() {
        return numCertificado;
    }

    public void setNumCertificado(String numCertificado) {
        this.numCertificado = numCertificado;
    }

    public String getCveDescuento() {
        return cveDescuento;
    }

    public void setCveDescuento(String cveDescuento) {
        this.cveDescuento = cveDescuento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getImporteDescuento() {
        return importeDescuento;
    }

    public void setImporteDescuento(double importeDescuento) {
        this.importeDescuento = importeDescuento;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglasRetenedor() {
        return siglasRetenedor;
    }

    public void setSiglasRetenedor(String siglasRetenedor) {
        this.siglasRetenedor = siglasRetenedor;
    }

    public String getAnioQuincena() {
        return anioQuincena;
    }

    public void setAnioQuincena(String anioQuincena) {
        this.anioQuincena = anioQuincena;
    }
    
}
