/*
 * PrestamoEmpleado.java
 *
 * Created on 22 de mayo de 2008, 11:19 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class PrestamoEmpleado {
    
    private int cveEmpleado;
    private int idPrestamo;
    private int cvePrestamo;
    private String condicionPrestamo;
    private double totalPrestamo;
    private int numPagosTotales;
    private double importePagosRegular;
    private int numQuincenaAplicacion;
    private int anioQuincenaAplicacion;
    private boolean marcaPrestamoLiquidado;
    
    private Empleado empleado=new Empleado();
    /** Creates a new instance of PrestamoEmpleado */
    public PrestamoEmpleado() {
    }

    public int getCveEmpleado() {
        return cveEmpleado;
    }

    public void setCveEmpleado(int cveEmpleado) {
        this.cveEmpleado = cveEmpleado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getCvePrestamo() {
        return cvePrestamo;
    }

    public void setCvePrestamo(int cvePrestamo) {
        this.cvePrestamo = cvePrestamo;
    }

    public String getCondicionPrestamo() {
        return condicionPrestamo;
    }

    public void setCondicionPrestamo(String condicionPrestamo) {
        this.condicionPrestamo = condicionPrestamo;
    }

    public double getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(double totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }

    public int getNumPagosTotales() {
        return numPagosTotales;
    }

    public void setNumPagosTotales(int numPagosTotales) {
        this.numPagosTotales = numPagosTotales;
    }

    public double getImportePagosRegular() {
        return importePagosRegular;
    }

    public void setImportePagosRegular(double importePagosRegular) {
        this.importePagosRegular = importePagosRegular;
    }

    public int getNumQuincenaAplicacion() {
        return numQuincenaAplicacion;
    }

    public void setNumQuincenaAplicacion(int numQuincenaAplicacion) {
        this.numQuincenaAplicacion = numQuincenaAplicacion;
    }

   

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isMarcaPrestamoLiquidado() {
        return marcaPrestamoLiquidado;
    }

    public void setMarcaPrestamoLiquidado(boolean marcaPrestamoLiquidado) {
        this.marcaPrestamoLiquidado = marcaPrestamoLiquidado;
    }

    public int getAnioQuincenaAplicacion() {
        return anioQuincenaAplicacion;
    }

    public void setAnioQuincenaAplicacion(int anioQuincenaAplicacion) {
        this.anioQuincenaAplicacion = anioQuincenaAplicacion;
    }

  
    
}
