/*
 * BonoTrimestralAgente.java
 *
 * Created on 24 de marzo de 2008, 03:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class BonoTrimestralAgente {
    
    private int cveAgente;
    private double importeBonoAgente;
    private double importeBonoSupervisor;
    private double importeBonoGerente;
    
    /** Creates a new instance of BonoTrimestralAgente */
    public BonoTrimestralAgente() {
    }

    public int getCveAgente() {
        return cveAgente;
    }

    public void setCveAgente(int cveAgente) {
        this.cveAgente = cveAgente;
    }

    public double getImporteBonoAgente() {
        return importeBonoAgente;
    }

    public void setImporteBonoAgente(double importeBonoAgente) {
        this.importeBonoAgente = importeBonoAgente;
    }

    public double getImporteBonoSupervisor() {
        return importeBonoSupervisor;
    }

    public void setImporteBonoSupervisor(double importeBonoSupervisor) {
        this.importeBonoSupervisor = importeBonoSupervisor;
    }

    public double getImporteBonoGerente() {
        return importeBonoGerente;
    }

    public void setImporteBonoGerente(double importeBonoGerente) {
        this.importeBonoGerente = importeBonoGerente;
    }
    
}
