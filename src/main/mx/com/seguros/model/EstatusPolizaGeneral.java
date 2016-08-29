/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;

/**
 * Clase de mapeo de BD para el estado general de una poliza
 * @author Emigdio
 *
 */
public class EstatusPolizaGeneral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1238586896914021412L;
	/**
	 * ID del esatatus
	 */
	private Integer idEstatusPolizaGeneral = null;
	/**
	 * Descripción del estatus
	 */
	private String descripcion = null;
	/**
	 * @return the idEstatusPolizaGeneral
	 */
	public Integer getIdEstatusPolizaGeneral() {
		return idEstatusPolizaGeneral;
	}
	/**
	 * @param idEstatusPolizaGeneral the idEstatusPolizaGeneral to set
	 */
	public void setIdEstatusPolizaGeneral(Integer idEstatusPolizaGeneral) {
		this.idEstatusPolizaGeneral = idEstatusPolizaGeneral;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
