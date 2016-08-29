/**
 * 
 */
package mx.com.seguros.dto;

import java.util.List;

import mx.com.seguros.utils.FormatUtil;

/**
 * Objeto DTO para presentar en pantalla el detalle del cálculo de una suma aseguradda total
 * @author Emigdio Hernández
 *
 */
public class DetalleCalculoSumaAseguradaDTO {
	
	
	private Double sumaSeguroVida = null;
	private String sumaSeguroVidaString = null;
	
	private Double sumaAseguradaTotal = null;
	private String sumaAseguradaTotalString = null;
	private Double sumaAseguradaIndividual = null;
	private String sumaAseguradaIndividualString = null;
	private Double sumaSEVI = null;
	private String sumaSEVIString = null;
	
	private Double sumaGastosFunerarios = null;
	private String sumaGastosFunerariosString = null;
	private Double sumaBAF = null;
	private String sumaBAFString = null;
	
	private Double montoCoberturaBeneficios = null;
	private String montoCoberturaBeneficiosString = null;
	private Double sumaAseguradaColectiva = null;
	private String sumaAseguradaColectivaString = null;
	
	private boolean formatoAnterior = true;
	
	private List<DetalleBeneficioAdicionalDTO> detalleBeneficios;

	/**
	 * @return the sumaAseguradaTotal
	 */
	public Double getSumaAseguradaTotal() {
		return sumaAseguradaTotal;
	}

	/**
	 * @param sumaAseguradaTotal the sumaAseguradaTotal to set
	 */
	public void setSumaAseguradaTotal(Double sumaAseguradaTotal) {
		this.sumaAseguradaTotal = sumaAseguradaTotal;
	}

	/**
	 * @return the sumaAseguradaTotalString
	 */
	public String getSumaAseguradaTotalString() {
		return sumaAseguradaTotalString;
	}

	/**
	 * @param sumaAseguradaTotalString the sumaAseguradaTotalString to set
	 */
	public void setSumaAseguradaTotalString(String sumaAseguradaTotalString) {
		this.sumaAseguradaTotalString = sumaAseguradaTotalString;
	}

	/**
	 * @return the sumaAseguradaIndividual
	 */
	public Double getSumaAseguradaIndividual() {
		return sumaAseguradaIndividual;
	}

	/**
	 * @param sumaAseguradaIndividual the sumaAseguradaIndividual to set
	 */
	public void setSumaAseguradaIndividual(Double sumaAseguradaIndividual) {
		this.sumaAseguradaIndividual = sumaAseguradaIndividual;
	}

	/**
	 * @return the sumaAseguradaIndividualString
	 */
	public String getSumaAseguradaIndividualString() {
		return sumaAseguradaIndividualString;
	}

	/**
	 * @param sumaAseguradaIndividualString the sumaAseguradaIndividualString to set
	 */
	public void setSumaAseguradaIndividualString(
			String sumaAseguradaIndividualString) {
		this.sumaAseguradaIndividualString = sumaAseguradaIndividualString;
	}

	/**
	 * @return the sumaSEVI
	 */
	public Double getSumaSEVI() {
		return sumaSEVI;
	}

	/**
	 * @param sumaSEVI the sumaSEVI to set
	 */
	public void setSumaSEVI(Double sumaSEVI) {
		this.sumaSEVI = sumaSEVI;
	}

	/**
	 * @return the sumaSEVIString
	 */
	public String getSumaSEVIString() {
		return sumaSEVIString;
	}

	/**
	 * @param sumaSEVIString the sumaSEVIString to set
	 */
	public void setSumaSEVIString(String sumaSEVIString) {
		this.sumaSEVIString = sumaSEVIString;
	}

	/**
	 * @return the sumaGastosFunerarios
	 */
	public Double getSumaGastosFunerarios() {
		return sumaGastosFunerarios;
	}

	/**
	 * @param sumaGastosFunerarios the sumaGastosFunerarios to set
	 */
	public void setSumaGastosFunerarios(Double sumaGastosFunerarios) {
		this.sumaGastosFunerarios = sumaGastosFunerarios;
	}

	/**
	 * @return the sumaGastosFunerariosString
	 */
	public String getSumaGastosFunerariosString() {
		return sumaGastosFunerariosString;
	}

