/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;

/**
 * DTO que representa al catálogo de oficinas
 * @author Emigdio Hernández
 *
 */
public class Oficina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5826718073083386109L;
	
	private Integer idOficina;
	
	private String nombre;
	
	private String descripcion;

	/**
	 * @return the idOficina
	 */
	public Integer getIdOficina() {
		return idOficina;
	}

	/**
	 * @param idOficina the idOficina to set
	 */
	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
