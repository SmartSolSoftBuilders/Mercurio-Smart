/*
 * ObtenerEstatusPoliza.java
 *
 * Created on 14 de febrero de 2008, 05:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
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
 * @author QTX
 */
public class ObtenerEstatusPolizaController extends MultiActionController{
    private IPolizaBusiness polizaBusiness;
    
    /** Creates a new instance of ObtenerEstatusPoliza */
   public ModelAndView obtenerEstatusPoliza(HttpServletRequest req, HttpServletResponse res){
       List listaestatus=polizaBusiness.obtenerEstatusPoliza();
       Map valores=new HashMap(1);
       valores.put("listaValores",listaestatus);
       System.out.print("lista"+valores);
       return new ModelAndView("jspVacio",valores);
   }

    public IPolizaBusiness getPolizaBusiness() {
        return polizaBusiness;
    }

    public void setPolizaBusiness(IPolizaBusiness polizaBusiness) {
        this.polizaBusiness = polizaBusiness;
    }

    
    
}
