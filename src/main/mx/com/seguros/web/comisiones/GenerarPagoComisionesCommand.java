/*
 * GenerarPagoComisionesCommand.java
 *
 * Created on 13 de marzo de 2008, 09:48 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.comisiones;
import mx.com.seguros.model.ComisionBrutaAgente;
import mx.com.seguros.business.reporte.ReportesPDF;
/**
 *
 * @author QTX
 */
public class GenerarPagoComisionesCommand {
    
    /** Creates a new instance of GenerarPagoComisionesCommand */
    public GenerarPagoComisionesCommand() {
    }
     private ComisionBrutaAgente comisionBrutaAgente = new ComisionBrutaAgente();
     private ReportesPDF reportes= new ReportesPDF();

    public ComisionBrutaAgente getComisionBrutaAgente() {
        return comisionBrutaAgente;
    }

    public void setComisionBrutaAgente(ComisionBrutaAgente comisionBrutaAgente) {
        this.comisionBrutaAgente = comisionBrutaAgente;
    }

    public ReportesPDF getReportes() {
        return reportes;
    }

    public void setReportes(ReportesPDF reportes) {
        this.reportes = reportes;
    }
    
    
}
