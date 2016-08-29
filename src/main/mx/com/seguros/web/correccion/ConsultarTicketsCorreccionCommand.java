/**
 * 
 */
package mx.com.seguros.web.correccion;

import java.util.Date;

/**
 * Objeto de comando para transportar los criterios de búsqueda de tickets de corrección
 * @author Emigdio Hernández
 *
 */
public class ConsultarTicketsCorreccionCommand {

	public Integer idEstadoTicketCorreccion = null;
	public Date fechaInicioConsulta = null;
	public Date fechaFinConsulta = null;
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
	 * @return the fechaInicialConsulta
	 */
	/**
	 * @return the fechaInicioConsulta
	 */
	public Date getFechaInicioConsulta() {
		return fechaInicioConsulta;
	}
	/**
	 * @param fechaInicioConsulta the fechaInicioConsulta to set
	 */
	public void setFechaInicioConsulta(Date fechaInicioConsulta) {
		this.fechaInicioConsulta = fechaInicioConsulta;
	}
	/**
	 * @return the fechaFinConsulta
	 */
	public Date getFechaFinConsulta() {
		return fechaFinConsulta;
	}
	/**
	 * @param fechaFinConsulta the fechaFinConsulta to set
	 */
	public void setFechaFinConsulta(Date fechaFinConsulta) {
		this.fechaFinConsulta = fechaFinConsulta;
	}
	
}
