package mx.com.seguros.model;

import java.util.Date;

public class Solicitud {
    public static int NUM_MAX_BENEFICIARIOS = 8;
    
    public static String[] FORMATOS_SOLICITUD = new String[]{"F-278-2","F-2111-1"};
    
    private Integer cveAgente;
    private Integer cveTarifa;
    private Integer cvePromotor;
    private Integer folioSolicitud;
    private String formatoSolicitud;
	private Integer cveEmpresa;
    private Integer idEstatusSolicitud;
    private String numNominaContratante;
    private String RFCsolicitante;
    
    private Date fechaSolicitud;
    private Boolean tipoSolicitudNormal = true;
//    private String tipoSolicitudNormal = null;
    private Date fechaCaptura;
    private Empleado empleado = new Empleado();
    private Agente agente = new Agente();
    private Promotor promotor = new Promotor();
    private TarifaAportMensual tarifa = new TarifaAportMensual();
    private Empresa empresa = new Empresa();
    private Contratante contratante = new Contratante();
    private Solicitante solicitante = new Solicitante();
    private EstatusSolicitud estatusSolicitud = new EstatusSolicitud();
    private Beneficiario[] beneficiario = new Beneficiario[NUM_MAX_BENEFICIARIOS];    
    private String tipoMovimiento;
    //private List<CertificadoIndividual> certificadoindividual = new ArrayList<CertificadoIndividual>();
    private CertificadoIndividual certificadoindividual = new CertificadoIndividual();
    //private PolizaIndividual polizaindividual = new PolizaIndividual();
   // private List<Beneficiario> beneficiario = new ArrayList<Beneficiario>();
    
    private String claveUsuarioRegistro;
    private String claveUsuarioModificacion;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private Date fechaProduccion;
    
   
    
    private Double tarifaTotal;
    
    private Long cveAgenteInbursa = null;
    private Float porcentajeComisionPromotor = new Float(0.0);
    private Float porcentajeComisionAgenteInbursa = new Float(0.0);
    
    
    
    
    
    /**
	 * @return the formatoSolicitud
	 */
	public String getFormatoSolicitud() {
		return formatoSolicitud;
	}

	/**
	 * @param formatoSolicitud the formatoSolicitud to set
	 */
	public void setFormatoSolicitud(String formatoSolicitud) {
		this.formatoSolicitud = formatoSolicitud;
	}


    /**
     * @return the cveAgente
     */
    public Integer getCveAgente() {
        return cveAgente;
    }

    /**
     * @param cveAgente the cveAgente to set
     */
    public void setCveAgente(Integer cveAgente) {
        this.cveAgente = cveAgente;
    }

    /**
     * @return the cveTarifa
     */
    public Integer getCveTarifa() {
        return cveTarifa;
    }

    /**
     * @param cveTarifa the cveTarifa to set
     */
    public void setCveTarifa(Integer cveTarifa) {
        this.cveTarifa = cveTarifa;
    }

    /**
     * @return the cvePromotor
     */
    public Integer getCvePromotor() {
        return cvePromotor;
    }

    /**
     * @param cvePromotor the cvePromotor to set
     */
    public void setCvePromotor(Integer cvePromotor) {
        this.cvePromotor = cvePromotor;
    }

    /**
     * @return the folioSolicitud
     */
    public Integer getFolioSolicitud() {
        return folioSolicitud;
    }

