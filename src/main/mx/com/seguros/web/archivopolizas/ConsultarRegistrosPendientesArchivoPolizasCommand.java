/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.web.archivopolizas;

/**
 * Comando para la consulta de registros de archivo poliza pendientes
 * @author Emigdio
 */
public class ConsultarRegistrosPendientesArchivoPolizasCommand {
    private Integer registrosPorPagina;
    private Integer totalResultados;
    private Integer paginaActual;

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

    /**
     * @return the totalResultados
     */
    public Integer getTotalResultados() {
        return totalResultados;
    }

    /**
     * @param totalResultados the totalResultados to set
     */
    public void setTotalResultados(Integer totalResultados) {
        this.totalResultados = totalResultados;
    }

    /**
     * @return the paginaActual
     */
    public Integer getPaginaActual() {
        return paginaActual;
    }

    /**
     * @param paginaActual the paginaActual to set
     */
    public void setPaginaActual(Integer paginaActual) {
        this.paginaActual = paginaActual;
    }


}
