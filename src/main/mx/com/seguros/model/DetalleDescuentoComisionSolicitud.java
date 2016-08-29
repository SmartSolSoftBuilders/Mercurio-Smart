/*
 * DetalleDescuentoComisionSolicitud.java
 *
 * Created on 22 de mayo de 2008, 11:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class DetalleDescuentoComisionSolicitud {
    
    private int folioSolicitud;
    private String formatoSolicitud;
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

	private double importeDescuentoComisionAgente;
    private double importeDescuentoComisionSupervisor;
    private double importeDescuentoComisionGerente;
    /** Creates a new instance of DetalleDescuentoComisionSolicitud */
    public DetalleDescuentoComisionSolicitud() {
    }

    public int getFolioSolicitud() {
        return folioSolicitud;
    }

    public void setFolioSolicitud(int folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

    public double getImporteDescuentoComisionAgente() {
        return importeDescuentoComisionAgente;
    }

    public void setImporteDescuentoComisionAgente(double importeDescuentoComisionAgente) {
        this.importeDescuentoComisionAgente = importeDescuentoComisionAgente;
    }

    public double getImporteDescuentoComisionSupervisor() {
        return importeDescuentoComisionSupervisor;
    }

    public void setImporteDescuentoComisionSupervisor(double importeDescuentoComisionSupervisor) {
        this.importeDescuentoComisionSupervisor = importeDescuentoComisionSupervisor;
    }

    public double getImporteDescuentoComisionGerente() {
        return importeDescuentoComisionGerente;
    }

    public void setImporteDescuentoComisionGerente(double importeDescuentoComisionGerente) {
        this.importeDescuentoComisionGerente = importeDescuentoComisionGerente;
    }

    
    
}
