/*
 * GenerarFormatoAplicDescCommand.java
 *
 * Created on 7 de febrero de 2008, 11:24 AM
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
public class GenerarFormatoAplicDescCommand {
    
    /** Creates a new instance of GenerarFormatoAplicDescCommand */
    public GenerarFormatoAplicDescCommand() {
    }
    private PolizaIndividual polizaIndividual = new PolizaIndividual();
     private ReportesPDF reportesGenerados4= new ReportesPDF();

    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }

    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }

    public ReportesPDF getReportesGenerados4() {
        return reportesGenerados4;
    }

    public void setReportesGenerados4(ReportesPDF reportesGenerados4) {
        this.reportesGenerados4 = reportesGenerados4;
    }
    
}
