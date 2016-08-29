package mx.com.seguros.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Clase de mapeo de resultado para la consulta a tabla CalculoBonoPolizaAgente de la BD
 * @author JLVO
 *
 */
public class ResultadoCalculoBonoPolizaAgenteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * IDentificador del registro
	 */
	int idCalculoBonoPolizaAgente = 0;
	/**
	 * Número de la póliza
	 */
	int numPoliza = 0;
	/**
	 * Número de consignatario
	 */
	int numConsignatario = 0;
	/**
	 * Clave del agente de la comisión
	 */
	Integer cveAgente = 0;
	/**
	 * Tarifa utilizada para el cálculo
	 */
	double tarifa = 0;
	/**
	 * Porcentaje de bono utilizado para el cálculo
	 */
	double porcentaje = 0;
	/**
	 * Número de quincenas consideradas para este cálculo
	 */
	int numeroQuincenas = 0;
	/**
	 * Número de quincena entre 13 y 48 inicial del cálculo
	 */
	int numeroQuincenaBase = 0;
	/**
	 * Número de la quincena inicial qqyyyy
	 */
	int quincenaFinal = 0;
	/**
	 * Número de la quincena inicial qqyyyy
	 */
	int quincenaInicial = 0;
	/**
	 * Monto calculado del bono
	 */
	double montoBono = 0;
	/**
	 * Fecha de cálculo del bono
	 */
	Date fechaCalculo = null;
	/**
	 * ID del registro de resumen del cálculo del bono del agente
	 */
	Integer idResumenCalculoBonoPolizaAgente = null;
	/**
	 * @return the idCalculoBonoPolizaAgente
	 */
	public int getIdCalculoBonoPolizaAgente() {
		return idCalculoBonoPolizaAgente;
	}
	/**
	 * @param idCalculoBonoPolizaAgente the idCalculoBonoPolizaAgente to set
	 */
	public void setIdCalculoBonoPolizaAgente(int idCalculoBonoPolizaAgente) {
		this.idCalculoBonoPolizaAgente = idCalculoBonoPolizaAgente;
	}
	/**
	 * @return the numPoliza
	 */
	public int getNumPoliza() {
		return numPoliza;
	}
	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}
	/**
	 * @return the numConsignatario
	 */
	public int getNumConsignatario() {
		return numConsignatario;
	}
	/**
	 * @param numConsignatario the numConsignatario to set
	 */
	public void setNumConsignatario(int numConsignatario) {
		this.numConsignatario = numConsignatario;
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
	 * @return the tarifa
	 */
	public double getTarifa() {
		return tarifa;
	}
	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	/**
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}
	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	/**
	 * @return the numeroQuincenas
	 */
	public int getNumeroQuincenas() {
		return numeroQuincenas;
	}
	/**
	 * @param numeroQuincenas the numeroQuincenas to set
	 */
	public void setNumeroQuincenas(int numeroQuincenas) {
		this.numeroQuincenas = numeroQuincenas;
	}
	/**
	 * @return the numeroQuincenaBase
	 */
	public int getNumeroQuincenaBase() {
		return numeroQuincenaBase;
	}
	/**
	 * @param numeroQuincenaBase the numeroQuincenaBase to set
	 */
	public void setNumeroQuincenaBase(int numeroQuincenaBase) {
		this.numeroQuincenaBase = numeroQuincenaBase;
	}
	/**
	 * @return the quincenaFinal
	 */
	public int getQuincenaFinal() {
		return quincenaFinal;
	}
	/**
	 * @param quincenaFinal the quincenaFinal to set
	 */
	public void setQuincenaFinal(int quincenaFinal) {
		this.quincenaFinal = quincenaFinal;
	}
	/**
	 * @return the quincenaInicial
	 */
	public int getQuincenaInicial() {
		return quincenaInicial;
	}
	/**
	 * @param quincenaInicial the quincenaInicial to set
	 */
	public void setQuincenaInicial(int quincenaInicial) {
		this.quincenaInicial = quincenaInicial;
	}
	/**
	 * @return the montoBono
	 */
	public double getMontoBono() {
		return montoBono;
	}
	/**
	 * @param montoBono the montoBono to set
	 */
	public void setMontoBono(double montoBono) {
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
	 * @return the idResumenCalculoBonoPolizaAgente
	 */
	public Integer getIdResumenCalculoBonoPolizaAgente() {
		return idResumenCalculoBonoPolizaAgente;
	}
	/**
	 * @param idResumenCalculoBonoPolizaAgente the idResumenCalculoBonoPolizaAgente to set
	 */
	public void setIdResumenCalculoBonoPolizaAgente(
			Integer idResumenCalculoBonoPolizaAgente) {
		this.idResumenCalculoBonoPolizaAgente = idResumenCalculoBonoPolizaAgente;
	}
	
	/*
	 * JLVO: Datos extra a considerar para resultado folioSolicitud y RFCSolicitante
	 * */
	
	/**
	 * @return the folioSolicitud
	 */	
	
	private Integer folioSolicitud;
    
    private String RFCsolicitante;
	
    public Integer getFolioSolicitud() {
		return folioSolicitud;
	}
    
	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */    
    
	public void setFolioSolicitud(Integer folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	/**
	 * @return the RFCsolicitante
	 */
	public String getRFCsolicitante() {
		return RFCsolicitante;
	}

	public void setRFCsolicitante(String rFCsolicitante) {
		RFCsolicitante = rFCsolicitante;
	}	
	
	
	private String nombre1Solicitante;
	private String apPaternoSolicitante;
	private String apMaternoSolicitante;	
	
	/**
	 * @return the nombre1Solicitante
	 */
	public String getNombre1Solicitante() {
		return nombre1Solicitante;
	}
	/**
	 * @param nombre1Solicitante the nombre1Solicitante to set
	 */
	public void setNombre1Solicitante(String nombre1Solicitante) {
		this.nombre1Solicitante = nombre1Solicitante;
	}

	/**
	 * @return the apPaternoSolicitante
	 */
	public String getApPaternoSolicitante() {
		return apPaternoSolicitante;
	}
	/**
	 * @param apPaternoSolicitante the apPaternoSolicitante to set
	 */
	public void setApPaternoSolicitante(String apPaternoSolicitante) {
		this.apPaternoSolicitante = apPaternoSolicitante;
	}

	/**
	 * @return the apMaternoSolicitante
	 */
	public String getApMaternoSolicitante() {
		return apMaternoSolicitante;
	}
	/**
	 * @param apMaternoSolicitante the apMaternoSolicitante to set
	 */
	public void setApMaternoSolicitante(String apMaternoSolicitante) {
		this.apMaternoSolicitante = apMaternoSolicitante;
	}


}
