/*
 * AutofinanciarPolizaCancelCommand.java
 *
 * Created on 4 de marzo de 2008, 01:12 PM
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
public class AutofinanciarPolizaCancelCommand {
    
    /** Creates a new instance of AutofinanciarPolizaCancelCommand */
    public AutofinanciarPolizaCancelCommand() {
    }
    private PolizaIndividual polizaIndividual = new PolizaIndividual();
    
    public PolizaIndividual getPolizaIndividual() {
        return polizaIndividual;
    }
    
    public void setPolizaIndividual(PolizaIndividual polizaIndividual) {
        this.polizaIndividual = polizaIndividual;
    }
    
}
