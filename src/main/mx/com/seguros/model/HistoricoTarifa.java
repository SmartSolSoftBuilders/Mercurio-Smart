/**
 * 
 */
package mx.com.seguros.model;

import java.util.Date;

/**
 * Clase de modelo que representa la tabla de Histórico de Tarifas de una Solicitud
 * @author Emigdio Hernádez
 *
 */
public class HistoricoTarifa {
	
	private Integer idHistoricoTarifa = null;
	private Integer cveTarifa = null;
	private Double tarifaTotal = null;
	private String comentario = null;
	private Date fechaFin = null;
	private String usuario = null;
	private Integer folioSolicitud = null;
	private String formatoSolicitud = null;
	private TarifaAportMensual tarifa = null;
	private String descripcion = null;
	/**
	 * @return the idHistoricoTarifas
	 */
	public Integer getIdHistoricoTarifa() {
		return idHistoricoTarifa;
	}
	/**
	 * @param idHistoricoTarifas the idHistoricoTarifas to set
	 */
	public void setIdHistoricoTarifa(Integer idHistoricoTarifas) {
		this.idHistoricoTarifa = idHistoricoTarifas;
	}
	/**
	 * @return the cveTarifa
	 */
	public Integer getCveTarifa() {
		return cveTarifa;
	}
	/**
	 * @param cveTarifa the cveTarifa to set
	 */
	public void setCveTarifa(Integer cveTarifa) {
		this.cveTarifa = cveTarifa;
	}
	/**
	 * @return the tarifaTotal
	 */
	public Double getTarifaTotal() {
		return tarifaTotal;
	}
	/**
	 * @param tarifaTotal the tarifaTotal to set
	 */
	public void setTarifaTotal(Double tarifaTotal) {
		this.tarifaTotal = tarifaTotal;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the folioSolicitud
	 */
	public Integer getFolioSolicitud() {
		return folioSolicitud;
	}
	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(Integer folioSolicitud) {
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
	/**
	 * @return the tarifa
	 */
	public TarifaAportMensual getTarifa() {
		return tarifa;
	}
	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(TarifaAportMensual tarifa) {
		this.tarifa = tarifa;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
