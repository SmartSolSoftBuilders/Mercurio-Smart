package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Solicitud;
import java.util.ArrayList;

public class Empresa {
    private Integer cveEmpresa;
    private String nombreEmpresa;
    private Integer cveGrupoAsegurado;
    private Integer cveSucursal;
    private Integer cveColonia;
    private Integer cveTurno;
    private GrupoAsegurado grupoAsegurado=new GrupoAsegurado();
    private Sucursal sucursal = new Sucursal();
    private Colonia colonia = new Colonia ();
    private TurnoEmpresa turnoEmpresa = new TurnoEmpresa ();
    private TipoEmpresa tipoEmpresa = new TipoEmpresa();
    
    private List<Solicitud> solicitud = new ArrayList<Solicitud>();
    
    public void setCveEmpresa(Integer cveEmpresa) {
        this.cveEmpresa = cveEmpresa;
    }
    
    public Integer getCveEmpresa() {
        return this.cveEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    public GrupoAsegurado getGrupoAsegurado() {
        return grupoAsegurado;
    }
    
    public void setGrupoAsegurado(GrupoAsegurado grupoAsegurado) {
        this.grupoAsegurado = grupoAsegurado;
    }
    
    public Sucursal getSucursal() {
        return sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public Colonia getColonia() {
        return colonia;
    }
    
    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public Integer getCveGrupoAsegurado() {
        return cveGrupoAsegurado;
    }

    public void setCveGrupoAsegurado(Integer cveGrupoAsegurado) {
        this.cveGrupoAsegurado = cveGrupoAsegurado;
    }

    public Integer getCveSucursal() {
        return cveSucursal;
    }

    public void setCveSucursal(Integer cveSucursal) {
        this.cveSucursal = cveSucursal;
    }

    public Integer getCveColonia() {
        return cveColonia;
    }

    public void setCveColonia(Integer cveColonia) {
        this.cveColonia = cveColonia;
    }

    public List<Solicitud> getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(List<Solicitud> solicitud) {
        this.solicitud = solicitud;
    }

    public TurnoEmpresa getTurnoEmpresa() {
        return turnoEmpresa;
    }

    public void setTurnoEmpresa(TurnoEmpresa turnoEmpresa) {
        this.turnoEmpresa = turnoEmpresa;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

	/**
	 * @return the cveTurno
	 */
	public Integer getCveTurno() {
		return cveTurno;
	}

	/**
	 * @param cveTurno the cveTurno to set
	 */
	public void setCveTurno(Integer cveTurno) {
		this.cveTurno = cveTurno;
	}
    
}