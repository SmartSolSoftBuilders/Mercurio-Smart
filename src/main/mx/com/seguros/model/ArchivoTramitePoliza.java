/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO que representa un registro de la tabla de ArchivoTramitePoliza
 * @author Emigdio Hernandez
 *
 */
public class ArchivoTramitePoliza implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193819819339905192L;

	/**
	 * Identificador único de la tabla
	 */
	private Integer idArchivoTramitePoliza;
	/**
	 * Día de carga del archivo
	 */
	private Date fechaCarga;
	/**
	 * Usuario que realiza la carga del archivo
	 */
	private String usuario;
	/**
	 * Fecha y hora de inicio del proceso de carga
	 */
	private Date fechaHoraInicio;
	/**
	 * Fecha de fin del proceso de carga
	 */
	private Date fechaHoraFin;
	/**
	 * Log del proceso
	 */
	private String log;
	/**
     * Archivo cargado
     */
    private byte[] archivo;
    /**
     * Número de registros contenidos en el archivo
     */
    private Integer numeroRegistros;
    /**
     * Nombre físico del archivo
     */
    private String nombreArchivo;
	/**
	 * @return the idArchivoTramitePoliza
	 */
	public Integer getIdArchivoTramitePoliza() {
		return idArchivoTramitePoliza;
	}
	/**
	 * @param idArchivoTramitePoliza the idArchivoTramitePoliza to set
	 */
	public void setIdArchivoTramitePoliza(Integer idArchivoTramitePoliza) {
		this.idArchivoTramitePoliza = idArchivoTramitePoliza;
	}
	/**
	 * @return the fechaCarga
	 */
	public Date getFechaCarga() {
		return fechaCarga;
	}
	/**
	 * @param fechaCarga the fechaCarga to set
	 */
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
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
	 * @return the fechaHoraInicio
	 */
	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	/**
	 * @param fechaHoraInicio the fechaHoraInicio to set
	 */
	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	/**
	 * @return the fechaHoraFin
	 */
	public Date getFechaHoraFin() {
		return fechaHoraFin;
	}
	/**
	 * @param fechaHoraFin the fechaHoraFin to set
	 */
	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}
	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}
	/**
	 * @return the archivo
	 */
	public byte[] getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return the numeroRegistros
	 */
	public Integer getNumeroRegistros() {
		return numeroRegistros;
	}
	/**
	 * @param numeroRegistros the numeroRegistros to set
	 */
	public void setNumeroRegistros(Integer numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
    
}
