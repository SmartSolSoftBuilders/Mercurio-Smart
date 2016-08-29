/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.web.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.inburnomina.AdministrarProductosInburnominaService;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import mx.com.seguros.business.solicitud.ISolicitudBusiness;
import mx.com.seguros.model.Agente;
import mx.com.seguros.model.BeneficioAdicionalPoliza;
import mx.com.seguros.model.PolizaIndividual;
import mx.com.seguros.model.ProductosInburnomina;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.TarifaAportMensual;
import mx.com.seguros.utils.ConstantesGenerales;
import mx.com.seguros.utils.DateUtils;
import mx.com.seguros.web.poliza.ConsultaPolizaCommand;
import mx.com.seguros.web.seguridad.util.SeguridadUtil;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller dedicado a atender las solicitudes de una consulta detallada de
 * solicitud de seguro
 * @author Emigdio Hernández
 */
public class ConsultaDetalleSolicitudController extends AbstractController{

    private IPolizaBusiness polizaBusiness;

    private ISolicitudBusiness solicitudBusiness;
    
    private SeguridadUtil seguridadUtil;
    /**
	 * Servicio para la consulta de los productos inburnomina
	 */
    private AdministrarProductosInburnominaService administrarProductosInburnominaService;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        boolean emitirReporteDescuentos = request.getParameter("_finish")!=null;
        boolean actualizarDatosEstado = request.getParameter("actualizarEstados")!=null && request.getParameter("actualizarEstados").equals("true");
        ModelAndView mv = null;
        Integer numPoliza = NumberUtils.toInt(request.getParameter("numPoliza"));
        Integer emisor = NumberUtils.toInt(request.getParameter("emisor"));
        if(emitirReporteDescuentos){
        	ConsultaPolizaCommand datosPoliza = new ConsultaPolizaCommand();
        	datosPoliza.getPolizaIndividual().setNumPoliza(numPoliza);
        	datosPoliza.getPolizaIndividual().setNumConsignatario(emisor);
            polizaBusiness.generarReportes5(datosPoliza);
            request.getSession().setAttribute("ReportesPDF",polizaBusiness.obtenerReportesGenerados5(datosPoliza));
            mv = new ModelAndView("registroPoliza/reporteAplicDescExitoso");
        }else{
        	
        	
        	
        	mv = new ModelAndView("consulta/detalleSolicitud");
        	
            Integer folioSolicitud = NumberUtils.toInt(request.getParameter("folioSolicitud"));
            String formatoSolicitud = request.getParameter("formatoSolicitud");
            PolizaIndividual poliza = polizaBusiness.obtenerDetallePolizaPorNumero(numPoliza,emisor);


        	if(actualizarDatosEstado){
        		if(request.getParameter("fechaSolicitudCancelacion") != null){
        			poliza.setFechaSolicitudCancelacion(DateUtils.parseDate(request.getParameter("fechaSolicitudCancelacion")));
        		}
        		if(request.getParameter("fechaCancelacionDescuento") != null){
        			poliza.setFechaCancelacionDescuento(DateUtils.parseDate(request.getParameter("fechaCancelacionDescuento")));
        		}
        		if(request.getParameter("idEstatusPolizaSeguimiento") != null){
        			poliza.setIdEstatusPolizaSeguimiento(NumberUtils.toInt(request.getParameter("idEstatusPolizaSeguimiento")));
        		}
        		if(request.getParameter("idEstatusPagosPoliza") != null){
        			poliza.setIdEstatusPagosPoliza(NumberUtils.toInt(request.getParameter("idEstatusPagosPoliza")));
        		}
        		if(request.getParameter("numQuincenaUltimoDescuento") != null){
        			poliza.setNumQuincenaUltimoDescuento(NumberUtils.toInt(request.getParameter("numQuincenaUltimoDescuento")));
        		}
        		
        		if(request.getParameter("anhoUltimoDescuento") != null){
        			poliza.setAnhoUltimoDescuento(NumberUtils.toInt(request.getParameter("anhoUltimoDescuento")));
        		}
        		
        		
        		polizaBusiness.actualizarDatosPolizaAtencionClientes(poliza);
        		mv.addObject("mensajeUsuario","Datos de la póliza actualizados correctamente");
        	}
            
            Solicitud sol = solicitudBusiness.obtenerDetalleSolicitudPorFolio(folioSolicitud,formatoSolicitud);
            
            
            if(sol.getCveAgente() != null){
            	Agente agente = solicitudBusiness.obtenerAgentePorCveAgente(sol.getCveAgente());
                sol.setAgente(agente);
                if(sol.getAgente() != null){
                	sol.getAgente().setEmpleado(solicitudBusiness.obtenerEmpleadoPorCveEmpleado(agente.getCveEmpleado()));
                }
            }
            if(poliza == null){
            	poliza = new PolizaIndividual();
            }
            //Preparar la suma asegurada total
            double totalBeneficios = 0;
            double totalTarifaBeneficio = 0;
            if(poliza.getBeneficiosAdicionales() != null){
            	for(BeneficioAdicionalPoliza benef:poliza.getBeneficiosAdicionales()){
                	totalBeneficios+=benef.getMontoCobertura()!=null?benef.getMontoCobertura():0;
                	totalTarifaBeneficio+=benef.getSumaBeneficio()!=null?benef.getSumaBeneficio():0;
                }
            }
            
            poliza.setSumaAseguradaTotal(
            		(poliza.getSumaAseguradaIndividual()!=null?poliza.getSumaAseguradaIndividual():0) + 
            		(poliza.getSumaSEVI()!=null?poliza.getSumaSEVI():0) + 
            		(poliza.getSumaGastosFunerarios()!=null?poliza.getSumaGastosFunerarios():0) + 
            		(poliza.getSumaBAF()!=null?poliza.getSumaBAF():0.00)+totalBeneficios+sol.getTarifa().getPrimaMensualSeguroColectivo().getSumaAseguradaColectiva());
          
           
           

            mv.addObject("poliza",poliza);

            mv.addObject("historicoTarifas",solicitudBusiness.consultarHistoricoTarifaSolicitud(sol));
            
            mv.addObject("listaTramites",polizaBusiness.obtenerTramitesDePoliza(poliza.getNumPoliza(), poliza.getNumConsignatario()));
            //catalogo de estatus
            
            mv.addObject("listaEstatusPolizaGeneral", polizaBusiness.consultarEstatusPolizaGeneral());
            mv.addObject("listaEstatusPolizaSeguimiento", polizaBusiness.consultarEstatusPolizaSeguimiento());
            mv.addObject("listaEstatusPolizaPagos", polizaBusiness.consultarEstatusPolizaPagos());
            
            mv.addObject("puedeModificarEstatus",seguridadUtil.isRolAntencionClientes());
            
            poliza.setProductosInburnomina(administrarProductosInburnominaService.obtenerProductosInburnominaDePoliza(numPoliza, emisor));
            if(poliza.getProductosInburnomina() == null){
            	poliza.setProductosInburnomina(new ProductosInburnomina());
            }
            
            if(poliza!=null && sol!=null){
                poliza.setSolicitud(sol);
                sol.setTarifaTotal(totalTarifaBeneficio+sol.getTarifa().getImporteTarifa()+poliza.getProductosInburnomina().getTotalPrimaQuincenal());
            }
            
            if(sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_PRECAPTURA ||
            		sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_SIN_EMISION ||
            		sol.getIdEstatusSolicitud() == ConstantesGenerales.ESTATUS_SOLICITUD_REQUERIMIENTO_MEDICO){
            	mv.addObject("puedeModificar",true);
            }else{
            	mv.addObject("puedeModificar",false);
            }
        }
        	
        
        
        

        return mv;
    }

    /**
     * @return the polizaBusiness
     */
    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    /**
     * @param polizaBusiness the polizaBusiness to set
     */
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }

    /**
     * @return the solicitudBusiness
     */
    public ISolicitudBusiness getSolicitudBusiness() {
        return solicitudBusiness;
    }

    /**
     * @param solicitudBusiness the solicitudBusiness to set
     */
    public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
        this.solicitudBusiness = solicitudBusiness;
    }

	/**
	 * @param administrarProductosInburnominaService the administrarProductosInburnominaService to set
	 */
	public void setAdministrarProductosInburnominaService(
			AdministrarProductosInburnominaService administrarProductosInburnominaService) {
		this.administrarProductosInburnominaService = administrarProductosInburnominaService;
	}

	/**
	 * @param seguridadUtil the seguridadUtil to set
	 */
	public void setSeguridadUtil(SeguridadUtil seguridadUtil) {
		this.seguridadUtil = seguridadUtil;
	}

    

}
