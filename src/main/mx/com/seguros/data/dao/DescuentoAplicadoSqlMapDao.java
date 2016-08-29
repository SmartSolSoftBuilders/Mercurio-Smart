
package mx.com.seguros.data.dao;

/**
 *
 * @author Capacitacion
 */
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.data.dao.exception.DescuentoAplicadoException;
import mx.com.seguros.model.ArchivosDescuentosCargados;
import mx.com.seguros.model.CifrasControlProcesoAutofinanciar;
import mx.com.seguros.model.DescuentosAplicados;
import mx.com.seguros.model.PolizaIndividual;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DescuentoAplicadoSqlMapDao extends SqlMapClientDaoSupport implements IDescuetosAplicadosDao{
    
	public DescuentoAplicadoSqlMapDao() {
    }

    @Override
    public List obtenDescuentosPorPoliza(PolizaIndividual poliza) {
        return getSqlMapClientTemplate().queryForList(
                "buscarDescuentosPorPoliza", poliza);

    }

    @Override
    public List obtenDescuentosPorPoliza(DescuentosAplicados descuento) {
        return this.getSqlMapClientTemplate().queryForList("buscarDescuentosPorNumPoliza", descuento);
    }

    @Override
    public void insertarDescuentoAplicado(DescuentosAplicados descuento) {
        this.getSqlMapClientTemplate().insert("insertarDescuentoAplicado", descuento);
    }

    @Override
    public Object obtenIndiceArchivo(Integer numQuincena) {
        return this.getSqlMapClientTemplate().queryForObject("obtenUltimoArchivoCargado", numQuincena);
    }

    @Override
    public List obtenArchivosCargados() {
        return this.getSqlMapClientTemplate().queryForList("obtenArchivosCargados");
    }

    @Override
    public void insertaDatosArchivo(ArchivosDescuentosCargados archivoCargado) {
        this.getSqlMapClientTemplate().insert("insertaDatosArchivo", archivoCargado);
    }

    @Override
    public Object obtenerUltimoImporteRealPagoPrima(DescuentosAplicados descuento) {
        return this.getSqlMapClientTemplate().queryForObject("obtenerUltimoImporteRealPagoPrima", descuento);
    }

    @Override
    public List<Integer> findQnasPagoReportadoByPoliza(PolizaIndividual poliza) {
        return getSqlMapClientTemplate().queryForList("quincenasPagoReportado",
                poliza);
    }

    @Override
    public DescuentosAplicados findDescuentoByPolizaQuincenaReportada(PolizaIndividual poliza, Integer numQnaArchivo) {

        Map<String, Object> paramMap;
        paramMap = new HashMap<String, Object>();
        paramMap.put("numQnaArchivo", numQnaArchivo);
        paramMap.put("numPoliza", poliza.getNumPoliza());
        paramMap.put("numConsignatario", poliza.getNumConsignatario());
        paramMap.put("numQnaPagada", numQnaArchivo);

        DescuentosAplicados descuentoAplicado;
        descuentoAplicado = (DescuentosAplicados) getSqlMapClientTemplate().queryForObject("consultaDescuentoByPolizaQuincenaReportada",
                paramMap);
        if (descuentoAplicado == null) {
            LOG.info("Se realizar\u00E1 una segunda b\u00FAsqueda...");
            descuentoAplicado = (DescuentosAplicados) getSqlMapClientTemplate().queryForObject(
                    "consultaDescuentoByPolizaQuincenaReportada2",
                    paramMap);
            if (descuentoAplicado == null) {
                StringBuilder msg = new StringBuilder();
                msg.append("No fue posible encontrar el descuento aplicado ");
                msg.append("para la quincena de archivo ");
                msg.append(numQnaArchivo);
                msg.append(" y la p\u00F3liza \n");
                msg.append(poliza);
                throw new DescuentoAplicadoException(msg.toString());
            }
        }

        return descuentoAplicado;


    }

    @Override
    public List<DescuentosAplicados> findDescuentoPrimaByPolizaQnaArchivo(PolizaIndividual poliza, Integer numQnaArchivo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("numPoliza", poliza.getNumPoliza());
        paramMap.put("numConsignatario", poliza.getNumConsignatario());
        paramMap.put("numQnaArchivo", numQnaArchivo);

        List<DescuentosAplicados> descuentosPolizaQna;
        descuentosPolizaQna = (List) getSqlMapClientTemplate().queryForList(
                "consultaDescuentosByPolizaQnaArchivo", paramMap);

        return descuentosPolizaQna;

    }

    @Override
    public Map<String, Object> findParametrosReporteDescuentos(PolizaIndividual poliza) {
        Map paramMap;
        paramMap = getSqlMapClientTemplate().queryForMap("findParametrosReporteDescuentos", poliza,
                "nombre1Contratante");
        Integer paramMapSize;
        paramMapSize = paramMap.size();
        if (paramMapSize == 1) {
            paramMap = (Map) paramMap.values().toArray()[0];
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Se esperaba un solo objeto, se han encontrado ");
            sb.append(paramMapSize);
            throw new DescuentoAplicadoException(sb.toString());
        }
        String pathLogo;
        
        logParams(paramMap);
        return paramMap;
    }

    private void logParams(Map paramMap) {
        if (LOG.isTraceEnabled()) {
            LOG.trace("INICIA TRAZA PARAMS");
            for (Object paramObj : paramMap.entrySet()) {
                LOG.trace("" + ((Map.Entry) paramObj).getValue().getClass() + " : " + paramObj);
            }
            LOG.trace("TERMINA TRAZA PARAMS");
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("paramMap: " + paramMap);
        }
    }

    @Override
    public Integer findFechaPrimerPagoInt(PolizaIndividual poliza) {
        String qryId = "findFechaPrimerPago";
        Integer qnaPrimerPago;
        qnaPrimerPago = (Integer) getSqlMapClientTemplate().queryForObject(
                qryId, poliza);
        return qnaPrimerPago;

    }

    @Override
    public int obtenerNumeroPagosAplicadosPoliza(PolizaIndividual poliza) {
        Integer numeroPagosAplicadosPoliza;
        numeroPagosAplicadosPoliza = (Integer) getSqlMapClientTemplate().queryForObject("obtenerNumeroPagosAplicadosPoliza", poliza);
        return numeroPagosAplicadosPoliza;

    }

    @Override
    public BigDecimal obtenerMontoTotalFondoAhorro(PolizaIndividual poliza) {
        Object montoTotalFondoAhorroObj;
        montoTotalFondoAhorroObj = getSqlMapClientTemplate().queryForObject(
                "obtenerMontoTotalFondoAhorro", poliza);
        // TODO - Revisar con Cesar si es correcto este manejo del caso nulo...
        BigDecimal montoTotalFondoAhorro;
        if (montoTotalFondoAhorroObj == null) {
            montoTotalFondoAhorro = BigDecimal.ZERO;
        } else {
            montoTotalFondoAhorro = new BigDecimal(montoTotalFondoAhorroObj.toString());
        }
        return montoTotalFondoAhorro;
    }

    @Override
    public Integer obtenerUltimaQuincenaPagadaPoliza(PolizaIndividual poliza) {
        Integer ultQnaPagada = (Integer) getSqlMapClientTemplate().queryForObject("obtenerUltimaQuincenaPagadaPoliza", poliza);
        //LOG.info("ultQnaPagada: " + ultQnaPagada);
        return ultQnaPagada;
    }

    private static Logger LOG;

    static {
        LOG = Logger.getLogger(DescuentoAplicadoSqlMapDao.class);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#obtenUltimoDescuentoPorPoliza(int, int)
     */
	@Override
	public DescuentosAplicados obtenUltimoDescuentoConVigenciaPorPoliza(PolizaIndividual poliza) {
		return (DescuentosAplicados)getSqlMapClientTemplate().queryForObject("buscarUltimoDescuentoConVigenciaPorPoliza", poliza);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#insertarCifrasControlProcesoAutofinanciar(mx.com.seguros.model.CifrasControlProcesoAutofinanciar)
	 */
	@Override
	public void insertarCifrasControlProcesoAutofinanciar(CifrasControlProcesoAutofinanciar cifras) {
		getSqlMapClientTemplate().insert("insertarCifrasControlProcesoAutofinanciar", cifras);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#obtenerDescuentosAplicadosPorPolizayQuincenaArchivo(mx.com.seguros.model.DescuentosAplicados)
	 */
	@Override
	public List<DescuentosAplicados> obtenerDescuentosAplicadosPorPolizayQuincenaArchivo(DescuentosAplicados params) {
		return  getSqlMapClientTemplate().queryForList("buscarDescuentosPorNumPolizaYQuincenaArchivo", params);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#existeDescuentoAplicadoPorPolizayQuincenaArchivo(mx.com.seguros.model.DescuentosAplicados)
	 */
	@Override
	public boolean existeDescuentoAplicadoPorPolizayQuincenaArchivo(DescuentosAplicados descuento) {
		
		return (Integer)getSqlMapClientTemplate().queryForObject("buscarNumeroDescuentosPorNumPolizaYQuincenaArchivo", descuento)>0;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#obtenerDescuentosAplicadosConPagoPrima(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<DescuentosAplicados> obtenerDescuentosAplicadosConPagoPrima(Integer numPoliza, Integer numConsignatario) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("numPoliza",numPoliza);
		params.put("numConsignatario",numConsignatario);
		return  getSqlMapClientTemplate().queryForList("buscarDescuentosPagoPrimaPorNumPoliza", params);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#existenCalculosDeBonoDeArchivoDeAplicacionDePagos(java.lang.Long)
	 */
	@Override
	public boolean existenCalculosDeBonoDeArchivoDeAplicacionDePagos(
			Long idArchivoAplicacionDescuentos) {
		return ((Integer)getSqlMapClientTemplate().queryForObject("existenCalculosDeBonoDeArchivoDeaplicacionDePagos",idArchivoAplicacionDescuentos))>0;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#obtenerDescuentosAplicadosDeArchivoDeAplicacion(java.lang.Long)
	 */
	@Override
	public List<DescuentosAplicados> obtenerDescuentosAplicadosDeArchivoDeAplicacion(Long idArchivoAplicacion) {
		return (List<DescuentosAplicados>)getSqlMapClientTemplate().queryForList("obtenerDescuentosAplicadosDeArchivoDeAplicacion",idArchivoAplicacion);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#eliminarDescuentoAplicado(mx.com.seguros.model.DescuentosAplicados)
	 */
	@Override
	public void eliminarDescuentoAplicado(DescuentosAplicados descuento) {
		getSqlMapClientTemplate().delete("eliminarDescuentosAplicados",descuento);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#obtenerPolizasDescuentosAplicados()
	 */
	@Override
	public List<String> obtenerPolizasDescuentosAplicados() {
		return getSqlMapClientTemplate().queryForList("obtenerPolizasDescuentosAplicados");
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IDescuetosAplicadosDao#actualizarSaldoDescuentoAplicado(mx.com.seguros.model.DescuentosAplicados)
	 */
	@Override
	public void actualizarSaldoDescuentoAplicado(DescuentosAplicados descuento) {
		getSqlMapClientTemplate().update("actualizarSaldoDescuentoAplicado",descuento);
		
	}
    
}
