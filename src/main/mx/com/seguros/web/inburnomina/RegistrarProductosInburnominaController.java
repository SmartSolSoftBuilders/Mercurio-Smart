/*
 * Smart Solutions 2014
 */
package mx.com.seguros.web.inburnomina;

import java.util.Date;

import mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 * Controller para el registro o modificación de productos de inburnomina integral
 * @author Emigdio Hernandez
 *
 */
public class RegistrarProductosInburnominaController extends SimpleFormController {

	private SeguridadUtil seguridadUtil;
	/**
	 * Servicio para la adminstración de los productos de inburnomina
	 */
	private AdministrarProductosInburnominaService administrarProductosInburnominaService = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		ModelAndView mav = new ModelAndView(getSuccessView());
		
		RegistrarProductosInburnominaCommand comando = (RegistrarProductosInburnominaCommand)command;
		ProductosInburnomina productos = new ProductosInburnomina();
		
		productos.setNumPoliza(NumberUtils.toInt(comando.getNumPoliza()));
		productos.setNumConsignatario(NumberUtils.toInt(comando.getNumConsignatario()));
		productos.setUsuario(seguridadUtil.getUsuario().getUsername());
		productos.setFechaUltimaModif(new Date());
		
		productos.setIndRcLicencia(comando.getIndRcLicencia());
		if(productos.getIndRcLicencia()){
			productos.setNumLicencia(comando.getNumLicencia());
			productos.setPrimaMensualLicencia(NumberUtils.toDouble(comando.getPrimaMensualLicencia()));
			productos.setNumPolizaRcLicencia(NumberUtils.toInt(comando.getNumPolizaRcLicencia()));
			productos.setNumConsignatarioRcLicencia(NumberUtils.toInt(comando.getNumConsignatarioRcLicencia()));
			productos.setFechaVigenciaRcLicencia(comando.getFechaVigenciaRcLicencia());
		}else{
			productos.setNumLicencia("");
			productos.setPrimaMensualLicencia(0.0);
			productos.setNumPolizaRcLicencia(null);
			productos.setNumConsignatarioRcLicencia(null);
			productos.setFechaVigenciaRcLicencia(null);
		}
		
		productos.setIndInburmedic(comando.getIndInburmedic());
		if(productos.getIndInburmedic()){
			productos.setPrimaMensualInburmedic(NumberUtils.toDouble(comando.getPrimaMensualInburmedic()));
			
			productos.setNumPolizaInburmedic(NumberUtils.toInt(comando.getNumPolizaInburmedic()));
			productos.setNumConsignatarioInburmedic(NumberUtils.toInt(comando.getNumConsignatarioInburmedic()));
			productos.setFechaVigenciaInburmedic(comando.getFechaVigenciaInburmedic());
			
		}else{
			productos.setPrimaMensualInburmedic(0.0);
			productos.setNumPolizaInburmedic(null);
			productos.setNumConsignatarioInburmedic(null);
			productos.setFechaVigenciaInburmedic(null);
		}
		
		productos.setIndSeguCancer(comando.getIndSeguCancer());
		if(productos.getIndSeguCancer()){
			productos.setPrimaMensualSeguCancer(NumberUtils.toDouble(comando.getPrimaMensualSeguCancer()));
			
			productos.setNumPolizaSeguCancer(NumberUtils.toInt(comando.getNumPolizaSeguCancer()));
			productos.setNumConsignatarioSeguCancer(NumberUtils.toInt(comando.getNumConsignatarioSeguCancer()));
			productos.setFechaVigenciaSeguCancer(comando.getFechaVigenciaSeguCancer());
			
		}else{
			productos.setPrimaMensualSeguCancer(0.0);
			productos.setNumPolizaSeguCancer(null);
			productos.setNumConsignatarioSeguCancer(null);
			productos.setFechaVigenciaSeguCancer(null);
		}
		
		administrarProductosInburnominaService.registrarProductosInburnomina(productos);
		mav.addObject("registroProductosInburnomina",true);
		mav.addObject(getCommandName(),command);
		return mav;
		
	}
	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}
	/**
	 * @param administrarProductosInburnominaService the administrarProductosInburnominaService to set
	 */
	public void setAdministrarProductosInburnominaService(
			AdministrarProductosInburnominaService administrarProductosInburnominaService) {
		this.administrarProductosInburnominaService = administrarProductosInburnominaService;
	}
}
