/**
 * 
 */
package mx.com.seguros.web.archivopolizas;

import org.springframework.web.multipart.MultipartFile;

/**
 * Objeto de comando para la carga de archivos de pólizas de inbursa
 * @author Emigdio Hernández
 *
 */
public class CargarArchivoPolizasInbursaCommand {

	MultipartFile archivoInbursa = null;
	String mensajeError = null;
	/**
	 * @return the archivoInbursa
	 */
	public MultipartFile getArchivoInbursa() {
		return archivoInbursa;
	}

	/**
	 * @param archivoInbursa the archivoInbursa to set
	 */
	public void setArchivoInbursa(MultipartFile archivoInbursa) {
		this.archivoInbursa = archivoInbursa;
	}

	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
}
