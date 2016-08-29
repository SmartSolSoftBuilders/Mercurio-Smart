/**
 * 
 */
package mx.com.seguros.dto;

/**
 * Objeto DTO que representa el detalle de un beneficio adicional de una póliza, este objeto
 * incluye la descripción y una representación en cadena del monto de cobertura y del costo
 * del beneficio para que sean mostrados directamente en vista sin transformaciones
 * @author Emigdio Hernández
 * @version 1.0
 */
public class DetalleBeneficioAdicionalDTO {
	
	private String descripcionBeneficio;
	private String costoBeneficio;
	private String montoCobertura;
	/**
	 * @return the descripcionBeneficio
	 */
	public String getDescripcionBeneficio() {
		return descripcionBeneficio;
	}
	/**
	 * @param descripcionBeneficio the descripcionBeneficio to set
	 */
	public void setDescripcionBeneficio(String descripcionBeneficio) {
		this.descripcionBeneficio = descripcionBeneficio;
	}
	/**
	 * @return the costoBeneficio
	 */
	public String getCostoBeneficio() {
		return costoBeneficio;
	}
	/**
	 * @param costoBeneficio the costoBeneficio to set
	 */
	public void setCostoBeneficio(String costoBeneficio) {
		this.costoBeneficio = costoBeneficio;
	}
	/**
	 * @return the montoCobertura
	 */
	public String getMontoCobertura() {
		return montoCobertura;
	}
	/**
	 * @param montoCobertura the montoCobertura to set
	 */
	public void setMontoCobertura(String montoCobertura) {
		this.montoCobertura = montoCobertura;
	}

}
