package mx.com.seguros.model;

import java.util.Date;
import java.util.List;

public class PolizaIndividual {
	
	
	public PolizaIndividual(){}
	
	public PolizaIndividual(Integer numPoliza, Integer numConsignatario){
		this.numPoliza = numPoliza;
		this.numConsignatario = numConsignatario;
	}
	
    private Integer numPoliza;
    private Integer numPolizaCambio;
    private Integer numConsignatario;
    private Integer numConsignatarioCambio;
    private Date fechaInicioVigencia;
    private Date fechaFinVigencia;
    private Double sumaAseguradaIndividual;
    private Date fechaExpedicion;
    private Solicitud solicitud=new Solicitud();
    private Integer folioSolicitud;
    private String formatoSolicitud;
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

	private String tipoSeguro;
    private Integer agrupacionCIS;
    private Integer idEstatusPolizaSeguimiento;
    private String nombrePersonaRecibe;
    private Date fechaRecepcionPoliza;
    private Integer idEstatusPagosPoliza;
    private Integer indicadorPagoComisionEntregaPoliza;
    private Integer indicadorDescuentoComision;
    private Date fechaCancelacion;
    private Date fechaEntregaAgente;
    //HEFS Datos para consulta de polizas emitidas entregadas al agente
    private Integer numCertificado;
    private String cvePlaza;
    private String descripcionTipoSeguro;
  //  private List<Asegurado> asegurado = new ArrayList<Asegurado>();
    private Asegurado asegurado=new Asegurado();
    private EstatusPolizaSeguimiento estatusPolizaSeguimiento = new EstatusPolizaSeguimiento ();
    private EstatusPolizaPagos estatusPolizaPagos = new EstatusPolizaPagos ();
    private Integer numQuincena;
    private Integer anoQuincena;
    private String tipoMovimientoPoliza;
    private String tipoMovimientoPolizaCambio;
    private String qnaProgEnvioMvtoPoliza;

    private Double sumaGastosFunerarios;
    private Double sumaSEVI;
    private Double sumaBAF;
    private Double sumaDI;
    private Double sumaPM;
    private Double sumaBITP;
    private Double sumaCPF;
    private Integer plazoSeguro;
    
    private String descripcionPaqueteVidadxn;
    
    
    private List<BeneficioAdicionalPoliza> beneficiosAdicionales;
    
    private Double sumaAseguradaTotal;
    
    private Double montoCoberturaBeneficios;
    
    
    private Integer agrupacion = null;
    
    private Date fechaSolicitudCancelacion = null;
    
    private Date fechaCancelacionDescuento = null;
    
    private ProductosInburnomina productosInburnomina = null;
    
    private Double importeAhorroAdicionalMensual = null;
    /**
     * Estatus general de la poliza (Cancelaga o Vigente)
     */
    private Integer idEstatusPolizaGeneral = null;
    private EstatusPolizaGeneral estatusPolizaGeneral = new EstatusPolizaGeneral();
    /**
     * Número de quincena de último descuento capturada por mesa de control
     */
    private Integer numQuincenaUltimoDescuento = null;
    
    /**
     * JLVO: Año de quincena de último descuento capturada por mesa de control
     */
    private Integer anhoUltimoDescuento = null;    
    
    
    public Double getTotalProteccion(){
    	return sumaGastosFunerarios+sumaSEVI + 
    	(sumaBAF != null?sumaBAF.doubleValue():0)+
    	(sumaCPF != null?sumaCPF.doubleValue():0);
    }
    
    public void setNumCertificado(Integer numCertificado){
        this.numCertificado=numCertificado;
    }
    
    public Integer getNumCertificado(){
        return this.numCertificado;
    }
    
    public void setCvePlaza(String cvePlaza){
        this.cvePlaza=cvePlaza;
    }
    
    public String getCvePlaza(){
        return this.cvePlaza;
    }
    
     
    public Integer getNumPoliza() {
        return numPoliza;
    }
    
    public void setNumPoliza(Integer numPoliza) {
        this.numPoliza = numPoliza;
    }
    
    public Integer getNumConsignatario() {
        return numConsignatario;
    }
    
