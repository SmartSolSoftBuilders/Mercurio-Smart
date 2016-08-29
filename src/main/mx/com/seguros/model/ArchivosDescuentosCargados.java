/*
 * ArchivosDescuentosCargados.java
 *
 * Created on 31 de marzo de 2008, 10:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;
import java.util.Date;
/**
 *
 * @author root
 */
public class ArchivosDescuentosCargados {
    
    private int numQuincena;
    private String cveRetenedor;
    private int consecutivoArchivo;
    private Date fechaCarga;
    
    /** Creates a new instance of ArchivosDescuentosCargados */
    public ArchivosDescuentosCargados() {
    }

    public int getNumQuincena() {
        return numQuincena;
    }

    public void setNumQuincena(int numQuincena) {
        this.numQuincena = numQuincena;
    }

   

    public int getConsecutivoArchivo() {
        return consecutivoArchivo;
    }

    public void setConsecutivoArchivo(int consecutivoArchivo) {
        this.consecutivoArchivo = consecutivoArchivo;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getCveRetenedor() {
        return cveRetenedor;
    }

    public void setCveRetenedor(String cveRetenedor) {
        this.cveRetenedor = cveRetenedor;
    }

   
}
