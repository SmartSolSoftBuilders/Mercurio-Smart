package mx.com.seguros.web.tramitesPoliza;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.dto.CriteriosConsultaPolizaPorBajaDTO;
import mx.com.seguros.dto.CriteriosConsultaReporteTramitesDTO;
import mx.com.seguros.model.Oficina;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.TramitePoliza;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;
import mx.com.seguros.web.seguridad.util.Usuario;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller que atiende las solicitudes de búsqueda de trámites de póliza para reporte
 * @author JLVO
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})

public class ConsultaReporteTramitesController extends SimpleFormController{
	
	private IPolizaBusiness polizaBusiness;
	private SeguridadUtil seguridadUtil;
	
	 /* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, Object command,BindException errors) throws Exception {
		
		ModelAndView mv = new ModelAndView(getFormView());
		
		
		CriteriosConsultaReporteTramitesDTO tramiteCommand = (CriteriosConsultaReporteTramitesDTO)command;
		
		System.out.println("consultando los reportes");
		
		System.out.println("Fecha Inicial:" + tramiteCommand.getFechaInicial());
		
		System.out.println("Fecha Final:" + tramiteCommand.getFechaFinal());
		
		System.out.println("Oficina:" + tramiteCommand.getOficina());
		
	    List <TramitePoliza> resultado = polizaBusiness.obtenerTramitesDePoliza(tramiteCommand.getFechaInicial(), tramiteCommand.getFechaFinal(), tramiteCommand.getOficina());
		
	    
	    
	    System.out.println("Resultado Count:" + resultado.size() );
	    
	    
        //Verificar si se desea exportar en Excel La consulta
        
        if(request.getParameter("formato") != null && "xls".equals(request.getParameter("formato"))){
        	
        	System.out.println("a excel");
        	mv.setViewName("/tramitesPoliza/consultaTramiteExcel");
        	response.setContentType("application/ms-excel");
            response.setHeader("Content-Disposition",
            		"attachment; filename=" +  "consultaGeneral.xls");
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("pragma","no-cache");
        
        
        }
	    
	    
	    
		mv.addObject("resultado", resultado);
		mv.addObject(getCommandName(), command);        
		mv.addAllObjects(referenceData(request, command, errors));
		return mv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	
	
	@Override
   public Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
       Map data = new HashMap();
       
       
       List<Oficina> listaOficinas = polizaBusiness.obtenerCatalogOficinas();
       
       Oficina oficinaTodos = new Oficina(); 
       oficinaTodos.setIdOficina(null);
       oficinaTodos.setNombre("Todas");    
       
       listaOficinas.add(0, oficinaTodos);
       
	   data.put("listaOficinas", listaOficinas);
       return data;
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public Object formBackingObject(HttpServletRequest request)throws Exception{
		
		CriteriosConsultaReporteTramitesDTO  command = new CriteriosConsultaReporteTramitesDTO();
        

        return command;		
	
	}
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	 @Override
	 protected void initBinder(HttpServletRequest req,
	        ServletRequestDataBinder binder) throws Exception {
		    
		    System.out.println("ingresando a Binder");
		 
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        //dateFormat.format(new Date());
	        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
	        binder.registerCustomEditor(Date.class, dateEditor);
	        
	        
	        System.out.println("saliendo de Binder");
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
	
	
}