    public void setNumConsignatario(Integer numConsignatario) {
        this.numConsignatario = numConsignatario;
    }
    
    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    
    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
    
    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }
    
    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }
    
    public Double getSumaAseguradaIndividual() {
        return sumaAseguradaIndividual;
    }
    
    public void setSumaAseguradaIndividual(Double sumaAseguradaIndividual) {
        this.sumaAseguradaIndividual = sumaAseguradaIndividual;
    }
    
    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }
    
    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    public Solicitud getSolicitud() {
        return solicitud;
    }
    
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
     public Asegurado getAsegurado () {
        return asegurado;
    }
    public void setAsegurado(Asegurado asegurado) {
        this.asegurado = asegurado;
    }
    
    public Integer getFolioSolicitud() {
        return folioSolicitud;
    }
    
    public void setFolioSolicitud(Integer folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }
    
    public String getTipoSeguro() {
        return tipoSeguro;
    }
    
    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
    
    public Integer getAgrupacionCIS() {
        return agrupacionCIS;
    }
    
    public void setAgrupacionCIS(Integer agrupacionCIS) {
        this.agrupacionCIS = agrupacionCIS;
    }
    
     public Integer getIdEstatusPolizaSeguimiento() {
        return idEstatusPolizaSeguimiento;
    }
    
    public void setIdEstatusPolizaSeguimiento(Integer idEstatusPolizaSeguimiento) {
        this.idEstatusPolizaSeguimiento = idEstatusPolizaSeguimiento;
    }
    
    public void setNombrePersonaRecibe(String nombrePersonaRecibe){
        this.nombrePersonaRecibe=nombrePersonaRecibe;
    }
    
    public String getNombrePersonaRecibe(){
        return nombrePersonaRecibe;
    }
    public void setFechaRecepcionPoliza(Date fechaRecepcionPoliza){
        this.fechaRecepcionPoliza=fechaRecepcionPoliza;
    }
    
    public Date getFechaRecepcionPoliza(){
        return fechaRecepcionPoliza;
    }

    public Integer getNumQuincena() {
        return numQuincena;
    }

    public void setNumQuincena(Integer numQuincena) {
        this.numQuincena = numQuincena;
    }

    public Integer getAnoQuincena() {
        return anoQuincena;
    }

    public void setAnoQuincena(Integer anoQuincena) {
        this.anoQuincena = anoQuincena;
    }

    public Integer getIdEstatusPagosPoliza() {
        return idEstatusPagosPoliza;
    }

    public void setIdEstatusPagosPoliza(Integer idEstatusPagosPoliza) {
        this.idEstatusPagosPoliza = idEstatusPagosPoliza;
    }

    public EstatusPolizaSeguimiento getEstatusPolizaSeguimiento() {
        return estatusPolizaSeguimiento;
    }

    public void setEstatusPolizaSeguimiento(EstatusPolizaSeguimiento estatusPolizaSeguimiento) {
        this.estatusPolizaSeguimiento = estatusPolizaSeguimiento;
    }

    public EstatusPolizaPagos getEstatusPolizaPagos() {
        return estatusPolizaPagos;
    }

    public void setEstatusPolizaPagos(EstatusPolizaPagos estatusPolizaPagos) {
        this.estatusPolizaPagos = estatusPolizaPagos;
    }

    public Integer getIndicadorPagoComisionEntregaPoliza() {
        return indicadorPagoComisionEntregaPoliza;
    }

    public void setIndicadorPagoComisionEntregaPoliza(Integer indicadorPagoComisionEntregaPoliza) {
        this.indicadorPagoComisionEntregaPoliza = indicadorPagoComisionEntregaPoliza;
    }

    public Integer getIndicadorDescuentoComision() {
        return indicadorDescuentoComision;
    }

    public void setIndicadorDescuentoComision(Integer indicadorDescuentoComision) {
        this.indicadorDescuentoComision = indicadorDescuentoComision;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Date getFechaEntregaAgente() {
        return fechaEntregaAgente;
    }

    public void setFechaEntregaAgente(Date fechaEntregaAgente) {
        this.fechaEntregaAgente = fechaEntregaAgente;
    }

    public String getTipoMovimientoPoliza() {
        return tipoMovimientoPoliza;
    }

    public void setTipoMovimientoPoliza(String tipoMovimientoPoliza) {
        this.tipoMovimientoPoliza = tipoMovimientoPoliza;
    }

    public Integer getNumPolizaCambio() {
        return numPolizaCambio;
    }

    public void setNumPolizaCambio(Integer numPolizaCambio) {
        this.numPolizaCambio = numPolizaCambio;
    }

    public Integer getNumConsignatarioCambio() {
        return numConsignatarioCambio;
    }

    public void setNumConsignatarioCambio(Integer numConsignatarioCambio) {
        this.numConsignatarioCambio = numConsignatarioCambio;
    }

    public String getTipoMovimientoPolizaCambio() {
        return tipoMovimientoPolizaCambio;
    }

    public void setTipoMovimientoPolizaCambio(String tipoMovimientoPolizaCambio) {
        this.tipoMovimientoPolizaCambio = tipoMovimientoPolizaCambio;
    }

    public String getQnaProgEnvioMvtoPoliza() {
        return qnaProgEnvioMvtoPoliza;
    }

    public void setQnaProgEnvioMvtoPoliza(String qnaProgEnvioMvtoPoliza) {
        this.qnaProgEnvioMvtoPoliza = qnaProgEnvioMvtoPoliza;
    }

    public Double getSumaGastosFunerarios() {
        return sumaGastosFunerarios;
    }

    public void setSumaGastosFunerarios(Double sumaGastosFunerarios) {
        this.sumaGastosFunerarios = sumaGastosFunerarios;
    }

    public Double getSumaSEVI() {
        return sumaSEVI;
    }

    public void setSumaSEVI(Double sumaSEVI) {
        this.sumaSEVI = sumaSEVI;
    }

    /**
     * @return the sumaBAF
     */
    public Double getSumaBAF() {
        return sumaBAF;
    }

    /**
     * @param sumaBAF the sumaBAF to set
     */
    public void setSumaBAF(Double sumaBAF) {
        this.sumaBAF = sumaBAF;
    }
    
    

    public Double getSumaDI() {
		return sumaDI;
	}

	public void setSumaDI(Double sumaDI) {
		this.sumaDI = sumaDI;
	}

	public Double getSumaPM() {
		return sumaPM;
	}

	public void setSumaPM(Double sumaPM) {
		this.sumaPM = sumaPM;
	}

	public Double getSumaBITP() {
		return sumaBITP;
	}

	public void setSumaBITP(Double sumaBITP) {
		this.sumaBITP = sumaBITP;
	}

	/**
     * @return the sumaCPF
     */
    public Double getSumaCPF() {
        return sumaCPF;
    }

    /**
     * @param sumaCPF the sumaCPF to set
     */
    public void setSumaCPF(Double sumaCPF) {
        this.sumaCPF = sumaCPF;
    }

    /**
     * @return the plazoSeguro
     */
    public Integer getPlazoSeguro() {
        return plazoSeguro;
    }

    /**
     * @param plazoSeguro the plazoSeguro to set
     */
    public void setPlazoSeguro(Integer plazoSeguro) {
        this.plazoSeguro = plazoSeguro;
    }

	/**
	 * Método de acceso al campo beneficiosAdicionales.
	 * @return El valor del campo beneficiosAdicionales
	 */
	public List<BeneficioAdicionalPoliza> getBeneficiosAdicionales() {
		return beneficiosAdicionales;
	}

	/**
	 * Asigna el valor al campo beneficiosAdicionales.
	 * @param beneficiosAdicionales el valor beneficiosAdicionales a asignar
	 */
	public void setBeneficiosAdicionales(
			List<BeneficioAdicionalPoliza> beneficiosAdicionales) {
		this.beneficiosAdicionales = beneficiosAdicionales;
	}

	/**
	 * Método de acceso al campo descripcionTipoSeguro.
	 * @return El valor del campo descripcionTipoSeguro
	 */
	public String getDescripcionTipoSeguro() {
		return descripcionTipoSeguro;
	}

	/**
	 * Asigna el valor al campo descripcionTipoSeguro.
	 * @param descripcionTipoSeguro el valor descripcionTipoSeguro a asignar
	 */
	public void setDescripcionTipoSeguro(String descripcionTipoSeguro) {
		this.descripcionTipoSeguro = descripcionTipoSeguro;
	}

	

	/**
	 * Método de acceso al campo descripcionPaqueteVidadxn.
	 * @return El valor del campo descripcionPaqueteVidadxn
	 */
	public String getDescripcionPaqueteVidadxn() {
		return descripcionPaqueteVidadxn;
	}

	/**
	 * Asigna el valor al campo descripcionPaqueteVidadxn.
	 * @param descripcionPaqueteVidadxn el valor descripcionPaqueteVidadxn a asignar
	 */
	public void setDescripcionPaqueteVidadxn(String descripcionPaqueteVidadxn) {
		this.descripcionPaqueteVidadxn = descripcionPaqueteVidadxn;
	}

	/**
	 * @return the sumaAseguradaTotal
	 */
	public Double getSumaAseguradaTotal() {
		return sumaAseguradaTotal;
	}

	/**
	 * @param sumaAseguradaTotal the sumaAseguradaTotal to set
	 */
	public void setSumaAseguradaTotal(Double sumaAseguradaTotal) {
		this.sumaAseguradaTotal = sumaAseguradaTotal;
	}

	/**
	 * @return the montoCoberturaBeneficios
	 */
	public Double getMontoCoberturaBeneficios() {
		return montoCoberturaBeneficios;
	}

	/**
	 * @param montoCoberturaBeneficios the montoCoberturaBeneficios to set
	 */
	public void setMontoCoberturaBeneficios(Double montoCoberturaBeneficios) {
		this.montoCoberturaBeneficios = montoCoberturaBeneficios;
	}

	/**
	 * @return the agrupacion
	 */
	public Integer getAgrupacion() {
		return agrupacion;
	}

	/**
	 * @param agrupacion the agrupacion to set
	 */
	public void setAgrupacion(Integer agrupacion) {
		this.agrupacion = agrupacion;
	}

	/**
	 * @return the fechaSolicitudCancelacion
	 */
	public Date getFechaSolicitudCancelacion() {
		return fechaSolicitudCancelacion;
	}

	/**
	 * @param fechaSolicitudCancelacion the fechaSolicitudCancelacion to set
	 */
	public void setFechaSolicitudCancelacion(Date fechaSolicitudCancelacion) {
		this.fechaSolicitudCancelacion = fechaSolicitudCancelacion;
	}

	/**
	 * @return the fechaCancelacionDescuento
	 */
	public Date getFechaCancelacionDescuento() {
		return fechaCancelacionDescuento;
	}

	/**
	 * @param fechaCancelacionDescuento the fechaCancelacionDescuento to set
	 */
	public void setFechaCancelacionDescuento(Date fechaCancelacionDescuento) {
		this.fechaCancelacionDescuento = fechaCancelacionDescuento;
	}

	/**
	 * @return the productosInburnomina
	 */
	public ProductosInburnomina getProductosInburnomina() {
		return productosInburnomina;
	}

	/**
	 * @param productosInburnomina the productosInburnomina to set
	 */
	public void setProductosInburnomina(ProductosInburnomina productosInburnomina) {
		this.productosInburnomina = productosInburnomina;
	}

	/**
	 * @return the importeAhorroAdicionalMensual
	 */
	public Double getImporteAhorroAdicionalMensual() {
		return importeAhorroAdicionalMensual;
	}

	/**
	 * @param importeAhorroAdicionalMensual the importeAhorroAdicionalMensual to set
	 */
	public void setImporteAhorroAdicionalMensual(
			Double importeAhorroAdicionalMensual) {
		this.importeAhorroAdicionalMensual = importeAhorroAdicionalMensual;
	}

	/**
	 * @return the idEstatusPolizaGeneral
	 */
	public Integer getIdEstatusPolizaGeneral() {
		return idEstatusPolizaGeneral;
	}

	/**
	 * @param idEstatusPolizaGeneral the idEstatusPolizaGeneral to set
	 */
	public void setIdEstatusPolizaGeneral(Integer idEstatusPolizaGeneral) {
		this.idEstatusPolizaGeneral = idEstatusPolizaGeneral;
	}

	/**
	 * @return the estatusPolizaGeneral
	 */
	public EstatusPolizaGeneral getEstatusPolizaGeneral() {
		return estatusPolizaGeneral;
	}

	/**
	 * @param estatusPolizaGeneral the estatusPolizaGeneral to set
	 */
	public void setEstatusPolizaGeneral(EstatusPolizaGeneral estatusPolizaGeneral) {
		this.estatusPolizaGeneral = estatusPolizaGeneral;
	}

	/**
	 * @return the numQuincenaUltimoDescuento
	 */
	public Integer getNumQuincenaUltimoDescuento() {
		return numQuincenaUltimoDescuento;
	}

	/**
	 * @param numQuincenaUltimoDescuento the numQuincenaUltimoDescuento to set
	 */
	public void setNumQuincenaUltimoDescuento(Integer numQuincenaUltimoDescuento) {
		this.numQuincenaUltimoDescuento = numQuincenaUltimoDescuento;
	}

	/**
	 * @return the anhoUltimoDescuento
	 */
	public Integer getAnhoUltimoDescuento() {
		return anhoUltimoDescuento;
	}

	/**
	 * @param anhoUltimoDescuento the anhoUltimoDescuento to set
	 */
	public void setAnhoUltimoDescuento(Integer anhoUltimoDescuento) {
		this.anhoUltimoDescuento = anhoUltimoDescuento;
	}   
}

