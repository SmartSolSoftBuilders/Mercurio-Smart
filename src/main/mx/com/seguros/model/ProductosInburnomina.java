/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Objeto del modelo que representa la tabla con la información de los productos inburnomina integral
 * por poliza
 * @author Emigdio
 *
 */
public class ProductosInburnomina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2565458240054963792L;
	
	private Integer numPoliza = null;
	private Integer numConsignatario = null;
	private Boolean indRcLicencia = false;
	private Boolean indInburmedic = false;
	private Boolean indSeguCancer = false;
	private String numLicencia = null;
	private Double primaMensualLicencia = null;
	private Double primaMensualInburmedic = null;
	private Double primaMensualSeguCancer = null;
	private Date fechaUltimaModif = null;
	
	private Integer numPolizaRcLicencia = null;
	private Integer numConsignatarioRcLicencia = null;
	private String fechaVigenciaRcLicencia = null;
	
	private Integer numPolizaInburmedic = null;
	private Integer numConsignatarioInburmedic = null;
	private String fechaVigenciaInburmedic = null;
	
	private Integer numPolizaSeguCancer = null;
	private Integer numConsignatarioSeguCancer = null;
	private String fechaVigenciaSeguCancer = null;
	
	private String usuario = null;
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
	 * @return the indRcLicencia
	 */
	public Boolean getIndRcLicencia() {
		return indRcLicencia;
	}
	/**
	 * @param indRcLicencia the indRcLicencia to set
	 */
	public void setIndRcLicencia(Boolean indRcLicencia) {
		this.indRcLicencia = indRcLicencia;
	}
	/**
	 * @return the indInburmedic
	 */
	public Boolean getIndInburmedic() {
		return indInburmedic;
	}
	/**
	 * @param indInburmedic the indInburmedic to set
	 */
	public void setIndInburmedic(Boolean indInburmedic) {
		this.indInburmedic = indInburmedic;
	}
	/**
	 * @return the indSeguCancer
	 */
	public Boolean getIndSeguCancer() {
		return indSeguCancer;
	}
	/**
	 * @param indSeguCancer the indSeguCancer to set
	 */
	public void setIndSeguCancer(Boolean indSeguCancer) {
		this.indSeguCancer = indSeguCancer;
	}
	/**
	 * @return the numLicencia
	 */
	public String getNumLicencia() {
		return numLicencia;
	}
	/**
	 * @param numLicencia the numLicencia to set
	 */
	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}
	/**
	 * @return the primaMensualLicencia
	 */
	public Double getPrimaMensualLicencia() {
		return primaMensualLicencia;
	}
	/**
	 * @param primaMensualLicencia the primaMensualLicencia to set
	 */
	public void setPrimaMensualLicencia(Double primaMensualLicencia) {
		this.primaMensualLicencia = primaMensualLicencia;
	}
	/**
	 * @return the primaMensualInburmedic
	 */
	public Double getPrimaMensualInburmedic() {
		return primaMensualInburmedic;
	}
	/**
	 * @param primaMensualInburmedic the primaMensualInburmedic to set
	 */
	public void setPrimaMensualInburmedic(Double primaMensualInburmedic) {
		this.primaMensualInburmedic = primaMensualInburmedic;
	}
	/**
	 * @return the primaMensualSeguCancer
	 */
	public Double getPrimaMensualSeguCancer() {
		return primaMensualSeguCancer;
	}
	/**
	 * @param primaMensualSeguCancer the primaMensualSeguCancer to set
	 */
	public void setPrimaMensualSeguCancer(Double primaMensualSeguCancer) {
		this.primaMensualSeguCancer = primaMensualSeguCancer;
	}
	/**
	 * @return the fechaUltimaModif
	 */
	public Date getFechaUltimaModif() {
		return fechaUltimaModif;
	}
	/**
	 * @param fechaUltimaModif the fechaUltimaModif to set
	 */
	public void setFechaUltimaModif(Date fechaUltimaModif) {
		this.fechaUltimaModif = fechaUltimaModif;
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
	
	public double getTotalPrimaMensual(){
		double prima = 0;
		if(primaMensualInburmedic != null){
			prima+=primaMensualInburmedic;
		}
		if(primaMensualLicencia!=null){
			prima+=primaMensualLicencia;
		}
		if(primaMensualSeguCancer!=null){
			prima+=primaMensualSeguCancer;
		}
		return prima;
	}
	
	public double getTotalPrimaQuincenal(){
		return getTotalPrimaMensual()/2.0;
	}
	/**
	 * @return the numPolizaRcLicencia
	 */
	public Integer getNumPolizaRcLicencia() {
		return numPolizaRcLicencia;
	}
	/**
	 * @param numPolizaRcLicencia the numPolizaRcLicencia to set
	 */
	public void setNumPolizaRcLicencia(Integer numPolizaRcLicencia) {
		this.numPolizaRcLicencia = numPolizaRcLicencia;
	}
	/**
	 * @return the numConsignatarioRcLicencia
	 */
	public Integer getNumConsignatarioRcLicencia() {
		return numConsignatarioRcLicencia;
	}
	/**
	 * @param numConsignatarioRcLicencia the numConsignatarioRcLicencia to set
	 */
	public void setNumConsignatarioRcLicencia(Integer numConsignatarioRcLicencia) {
		this.numConsignatarioRcLicencia = numConsignatarioRcLicencia;
	}
	/**
	 * @return the fechaVigenciaRcLicencia
	 */
	public String getFechaVigenciaRcLicencia() {
		return fechaVigenciaRcLicencia;
	}
	/**
	 * @param fechaVigenciaRcLicencia the fechaVigenciaRcLicencia to set
	 */
	public void setFechaVigenciaRcLicencia(String fechaVigenciaRcLicencia) {
		this.fechaVigenciaRcLicencia = fechaVigenciaRcLicencia;
	}
	/**
	 * @return the numPolizaInburmedic
	 */
	public Integer getNumPolizaInburmedic() {
		return numPolizaInburmedic;
	}
	/**
	 * @param numPolizaInburmedic the numPolizaInburmedic to set
	 */
	public void setNumPolizaInburmedic(Integer numPolizaInburmedic) {
		this.numPolizaInburmedic = numPolizaInburmedic;
	}
	/**
	 * @return the numConsignatarioInburmedic
	 */
	public Integer getNumConsignatarioInburmedic() {
		return numConsignatarioInburmedic;
	}
	/**
	 * @param numConsignatarioInburmedic the numConsignatarioInburmedic to set
	 */
	public void setNumConsignatarioInburmedic(Integer numConsignatarioInburmedic) {
		this.numConsignatarioInburmedic = numConsignatarioInburmedic;
	}
	/**
	 * @return the fechaVigenciaInburmedic
	 */
	public String getFechaVigenciaInburmedic() {
		return fechaVigenciaInburmedic;
	}
	/**
	 * @param fechaVigenciaInburmedic the fechaVigenciaInburmedic to set
	 */
	public void setFechaVigenciaInburmedic(String fechaVigenciaInburmedic) {
		this.fechaVigenciaInburmedic = fechaVigenciaInburmedic;
	}
	/**
	 * @return the numPolizaSeguCancer
	 */
	public Integer getNumPolizaSeguCancer() {
		return numPolizaSeguCancer;
	}
	/**
	 * @param numPolizaSeguCancer the numPolizaSeguCancer to set
	 */
	public void setNumPolizaSeguCancer(Integer numPolizaSeguCancer) {
		this.numPolizaSeguCancer = numPolizaSeguCancer;
	}
	/**
	 * @return the numConsignatarioSeguCancer
	 */
	public Integer getNumConsignatarioSeguCancer() {
		return numConsignatarioSeguCancer;
	}
	/**
	 * @param numConsignatarioSeguCancer the numConsignatarioSeguCancer to set
	 */
	public void setNumConsignatarioSeguCancer(Integer numConsignatarioSeguCancer) {
		this.numConsignatarioSeguCancer = numConsignatarioSeguCancer;
	}
	/**
	 * @return the fechaVigenciaSeguCancer
	 */
	public String getFechaVigenciaSeguCancer() {
		return fechaVigenciaSeguCancer;
	}
	/**
	 * @param fechaVigenciaSeguCancer the fechaVigenciaSeguCancer to set
	 */
	public void setFechaVigenciaSeguCancer(String fechaVigenciaSeguCancer) {
		this.fechaVigenciaSeguCancer = fechaVigenciaSeguCancer;
	}

}
