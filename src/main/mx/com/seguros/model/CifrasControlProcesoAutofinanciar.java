/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Objeto de mapeo a BD de cifras de control del proceso batch de autofinanciar
 * @author Emigdio Hernandez
 *
 */
public class CifrasControlProcesoAutofinanciar implements Serializable {
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador
	 */
	int idCifrasControlProcesoAutofinanciar = 0;
	/**
	 * Fecha y hora del inicio del proceso
	 */
	Date fechaHoraInicio=null;
	/**
	 * Fecha y hora del fin del proceso
	 */
	Date fechaHoraFin=null;
	/**
	 * Total de pólizas consultadas
	 */
	long totalRegistrosProcesados=0;
	/**
	 * Total de descuentos que lograron aplicarse
	 */
	long totalDescuentosAplicados=0;
	/**
	 * Log y observaciones
	 */
	String log=null;
	/**
	 * @return the idCifrasControlProcesoAutofinanciar
	 */
	public int getIdCifrasControlProcesoAutofinanciar() {
		return idCifrasControlProcesoAutofinanciar;
	}
	/**
	 * @param idCifrasControlProcesoAutofinanciar the idCifrasControlProcesoAutofinanciar to set
	 */
	public void setIdCifrasControlProcesoAutofinanciar(
			int idCifrasControlProcesoAutofinanciar) {
		this.idCifrasControlProcesoAutofinanciar = idCifrasControlProcesoAutofinanciar;
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
	 * @return the totalRegistrosProcesados
	 */
	public long getTotalRegistrosProcesados() {
		return totalRegistrosProcesados;
	}
	/**
	 * @param totalRegistrosProcesados the totalRegistrosProcesados to set
	 */
	public void setTotalRegistrosProcesados(long totalRegistrosProcesados) {
		this.totalRegistrosProcesados = totalRegistrosProcesados;
	}
	/**
	 * @return the totalDescuentosAplicados
	 */
	public long getTotalDescuentosAplicados() {
		return totalDescuentosAplicados;
	}
	/**
	 * @param totalDescuentosAplicados the totalDescuentosAplicados to set
	 */
	public void setTotalDescuentosAplicados(long totalDescuentosAplicados) {
		this.totalDescuentosAplicados = totalDescuentosAplicados;
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
