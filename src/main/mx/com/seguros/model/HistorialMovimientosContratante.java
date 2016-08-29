/*
 * HistorialMovimientosContratante.java
 *
 * Created on 14 de noviembre de 2008, 01:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class HistorialMovimientosContratante {
    
    /** Creates a new instance of HistorialMovimientosContratante */
    public HistorialMovimientosContratante() {
    }
    
    private int idMovimientoContratante;
    private String numNominaContratante;
    private String qnaProgramadaEnvioMovimientoHistorial;
    private String tipoMovimientoEnvio;
    private double totalImporteMovimiento;
    private String cveDescuento;
    private int indicadorEnvioArchivo;

    public int getIdMovimientoContratante() {
        return idMovimientoContratante;
    }

    public void setIdMovimientoContratante(int idMovimientoContratante) {
        this.idMovimientoContratante = idMovimientoContratante;
    }

    public String getNumNominaContratante() {
        return numNominaContratante;
    }

    public void setNumNominaContratante(String numNominaContratante) {
        this.numNominaContratante = numNominaContratante;
    }

    public String getQnaProgramadaEnvioMovimientoHistorial() {
        return qnaProgramadaEnvioMovimientoHistorial;
    }

    public void setQnaProgramadaEnvioMovimientoHistorial(String qnaProgramadaEnvioMovimientoHistorial) {
        this.qnaProgramadaEnvioMovimientoHistorial = qnaProgramadaEnvioMovimientoHistorial;
    }

    public String getTipoMovimientoEnvio() {
        return tipoMovimientoEnvio;
    }

    public void setTipoMovimientoEnvio(String tipoMovimientoEnvio) {
        this.tipoMovimientoEnvio = tipoMovimientoEnvio;
    }

    public double getTotalImporteMovimiento() {
        return totalImporteMovimiento;
    }

    public void setTotalImporteMovimiento(double totalImporteMovimiento) {
        this.totalImporteMovimiento = totalImporteMovimiento;
    }

    public String getCveDescuento() {
        return cveDescuento;
    }

    public void setCveDescuento(String cveDescuento) {
        this.cveDescuento = cveDescuento;
    }

    public int getIndicadorEnvioArchivo() {
        return indicadorEnvioArchivo;
    }

    public void setIndicadorEnvioArchivo(int indicadorEnvioArchivo) {
        this.indicadorEnvioArchivo = indicadorEnvioArchivo;
    }
    
}
