package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Empresa;
import java.util.ArrayList;

public class Colonia {
	private int cveColonia;
	private String tipoAsentamiento;
	private String asentamiento;
	private String municipio;
	private String estado;
	private List<Empresa> empresa = new ArrayList<Empresa>();

	public void setCveColonia(int cveColonia) {
		this.cveColonia = cveColonia;
	}

	public int getCveColonia() {
		return this.cveColonia;
	}

	public void setTipoAsentamiento(String tipoAsentamiento) {
		this.tipoAsentamiento = tipoAsentamiento;
	}

	public String getTipoAsentamiento() {
		return this.tipoAsentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getAsentamiento() {
		return this.asentamiento;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}
}