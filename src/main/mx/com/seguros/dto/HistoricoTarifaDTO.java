/**
 * 
 */
package mx.com.seguros.dto;

import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.utils.FormatUtil;

/**
 * Clase de DTO donde se resume un objeto de histórico de tarifas ya con los formatos listos para la clase de vista
 * @author Emigdio Hernández
 *
 */
public class HistoricoTarifaDTO {
	
	private Integer idHistoricoTarifa;
	private String usuario;
	private String fecha;
	private String importeTarifa;
	private Integer cveTarifa;
	private String descripcion; 
	public HistoricoTarifaDTO(){}
	public HistoricoTarifaDTO(HistoricoTarifa tarifa){
		idHistoricoTarifa = tarifa.getIdHistoricoTarifa();
		cveTarifa = tarifa.getCveTarifa();
		importeTarifa =  FormatUtil.formatoMoneda(tarifa.getTarifa().getImporteTarifa());
		fecha = FormatUtil.dateToString(tarifa.getFechaFin());
		usuario = tarifa.getUsuario();
		descripcion = tarifa.getDescripcion();
		
	}
	/**
	 * @return the idHistoricoTarifa
	 */
	public Integer getIdHistoricoTarifa() {
		return idHistoricoTarifa;
	}
	/**
	 * @param idHistoricoTarifa the idHistoricoTarifa to set
	 */
	public void setIdHistoricoTarifa(Integer idHistoricoTarifa) {
		this.idHistoricoTarifa = idHistoricoTarifa;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the importeTarifa
	 */
	public String getImporteTarifa() {
		return importeTarifa;
	}
	/**
	 * @param importeTarifa the importeTarifa to set
	 */
	public void setImporteTarifa(String importeTarifa) {
		this.importeTarifa = importeTarifa;
	}
	/**
	 * @return the cveTarifa
	 */
	public Integer getCveTarifa() {
		return cveTarifa;
	}
	/**
	 * @param cveTarifa the cveTarifa to set
	 */
	public void setCveTarifa(Integer cveTarifa) {
		this.cveTarifa = cveTarifa;
	}

}
