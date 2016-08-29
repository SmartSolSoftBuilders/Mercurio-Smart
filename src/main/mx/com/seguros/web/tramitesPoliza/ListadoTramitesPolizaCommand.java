/**
 * 
 */
package mx.com.seguros.web.tramitesPoliza;

import java.io.Serializable;
import java.util.Date;

/**
 * Objeto de Command para las peticiones
 * de registro de un nuevo trámite de póliza
 * @author Emigdio Hernández
 *
 */
public class ListadoTramitesPolizaCommand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2499022318881533796L;

	private Date fechaTramite;
	private Integer idTipoTramiteInicial;
	private Integer idTipoTramiteFinal;
	private Integer idOficina;
	private Integer numPoliza;
	private Integer numConsignatario;
	
	private String telefono;
	private String comentariosAsegurado;
	private String comentariosAsesor;
	private String observaciones;
	/**
	 * @return the fechaTramite
	 */
	public Date getFechaTramite() {
		return fechaTramite;
	}
	/**
	 * @param fechaTramite the fechaTramite to set
	 */
	public void setFechaTramite(Date fechaTramite) {
		this.fechaTramite = fechaTramite;
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
