/*
 * GenerarFormatoDescuentoCommand.java
 *
 * Created on 30 de enero de 2008, 12:32 PM
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
public class GenerarFormatoDescuentoCommand {
    
    /** Creates a new instance of GenerarFormatoDescuentoCommand */
    public GenerarFormatoDescuentoCommand() {
    }
    
    private PolizaIndividual polizaIndividual = new PolizaIndividual();
     private ReportesPDF reportesGenerados3= new ReportesPDF();

    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }

    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }

    public ReportesPDF getReportesGenerados3() {
        return reportesGenerados3;
    }

    public void setReportesGenerados3(ReportesPDF reportesGenerados3) {
        this.reportesGenerados3 = reportesGenerados3;
    }
     
    
    
}
