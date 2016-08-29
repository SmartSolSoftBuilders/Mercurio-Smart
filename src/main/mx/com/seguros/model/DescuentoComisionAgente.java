/*
 * DescuentoComisionAgente.java
 *
 * Created on 24 de marzo de 2008, 09:57 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class DescuentoComisionAgente {
    
    private int cveAgente;
    private double totalDescuentoComisionAgente;
    private double totalDescuentoComisionSupervisor;
    private double totalDescuentoComisionGerente;
    
    /** Creates a new instance of DescuentoComisionAgente */
    public DescuentoComisionAgente() {
    }

    public int getCveAgente() {
        return cveAgente;
    }

    public void setCveAgente(int cveAgente) {
        this.cveAgente = cveAgente;
    }

    public double getTotalDescuentoComisionAgente() {
        return totalDescuentoComisionAgente;
    }

    public void setTotalDescuentoComisionAgente(double totalDescuentoComisionAgente) {
        this.totalDescuentoComisionAgente = totalDescuentoComisionAgente;
    }

    public double getTotalDescuentoComisionSupervisor() {
        return totalDescuentoComisionSupervisor;
    }

    public void setTotalDescuentoComisionSupervisor(double totalDescuentoComisionSupervisor) {
        this.totalDescuentoComisionSupervisor = totalDescuentoComisionSupervisor;
    }

    public double getTotalDescuentoComisionGerente() {
        return totalDescuentoComisionGerente;
    }

    public void setTotalDescuentoComisionGerente(double totalDescuentoComisionGerente) {
        this.totalDescuentoComisionGerente = totalDescuentoComisionGerente;
    }
    
}
