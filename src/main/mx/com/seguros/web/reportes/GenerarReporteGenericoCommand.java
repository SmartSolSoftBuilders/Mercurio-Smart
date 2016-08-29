/**
 * 
 */
package mx.com.seguros.web.reportes;

/**
 * Clase command para atender las peticiones de emisión de cualquier reporte
 * @author Emigdio Hernández
 *
 */
public class GenerarReporteGenericoCommand {
	
	String claveReporte = null;
	String comentario = null;
	
	String[] nombreParametros = null;
	String[] valoresParametros = null;
	/**
	 * @return the claveReporte
	 */
	public String getClaveReporte() {
		return claveReporte;
	}
	/**
	 * @param claveReporte the claveReporte to set
	 */
	public void setClaveReporte(String claveReporte) {
		this.claveReporte = claveReporte;
	}
	/**
	 * @return the nombreParametros
	 */
	public String[] getNombreParametros() {
		return nombreParametros;
	}
	/**
	 * @param nombreParametros the nombreParametros to set
	 */
	public void setNombreParametros(String[] nombreParametros) {
		this.nombreParametros = nombreParametros;
	}
	/**
	 * @return the valoresParametros
	 */
	public String[] getValoresParametros() {
		return valoresParametros;
	}
	/**
	 * @param valoresParametros the valoresParametros to set
	 */
	public void setValoresParametros(String[] valoresParametros) {
		this.valoresParametros = valoresParametros;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
