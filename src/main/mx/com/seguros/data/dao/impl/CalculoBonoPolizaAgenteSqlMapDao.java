/**
 * 
 */
package mx.com.seguros.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao;
import mx.com.seguros.dto.BonoPolizaPorCalcularDTO;
import mx.com.seguros.dto.ResultadoCalculoBonoPolizaAgenteDTO;
import mx.com.seguros.model.CalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.model.ResumenProcesoCalculoBono;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del DAO para las operaciones sobre la tabla de cálculo de bonos de pólizas
 * @author Emigdio Hernandez
 *
 */
public class CalculoBonoPolizaAgenteSqlMapDao  extends SqlMapClientDaoSupport implements ICalculoBonoPolizaAgenteDao {

	/* (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#consultarBonosPendientesPorCalcular(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<BonoPolizaPorCalcularDTO> consultarBonosPendientesPorCalcular(Integer numPoliza, Integer numConsignatario, Integer idPlaza) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("numPoliza", numPoliza);
		params.put("numConsignatario", numConsignatario);
		params.put("idPlaza",idPlaza);
		return getSqlMapClientTemplate().queryForList("bonosPorCalcular",params);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#insertarResumenProcesoCalculoBono(mx.com.seguros.model.ResumenProcesoCalculoBono)
	 */
	@Override
	public void insertarResumenProcesoCalculoBono(ResumenProcesoCalculoBono resumenProceso) {
		getSqlMapClientTemplate().insert("insertarResumenProcesoCalculoBono",resumenProceso);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#insertarResumenCalculoBonoPolizaAgente(mx.com.seguros.model.ResumenCalculoBonoPolizaAgente)
	 */
	@Override
	public void insertarResumenCalculoBonoPolizaAgente(ResumenCalculoBonoPolizaAgente resumenCalculo) {
		getSqlMapClientTemplate().insert("insertarResumenCalculoBonoPolizaAgente",resumenCalculo);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#insertarCalculoBonoPolizaAgente(mx.com.seguros.model.CalculoBonoPolizaAgente)
	 */
	@Override
	public void insertarCalculoBonoPolizaAgente(CalculoBonoPolizaAgente calculo) {
		getSqlMapClientTemplate().insert("insertarCalculoBonoPolizaAgente",calculo);		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#consultarResumenProcesosCalculoBono()
	 */
	@Override
	public List<ResumenProcesoCalculoBono> consultarResumenProcesosCalculoBono() {
		return getSqlMapClientTemplate().queryForList("consultarResumenProcesosCalculoBono");
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#consultarResumenCalculoBonoPolizaAgentePorIdResumenCalculo(java.lang.Integer)
	 */
	@Override
	public List<ResumenCalculoBonoPolizaAgente> consultarResumenCalculoBonoPolizaAgentePorIdResumenCalculo(Integer idResumenProcesoCalculoBono) {
		return getSqlMapClientTemplate().queryForList("consultarResumenCalculoBonoPolizaAgentePorIdResumenCalculo",idResumenProcesoCalculoBono);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#consultarDetalleCalculoBonoPolizaAgentePorIdResumenProcesoCalculoBono(java.lang.Integer)
	 */
	@Override
	public List<ResultadoCalculoBonoPolizaAgenteDTO> consultarDetalleCalculoBonoPolizaAgentePorIdResumenProcesoCalculoBono(Integer idResumenProcesoCalculoBono) {
		return getSqlMapClientTemplate().queryForList("consultarDetalleCalculoBonoPolizaAgentePorIdResumenProcesoCalculoBono",idResumenProcesoCalculoBono);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.ICalculoBonoPolizaAgenteDao#consultarResumenProcesoCalculoBonoPorId(java.lang.Integer)
	 */
	@Override
	public ResumenProcesoCalculoBono consultarResumenProcesoCalculoBonoPorId(Integer idResumenProcesoCalculoBono) {
		return  (ResumenProcesoCalculoBono)getSqlMapClientTemplate().queryForObject("consultarResumenProcesosCalculoBonoPorId",idResumenProcesoCalculoBono);
	}

}
