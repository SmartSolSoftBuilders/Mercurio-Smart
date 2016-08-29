/**
 * 
 */
package mx.com.seguros.model.seguridad;

import java.io.Serializable;
import java.util.List;

/**
 * Clase del modelo que representa la tabla de Menú en la base de datos
 * @author Emigdio Hernández
 *
 */
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8757703561677769865L;
	/**
	 * Identificador del Menú
	 */
	private String idMenu;
	/**
	 * Descripción del menú
	 */
	private String descripcion;
	/**
	 * URL del destino del menpu
	 */
	private String ruta;
	/**
	 * Identificador del menu pare, null si no es menú hoja
	 */
	private String idMenuPadre;
	/**
	 * Titulo en el menú
	 */
	private String titulo;
	
	
	private List<Menu> subMenus;
	/**
	 * @return the idMenu
	 */
	public String getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	/**
	 * @return the idMenuPadre
	 */
	public String getIdMenuPadre() {
		return idMenuPadre;
	}
	/**
	 * @param idMenuPadre the idMenuPadre to set
	 */
	public void setIdMenuPadre(String idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the subMenus
	 */
	public List<Menu> getSubMenus() {
		return subMenus;
	}
	/**
	 * @param subMenus the subMenus to set
	 */
	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
	
}
