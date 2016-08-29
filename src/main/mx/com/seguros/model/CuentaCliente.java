/**
 * 
 */
package mx.com.seguros.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Objeto del modelo que representa la tabla CuentaCliente
 * @author SmartSolutions
 *
 */
public class CuentaCliente {
	
	private BigDecimal saldoCuenta;
	private Date fechaCalculoSaldo;
	private Integer transaccionId;
	private Integer numPoliza = null;
	private Integer numConsignatario = null;
	private String numNominaContratante = null;
	
	public CuentaCliente(){}
	
	public CuentaCliente(Integer numPoliza2, Integer numConsignatario2) {
		numPoliza = numPoliza2;
		numConsignatario = numConsignatario2;
	}
	/**
	 * @return the saldoCuenta
	 */
	public BigDecimal getSaldoCuenta() {
		return saldoCuenta;
	}
	/**
	 * @param saldoCuenta the saldoCuenta to set
	 */
	public void setSaldoCuenta(BigDecimal saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	/**
	 * @return the fechaCalculoSaldo
	 */
	public Date getFechaCalculoSaldo() {
		return fechaCalculoSaldo;
	}
	/**
	 * @param fechaCalculoSaldo the fechaCalculoSaldo to set
	 */
	public void setFechaCalculoSaldo(Date fechaCalculoSaldo) {
		this.fechaCalculoSaldo = fechaCalculoSaldo;
	}
	/**
	 * @return the transaccionId
	 */
	public Integer getTransaccionId() {
		return transaccionId;
	}
	/**
	 * @param transaccionId the transaccionId to set
	 */
	public void setTransaccionId(Integer transaccionId) {
		this.transaccionId = transaccionId;
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

}
