
/*
 * ReportesPDF.java
 *
 * Created on 18 de octubre de 2007, 06:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.business.reporte;

/**
 *
 * @author Cesar
 */
public class ReportesPDF {
    
    /** Creates a new instance of ReportesPDF */
    private String rutaReporteCertInd;
    private String rutaReporteCartaResumen;
    private String rutaReporteAcuseRecibo;
    private String rutaReportePolizasEmitidas;
    private String rutaFormatoDescuentoAsegurados;
    private String rutaFormatoAplicacionDescuentos;
    private String rutaFormatoAplicacionDescuentos2;
    private String rutaArchivoPagosRetenedor;
    private String rutaReporteAltaAsegurado;
    
    private String rutaReportePagoComisionesAgente;
    private String rutaReportePagoComisionesSupervisor;
    private String rutaReportePagoComisionesGerente;
    private String rutaReporteAsignacionBonoTrimestral;
    
    private String rutaReportePagoComisionesAgenteFactura;
    private String rutaReportePagoComisionesSupervisorFactura;
    private String rutaReportePagoComisionesGerenteFactura;
    
    private String rutaReportePagoComisionesAgenteAsimilables;
    private String rutaReportePagoComisionesSupervisorAsimilables;
    private String rutaReportePagoComisionesGerenteAsimilables;
    
    private String rutaReportePagoComisionesAgenteNoDeterminado;
    private String rutaReportePagoComisionesSupervisorNoDeterminado;
    private String rutaReportePagoComisionesGerenteNoDeterminado;
    
    private String rutaGenerarArchivoPagosRetenedor;
    
    private String rutaVista;
    private String zipFileName;
 //   private String rutaListaSupervisores;
  //  private String rutaListaGerentes;
    
    
    
    public String getRutaFormatoAplicacionDescuentos2() {
        return rutaFormatoAplicacionDescuentos2;
    }

    public void setRutaFormatoAplicacionDescuentos2(String rutaFormatoAplicacionDescuentos2) {
        this.rutaFormatoAplicacionDescuentos2 = rutaFormatoAplicacionDescuentos2;
    }
    
    
     public String getRutaFormatoAplicacionDescuentos() {
        return rutaFormatoAplicacionDescuentos;
    }

    public void setRutaFormatoAplicacionDescuentos(String rutaFormatoAplicacionDescuentos) {
        this.rutaFormatoAplicacionDescuentos = rutaFormatoAplicacionDescuentos;
    }
    
    public String getRutaFormatoDescuentoAsegurados(){
        return rutaFormatoDescuentoAsegurados;
    }

    public void setRutaFormatoDescuentoAsegurados(String rutaFormatoDescuentoAsegurados){
        this.rutaFormatoDescuentoAsegurados=rutaFormatoDescuentoAsegurados;
    }
    
    
    public String getRutaReportePolizasEmitidas(){
        return rutaReportePolizasEmitidas;
    }

    public void setRutaReportePolizasEmitidas(String rutaReportePolizasEmitidas){
        this.rutaReportePolizasEmitidas=rutaReportePolizasEmitidas;
    }
    
    public String getRutaReporteCertInd() {
        return rutaReporteCertInd;
    }

    public void setRutaReporteCertInd(String rutaReporteCertInd) {
        this.rutaReporteCertInd = rutaReporteCertInd;
    }

    public String getRutaReporteCartaResumen() {
        return rutaReporteCartaResumen;
    }

    public void setRutaReporteCartaResumen(String rutaReporteCartaResumen) {
        this.rutaReporteCartaResumen = rutaReporteCartaResumen;
    }

    public String getRutaReporteAcuseRecibo() {
        return rutaReporteAcuseRecibo;
    }

    public void setRutaReporteAcuseRecibo(String rutaReporteAcuseRecibo) {
        this.rutaReporteAcuseRecibo = rutaReporteAcuseRecibo;
    }

   

    public String getRutaReporteAsignacionBonoTrimestral() {
        return rutaReporteAsignacionBonoTrimestral;
    }

    public void setRutaReporteAsignacionBonoTrimestral(String rutaReporteAsignacionBonoTrimestral) {
        this.rutaReporteAsignacionBonoTrimestral = rutaReporteAsignacionBonoTrimestral;
    }
/*
    public String getRutaListaSupervisores() {
        return rutaListaSupervisores;
    }

    public void setRutaListaSupervisores(String rutaListaSupervisores) {
        this.rutaListaSupervisores = rutaListaSupervisores;
    }

    public String getRutaListaGerentes() {
        return rutaListaGerentes;
    }

    public void setRutaListaGerentes(String rutaListaGerentes) {
        this.rutaListaGerentes = rutaListaGerentes;
    }*/

    public String getRutaReportePagoComisionesAgente() {
        return rutaReportePagoComisionesAgente;
    }

    public void setRutaReportePagoComisionesAgente(String rutaReportePagoComisionesAgente) {
        this.rutaReportePagoComisionesAgente = rutaReportePagoComisionesAgente;
    }

    public String getRutaReportePagoComisionesSupervisor() {
        return rutaReportePagoComisionesSupervisor;
    }

