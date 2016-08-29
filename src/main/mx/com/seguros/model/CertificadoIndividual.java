package mx.com.seguros.model;

import java.util.Date;

public class CertificadoIndividual {
    private Integer numCertificado;
    private Date fechaExpedicion;
    private Integer idPlaza;
    private Integer folioSolicitud;
    private String formatoSolicitud;
    

	private Plaza plaza = new Plaza();
    
    public void setNumCertificado(Integer numCertificado) {
        this.numCertificado = numCertificado;
    }
    
    public Integer getNumCertificado() {
        return this.numCertificado;
    }
    
    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    public Date getFechaExpedicion() {
        return this.fechaExpedicion;
    }
    
    public Integer getIdPlaza() {
        return idPlaza;
    }
    
    public void setIdPlaza(Integer idPlaza) {
        this.idPlaza = idPlaza;
    }
    
    public Integer getFolioSolicitud() {
        return folioSolicitud;
    }
    
    public void setFolioSolicitud(Integer folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
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