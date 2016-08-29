/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: BaseServiceTest.java
 * Fecha de creación: 04/06/2011
 * Última Modificación: 04/06/2011
 */

package mx.com.seguros.model;

/**
 * Modelo para tabla EstadoRegistroPoliza
 * @author Emigdio
 */
public class EstadoRegistroPoliza {

    public static final Integer PENDIENTE = new Integer(1);
    public static final Integer PROCESADO = new Integer(2);
    public static final Integer INVALIDO = new Integer(3);

    private Integer idEstadoRegistroPoliza;
    private String descripcion;

    /**
     * @return the idEstadoRegistroPoliza
     */
    public Integer getIdEstadoRegistroPoliza() {
        return idEstadoRegistroPoliza;
    }

    /**
     * @param idEstadoRegistroPoliza the idEstadoRegistroPoliza to set
     */
    public void setIdEstadoRegistroPoliza(Integer idEstadoRegistroPoliza) {
        this.idEstadoRegistroPoliza = idEstadoRegistroPoliza;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
