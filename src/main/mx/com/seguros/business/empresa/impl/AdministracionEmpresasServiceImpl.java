/**
 * 
 */
package mx.com.seguros.business.empresa.impl;

import java.util.List;

import mx.com.seguros.business.empresa.AdministracionEmpresasService;
import mx.com.seguros.data.dao.EmpresaSqlMapDao;
import mx.com.seguros.data.dao.IEmpresaDao;
import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;
import mx.com.seguros.model.Colonia;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.Sucursal;
import mx.com.seguros.model.TipoEmpresa;
import mx.com.seguros.model.TurnoEmpresa;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

/**
 * Implementación del servicio de negocio para la adminstración
 * de empresas dentro del sistema.
 * @author Emigdio Hernandez
 *
 */
public class AdministracionEmpresasServiceImpl implements AdministracionEmpresasService {
	/**
	 * DAO para consultar e insertar empresas
	 */
	private IEmpresaDao empresaDao = null;

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#consultaGeneralEmpresas(mx.com.seguros.dto.CriteriosConsultaEscuelasDTO, mx.com.seguros.utils.ResultadoPaginadoDTO)
	 */
	@Override
	public void consultaGeneralEmpresas(CriteriosConsultaEscuelasDTO criterios, ResultadoPaginadoDTO<Empresa> resultadoPaginado) {
		empresaDao.consultarListadoEmpresas(criterios, resultadoPaginado);
	}

	/**
	 * @param empresaDao the empresaDao to set
	 */
	public void setEmpresaDao(IEmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#consultarTiposEmpresa()
	 */
	@Override
	public List<TipoEmpresa> consultarTiposEmpresa() {
		return empresaDao.consultarTiposEmpresa();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#consultarTurnosEmpresa()
	 */
	@Override
	public List<TurnoEmpresa> consultarTurnosEmpresa() {
		return empresaDao.consultarTurnosEmpresa();
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#guardarEscuela(mx.com.seguros.model.Empresa)
	 */
	@Override
	public void guardarEscuela(Empresa empresa) {
		Empresa empresaOriginal = null;
		if(empresa != null){
			//revisar si la empresa a actualizar realmente existe, si no, reasignar su PK
			if(empresa.getCveEmpresa() != null){
				empresaOriginal = empresaDao.consultarEmpresaPorClave(empresa.getCveEmpresa());
				if(empresaOriginal == null){
					empresa.setCveEmpresa(null);
				}
			}
			
			if(empresa.getCveEmpresa() == null || empresa.getCveEmpresa() <= 0){
				//empresa nueva
				empresaDao.agregarEmpresa(empresa);
			}else{
				//actualizar empresa
				empresaDao.actualizarEmpresa(empresa);
			}
			
			
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#consultaEscuelaPorClave(java.lang.Integer)
	 */
	@Override
	public Empresa consultaEscuelaPorClave(Integer cveEmpresa) {
		return empresaDao.consultarEmpresaPorClave(cveEmpresa);
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#agregarSucursal(mx.com.seguros.model.Sucursal)
	 */
	@Override
	public void agregarSucursal(Sucursal sucursal) {
		empresaDao.agregarSucursal(sucursal);
		
	}
	/*
	 * (non-Javadoc)
	 * @see mx.com.seguros.business.empresa.AdministracionEmpresasService#agregarColonia(mx.com.seguros.model.Colonia)
	 */
	@Override
	public void agregarColonia(Colonia colonia) {
		empresaDao.agregarColonia(colonia);		
	}

}
