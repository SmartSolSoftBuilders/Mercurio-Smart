/*
 * EmitidaEntregadaAgenteController.java
 *
 * Created on 17 de enero de 2008, 02:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import mx.com.seguros.business.poliza.IPolizaBusiness;
/**
 *
 * @author Capacitacion
 */
public class EmitidaEntregadaAgenteController extends MultiActionController {
    private IPolizaBusiness polizaBusiness;
    /*MÃ©todo encargado de consultar polizas emitidas*/
    
    public ModelAndView consultaPolizaEmitida(HttpServletRequest req, HttpServletResponse res){
        String opcion=req.getParameter("opcion");
        ModelAndView modelResult=null;
        
        if(opcion.equals("1"))
            modelResult= consultaPolizasEmitidaEntregada(req,res);
        else if(opcion.equals("2"))
            modelResult= actualizaEstatusPoliza(req,res);
        return modelResult;
    }
    
    public ModelAndView actualizaEstatusPoliza(HttpServletRequest req, HttpServletResponse res){
        String[] polizas=req.getParameterValues("polizaSeleccionada");
        String url="";
        String idPolizaSeparado[] = null;
        Map valores=new HashMap(2);
        if (polizas!=null){
        	
            for(int i=0;i<polizas.length;i++){
            	//Smart Solutions Diciembre 2011 Se agrega el parámetro de de numero de consignatario para que se actualice correctamente la póliza
            	idPolizaSeparado = polizas[i].split(",");
                polizaBusiness.actualizaEstatusPoliza(Integer.parseInt(idPolizaSeparado[0]),Integer.parseInt(idPolizaSeparado[1]),2);
            }
            url="registroPoliza/operacionCorrecta";
            valores.put("UrlOrigen","polizaEntregadaEmitida");
        }
        return new ModelAndView(url,valores);
    }
    
    public ModelAndView metodoNulo(HttpServletRequest req, HttpServletResponse res){
        return new ModelAndView("registroPoliza/registroPolisasEntregadaAgente");
    }   
    
    private ModelAndView consultaPolizasEmitidaEntregada(HttpServletRequest req, HttpServletResponse res){
        Map valores=new HashMap(2);
        String agente=req.getParameter("agente").toString();
        List listaPolizas= polizaBusiness.obtenerPolizaEntregadaEmitidaAgente(agente);
        valores.put("listaValores",listaPolizas);
        //req.getSession().setAttribute("listaValores",listaPolizas);
        
        return new ModelAndView("registroPoliza/registroPolisasEntregadaAgente",valores);
    }
    
    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }
    
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }
}
