package mx.com.seguros.model;

import java.util.Date;
import mx.com.seguros.model.PolizaIndividual;
import java.util.List;
import java.util.ArrayList;

public class Asegurado {
	private Integer idAsegurado;
	private String numNominaAsegurado;
	private String RFCasegurado;
	private String apPaternoAsegurado;
	private String apMaternoAsegurado;
	private String nombre1Asegurado;
	private String nombre2Asegurado;
	private Date fechaNacimientoAsegurado;
	private String puestoAsegurado;
	private boolean sexoAseguradoMasculino;
	private String estadoCivilAsegurado;
	//private BigDecimal ingresoMensualAsegurado;
	private String ingresoMensualAsegurado;
	private Date fechaAltaDependencia;
	private int numOficioAltaDependencia;
	private Date fechaBajaDependencia;
	private int numOficioBajaDependencia;
	private String calle;
	private String edificio;
	private String numExtInt;
	private String colonia;
	private int codPostal;
	private String delegacionMpio;
	private String ciudadPoblacion;
	private String entidadFederativa;
	private int lada;
	private int telefono;
	private int numPoliza;
        private String email; 
        private String anioQuincena;
        private int numConsignatario;
        private boolean esFumadorAsegurado;
    //    private PolizaIndividual poliza=new PolizaIndividual();
        private List<PolizaIndividual> polizaindividual = new ArrayList<PolizaIndividual>();
        
         public List<PolizaIndividual> getPolizaindividual() {
        return polizaindividual;
    }

    public void setPolizaindividual(List<PolizaIndividual> polizaindividual) {
        this.polizaindividual = polizaindividual;
    }
        
   /*   public PolizaIndividual getPolizaIndividual() {
        return poliza;
    }
    
    public void setPolizaIndividual(PolizaIndividual poliza) {
        this.poliza = poliza;
    }*/

	public void setIdAsegurado(Integer idAsegurado) {
		this.idAsegurado = idAsegurado;
	}

	public Integer getIdAsegurado() {
		return this.idAsegurado;
	}

	public void setNumNominaAsegurado(String numNominaAsegurado) {
		this.numNominaAsegurado = numNominaAsegurado;
	}

	public String getNumNominaAsegurado() {
		return this.numNominaAsegurado;
	}

	public void setRFCasegurado(String RFCasegurado) {
		this.RFCasegurado = RFCasegurado;
	}

	public String getRFCasegurado() {
		return this.RFCasegurado;
	}

	public void setApPaternoAsegurado(String apPaternoAsegurado) {
		this.apPaternoAsegurado = apPaternoAsegurado;
	}

	public String getApPaternoAsegurado() {
		return this.apPaternoAsegurado;
	}

	public void setApMaternoAsegurado(String apMaternoAsegurado) {
		this.apMaternoAsegurado = apMaternoAsegurado;
	}

	public String getApMaternoAsegurado() {
		return this.apMaternoAsegurado;
	}

	public void setNombre1Asegurado(String nombre1Asegurado) {
		this.nombre1Asegurado = nombre1Asegurado;
	}

	public String getNombre1Asegurado() {
		return this.nombre1Asegurado;
	}

	public void setNombre2Asegurado(String nombre2Asegurado) {
		this.nombre2Asegurado = nombre2Asegurado;
	}

	public String getNombre2Asegurado() {
		return this.nombre2Asegurado;
	}

	public void setFechaNacimientoAsegurado(Date fechaNacimientoAsegurado) {
		this.fechaNacimientoAsegurado = fechaNacimientoAsegurado;
	}

	public Date getFechaNacimientoAsegurado() {
		return this.fechaNacimientoAsegurado;
	}

	public void setPuestoAsegurado(String puestoAsegurado) {
		this.puestoAsegurado = puestoAsegurado;
	}

	public String getPuestoAsegurado() {
		return this.puestoAsegurado;
	}



	public void setIngresoMensualAsegurado(String ingresoMensualAsegurado) {
		this.ingresoMensualAsegurado = ingresoMensualAsegurado;
	}

	public String getIngresoMensualAsegurado() {
		return this.ingresoMensualAsegurado;
	}

	public void setFechaAltaDependencia(Date fechaAltaDependencia) {
		this.fechaAltaDependencia = fechaAltaDependencia;
	}

	public Date getFechaAltaDependencia() {
		return this.fechaAltaDependencia;
	}

	public void setNumOficioAltaDependencia(int numOficioAltaDependencia) {
		this.numOficioAltaDependencia = numOficioAltaDependencia;
	}

	public int getNumOficioAltaDependencia() {
		return this.numOficioAltaDependencia;
	}

	public void setFechaBajaDependencia(Date fechaBajaDependencia) {
		this.fechaBajaDependencia = fechaBajaDependencia;
	}

	public Date getFechaBajaDependencia() {
		return this.fechaBajaDependencia;
	}

	public void setNumOficioBajaDependencia(int numOficioBajaDependencia) {
		this.numOficioBajaDependencia = numOficioBajaDependencia;
	}

	public int getNumOficioBajaDependencia() {
		return this.numOficioBajaDependencia;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getEdificio() {
		return this.edificio;
	}

	public void setNumExtInt(String numExtInt) {
		this.numExtInt = numExtInt;
	}

	public String getNumExtInt() {
		return this.numExtInt;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public int getCodPostal() {
		return this.codPostal;
	}

	public void setDelegacionMpio(String delegacionMpio) {
		this.delegacionMpio = delegacionMpio;
	}

	public String getDelegacionMpio() {
		return this.delegacionMpio;
	}

	public void setCiudadPoblacion(String ciudadPoblacion) {
		this.ciudadPoblacion = ciudadPoblacion;
	}

	public String getCiudadPoblacion() {
		return this.ciudadPoblacion;
	}

	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	public String getEntidadFederativa() {
		return this.entidadFederativa;
	}

	public void setLada(int lada) {
		this.lada = lada;
	}

	public int getLada() {
		return this.lada;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getTelefono() {
		return this.telefono;
	}

    public boolean isSexoAseguradoMasculino() {
        return sexoAseguradoMasculino;
    }

    public void setSexoAseguradoMasculino(boolean sexoAseguradoMasculino) {
        this.sexoAseguradoMasculino = sexoAseguradoMasculino;
    }

    public int getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(int numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivilAsegurado() {
        return estadoCivilAsegurado;
    }

    public void setEstadoCivilAsegurado(String estadoCivilAsegurado) {
        this.estadoCivilAsegurado = estadoCivilAsegurado;
    }    

    public String getAnioQuincena() {
        return anioQuincena;
    }

    public void setAnioQuincena(String anioQuincena) {
        this.anioQuincena = anioQuincena;
    }

    public int getNumConsignatario() {
        return numConsignatario;
    }

    public void setNumConsignatario(int numConsignatario) {
        this.numConsignatario = numConsignatario;
    }

    /**
     * @return the esFumadorAsegurado
     */
    public boolean isEsFumadorAsegurado() {
        return esFumadorAsegurado;
    }

    /**
     * @param esFumadorAsegurado the esFumadorAsegurado to set
     */
    public void setEsFumadorAsegurado(boolean esFumadorAsegurado) {
        this.esFumadorAsegurado = esFumadorAsegurado;
    }
}