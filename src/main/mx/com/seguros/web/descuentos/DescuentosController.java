/*
 * DescuentosController.java
 *
 * Created on 31 de enero de 2008, 04:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.descuentos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.descuentos.DescuentosBusiness;
import mx.com.seguros.utils.CargaArchivo;
import mx.com.seguros.utils.CargaArchivoVO;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Capacitacion
 */
public class DescuentosController extends SimpleFormController {
    
    /** Creates a new instance of DescuentosController */
    private DescuentosBusiness descuentosBusiness;
    @Override
    public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,
            Object command,BindException errors) throws ServletException, IOException {
        //ModelAndView modelAndView=null;
        String ruta;
        String url="";
        ArrayList datosArchivo=null;
        Map valores=new HashMap(2);
        CargaArchivoVO cargaArchivoVO=(CargaArchivoVO)command;
        MultipartFile file= cargaArchivoVO.getFile();
        CargaArchivo cargaArchivo=new CargaArchivo();
        try {
			datosArchivo=cargaArchivo.cargaInformacionArchivo(file.getInputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ruta=this.getServletContext().getRealPath(".");
        
        if(!descuentosBusiness.obtenListaPolizasPorPagar(datosArchivo,ruta)){
            if(descuentosBusiness.validaArchivo(datosArchivo)){
                if(!descuentosBusiness.obtenListaPolizasPorPagar(datosArchivo,ruta)){
                    String[] error=descuentosBusiness.getError().split("-");
                    valores.put("mensajeError",error[0]);
                    valores.put("archivoError",error.length>1?error[1]:"");
                }
                url="CargaArchivos/operacionCorrecta2";
                valores.put("UrlOrigen",descuentosBusiness.getError());
                
                
            }else{
                url="CargaArchivos/cargaArchivoDescuentos";
                valores.put("Error",descuentosBusiness.getError());
            }
            
            
        }
        else{
            if(descuentosBusiness.validaArchivo(datosArchivo)){
                if(!descuentosBusiness.obtenListaPolizasPorPagar(datosArchivo,ruta)){
                    String[] error=descuentosBusiness.getError().split("-");
                    valores.put("mensajeError",error[0]);
                    valores.put("archivoError",error[1]);
                }
                if(descuentosBusiness.getFechDepIncorrecta() == 1){
                    url="CargaArchivos/operacionIncorrecta";
                }
                else{
                url="CargaArchivos/operacionCorrecta";
                valores.put("UrlOrigen",descuentosBusiness.getError());
                }
                
            } else if(!descuentosBusiness.validaCantidades(datosArchivo)){
                url="CargaArchivos/cargaArchivoDescuentos";
                valores.put("Error2",descuentosBusiness.getError());
              } 
            else{
                url="CargaArchivos/cargaArchivoDescuentos";
                valores.put("Error",descuentosBusiness.getError());
            }
            
            
            
            
        }
   /*     if(descuentosBusiness.validaQuincenaArchivo(datosArchivo,idArchivo)){
            idArchivo=idArchivo.substring(0,6);
            if(!descuentosBusiness.obtenListaPolizasPorPagar(datosArchivo,ruta)){
                String[] error=descuentosBusiness.getError().split("-");
                valores.put("mensajeError",error[0]);
                valores.put("archivoError",error[1]);
            }
            url="CargaArchivos/operacionCorrecta";
            valores.put("UrlOrigen",descuentosBusiness.getError());
        } else{
            url="CargaArchivos/cargaArchivoDescuentos";
            valores.put("Error1",descuentosBusiness.getError());
        }*/
        
        
        
        
        
        return new ModelAndView(url,valores);
    }
    
    public DescuentosBusiness getDescuentosBusiness() {
        return descuentosBusiness;
    }
    
    public void setDescuentosBusiness(DescuentosBusiness descuentosBusiness) {
        this.descuentosBusiness = descuentosBusiness;
    }
}
