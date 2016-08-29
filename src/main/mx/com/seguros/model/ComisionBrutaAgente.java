/*
 * ComisionBrutaAgente.java
 *
 * Created on 17 de marzo de 2008, 09:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

import java.util.Date;
import mx.com.seguros.model.Empleado;

/**
 *
 * @author Alverik
 */
public class ComisionBrutaAgente {
    
    private int cveAgente;
    private double totalComisionFijaAgente;
    private double totalComisionFijaSupervisor;
    private double totalComisionFijaGerente;
    private double reservaBonoTrim;
    private Date fechaInicioPeriodoComisiones;
    private Date fechaFinPeriodoComisiones;
    
    private Empleado empleado=new Empleado();
    
    
    //Dato auxiliar para generar mi reporte//
    private int numQuincenaReporte;
    private int anioQuincena;
    //Dato auxiliar para generar mi reporte//

    
    /** Creates a new instance of ComisionBrutaAgente */
    public ComisionBrutaAgente() {
    }

    public int getCveAgente() {
        return cveAgente;
    }

    public void setCveAgente(int cveAgente) {
        this.cveAgente = cveAgente;
    }

   

    public double getTotalComisionFijaSupervisor() {
        return totalComisionFijaSupervisor;
    }

    public void setTotalComisionFijaSupervisor(double totalComisionFijaSupervisor) {
        this.totalComisionFijaSupervisor = totalComisionFijaSupervisor;
    }

    public double getTotalComisionFijaGerente() {
        return totalComisionFijaGerente;
    }

    public void setTotalComisionFijaGerente(double totalComisionFijaGerente) {
        this.totalComisionFijaGerente = totalComisionFijaGerente;
    }

    public double getReservaBonoTrim() {
        return reservaBonoTrim;
    }

    public void setReservaBonoTrim(double reservaBonoTrim) {
        this.reservaBonoTrim = reservaBonoTrim;
    }

    public Date getFechaInicioPeriodoComisiones() {
        return fechaInicioPeriodoComisiones;
    }

    public void setFechaInicioPeriodoComisiones(Date fechaInicioPeriodoComisiones) {
        this.fechaInicioPeriodoComisiones = fechaInicioPeriodoComisiones;
    }

    public double getTotalComisionFijaAgente() {
        return totalComisionFijaAgente;
    }

    public void setTotalComisionFijaAgente(double totalComisionFijaAgente) {
        this.totalComisionFijaAgente = totalComisionFijaAgente;
    }

    public Date getFechaFinPeriodoComisiones() {
        return fechaFinPeriodoComisiones;
    }

    public void setFechaFinPeriodoComisiones(Date fechaFinPeriodoComisiones) {
        this.fechaFinPeriodoComisiones = fechaFinPeriodoComisiones;
    }

    public int getNumQuincenaReporte() {
        return numQuincenaReporte;
    }

    public void setNumQuincenaReporte(int numQuincenaReporte) {
        this.numQuincenaReporte = numQuincenaReporte;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getAnioQuincena() {
        return anioQuincena;
    }

    public void setAnioQuincena(int anioQuincena) {
        this.anioQuincena = anioQuincena;
    }

    

    

    
    
    
}
