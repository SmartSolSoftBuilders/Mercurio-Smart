/*
 * EmpresaSqlMapDao.java
 *
 * Created on 29 de agosto de 2007, 03:01 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.data.dao;

import java.util.List;

import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;
import mx.com.seguros.model.Colonia;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.Sucursal;
import mx.com.seguros.model.TipoEmpresa;
import mx.com.seguros.model.TurnoEmpresa;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author QTX
 */
@SuppressWarnings("unchecked")
public class EmpresaSqlMapDao extends SqlMapClientDaoSupport implements IEmpresaDao{
    
    /** Creates a new instance of EmpresaSqlMapDao */
    public EmpresaSqlMapDao() {
    }

    public void insertarEmpresa(Empresa empresa) {
    }
    /*
     * (non-Javadoc)
     * @see mx.com.seguros.data.dao.IEmpresaDao#consultarPlazas()
     */
	@Override
	public List<Plaza> consultarPlazas() {
		return (List<Plaza>)getSqlMapClientTemplate().queryForList("buscarPlazas");
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#consultarListadoEmpresas(mx.com.seguros.dto.CriteriosConsultaEscuelasDTO, mx.com.seguros.utils.ResultadoPaginadoDTO)
	 */
	
	@Override
	public void consultarListadoEmpresas(CriteriosConsultaEscuelasDTO criterios,ResultadoPaginadoDTO<Empresa> resultadoPaginado) {
		
		String nombreEscuelaOriginal = null;
	        
        //se agregan los "%" para que realice correctamente la búsqueda por nombre
    	if(criterios != null && criterios.getNombreEscuela() != null){
    		nombreEscuelaOriginal = criterios.getNombreEscuela() ;
    		criterios.setNombreEscuela("%"  + nombreEscuelaOriginal +"%");
        }
    	if(resultadoPaginado != null){
            if(resultadoPaginado.isPrimerVez()){
                //obtener el total de registros de la consulta
                Integer totalResultados = (Integer)getSqlMapClientTemplate().queryForObject("selectCountConsultaEmpresas", criterios);
                resultadoPaginado.setTotalResultados(totalResultados);
                resultadoPaginado.setTotalPaginas((int)Math.ceil( ((double)totalResultados)/((double)resultadoPaginado.getRegistrosPorPagina()) ));
                resultadoPaginado.setPaginaActual(1);
            }
            resultadoPaginado.setResultados(getSqlMapClientTemplate().queryForList("selectConsultaEmpresas",criterios,
                    (resultadoPaginado.getPaginaActual()-1)*resultadoPaginado.getRegistrosPorPagina()
                    ,resultadoPaginado.getRegistrosPorPagina() ));
        }
    	 if(criterios != null  ){
    		 criterios.setNombreEscuela(nombreEscuelaOriginal);
         }
		
		
	}	
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#consultarTiposEmpresa()
	 */
	@Override
	public List<TipoEmpresa> consultarTiposEmpresa() {
		return (List<TipoEmpresa>) getSqlMapClientTemplate().queryForList("selectTiposEmpresa");
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#consultarTurnosEmpresa()
	 */
	@Override
	public List<TurnoEmpresa> consultarTurnosEmpresa() {
		return (List<TurnoEmpresa>) getSqlMapClientTemplate().queryForList("obtenerTurnosEmpresa");
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#consultarEmpresaPorClave(java.lang.Integer)
	 */
	@Override
	public Empresa consultarEmpresaPorClave(Integer claveEmpresa) {
		return (Empresa)getSqlMapClientTemplate().queryForObject("selectEmpresaPorCveEmpresa",claveEmpresa);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#agregarEmpresa(mx.com.seguros.model.Empresa)
	 */
	@Override
	public void agregarEmpresa(Empresa empresa) {
		getSqlMapClientTemplate().insert("agregarEmpresa", empresa);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#actualizarEmpresa(mx.com.seguros.model.Empresa)
	 */
	@Override
	public void actualizarEmpresa(Empresa empresa) {
		getSqlMapClientTemplate().update("actualizarEmpresa",empresa);		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#agregarSucursal(mx.com.seguros.model.Sucursal)
	 */
	@Override
	public void agregarSucursal(Sucursal sucursal) {
		getSqlMapClientTemplate().insert("agregarSucursal", sucursal);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.data.dao.IEmpresaDao#agregarColonia(mx.com.seguros.model.Colonia)
	 */
	@Override
	public void agregarColonia(Colonia colonia) {
		getSqlMapClientTemplate().insert("agregarColonia", colonia);
		
	}
    
}
