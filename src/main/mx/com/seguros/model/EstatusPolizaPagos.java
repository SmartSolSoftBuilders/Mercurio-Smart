/*
 * EstatusPolizaPagos.java
 *
 * Created on 10 de marzo de 2008, 03:38 PM
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
public class EstatusPolizaPagos {
    
    /** Creates a new instance of EstatusPolizaPagos */
    public EstatusPolizaPagos() {
    }
    private Integer idEstatusPagosPoliza;
    private String descripcionEstatusPagosPoliza;
    private List<PolizaIndividual> polizaindividual = new ArrayList<PolizaIndividual>();
    
      public List<PolizaIndividual> getPolizaindividual() {
            return polizaindividual;
    }

    public void setPolizaindividual(List<PolizaIndividual> polizaindividual) {
        this.polizaindividual = polizaindividual;
    }

    public Integer getIdEstatusPagosPoliza() {
        return idEstatusPagosPoliza;
    }

    public void setIdEstatusPagosPoliza(Integer idEstatusPagosPoliza) {
        this.idEstatusPagosPoliza = idEstatusPagosPoliza;
    }

    public String getDescripcionEstatusPagosPoliza() {
        return descripcionEstatusPagosPoliza;
    }

    public void setDescripcionEstatusPagosPoliza(String descripcionEstatusPagosPoliza) {
        this.descripcionEstatusPagosPoliza = descripcionEstatusPagosPoliza;
    }
    
    
}
