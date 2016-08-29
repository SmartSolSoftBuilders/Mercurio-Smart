/*
 * PagoPrestamoEmpleado.java
 *
 * Created on 22 de mayo de 2008, 11:24 AM
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
public class PagoPrestamoEmpleado {
    
    private int cveEmpleado;
    private int idPrestamo;
    private int idPago;
    private double montoPagado;
    private Date fechaPago;
    /** Creates a new instance of PagoPrestamoEmpleado */
    public PagoPrestamoEmpleado() {
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

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
}
