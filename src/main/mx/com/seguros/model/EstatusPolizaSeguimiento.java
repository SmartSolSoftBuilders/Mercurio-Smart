/*
 * EstatusPolizaSeguimiento.java
 *
 * Created on 10 de marzo de 2008, 03:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

import mx.com.seguros.model.PolizaIndividual;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author QTX
 */
public class EstatusPolizaSeguimiento {
    
    /** Creates a new instance of EstatusPolizaSeguimiento */
    public EstatusPolizaSeguimiento() {
    }
    
     private int idEstatusPolizaSeguimiento;
    private String descripcionEstatusPoliza;    
    private List<PolizaIndividual> polizaindividual = new ArrayList<PolizaIndividual>();
        
         public List<PolizaIndividual> getPolizaindividual() {
            return polizaindividual;
    }

    public void setPolizaindividual(List<PolizaIndividual> polizaindividual) {
        this.polizaindividual = polizaindividual;
    }

    public int getIdEstatusPolizaSeguimiento() {
        return idEstatusPolizaSeguimiento;
    }

    public void setIdEstatusPolizaSeguimiento(int idEstatusPolizaSeguimiento) {
        this.idEstatusPolizaSeguimiento = idEstatusPolizaSeguimiento;
    }

    public String getDescripcionEstatusPoliza() {
        return descripcionEstatusPoliza;
    }

    public void setDescripcionEstatusPoliza(String descripcionEstatusPoliza) {
        this.descripcionEstatusPoliza = descripcionEstatusPoliza;
    }
    
}
