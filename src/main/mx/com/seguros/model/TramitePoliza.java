/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO que representa los registros de los Trámites de las Pólizas
 * @author Emigdio Hernandez
 *
 */
public class TramitePoliza implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idTramitePoliza = null;
	private Integer idTipoTramiteInicial = null;
	private Integer idTipoTramiteFinal = null;
	private Integer idOficina = null;
	
	private Integer numPoliza = null;
	private Integer numConsignatario = null;
	
	private Date fecha = null;
	
	private String usuario = null;
	
	private String telefono = null;
	private String comentariosAsegurado = null;
	private String comentariosAsesor = null;
	private String observaciones = null;
	
	private TipoTramite tipoTramiteInicial = null;
	private TipoTramite tipoTramiteFinal = null;
	private Oficina oficina;
	/**
	 * @return the idTramitePoliza
	 */
	public Integer getIdTramitePoliza() {
		return idTramitePoliza;
	}
	/**
	 * @param idTramitePoliza the idTramitePoliza to set
	 */
	public void setIdTramitePoliza(Integer idTramitePoliza) {
		this.idTramitePoliza = idTramitePoliza;
	}
	/**
	 * @return the idTipoTramiteInicial
	 */
	public Integer getIdTipoTramiteInicial() {
		return idTipoTramiteInicial;
	}
	/**
	 * @param idTipoTramiteInicial the idTipoTramiteInicial to set
	 */
	public void setIdTipoTramiteInicial(Integer idTipoTramiteInicial) {
		this.idTipoTramiteInicial = idTipoTramiteInicial;
	}
	/**
	 * @return the idTipoTramiteFinal
	 */
	public Integer getIdTipoTramiteFinal() {
		return idTipoTramiteFinal;
	}
	/**
	 * @param idTipoTramiteFinal the idTipoTramiteFinal to set
	 */
	public void setIdTipoTramiteFinal(Integer idTipoTramiteFinal) {
		this.idTipoTramiteFinal = idTipoTramiteFinal;
	}
	/**
	 * @return the idOficina
	 */
	public Integer getIdOficina() {
		return idOficina;
	}
	/**
	 * @param idOficina the idOficina to set
	 */
	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
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
	/**
	 * @return the tipoTramiteInicial
	 */
	public TipoTramite getTipoTramiteInicial() {
		return tipoTramiteInicial;
	}
	/**
	 * @param tipoTramiteInicial the tipoTramiteInicial to set
	 */
	public void setTipoTramiteInicial(TipoTramite tipoTramiteInicial) {
		this.tipoTramiteInicial = tipoTramiteInicial;
	}
	/**
	 * @return the tipoTramiteFinal
	 */
	public TipoTramite getTipoTramiteFinal() {
		return tipoTramiteFinal;
	}
	/**
	 * @param tipoTramiteFinal the tipoTramiteFinal to set
	 */
	public void setTipoTramiteFinal(TipoTramite tipoTramiteFinal) {
		this.tipoTramiteFinal = tipoTramiteFinal;
	}
	/**
	 * @return the oficina
	 */
	public Oficina getOficina() {
		return oficina;
	}
	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
			

}
