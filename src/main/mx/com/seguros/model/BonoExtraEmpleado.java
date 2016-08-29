/*
 * BonoExtraEmpleado.java
 *
 * Created on 22 de mayo de 2008, 11:28 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class BonoExtraEmpleado {
    
    private int cveEmpleado;
    private int idBonoExtra;
    private String conceptoBonoExtra;
    private double importeBonoExtra;
    private int numQuincenaAplicacion;
    private int anioQuincenaAplicacion;
    
    /** Creates a new instance of BonoExtraEmpleado */
    public BonoExtraEmpleado() {
    }

    public int getCveEmpleado() {
        return cveEmpleado;
    }

    public void setCveEmpleado(int cveEmpleado) {
        this.cveEmpleado = cveEmpleado;
    }

    public int getIdBonoExtra() {
        return idBonoExtra;
    }

    public void setIdBonoExtra(int idBonoExtra) {
        this.idBonoExtra = idBonoExtra;
    }

    public String getConceptoBonoExtra() {
        return conceptoBonoExtra;
    }

    public void setConceptoBonoExtra(String conceptoBonoExtra) {
        this.conceptoBonoExtra = conceptoBonoExtra;
    }

    public double getImporteBonoExtra() {
        return importeBonoExtra;
    }

    public void setImporteBonoExtra(double importeBonoExtra) {
        this.importeBonoExtra = importeBonoExtra;
    }

    public int getNumQuincenaAplicacion() {
        return numQuincenaAplicacion;
    }

    public void setNumQuincenaAplicacion(int numQuincenaAplicacion) {
        this.numQuincenaAplicacion = numQuincenaAplicacion;
    }

    public int getAnioQuincenaAplicacion() {
        return anioQuincenaAplicacion;
    }

    public void setAnioQuincenaAplicacion(int anioQuincenaAplicacion) {
        this.anioQuincenaAplicacion = anioQuincenaAplicacion;
    }
    
}
