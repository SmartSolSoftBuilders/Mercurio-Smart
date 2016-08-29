package mx.com.seguros.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * DTO con el criterio de busqueda para consulta de reportes para trámite
 * @author JLVO
 *
 */
public class CriteriosConsultaReporteTramitesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -887916066390876383L;
	
	private Date fechaInicial;
	
	private Date fechaFinal;
	
	private Integer oficina;

	/**
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * @return the oficina
	 */
	public Integer getOficina() {
		return oficina;
	}

	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(Integer oficina) {
		this.oficina = oficina;
	}
	
	

}