	/**
	 * @param sumaGastosFunerariosString the sumaGastosFunerariosString to set
	 */
	public void setSumaGastosFunerariosString(String sumaGastosFunerariosString) {
		this.sumaGastosFunerariosString = sumaGastosFunerariosString;
	}

	/**
	 * @return the sumaBAF
	 */
	public Double getSumaBAF() {
		return sumaBAF;
	}

	/**
	 * @param sumaBAF the sumaBAF to set
	 */
	public void setSumaBAF(Double sumaBAF) {
		this.sumaBAF = sumaBAF;
	}

	/**
	 * @return the sumaBAFString
	 */
	public String getSumaBAFString() {
		return sumaBAFString;
	}

	/**
	 * @param sumaBAFString the sumaBAFString to set
	 */
	public void setSumaBAFString(String sumaBAFString) {
		this.sumaBAFString = sumaBAFString;
	}

	/**
	 * @return the montoCoberturaBeneficios
	 */
	public Double getMontoCoberturaBeneficios() {
		return montoCoberturaBeneficios;
	}

	/**
	 * @param montoCoberturaBeneficios the montoCoberturaBeneficios to set
	 */
	public void setMontoCoberturaBeneficios(Double montoCoberturaBeneficios) {
		this.montoCoberturaBeneficios = montoCoberturaBeneficios;
	}

	/**
	 * @return the montoCoberturaBeneficiosString
	 */
	public String getMontoCoberturaBeneficiosString() {
		return montoCoberturaBeneficiosString;
	}

	/**
	 * @param montoCoberturaBeneficiosString the montoCoberturaBeneficiosString to set
	 */
	public void setMontoCoberturaBeneficiosString(
			String montoCoberturaBeneficiosString) {
		this.montoCoberturaBeneficiosString = montoCoberturaBeneficiosString;
	}

	/**
	 * @return the sumaAseguradaColectiva
	 */
	public Double getSumaAseguradaColectiva() {
		return sumaAseguradaColectiva;
	}

	/**
	 * @param sumaAseguradaColectiva the sumaAseguradaColectiva to set
	 */
	public void setSumaAseguradaColectiva(Double sumaAseguradaColectiva) {
		this.sumaAseguradaColectiva = sumaAseguradaColectiva;
	}

	/**
	 * @return the sumaAseguradaColectivaString
	 */
	public String getSumaAseguradaColectivaString() {
		return sumaAseguradaColectivaString;
	}

	/**
	 * @param sumaAseguradaColectivaString the sumaAseguradaColectivaString to set
	 */
	public void setSumaAseguradaColectivaString(String sumaAseguradaColectivaString) {
		this.sumaAseguradaColectivaString = sumaAseguradaColectivaString;
	}

	/**
	 * @return the formatoAnterior
	 */
	public boolean isFormatoAnterior() {
		return formatoAnterior;
	}

	/**
	 * @param formatoAnterior the formatoAnterior to set
	 */
	public void setFormatoAnterior(boolean formatoAnterior) {
		this.formatoAnterior = formatoAnterior;
	}

	/**
	 * @return the sumaSeguroVida
	 */
	public Double getSumaSeguroVida() {
		return sumaSeguroVida;
	}

	/**
	 * @param sumaSeguroVida the sumaSeguroVida to set
	 */
	public void setSumaSeguroVida(Double sumaSeguroVida) {
		this.sumaSeguroVida = sumaSeguroVida;
	}

	/**
	 * @return the sumaSeguroVidaString
	 */
	public String getSumaSeguroVidaString() {
		return sumaSeguroVidaString;
	}

	/**
	 * @param sumaSeguroVidaString the sumaSeguroVidaString to set
	 */
	public void setSumaSeguroVidaString(String sumaSeguroVidaString) {
		this.sumaSeguroVidaString = sumaSeguroVidaString;
	}

	/**
	 * @return the detalleBeneficios
	 */
	public List<DetalleBeneficioAdicionalDTO> getDetalleBeneficios() {
		return detalleBeneficios;
	}

	/**
	 * @param detalleBeneficios the detalleBeneficios to set
	 */
	public void setDetalleBeneficios(
			List<DetalleBeneficioAdicionalDTO> detalleBeneficios) {
		this.detalleBeneficios = detalleBeneficios;
	}

	
	
	
	
}
