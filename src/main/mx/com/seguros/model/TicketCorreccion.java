/**
 * Proyecto: Estrategas Seguros de Vida
 * Author:Smart Solutions.
 * Fecha de Creación: 15/02/2012
 * 
 */
package mx.com.seguros.model;

import java.util.Date;
import java.util.List;

/**
 * Clase de modelo que representa la tabla TicketCorreccion
 * @author Emigdio Hernández
 *
 */
public class TicketCorreccion {
	private Integer idTicketCorreccion;
	private String usuarioSolicitante;
	private String motivoSolicitud;
	private Date fechaSolicitud;
	private String datosOriginales;
	private String datosNuevos;
	private Integer folioSolicitud;
	private String formatoSolicitud;
	private Integer numPoliza;
	private Integer numConsignatario;
	private Integer idEstadoTicketCorreccion;
	private String usuarioAutoriza;
	private Date fechaAutorizacion;
	private EstadoTicketCorreccion estadoTicketCorreccion;
	private List<ComentarioTicket> comentariosTicket;
	/**
	 * @return the idTicketCorreccion
	 */
	public Integer getIdTicketCorreccion() {
		return idTicketCorreccion;
	}
	/**
	 * @param idTicketCorreccion the idTicketCorreccion to set
	 */
	public void setIdTicketCorreccion(Integer idTicketCorreccion) {
		this.idTicketCorreccion = idTicketCorreccion;
	}
	/**
	 * @return the usuarioSolicitante
	 */
	public String getUsuarioSolicitante() {
		return usuarioSolicitante;
	}
	/**
	 * @param usuarioSolicitante the usuarioSolicitante to set
	 */
	public void setUsuarioSolicitante(String usuarioSolicitante) {
		this.usuarioSolicitante = usuarioSolicitante;
	}
	/**
	 * @return the motivoSolicitud
	 */
	public String getMotivoSolicitud() {
		return motivoSolicitud;
	}
	/**
	 * @param motivoSolicitud the motivoSolicitud to set
	 */
	public void setMotivoSolicitud(String motivoSolicitud) {
		this.motivoSolicitud = motivoSolicitud;
	}
	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	/**
	 * @return the datosOriginales
	 */
	public String getDatosOriginales() {
		return datosOriginales;
	}
	/**
	 * @param datosOriginales the datosOriginales to set
	 */
	public void setDatosOriginales(String datosOriginales) {
		this.datosOriginales = datosOriginales;
	}
	/**
	 * @return the datosNuevos
	 */
	public String getDatosNuevos() {
		return datosNuevos;
	}
	/**
	 * @param datosNuevos the datosNuevos to set
	 */
	public void setDatosNuevos(String datosNuevos) {
		this.datosNuevos = datosNuevos;
	}
	/**
	 * @return the idEstadoTicketCorreccion
	 */
	public Integer getIdEstadoTicketCorreccion() {
		return idEstadoTicketCorreccion;
	}
	/**
	 * @param idEstadoTicketCorreccion the idEstadoTicketCorreccion to set
	 */
	public void setIdEstadoTicketCorreccion(Integer idEstadoTicketCorreccion) {
		this.idEstadoTicketCorreccion = idEstadoTicketCorreccion;
	}
	/**
	 * @return the estadoTicketCorreccion
	 */
	public EstadoTicketCorreccion getEstadoTicketCorreccion() {
		return estadoTicketCorreccion;
	}
	/**
	 * @param estadoTicketCorreccion the estadoTicketCorreccion to set
	 */
	public void setEstadoTicketCorreccion(
			EstadoTicketCorreccion estadoTicketCorreccion) {
		this.estadoTicketCorreccion = estadoTicketCorreccion;
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
	 * @return the numPoliza
	 */
	public Integer getNumPoliza() {
		return numPoliza;
	}
	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(Integer numPoliza) {
		this.numPoliza = numPoliza;
	}
	/**
	 * @return the numConsignatario
	 */
	public Integer getNumConsignatario() {
		return numConsignatario;
	}
	/**
	 * @param numConsignatario the numConsignatario to set
	 */
	public void setNumConsignatario(Integer numConsignatario) {
		this.numConsignatario = numConsignatario;
	}
	/**
	 * @return the comentariosTicket
	 */
	public List<ComentarioTicket> getComentariosTicket() {
		return comentariosTicket;
	}
	/**
	 * @param comentariosTicket the comentariosTicket to set
	 */
	public void setComentariosTicket(List<ComentarioTicket> comentariosTicket) {
		this.comentariosTicket = comentariosTicket;
	}
	/**
	 * @return the usuarioAutoriza
	 */
	public String getUsuarioAutoriza() {
		return usuarioAutoriza;
	}
	/**
	 * @param usuarioAutoriza the usuarioAutoriza to set
	 */
	public void setUsuarioAutoriza(String usuarioAutoriza) {
		this.usuarioAutoriza = usuarioAutoriza;
	}
	/**
	 * @return the fechaAutorizacion
	 */
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
}
