/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: ConsultarRegistrosPendientesArchivoPolizasController.java
 * Fecha de creación: 10/06/2011
 * Última Modificación: 10/06/2011
 */

package mx.com.seguros.web.archivopolizas;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.seguros.business.archivopolizas.IArchivoPolizasBusiness;
import mx.com.seguros.model.EstadoRegistroPoliza;
import mx.com.seguros.model.RegistroArchivoPolizas;
import mx.com.seguros.utils.ResultadoPaginadoDTO;
import org.apache.commons.lang.math.NumberUtils;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Controller para las peticiones de búsqueda de los registros del archivo póliza pendientes de procesar
 * @author Emigdio
 */
public class ConsultarRegistrosPendientesArchivoPolizasController extends AbstractController{
     /** Creates a new instance of DescuentosController */
    private IArchivoPolizasBusiness archivoPolizasBusiness;
    private Integer registrosPorPagina;
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ResultadoPaginadoDTO<RegistroArchivoPolizas> resultado = new ResultadoPaginadoDTO<RegistroArchivoPolizas>();
        resultado.setPaginaActual(1);
        resultado.setRegistrosPorPagina(getRegistrosPorPagina());
        if(request.getParameter("paginaActual") != null){
            resultado.setPrimerVez(false);
            resultado.setPaginaActual(NumberUtils.toInt(request.getParameter("paginaActual"), 1));
            resultado.setTotalResultados(NumberUtils.toInt(request.getParameter("totalResultados"), 1));
            resultado.setTotalPaginas(NumberUtils.toInt(request.getParameter("totalPaginas"), 1));
        }


        getArchivoPolizasBusiness().consultarRegistroArchivoPolizasPorEstatus(EstadoRegistroPoliza.PENDIENTE,resultado );

        Map<String,Object> resultModel = new HashMap<String, Object>();
        resultModel.put("resultado",resultado);
        
         return new ModelAndView("archivoPolizas/consultarRegistrosPolizaPendientes",resultModel);
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

    /**
     * @return the registrosPorPagina
     */
    public Integer getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    /**
     * @param registrosPorPagina the registrosPorPagina to set
     */
    public void setRegistrosPorPagina(Integer registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

}
