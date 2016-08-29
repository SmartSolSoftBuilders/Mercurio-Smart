/**
 * 
 */
package mx.com.seguros.web.consulta;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.consulta.IConsultaGeneralSolicitudesBusiness;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.ResultadoConsultaSolicitudDTO;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller que atiene las solicitudes para la consulta de póliza para posteriormente 
 * confirmar su baja
 * @author Emigdio HErnandez
 *
 */
public class ConsultaPolizasPorBajaController  extends SimpleFormController{

	/**
	 * Número predeterminado de registros por pagina
	 */
	private Integer registrosPorPagina;
	/**
	 * Servicio de negocio para la consulta de solicitudes
	 */
    private IConsultaGeneralSolicitudesBusiness consultaGeneralSolicitudesBusiness;
    /**
     * Utilerías de seguridad
     */
    private SeguridadUtil seguridadUtil;
    /**
     * Servicio de consulta de datos de solicitudes
     */
    private IPolizaBusiness polizaBusiness;
	
	
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        
        List<EstatusPolizaPagos> estatusPagos = polizaBusiness.consultarEstatusPolizaPagos();
        EstatusPolizaPagos estatusPagosTodos = new EstatusPolizaPagos();
        estatusPagosTodos.setIdEstatusPagosPoliza(null);
        estatusPagosTodos.setDescripcionEstatusPagosPoliza("Todos");
        estatusPagos.add(0, estatusPagosTodos);
        
        data.put("listaEstatusPolizaPagos",estatusPagos );
        
        List<Plaza> plazas = polizaBusiness.consultarPlazas();
        
        Plaza plazaTodos = new Plaza(); 
        plazaTodos.setIdPlaza(null);
        plazaTodos.setCvePlaza("Todas");
        
        plazas.add(0,plazaTodos);
        data.put("listaPlazas",plazas );
        return data;
    }
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

    	CriteriosConsultaPolizaPorBajaDTO  command = new CriteriosConsultaPolizaPorBajaDTO();
        

        return command;

    }
    
    
    @Override
    protected void initBinder(HttpServletRequest req,
        ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.format(new Date());
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }
    /**
     * Atiende las solicitudes de búsqueda desde la pantalla de consulta de polizas por baja
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command,BindException errors) throws Exception{
        
       
    	
    	
    	ModelAndView mav = new ModelAndView (getFormView());
        mav.addObject(getCommandName(), command);
        mav.addAllObjects(referenceData(request, command, errors));
        if(StringUtils.isNotBlank(request.getParameter("actualizar"))){
        	String []polizasActualizar = request.getParameterValues("polizasMarcadas");
        	if(polizasActualizar != null){
        		for(String idPoliza:polizasActualizar){
        			
        			String[] polizaConsignatario = idPoliza.split("-");
        			polizaBusiness.actualizaEstatusPolizaPago(NumberUtils.toInt(polizaConsignatario[0]),NumberUtils.toInt(polizaConsignatario[1]),
        					ConstantesGenerales.ESTATUS_PAGOS_CANCELADA_POR_CLIENTE);
        		}
        		mav.addObject("mensaje","Se actualizaron correctamente "+polizasActualizar.length + " pólizas.");
        	} 	
        	
        }else{
        	ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO> resultado = new ResultadoPaginadoDTO<ResultadoConsultaSolicitudDTO>();
            resultado.setPaginaActual(1);
            resultado.setRegistrosPorPagina(registrosPorPagina);
            if(StringUtils.isNotBlank(request.getParameter("paginaActual"))){
                resultado.setPrimerVez(false);
                resultado.setPaginaActual(NumberUtils.toInt(request.getParameter("paginaActual"), 1));
                resultado.setTotalResultados(NumberUtils.toInt(request.getParameter("totalResultados"), 1));
                resultado.setTotalPaginas(NumberUtils.toInt(request.getParameter("totalPaginas"), 1));
                resultado.setTotalPrima(NumberUtils.toDouble(request.getParameter("totalPrima"), 0));
            }
            consultaGeneralSolicitudesBusiness.consultarPolizasPorBaja((CriteriosConsultaPolizaPorBajaDTO)command, resultado);
            mav.addObject("resultado",resultado);
            
        }
        
        
        
        return mav;
    }
	/**
	 * @param registrosPorPagina the registrosPorPagina to set
	 */
	public void setRegistrosPorPagina(Integer registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}
	/**
	 * @param consultaGeneralSolicitudesBusiness the consultaGeneralSolicitudesBusiness to set
	 */
	public void setConsultaGeneralSolicitudesBusiness(
			IConsultaGeneralSolicitudesBusiness consultaGeneralSolicitudesBusiness) {
		this.consultaGeneralSolicitudesBusiness = consultaGeneralSolicitudesBusiness;
	}
	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}
	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}
}
