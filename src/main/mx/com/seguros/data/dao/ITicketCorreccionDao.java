/**
 * Proyecto: Estrategas Seguros de Vida
 * Author:Smart Solutions.
 * Fecha de Creaci�n: 15/02/2012
 * 
 */
package mx.com.seguros.data.dao;

import java.util.Date;
import java.util.List;

import mx.com.seguros.model.ComentarioTicket;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.TicketCorreccion;

/**
 * Definici�n del contrato de funcionalidad para el objeto de acceso a datos
 * para el poceso de solicitud de ticket de correcci�n de Solicitudes
 * @author Emigdio Hern�ndez
 *
 */
public interface ITicketCorreccionDao {
	/**
	 * Consulta un conjunto de tickets de correcci�n bajo las siguientes condiciones:
	 * Con un cierto estado, si el estado no es enviado, entonces se omite el criterio de b�squeda
	 * Entre cierta fecha inicial y final, si alguna fecha es omitida, no se incluye en el criterio
	 * Se env�a el usuario que consulta, si el usuario no es un rol de adminsitraci�n entonces se filtran las
	 * solicitudes �nicamente de ese usuario
	 * @param idEstadoCorreccion Estado de correcci�n a filtrar
	 * @param fechaInicial Criterio inicial de la fecha de creaci�n
	 * @param fechaFinal Criterio final de la fecha de creaci�n
	 * @param usuario Usuario que realiza la solicitud
	 * @return Lista de tickets de correcci�n que corresponden con los criterios
	 */
	List<TicketCorreccion> consultarTicketsCorreccion(Integer idEstadoCorreccion,Date fechaInicial,Date fechaFinal, String usuario);
	/**
	 * Consulta el detalle de un ticket de correcci�n basado en su llave primaria
	 * @param idTicketCorreccion Identificador del ticket a consultar
	 * @return Ticket econtrado, null en otro caso
	 */
	TicketCorreccion consultarDetalleTicketCorreccion(Integer idTicketCorreccion);
	/**
	 * Almacena un nuevo ticket de correcci�n y retorna el ID generado
	 * @param ticket Datos del nuevo ticket de correcci�n
	 * @return ID generado
	 */
	Integer guardarTicketCorreccion(TicketCorreccion ticket);
	/**
	 * Actualiza la informaci�n de un ticket de correcci�n
	 * @param ticket Datos nuevos del ticket de correcci�n
	 */
	void actualizarTicketCorreccion(TicketCorreccion ticket);
	/**
	 * Inserta un nuevo comentario para un ticket de correcci�n
	 * @param comentario Datos del comentario
	 * @return Id del comentario generado
	 */
	Integer agregarComentarioTicket(ComentarioTicket comentario);
	/**
	 * Actualiza el estado de cierto ticket de correccion
	 * @param idTicketCorreccion ID del ticket a actualizar
	 * @param idEstadoTicketCorreccion Estado a asignar
	 */
	void actualizarEstadoTicketCorreccion(Integer idTicketCorreccion,Integer idEstadoTicketCorreccion);
	/**
	 * Consulta el cat�logo de estados de ticket de correcci�n
	 * @return Lista de estados de ticket de correcci�n
	 */
	List<EstadoTicketCorreccion> consultarEstadosTicketCorreccion();
	
	
}
