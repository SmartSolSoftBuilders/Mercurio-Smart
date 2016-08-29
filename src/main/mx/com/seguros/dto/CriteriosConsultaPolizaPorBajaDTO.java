/**
 * 
 */
package mx.com.seguros.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO con el criterio de busqueda para consulta de polizas para baja
 * @author Emigdio
 *
 */
public class CriteriosConsultaPolizaPorBajaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7460286632057257076L;

	/**
	 * ID de estatus de pago
	 */
	private Integer idEstatusPagosPoliza = null;
	
	/**
	 * Número de la quincena de suspension
	 */
	private Integer quincenaSuspension = null;
	/**
	 * Fecha de solicitud de cancel
	 */
	private Date fechaSolicitudCancelacion = null;
	/**
	 * Identificador de la plaza
	 */
	private Integer idPlaza = null;
	/**
	 * @return the idEstatusPagosPoliza
	 */
	public Integer getIdEstatusPagosPoliza() {
		return idEstatusPagosPoliza;
	}

	/**
	 * @param idEstatusPagosPoliza the idEstatusPagosPoliza to set
	 */
	public void setIdEstatusPagosPoliza(Integer idEstatusPagosPoliza) {
		this.idEstatusPagosPoliza = idEstatusPagosPoliza;
	}

	
	/**
	 * @return the quincenaSuspension
	 */
	public Integer getQuincenaSuspension() {
		return quincenaSuspension;
	}

	/**
	 * @param quincenaSuspension the quincenaSuspension to set
	 */
	public void setQuincenaSuspension(Integer quincenaSuspension) {
		this.quincenaSuspension = quincenaSuspension;
	}

	/**
	 * @return the fechaSolicitudCancelacion
	 */
	public Date getFechaSolicitudCancelacion() {
		return fechaSolicitudCancelacion;
	}

	/**
	 * @param fechaSolicitudCancelacion the fechaSolicitudCancelacion to set
	 */
	public void setFechaSolicitudCancelacion(Date fechaSolicitudCancelacion) {
		this.fechaSolicitudCancelacion = fechaSolicitudCancelacion;
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
