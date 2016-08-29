package mx.com.seguros.model;

import java.util.List;
import mx.com.seguros.model.Solicitud;
import mx.com.seguros.model.ProduccionQuincenaPuntosAgente;
import java.util.ArrayList;

public class Agente extends Empleado{
	private Integer cveAgente;
        private int tipoAgente;
	private Empleado empleado=new Empleado();
        private int cveGerente;
        private int cveSupervisor;
	private List<Solicitud> solicitud = new ArrayList<Solicitud>();
        private ProduccionQuincenaPuntosAgente produccion=new ProduccionQuincenaPuntosAgente();

	public void setCveAgente(Integer cveAgente) {
		this.cveAgente = cveAgente;
	}

	public Integer getCveAgente() {
		return this.cveAgente;
	}

    public int getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(int tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getCveGerente() {
        return cveGerente;
    }

    public void setCveGerente(int cveGerente) {
        this.cveGerente = cveGerente;
    }

    public int getCveSupervisor() {
        return cveSupervisor;
    }

    public void setCveSupervisor(int cveSupervisor) {
        this.cveSupervisor = cveSupervisor;
    }

    public ProduccionQuincenaPuntosAgente getProduccion() {
        return produccion;
    }

    public void setProduccion(ProduccionQuincenaPuntosAgente produccion) {
        this.produccion = produccion;
    }
        
}