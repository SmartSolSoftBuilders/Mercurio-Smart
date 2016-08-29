/*
 * RegistroPolizaCommand.java
 *
 * Created on 24 de septiembre de 2007, 07:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;

import java.util.List;

import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;

/**
 *
 * @author Cesar
 */
public class RegistroPolizaCommand {
    
    /** Creates a new instance of RegistroPolizaCommand */
    public RegistroPolizaCommand() {
    }
    
    private PolizaIndividual polizaIndividual = new PolizaIndividual();
    private ReportesPDF reportesGenerados= new ReportesPDF();
    private boolean modificacion = false;
    private BeneficioAdicionalPoliza[] beneficiosPoliza = null;
    //Solicitud solicitud=new Solicitud();

    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }

    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }

    public ReportesPDF getReportesGenerados() {
        return reportesGenerados;
    }

    public void setReportesGenerados(ReportesPDF reportesGenerados) {
        this.reportesGenerados = reportesGenerados;
    }

	/**
	 * Método de acceso al campo modificacion.
	 * @return El valor del campo modificacion
	 */
	public boolean isModificacion() {
		return modificacion;
	}

	/**
	 * Asigna el valor al campo modificacion.
	 * @param modificacion el valor modificacion a asignar
	 */
	public void setModificacion(boolean modificacion) {
		this.modificacion = modificacion;
	}

	/**
	 * Método de acceso al campo beneficiosPoliza.
	 * @return El valor del campo beneficiosPoliza
	 */
	public BeneficioAdicionalPoliza[] getBeneficiosPoliza() {
		return beneficiosPoliza;
	}

	/**
	 * Asigna el valor al campo beneficiosPoliza.
	 * @param beneficiosPoliza el valor beneficiosPoliza a asignar
	 */
	public void setBeneficiosPoliza(BeneficioAdicionalPoliza[] beneficiosPoliza) {
		this.beneficiosPoliza = beneficiosPoliza;
	}

    

}
