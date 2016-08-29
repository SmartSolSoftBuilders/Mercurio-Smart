package mx.com.seguros.model;

/**
 * Objeto de entidad de la tabla de beneficio adicional
 * @version 1.0
 * @author Emigdio
 *
 */
public class BeneficioAdicional {

	private Integer idBeneficioAdicional;
	private String descripcionBeneficioAdicional;
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
	 * Método de acceso al campo descripcionBeneficioAdicional.
	 * @return El valor del campo descripcionBeneficioAdicional
	 */
	public String getDescripcionBeneficioAdicional() {
		return descripcionBeneficioAdicional;
	}
	/**
	 * Asigna el valor al campo descripcionBeneficioAdicional.
	 * @param descripcionBeneficioAdicional el valor descripcionBeneficioAdicional a asignar
	 */
	public void setDescripcionBeneficioAdicional(
			String descripcionBeneficioAdicional) {
		this.descripcionBeneficioAdicional = descripcionBeneficioAdicional;
	}
}
