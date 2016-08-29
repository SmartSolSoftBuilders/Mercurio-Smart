package mx.com.seguros.data.dao.impl;

import java.math.BigDecimal;

import mx.com.seguros.data.dao.TarifaAportMensualDao;
import mx.com.seguros.model.TarifaAportMensual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TarifaAportMensualSqlMapDao extends SqlMapClientDaoSupport
        implements TarifaAportMensualDao {

    @Override
    public BigDecimal findTarifaPoliza(Integer folioSolicitud) {
        if (LOG.isTraceEnabled()) {
            LOG.trace("folioSolicitud: " + folioSolicitud);
        }
        TarifaAportMensual tarifaAportMensual;
        tarifaAportMensual = (TarifaAportMensual) getSqlMapClientTemplate().queryForObject("findTarifaPoliza", folioSolicitud);
        BigDecimal tarifaPolizaVigente;
        tarifaPolizaVigente = BigDecimal.valueOf(tarifaAportMensual.getImporteTarifa());
        if (LOG.isTraceEnabled()) {
            LOG.trace("tarifaPolizaVigente: " + tarifaPolizaVigente);
        }
        return tarifaPolizaVigente;
    }
    private static final Logger LOG;

    static {
        LOG = LoggerFactory.getLogger(TarifaAportMensualSqlMapDao.class);
    }
}
