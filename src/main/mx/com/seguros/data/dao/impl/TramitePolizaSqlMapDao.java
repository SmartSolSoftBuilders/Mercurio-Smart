/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.data.dao.TramitePolizaDao;
import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.TipoTramite;
import mx.com.seguros.model.TramitePoliza;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del objeto de accesoa datos para las operaciones relacionadas
 * con la bitároca de trámites de una póliza
 * @author Emigdio Hernandez
 *
 */
@SuppressWarnings("unchecked")
public class TramitePolizaSqlMapDao extends SqlMapClientDaoSupport implements TramitePolizaDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramitePolizaDAO#obtenerCatalogTipoTramite()
	 */
	
	@Override
	public List<TipoTramite> obtenerCatalogTipoTramite() {
		return (List<TipoTramite>)getSqlMapClientTemplate().queryForList("obtenerTiposTramite");
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramitePolizaDAO#obtenerTipoTramitePorId(java.lang.Integer)
	 */
	@Override
	public TipoTramite obtenerTipoTramitePorId(Integer idTipoTramite) {
		return (TipoTramite)getSqlMapClientTemplate().queryForObject("obtenerTipoTramitePorId");
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramitePolizaDAO#obtenerTramitesDePoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<TramitePoliza> obtenerTramitesDePoliza(Integer numPoliza,Integer numConsignatario) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("numPoliza", numPoliza);
		params.put("numConsignatario", numConsignatario);
		return (List<TramitePoliza>)getSqlMapClientTemplate().queryForList("obtenerTramitesPorPoliza",params);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramitePolizaDAO#insertarTramitePoliza(mx.com.seguros.model.TramitePoliza)
	 */
	@Override
	public void insertarTramitePoliza(TramitePoliza tramite) {
		getSqlMapClientTemplate().insert("insertarTramitePoliza",tramite);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.TramitePolizaDao#obtenerCatalogOficinas()
	 */
	@Override
	public List<Oficina> obtenerCatalogOficinas() {
		return (List<Oficina>)getSqlMapClientTemplate().queryForList("obtenerOficinas");
	}

	@Override
	public List<TramitePoliza> obtenerTramitesDePoliza(Date fechaInicial, Date fechaFinal, Integer idOficina) {
		Map<String,Object> params = new HashMap<String, Object>();
		
		System.out.println("Parametro en DAO FI:" + fechaInicial);
		System.out.println("Parametro en DAO FF:" + fechaFinal);
		System.out.println("Parametro en DAO OF:" + idOficina);
		
		
		params.put("fechaInicial", fechaInicial);
		params.put("fechaFinal", fechaFinal);
		params.put("idOficina", idOficina);
		return (List<TramitePoliza>)getSqlMapClientTemplate().queryForList("obtenerTramitesPorFechaOficina",params);
    }

}
