/**
 * 
 */
package mx.com.seguros.web.escuelas;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.empresa.AdministracionEmpresasService;
import mx.com.seguros.dto.CriteriosConsultaEscuelasDTO;
import mx.com.seguros.dto.CriteriosConsultaSolicitudesDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.TipoEmpresa;
import mx.com.seguros.model.TurnoEmpresa;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para la atención de solicitudes de edición de datos para una escuela nueva
 * o para la modificación de una escuela existente
 * @author Emigdio Hernnadez
 *
 */
public class AgregarEscuelaController extends SimpleFormController{
	
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
		
        AgregarEscuelaCommand escuelaCommand = (AgregarEscuelaCommand)command;
        //llenar un objeto del tipo Empresa
        Empresa empresa = new Empresa();
        
        empresa.setCveGrupoAsegurado(escuelaCommand.getCveGrupoAsegurado());
        empresa.setCveSucursal(escuelaCommand.getCveSucursal());
        empresa.setCveColonia(escuelaCommand.getCveColonia());
        empresa.setTipoEmpresa(new TipoEmpresa());
        empresa.getTipoEmpresa().setTipoEmpresa(escuelaCommand.getTipoEmpresa());
        empresa.setCveTurno(escuelaCommand.getCveTurno());
        empresa.setNombreEmpresa(escuelaCommand.getNombreEscuela());
        empresa.setCveEmpresa(escuelaCommand.getCveEmpresa());
        administracionEmpresasService.guardarEscuela(empresa);
        
        mav.addObject("error","Datos de la escuela guardadods exitósamente");
        
        mav.addObject(getCommandName(), new AgregarEscuelaCommand());
        
        mav.addAllObjects(referenceData(request, command, errors));
        return mav;
	}
		
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
		
		//catálogos de tipo de escuela
		Map datos = new HashMap();
		
		datos.put("tiposEscuela",administracionEmpresasService.consultarTiposEmpresa());
		datos.put("turnosEscuela", administracionEmpresasService.consultarTurnosEmpresa());
		return datos;
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
		AgregarEscuelaCommand command = new AgregarEscuelaCommand();
		
		if(StringUtils.isNotBlank(request.getParameter("cveEmpresa"))){
			Integer clave = NumberUtils.toInt(request.getParameter("cveEmpresa"),0);
			Empresa empresa = administracionEmpresasService.consultaEscuelaPorClave(clave);
			if(empresa != null){
				//llenar los datos del command con la empresa a editar
				command.setCveGrupoAsegurado(empresa.getCveGrupoAsegurado());
				command.setDescripcionGrupoAsegurado(empresa.getGrupoAsegurado().getNombreGrupoAsegurado());
				command.setCveSucursal(empresa.getCveSucursal());
				command.setDescripcionSucursal(empresa.getSucursal().getNombreSucursal());
				command.setCveColonia(empresa.getCveColonia());
				command.setDescripcionColonia(empresa.getColonia().getAsentamiento());
				command.setCveTurno(empresa.getCveTurno());
				command.setTipoEmpresa(empresa.getTipoEmpresa().getTipoEmpresa());
				command.setNombreEscuela(empresa.getNombreEmpresa());
				command.setCveEmpresa(empresa.getCveEmpresa());
			}
		}
		
    	return command;

    }
	/**
	 * @param administracionEmpresasService the administracionEmpresasService to set
	 */
	public void setAdministracionEmpresasService(
			AdministracionEmpresasService administracionEmpresasService) {
		this.administracionEmpresasService = administracionEmpresasService;
	}

	

}
