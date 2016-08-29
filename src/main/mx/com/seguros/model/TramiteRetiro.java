/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Objeto que representa un registro de un trámite de retiro
 * @author Emigdio Hernández
 *
 */
public class TramiteRetiro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5238796576429616405L;
	private long idTramiteRetiro = 0;
	private String numNominaContratante= null;
	private Date fechaTramite= null;
	private double importeOriginal = 0;
	private double importeAplicado = 0;
	private String observacionConcepto = null;
	private String nombreOperador = null;
	private String nombreSucursal = null;
	private Long transaccionId = null;
	private Long idArchivoRetirosCargado = null;
	private String username = null;
	private Integer numPoliza = null;
	private Integer numConsignatario = null;
	/**
	 * @return the idTramiteRetiro
	 */
	public long getIdTramiteRetiro() {
		return idTramiteRetiro;
	}
	/**
	 * @param idTramiteRetiro the idTramiteRetiro to set
	 */
	public void setIdTramiteRetiro(long idTramiteRetiro) {
		this.idTramiteRetiro = idTramiteRetiro;
	}
	/**
	 * @return the numNominaContratante
	 */
	public String getNumNominaContratante() {
		return numNominaContratante;
	}
	/**
	 * @param numNominaContratante the numNominaContratante to set
	 */
	public void setNumNominaContratante(String numNominaContratante) {
		this.numNominaContratante = numNominaContratante;
	}
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
	 * @return the importeOriginal
	 */
	public double getImporteOriginal() {
		return importeOriginal;
	}
	/**
	 * @param importeOriginal the importeOriginal to set
	 */
	public void setImporteOriginal(double importeOriginal) {
		this.importeOriginal = importeOriginal;
	}
	/**
	 * @return the importeAplicado
	 */
	public double getImporteAplicado() {
		return importeAplicado;
	}
	/**
	 * @param importeAplicado the importeAplicado to set
	 */
	public void setImporteAplicado(double importeAplicado) {
		this.importeAplicado = importeAplicado;
	}
	/**
	 * @return the observacionConcepto
	 */
	public String getObservacionConcepto() {
		return observacionConcepto;
	}
	/**
	 * @param observacionConcepto the observacionConcepto to set
	 */
	public void setObservacionConcepto(String observacionConcepto) {
		this.observacionConcepto = observacionConcepto;
	}
	/**
	 * @return the nombreOperador
	 */
	public String getNombreOperador() {
		return nombreOperador;
	}
	/**
	 * @param nombreOperador the nombreOperador to set
	 */
	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
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
	 * @return the transaccionId
	 */
	public Long getTransaccionId() {
		return transaccionId;
	}
	/**
	 * @param transaccionId the transaccionId to set
	 */
	public void setTransaccionId(Long transaccionId) {
		this.transaccionId = transaccionId;
	}
	/**
	 * @return the idArchivoRetirosCargado
	 */
	public Long getIdArchivoRetirosCargado() {
		return idArchivoRetirosCargado;
	}
	/**
	 * @param idArchivoRetirosCargado the idArchivoRetirosCargado to set
	 */
	public void setIdArchivoRetirosCargado(Long idArchivoRetirosCargado) {
		this.idArchivoRetirosCargado = idArchivoRetirosCargado;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	
}
