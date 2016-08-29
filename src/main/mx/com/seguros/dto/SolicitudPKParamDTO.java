/**
 * 
 */
package mx.com.seguros.dto;

/**
 * DTO que representa la PK compuesta del objeto de Solicitud
 * Se utiliza para cuando se tiene que enviar en un solo objeto el PK completo, se creó este DTO
 * para evitar usar el objeto completo de Solicitud
 * @author Emigdio Hernández
 *
 */
public class SolicitudPKParamDTO {
	private int folioSolicitud;
	private String formatoSolicitud;
	
	public SolicitudPKParamDTO(){}
	
	public SolicitudPKParamDTO(int folioSolicitud, String formatoSolicitud){
		this.folioSolicitud = folioSolicitud;
		this.formatoSolicitud = formatoSolicitud;
	}
	
    /**
	 * @return the folioSolicitud
	 */
	public int getFolioSolicitud() {
		return folioSolicitud;
	}
	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(int folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
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
