/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: RegistroArchivoPolizasDao.java
 * Fecha de creación: 10/06/2011
 * Última Modificación: 10/06/2011
 */

package mx.com.seguros.data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.model.ResumenCargaArchivoPolizas;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Implementación del DAO para el acceso a las tablas de carga del archivo de pólizas
 * @author Emigdio Hernández
 */

public class RegistroArchivoPolizasSqlMapDao extends SqlMapClientDaoSupport implements IRegistroArchivoPolizasDao {
    /*
     * 
     */
    @Override
    public void consultarRegistroArchivoPolizasPorEstatus(Integer estadoRegistro,ResultadoPaginadoDTO resultado) {

        if(resultado != null){
            if(resultado.isPrimerVez()){
                //obtener el total de registros de la consulta
                Integer totalResultados = (Integer)getSqlMapClientTemplate().queryForObject("countRegistrosCargadosPendientes", estadoRegistro);
                resultado.setTotalResultados(totalResultados);
                resultado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultado.getRegistrosPorPagina()) ));
            }

            resultado.setResultados(getSqlMapClientTemplate().queryForList("obtenerRegistrosCargadosPendientes",estadoRegistro,
                    (resultado.getPaginaActual()-1)*resultado.getRegistrosPorPagina() 
                    ,resultado.getRegistrosPorPagina() ));
        }
      

    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#consultarPorId(java.lang.Long)
     */
    @Override
    public RegistroArchivoPolizas consultarPorId(Long id) {
        return (RegistroArchivoPolizas)getSqlMapClientTemplate().queryForObject("obtenerRegistroArchivoPolizas", id);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#actualizarEstatusRegistro(java.lang.Long, java.lang.Integer)
     */
    @Override
    public void actualizarEstatusRegistro(Long registroId, Integer estatus) {
        RegistroArchivoPolizas params = new RegistroArchivoPolizas();
        params.setIdRegistroArchivoPolizas(registroId.intValue());
        params.setIdEstadoRegistroPoliza(estatus);
        getSqlMapClientTemplate().update("actualizarEstatusRegistroArchivoPolizas",params);
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#inserterResumenCargaArchivoPolizas(mx.com.seguros.model.ResumenCargaArchivoPolizas)
     */
	@Override
	public void insertarResumenCargaArchivoPolizas(
			ResumenCargaArchivoPolizas resumenCarga) {
		
		getSqlMapClientTemplate().insert("insertarResumenCargaArchivoPolizas",resumenCarga);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#consultarArchivosCargados()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ResumenCargaArchivoPolizas> consultarArchivosCargados() {
		
		return getSqlMapClientTemplate().queryForList("consultarArchivosCargados");
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#consultarRegistrosArchivoPolizaPorArchivoCargado(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<RegistroArchivoPolizas> consultarRegistrosArchivoPolizaPorArchivoCargado(
			Integer IdResumenCargaArchivoPolizas, Integer idEstadoRegistroPoliza) {
		Map params = new HashMap();
		params.put("idResumenCargaArchivoPolizas", IdResumenCargaArchivoPolizas);
		params.put("idEstadoRegistroPoliza", idEstadoRegistroPoliza);
		return getSqlMapClientTemplate().queryForList("consultarRegistrosArchivoPolizaPorArchivoCargado",params);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#insertarRegistroArchivoPolizas(mx.com.seguros.model.RegistroArchivoPolizas)
	 */
	@Override
	public void insertarRegistroArchivoPolizas(RegistroArchivoPolizas registro) {
		getSqlMapClientTemplate().insert("insertarRegistroArchivoPolizas",registro);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#consultarArchivoPolizasPorId(java.lang.Integer)
	 */
	@Override
	public ResumenCargaArchivoPolizas consultarArchivoPolizasPorId(Integer id) {
		return (ResumenCargaArchivoPolizas)getSqlMapClientTemplate().queryForObject("consultarArchivoPolizasPorId",id);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IRegistroArchivoPolizasDao#eliminarRegistroArchivoPolizas(java.lang.Integer)
	 */
	@Override
	public void eliminarRegistroArchivoPolizas(Integer idRegistro) {
		getSqlMapClientTemplate().delete("eliminarRegistroArchivoPolizas",idRegistro);
		
	}

}
