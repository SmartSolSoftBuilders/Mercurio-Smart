package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Empresa;
import java.util.ArrayList;

public class Sucursal {
	private int cveSucursal;
	private String nombreSucursal;
	private List<Empresa> empresa = new ArrayList<Empresa>();

	public void setCveSucursal(int cveSucursal) {
		this.cveSucursal = cveSucursal;
	}

	public int getCveSucursal() {
		return this.cveSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getNombreSucursal() {
		return this.nombreSucursal;
	}
}