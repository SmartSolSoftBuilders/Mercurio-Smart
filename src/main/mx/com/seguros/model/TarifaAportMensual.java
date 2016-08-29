package mx.com.seguros.model;

import java.util.List;
import java.util.ArrayList;

public class TarifaAportMensual {
    private Integer cveTarifa;
    private Double importeTarifa;
    private Double importePrimaInd;
    private Integer importePrimaColectiva = 0;
    private PrimaMensualSeguroColectivo primaMensualSeguroColectivo = new PrimaMensualSeguroColectivo();
    private List<Solicitud> solicitud = new ArrayList<Solicitud>();
    private Integer puntosProduccion;
    
    private String descripcion;
    private boolean conAhorro = true;
    
    public void setCveTarifa(Integer cveTarifa) {
        this.cveTarifa = cveTarifa;
    }
    
    public Integer getCveTarifa() {
        return this.cveTarifa;
    }
    
    public void setImporteTarifa(Double importeTarifa) {
        this.importeTarifa = importeTarifa;
    }
    
    public Double getImporteTarifa() {
        return this.importeTarifa;
    }
    
    public void setImportePrimaInd(Double importePrimaInd) {
        this.importePrimaInd = importePrimaInd;
    }
    
    public Double getImportePrimaInd() {
        return this.importePrimaInd;
    }
    
    public Integer getImportePrimaColectiva() {
        return importePrimaColectiva;
    }
    
    public void setImportePrimaColectiva(Integer importePrimaColectiva) {
        this.importePrimaColectiva = importePrimaColectiva;
    }
    
    public PrimaMensualSeguroColectivo getPrimaMensualSeguroColectivo() {
        return primaMensualSeguroColectivo;
    }
    
    public void setPrimaMensualSeguroColectivo(PrimaMensualSeguroColectivo primaMensualSeguroColectivo) {
        this.primaMensualSeguroColectivo = primaMensualSeguroColectivo;
    }

    public Integer getPuntosProduccion() {
        return puntosProduccion;
    }

    public void setPuntosProduccion(Integer puntosProduccion) {
        this.puntosProduccion = puntosProduccion;
    }

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the conAhorro
	 */
	public boolean isConAhorro() {
		return conAhorro;
	}

	/**
	 * @param conAhorro the conAhorro to set
	 */
	public void setConAhorro(boolean conAhorro) {
		this.conAhorro = conAhorro;
	}
}