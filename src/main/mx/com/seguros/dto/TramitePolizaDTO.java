/**
 * 
 */
package mx.com.seguros.dto;

import java.io.Serializable;

/**
 * DTO para enviar la información del trámite de póliza en formato
 * XML
 * @author Emigdio Hernandez
 *
 */
public class TramitePolizaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8911674683496869983L;

	private String fecha;
	private String tipoTramiteInicial;
	private String tipoTramiteFinal;
	private String oficina;
	private String usuario;
	private String telefono;
	private String comentariosAsegurado = null;
	private String comentariosAsesor = null;
	private String observaciones = null;
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the tipoTramiteInicial
	 */
	public String getTipoTramiteInicial() {
		return tipoTramiteInicial;
	}
	/**
	 * @param tipoTramiteInicial the tipoTramiteInicial to set
	 */
	public void setTipoTramiteInicial(String tipoTramiteInicial) {
		this.tipoTramiteInicial = tipoTramiteInicial;
	}
	/**
	 * @return the tipoTramiteFinal
	 */
	public String getTipoTramiteFinal() {
		return tipoTramiteFinal;
	}
	/**
	 * @param tipoTramiteFinal the tipoTramiteFinal to set
	 */
	public void setTipoTramiteFinal(String tipoTramiteFinal) {
		this.tipoTramiteFinal = tipoTramiteFinal;
	}
	/**
	 * @return the oficina
	 */
	public String getOficina() {
		return oficina;
	}
	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(String oficina) {
		this.oficina = oficina;
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the comentariosAsegurado
	 */
	public String getComentariosAsegurado() {
		return comentariosAsegurado;
	}
	/**
	 * @param comentariosAsegurado the comentariosAsegurado to set
	 */
	public void setComentariosAsegurado(String comentariosAsegurado) {
		this.comentariosAsegurado = comentariosAsegurado;
	}
	/**
	 * @return the comentariosAsesor
	 */
	public String getComentariosAsesor() {
		return comentariosAsesor;
	}
	/**
	 * @param comentariosAsesor the comentariosAsesor to set
	 */
	public void setComentariosAsesor(String comentariosAsesor) {
		this.comentariosAsesor = comentariosAsesor;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
