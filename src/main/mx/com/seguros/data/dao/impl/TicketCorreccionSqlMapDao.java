/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.data.dao.ITicketCorreccionDao;
import mx.com.seguros.model.ComentarioTicket;
import mx.com.seguros.model.EstadoTicketCorreccion;
import mx.com.seguros.model.TicketCorreccion;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del objeto de acceso a datos para el proceso de corrección de solicitudes
 * @author Emigdio Hernández
 *
 */
@SuppressWarnings("unchecked")
public class TicketCorreccionSqlMapDao extends SqlMapClientDaoSupport implements ITicketCorreccionDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ITicketCorreccionDao#consultarTicketsCorreccion(java.lang.Integer, java.util.Date, java.util.Date, java.lang.String)
	 */
	
	@Override
	public List<TicketCorreccion> consultarTicketsCorreccion(
			Integer idEstadoCorreccion, Date fechaInicial, Date fechaFinal,
			String usuario) {
		Map<String, Object> params = new HashMap<String, Object>();
		Calendar fechaFinalAjustada = null;
		
		if(fechaFinal != null){
			fechaFinalAjustada = Calendar.getInstance();
			fechaFinalAjustada.setTime(fechaFinal);
			fechaFinalAjustada.set(Calendar.HOUR_OF_DAY,23);
			fechaFinalAjustada.set(Calendar.MINUTE,59);
			
		}
		params.put("fechaInicial",fechaInicial);
		params.put("fechaFinal",fechaFinalAjustada!=null?fechaFinalAjustada.getTime():null);
		params.put("idEstadoTicketCorreccion",idEstadoCorreccion);
		params.put("usuario",usuario);
		return (List<TicketCorreccion>)getSqlMapClientTemplate().queryForList("consultarTicketsCorreccion", params);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ITicketCorreccionDao#consultarDetalleTicketCorreccion(java.lang.Integer)
	 */
	@Override
	public TicketCorreccion consultarDetalleTicketCorreccion(
			Integer idTicketCorreccion) {
		TicketCorreccion ticket = (TicketCorreccion) getSqlMapClientTemplate().
				queryForObject("consultarDetalleTicketCorreccion",idTicketCorreccion);
		if(ticket != null){
			ticket.setComentariosTicket(
					getSqlMapClientTemplate().queryForList("consultarComentariosTicketCorreccion", idTicketCorreccion)
					);
		}
		return ticket;
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ITicketCorreccionDao#guardarTicketCorreccion(mx.com.seguros.model.TicketCorreccion)
	 */
	@Override
	public Integer guardarTicketCorreccion(TicketCorreccion ticket) {
		
		getSqlMapClientTemplate().
				insert("guardarTicketCorreccion", ticket);
		return ticket.getIdTicketCorreccion();
		
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ITicketCorreccionDao#actualizarTicketCorreccion(mx.com.seguros.model.TicketCorreccion)
	 */
	@Override
	public void actualizarTicketCorreccion(TicketCorreccion ticket) {
			getSqlMapClientTemplate().update("actualizarTicketCorreccion",ticket);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ITicketCorreccionDao#agregarComentarioTicket(mx.com.seguros.model.ComentarioTicket)
	 */
	@Override
	public Integer agregarComentarioTicket(ComentarioTicket comentario) {
		getSqlMapClientTemplate().insert("agregarComentarioTicket",comentario);
		return comentario.getIdComentarioTicket();
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ITicketCorreccionDao#actualizarEstadoTicketCorreccion(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void actualizarEstadoTicketCorreccion(Integer idTicketCorreccion,
			Integer idEstadoTicketCorreccion) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEstadoTicketCorreccion",idEstadoTicketCorreccion);
		params.put("idTicketCorreccion",idTicketCorreccion);
		getSqlMapClientTemplate().update("actualizarEstadoTicketCorreccion",params);

	}

	@Override
	public List<EstadoTicketCorreccion> consultarEstadosTicketCorreccion() {
		return getSqlMapClientTemplate().queryForList("consultarEstadosTicketCorreccion");
	}

}
