/**
 * 
 */
package mx.com.seguros.web.escuelas;

import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;

/**
 * Command para el controller de agregar / editar escuelas
 * @author Emigdio Hernandez
 *
 */
public class AgregarEscuelaCommand extends CriteriosConsultaEscuelasDTO{
	
	private String descripcionColonia = null;
	
	private String descripcionSucursal = null;
	
	private String descripcionGrupoAsegurado = null;
	
	private Integer tipoEmpresa = null;
	
	private Integer cveEmpresa = null;
	
	private Integer cveTurno = null;

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

	/**
	 * @return the tipoEmpresa
	 */
	public Integer getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * @param tipoEmpresa the tipoEmpresa to set
	 */
	public void setTipoEmpresa(Integer tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	/**
	 * @return the cveEmpresa
	 */
	public Integer getCveEmpresa() {
		return cveEmpresa;
	}

	/**
	 * @param cveEmpresa the cveEmpresa to set
	 */
	public void setCveEmpresa(Integer cveEmpresa) {
		this.cveEmpresa = cveEmpresa;
	}

	/**
	 * @return the cveTurno
	 */
	public Integer getCveTurno() {
		return cveTurno;
	}

	/**
	 * @param cveTurno the cveTurno to set
	 */
	public void setCveTurno(Integer cveTurno) {
		this.cveTurno = cveTurno;
	}

	public void reset() {

		
		
	}
}
