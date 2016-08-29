package mx.com.seguros.web.pagos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.pagos.PagosBusiness;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.CriteriosEjecucionAutofinanciamientoDTO;
import mx.com.seguros.model.CifrasControlProcesoAutofinanciar;
import mx.com.seguros.model.EstatusPolizaPagos;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controler para antender las solicitudes del usuario para ejecutar el autofinanciamiento
 * @author Emigdio
 *
 */
public class EjecutarAutofinanciamientoController extends SimpleFormController{ 

	/**
     * Servicio de consulta de datos de solicitudes
     */
    private IPolizaBusiness polizaBusiness;
    
    private SeguridadUtil seguridadUtil;
    
    private PagosBusiness pagosBusiness;
	
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        
        List<Plaza> plazas = polizaBusiness.consultarPlazas();
        
        /*JLVO: Se quita la Plaza Todos*/
        /*
        Plaza plazaTodos = new Plaza(); 
        plazaTodos.setIdPlaza(null);
        plazaTodos.setCvePlaza("Todas");        
        plazas.add(0,plazaTodos);
        */
        
        data.put("listaPlazas",plazas);
        
        
        /*JLVO: Para manejar una consulta más sencilla se agrega la opción a estatus Todos*/
      
        List<EstatusPolizaPagos> estatusPolizaPagos = polizaBusiness.consultarEstatusPolizaPagos();
        
         
        
        EstatusPolizaPagos estatusPolizaPagosTodos = new EstatusPolizaPagos(); 
        estatusPolizaPagosTodos.setIdEstatusPagosPoliza(null);
        estatusPolizaPagosTodos.setDescripcionEstatusPagosPoliza("TODOS");        
        estatusPolizaPagos.add(0,estatusPolizaPagosTodos);
                
        
        data.put("listaEstatusPolizaPagos", estatusPolizaPagos);
        
        
        return data;
    }
	
	@Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

		CriteriosEjecucionAutofinanciamientoDTO  command = new CriteriosEjecucionAutofinanciamientoDTO();
        

        return command;

    }
    
	@Override
    public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command,BindException errors) throws Exception{
		ModelAndView mav = new ModelAndView (getFormView());
		
		CriteriosEjecucionAutofinanciamientoDTO criteriosEjecucionAutofinanciamientoDTO = (CriteriosEjecucionAutofinanciamientoDTO)command;
		
		CifrasControlProcesoAutofinanciar cifrasControl = pagosBusiness.autoFinanciarPolizasAutomaticamente(criteriosEjecucionAutofinanciamientoDTO.getIdPlaza(), criteriosEjecucionAutofinanciamientoDTO.getIdEstatusPolizaPagos());
		mav.addObject("cifrasControl", cifrasControl);
		mav.addObject("criteriosBusqueda", criteriosEjecucionAutofinanciamientoDTO);
		mav.addAllObjects(this.referenceData(request, command, errors));
		return mav;
	}

	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}

	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

	/**
	 * @param pagoBusiness the pagoBusiness to set
	 */
	public void setPagosBusiness(PagosBusiness pagoBusiness) {
		this.pagosBusiness = pagoBusiness;
	}
}
