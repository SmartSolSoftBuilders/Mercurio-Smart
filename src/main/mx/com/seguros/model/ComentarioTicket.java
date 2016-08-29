/**
 * Proyecto: Estrategas Seguros de Vida
 * Author:Smart Solutions.
 * Fecha de Creación: 15/02/2012
 * 
 */
package mx.com.seguros.model;

import java.util.Date;

/**
 * Clase de modelo para la tabla de Comentario Ticket
 * @author Emigdio Hernández
 *
 */
public class ComentarioTicket {
	private Integer idComentarioTicket;
	private String usuario;
	private Date fecha;
	private String comentario;
	private Integer idTicketCorreccion;
	/**
	 * @return the idComentarioTicket
	 */
	public Integer getIdComentarioTicket() {
		return idComentarioTicket;
	}
	/**
	 * @param idComentarioTicket the idComentarioTicket to set
	 */
	public void setIdComentarioTicket(Integer idComentarioTicket) {
		this.idComentarioTicket = idComentarioTicket;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	
}
