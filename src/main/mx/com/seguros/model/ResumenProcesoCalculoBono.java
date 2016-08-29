/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Objeto de mapeo de la tabla donde se almacena el resumen final de un proceso de cálculo de bonos
 * @author Emigdio Hernandez
 */
public class ResumenProcesoCalculoBono implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador del registro
	 */
	private Integer idResumenProcesoCalculoBono = null;
	/**
	 * Identificador del usuario que realiza el cálculo
	 */
	private String cveUsuario = null;
	/**
	 * Fecha en la que se realiza el cálculo
	 */
	private Date fechaCalculo = null;
	/**
	 * Monto total del bono calculado en el proceso
	 */
	private BigDecimal montoTotal = null;
	/**
	 * Número de agentes considerados con bono
	 */
	private Integer numeroAgentes = null;
	/**
	 * Identificador de la plaza para la cuál se realizó el cálculo.
	 * Null en caso de que se haya realizado para todas las plazas
	 */
	private Integer idPlaza = null;
	/**
	 * Objeto de plaza para desplegar la plaza para la cuál se realizó el cálculo.
	 * Null en caso de que se haya realizado para todas las plazas
	 */
	private Plaza plaza = null;
	/**
	 * Detalle por agente del cálculo
	 */
	List<ResumenCalculoBonoPolizaAgente> listaDetalleAgente = null;
	/**
	 * @return the idResumenProcesoCalculoBono
	 */
	public Integer getIdResumenProcesoCalculoBono() {
		return idResumenProcesoCalculoBono;
	}
	/**
	 * @param idResumenProcesoCalculoBono the idResumenProcesoCalculoBono to set
	 */
	public void setIdResumenProcesoCalculoBono(Integer idResumenProcesoCalculoBono) {
		this.idResumenProcesoCalculoBono = idResumenProcesoCalculoBono;
	}
	/**
	 * @return the cveUsuario
	 */
	public String getCveUsuario() {
		return cveUsuario;
	}
	/**
	 * @param cveUsuario the cveUsuario to set
	 */
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}
	/**
	 * @return the fechaCalculo
	 */
	public Date getFechaCalculo() {
		return fechaCalculo;
	}
	/**
	 * @param fechaCalculo the fechaCalculo to set
	 */
	public void setFechaCalculo(Date fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}
	/**
	 * @return the montoTotal
	 */
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	/**
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
	/**
	 * @return the numeroAgentes
	 */
	public Integer getNumeroAgentes() {
		return numeroAgentes;
	}
	/**
	 * @param numeroAgentes the numeroAgentes to set
	 */
	public void setNumeroAgentes(Integer numeroAgentes) {
		this.numeroAgentes = numeroAgentes;
	}
	/**
	 * @return the listaDetalleAgente
	 */
	public List<ResumenCalculoBonoPolizaAgente> getListaDetalleAgente() {
		return listaDetalleAgente;
	}
	/**
	 * @param listaDetalleAgente the listaDetalleAgente to set
	 */
	public void setListaDetalleAgente(
			List<ResumenCalculoBonoPolizaAgente> listaDetalleAgente) {
		this.listaDetalleAgente = listaDetalleAgente;
	}
	/**
	 * @return the plaza
	 */
	public Plaza getPlaza() {
		return plaza;
	}
	/**
	 * @param plaza the plaza to set
	 */
	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
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
