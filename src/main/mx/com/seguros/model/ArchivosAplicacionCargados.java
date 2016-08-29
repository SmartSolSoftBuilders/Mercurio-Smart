/*
 * Smart Solutions Noviembre 2012
 */
package mx.com.seguros.model;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * Objeto que representa un Archivo de Aplicacion desde la BD
 * @author Emigdio Hernandez
 */
public class ArchivosAplicacionCargados implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador del archivo cargado
	 */
	private long idArchivosAplicacionCargados;
	/**
	 * Número de quincena del archivo
	 */
	private int numQuincena;
	/**
	 * Número consecutivo del archivo
	 */
    private int consecutivoArchivo;
    /**
     * Plaza correspondiente al archivo
     */
    private int idPlaza;
    private Plaza plaza;
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
    
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public long getNumeroRegistros() {
		return numeroRegistros;
	}
	public void setNumeroRegistros(long numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public long getIdArchivosAplicacionCargados() {
		return idArchivosAplicacionCargados;
	}
	public void setIdArchivosAplicacionCargados(long idArchivosAplicacionCargados) {
		this.idArchivosAplicacionCargados = idArchivosAplicacionCargados;
	}
	public int getNumQuincena() {
		return numQuincena;
	}
	public void setNumQuincena(int numQuincena) {
		this.numQuincena = numQuincena;
	}
	public int getConsecutivoArchivo() {
		return consecutivoArchivo;
	}
	public void setConsecutivoArchivo(int consecutivoArchivo) {
		this.consecutivoArchivo = consecutivoArchivo;
	}
	public int getIdPlaza() {
		return idPlaza;
	}
	public void setIdPlaza(int idPlaza) {
		this.idPlaza = idPlaza;
	}
	public Plaza getPlaza() {
		return plaza;
	}
	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
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
