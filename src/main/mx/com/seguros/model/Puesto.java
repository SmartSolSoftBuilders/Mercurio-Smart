package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Empleado;
import java.util.ArrayList;

public class Puesto {
	private int cvePuesto;
	private String nombrePuesto;
	private List<Empleado> empleado = new ArrayList<Empleado>();

	public void setCvePuesto(int cvePuesto) {
		this.cvePuesto = cvePuesto;
	}

	public int getCvePuesto() {
		return this.cvePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public String getNombrePuesto() {
		return this.nombrePuesto;
	}
}