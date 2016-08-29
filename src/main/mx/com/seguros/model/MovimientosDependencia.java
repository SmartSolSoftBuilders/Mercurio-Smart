/*
 * MovimientosDependencia.java
 *
 * Created on 28 de octubre de 2008, 10:58 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

import java.io.File;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * @author QTX
 */
public class MovimientosDependencia {
    
    private static int NUM_MAX_CONTRATANTES = 15;
    
    private PolizaIndividual polizaIndividual = new PolizaIndividual();    
    private Solicitud solicitud = new Solicitud();
    private Contratante[] contratantes = new Contratante[NUM_MAX_CONTRATANTES]; 
    private int cveRetenedor;
    private String fechaInicioVigencia;
    private String cveDescuento;
    private String anioQuincena;
    private String tipoMovimiento;
    private MultipartFile archivoCargado;
    private String siglasRetenedor;
    private HistorialMovimientosContratante historial = new HistorialMovimientosContratante();

    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }

    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }    

    public int getCveRetenedor() {
        return cveRetenedor;
    }

    public void setCveRetenedor(int cveRetenedor) {
        this.cveRetenedor = cveRetenedor;
    }

    public String getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(String fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }    

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }    

    public String getCveDescuento() {
        return cveDescuento;
    }

    public void setCveDescuento(String cveDescuento) {
        this.cveDescuento = cveDescuento;
    }

    public String getAnioQuincena() {
        return anioQuincena;
    }

    public void setAnioQuincena(String anioQuincena) {
        this.anioQuincena = anioQuincena;
    }
    
    public Contratante[] getContratantes() {
        return contratantes;
    }

    public void setContratantes(Contratante[] contratantes) {
        this.contratantes = contratantes;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }   

    public MultipartFile getArchivoCargado() {
        return archivoCargado;
    }

    public void setArchivoCargado(MultipartFile archivoCargado) {
        this.archivoCargado = archivoCargado;
    }

    public String getSiglasRetenedor() {
        return siglasRetenedor;
    }

    public void setSiglasRetenedor(String siglasRetenedor) {
        this.siglasRetenedor = siglasRetenedor;
    }

    public HistorialMovimientosContratante getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialMovimientosContratante historial) {
        this.historial = historial;
    }
    
}
