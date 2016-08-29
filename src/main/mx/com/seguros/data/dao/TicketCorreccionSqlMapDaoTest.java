/**
 * 
 */
package mx.com.seguros.data.dao;

import java.util.Date;
import java.util.List;

import mx.com.seguros.model.ComentarioTicket;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.TicketCorreccion;
import mx.com.seguros.test.BaseServiceTest;
import mx.com.seguros.utils.FormatUtil;

/**
 * Clase de pruebas unitarias para del DAO del proceso de corrección de datos de solicitud
 * @author Emigdio Hernández
 *
 */
public class TicketCorreccionSqlMapDaoTest extends BaseServiceTest {
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
	
	public void testProcesoCorreccion(){
		ITicketCorreccionDao dao = (ITicketCorreccionDao) getBean("ticketCorreccionDao");
		//Crear Ticket
		TicketCorreccion ticket = new TicketCorreccion();
		
		ticket.setUsuarioSolicitante("test");
		ticket.setMotivoSolicitud("Typo en captura");
		ticket.setFechaSolicitud(new Date());
		ticket.setDatosOriginales("<solicitud></solicitud>");
		ticket.setDatosNuevos("<solicitud></solicitud>");
		ticket.setFolioSolicitud(11);
		ticket.setFormatoSolicitud("A");
		ticket.setNumPoliza(2);
		ticket.setNumConsignatario(1);
		ticket.setIdEstadoTicketCorreccion(EstadoTicketCorreccion.NUEVO);
		
		dao.guardarTicketCorreccion(ticket);
		
		ticket = dao.consultarDetalleTicketCorreccion(ticket.getIdTicketCorreccion());
		
		ticket = new TicketCorreccion();
		
		ticket.setUsuarioSolicitante("test");
		ticket.setMotivoSolicitud("Typo en captura");
		ticket.setFechaSolicitud(new Date());
		ticket.setDatosOriginales("<solicitud></solicitud>");
		ticket.setDatosNuevos("<solicitud></solicitud>");
		ticket.setFolioSolicitud(12);
		ticket.setFormatoSolicitud("A");
		ticket.setNumPoliza(3);
		ticket.setNumConsignatario(1);
		ticket.setIdEstadoTicketCorreccion(EstadoTicketCorreccion.NUEVO);
		ticket.setIdTicketCorreccion(dao.guardarTicketCorreccion(ticket));
		ticket = dao.consultarDetalleTicketCorreccion(ticket.getIdTicketCorreccion());
		
		List<TicketCorreccion> tickets = dao.consultarTicketsCorreccion(EstadoTicketCorreccion.NUEVO,FormatUtil.stringToDate("14/02/2012"), 
				FormatUtil.stringToDate("15/02/2012"), "test");
		System.out.println("Tickets consulta inicial con params:" + tickets.size());
		
		tickets = dao.consultarTicketsCorreccion(EstadoTicketCorreccion.NUEVO,FormatUtil.stringToDate("14/02/2012"), 
				FormatUtil.stringToDate("15/02/2012"),null);
		System.out.println("Tickets consulta inicial con params:" + tickets.size());
		
		tickets = dao.consultarTicketsCorreccion(EstadoTicketCorreccion.NUEVO,FormatUtil.stringToDate("14/02/2012"), 
				null,null);
		System.out.println("Tickets consulta inicial con params:" + tickets.size());
		
		tickets = dao.consultarTicketsCorreccion(EstadoTicketCorreccion.NUEVO,null, 
				null,null);
		System.out.println("Tickets consulta inicial con params:" + tickets.size());
		
		tickets = dao.consultarTicketsCorreccion(null,null, 
				null,null);
		System.out.println("Tickets consulta inicial sin params:" + tickets.size());
		
		dao.actualizarEstadoTicketCorreccion(ticket.getIdEstadoTicketCorreccion(), EstadoTicketCorreccion.APLICADO);
		
		dao.actualizarTicketCorreccion(ticket);
		
		ComentarioTicket comentario = new ComentarioTicket();
		comentario.setUsuario("comentario");
		comentario.setFecha(new Date());
		comentario.setComentario("El contenido del comentario");
		comentario.setIdTicketCorreccion(ticket.getIdTicketCorreccion());
		
		dao.agregarComentarioTicket(comentario);
		comentario.setComentario("El contenido del comentario 2");
		dao.agregarComentarioTicket(comentario);
		comentario.setComentario("El contenido del comentario 3");
		dao.agregarComentarioTicket(comentario);
		
		ticket = dao.consultarDetalleTicketCorreccion(ticket.getIdTicketCorreccion());
		
		System.out.println("Comentarios = "+ticket.getComentariosTicket().size());
	}
	
}
