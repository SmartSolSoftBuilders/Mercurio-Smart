/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: ResumenCargaArchivoPolizas.java
 * Fecha de creación: 04/06/2011
 * Última Modificación: 04/06/2011
 */

package mx.com.seguros.model;

import java.util.Date;

/**
 * Modelo para la tabla ResumenCargaArchivoPoliza
 * @author Emigdio
 */
public class ResumenCargaArchivoPolizas {
    private Integer idResumenCargaArchivoPolizas;
    private Date fechaCarga;
    private String usuario;
    private Integer totalRegistros;
    private String nombreArchivo;
    private Integer registrosValidos;

    /**
     * @return the idResumenCargaArchivoPolizas
     */
    public Integer getIdResumenCargaArchivoPolizas() {
        return idResumenCargaArchivoPolizas;
    }

    /**
     * @param idResumenCargaArchivoPolizas the idResumenCargaArchivoPolizas to set
     */
    public void setIdResumenCargaArchivoPolizas(Integer idResumenCargaArchivoPolizas) {
        this.idResumenCargaArchivoPolizas = idResumenCargaArchivoPolizas;
    }

    /**
     * @return the fechaCarga
     */
    public Date getFechaCarga() {
        return fechaCarga;
    }

    /**
     * @param fechaCarga the fechaCarga to set
     */
    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the totalRegistros
     */
    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    /**
     * @param totalRegistros the totalRegistros to set
     */
    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the registrosValidos
     */
    public Integer getRegistrosValidos() {
        return registrosValidos;
    }

    /**
     * @param registrosValidos the registrosValidos to set
     */
    public void setRegistrosValidos(Integer registrosValidos) {
        this.registrosValidos = registrosValidos;
    }

}
