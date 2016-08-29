package mx.com.seguros.model;

/**
 * Objeto de entidad para el mapero de la tabla de beneficio adicional de la póliza
 * @version 1.0
 * @author Emigdio
 *
 */
public class BeneficioAdicionalPoliza {

	private Integer idBeneficioAdicional;
	private Integer numPoliza;
	private Integer numConsignatario;
	private Double sumaBeneficio;
	private Double montoCobertura;
	private String descripcionBeneficio;
	/**
	 * Método de acceso al campo idBeneficioAdicional.
	 * @return El valor del campo idBeneficioAdicional
	 */
	public Integer getIdBeneficioAdicional() {
		return idBeneficioAdicional;
	}
	/**
	 * Asigna el valor al campo idBeneficioAdicional.
	 * @param idBeneficioAdicional el valor idBeneficioAdicional a asignar
	 */
	public void setIdBeneficioAdicional(Integer idBeneficioAdicional) {
		this.idBeneficioAdicional = idBeneficioAdicional;
	}
	/**
	 * Método de acceso al campo numPoliza.
	 * @return El valor del campo numPoliza
	 */
	public Integer getNumPoliza() {
		return numPoliza;
	}
	/**
	 * Asigna el valor al campo numPoliza.
	 * @param numPoliza el valor numPoliza a asignar
	 */
	public void setNumPoliza(Integer numPoliza) {
		this.numPoliza = numPoliza;
	}
	/**
	 * Método de acceso al campo numConsignatario.
	 * @return El valor del campo numConsignatario
	 */
	public Integer getNumConsignatario() {
		return numConsignatario;
	}
	/**
	 * Asigna el valor al campo numConsignatario.
	 * @param numConsignatario el valor numConsignatario a asignar
	 */
	public void setNumConsignatario(Integer numConsignatario) {
		this.numConsignatario = numConsignatario;
	}
	/**
	 * Método de acceso al campo sumaBeneficio.
	 * @return El valor del campo sumaBeneficio
	 */
	public Double getSumaBeneficio() {
		return sumaBeneficio;
	}
	/**
	 * Asigna el valor al campo sumaBeneficio.
	 * @param sumaBeneficio el valor sumaBeneficio a asignar
	 */
	public void setSumaBeneficio(Double sumaBeneficio) {
		this.sumaBeneficio = sumaBeneficio;
	}
	/**
	 * Método de acceso al campo descripcionBeneficio.
	 * @return El valor del campo descripcionBeneficio
	 */
	public String getDescripcionBeneficio() {
		return descripcionBeneficio;
	}
	/**
	 * Asigna el valor al campo descripcionBeneficio.
	 * @param descripcionBeneficio el valor descripcionBeneficio a asignar
	 */
	public void setDescripcionBeneficio(String descripcionBeneficio) {
		this.descripcionBeneficio = descripcionBeneficio;
	}
	/**
	 * @return the montoCobertura
	 */
	public Double getMontoCobertura() {
		return montoCobertura;
	}
	/**
	 * @param montoCobertura the montoCobertura to set
	 */
	public void setMontoCobertura(Double montoCobertura) {
		this.montoCobertura = montoCobertura;
	}
}
