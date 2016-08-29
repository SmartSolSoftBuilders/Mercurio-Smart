package mx.com.seguros.web.inburnomina;

import java.util.Date;

/**
 * Command class para el registro de productos de inburnomina integral
 * @author Emigdio Hernandez
 */
public class RegistrarProductosInburnominaCommand {
    
	private String numPoliza = null;
	private String numConsignatario = null;
	private Boolean indRcLicencia = false;
	private Boolean indInburmedic = false;
	private Boolean indSeguCancer = false;
	private String numLicencia = null;
	private String cvePlaza = null;
	private String numCertificado = null;
	private String primaMensualLicencia = null;
	private String primaMensualInburmedic = null;
	private String primaMensualSeguCancer = null;
	
	private String numPolizaRcLicencia = null;
	private String numConsignatarioRcLicencia = null;
	private String fechaVigenciaRcLicencia = null;
	
	private String numPolizaInburmedic = null;
	private String numConsignatarioInburmedic = null;
	private String fechaVigenciaInburmedic = null;
	
	private String numPolizaSeguCancer = null;
	private String numConsignatarioSeguCancer = null;
	private String fechaVigenciaSeguCancer = null;
	
	
	/**
	 * 
	 * 
	 * @return the numPoliza
	 */
	public String getNumPoliza() {
		return numPoliza;
	}
	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}
	/**
	 * @return the numConsignatario
	 */
	public String getNumConsignatario() {
		return numConsignatario;
	}
	/**
	 * @param numConsignatario the numConsignatario to set
	 */
	public void setNumConsignatario(String numConsignatario) {
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
	public String getPrimaMensualLicencia() {
		return primaMensualLicencia;
	}
	/**
	 * @param primaMensualLicencia the primaMensualLicencia to set
	 */
	public void setPrimaMensualLicencia(String primaMensualLicencia) {
		this.primaMensualLicencia = primaMensualLicencia;
	}
	/**
	 * @return the primaMensualInburmedic
	 */
	public String getPrimaMensualInburmedic() {
		return primaMensualInburmedic;
	}
	/**
	 * @param primaMensualInburmedic the primaMensualInburmedic to set
	 */
	public void setPrimaMensualInburmedic(String primaMensualInburmedic) {
		this.primaMensualInburmedic = primaMensualInburmedic;
	}
	/**
	 * @return the primaMensualSeguCancer
	 */
	public String getPrimaMensualSeguCancer() {
		return primaMensualSeguCancer;
	}
	/**
	 * @param primaMensualSeguCancer the primaMensualSeguCancer to set
	 */
	public void setPrimaMensualSeguCancer(String primaMensualSeguCancer) {
		this.primaMensualSeguCancer = primaMensualSeguCancer;
	}
	/**
	 * @return the cvePlaza
	 */
	public String getCvePlaza() {
		return cvePlaza;
	}
	/**
	 * @param cvePlaza the cvePlaza to set
	 */
	public void setCvePlaza(String cvePlaza) {
		this.cvePlaza = cvePlaza;
	}
	/**
	 * @return the numCertificado
	 */
	public String getNumCertificado() {
		return numCertificado;
	}
	/**
	 * @param numCertificado the numCertificado to set
	 */
	public void setNumCertificado(String numCertificado) {
		this.numCertificado = numCertificado;
	}
	/**
	 * @return the numPolizaRcLicencia
	 */
	public String getNumPolizaRcLicencia() {
		return numPolizaRcLicencia;
	}
	/**
	 * @param numPolizaRcLicencia the numPolizaRcLicencia to set
	 */
	public void setNumPolizaRcLicencia(String numPolizaRcLicencia) {
		this.numPolizaRcLicencia = numPolizaRcLicencia;
	}
	/**
	 * @return the numConsignatarioRcLicencia
	 */
	public String getNumConsignatarioRcLicencia() {
		return numConsignatarioRcLicencia;
	}
	/**
	 * @param numConsignatarioRcLicencia the numConsignatarioRcLicencia to set
	 */
	public void setNumConsignatarioRcLicencia(String numConsignatarioRcLicencia) {
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
	public String getNumPolizaInburmedic() {
		return numPolizaInburmedic;
	}
	/**
	 * @param numPolizaInburmedic the numPolizaInburmedic to set
	 */
	public void setNumPolizaInburmedic(String numPolizaInburmedic) {
		this.numPolizaInburmedic = numPolizaInburmedic;
	}
	/**
	 * @return the numConsignatarioInburmedic
	 */
	public String getNumConsignatarioInburmedic() {
		return numConsignatarioInburmedic;
	}
	/**
	 * @param numConsignatarioInburmedic the numConsignatarioInburmedic to set
	 */
	public void setNumConsignatarioInburmedic(String numConsignatarioInburmedic) {
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
	public String getNumPolizaSeguCancer() {
		return numPolizaSeguCancer;
	}
	/**
	 * @param numPolizaSeguCancer the numPolizaSeguCancer to set
	 */
	public void setNumPolizaSeguCancer(String numPolizaSeguCancer) {
		this.numPolizaSeguCancer = numPolizaSeguCancer;
	}
	/**
	 * @return the numConsignatarioSeguCancer
	 */
	public String getNumConsignatarioSeguCancer() {
		return numConsignatarioSeguCancer;
	}
	/**
	 * @param numConsignatarioSeguCancer the numConsignatarioSeguCancer to set
	 */
	public void setNumConsignatarioSeguCancer(String numConsignatarioSeguCancer) {
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
