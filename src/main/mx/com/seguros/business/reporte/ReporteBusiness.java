/*
 * ReporteBusiness.java
 *
 * Created on 10 de octubre de 2007, 12:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mx.com.seguros.business.reporte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import mx.com.seguros.data.dao.IBitacoraEmisionReporteDao;
import mx.com.seguros.data.dao.ICertificadoIndividualDao;
import mx.com.seguros.data.dao.IPolizaDao;
import mx.com.seguros.data.dao.ISolicitudDao;
import mx.com.seguros.data.dao.ReporteDao;
import mx.com.seguros.model.BitacoraEmisionReporte;
import mx.com.seguros.model.CertificadoIndividual;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.FormatUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.FileResolver;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @authors Pedro, Cesar Garcia Mauricio
 */
public class ReporteBusiness implements ApplicationContextAware{

	
	public static String CARTA_RESUMEN = "cartaResumen";
	public static String ACUSE_RECIBO = "acuseRecibo";
	public static String FORMATO_APLIC_DESCUENTOS = "formatoAplicacionDescuentos";
	public static String CERTIFICADO_INDIVIDUAL = "reporteCertificadoIndividual";
	private ICertificadoIndividualDao certificadoIndividualDao = null;
	private IBitacoraEmisionReporteDao bitacoraEmisionReporteDao = null;
	private ISolicitudDao solicitudDao = null;
	private IPolizaDao polizaDao = null;
    public ReporteBusiness() {
    }

    
    /**
	 * Inserta un nuevo registro en la bitácora de emisión de reportes
	 * @param datosEntrada Datos origen
	 */
	void insertarBitacoraEmisionReporte(BitacoraEmisionReporte datosEntrada){
		bitacoraEmisionReporteDao.insertarBitacoraEmisionReporte(datosEntrada);
	}
    
