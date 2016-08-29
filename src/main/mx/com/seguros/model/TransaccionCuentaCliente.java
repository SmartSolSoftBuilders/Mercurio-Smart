/**
 * 
 */
package mx.com.seguros.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase del modelo que representa la tabla TransaccionCuentaCliente
 * @author SmartSolutions
 *
 */
public class TransaccionCuentaCliente {
	
	private long transaccionId;
	private int cveTipoTransaccion;
	private Date fechaTransaccion;
	private BigDecimal importeTransaccion;
	private Integer numPoliza = null;
	private Integer numConsignatario = null;
	private TipoTransaccionCuentaCliente tipoTransaccionCuentaCliente = new TipoTransaccionCuentaCliente();
	public TransaccionCuentaCliente(){}
	public TransaccionCuentaCliente(int cveTipoTransaccion){
		this.cveTipoTransaccion = cveTipoTransaccion;
		tipoTransaccionCuentaCliente.setCveTipoTransaccion(cveTipoTransaccion);
	}
	/**
	 * @return the transaccionId
	 */
	public long getTransaccionId() {
		return transaccionId;
	}
	/**
	 * @param transaccionId the transaccionId to set
	 */
	public void setTransaccionId(long transaccionId) {
		this.transaccionId = transaccionId;
	}
	/**
	 * @return the cveTipoTransaccion
	 */
	public int getCveTipoTransaccion() {
		return cveTipoTransaccion;
	}
	/**
	 * @param cveTipoTransaccion the cveTipoTransaccion to set
	 */
	public void setCveTipoTransaccion(int cveTipoTransaccion) {
		this.cveTipoTransaccion = cveTipoTransaccion;
	}
	/**
	 * @return the fechaTransaccion
	 */
	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}
	/**
	 * @param fechaTransaccion the fechaTransaccion to set
	 */
	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	/**
	 * @return the importeTransaccion
	 */
	public BigDecimal getImporteTransaccion() {
		return importeTransaccion;
	}
	/**
	 * @param importeTransaccion the importeTransaccion to set
	 */
	public void setImporteTransaccion(BigDecimal importeTransaccion) {
		this.importeTransaccion = importeTransaccion;
	}
	/**
	 * @return the tipoTransaccionCuentaCliente
	 */
	public TipoTransaccionCuentaCliente getTipoTransaccionCuentaCliente() {
		return tipoTransaccionCuentaCliente;
	}
	/**
	 * @param tipoTransaccionCuentaCliente the tipoTransaccionCuentaCliente to set
	 */
	public void setTipoTransaccionCuentaCliente(
			TipoTransaccionCuentaCliente tipoTransaccionCuentaCliente) {
		this.tipoTransaccionCuentaCliente = tipoTransaccionCuentaCliente;
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
