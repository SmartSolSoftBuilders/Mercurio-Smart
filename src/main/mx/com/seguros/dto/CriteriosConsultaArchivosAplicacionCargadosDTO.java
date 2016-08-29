/*
 * Smart Solutions Noviembre 2012 
 */
package mx.com.seguros.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO que contiene los criterios de consulta aplicables a las búsquedas
 * de los archivos de aplicación de pagos en base de datos
 * @author Emigdio Hernandez
 *
 */
public class CriteriosConsultaArchivosAplicacionCargadosDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Fechas de carga
	 */
	private Date fechaCargaInicial = null;
	private Date fechaCargaFinal = null;
	/**
	 * Usuario
	 */
	private String claveUsuario = null;
	/**
	 * Plaza
	 */
	private Integer idPlaza = null;
	private String cvePlaza = null;
	/**
	 * Quincenas
	 */
	private Integer numQuincena = null;
	public Date getFechaCargaInicial() {
		return fechaCargaInicial;
	}
	public void setFechaCargaInicial(Date fechaCargaInicial) {
		this.fechaCargaInicial = fechaCargaInicial;
	}
	public Date getFechaCargaFinal() {
		return fechaCargaFinal;
	}
	public void setFechaCargaFinal(Date fechaCargaFinal) {
		this.fechaCargaFinal = fechaCargaFinal;
	}
	public String getClaveUsuario() {
		return claveUsuario;
	}
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	public Integer getIdPlaza() {
		return idPlaza;
	}
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}
	public String getCvePlaza() {
		return cvePlaza;
	}
	public void setCvePlaza(String cvePlaza) {
		this.cvePlaza = cvePlaza;
	}
	public Integer getNumQuincena() {
		return numQuincena;
	}
	public void setNumQuincena(Integer numQuincena) {
		this.numQuincena = numQuincena;
	}
	
}
