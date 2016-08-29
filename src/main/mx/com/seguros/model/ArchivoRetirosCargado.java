/*
 * Smart Solutions Septiembre 2013
 */
package mx.com.seguros.model;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * Objeto que representa un Archivo de Retiros Realizados por asegurados
 * @author Emigdio Hernandez
 */
public class ArchivoRetirosCargado implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador del archivo cargado
	 */
	private long idArchivoRetirosCargado;
    /**
     * Usuario que carga el archivo
     */
    private String username;
    /**
     * Fecha y hora de la carga del archivo
     */
    private Date fechaCarga;
    /**
     * Archivo cargado
     */
    private byte[] archivo;
    
    /**
     * Número de registros del archivo
     */
    private long numeroRegistros=0;
    /**
     * Nombre del archivo excel cargado
     */
    private String nombreArchivo;
    /**
     * Fecha y hora de inicio de la carga
     */
    private Date fechaHoraInicio;
    /**
     * Fecha y hora de fin de la carga
     */
    private Date fechaHoraFin;
    /**
     * Log del proceso de carga del archivo
     */
    private String log;
	/**
	 * @return the idArchivoRetirosCargados
	 */
	public long getIdArchivoRetirosCargado() {
		return idArchivoRetirosCargado;
	}
	/**
	 * @param idArchivoRetirosCargados the idArchivoRetirosCargados to set
	 */
	public void setIdArchivoRetirosCargado(long idArchivoRetirosCargados) {
		this.idArchivoRetirosCargado = idArchivoRetirosCargados;
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
	public long getNumeroRegistros() {
		return numeroRegistros;
	}
	/**
	 * @param numeroRegistros the numeroRegistros to set
	 */
	public void setNumeroRegistros(long numeroRegistros) {
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
    
	
   
   
}
