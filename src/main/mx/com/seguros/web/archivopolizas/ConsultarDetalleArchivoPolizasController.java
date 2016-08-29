 	/**
 * 
 */
package mx.com.seguros.web.archivopolizas;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness;
import mx.com.seguros.model.EstadoRegistroPoliza;
import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.utils.FormatUtil;
import mx.com.seguros.utils.ResultadoPaginadoDTO;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Controller que atiende las peticiones de ver el detalle de la carga de una archivo de pólizas
 * @author Emigdio Hernández
 *
 */
public class ConsultarDetalleArchivoPolizasController extends AbstractController{
	private IArchivoPolizasBusiness archivoPolizasBusiness;
    
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	if(request.getParameter("idEliminar") != null){
    		archivoPolizasBusiness.eliminarRegistroArchivoPolizas(NumberUtils.toInt(request.getParameter("idEliminar"),0));
    	}
    	ModelAndView mv = new ModelAndView("archivoPolizas/detalleCargaArchivoInbursa");
    	Integer idResumenCargaArchivoPolizas = NumberUtils.toInt(request.getParameter("idResumenCargaArchivoPolizas"));
    	Integer idEstadoRegistroPoliza = FormatUtil.parseIntNull(request.getParameter("idEstadoRegistroPoliza"));
    	mv.addObject("idResumenCargaArchivoPolizas",idResumenCargaArchivoPolizas);
    	mv.addObject("idEstadoRegistroPoliza",idEstadoRegistroPoliza);
    	mv.addObject("resumen",
    			archivoPolizasBusiness.consultarArchivoPolizasPorId(idResumenCargaArchivoPolizas));
    	mv.addObject("listaRegistrosArchivo",
    			archivoPolizasBusiness.consultarRegistrosArchivoPolizaPorArchivoCargado(idResumenCargaArchivoPolizas, idEstadoRegistroPoliza));
        
    	
    	
        return mv;
    }

    /**
     * @return the archivoPolizasBusiness
     */
    public IArchivoPolizasBusiness getArchivoPolizasBusiness() {
        return archivoPolizasBusiness;
    }

    /**
     * @param archivoPolizasBusiness the archivoPolizasBusiness to set
     */
    public void setArchivoPolizasBusiness(IArchivoPolizasBusiness archivoPolizasBusiness) {
        this.archivoPolizasBusiness = archivoPolizasBusiness;
    }

}
