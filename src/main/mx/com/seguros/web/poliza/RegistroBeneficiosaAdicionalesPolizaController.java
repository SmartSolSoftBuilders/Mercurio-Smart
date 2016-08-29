/*
 * RegistroBeneficiosaAdicionalesPolizaController.java
 *
 * Created on 01/08/2011, 07:11 PM
 *
 */
package mx.com.seguros.web.poliza;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.model.BeneficioAdicional;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.web.servlet.view.RedirectView;
/**
 * Controller que atiende la solicitudes de la capa de vista
 * para el proceso de registro de pólizas adicionales
 * 
 * @version 1.0
 * @author Emigdio Hernández
 *
 */
public class RegistroBeneficiosaAdicionalesPolizaController extends AbstractWizardFormController {

    private IPolizaBusiness polizaBusiness;

    public RegistroBeneficiosaAdicionalesPolizaController() {
        this.setSupportedMethods(new String[]{METHOD_POST, METHOD_GET});
        setPages(new String[]{"registroPoliza/w02_RegistroPolizasSeguroEmitidas"});
        
    }

    @SuppressWarnings("unchecked")
	@Override
    protected Map referenceData(HttpServletRequest request, int page) throws Exception {
        Map data = new HashMap();

        
        
        
        data.put("catalogoBeneficios", polizaBusiness.consultarCatalogoBeneficiosAdicionales());
    
        
        

        return data;
    }
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        RegistroPolizaCommand cmd = new RegistroPolizaCommand();
        
      
        Integer numPoliza =  NumberUtils.toInt(request.getParameter("numPoliza"),0);
        Integer numConsignatario = NumberUtils.toInt(request.getParameter("numConsignatario"),0);
      
       if(numPoliza != null && numPoliza > 0){
            PolizaIndividual poliza = polizaBusiness.obtenerDetallePolizaPorNumero(numPoliza, numConsignatario);
            if(poliza != null){
               cmd.setModificacion(true);
               cmd.setPolizaIndividual(poliza);
               int i = 0;
               List <BeneficioAdicional> beneficios = polizaBusiness.consultarCatalogoBeneficiosAdicionales();
               List<BeneficioAdicionalPoliza> beneficiosPoliza = polizaBusiness.
               consultarBeneficiosAdicionalesDePoliza(numPoliza, numConsignatario);
               cmd.setBeneficiosPoliza(new BeneficioAdicionalPoliza[beneficios.size()]);
               for(BeneficioAdicional beneficio:beneficios){
            	   cmd.getBeneficiosPoliza()[i] = new BeneficioAdicionalPoliza();
            	   cmd.getBeneficiosPoliza()[i].setIdBeneficioAdicional(beneficio.getIdBeneficioAdicional());
            	   cmd.getBeneficiosPoliza()[i].setDescripcionBeneficio(beneficio.getDescripcionBeneficioAdicional());
            	   cmd.getBeneficiosPoliza()[i].setNumConsignatario(numConsignatario);
            	   cmd.getBeneficiosPoliza()[i].setNumPoliza(numPoliza);
            	   cmd.getBeneficiosPoliza()[i++].setSumaBeneficio(obtenerSumaDeBeneficio(beneficiosPoliza,beneficio.getIdBeneficioAdicional()));
            	   
               }

              
           }

        }

        return cmd;

    }
    /**
     * Obtiene la suma del beneficio para un beneficio en particular de una lista de 
     * beneficios adicionales enviada, cero si no se encuentra el beneficio
     * @param beneficiosPoliza Lista de beneficios donde se buscara la suma
     * @param idBeneficioAdicional Identificador del beneficio
     * @return
     */
    private Double obtenerSumaDeBeneficio(
			List<BeneficioAdicionalPoliza> beneficiosPoliza,
			Integer idBeneficioAdicional) {
		for(BeneficioAdicionalPoliza beneficio:beneficiosPoliza){
			if(beneficio.getIdBeneficioAdicional().intValue() == idBeneficioAdicional.intValue()){
				return beneficio.getSumaBeneficio();
			}
		}
		return 0.0;
	}

	@Override
    protected void validatePage(Object command, Errors errors, int page) {
        
    }

    @Override
    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException bindException) throws Exception {
        RegistroPolizaCommand datosPoliza = (RegistroPolizaCommand) command;
        List<BeneficioAdicionalPoliza> listaBeneficios = new ArrayList<BeneficioAdicionalPoliza>();
        
        for(BeneficioAdicionalPoliza benef:datosPoliza.getBeneficiosPoliza()){
        	if(benef.getSumaBeneficio() != null && benef.getSumaBeneficio()>0 &&
        		benef.getMontoCobertura() != null && benef.getMontoCobertura() > 0){
        		listaBeneficios.add(benef);
        	}
        }
        datosPoliza.getPolizaIndividual().setBeneficiosAdicionales(listaBeneficios);
        
        polizaBusiness.guardarBeneficiosAdicionales(datosPoliza.getPolizaIndividual());
        
        ModelAndView mav = new ModelAndView("registroPoliza/registroPolizaExitoso");
        mav.addObject(polizaBusiness.obtenerReportesGenerados(datosPoliza));
        return mav;
    }

    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView(new RedirectView("registroPolizaController"));
    }

    @Override
    protected void initBinder(HttpServletRequest req,
            ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
}