    public void setRutaReportePagoComisionesSupervisor(String rutaReportePagoComisionesSupervisor) {
        this.rutaReportePagoComisionesSupervisor = rutaReportePagoComisionesSupervisor;
    }

    public String getRutaReportePagoComisionesGerente() {
        return rutaReportePagoComisionesGerente;
    }

    public void setRutaReportePagoComisionesGerente(String rutaReportePagoComisionesGerente) {
        this.rutaReportePagoComisionesGerente = rutaReportePagoComisionesGerente;
    }

    public String getRutaReportePagoComisionesAgenteFactura() {
        return rutaReportePagoComisionesAgenteFactura;
    }

    public void setRutaReportePagoComisionesAgenteFactura(String rutaReportePagoComisionesAgenteFactura) {
        this.rutaReportePagoComisionesAgenteFactura = rutaReportePagoComisionesAgenteFactura;
    }

    public String getRutaReportePagoComisionesSupervisorFactura() {
        return rutaReportePagoComisionesSupervisorFactura;
    }

    public void setRutaReportePagoComisionesSupervisorFactura(String rutaReportePagoComisionesSupervisorFactura) {
        this.rutaReportePagoComisionesSupervisorFactura = rutaReportePagoComisionesSupervisorFactura;
    }

    public String getRutaReportePagoComisionesGerenteFactura() {
        return rutaReportePagoComisionesGerenteFactura;
    }

    public void setRutaReportePagoComisionesGerenteFactura(String rutaReportePagoComisionesGerenteFactura) {
        this.rutaReportePagoComisionesGerenteFactura = rutaReportePagoComisionesGerenteFactura;
    }

    public String getRutaReportePagoComisionesAgenteAsimilables() {
        return rutaReportePagoComisionesAgenteAsimilables;
    }

    public void setRutaReportePagoComisionesAgenteAsimilables(String rutaReportePagoComisionesAgenteAsimilables) {
        this.rutaReportePagoComisionesAgenteAsimilables = rutaReportePagoComisionesAgenteAsimilables;
    }

    public String getRutaReportePagoComisionesSupervisorAsimilables() {
        return rutaReportePagoComisionesSupervisorAsimilables;
    }

    public void setRutaReportePagoComisionesSupervisorAsimilables(String rutaReportePagoComisionesSupervisorAsimilables) {
        this.rutaReportePagoComisionesSupervisorAsimilables = rutaReportePagoComisionesSupervisorAsimilables;
    }

    public String getRutaReportePagoComisionesGerenteAsimilables() {
        return rutaReportePagoComisionesGerenteAsimilables;
    }

    public void setRutaReportePagoComisionesGerenteAsimilables(String rutaReportePagoComisionesGerenteAsimilables) {
        this.rutaReportePagoComisionesGerenteAsimilables = rutaReportePagoComisionesGerenteAsimilables;
    }

    public String getRutaVista() {
        return rutaVista;
    }

    public void setRutaVista(String rutaVista) {
        this.rutaVista = rutaVista;
    }

    public String getRutaReportePagoComisionesAgenteNoDeterminado() {
        return rutaReportePagoComisionesAgenteNoDeterminado;
    }

    public void setRutaReportePagoComisionesAgenteNoDeterminado(String rutaReportePagoComisionesAgenteNoDeterminado) {
        this.rutaReportePagoComisionesAgenteNoDeterminado = rutaReportePagoComisionesAgenteNoDeterminado;
    }

    public String getRutaReportePagoComisionesSupervisorNoDeterminado() {
        return rutaReportePagoComisionesSupervisorNoDeterminado;
    }

    public void setRutaReportePagoComisionesSupervisorNoDeterminado(String rutaReportePagoComisionesSupervisorNoDeterminado) {
        this.rutaReportePagoComisionesSupervisorNoDeterminado = rutaReportePagoComisionesSupervisorNoDeterminado;
    }

    public String getRutaReportePagoComisionesGerenteNoDeterminado() {
        return rutaReportePagoComisionesGerenteNoDeterminado;
    }

    public void setRutaReportePagoComisionesGerenteNoDeterminado(String rutaReportePagoComisionesGerenteNoDeterminado) {
        this.rutaReportePagoComisionesGerenteNoDeterminado = rutaReportePagoComisionesGerenteNoDeterminado;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public String getRutaGenerarArchivoPagosRetenedor() {
        return rutaGenerarArchivoPagosRetenedor;
    }

    public void setRutaGenerarArchivoPagosRetenedor(String rutaGenerarArchivoPagosRetenedor) {
        this.rutaGenerarArchivoPagosRetenedor = rutaGenerarArchivoPagosRetenedor;
    }

    public String getRutaArchivoPagosRetenedor() {
        return rutaArchivoPagosRetenedor;
    }

    public void setRutaArchivoPagosRetenedor(String rutaArchivoPagosRetenedor) {
        this.rutaArchivoPagosRetenedor = rutaArchivoPagosRetenedor;
    }

    public String getRutaReporteAltaAsegurado() {
        return rutaReporteAltaAsegurado;
    }

    public void setRutaReporteAltaAsegurado(String rutaReporteAltaAsegurado) {
        this.rutaReporteAltaAsegurado = rutaReporteAltaAsegurado;
    }

    

    

   
    
    
}
