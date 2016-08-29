/**
 * Proyecto: Estrategas Seguros de Vida
 * Author:Smart Solutions.
 * Fecha de Creación: 15/02/2012
 * 
 */
package mx.com.seguros.model;

/**
 * Clase de modelo para la tabla de EstadoTicketCorreccion
 * 
 * @author Emigdio Hernández
 *
 */
public class EstadoTicketCorreccion {
	
	public static Integer NUEVO = 1;
	public static Integer RECHAZADO = 2;
	public static Integer APLICADO = 3;
	
	public static String[] DESCRIPCION = new String[]{"","Nuevo","Rechazado","Aplicado"}; 
	
	private Integer idEstadoTicketCorreccion;
	private String descripcionEstadoTicketCorreccion;
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
	 * @return the descripcionEstadoTicketCorreccion
	 */
	public String getDescripcionEstadoTicketCorreccion() {
		return descripcionEstadoTicketCorreccion;
	}
	/**
	 * @param descripcionEstadoTicketCorreccion the descripcionEstadoTicketCorreccion to set
	 */
	public void setDescripcionEstadoTicketCorreccion(
			String descripcionEstadoTicketCorreccion) {
		this.descripcionEstadoTicketCorreccion = descripcionEstadoTicketCorreccion;
	}
}
