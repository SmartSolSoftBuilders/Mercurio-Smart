package mx.com.seguros.dto;

import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.EstatusPolizaPagos;

/**
 * DTO para ejecución del Autofinanciamiento de Pagos
 * @author JLVO
 */


public class CriteriosEjecucionAutofinanciamientoDTO {
	
	private Integer idPlaza;
	
	private Integer idEstatusPolizaPagos;

	
	/**
     * @return the idPlaza
     */
	public Integer getIdPlaza() {
		return idPlaza;
	}

	/**
     * @param idPlaza the idPlaza to set
     */ 
	public void setPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}

	/**
     * @return the idEstatusPolizaPagos
     */
	public Integer getIdEstatusPolizaPagos() {
		return idEstatusPolizaPagos;
	}

	/**
     * @param idEstatusPolizaPagos the idEstatusPolizaPagos to set
     */
	
	public void setIdEstatusPolizaPagos(Integer idEstatusPolizaPagos) {
		this.idEstatusPolizaPagos = idEstatusPolizaPagos;
	}
	
	
	
	
	

}
