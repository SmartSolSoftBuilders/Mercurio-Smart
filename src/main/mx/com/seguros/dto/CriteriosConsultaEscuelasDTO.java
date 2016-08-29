/**
 * 
 */
package mx.com.seguros.dto;

/**
 * DTO que representa los datos de los criterios de búsqueda 
 * para el catálogo de escuelas 
 * @author Emigdio Hernandez
 *
 */
public class CriteriosConsultaEscuelasDTO {
	/**
	 * Clave del grupo asegurado a filtrar
	 */
	private Integer cveGrupoAsegurado = null;
	/**
	 * Clave de la delegación o municipio a filtrar
	 */
	private Integer cveSucursal = null;
	/**
	 * Clave de la colonia a filtrar
	 */
	private Integer cveColonia = null;
	/**
	 * Nombre de la escuela a buscar
	 */
	private String nombreEscuela = null;
	/**
	 * Clave de la empresa
	 */
	private Integer cveEmpresa = null;
	
	/**
	 * @return the cveGrupoAsegurado
	 */
	public Integer getCveGrupoAsegurado() {
		return cveGrupoAsegurado;
	}

	/**
	 * @param cveGrupoAsegurado the cveGrupoAsegurado to set
	 */
	public void setCveGrupoAsegurado(Integer cveGrupoAsegurado) {
		this.cveGrupoAsegurado = cveGrupoAsegurado;
	}

	/**
	 * @return the cveSucursal
	 */
	public Integer getCveSucursal() {
		return cveSucursal;
	}

	/**
	 * @param cveSucursal the cveSucursal to set
	 */
	public void setCveSucursal(Integer cveSucursal) {
		this.cveSucursal = cveSucursal;
	}

	/**
	 * @return the cveColonia
	 */
	public Integer getCveColonia() {
		return cveColonia;
	}

	/**
	 * @param cveColonia the cveColonia to set
	 */
	public void setCveColonia(Integer cveColonia) {
		this.cveColonia = cveColonia;
	}

	/**
	 * @return the nombreEscuela
	 */
	public String getNombreEscuela() {
		return nombreEscuela;
	}

	/**
	 * @param nombreEscuela the nombreEscuela to set
	 */
	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
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

}
