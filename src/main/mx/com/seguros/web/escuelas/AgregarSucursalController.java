/**
 * 
 */
package mx.com.seguros.web.escuelas;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.empresa.AdministracionEmpresasService;
import mx.com.seguros.model.Sucursal;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para la atención de solicitudes de agregar un nuevo valor al catálogo de sucursales
 * @author Emigdio Hernnadez
 *
 */
public class AgregarSucursalController extends SimpleFormController{
	
	/**
	 * Servicio para adminsitración de escuelas
	 */
	private AdministracionEmpresasService administracionEmpresasService = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
    public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command,BindException errors) throws Exception{
		ModelAndView mav = new ModelAndView (getFormView());
		
		AgregarSucursalColoniaCommand comando = (AgregarSucursalColoniaCommand)command;
		Sucursal sucursal = new Sucursal();
		sucursal.setNombreSucursal(comando.getNombreSucursal());
		administracionEmpresasService.agregarSucursal(sucursal);
		comando.setCveSucursal(sucursal.getCveSucursal());
        mav.addObject("cerrar",Boolean.TRUE);
        mav.addObject(getCommandName(),comando);
        mav.addAllObjects(referenceData(request, command, errors));
        return mav;
	}
		
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
		
		return null;
	}
	
	/**
	 * @param administracionEmpresasService the administracionEmpresasService to set
	 */
	public void setAdministracionEmpresasService(
			AdministracionEmpresasService administracionEmpresasService) {
		this.administracionEmpresasService = administracionEmpresasService;
	}

	

}
