/**
 * 
 */
package mx.com.seguros.web.bonos;

/**
 * Clase de command para mostrar el cálculo previo de los bonos de póliza a agentes
 * @author Emigdio Henrnadez
 *
 */
public class CalcularBonoPolizaAgenteCommand {

	private boolean guardar = false;

	private Integer idPlaza = null;
	/**
	 * @return the guardar
	 */
	public boolean isGuardar() {
		return guardar;
	}

	/**
	 * @param guardar the guardar to set
	 */
	public void setGuardar(boolean guardar) {
		this.guardar = guardar;
	}

	/**
	 * @return the idPlaza
	 */
	public Integer getIdPlaza() {
		return idPlaza;
	}

	/**
	 * @param idPlaza the idPlaza to set
	 */
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}
}
