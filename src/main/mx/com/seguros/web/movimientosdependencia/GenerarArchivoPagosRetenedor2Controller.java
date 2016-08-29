/*
 * GenerarArchivoPagosRetenedor2Controller.java
 *
 * Created on 15 de noviembre de 2008, 04:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.movimientosdependencia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.movimientosdependencia.GenerarArchivoPagosRetenedorBusiness;
import mx.com.seguros.business.reporte.ReportesPDF;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author QTX
 */
public class GenerarArchivoPagosRetenedor2Controller extends SimpleFormController{
    private GenerarArchivoPagosRetenedorBusiness generarArchivoPagosRetenedorBusiness;
    
    public ModelAndView onSubmit(HttpServletRequest req,HttpServletResponse res,
            Object command,BindException errors) throws ServletException, IOException {
        String url = "generarArchivoPagosRetenedor/generarArchivosPagRetExitoso";
        GenerarArchivoPagosRetenedorCommand generarArchivoPagosRetenedor = (GenerarArchivoPagosRetenedorCommand)command;
        
        if(generarArchivoPagosRetenedor.getFile() != null && !generarArchivoPagosRetenedor.getFile().isEmpty()){
        	
        	generarArchivoPagosRetenedorBusiness.leerArchivoPagoRetenedores(generarArchivoPagosRetenedor.getFile().getInputStream());
        	
        }
       
        
        String rutaArchivoPagosRetenedor = generarArchivoPagosRetenedorBusiness.generarArchivoPagosRetenedor();
        System.out.println("rutaArchivoPagosRetenedor "+rutaArchivoPagosRetenedor);
        ReportesPDF reportesGenerados = new ReportesPDF();
        reportesGenerados.setRutaArchivoPagosRetenedor(rutaArchivoPagosRetenedor);        
        req.getSession().setAttribute("ReportesPDF",reportesGenerados);
        ModelAndView mav = new ModelAndView (url);        
        mav.addObject(reportesGenerados);
        return mav;        
    }

    public GenerarArchivoPagosRetenedorBusiness getGenerarArchivoPagosRetenedorBusiness() {
        return generarArchivoPagosRetenedorBusiness;
    }

    public void setGenerarArchivoPagosRetenedorBusiness(GenerarArchivoPagosRetenedorBusiness generarArchivoPagosRetenedorBusiness) {
        this.generarArchivoPagosRetenedorBusiness = generarArchivoPagosRetenedorBusiness;
    }
    
}
