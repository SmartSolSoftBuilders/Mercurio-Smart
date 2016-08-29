/*
 * TipoPrestamo.java
 *
 * Created on 22 de mayo de 2008, 11:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

/**
 *
 * @author QTX
 */
public class TipoPrestamo {
    
    private int cvePrestamo;
    private String conceptoPrestamo;
    /** Creates a new instance of TipoPrestamo */
    public TipoPrestamo() {
    }

    public int getCvePrestamo() {
        return cvePrestamo;
    }

    public void setCvePrestamo(int cvePrestamo) {
        this.cvePrestamo = cvePrestamo;
    }

    public String getConceptoPrestamo() {
        return conceptoPrestamo;
    }

    public void setConceptoPrestamo(String conceptoPrestamo) {
        this.conceptoPrestamo = conceptoPrestamo;
    }
    
}
