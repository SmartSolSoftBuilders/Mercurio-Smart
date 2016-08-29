/**
creado 13 feb 2011 21:30
 */
package mx.com.seguros.data.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import mx.com.seguros.data.dao.ReporteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author Cesar Garcia M
 */
public class ReporteDaoSqlMapDao extends SqlMapClientDaoSupport
        implements ReporteDao {

    @Override
    public Map<String, Object> getParametersReporteCartaResumenPoliza(
            int numCertificado, int numPoliza) {
        final Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("numCertificado", numCertificado);
        try {
            PreparedStatement prepareStatement = getDataSource().getConnection().prepareStatement(SQL_GET_PARAMETERS_REPORTE_CARTA_RESUMEN_POLIZA);
            LOG.info("Parametros de la consulta:\tnumCertificado: " +
                    numCertificado + "  numPoliza: " + numPoliza);
            prepareStatement.setInt(1, numCertificado);
            prepareStatement.setInt(2, numPoliza);
            ResultSet result = prepareStatement.executeQuery();
            LOG.trace("resultSet: " + result);
            Integer numCol = 0;
            while (result.next()) { // process results one row at a time
                parametros.put("apPaternoSolicitante", result.getString(++numCol));
                parametros.put("apMaternoSolicitante", result.getString(++numCol));
                parametros.put("nombre1Solicitante", result.getString(++numCol));
                parametros.put("nombre2Solicitante", result.getString(++numCol));
                //parametros.put("fechaNacimientoSolicitante", result.getDate(++numCol));
                parametros.put("numConsignatario", result.getInt(++numCol));
                parametros.put("sumaAseguradaIndividual", BigDecimal.valueOf(result.getDouble(++numCol)));
                parametros.put("nombrePaquete", result.getString(++numCol));
                parametros.put("importeTarifa", BigDecimal.valueOf(result.getDouble(++numCol)));
                //parametros.put("importePrimaInd", result.getDouble(++numCol));
                parametros.put("sumaAseguradaBAF", BigDecimal.valueOf(result.getDouble(++numCol)));
                parametros.put("sumaGastosFunerarios", BigDecimal.valueOf(result.getDouble(++numCol)));
                parametros.put("sumaSEVI", BigDecimal.valueOf(result.getDouble(++numCol)));
                parametros.put("cvePlaza", result.getString(++numCol));
                parametros.put("domicilioPlaza", result.getString(++numCol));
                parametros.put("lada", String.valueOf(result.getInt(++numCol)));
                parametros.put("telefono", String.valueOf(result.getInt(++numCol)));
                parametros.put("horarioAtencion", result.getString(++numCol));
                parametros.put("cveAgente", result.getLong(++numCol));
                parametros.put("cveSupervisor", result.getInt(++numCol));
                parametros.put("cveGerente", result.getInt(++numCol));
                parametros.put("cveDescuento", result.getString(++numCol));
            }
            /*
            PolizaIndividual polizaIndividual = new PolizaIndividual();
            polizaIndividual.setNumCertificado(numCertificado);
            polizaIndividual.setNumPoliza(numPoliza);
            Map<String, Object> paramMap = (Map) getSqlMapClientTemplate().
            queryForMap("seleccionarParametrosReporteCartaResumenPoliza", polizaIndividual, "cvePlaza");
            LOG.debug("paramMap: " + paramMap);
             */
            //parametros.put("NUM_CONSIGNATARIO", Integer.valueOf("TODO"));
			// TODO - Localizar al reporte...
            // if (args.length != 2){
            /*
             * } else{ language = new String(args[0]); country = new
             * String(args[1]); }
             */
            Locale currentLocale = new Locale("es", "MX");
            Locale.setDefault(currentLocale);
            ResourceBundle textReporteCartaResumenPoliza = ResourceBundle.getBundle("reporteCartaResumenPoliza", currentLocale);
            parametros.put("REPORT_LOCALE", currentLocale);
            parametros.put("REPORT_RESOURCE_BUNDLE", textReporteCartaResumenPoliza);
            LOG.debug("parametros del reporte:\n" + parametros);
        } catch (SQLException ex) {
            LOG.error("", ex);
        }
        return parametros;
    }
    private static final Logger LOG;
    private static final String SQL_GET_PARAMETERS_REPORTE_CARTA_RESUMEN_POLIZA;

    static {
        LOG = LoggerFactory.getLogger(ReporteDaoSqlMapDao.class);
        SQL_GET_PARAMETERS_REPORTE_CARTA_RESUMEN_POLIZA = "SELECT "
                + "slc.apPaternoSolicitante"
                + ", slc.apMaternoSolicitante"
                + ", slc.nombre1Solicitante"
                + ", slc.nombre2Solicitante"
                // + ", slc.fechaNacimientoSolicitante"
                + ", pol.numConsignatario"
                + ", pol.sumaAseguradaIndividual"
                + ", paq.nombrePaquete"
                + ", tar.importeTarifa"
                // + ", tar.importePrimaInd"
                + ", baf.sumaAseguradaBAF"
                + ", pol.sumaGastosFunerarios, pol.sumaSEVI"
                + ", pla.cvePlaza, pla.domicilioPlaza"
                + ", pla.lada, pla.telefono, pla.horarioAtencion"
                + ", agt.cveAgente, agt.cveSupervisor, agt.cveGerente"
                + ", ret.cveDescuento"
                + "  FROM CertificadoIndividual cer"
                + ",  Solicitante slc"
                + ",  PolizaIndividual pol"
                + ",  PaqueteVidaDxN paq"
                + ",  TarifaAportMensual tar"
                + ",  Solicitud sol"
                + ",  Plaza pla, Agente agt, BAF baf"
                + ",  Retenedor ret"
                + ",  Empresa epr"
                + ",  GrupoAsegurado gpo "
                + "  WHERE cer.numCertificado = ?"
                + "     AND pol.numPoliza = ?"
                + "     AND cer.folioSolicitud = pol.folioSolicitud"
                + "     AND sol.folioSolicitud=pol.folioSolicitud"
                + "     AND slc.RFCsolicitante=sol.RFCsolicitante"
                + "     AND tar.cveTarifa=sol.cveTarifa"
                + "     AND agt.cveAgente=sol.cveAgente"
                + "     AND pla.idPlaza=cer.idPlaza"
                + "     AND paq.idPaqueteVidaDxN=pol.tipoSeguro"
                + "     AND baf.importePrimaBAF=tar.importePrimaBAF"
                + "     AND baf.idPaqueteVidaDxN=paq.idPaqueteVidaDxN"
                + "     AND epr.cveEmpresa = sol.cveEmpresa"
                + "     AND gpo.cveGrupoAsegurado = epr.cveGrupoAsegurado"
                + "     AND ret.cveRetenedor=gpo.cveRetenedor";
    }

}
