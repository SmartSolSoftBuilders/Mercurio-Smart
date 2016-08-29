package mx.com.seguros.model;

public class Promotor{
    private int cvePromotor;

    public int getCveEmpleado() {
        return cveEmpleado;
    }

    public void setCveEmpleado(int cveEmpleado) {
        this.cveEmpleado = cveEmpleado;
    }

    public int getCvePromotor() {
        return cvePromotor;
    }

    public void setCvePromotor(int cvePromotor) {
        this.cvePromotor = cvePromotor;
    }

    public String getNombrePromotor() {
        return nombrePromotor;
    }

    public void setNombrePromotor(String nombrePromotor) {
        this.nombrePromotor = nombrePromotor;
    }
    private int cveEmpleado;
    private String nombrePromotor;
}

/* Modificado por cambio de producto 26/04/2010 ***CGB***
import java.util.List;
import java.util.ArrayList;


public class Promotor extends Empleado {
	private int cvePromotor;
	
	private List<Solicitud> solicitud = new ArrayList<Solicitud>();

	public void setCvePromotor(int cvePromotor) {
		this.cvePromotor = cvePromotor;
	}

	public int getCvePromotor() {
		return this.cvePromotor;
	}
}*/