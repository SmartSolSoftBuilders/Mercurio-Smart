/*
 * EmitidaEntregadaAseguradosController.java
 *
 * Created on 23 de enero de 2008, 12:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.poliza.IPolizaBusiness;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Capacitacion
 */
public class EmitidaEntregadaAseguradosController extends MultiActionController{
    
    private IPolizaBusiness polizaBusiness;

    public ModelAndView metodoControlador(HttpServletRequest req, HttpServletResponse res){
        String opcion=req.getParameter("opcion");
        ModelAndView modelResult=null;
        if(opcion==null){
            modelResult=new ModelAndView("registroPoliza/RegistroEntregasAsegurados");
        }else if(opcion.equals("1")){
           modelResult= obtenerPolizasPorEntregarAsegurado(req,res);
        }else if(opcion.equals("2")){
            modelResult=actualizarEstatusPoliza(req,res);
        }
        return modelResult;
    }
    
    private ModelAndView obtenerPolizasPorEntregarAsegurado(HttpServletRequest req, HttpServletResponse res){
        List listaPolizas=polizaBusiness.obtenerPolizasPorEntregarAsegurado(req.getParameter("agente").toString());
        Map valores=new HashMap(2);
        valores.put("listaValores",listaPolizas);
        return new ModelAndView("registroPoliza/RegistroEntregasAsegurados",valores);
    }
    
    private ModelAndView actualizarEstatusPoliza(HttpServletRequest req, HttpServletResponse res){
        String[] nombres=req.getParameterValues("nombre");
        String[] fechas=req.getParameterValues("fecha");
        String[] checks=req.getParameterValues("polizaSeleccionada");
        String[] hiddens=req.getParameterValues("hiddenPoliza");
        String url="";
        String idPolizaSeparado[] = null;
        Map valores=new HashMap(2);
        for(int i=1;i<checks.length;i++){
            int index=Integer.parseInt(checks[i])+1;
            try{
                SimpleDateFormat ds=new SimpleDateFormat("dd/MM/yyyy");
                Date fecha=ds.parse(fechas[index]);
                //Date fecha= DateFormat.getDateInstance().parse(fechas[i]);
              //Smart Solutions Diciembre 2011 Se agrega el parámetro de de numero de consignatario para que se actualice correctamente la póliza
                
                idPolizaSeparado = hiddens[index].split(",");
                polizaBusiness.actualizaPolizaEntregadaAsegurado(Integer.parseInt(idPolizaSeparado[0]),Integer.parseInt(idPolizaSeparado[1]),3,nombres[index],fecha);
                url="registroPoliza/operacionCorrecta";
                valores.put("UrlOrigen","emitidasEntregadasAsegurados");
            
            }catch(Exception er){
                valores.put("Resultado","La fecha "+fechas[i]+" es incorrecta");
                url="registroPoliza/RegistroEntregasAsegurados";
                break;
            }
        }
        /*
        for(int i=1;i<checks.length;i++){
            try{
                SimpleDateFormat ds=new SimpleDateFormat("dd/MM/yyyy");
                Date fecha=ds.parse(fechas[i]);
                //Date fecha= DateFormat.getDateInstance().parse(fechas[i]);
                polizaBusiness.actualizaPolizaEntregadaAsegurado(Integer.parseInt(checks[i]),3,nombres[i],fecha);
                url="registroPoliza/operacionCorrecta";
                valores.put("UrlOrigen","emitidasEntregadasAsegurados");
            }catch(Exception er){
                valores.put("Resultado","La fecha "+fechas[i]+" es incorrecta");
                url="registroPoliza/RegistroEntregasAsegurados";
                break;
            }
        }*/
        return new ModelAndView(url,valores);
    }
    
    public void setPolizaBusiness(IPolizaBusiness polizaBusiness){
        this.polizaBusiness=polizaBusiness;
    }
    
    public IPolizaBusiness getPolizaBusiness(){
        return this.polizaBusiness;
    }
    
}
