/**
 * 
 */
package mx.com.seguros.model;

import java.util.Date;

/**
 * Clase del modelo que representa la tabla de BitacoraEmisionReporte
 * @author Emigdio Hernández
 *
 */
public class BitacoraEmisionReporte {
	Integer idBitacoraEmisionReporte = null;
	String usuario = null;
	Date fechaEmision = null;
	String nombreReporte = null;
	String nombreArchivoGenerado = null;
	String comentario = null;
	/**
	 * @return the idBitacoraEmisionReporte
	 */
	public Integer getIdBitacoraEmisionReporte() {
		return idBitacoraEmisionReporte;
	}
	/**
	 * @param idBitacoraEmisionReporte the idBitacoraEmisionReporte to set
	 */
	public void setIdBitacoraEmisionReporte(Integer idBitacoraEmisionReporte) {
		this.idBitacoraEmisionReporte = idBitacoraEmisionReporte;
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
	 * @return the fechaEmision
	 */
	public Date getFechaEmision() {
		return fechaEmision;
	}
	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	/**
	 * @return the nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}
	/**
	 * @param nombreReporte the nombreReporte to set
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}
	/**
	 * @return the nombreArchivoGenerado
	 */
	public String getNombreArchivoGenerado() {
		return nombreArchivoGenerado;
	}
	/**
	 * @param nombreArchivoGenerado the nombreArchivoGenerado to set
	 */
	public void setNombreArchivoGenerado(String nombreArchivoGenerado) {
		this.nombreArchivoGenerado = nombreArchivoGenerado;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
