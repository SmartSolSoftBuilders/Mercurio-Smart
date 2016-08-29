package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Agente;
import java.util.ArrayList;
import mx.com.seguros.model.Promotor;

public class Empleado {
	private int cveEmpleado;
	private String apPaternoEmpleado;
	private String apMaternoEmpleado;
	private String nombre1Empleado;
	private String nombre2Empleado;
	private String RFCempleado;
        private int idEsquema;
	private mx.com.seguros.model.Puesto cvePuesto;
        private Puesto puesto=new Puesto();
	private Integer idPlaza;
        private List<Solicitud> solicitud = new ArrayList<Solicitud>();
	private List<Agente> agente = new ArrayList<Agente>();
	private List<Promotor> promotor = new ArrayList<Promotor>();
        
	public String getNombreCompleto(){
		if(apPaternoEmpleado == null){
			return null;
		}
		return apPaternoEmpleado + " " + apMaternoEmpleado + " " +
				(nombre1Empleado!=null?nombre1Empleado:"") + " " +
				(nombre2Empleado!=null?nombre2Empleado:"");
	}
	public void setNombreCompleto(){
		
	}
	
	public void setCveEmpleado(int cveEmpleado) {
		this.cveEmpleado = cveEmpleado;
	}

	public int getCveEmpleado() {
		return this.cveEmpleado;
	}

	public void setApPaternoEmpleado(String apPaternoEmpleado) {
		this.apPaternoEmpleado = apPaternoEmpleado;
	}

	public String getApPaternoEmpleado() {
		return this.apPaternoEmpleado;
	}

	public void setApMaternoEmpleado(String apMaternoEmpleado) {
		this.apMaternoEmpleado = apMaternoEmpleado;
	}

	public String getApMaternoEmpleado() {
		return this.apMaternoEmpleado;
	}

	public void setNombre1Empleado(String nombre1Empleado) {
		this.nombre1Empleado = nombre1Empleado;
	}

	public String getNombre1Empleado() {
		return this.nombre1Empleado;
	}

	public void setNombre2Empleado(String nombre2Empleado) {
		this.nombre2Empleado = nombre2Empleado;
	}

	public String getNombre2Empleado() {
		return this.nombre2Empleado;
	}

	public void setRFCempleado(String RFCempleado) {
		this.RFCempleado = RFCempleado;
	}

	public String getRFCempleado() {
		return this.RFCempleado;
	}

    public int getIdEsquema() {
        return idEsquema;
    }

    public void setIdEsquema(int idEsquema) {
        this.idEsquema = idEsquema;
    }
    
    public Puesto getPuesto(){
        return puesto;
    }
    
    public void setPuesto(Puesto puesto){
        this.puesto = puesto;
    }

	/**
	 * Método de acceso al campo idPlaza.
	 * @return El valor del campo idPlaza
	 */
	public Integer getIdPlaza() {
		return idPlaza;
	}

	/**
	 * Asigna el valor al campo idPlaza.
	 * @param idPlaza el valor idPlaza a asignar
	 */
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}
}