    /**
     * @param folioSolicitud the folioSolicitud to set
     */
    public void setFolioSolicitud(Integer folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

    /**
     * @return the cveEmpresa
     */
    public Integer getCveEmpresa() {
        return cveEmpresa;
    }

    /**
     * @param cveEmpresa the cveEmpresa to set
     */
    public void setCveEmpresa(Integer cveEmpresa) {
        this.cveEmpresa = cveEmpresa;
    }

    /**
     * @return the idEstatusSolicitud
     */
    public Integer getIdEstatusSolicitud() {
        return idEstatusSolicitud;
    }

    /**
     * @param idEstatusSolicitud the idEstatusSolicitud to set
     */
    public void setIdEstatusSolicitud(Integer idEstatusSolicitud) {
        this.idEstatusSolicitud = idEstatusSolicitud;
    }

    /**
     * @return the numNominaContratante
     */
    public String getNumNominaContratante() {
        return numNominaContratante;
    }

    /**
     * @param numNominaContratante the numNominaContratante to set
     */
    public void setNumNominaContratante(String numNominaContratante) {
        this.numNominaContratante = numNominaContratante;
    }

    /**
     * @return the RFCsolicitante
     */
    public String getRFCsolicitante() {
        return RFCsolicitante;
    }

    /**
     * @param RFCsolicitante the RFCsolicitante to set
     */
    public void setRFCsolicitante(String RFCsolicitante) {
        this.RFCsolicitante = RFCsolicitante;
    }

    

    

    /**
     * @return the tipoSolicitudNormal
     */
    public Boolean getTipoSolicitudNormal() {
        return tipoSolicitudNormal;
    }

    /**
     * @param tipoSolicitudNormal the tipoSolicitudNormal to set
     */
    public void setTipoSolicitudNormal(Boolean tipoSolicitudNormal) {
        this.tipoSolicitudNormal = tipoSolicitudNormal;
    }

    /**
     * @return the fechaCaptura
     */
    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    /**
     * @param fechaCaptura the fechaCaptura to set
     */
    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the agente
     */
    public Agente getAgente() {
        return agente;
    }

    /**
     * @param agente the agente to set
     */
    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    /**
     * @return the promotor
     */
    public Promotor getPromotor() {
        return promotor;
    }

    /**
     * @param promotor the promotor to set
     */
    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    /**
     * @return the tarifa
     */
    public TarifaAportMensual getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(TarifaAportMensual tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the contratante
     */
    public Contratante getContratante() {
        return contratante;
    }

    /**
     * @param contratante the contratante to set
     */
    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    /**
     * @return the solicitante
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }

    /**
     * @param solicitante the solicitante to set
     */
    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    /**
     * @return the estatussolicitud
     */
    public EstatusSolicitud getEstatusSolicitud() {
        return estatusSolicitud;
    }

    /**
     * @param estatussolicitud the estatussolicitud to set
     */
    public void setEstatusSolicitud(EstatusSolicitud estatussolicitud) {
        this.estatusSolicitud = estatussolicitud;
    }

    /**
     * @return the beneficiario
     */
    public Beneficiario[] getBeneficiario() {
        return beneficiario;
    }

    /**
     * @param beneficiario the beneficiario to set
     */
    public void setBeneficiario(Beneficiario[] beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * @return the tipoMovimiento
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * @param tipoMovimiento the tipoMovimiento to set
     */
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * @return the certificadoindividual
     */
    public CertificadoIndividual getCertificadoindividual() {
        return certificadoindividual;
    }

    /**
     * @param certificadoindividual the certificadoindividual to set
     */
    public void setCertificadoindividual(CertificadoIndividual certificadoindividual) {
        this.certificadoindividual = certificadoindividual;
    }

    

	/**
	 * Método de acceso al campo claveUsuarioRegistro.
	 * @return El valor del campo claveUsuarioRegistro
	 */
	public String getClaveUsuarioRegistro() {
		return claveUsuarioRegistro;
	}

	/**
	 * Asigna el valor al campo claveUsuarioRegistro.
	 * @param claveUsuarioRegistro el valor claveUsuarioRegistro a asignar
	 */
	public void setClaveUsuarioRegistro(String claveUsuarioRegistro) {
		this.claveUsuarioRegistro = claveUsuarioRegistro;
	}

	/**
	 * Método de acceso al campo claveUsuarioModificacion.
	 * @return El valor del campo claveUsuarioModificacion
	 */
	public String getClaveUsuarioModificacion() {
		return claveUsuarioModificacion;
	}

	/**
	 * Asigna el valor al campo claveUsuarioModificacion.
	 * @param claveUsuarioModificacion el valor claveUsuarioModificacion a asignar
	 */
	public void setClaveUsuarioModificacion(String claveUsuarioModificacion) {
		this.claveUsuarioModificacion = claveUsuarioModificacion;
	}

	/**
	 * Método de acceso al campo fechaRegistro.
	 * @return El valor del campo fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Asigna el valor al campo fechaRegistro.
	 * @param fechaRegistro el valor fechaRegistro a asignar
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Método de acceso al campo fechaModificacion.
	 * @return El valor del campo fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Asigna el valor al campo fechaModificacion.
	 * @param fechaModificacion el valor fechaModificacion a asignar
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método de acceso al campo fechaProduccion.
	 * @return El valor del campo fechaProduccion
	 */
	public Date getFechaProduccion() {
		return fechaProduccion;
	}

	/**
	 * Asigna el valor al campo fechaProduccion.
	 * @param fechaProduccion el valor fechaProduccion a asignar
	 */
	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	/**
	 * @return the tarifaTotal
	 */
	public Double getTarifaTotal() {
		return tarifaTotal;
	}

	/**
	 * @param tarifaTotal the tarifaTotal to set
	 */
	public void setTarifaTotal(Double tarifaTotal) {
		this.tarifaTotal = tarifaTotal;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the cveAgenteInbursa
	 */
	public Long getCveAgenteInbursa() {
		return cveAgenteInbursa;
	}

	/**
	 * @param cveAgenteInbursa the cveAgenteInbursa to set
	 */
	public void setCveAgenteInbursa(Long cveAgenteInbursa) {
		this.cveAgenteInbursa = cveAgenteInbursa;
	}

	/**
	 * @return the porcentajeComisionPromotor
	 */
	public Float getPorcentajeComisionPromotor() {
		return porcentajeComisionPromotor;
	}

	/**
	 * @param porcentajeComisionPromotor the porcentajeComisionPromotor to set
	 */
	public void setPorcentajeComisionPromotor(Float porcentajeComisionPromotor) {
		this.porcentajeComisionPromotor = porcentajeComisionPromotor;
	}

	/**
	 * @return the porcentajeComisionAgenteInbursa
	 */
	public Float getPorcentajeComisionAgenteInbursa() {
		return porcentajeComisionAgenteInbursa;
	}

	/**
	 * @param porcentajeComisionAgenteInbursa the porcentajeComisionAgenteInbursa to set
	 */
	public void setPorcentajeComisionAgenteInbursa(
			Float porcentajeComisionAgenteInbursa) {
		this.porcentajeComisionAgenteInbursa = porcentajeComisionAgenteInbursa;
	}
    
   
    
}