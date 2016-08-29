/*
 * Retenedor.java
 *
 * Created on 22 de mayo de 2008, 11:07 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class Retenedor {
    
    private int cveRetenedor;
    private String nombreRetenedor;
    private String siglasRetenedor;
    private int idPlaza;
    private String nombreResponsable;
    private String puesto;
    private String cveDescuento;
    
    /** Creates a new instance of Retenedor */
    public Retenedor() {
    }

    public int getCveRetenedor() {
        return cveRetenedor;
    }

    public void setCveRetenedor(int cveRetenedor) {
        this.cveRetenedor = cveRetenedor;
    }

    public String getNombreRetenedor() {
        return nombreRetenedor;
    }

    public void setNombreRetenedor(String nombreRetenedor) {
        this.nombreRetenedor = nombreRetenedor;
    }

    public int getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(int idPlaza) {
        this.idPlaza = idPlaza;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCveDescuento() {
        return cveDescuento;
    }

    public void setCveDescuento(String cveDescuento) {
        this.cveDescuento = cveDescuento;
    }

    public String getSiglasRetenedor() {
        return siglasRetenedor;
    }

    public void setSiglasRetenedor(String siglasRetenedor) {
        this.siglasRetenedor = siglasRetenedor;
    }
    
}
