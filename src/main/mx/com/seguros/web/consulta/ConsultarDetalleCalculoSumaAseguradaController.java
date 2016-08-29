package mx.com.seguros.web.consulta;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.dto.DetalleBeneficioAdicionalDTO;
import mx.com.seguros.dto.DetalleCalculoSumaAseguradaDTO;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.XMLUtil;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller dedicado a atender las solicitudes de una consulta del detalle del cálculo
 * de la suma asegurada individual
 * @author Emigdio Hernández
 */
public class ConsultarDetalleCalculoSumaAseguradaController extends AbstractController{

  
    private IPolizaBusiness polizaBusiness;
    
    private ISolicitudBusiness solicitudBusiness;
    
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	//Preparar la suma asegurada total
        DetalleCalculoSumaAseguradaDTO detalleCalculo = new DetalleCalculoSumaAseguradaDTO();
        
        Integer numPoliza = NumberUtils.toInt(request.getParameter("numPoliza"));
        Integer emisor = NumberUtils.toInt(request.getParameter("numConsignatario"));
        
        
        PolizaIndividual poliza = polizaBusiness.obtenerDetallePolizaPorNumero(numPoliza,emisor);
        
                
        
        if(poliza != null ){
        	
        	Solicitud sol = solicitudBusiness.obtenerDetalleSolicitudPorFolio(poliza.getSolicitud().getFolioSolicitud(),poliza.getSolicitud().getFormatoSolicitud());

        	
        	double totalBeneficios = 0;
        	
        	detalleCalculo.setDetalleBeneficios(new ArrayList<DetalleBeneficioAdicionalDTO>());
        	DetalleBeneficioAdicionalDTO detalleBeneficio = null;
            for(BeneficioAdicionalPoliza benef:poliza.getBeneficiosAdicionales()){
            	totalBeneficios+=benef.getMontoCobertura()!=null?benef.getMontoCobertura():0;
            	detalleBeneficio = new DetalleBeneficioAdicionalDTO();
            	detalleBeneficio.setDescripcionBeneficio(benef.getDescripcionBeneficio());
            	detalleBeneficio.setCostoBeneficio(FormatUtil.formatoNumeroEntero(benef.getSumaBeneficio()));
            	detalleBeneficio.setMontoCobertura(FormatUtil.formatoNumeroEntero(benef.getMontoCobertura()!=null?benef.getMontoCobertura():0));
            	detalleCalculo.getDetalleBeneficios().add(detalleBeneficio);
            }
            
            
            detalleCalculo.setSumaAseguradaIndividual(poliza.getSumaAseguradaIndividual());
            detalleCalculo.setSumaAseguradaColectiva(sol.getTarifa().getPrimaMensualSeguroColectivo().getSumaAseguradaColectiva());
            detalleCalculo.setSumaGastosFunerarios(poliza.getSumaGastosFunerarios()!=null?poliza.getSumaGastosFunerarios():0.0);
            detalleCalculo.setSumaSEVI(poliza.getSumaSEVI()!=null?poliza.getSumaSEVI():0.0);
            detalleCalculo.setSumaBAF(poliza.getSumaBAF()!=null?poliza.getSumaBAF():0.0);
            detalleCalculo.setMontoCoberturaBeneficios(totalBeneficios);
            
            detalleCalculo.setSumaSeguroVida(detalleCalculo.getSumaAseguradaIndividual() + detalleCalculo.getSumaAseguradaColectiva());
            
            detalleCalculo.setSumaAseguradaTotal(
            			detalleCalculo.getSumaAseguradaIndividual() + detalleCalculo.getSumaAseguradaColectiva() +
            			detalleCalculo.getSumaGastosFunerarios() + detalleCalculo.getSumaSEVI() +
            			detalleCalculo.getSumaBAF() + detalleCalculo.getMontoCoberturaBeneficios()
            		);
            
            
            
            
            detalleCalculo.setFormatoAnterior(sol.getTarifa().getPrimaMensualSeguroColectivo().getSumaAseguradaColectiva() > 0);
            
            
            detalleCalculo.setSumaAseguradaIndividualString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaAseguradaIndividual()));
            detalleCalculo.setSumaAseguradaColectivaString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaAseguradaColectiva()));
            detalleCalculo.setSumaGastosFunerariosString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaGastosFunerarios()));
            detalleCalculo.setSumaSEVIString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaSEVI()));
            detalleCalculo.setSumaBAFString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaBAF()));
            detalleCalculo.setMontoCoberturaBeneficiosString(FormatUtil.formatoNumeroEntero(detalleCalculo.getMontoCoberturaBeneficios()));
            detalleCalculo.setSumaSeguroVidaString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaSeguroVida()));
            
            detalleCalculo.setSumaAseguradaTotalString(FormatUtil.formatoNumeroEntero(detalleCalculo.getSumaAseguradaTotal()));
            
        }
    	
    	
    	
    	
    	response.getWriter().write(
    	XMLUtil.converter.toXML(detalleCalculo)
    	);
        return null;
    }

       
   	/**
	 * @param polizaBusiness the polizaBusiness to set
	 */
	public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
		this.polizaBusiness = polizaBusiness;
	}


	/**
	 * @param solicitudBusiness the solicitudBusiness to set
	 */
	public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
		this.solicitudBusiness = solicitudBusiness;
	}

    

}