    /**
     * Genera y muestra el reporte de Certificado Individual. El archivo se
     * guarda en formato PDF, y la visualizacion se realiza usando al visor
     * interno (JasperViewer).
     */
    // reportes de pago de comisiones//
    // public String generarReportePagoComisionesAgente(Date
    // fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,Object
    // cveAgentesEsquema,int numQuincenaReporte){
    public String generarReportePagoComisionesAgenteNoDeterminado(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveAgente, int numQuincenaReporte, int anioQuincenaReporte) {

        Integer cveAgente2 = Integer.valueOf(cveAgente);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        String reporteResourcePath = "ReportePagoComisionesAgenteNoDeterminado.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesAgentesNoDeterminado_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveAgente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveAgenteParam", cveAgente2);
        String rutaReportePagoComisionesAgenteNoDeterminado = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesAgenteNoDeterminado;
    }

    public String generarReportePagoComisionesSupervisorNoDeterminado(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveSupervisor, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveSupervisor2 = Integer.valueOf(cveSupervisor);
        String reporteResourcePath = "ReportePagoComisionesSupervisorNoDeterminado.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesSupervisoresNoDeterminado_"
                + "De_"
                + sdf.format(fechaInicioPeriodoComisiones)
                + "_A_"
                + sdf.format(fechaFinPeriodoComisiones)
                + "_"
                + cveSupervisor
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveSupervisorParam", cveSupervisor2);
        String rutaReportePagoComisionesSupervisorNoDeterminado = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesSupervisorNoDeterminado;
    }

    public String generarReportePagoComisionesGerenteNoDeterminado(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveGerente, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveGerente2 = Integer.valueOf(cveGerente);
        String reporteResourcePath = "ReportePagoComisionesGerenteNoDeterminado.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesGerentesNoDeterminado_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveGerente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveGerenteParam", cveGerente2);
        String rutaReportePagoComisionesGerenteNoDeterminado = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesGerenteNoDeterminado;
    }

    public String generarReportePagoComisionesAgente(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveAgente, int numQuincenaReporte, int anioQuincenaReporte) {

        Integer cveAgente2 = Integer.valueOf(cveAgente);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        String reporteResourcePath = "ReportePagoComisionesAgente.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesAgentesPorHonorarios_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveAgente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveAgenteParam", cveAgente2);
        String rutaReportePagoComisionesAgente = generarReporte(parametros,
                nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesAgente;
    }

    // public String generarReportePagoComisionesSupervisor(Date
    // fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones, Object
    // cveAgentesEsquema,int numQuincenaReporte){
    public String generarReportePagoComisionesSupervisor(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveSupervisor, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveSupervisor2 = Integer.valueOf(cveSupervisor);
        String reporteResourcePath = "ReportePagoComisionesSupervisor.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();

        String nombreReporte = "ReportePagoComisionesSupervisoresPorHonorarios_"
                + "De_"
                + sdf.format(fechaInicioPeriodoComisiones)
                + "_A_"
                + sdf.format(fechaFinPeriodoComisiones)
                + "_"
                + cveSupervisor
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveSupervisorParam", cveSupervisor2);
        String rutaReportePagoComisionesSupervisor = generarReporte(parametros,
                nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesSupervisor;
    }

    // public String generarReportePagoComisionesGerente(Date
    // fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,Object
    // cveAgentesEsquema,int numQuincenaReporte){
    public String generarReportePagoComisionesGerente(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveGerente, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveGerente2 = Integer.valueOf(cveGerente);
        String reporteResourcePath = "ReportePagoComisionesGerente.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesGerentesPorHonorarios_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveGerente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveGerenteParam", cveGerente2);
        String rutaReportePagoComisionesGerente = generarReporte(parametros,
                nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesGerente;
    }

    // metodos para esquema de pago perteneciente a FACTURA
    // public String generarReportePagoComisionesAgenteFactura(Date
    // fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,Object
    // cveAgentesEsquema,int numQuincenaReporte){
    public String generarReportePagoComisionesAgenteFactura(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveAgente, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveAgente2 = Integer.valueOf(cveAgente);
        String reporteResourcePath =  "ReportePagoComisionesAgenteFactura.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesAgentesPorFactura_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveAgente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveAgenteParam", cveAgente2);
        String rutaReportePagoComisionesAgenteFactura = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesAgenteFactura;
    }

    public String generarReportePagoComisionesSupervisorFactura(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveSupervisor, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveSupervisor2 = Integer.valueOf(cveSupervisor);
        String reporteResourcePath = "ReportePagoComisionesSupervisorFactura.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesSupervisoresPorFactura_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveSupervisor
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveSupervisorParam", cveSupervisor2);
        String rutaReportePagoComisionesSupervisorFactura = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesSupervisorFactura;
    }

    public String generarReportePagoComisionesGerenteFactura(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveGerente, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveGerente2 = Integer.valueOf(cveGerente);
        String reporteResourcePath =  "ReportePagoComisionesGerenteFactura.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesGerentesPorFactura_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveGerente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveGerenteParam", cveGerente2);
        String rutaReportePagoComisionesGerenteFactura = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesGerenteFactura;
    }

    // metodos para esquema de pago perteneciente a ASIMILABLES A SALARIOS
    public String generarReportePagoComisionesAgenteAsimilables(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveAgente, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveAgente2 = Integer.valueOf(cveAgente);
        String reporteResourcePath =  "ReportePagoComisionesAgenteAsimilables.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesAgentesAsimilables_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveAgente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveAgenteParam", cveAgente2);
        String rutaReportePagoComisionesAgenteAsimilables = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesAgenteAsimilables;
    }

    public String generarReportePagoComisionesSupervisorAsimilables(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveSupervisor, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveSupervisor2 = Integer.valueOf(cveSupervisor);
        String reporteResourcePath =  "ReportePagoComisionesSupervisorAsimilables.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesSupervisoresAsimilables_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveSupervisor
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveSupervisorParam", cveSupervisor2);
        String rutaReportePagoComisionesSupervisorAsimilables = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesSupervisorAsimilables;
    }

    public String generarReportePagoComisionesGerenteAsimilables(
            Date fechaInicioPeriodoComisiones, Date fechaFinPeriodoComisiones,
            int cveGerente, int numQuincenaReporte, int anioQuincenaReporte) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer numQuincenaReporte2 = Integer.valueOf(numQuincenaReporte);
        Integer anioQuincenaReporte2 = Integer.valueOf(anioQuincenaReporte);
        Integer cveGerente2 = Integer.valueOf(cveGerente);
        String reporteResourcePath = "ReportePagoComisionesGerenteAsimilables.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePagoComisionesGerentesAsimilables_"
                + "De_" + sdf.format(fechaInicioPeriodoComisiones) + "_A_"
                + sdf.format(fechaFinPeriodoComisiones) + "_" + cveGerente
                + ".pdf";
        parametros.put("fechaInicioPeriodoComisionesParam",
                fechaInicioPeriodoComisiones);
        parametros.put("fechaFinPeriodoComisionesParam",
                fechaFinPeriodoComisiones);
        parametros.put("numQuincenaReporteParam", numQuincenaReporte2);
        parametros.put("anioQuincenaReporteParam", anioQuincenaReporte2);
        parametros.put("cveGerenteParam", cveGerente2);
        String rutaReportePagoComisionesGerenteAsimilables = generarReporte(
                parametros, nombreReporte, reporteResourcePath);
        return rutaReportePagoComisionesGerenteAsimilables;
    }

    public String generarReporteAsignacionBonoTrimestral(int numQuincenaReporte) {
        Integer numQuincenaReporteAux = Integer.valueOf(numQuincenaReporte);
        String reporteResourcePath = "ReporteAsignacionBonoTrimestral.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReporteAsignacionBonoTrimestral_"
                + numQuincenaReporte + ".pdf";
        parametros.put("numQuincenaReporteParam", numQuincenaReporteAux);
        String rutaReporteAsignacionBonoTrimestral = generarReporte(parametros,
                nombreReporte, reporteResourcePath);
        return rutaReporteAsignacionBonoTrimestral;
    }

    /*
     * public String generarListadeSupervisores(){ String reporteResourcePath=
     * pathBaseJasper + "ListaSupervisores.jasper"; Map<String, Object>
     * parametros=new HashMap<String, Object>(); String nombreReporte=
     * "ListaSupervisores.pdf"; String
     * rutaListaSupervisores=generarReporte(parametros
     * ,nombreReporte,reporteResourcePath); return rutaListaSupervisores; }
     *
     * public String generarListadeGerentes(){ String reporteResourcePath=
     * pathBaseJasper + "ListaGerentes.jasper"; Map<String, Object>
     * parametros=new HashMap<String, Object>(); String nombreReporte=
     * "ListaGerentes.pdf"; String
     * rutaListaGerentes=generarReporte(parametros,nombreReporte
     * ,reporteResourcePath); return rutaListaGerentes; }
     */
    public String generarFormatoAplicacionDescuentos2(int numPoliza,
            int numConsignatario) {
        Integer numPoliza2 = Integer.valueOf(numPoliza);
        Integer numConsignatario2 = Integer.valueOf(numConsignatario);
        String reporteResourcePath = "FormatoAplicacionDescuentos";
        
        PolizaIndividual pol = polizaDao.obtenerResumenPoliza(numPoliza, numConsignatario);
        if(pol != null){
        	Solicitud sol = solicitudDao.obtenerDetalleSolicitudPorFolio(pol.getFolioSolicitud(), pol.getFormatoSolicitud());
        	if(sol != null){
        		if(sol.getTarifa().isConAhorro()){
        			reporteResourcePath = reporteResourcePath + ConstantesGenerales.SUFIJO_REPORTES_CON_AHORRO;
        		}else{
        			reporteResourcePath = reporteResourcePath + ConstantesGenerales.SUFIJO_REPORTES_SIN_AHORRO;
        		}
        	}
        }
        
        reporteResourcePath = reporteResourcePath + ".jasper";
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("numPolizaParam", numPoliza2);
        parametros.put("numConsignatarioParam", numConsignatario2);
        parametros.put("pathLogo", pathBase + FOLDER_SEPARATOR + "img"
                + FOLDER_SEPARATOR + "logoEstrategas.bmp");
        // TODO - Calcular los que deben ser parametros del reporte y aniadirlos
        // al mapa de parametros...
        String nombreReporte;
        nombreReporte = "ReporteDescuentosAplicados_" + numPoliza + ".pdf";
        JRDataSource dataSource;
        // TODO - Crear consulta para llenado de reporte...
     
        String rutaFormatoAplicacionDescuentos2;
        rutaFormatoAplicacionDescuentos2 = generarReporte(parametros, nombreReporte,
                reporteResourcePath);
        	
        log.debug(rutaFormatoAplicacionDescuentos2);
        return rutaFormatoAplicacionDescuentos2;
    }

    /*
     * public String generarFormatoAplicacionDescuentos (int numPoliza){ Integer
     * numPoliza2=new Integer (numPoliza); String reporteResourcePath=
     * pathBaseJasper + "FormatoAplicacionDescuentos.jasper"; Map<String,
     * Object> parametros=new HashMap<String, Object>(); String nombreReporte=
     * "ReporteDescuentosAplicados_"+ numPoliza+ ".pdf";
     * parametros.put("numPolizaParam",numPoliza2);
     *
     * String rutaFormatoAplicacionDescuentos=
     * generarReporte(parametros,nombreReporte,reporteResourcePath); return
     * rutaFormatoAplicacionDescuentos; }
     */
    public String generarFormatoDescuentoAsegurados(final PolizaIndividual poliza) {
    	final Solicitud solicitud = poliza.getSolicitud();
        final Integer cveRetenedor = solicitud.getEmpresa().getGrupoAsegurado().
                getCveRetenedor();
        final Integer numQuincena = poliza.getNumQuincena();
        final Integer anoQuincena = poliza.getAnoQuincena();

        final String numQuincena3;
        if (numQuincena < 10 && numQuincena >= 0) {
            numQuincena3 = '0' + numQuincena.toString();
        } else {
            numQuincena3 = numQuincena.toString();
        }
        
        final Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("cveRetenedorParam", cveRetenedor);
        parametros.put("numQuincenaParam", numQuincena3);
        parametros.put("anoQuincenaParam", anoQuincena);
        
        final String nombreReporte = "FormatoDescuentoAsegurados_" + cveRetenedor
                + ".xls";
        final String reporteResourcePath = "FormatoDescuentoAsegurados_subreport0.jasper";
        
        return generarReporteExcel(parametros,
                nombreReporte, reporteResourcePath);
    }

    public String generarReportePolizasEmitidas(int cveAgente,
            int idEstatusPoliza) {
        Integer cveAgente2 = Integer.valueOf(cveAgente);
        Integer idEstatusPoliza2 = Integer.valueOf(idEstatusPoliza);
        String reporteResourcePath ="ReportePolizasEmitidas.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReportePolizasEmitidas_" + cveAgente + ".pdf";
        parametros.put("valorComboParam", idEstatusPoliza2);
        parametros.put("cveAgenteParam", cveAgente2);

        String rutaReportePolizasEmitidas = generarReporte(parametros,
                nombreReporte, reporteResourcePath);
        return rutaReportePolizasEmitidas;
    }

    public String generarReporteCertificadoIndividual(int folioSolicitud,String formatoSolicitud,
            int numPoliza, int numCertificado, String cvePlaza) {
        // certificadoIndividual.setFechaExpedicion(new Date());
        String reporteResourcePath = "reporteCertificadoIndividual.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReporteCertificadoIndividual_" + numCertificado
                + cvePlaza + ".pdf";
        parametros.put("folioSolicitudParam", folioSolicitud);
        parametros.put("formatoSolicitud", formatoSolicitud);
        parametros.put("numPolizaParam", numPoliza);
        parametros.put("numCertificadoParam", numCertificado);
        String rutaReporteCertInd = generarReporte(parametros, nombreReporte,
                reporteResourcePath);
        // JasperReport jasperReport =
        // (JasperReport) JRLoader.loadObjectFromLocation(
        // "C:/Documents and Settings/Pedro/Mis documentos/
        // proyectos NetBeans/09oct2007/SegurosApp/web/WEB-INF/
        // reportes/reporteCertificadoIndividual.jasper");
        // String reporteResourcePath = ApplicationContext getRealPath("/");
        // Me imprime el pathh de apache tomcat(ruta: C:\Archivos de
        // programa\netbeans-5.5\enterprise3\apache-tomcat-5.5.17\bin)
        // log.debug("padre: " + reporte.getParent());
        // log.debug("abuelo: " + reporte.getParentFile().getParent());
        // log.debug("bisabuelo: " +
        // reporte.getParentFile().getParentFile().getParent());
        // log.debug("tatarabuelo: " +
        // reporte.getParentFile().getParentFile().getParentFile().getParent());
        return rutaReporteCertInd;
    } // generarReporteCertificadoIndividual() //*/

    public String generarReporteCartaResumenPoliza(int numCertificado,
            int numPoliza, int numConsignatario, String cvePlaza) {
        // certificadoIndividual.setFechaExpedicion(new Date());
        
        //Mantenimiento Smart Solutions febrero 2012
        //Dependiendo del formato de la solicitud, elegir un formato de reporte de carta resumen anterior
    	String reporteResourcePath = obtenerNombreReporteCartaResumen(numCertificado,cvePlaza);
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "reporteCartaResumenPoliza_" + numCertificado
                + cvePlaza + ".pdf";
        parametros.put("numCertificadoParam", numCertificado);
        parametros.put("numPolizaParam", numPoliza);
        parametros.put("numConsignatarioParam", numConsignatario);
        //para el caso de carta resumen, se prepara como parámetro una lista de datos clave - valor para
        //imprimir las coberturas y su monto tanto coberturas adicionales como las predeterminadas,
        //esto con la intención de ponerlas todas en un subreporte y no existan espacios en blanco entre
        //la lista de coberturas y el total (este espacio en blaco que pueda dejar el subreporte de beneficios adicionales
        String language;
        String country;
        // if (args.length != 2){
        language = "es";
        country = "MX";
        /*
         * } else{ language = new String(args[0]); country = new
         * String(args[1]); }
         */
        Locale currentLocale = new Locale(language, country);
        Locale.setDefault(currentLocale);
        ResourceBundle textReporteCartaResumenPoliza = ResourceBundle.getBundle("reporteCartaResumenPoliza", currentLocale);

        parametros.put("REPORT_LOCALE", currentLocale);
        parametros.put("REPORT_RESOURCE_BUNDLE", textReporteCartaResumenPoliza);
        String rutaReporteCartaResumen = generarReporte(parametros,
                nombreReporte, reporteResourcePath);
        return rutaReporteCartaResumen;
    } // generarReporteCartaResumenPoliza() //*/

    
    /**
     * Elije el nombre correcto del archivo de reporte a emitir:
     * Se obtiene del certificado individual el formato de la solicitud, si existe
     * un archivo llamado reporteCartaResumenPoliza_[numero de formato].jasper
     * entonces se utiliza ese archivo en especial, de lo contratio se usa la opción
     * predeterminada reporteCartaResumenPoliza.jasper
     * @param numCertificado Número de certificado de la solicitud e emitir
     * @param cvePlaza Clave de la plaza de la solicitud a emitir
     * @return Nombre del reporte jasper con el que se va a emitir el reporte
     */
    private String obtenerNombreReporteCartaResumen(int numCertificado,
			String cvePlaza) {
    	String nombreJasper = "reporteCartaResumenPoliza";
    	String ext = ".jasper";
    	
    	
    	
    	CertificadoIndividual certificado = certificadoIndividualDao.buscarCertificadoPorCertificadoYPlaza(numCertificado, cvePlaza);
    	String nombreFinal = null;
    	if(certificado != null){
    		
    		//Verificar el tipo de seguro si es con ahorro o sin ahorro
    		Solicitud sol = solicitudDao.obtenerDetalleSolicitudPorFolio(certificado.getFolioSolicitud(), certificado.getFormatoSolicitud());
    		if(sol.getTarifa().isConAhorro()){
    			nombreJasper = nombreJasper + ConstantesGenerales.SUFIJO_REPORTES_CON_AHORRO;
    		}else{
    			nombreJasper = nombreJasper + ConstantesGenerales.SUFIJO_REPORTES_SIN_AHORRO;
    		}
    		nombreFinal = nombreJasper + "_" + certificado.getFormatoSolicitud() + ext;
    		File jasperFile = obtenerUbicacionReporteEntrada(nombreFinal);
    		if(jasperFile == null){
    			nombreFinal = nombreJasper +   ext;
    			 jasperFile = obtenerUbicacionReporteEntrada(nombreJasper +   ext);
    		}
    		
    	}
		return nombreFinal;
	}


	public String generarReporteAcuseReciboPoliza(int numCertificado,
            int numPoliza, String cvePlaza) {
        // certificadoIndividual.setFechaExpedicion(new Date());
        String reporteResourcePath = "reporteAcuseReciboPoliza";
        
        CertificadoIndividual certificado = certificadoIndividualDao.buscarCertificadoPorCertificadoYPlaza(numCertificado, cvePlaza);
        if(certificado != null){
        	Solicitud sol = solicitudDao.obtenerDetalleSolicitudPorFolio(certificado.getFolioSolicitud(), certificado.getFormatoSolicitud());
        	if(sol.getTarifa().isConAhorro()){
        		reporteResourcePath = reporteResourcePath + ConstantesGenerales.SUFIJO_REPORTES_CON_AHORRO;
    		}else{
    			reporteResourcePath = reporteResourcePath + ConstantesGenerales.SUFIJO_REPORTES_SIN_AHORRO;
    		}
        }
        reporteResourcePath = reporteResourcePath +  ".jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReporteAcuseReciboPoliza" + numCertificado
                + cvePlaza + ".pdf";
        parametros.put("numCertificadoParam", numCertificado);
        parametros.put("numPolizaParam", numPoliza);
        String rutaReporteAcuse = generarReporte(parametros, nombreReporte,
                reporteResourcePath);
        return rutaReporteAcuse;
    } // generarReporteAcuseReciboPoliza() //*/

    public String generarArchivoPagosRetenedor(String anioQuincenaPago,
            String siglasRetenedor) {
        String reporteResourcePath =  "FormatoPagosRetenedor.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "PagosRetenedor" + siglasRetenedor
                + anioQuincenaPago + ".xls";
        String rutaArchivoPagosRetenedor = generarReporteExcel(parametros,
                nombreReporte, reporteResourcePath);
        return rutaArchivoPagosRetenedor;
    }

    public String generarArchivoAltaAsegurados(int cveRetenedor,
            String anioQuincenaAplicacion, String siglasRetenedor) {
        String reporteResourcePath =  "FormatoAltaAsegurados2.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "AltaAsegurados" + siglasRetenedor
                + anioQuincenaAplicacion + ".xls";
        parametros.put("cveRetenedorParam", cveRetenedor);
        String rutaArchivoAltaAsegurados = generarReporteExcel(parametros,
                nombreReporte, reporteResourcePath);
        return rutaArchivoAltaAsegurados;
    }

    public Connection getConnection() {
        Connection conexion;
        conexion = null;
        try {
            System.out.println("Nota 1: "+JRPropertiesMap.class.getPackage().getImplementationVersion());
            System.out.println("Nota 2: "+JRPropertiesMap.class.getResource("/net/sf/jasperreports/engine/JRPropertiesMap.class"));
            conexion = jdbcDataSource.getConnection();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return conexion;
    }

    private void copiaArchivo(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    private String generarReporteExcel(Map<String, Object> parametros,
            String nombreReporte, String reporteResourcePath) {
        log.debug("nombreReporte: " + nombreReporte);
        log.debug("reporteResourcePath: " + reporteResourcePath);
        Connection con = getConnection();
        try {
            JasperReport jasperReport;
            jasperReport = (JasperReport) JRLoader.loadObjectFromLocation(obtenerUbicacionReporteEntrada(reporteResourcePath).getAbsolutePath());
            JasperPrint jasperPrint;
            jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parametros, con);
            // JExcelApiExporter xlsExporter = new JExcelApiExporter();
            JRXlsExporter xlsExporter = new JRXlsExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    jasperPrint);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    nombreReporte);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
                    Boolean.FALSE);
            xlsExporter.setParameter(
                    JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
                    Boolean.TRUE);
            xlsExporter.setParameter(
                    JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
                    Boolean.FALSE);
            xlsExporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        // JasperViewer.viewReport(jasperPrint);
        moveReportLocation(nombreReporte);
        return nombreReporte;
    }

    private void moveReportLocation(String nombreReporte) {
        // File dirReporte = new File(".");
        File dirReporte = new File("");
        File reporteOrigen;
        reporteOrigen = new File(dirReporte.getAbsolutePath()
                + FOLDER_SEPARATOR + nombreReporte);
        String msg;
        msg = "La trayectoria al reporte es " + dirReporte.getAbsolutePath();
        log.debug(msg);
        // Copy report from its current location to directory
        // WEB/reportes of application: XXX
        
        File reporteDestinoFile =  new File(obtenerNombreArchivoSalida(nombreReporte));
        log.debug("Origen: " + reporteOrigen.getAbsolutePath());
        log.debug("Destino: " + reporteDestinoFile.getAbsolutePath());
        try {
            copiaArchivo(reporteOrigen, reporteDestinoFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            reporteOrigen.delete();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private String generarReporte(Map<String, Object> parametros,
            JRDataSource dataSource, String nombreReporte,
            String reporteResourcePath) {
        log.debug("reporteResourcePath: " + reporteResourcePath);
        JasperPrint jasperPrint = null;
        File jasperFile;
        jasperFile = new File(reporteResourcePath);
        try {
            if (!jasperFile.exists()) {
                // compila al archivo .jrxml:
                int lastDot = reporteResourcePath.lastIndexOf(".");
                String reporteResourcePathSrc;
                reporteResourcePathSrc = reporteResourcePath.substring(0,
                        lastDot)
                        + ".jrxml";
                log.debug("Compilando el archivo fuente del reporte "
                        + reporteResourcePathSrc);
                JasperCompileManager.compileReportToFile(reporteResourcePathSrc);
            }
            JasperReport jasperReport;
            jasperReport = (JasperReport) JRLoader.loadObjectFromLocation(reporteResourcePath);
            jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parametros, dataSource);
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    jasperPrint);
            String reportOutPath;
            // TODO Ojo sig linea test vs web test
            reportOutPath = pathBase + FOLDER_SEPARATOR 
                    + nombreReporte;
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    reportOutPath);
            log.debug("reportOutPath: " + reportOutPath);
            pdfExporter.exportReport();
            // JasperExportManager.exportReportToPdfFile(jasperPrint,
            // nombreReporte);
        } catch (JRException e) {
        	e.printStackTrace();
            log.error("Error en generacion de reporte: ", e);
        }
        return nombreReporte;
    }

    private String generarReporte(Map<String, Object> parametros,
            String nombreReporte, String reporteResourcePath) {
    	
    	String reportOutPath = null;
    	String nombreReporteFinal = null;
    	
    	log.info("reporteResourcePath: "+reporteResourcePath);
        /* Modificacion necesaria por cambio de version de iReports y su consecuente archivo jasper << CGB >>*/
        Connection con = null;
        try {
            //Se obtiene directamente del DataSource definido e inyectado por spring
        	//23/11/2011 Mantenimiento QTX
            con = jdbcDataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ReporteBusiness.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        //Connection con = getConnection();
        JasperPrint jasperPrint = null;
        
        File jasperFile;
        //Se obtiene a partir de la ruta relativa 23/11/2011 Mantenimiento QTX
        System.out.println("+++++++++++ReporteBusiness--Obtencion Archivo+++++++++++++++");
        jasperFile = obtenerUbicacionReporteEntrada(reporteResourcePath);
        System.out.println("jasper file "+jasperFile);
       try {
            if (jasperFile == null) {
            	 System.out.println("+++++++++++ReporteBusiness--Previo a Compilacion+++++++++++++++");
                 System.out.println(reporteResourcePath.substring(0,
                		 reporteResourcePath.lastIndexOf(".")));
                
            	// compila al archivo .jrxml:
                int lastDot = reporteResourcePath.lastIndexOf(".");
                String reporteResourcePathSrc;
                reporteResourcePathSrc = reporteResourcePath.substring(0,
                        lastDot)
                        + ".jrxml";
                log.info("Compilando el archivo fuente del reporte "
                        + reporteResourcePathSrc);
            System.out.println("+++++++++++ReporteBusiness--Previo a Compilacion+++++++++++++++");
            System.out.println(reporteResourcePathSrc);
            System.out.println("ruta:"+reporteResourcePath + " " + reporteResourcePathSrc);
                //JasperCompileManager.compileReportToFile("C:\\desarrollo-mercurio\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\seguros4\\WEB-INF\\classes\\jasper\\" +reporteResourcePathSrc);
                JasperCompileManager.compileReportToFile("C:\\MarsWorkspace\\Seguros2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\seguros4\\WEB-INF\\classes\\jasper\\" +reporteResourcePathSrc);
                //JasperCompileManager.compileReportToFile("C:\\desarrollo-mercurio2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\seguros4\\WEB-INF\\classes\\jasper\\" +reporteResourcePathSrc);

                jasperFile = obtenerUbicacionReporteEntrada(reporteResourcePath);
            }
            int lastDot = reporteResourcePath.lastIndexOf(".");
            System.out.println("+++++++++++...--Previo a Carga+++++++++++++++");
            System.out.println(reporteResourcePath.substring(0,lastDot));
            //jasperFile=new File("C:\\mercuriows\\seguros4\\WebContent\\WEB-INF\\classes\\jasper\\reporteCartaResumenPolizajasper");
            //jasperFile=new File("C:\\Mercurio-Smart2\\WebContent\\WEB-INF\\classes\\jasper\\reporteAcuseReciboPoliza.jasper");
//<<<<<<< HEAD
            //jasperFile=new File("C:\\desarrollo-mercurio2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\seguros4\\WEB-INF\\classes\\jasper\\reporteAcuseReciboPoliza.jasper"); //reporteAcuseReciboPoliza.jasper //reporteCartaResumenPoliza.jasper
            jasperFile=new File("C:\\MarsWorkspace\\Seguros2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\seguros4\\WEB-INF\\classes\\jasper\\"+ reporteResourcePath.substring(0,lastDot) + ".jasper");
//=======
            //jasperFile=new File("C:\\MarsWorkspace\\Seguros\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\seguros4\\WEB-INF\\classes\\jasper\\reporteCartaResumenPoliza.jasper"); //reporteAcuseReciboPoliza.jasper //reporteCartaResumenPoliza.jasper
//>>>>>>> branch 'desarrollo' of https://github.com/SmartSolSoftBuilders/Mercurio-Smart.git
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromLocation(jasperFile.getAbsolutePath());
            
            // con = SoporteDatos.getConnection();
            
            //agregar el parámetro de directorio de reportes
            
            System.out.println("+++++++++++ReporteBusiness+++++++++++++++");
            System.out.println(jasperReport);
            System.out.println(parametros);
            System.out.println(con);
            System.out.println("+++++++++++ReporteBusiness+++++++++++++++");
            
            jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parametros, con);
            
            
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    jasperPrint);
            
            //23/11/2011 Mantenimiento QTX
            reportOutPath = obtenerNombreArchivoSalida(nombreReporte);
            nombreReporteFinal = obtenerNombreArchivoSalidaSinRuta(nombreReporte);		
            		
          
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    reportOutPath);
            log.debug("reportOutPath: " + reportOutPath);
            pdfExporter.exportReport();
            // JasperExportManager.exportReportToPdfFile(jasperPrint,
            // nombreReporte);
        } catch (JRException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println(e1.getMessage());
                }
            }
        
    
    
    
    }
        // JasperViewer.viewReport(jasperPrint);
        // File dirReporte = new File(".");
        // File dirReporte = new File("");
        // File reporteOrigen = new File(dirReporte.getAbsolutePath() + "//"
        // + nombreReporte);
        // log.debug("nombre buscado" + dirReporte.getAbsolutePath());
        // // Copio al reporte de su localidad actual (el bin del apache tomcat)
        // // hacia el dir WEB/reportes de la aplicacion:
        // String reporteDestino = pathBase + "/reportes/" + nombreReporte;
        // // String reporteDestino = pathBaseJasper + nombreReporte;
        // File reporteDestinoFile = new File(reporteDestino);
        // log.info("Origen: " + reporteOrigen.getAbsolutePath());
        // log.info("Destino: " + reporteDestino);
        // try {
        // copiaArchivo(reporteOrigen, reporteDestinoFile);
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // throw new RuntimeException(ex);
        // }
        // reporteOrigen.delete();
            
    //}catch(Exception e)
    //{
    	
    //	System.out.println(e.getMessage());
    //	e.printStackTrace();
    	
   // }    
            
            
        return nombreReporteFinal;
    }
