/*
 * GenerarArchivoPagosRetenedorCommand.java
 *
 * Created on 14 de noviembre de 2008, 12:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.movimientosdependencia;

import mx.com.seguros.business.reporte.ReportesPDF;
import mx.com.seguros.model.MovimientosDependencia;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author QTX
 */
public class GenerarArchivoPagosRetenedorCommand {
    
    /** Creates a new instance of GenerarArchivoPagosRetenedorCommand */
    /*
    
    private MovimientosDependencia movimientosDependencia = new MovimientosDependencia();

    public MovimientosDependencia getMovimientosDependencia() {
        return movimientosDependencia;
    }

    public void setMovimientosDependencia(MovimientosDependencia movimientosDependencia) {
        this.movimientosDependencia = movimientosDependencia;
    }*/
    private MultipartFile file;
    private ReportesPDF reportesGenerados = new ReportesPDF();    

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }       

    public ReportesPDF getReportesGenerados() {
        return reportesGenerados;
    }

    public void setReportesGenerados(ReportesPDF reportesGenerados) {
        this.reportesGenerados = reportesGenerados;
    }
    
}
