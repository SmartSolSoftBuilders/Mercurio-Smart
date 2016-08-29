/**
 * 
 */
package mx.com.seguros.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.seguros.dto.ResultadoCalculoBonoPolizaAgenteDTO;

import mx.com.seguros.dto.ResultadoCalculoBonoPolizaAgenteDTO;

/**
 * Resumen del cálculo del bono del agente de un conjunto de pólizas y meses
 * Este objeto de mapeo almacena el cálculo final del bono para un agente después de ejecutar
 * el proceso del cálculo de bono
 * @author Emigdio Hernandez
 *
 */
public class ResumenCalculoBonoPolizaAgente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador único
	 */
	private Integer idResumenCalculoBonoPolizaAgente = null;
	/**
	 * Monto del bono total para el agente
	 */
	private BigDecimal montoBono = null;
	/**
	 * Fecha de cálculo del bono
	 */
	private Date fechaCalculo = null;
	/**
	 * Clave del agente para el cuál es el bono
	 */
	private Integer cveAgente = null;
	/**
	 * Objeto de agente con los demás datos
	 */
	private Agente agente = null;
	/**
	 * Detalle del cálculo del bono por póliza del agente
	 */
	private List<CalculoBonoPolizaAgente> listaDetalleCalculo = new ArrayList<CalculoBonoPolizaAgente>();
	
	/*
	 * Detalle de la consulta del cálculo del bono por póliza del agente
	 */
	private List<ResultadoCalculoBonoPolizaAgenteDTO> resultadoDetalleCalculo = new ArrayList<ResultadoCalculoBonoPolizaAgenteDTO>();
	
	
	
	/**
	 * ID del registro del resuemn del proceso del cálculo del bono
	 */
	private Integer idResumenProcesoCalculoBono = null;
	/**
	 * @return the idResumenCalculoBonoPolizaAgente
	 */
	public Integer getIdResumenCalculoBonoPolizaAgente() {
		return idResumenCalculoBonoPolizaAgente;
	}

	/**
	 * @param idResumenCalculoBonoPolizaAgente the idResumenCalculoBonoPolizaAgente to set
	 */
	public void setIdResumenCalculoBonoPolizaAgente(Integer idResumenCalculoBonoPolizaAgente) {
		this.idResumenCalculoBonoPolizaAgente = idResumenCalculoBonoPolizaAgente;
	}

	/**
	 * @return the montoBono
	 */
	public BigDecimal getMontoBono() {
		return montoBono;
	}

	/**
	 * @param montoBono the montoBono to set
	 */
	public void setMontoBono(BigDecimal montoBono) {
		this.montoBono = montoBono;
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
	 * @return the cveAgente
	 */
	public Integer getCveAgente() {
		return cveAgente;
	}

	/**
	 * @param cveAgente the cveAgente to set
	 */
	public void setCveAgente(Integer cveAgente) {
		this.cveAgente = cveAgente;
	}

	/**
	 * @return the agente
	 */
	public Agente getAgente() {
		return agente;
	}

	/**
	 * @param agente the agente to set
	 */
	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	/**
	 * @return the listaDetalleCalculo
	 */
	public List<CalculoBonoPolizaAgente> getListaDetalleCalculo() {
		return listaDetalleCalculo;
	}

	/**
	 * @param listaDetalleCalculo the listaDetalleCalculo to set
	 */
	public void setListaDetalleCalculo(
			List<CalculoBonoPolizaAgente> listaDetalleCalculo) {
		this.listaDetalleCalculo = listaDetalleCalculo;
	}

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
	 * @return the resultadoDetalleCalculo
	 */
	public List<ResultadoCalculoBonoPolizaAgenteDTO> getResultadoDetalleCalculo() {
		return resultadoDetalleCalculo;
	}

	/**
	 * @param resultadoDetalleCalculo the resultadoDetalleCalculo to set
	 */
	public void setResultadoDetalleCalculo(List<ResultadoCalculoBonoPolizaAgenteDTO> resultadoDetalleCalculo) {
		this.resultadoDetalleCalculo = resultadoDetalleCalculo;
	}
	
	

}
