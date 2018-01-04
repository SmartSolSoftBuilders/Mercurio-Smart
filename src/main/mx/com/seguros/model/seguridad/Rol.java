/**
 * 
 */
package mx.com.seguros.model.seguridad;

/**
 * Clase del modelo que representa la tabla de roles
 * @author Emigdio Hern�ndez
 *
 */
public class Rol {
	/**
	 * LLave primaria, nombre del rol
	 */
	private String authority;
	/**
	 * Descripci�n del rol
	 */
	private String description;
	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	
	/*public String rol;
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}*/
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
