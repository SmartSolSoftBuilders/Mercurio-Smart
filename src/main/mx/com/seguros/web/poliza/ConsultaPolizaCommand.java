/*
 * ConsultaPolizaCommand.java
 *
 * Created on 10 de enero de 2008, 10:27 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.business.reporte.ReportesPDF;

/**
 *
 * @author QTX
 */
public class ConsultaPolizaCommand {
    
    /** Creates a new instance of ConsultaPolizaCommand */
    public ConsultaPolizaCommand() {
    }
    
    private PolizaIndividual polizaIndividual = new PolizaIndividual();
    private ReportesPDF reportesGenerados5= new ReportesPDF();
    
    
    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }
    
    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }
    
    public ReportesPDF getReportesGenerados5() {
        return reportesGenerados5;
    }
    
    public void setReportesGenerados5(ReportesPDF reportesGenerados5) {
        this.reportesGenerados5 = reportesGenerados5;
    }
    
}
