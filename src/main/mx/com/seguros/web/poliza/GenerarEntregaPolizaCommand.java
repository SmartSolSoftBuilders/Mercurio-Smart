/*
 * GenerarEntregaPolizaCommand.java
 *
 * Created on 16 de enero de 2008, 04:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;

import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.model.PolizaIndividual;
/**
 *
 * @author QTX
 */
public class GenerarEntregaPolizaCommand {
    
    /** Creates a new instance of GenerarEntregaPolizaCommand */
    public GenerarEntregaPolizaCommand() {
    }
    
     private PolizaIndividual polizaIndividual = new PolizaIndividual();
     private ReportesPDF reportesGenerados= new ReportesPDF();
     
     
       public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }

    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }
     
     
      public ReportesPDF getReportesGenerados2() {
        return reportesGenerados;
    }

    public void setReportesGenerados2(ReportesPDF reportesGenerados) {
        this.reportesGenerados = reportesGenerados;
    }
}
