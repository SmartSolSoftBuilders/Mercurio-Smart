/**
 * 
 */
package mx.com.seguros.web.escuelas;

import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;

/**
 * Command para el controller de consulta de escuelas
 * @author Emigdio Hernandez
 *
 */
public class ConsultarCatalogoEscuelasCommand extends CriteriosConsultaEscuelasDTO{
	
	private String descripcionColonia = null;
	
	private String descripcionSucursal = null;
	
	private String descripcionGrupoAsegurado = null;

	/**
	 * @return the descripcionColonia
	 */
	public String getDescripcionColonia() {
		return descripcionColonia;
	}

	/**
	 * @param descripcionColonia the descripcionColonia to set
	 */
	public void setDescripcionColonia(String descripcionColonia) {
		this.descripcionColonia = descripcionColonia;
	}

	/**
	 * @return the descripcionSucursal
	 */
	public String getDescripcionSucursal() {
		return descripcionSucursal;
	}

	/**
	 * @param descripcionSucursal the descripcionSucursal to set
	 */
	public void setDescripcionSucursal(String descripcionSucursal) {
		this.descripcionSucursal = descripcionSucursal;
	}

	/**
	 * @return the descripcionGrupoAsegurado
	 */
	public String getDescripcionGrupoAsegurado() {
		return descripcionGrupoAsegurado;
	}

	/**
	 * @param descripcionGrupoAsegurado the descripcionGrupoAsegurado to set
	 */
	public void setDescripcionGrupoAsegurado(String descripcionGrupoAsegurado) {
		this.descripcionGrupoAsegurado = descripcionGrupoAsegurado;
	}
}
