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
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para la atención de solicitudes de consulta del cálculo de bono 
 * en la pantalla de cálculo de bono de pólizas.
 * @author Emigdio Hernnadez
 *
 */
public class ConsultarCatalogoEscuelasController extends SimpleFormController{
	
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
        mav.addObject(getCommandName(), command);
        
        ResultadoPaginadoDTO<Empresa> resultado = new ResultadoPaginadoDTO<Empresa>();
        resultado.setPaginaActual(1);
        if(StringUtils.isNotBlank(request.getParameter("paginaActual"))){
            resultado.setPrimerVez(false);
            resultado.setPaginaActual(NumberUtils.toInt(request.getParameter("paginaActual"), 1));
            resultado.setTotalResultados(NumberUtils.toInt(request.getParameter("totalResultados"), 1));
            resultado.setTotalPaginas(NumberUtils.toInt(request.getParameter("totalPaginas"), 1));
        }
        ConsultarCatalogoEscuelasCommand criterios = (ConsultarCatalogoEscuelasCommand)command;
        administracionEmpresasService.consultaGeneralEmpresas(criterios, resultado);
        mav.addObject("resultado", resultado);
        return mav;
	}
		
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
		Map datos = new HashMap();
		ResultadoPaginadoDTO<Empresa> resultado = new ResultadoPaginadoDTO<Empresa>();
		administracionEmpresasService.consultaGeneralEmpresas(null, resultado);
		datos.put("resultado", resultado);
        return datos;
	}


	/**
	 * @param administracionEmpresasService the administracionEmpresasService to set
	 */
	public void setAdministracionEmpresasService(
			AdministracionEmpresasService administracionEmpresasService) {
		this.administracionEmpresasService = administracionEmpresasService;
	}

	

}
