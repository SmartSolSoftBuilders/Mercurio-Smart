/*
 * DetalleComisionSolicitud.java
 *
 * Created on 22 de mayo de 2008, 11:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class DetalleComisionSolicitud {
    
    private int folioSolicitud;
    private String formatoSolicitud;
    private double comisionSolicitudAgente;
    private double comisionSolicitudSupervisor;
    private double comisionSolicitudGerente;
    private double comisionPolizaAgente;
    private double comisionPolizaSupervisor;
    private double comisionPolizaGerente;
    /** Creates a new instance of DetalleComisionSolicitud */
    public DetalleComisionSolicitud() {
    }

    public int getFolioSolicitud() {
        return folioSolicitud;
    }

    public void setFolioSolicitud(int folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

    public double getComisionSolicitudAgente() {
        return comisionSolicitudAgente;
    }

    public void setComisionSolicitudAgente(double comisionSolicitudAgente) {
        this.comisionSolicitudAgente = comisionSolicitudAgente;
    }

    public double getComisionSolicitudSupervisor() {
        return comisionSolicitudSupervisor;
    }

    public void setComisionSolicitudSupervisor(double comisionSolicitudSupervisor) {
        this.comisionSolicitudSupervisor = comisionSolicitudSupervisor;
    }

    public double getComisionSolicitudGerente() {
        return comisionSolicitudGerente;
    }

    public void setComisionSolicitudGerente(double comisionSolicitudGerente) {
        this.comisionSolicitudGerente = comisionSolicitudGerente;
    }

    public double getComisionPolizaAgente() {
        return comisionPolizaAgente;
    }

    public void setComisionPolizaAgente(double comisionPolizaAgente) {
        this.comisionPolizaAgente = comisionPolizaAgente;
    }

    public double getComisionPolizaSupervisor() {
        return comisionPolizaSupervisor;
    }

    public void setComisionPolizaSupervisor(double comisionPolizaSupervisor) {
        this.comisionPolizaSupervisor = comisionPolizaSupervisor;
    }

    public double getComisionPolizaGerente() {
        return comisionPolizaGerente;
    }

    public void setComisionPolizaGerente(double comisionPolizaGerente) {
        this.comisionPolizaGerente = comisionPolizaGerente;
    }
    /**
	 * @return the formatoSolicitud
	 */
	public String getFormatoSolicitud() {
		return formatoSolicitud;
	}

	/**
	 * @param formatoSolicitud the formatoSolicitud to set
	 */
	public void setFormatoSolicitud(String formatoSolicitud) {
		this.formatoSolicitud = formatoSolicitud;
	}
    
}
