/**
 * Proyecto: Estrategas Seguros de Vida
 * Author:Smart Solutions.
 * Fecha de Creación: 15/02/2012
 * 
 */
package mx.com.seguros.data.dao;

import java.util.Date;
import java.util.List;

import mx.com.seguros.model.ComentarioTicket;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.TicketCorreccion;

/**
 * Definición del contrato de funcionalidad para el objeto de acceso a datos
 * para el poceso de solicitud de ticket de corrección de Solicitudes
 * @author Emigdio Hernández
 *
 */
public interface ITicketCorreccionDao {
	/**
	 * Consulta un conjunto de tickets de corrección bajo las siguientes condiciones:
	 * Con un cierto estado, si el estado no es enviado, entonces se omite el criterio de búsqueda
	 * Entre cierta fecha inicial y final, si alguna fecha es omitida, no se incluye en el criterio
	 * Se envía el usuario que consulta, si el usuario no es un rol de adminsitración entonces se filtran las
	 * solicitudes únicamente de ese usuario
	 * @param idEstadoCorreccion Estado de corrección a filtrar
	 * @param fechaInicial Criterio inicial de la fecha de creación
	 * @param fechaFinal Criterio final de la fecha de creación
	 * @param usuario Usuario que realiza la solicitud
	 * @return Lista de tickets de corrección que corresponden con los criterios
	 */
	List<TicketCorreccion> consultarTicketsCorreccion(Integer idEstadoCorreccion,Date fechaInicial,Date fechaFinal, String usuario);
	/**
	 * Consulta el detalle de un ticket de corrección basado en su llave primaria
	 * @param idTicketCorreccion Identificador del ticket a consultar
	 * @return Ticket econtrado, null en otro caso
	 */
	TicketCorreccion consultarDetalleTicketCorreccion(Integer idTicketCorreccion);
	/**
	 * Almacena un nuevo ticket de corrección y retorna el ID generado
	 * @param ticket Datos del nuevo ticket de corrección
	 * @return ID generado
	 */
	Integer guardarTicketCorreccion(TicketCorreccion ticket);
	/**
	 * Actualiza la información de un ticket de corrección
	 * @param ticket Datos nuevos del ticket de corrección
	 */
	void actualizarTicketCorreccion(TicketCorreccion ticket);
	/**
	 * Inserta un nuevo comentario para un ticket de corrección
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
	 * Consulta el catálogo de estados de ticket de corrección
	 * @return Lista de estados de ticket de corrección
	 */
	List<EstadoTicketCorreccion> consultarEstadosTicketCorreccion();
	
	
}