// Se desactivan cambios para eliminar directorios en hardcore por error de ejecucion que serÃ¡ solucionado en la nueva version //
  /*  public static String getPathBaseJasper() {
        if (pathBaseJasper == null) {
            // String webappRoot;
            // webappRoot = System.getProperty("webapp.root");
            // log.info("webapp.root: " + webappRoot);
            Resource pathResource;
            pathResource = new ClassPathResource("");
            try {
                pathBase = pathResource.getFile().getAbsolutePath();
                pathBase = pathBase.replace("WEB-INF" + FOLDER_SEPARATOR
                        + "classes", "");
                // TODO Ojo sig linea en amb test vs pruebas WEB!!!
                pathBaseJasper = pathBase + FOLDER_SEPARATOR + "jasper" + FOLDER_SEPARATOR;
            } catch (IOException e) {
                log.error("IOException: " + e.getMessage());
                e.printStackTrace();
            }
            log.info("pathBaseJasper ini: " + pathBaseJasper);
        }
        return pathBaseJasper;
    }

    public static String getPathBase() {
        if (pathBase == null) {
            getPathBaseJasper();
        }
        return pathBase;
    }*/
    /**
     * Obtiene la ruta absoluta del archivo donde se tiene que escribir la salida del reporte
     * @param nombreReporte Nombre del archivo de slaida
     * @return Ruta completa del archivo de salida, null en caso de no poder localizarla
     */
    public String obtenerNombreArchivoSalida(String nombreReporte) {
		File basePath = new File(getClass().getResource("/").getFile());
		File finalPath = new File(basePath.getParentFile().getParentFile() + 
				FOLDER_SEPARATOR + pathBase + FOLDER_SEPARATOR + nombreReporte);
		
		/**
		 * En lugar de sobreescribir el reporte, se requiere versionar
		 */
		if(finalPath.exists()){
			int indiceNombre = 1;
			int lastDot = nombreReporte.lastIndexOf(".");
            String nombreArchivo = nombreReporte.substring(0,
                    lastDot);
            String extension = nombreReporte.substring(lastDot);
            
            while(finalPath.exists()){
            	finalPath = new File(basePath.getParentFile().getParentFile() + 
        				FOLDER_SEPARATOR + pathBase + FOLDER_SEPARATOR + 
        				nombreArchivo + "_" + indiceNombre + extension);
            	indiceNombre++;
            }
			
			
			
		}
		
		return finalPath.getAbsolutePath();
	}
    /**
     * Obtiene la ruta absoluta del archivo donde se tiene que escribir la salida del reporte
     * @param nombreReporte Nombre del archivo de slaida
     * @return Ruta completa del archivo de salida, null en caso de no poder localizarla
     */
    public String obtenerNombreArchivoSalidaSinRuta(String nombreReporte) {
		File basePath = new File(getClass().getResource("/").getFile());
		File finalPath = new File(basePath.getParentFile().getParentFile() + 
				FOLDER_SEPARATOR + pathBase + FOLDER_SEPARATOR + nombreReporte);
		
		/**
		 * En lugar de sobreescribir el reporte, se requiere versionar
		 */
		if(finalPath.exists()){
			int indiceNombre = 1;
			int lastDot = nombreReporte.lastIndexOf(".");
            String nombreArchivo = nombreReporte.substring(0,
                    lastDot);
            String extension = nombreReporte.substring(lastDot);
            
            while(finalPath.exists()){
            	finalPath = new File(basePath.getParentFile().getParentFile() + 
        				FOLDER_SEPARATOR + pathBase + FOLDER_SEPARATOR + 
        				nombreArchivo + "_" + indiceNombre + extension);
            	indiceNombre++;
            }
			
			
			
		}
		
		return finalPath.getName();
	}

	public void setJdbcDataSource(DataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }
    private static final Log log;
    //private static String pathBaseJasper;
    private String pathBaseJasper ="/jasper/";
    //private static String pathBase;
    private String pathBase ="reportes";
    private DataSource jdbcDataSource;
    private ReporteDao reporteDao;
    public static final String FOLDER_SEPARATOR;
    private ApplicationContext applicationContext = null;
    static {
        log =
                 LogFactory.getLog(ReporteBusiness.class);
        FOLDER_SEPARATOR = SystemUtils.FILE_SEPARATOR;
        /*
         * try { Resource pathResource; pathResource = new
         * ClassPathResource("/reportes/"); pathBase =
         * pathResource.getFile().getAbsolutePath();; } catch (IOException e) {
         * pathBase = "/"; e.printStackTrace(); } log.debug("pathBase ini: " +
         * pathBase);
         */
    }

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		applicationContext = arg0;
		
	}
	
	/**
	 * Obtine la ubicación de algún archivo en específico (utilizando el getResource del class loader)
	 * @param archivo Nombre del archivo a obtener
	 * @return Archivo, nulo si no existe la ruta
	 */
	public File obtenerUbicacionReporteEntrada(String archivo){
		 URL ubicacion = getClass().getResource(pathBaseJasper + archivo);
		 System.out.println(pathBaseJasper + archivo);
		 log.info("Ubicacion reporte: pathBaseJasper = "+pathBaseJasper);
		 log.info("Ubicacion reporte: archivo = "+archivo);
		 log.info("Ubicacion reporte: URL = "+  (ubicacion != null? ubicacion.toString():"ubicación nula"));
	     return ubicacion!=null?new File(ubicacion.getFile()):null;
	}

	/**
	 * @return the reporteDao
	 */
	public ReporteDao getReporteDao() {
		return reporteDao;
	}

	/**
	 * @param reporteDao the reporteDao to set
	 */
	public void setReporteDao(ReporteDao reporteDao) {
		this.reporteDao = reporteDao;
	}

	/**
	 * @param bitacoraEmisionReporteDao the bitacoraEmisionReporteDao to set
	 */
	public void setBitacoraEmisionReporteDao(
			IBitacoraEmisionReporteDao bitacoraEmisionReporteDao) {
		this.bitacoraEmisionReporteDao = bitacoraEmisionReporteDao;
	}
	
	/**
	 * Emisión de reportes genérica
	 * @param claveReporte Clave del reporte a emitir
	 * @param params Conjunto de parámetros obtenidos de la capa de vista en forma de clave-valor
	 * @param usuario Usuario que emite el reporte
	 * @param comentario Comentario de la emisión del reporte
	 * @return Ruta del reporte generado
	 */
	public String emitirReporteGenerico(String claveReporte,Map params,String usuario,String comentario){
		String rutaFinal = null;
		
		if(CARTA_RESUMEN.equals(claveReporte)){
			
			rutaFinal = generarReporteCartaResumenPoliza(
					NumberUtils.toInt(params.get("numCertificado")!=null?params.get("numCertificado").toString():null,0),
					NumberUtils.toInt(params.get("numPoliza")!=null?params.get("numPoliza").toString():null,0), 
					NumberUtils.toInt(params.get("numConsignatario")!=null?params.get("numConsignatario").toString():null,0),
					params.get("cvePlaza")!=null?params.get("cvePlaza").toString():StringUtils.EMPTY);
			
		}
		if(ACUSE_RECIBO.equals(claveReporte)){
			rutaFinal = generarReporteAcuseReciboPoliza(
					NumberUtils.toInt(params.get("numCertificado")!=null?params.get("numCertificado").toString():null,0),
					NumberUtils.toInt(params.get("numPoliza")!=null?params.get("numPoliza").toString():null,0), 
					params.get("cvePlaza")!=null?params.get("cvePlaza").toString():StringUtils.EMPTY);
		}
		
		if(FORMATO_APLIC_DESCUENTOS.equals(claveReporte)){
			rutaFinal = generarFormatoAplicacionDescuentos2(NumberUtils.toInt(params.get("numPoliza")!=null?params.get("numPoliza").toString():null,0),
					NumberUtils.toInt(params.get("numEmisor")!=null?params.get("numEmisor").toString():null,0));
		}
		if(CERTIFICADO_INDIVIDUAL.equals(claveReporte)){
			rutaFinal = generarReporteCertificadoIndividual(
					NumberUtils.toInt(params.get("folioSolicitud")!=null?params.get("folioSolicitud").toString():null,0),
					params.get("formatoSolicitud")!=null?params.get("formatoSolicitud").toString():StringUtils.EMPTY,
							NumberUtils.toInt(params.get("numPoliza")!=null?params.get("numPoliza").toString():null,0), 
							NumberUtils.toInt(params.get("numCertificado")!=null?params.get("numCertificado").toString():null,0), 
					params.get("cvePlaza")!=null?params.get("cvePlaza").toString():StringUtils.EMPTY);
		}
		
		 
		BitacoraEmisionReporte bitacora = new BitacoraEmisionReporte();
		bitacora.setComentario(comentario);
		bitacora.setFechaEmision(new Date());
		bitacora.setNombreArchivoGenerado(rutaFinal);
		bitacora.setNombreReporte(claveReporte);
		bitacora.setUsuario(usuario);
		bitacoraEmisionReporteDao.insertarBitacoraEmisionReporte(bitacora);
		return rutaFinal;
	}


	/**
	 * @param certificadoIndividualDao the certificadoIndividualDao to set
	 */
	public void setCertificadoIndividualDao(
			ICertificadoIndividualDao certificadoIndividualDao) {
		this.certificadoIndividualDao = certificadoIndividualDao;
	}
	
	/**
	 * Genera el reporte PDF de resumen de un proceso de cálculo de bono
	 * @param idResumenProceso Identificador del resumen del proceso
	 * @return Ruta de acceso al reporte
	 */
	public String generarReporteResumenProcesoCalculoBono(Integer idResumenProceso) {
        
        String reporteResourcePath = "ReporteResumenProcesoCalculoBonos.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ResumenProcesoCalculoBonos_" + idResumenProceso + ".pdf";
        parametros.put("idResumenProcesoCalculoBono", idResumenProceso);
        String rutaReporteAcuse = generarReporte(parametros, nombreReporte,
                reporteResourcePath);
        return rutaReporteAcuse;
    } 
	
	/**
	 * Genera el reporte PDF de resumen del cálculo del bono de un agente en un cierto proceso de cálculo
	 * @param idResumenCalculoBonoPolizaAgente Identificador del resumen del cálculo del agente
	 * @return Ruta de acceso al reporte
	 */
	public String generarReporteResumenCalculoBonoAgente(Integer idResumenCalculoBonoPolizaAgente) {
        
		
       
		
        String reporteResourcePath = "ReporteResumenCalculoBonoPolizaAgente.jasper";
        Map<String, Object> parametros = new HashMap<String, Object>();
        String nombreReporte = "ReporteResumenCalculoBonoPolizaAgente_" + idResumenCalculoBonoPolizaAgente + ".pdf";
        parametros.put("idResumenCalculoBonoPolizaAgente", idResumenCalculoBonoPolizaAgente);
        
        //System.out.println("*********generarReporteResumenCalculoBonoAgente************");
        //System.out.println(parametros);
        //System.out.println(nombreReporte);
        //System.out.println(reporteResourcePath);
        //System.out.println("*********generarReporteResumenCalculoBonoAgente************");
        
        
        
        
        String rutaReporteAcuse = generarReporte(parametros, nombreReporte,
                reporteResourcePath);
        
        
        return rutaReporteAcuse; 
		
		//return "C:\\apache-tomcat-7.0.67\\webapps\\seguros4\\reportes\\ReporteResumenCalculoBonoPolizaAgente_1893_4.pdf";
    }


	/**
	 * @param solicitudDao the solicitudDao to set
	 */
	public void setSolicitudDao(ISolicitudDao solicitudDao) {
		this.solicitudDao = solicitudDao;
	}


	/**
	 * @param polizaDao the polizaDao to set
	 */
	public void setPolizaDao(IPolizaDao polizaDao) {
		this.polizaDao = polizaDao;
	} 
}