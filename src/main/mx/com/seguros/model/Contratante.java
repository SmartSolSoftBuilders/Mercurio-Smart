package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Solicitud;
import java.util.ArrayList;

public class Contratante {
    private String numNominaContratante;
    private String nombre2Contratante;
    private String nombre1Contratante;
    private String apPaternoContratante;
    private String apMaternoContratante;    
    private Boolean tieneAuto=null;
    private static int numeroContratantes;
    private int numContratantes;
    private double importeTarifa;
    private String tipoMovimiento;
    //private Domicilio domicilio = new Domicilio();
        
    public String getNumNominaContratante() {
        return numNominaContratante;
    }
    
    public void setNumNominaContratante(String numNominaContratante) {
        this.numNominaContratante = numNominaContratante;
    }
    
    public void setNombre2Contratante(String nombre2Contratante) {
        this.nombre2Contratante = nombre2Contratante;
    }
    
    public String getNombre2Contratante() {
        return this.nombre2Contratante;
    }
    
    public void setNombre1Contratante(String nombre1Contratante) {
        this.nombre1Contratante = nombre1Contratante;
    }
    
    public String getNombre1Contratante() {
        return this.nombre1Contratante;
    }
    
    public void setApPaternoContratante(String apPaternoContratante) {
        this.apPaternoContratante = apPaternoContratante;
    }
    
    public String getApPaternoContratante() {
        return this.apPaternoContratante;
    }
    
    public void setApMaternoContratante(String apMaternoContratante) {
        this.apMaternoContratante = apMaternoContratante;
    }
    
    public String getApMaternoContratante() {
        return this.apMaternoContratante;
    }    
    
     public int getNumContratantes() {
        return numeroContratantes;
    }

    public void setNumContratantes(int numContratantes) {
        this.numContratantes = numContratantes;
        this.numeroContratantes = numContratantes;
    }    

    public double getImporteTarifa() {
        return importeTarifa;
    }

    public void setImporteTarifa(double importeTarifa) {
        this.importeTarifa = importeTarifa;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

	/**
	 * @return the numeroContratantes
	 */
	public static int getNumeroContratantes() {
		return numeroContratantes;
	}

	/**
	 * @param numeroContratantes the numeroContratantes to set
	 */
	public static void setNumeroContratantes(int numeroContratantes) {
		Contratante.numeroContratantes = numeroContratantes;
	}

	/**
	 * @return the tieneAuto
	 */
	public Boolean getTieneAuto() {
		return tieneAuto;
	}

	/**
	 * @param tieneAuto the tieneAuto to set
	 */
	public void setTieneAuto(Boolean tieneAuto) {
		this.tieneAuto = tieneAuto;
	}
    
}