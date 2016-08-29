/*
 * CancelarPolizaCommand.java
 *
 * Created on 11 de febrero de 2008, 10:01 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.web.poliza;
import mx.com.seguros.model.PolizaIndividual;

/**
 *
 * @author QTX
 */
public class CancelarPolizaCommand {
    
    /** Creates a new instance of CancelarPolizaCommand */
    public CancelarPolizaCommand() {
    }
    
    private PolizaIndividual polizaIndividual = new PolizaIndividual();
    
    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }
    
    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }
    
}
