/**
 * 
 */
package mx.com.seguros.web.bonos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.com.seguros.business.comisiones.CalculoBonoPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Plaza;
import mx.com.seguros.model.ResumenCalculoBonoPolizaAgente;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para la atención de solicitudes de cálculo de bono 
 * en la pantalla de cálculo de bono de pólizas.
 * Se realiza primero un cálculo sin guardarlo en BD y posteriormente
 * se confirma ese cálculo para guardarlo en BD
 * @author Emigdio Hernnadez
 *
 */
public class CalcularBonoPolizaAgenteController extends SimpleFormController{
	/**
	 * Servicio para la consulta y almacenamiento del bono
	 */
	private CalculoBonoPolizaBusiness calculoBonoPolizaBusiness = null;
	/**
	 * Consulta de catálogos
	 */
	private ISolicitudBusiness solicitudBusiness = null;
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	public ModelAndView onSubmit(Object command) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		CalcularBonoPolizaAgenteCommand calcularCommand = (CalcularBonoPolizaAgenteCommand)command;
		Integer idPlaza = null;
		if(calcularCommand.getIdPlaza() != null && calcularCommand.getIdPlaza() > 0){
			idPlaza = calcularCommand.getIdPlaza();
		}
		if(calcularCommand.isGuardar()){
			SeguridadUtil utl = new SeguridadUtil();
			calculoBonoPolizaBusiness.registrarCalculoBonoFinal(null, null,utl.getUsuario().getUsername(), idPlaza);
			mv.addObject("error", "Proceso de Cálculo de Bono completado y registrado con éxito");
			
		}else{
			List<ResumenCalculoBonoPolizaAgente> listaResumenCalculo = calculoBonoPolizaBusiness.obtenerCalculoDeBonosAFechaActual(null, null, idPlaza);
			mv.addObject("listaResumenCalculo", listaResumenCalculo);
			
		}
		mv.addObject("calcularBonoPolizaAgenteCommand",command);
		mv.addAllObjects(referenceData(null, calcularCommand, null));
		return mv;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest, java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
    protected Map referenceData(HttpServletRequest request,Object command, Errors errors) throws java.lang.Exception{
        Map data = new HashMap();
        //consultar el catálog de plazas
        List<Plaza> opciones = solicitudBusiness.consultarPlazas();
        Plaza opcionTodas = new Plaza();
        opcionTodas.setIdPlaza(-1);
        opcionTodas.setNombrePlaza("TODAS");
        opciones.add(0, opcionTodas);
        data.put("plazas",opciones);
        return data;
	}

	/**
	 * @return the calculoBonoPolizaBusiness
	 */
	public CalculoBonoPolizaBusiness getCalculoBonoPolizaBusiness() {
		return calculoBonoPolizaBusiness;
	}

	/**
	 * @param calculoBonoPolizaBusiness the calculoBonoPolizaBusiness to set
	 */
	public void setCalculoBonoPolizaBusiness(
			CalculoBonoPolizaBusiness calculoBonoPolizaBusiness) {
		this.calculoBonoPolizaBusiness = calculoBonoPolizaBusiness;
	}

	/**
	 * @param solicitudBusiness the solicitudBusiness to set
	 */
	public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
		this.solicitudBusiness = solicitudBusiness;
	}


}
