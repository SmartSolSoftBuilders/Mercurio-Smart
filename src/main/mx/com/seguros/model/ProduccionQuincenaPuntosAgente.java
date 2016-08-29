/*
 * ProduccionQuincenaPuntosAgente.java
 *
 * Created on 24 de marzo de 2008, 03:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mx.com.seguros.model;

import java.util.ArrayList;
import java.util.List;
import mx.com.seguros.model.Agente;
/**
 *
 * @author QTX
 */
public class ProduccionQuincenaPuntosAgente {
    
    private int cveAgente;
    private int anoQuincenaComision;
    private int numQuincenaComision;
    private int indicadorCalculoAsignacionBonoTrim;
    private int totalProduccionPuntos;
    private List<Agente> agente = new ArrayList<Agente>();
    private double reservaBonoTrim;
    /** Creates a new instance of ProduccionQuincenaPuntosAgente */
    public ProduccionQuincenaPuntosAgente() {
    }

    public int getCveAgente() {
        return cveAgente;
    }

    public void setCveAgente(int cveAgente) {
        this.cveAgente = cveAgente;
    }

    public int getAnoQuincenaComision() {
        return anoQuincenaComision;
    }

    public void setAnoQuincenaComision(int anoQuincenaComision) {
        this.anoQuincenaComision = anoQuincenaComision;
    }

    public int getNumQuincenaComision() {
        return numQuincenaComision;
    }

    public void setNumQuincenaComision(int numQuincenaComision) {
        this.numQuincenaComision = numQuincenaComision;
    }

    public int getIndicadorCalculoAsignacionBonoTrim() {
        return indicadorCalculoAsignacionBonoTrim;
    }

    public void setIndicadorCalculoAsignacionBonoTrim(int indicadorCalculoAsignacionBonoTrim) {
        this.indicadorCalculoAsignacionBonoTrim = indicadorCalculoAsignacionBonoTrim;
    }

    public int getTotalProduccionPuntos() {
        return totalProduccionPuntos;
    }

    public void setTotalProduccionPuntos(int totalProduccionPuntos) {
        this.totalProduccionPuntos = totalProduccionPuntos;
    }

    public double getReservaBonoTrim() {
        return reservaBonoTrim;
    }

    public void setReservaBonoTrim(double reservaBonoTrim) {
        this.reservaBonoTrim = reservaBonoTrim;
    }

    public List<Agente> getAgente() {
        return agente;
    }

    public void setAgente(List<Agente> agente) {
        this.agente = agente;
    }

    
}
