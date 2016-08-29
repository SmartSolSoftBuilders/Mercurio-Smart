/**
 * 
 */
package mx.com.seguros.model.seguridad;

/**
 * Clase del modelo que representa la tabla de roles
 * @author Emigdio Hernández
 *
 */
public class Rol {
	/**
	 * LLave primaria, nombre del rol
	 */
	private String authority;
	/**
	 * Descripción del rol
	 */
	private String description;
	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
