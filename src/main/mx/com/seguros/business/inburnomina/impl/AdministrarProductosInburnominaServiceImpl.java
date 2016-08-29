/**
 * 
 */
package mx.com.seguros.business.inburnomina.impl;

import java.util.Date;
import java.util.List;

import mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.data.dao.IProductosInburnominaDao;
import mx.com.seguros.model.HistoricoProductosInburnomina;
import mx.com.seguros.model.HistoricoTarifa;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.model.Solicitud;

/**
 * Implementación del servicio de negocio para la administración de los datos
 * de los productos inburnómina adicionales a una poliza de seguro de vida
 * @author Emigdio Henrnadez
 *
 */
public class AdministrarProductosInburnominaServiceImpl implements AdministrarProductosInburnominaService {

	/**
	 * DAO para las operaciones de los productos de inburnomina integral
	 */
	private IProductosInburnominaDao productosInburnominaDao = null;
	/**
	 * Servicio para consultar datos de póliza
	 */
	private IPolizaBusiness polizaBusiness = null;
	/* (non-Javadoc)
	 * @see mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService#registrarProductosInburnomina(mx.com.seguros.model.ProductosInburnomina)
	 */
	@Override
	public void registrarProductosInburnomina(ProductosInburnomina datos) {
		ProductosInburnomina datosAnteriores = productosInburnominaDao.consultarProductosInburnominaDePoliza(datos.getNumPoliza(), datos.getNumConsignatario());
		if(datosAnteriores == null){
			//insertar
			productosInburnominaDao.insertarProductosInburnomina(datos);
		}else{
			//guardar historico
			productosInburnominaDao.insertarHistoricoProductosInburnomina(crearHistoricoProductosInburnomina(datosAnteriores));
			datosAnteriores.setUsuario(datos.getUsuario());
			datosAnteriores.setFechaUltimaModif(new Date());
			productosInburnominaDao.actualizarProductosInburnomina(datos);
		}
		//Modificar la tarifa total de la solicitud y guardar histórico
		polizaBusiness.actualizarTarifaTotalPoliza(datos.getNumPoliza(), datos.getNumConsignatario(), datos.getUsuario());
	}
	/* (non-Javadoc)
	 * @see mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService#obtenerProductosInburnominaDePoliza(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public ProductosInburnomina obtenerProductosInburnominaDePoliza(Integer numPoliza, Integer numConsignatario) {
		return productosInburnominaDao.consultarProductosInburnominaDePoliza(numPoliza, numConsignatario);
	}

	/* (non-Javadoc)
	 * @see mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService#obtenerHistoricoDeProductosInburnomina(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<HistoricoProductosInburnomina> obtenerHistoricoDeProductosInburnomina(Integer numPoliza, Integer numConsignatario) {
		return productosInburnominaDao.consultarHistoricoProductosInburnominaPorPoliza(numPoliza, numConsignatario);
	}
	/**
	 * Tranforma un registro de productos inburnomina en uno de historico
	 * @param datos
	 * @return
	 */
	private HistoricoProductosInburnomina crearHistoricoProductosInburnomina(ProductosInburnomina datos) {
		HistoricoProductosInburnomina hist = new HistoricoProductosInburnomina();
		hist.setUsuarioModificacion(datos.getUsuario());
		hist.setFechaModificacion(new Date());
		hist.setIndInburmedic(datos.getIndInburmedic());
		hist.setIndRcLicencia(datos.getIndRcLicencia());
		hist.setIndSeguCancer(datos.getIndSeguCancer());
		hist.setNumConsignatario(datos.getNumConsignatario());
		hist.setNumLicencia(datos.getNumLicencia());
		hist.setNumPoliza(datos.getNumPoliza());
		hist.setPrimaMensualInburmedic(datos.getPrimaMensualInburmedic());
		hist.setPrimaMensualLicencia(datos.getPrimaMensualLicencia());
		hist.setPrimaMensualSeguCancer(datos.getPrimaMensualSeguCancer());
		return hist;
	}


	/**
	 * @param productosInburnominaDao the productosInburnominaDao to set
	 */
	public void setProductosInburnominaDao(IProductosInburnominaDao productosInburnominaDao) {
		this.productosInburnominaDao = productosInburnominaDao;
	}
	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}

}
