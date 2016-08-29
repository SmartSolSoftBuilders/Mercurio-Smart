/**
 * 
 */
package mx.com.seguros.web.correccion;

import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.TicketCorreccion;

/**
 * Clase command para manejar los datos de la vista al registrar/modificar un ticket de corrección
 * @author Emigdio Hernández
 *
 */
public class RegistrarTicketCorreccionCommand {
	
	private TicketCorreccion ticket = null;
	private PolizaIndividual datosOriginales = null;
	private PolizaIndividual datosNuevos = null;
	
	private boolean mostrarBotonGuardar = true;
	private boolean mostrarBotonAplicarRechazar = false;
	private boolean aseguradoInexistente = false;
	private String comentarioNuevo = null;
	private boolean existenPagosAplicados = false;
	/**
	 * @return the ticket
	 */
	public TicketCorreccion getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(TicketCorreccion ticket) {
		this.ticket = ticket;
	}
	/**
	 * @return the datosOriginales
	 */
	public PolizaIndividual getDatosOriginales() {
		return datosOriginales;
	}
	/**
	 * @param datosOriginales the datosOriginales to set
	 */
	public void setDatosOriginales(PolizaIndividual datosOriginales) {
		this.datosOriginales = datosOriginales;
	}
	/**
	 * @return the datosNuevos
	 */
	public PolizaIndividual getDatosNuevos() {
		return datosNuevos;
	}
	/**
	 * @param datosNuevos the datosNuevos to set
	 */
	public void setDatosNuevos(PolizaIndividual datosNuevos) {
		this.datosNuevos = datosNuevos;
	}
	/**
	 * @return the mostrarBotonGuardar
	 */
	public boolean isMostrarBotonGuardar() {
		return mostrarBotonGuardar;
	}
	/**
	 * @param mostrarBotonGuardar the mostrarBotonGuardar to set
	 */
	public void setMostrarBotonGuardar(boolean mostrarBotonGuardar) {
		this.mostrarBotonGuardar = mostrarBotonGuardar;
	}
	/**
	 * @return the mostrarBotonAplicarRechazar
	 */
	public boolean isMostrarBotonAplicarRechazar() {
		return mostrarBotonAplicarRechazar;
	}
	/**
	 * @param mostrarBotonAplicarRechazar the mostrarBotonAplicarRechazar to set
	 */
	public void setMostrarBotonAplicarRechazar(boolean mostrarBotonAplicarRechazar) {
		this.mostrarBotonAplicarRechazar = mostrarBotonAplicarRechazar;
	}
	/**
	 * @return the comentarioNuevo
	 */
	public String getComentarioNuevo() {
		return comentarioNuevo;
	}
	/**
	 * @param comentarioNuevo the comentarioNuevo to set
	 */
	public void setComentarioNuevo(String comentarioNuevo) {
		this.comentarioNuevo = comentarioNuevo;
	}
	/**
	 * @return the aseguradoInexistente
	 */
	public boolean isAseguradoInexistente() {
		return aseguradoInexistente;
	}
	/**
	 * @param aseguradoInexistente the aseguradoInexistente to set
	 */
	public void setAseguradoInexistente(boolean aseguradoInexistente) {
		this.aseguradoInexistente = aseguradoInexistente;
	}
	/**
	 * @return the existenPagosAplicados
	 */
	public boolean isExistenPagosAplicados() {
		return existenPagosAplicados;
	}
	/**
	 * @param existenPagosAplicados the existenPagosAplicados to set
	 */
	public void setExistenPagosAplicados(boolean existenPagosAplicados) {
		this.existenPagosAplicados = existenPagosAplicados;
	}

}
