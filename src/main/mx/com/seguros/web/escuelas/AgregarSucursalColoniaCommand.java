/**
 * 
 */
package mx.com.seguros.web.escuelas;

/**
 * Command para agregar nuevos valores a los catálogos de lozalicación de escuela
 * @author Emigdio Hernandez
 *
 */
public class AgregarSucursalColoniaCommand {

	
	private Integer cveSucursal = null;
	private String nombreSucursal = null;
	private Integer cveColonia = null;
	private String tipoAsentamiento = null;
	private String municipio = null;
	private String estado = null;
	private String asentamiento = null;
	/**
	 * @return the cveSucursal
	 */
	public Integer getCveSucursal() {
		return cveSucursal;
	}
	/**
	 * @param cveSucursal the cveSucursal to set
	 */
	public void setCveSucursal(Integer cveSucursal) {
		this.cveSucursal = cveSucursal;
	}
	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	/**
	 * @return the cveColonia
	 */
	public Integer getCveColonia() {
		return cveColonia;
	}
	/**
	 * @param cveColonia the cveColonia to set
	 */
	public void setCveColonia(Integer cveColonia) {
		this.cveColonia = cveColonia;
	}
	/**
	 * @return the tipoAsentamiento
	 */
	public String getTipoAsentamiento() {
		return tipoAsentamiento;
	}
	/**
	 * @param tipoAsentamiento the tipoAsentamiento to set
	 */
	public void setTipoAsentamiento(String tipoAsentamiento) {
		this.tipoAsentamiento = tipoAsentamiento;
	}
	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the asentamiento
	 */
	public String getAsentamiento() {
		return asentamiento;
	}
	/**
	 * @param asentamiento the asentamiento to set
	 */
	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}
}
