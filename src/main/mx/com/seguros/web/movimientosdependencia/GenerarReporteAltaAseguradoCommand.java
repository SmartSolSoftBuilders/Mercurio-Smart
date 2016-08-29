/*
 * GenerarReporteAltaAseguradoCommand.java
 *
 * Created on 16 de noviembre de 2008, 11:42 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.movimientosdependencia;

import mx.com.seguros.business.reporte.ReportesPDF;

/**
 *
 * @author QTX
 */
public class GenerarReporteAltaAseguradoCommand {
    
    /** Creates a new instance of GenerarReporteAltaAseguradoCommand */
    public GenerarReporteAltaAseguradoCommand() {
    }
    
    private int cveRetenedor;
    private ReportesPDF reportesGenerados = new ReportesPDF();    

    public int getCveRetenedor() {
        return cveRetenedor;
    }

    public void setCveRetenedor(int cveRetenedor) {
        this.cveRetenedor = cveRetenedor;
    }

    public ReportesPDF getReportesGenerados() {
        return reportesGenerados;
    }

    public void setReportesGenerados(ReportesPDF reportesGenerados) {
        this.reportesGenerados = reportesGenerados;
    }
    
}
