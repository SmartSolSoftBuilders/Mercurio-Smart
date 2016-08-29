package mx.com.seguros.reporte.descuento.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import mx.com.seguros.business.descuentos.DescuentosBusiness;
import mx.com.seguros.business.pagos.impl.TransaccionCuentaClienteBusinessImpl;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.reporte.ReporteBusiness;
import mx.com.seguros.data.dao.DescuentoAplicadoSqlMapDao;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.reporte.descuento.DescuentoReporte;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DescuentoReporteImpl implements DescuentoReporte {

	private static final Logger log = LoggerFactory.getLogger(TransaccionCuentaClienteBusinessImpl.class);
	
    static {
        Locale myLocale;
        myLocale = new Locale("es", "MX");
        Locale.setDefault(myLocale);
    }

    @Override
    public String generarReporte(PolizaIndividual poliza) {
        poliza = polizaBusiness.findPolizaById(poliza);
        String nombreReporte;
        Integer numPoliza = poliza.getNumPoliza();
        nombreReporte = "ReporteDescuentosAplicados_" + numPoliza + ".pdf";
        Collection<DescuentosAplicados> descuentoAplicadoColl;
        descuentoAplicadoColl = calcularRegistrosReporteDescuentosAplicados(poliza);
        JRDataSource dataSource;
        dataSource = new JRBeanCollectionDataSource(descuentoAplicadoColl);
        Map<String, Object> parametros;
        parametros = descuentosAplicadosDao.findParametrosReporteDescuentos(poliza);
                
        String rutaFormatoAplicacionDescuentos2;
        rutaFormatoAplicacionDescuentos2 = generarReporte(parametros,
                dataSource, nombreReporte, "report1.jasper");
        
        log.debug(rutaFormatoAplicacionDescuentos2);

        return nombreReporte;
    }

    private String generarReporte(Map<String, Object> parametros,
            JRDataSource dataSource, String nombreReporte,
            String reporteResourcePath) {
        log.debug("reporteResourcePath: " + reporteResourcePath);
        JasperPrint jasperPrint = null;
        File jasperFile;
        jasperFile =reporteBusiness.obtenerUbicacionReporteEntrada(reporteResourcePath);
        try {
            if (!jasperFile.exists()) {
                // compila al archivo .jrxml:
                int lastDot = reporteResourcePath.lastIndexOf(".");
                String reporteResourcePathSrc;
                reporteResourcePathSrc = reporteResourcePath.substring(0,
                        lastDot)
                        + ".jrxml";
                log.info("Compilando el archivo fuente del reporte "
                        + reporteResourcePathSrc);
                JasperCompileManager.compileReportToFile(reporteResourcePathSrc);
            }
            JasperReport jasperReport;
            jasperReport = (JasperReport) JRLoader.loadObjectFromLocation(jasperFile.getAbsolutePath());
            jasperPrint = JasperFillManager.fillReport(jasperReport,
                    parametros, dataSource);
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    jasperPrint);
            String reportOutPath;
            // TODO Ojo sig linea test vs web test
            reportOutPath = reporteBusiness.obtenerNombreArchivoSalida(nombreReporte);
            		
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    reportOutPath);
            
            log.info("reportOutPath: " + reportOutPath);
            pdfExporter.exportReport();
            // JasperExportManager.exportReportToPdfFile(jasperPrint,
            // nombreReporte);
        } catch (JRException e) {
            log.error("Error en generacion de reporte: ", e);
        }
        return nombreReporte;
    }

    /*
     * (non-Javadoc)
     *
     * @seemx.com.seguros.reporte.descuento.DescuentoReporte#
     * calcularRangoCoberturaReporteDescuentosAplicados
     * (mx.com.seguros.model.PolizaIndividual, java.lang.Integer)
     */
    @Override
    public Collection<DescuentosAplicados> calcularRegistrosReporteDescuentosAplicados(
            PolizaIndividual poliza) {
        DescuentosAplicados registroDescuento;
        Collection<DescuentosAplicados> descuentoAplicadoColl;
        descuentoAplicadoColl = new ArrayList<DescuentosAplicados>();
        List<Integer> qnasPoliza;
        qnasPoliza = descuentoBusiness.findQnasPagoReportadoByPoliza(poliza);
        log.debug("Num de quincenas con pago registrado: " + qnasPoliza.size());
        log.debug("qnasPoliza:\n" + qnasPoliza);
        for (Integer numQnaArchivo : qnasPoliza) {
            registroDescuento = calcularRegistrosReporteDescuentosAplicados(
                    poliza, numQnaArchivo);
            descuentoAplicadoColl.add(registroDescuento);
        }
        return descuentoAplicadoColl;
    }

    /**
     * Calcula los datos finales a mostrar en el reporte de descuentos
     * aplicados, con los pagos correspondientes a quincenas de adeudo ya
     * sumarizadas y resumidas. Los datos del reporte son:
     * <p>
     * numQnaArchivo Integer <br>
     * montoReportado <br>
     * pagoPrima <br>
     * pagoAhorro <br>
     * (PROPUESTA) saldoCtaCliente <br>
     * fechaInicioCobertura <br>
     * fechaFinalCobertura <br>
     *
     * @param poliza
     *            Es la poliza pagada con los descuentos aplicados.
     * @param numQnaArchivo
     *            Es el numero de quincena del archivo del retenedor donde se
     *            reporta el deposito del contratante.
     */
    private DescuentosAplicados calcularRegistrosReporteDescuentosAplicados(
            PolizaIndividual poliza, Integer numQnaArchivo) {
        // Observe que el objeto retornado no corresponde a un registro en base
        // de datos, y solo es auxiliar para el reporte de descuentos:
        DescuentosAplicados registroDescuento;

        // Recupera el reportado en archivo, y los 2 pagos (prima &
        // ahorro)
        registroDescuento = descuentoBusiness.findDescuentoByPolizaQuincenaReportada(poliza, numQnaArchivo);
        // Calculo de rango de cobertura:
        DescuentosAplicados rangoDescuento;
        rangoDescuento = calcularRangoCoberturaReporteDescuentosAplicados(
                poliza, numQnaArchivo);
        Date fechaInicioCobertura;
        fechaInicioCobertura = rangoDescuento.getFechaInicioCobertura();
        registroDescuento.setFechaInicioCobertura(fechaInicioCobertura);
        Date fechaFinalCobertura;
        fechaFinalCobertura = rangoDescuento.getFechaFinalCobertura();
        registroDescuento.setFechaFinalCobertura(fechaFinalCobertura);
        // TODO Pendiente aniadir el saldo de la cta.
        return registroDescuento;
    }

    private DescuentosAplicados calcularRangoCoberturaReporteDescuentosAplicados(
            PolizaIndividual poliza, Integer numQnaArchivo) {
        List<DescuentosAplicados> descAppByPoliza;
        descAppByPoliza = descuentoBusiness.findDescuentoPrimaByPolizaQnaArchivo(poliza, numQnaArchivo);
        DescuentosAplicados rangoDescuento;
        rangoDescuento = new DescuentosAplicados();
        switch (descAppByPoliza.size()) {
            case 0:
                break;

            default:
                DescuentosAplicados firstDescuento;
                firstDescuento = (DescuentosAplicados) CollectionUtils.index(
                        descAppByPoliza, 0);
                DescuentosAplicados lastDescuento;
                lastDescuento = (DescuentosAplicados) CollectionUtils.index(
                        descAppByPoliza, descAppByPoliza.size() - 1);
                Date fechaInicioCobertura;
                fechaInicioCobertura = firstDescuento.getFechaInicioCobertura();
                Date fechaFinalCobertura;
                fechaFinalCobertura = lastDescuento.getFechaFinalCobertura();
                rangoDescuento.setFechaInicioCobertura(fechaInicioCobertura);
                rangoDescuento.setFechaFinalCobertura(fechaFinalCobertura);
                break;

        }
        log.trace("Descuento (rango cobertura) " + rangoDescuento);
        return rangoDescuento;
    }

    @Override
    @Deprecated
    public Map<String, Object> findParametrosReporteDescuentos(
            PolizaIndividual poliza) {
        return descuentosAplicadosDao.findParametrosReporteDescuentos(poliza);
    }

    public void setDescuentoBusiness(DescuentosBusiness descuentoBusiness) {
        this.descuentoBusiness = descuentoBusiness;
    }

    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }

    public void setDescuentosAplicadosDao(
            DescuentoAplicadoSqlMapDao descuentosAplicadosDao) {
        this.descuentosAplicadosDao = descuentosAplicadosDao;
    }
    private DescuentosBusiness descuentoBusiness;
    private IPolizaBusiness polizaBusiness;
    private DescuentoAplicadoSqlMapDao descuentosAplicadosDao;
    private ReporteBusiness reporteBusiness;
	/**
	 * @return the reporteBusiness
	 */
	public ReporteBusiness getReporteBusiness() {
		return reporteBusiness;
	}

	/**
	 * @param reporteBusiness the reporteBusiness to set
	 */
	public void setReporteBusiness(ReporteBusiness reporteBusiness) {
		this.reporteBusiness = reporteBusiness;
	}
}
