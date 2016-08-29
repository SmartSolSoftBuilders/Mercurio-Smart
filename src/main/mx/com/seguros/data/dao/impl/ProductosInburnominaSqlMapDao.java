/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.data.dao.IProductosInburnominaDao;
import mx.com.seguros.model.HistoricoProductosInburnomina;
import mx.com.seguros.model.ProductosInburnomina;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del objeto de acceso a datos para el registro y modificación
 * de registros de productos de inburnomina
 * @author Emigdio Hernanadez
 *
 */
@SuppressWarnings("unchecked")
public class ProductosInburnominaSqlMapDao extends SqlMapClientDaoSupport implements IProductosInburnominaDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IProductosInburnominaDao#insertarProductosInburnomina(mx.com.seguros.model.ProductosInburnomina)
	 */
	@Override
	public void insertarProductosInburnomina(ProductosInburnomina datos) {
		getSqlMapClientTemplate().insert("guardarProductosInburnomina",datos);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IProductosInburnominaDao#actualizarProductosInburnomina(mx.com.seguros.model.ProductosInburnomina)
	 */
	@Override
	public void actualizarProductosInburnomina(ProductosInburnomina datos) {
		getSqlMapClientTemplate().insert("actualizarProductosInburnomina",datos);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IProductosInburnominaDao#insertarHistoricoProductosInburnomina(mx.com.seguros.model.HistoricoProductosInburnomina)
	 */
	@Override
	public Integer insertarHistoricoProductosInburnomina(HistoricoProductosInburnomina historicoDatos) {
		getSqlMapClientTemplate().insert("insertarHistoricoProductosInburnomina",historicoDatos);
		return historicoDatos.getIdHistoricoProductosInburnomina();
	}
	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IProductosInburnominaDao#consultarProductosInburnominaDePoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public ProductosInburnomina consultarProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario) {
		List<ProductosInburnomina> resultados = getSqlMapClientTemplate().queryForList("consultaProductosInburnominaPorPoliza",
				crearPolizaParams(numPoliza, numConsignatario));
		if(resultados != null && resultados.size()>0){
			return resultados.get(0);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IProductosInburnominaDao#eixsteProductosInburnominaDePoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public boolean eixsteProductosInburnominaDePoliza(Integer numPoliza,Integer numConsignatario) {
		Integer count = (Integer)getSqlMapClientTemplate().queryForObject("countProductosInburnominaPorPoliza", crearPolizaParams(numPoliza, numConsignatario));
		if(count != null && count.intValue() > 0){
			return true;
		}
		return false;
	}
	/**
	 * Crea un mapara de parametros con los datos de numero de poliza y consignatario
	 * @param numPoliza
	 * @param numConsignatario
	 * @return
	 */
	private Map<String,Object> crearPolizaParams(Integer numPoliza,	Integer numConsignatario) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("numPoliza", numPoliza);
		params.put("numConsignatario", numConsignatario);
		return params;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IProductosInburnominaDao#consultarHistoricoProductosInburnominaPorPoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<HistoricoProductosInburnomina> consultarHistoricoProductosInburnominaPorPoliza(Integer numPoliza, Integer numConsignatario) {
		return getSqlMapClientTemplate().queryForList("consultaHistoricoProductosInburnominaPorPoliza",crearPolizaParams(numPoliza, numConsignatario));
	}

}
