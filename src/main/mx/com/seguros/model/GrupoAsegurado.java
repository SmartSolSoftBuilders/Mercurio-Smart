package mx.com.seguros.model;

import java.util.ArrayList;
import java.util.List;


public class GrupoAsegurado {
	private int cveGrupoAsegurado;
	private String nombreGrupoAsegurado;
        private int cveRetenedor;
        private Retenedor retenedor = new Retenedor();
	private List<Empresa> empresa = new ArrayList<Empresa>();
	private Integer idPlaza;
	private Plaza plaza;


	public void setCveGrupoAsegurado(int cveGrupoAsegurado) {
		this.cveGrupoAsegurado = cveGrupoAsegurado;
	}

	public int getCveGrupoAsegurado() {
		return this.cveGrupoAsegurado;
	}

	public void setNombreGrupoAsegurado(String nombreGrupoAsegurado) {
		this.nombreGrupoAsegurado = nombreGrupoAsegurado;
	}

	public String getNombreGrupoAsegurado() {
		return this.nombreGrupoAsegurado;
	}

    public int getCveRetenedor() {
        return cveRetenedor;
    }

    public void setCveRetenedor(int cveRetenedor) {
        this.cveRetenedor = cveRetenedor;
    }

    public Retenedor getRetenedor() {
        return retenedor;
    }

    public void setRetenedor(Retenedor retenedor) {
        this.retenedor = retenedor;
    }

	/**
	 * @return the idPlaza
	 */
	public Integer getIdPlaza() {
		return idPlaza;
	}

	/**
	 * @param idPlaza the idPlaza to set
	 */
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}

	/**
	 * @return the plaza
	 */
	public Plaza getPlaza() {
		return plaza;
	}

	/**
	 * @param plaza the plaza to set
	 */
	public void setPlaza(Plaza plaza) {
		this.plaza = plaza;
	}
}