/*
 * Proyecto: Estrategas Seguros - Inbursa
 * Archivo: RegistroArchivoPolizas.java
 * Fecha de creación: 04/06/2011
 * Última Modificación: 04/06/2011
 */

package mx.com.seguros.model;

import java.util.Date;

/**
 * Clase del Modelo para la tabla RegistroArchivoPolizas
 * @author Emigdio
 */
public class RegistroArchivoPolizas {
   private Integer idRegistroArchivoPolizas;
    private Integer idResumenCargaArchivoPolizas;
    private Integer idEstadoRegistroPoliza;
    private ResumenCargaArchivoPolizas resumenCargaArchivoPolizas;
    private EstadoRegistroPoliza estadoRegistroPoliza;
    private String nombreGrupoAsegurado;
    private String apPaternoAsegurado;
    private String apMaternoAsegurado;
    private String nombre1Asegurado;
    private String nombre2Asegurado;
    private String RFCasegurado;
    private String numNominaAsegurado;
    private Date fechaNacimientoAsegurado;
    private String cveSexoAsegurado;
    private String esFumadorAsegurado;
    private String cveEstadoCivilAsegurado;
    private String calle;
    private String numExterior;
    private String numInterior;
    private String codPostal;
    private String colonia;
    private String entidadFederativa;
    private String delegacionMpio;
    private String apPaternoContratante;
    private String apMaternoContratante;
    private String nombre1Contratante;
    private String nombre2Contratante;
    private String numConsignatario;
    private String numPoliza;
    private String agrupacionCIS;
    private Date fechaInicioVigencia;
    private Date fechaSolicitud;
    private Double sumaAseguradaIndividual;
    private Double sumaBAF;
    private Double sumaDIPM;
    private Double sumaDIPMC;
    private Double sumaBITP;
    private Double sumaSEVI;
    private Double sumaGastosFunerarios;
    private Double sumaCPF;
    private String nombrePaquete;
    private Integer plazoSeguro;
    private Double importeTarifa;
    private Integer cvePromotor;
    private Integer folioSolicitud;

    private Integer agrupacion = null;
    
    private boolean capturada = false;
    
    /**
     * @return the idRegistroArchivoPolizas
     */
    public Integer getIdRegistroArchivoPolizas() {
        return idRegistroArchivoPolizas;
    }

    /**
     * @param idRegistroArchivoPolizas the idRegistroArchivoPolizas to set
     */
    public void setIdRegistroArchivoPolizas(Integer idRegistroArchivoPolizas) {
        this.idRegistroArchivoPolizas = idRegistroArchivoPolizas;
    }

    /**
     * @return the idResumenCargaArchivoPolizas
     */
    public Integer getIdResumenCargaArchivoPolizas() {
        return idResumenCargaArchivoPolizas;
    }

    /**
     * @param idResumenCargaArchivoPolizas the idResumenCargaArchivoPolizas to set
     */
    public void setIdResumenCargaArchivoPolizas(Integer idResumenCargaArchivoPolizas) {
        this.idResumenCargaArchivoPolizas = idResumenCargaArchivoPolizas;
    }

    /**
     * @return the idEstadoRegistroPoliza
     */
    public Integer getIdEstadoRegistroPoliza() {
        return idEstadoRegistroPoliza;
    }

    /**
     * @param idEstadoRegistroPoliza the idEstadoRegistroPoliza to set
     */
    public void setIdEstadoRegistroPoliza(Integer idEstadoRegistroPoliza) {
        this.idEstadoRegistroPoliza = idEstadoRegistroPoliza;
    }

    /**
     * @return the resumenCargaArchivoPolizas
     */
    public ResumenCargaArchivoPolizas getResumenCargaArchivoPolizas() {
        return resumenCargaArchivoPolizas;
    }

    /**
     * @param resumenCargaArchivoPolizas the resumenCargaArchivoPolizas to set
     */
    public void setResumenCargaArchivoPolizas(ResumenCargaArchivoPolizas resumenCargaArchivoPolizas) {
        this.resumenCargaArchivoPolizas = resumenCargaArchivoPolizas;
    }

    /**
     * @return the estadoRegistroPoliza
     */
    public EstadoRegistroPoliza getEstadoRegistroPoliza() {
        return estadoRegistroPoliza;
    }

    /**
     * @param estadoRegistroPoliza the estadoRegistroPoliza to set
     */
    public void setEstadoRegistroPoliza(EstadoRegistroPoliza estadoRegistroPoliza) {
        this.estadoRegistroPoliza = estadoRegistroPoliza;
    }

    /**
     * @return the nombreGrupoAsegurado
     */
    public String getNombreGrupoAsegurado() {
        return nombreGrupoAsegurado;
    }

    /**
     * @param nombreGrupoAsegurado the nombreGrupoAsegurado to set
     */
    public void setNombreGrupoAsegurado(String nombreGrupoAsegurado) {
        this.nombreGrupoAsegurado = nombreGrupoAsegurado;
    }

    /**
     * @return the apPaternoAsegurado
     */
    public String getApPaternoAsegurado() {
        return apPaternoAsegurado;
    }

    /**
     * @param apPaternoAsegurado the apPaternoAsegurado to set
     */
    public void setApPaternoAsegurado(String apPaternoAsegurado) {
        this.apPaternoAsegurado = apPaternoAsegurado;
    }

    /**
     * @return the apMaternoAsegurado
     */
    public String getApMaternoAsegurado() {
        return apMaternoAsegurado;
    }

    /**
     * @param apMaternoAsegurado the apMaternoAsegurado to set
     */
    public void setApMaternoAsegurado(String apMaternoAsegurado) {
        this.apMaternoAsegurado = apMaternoAsegurado;
    }

    /**
     * @return the nombre1Asegurado
     */
    public String getNombre1Asegurado() {
        return nombre1Asegurado;
    }

    /**
     * @param nombre1Asegurado the nombre1Asegurado to set
     */
    public void setNombre1Asegurado(String nombre1Asegurado) {
        this.nombre1Asegurado = nombre1Asegurado;
    }

    /**
     * @return the nombre2Asegurado
     */
    public String getNombre2Asegurado() {
        return nombre2Asegurado;
    }

    /**
     * @param nombre2Asegurado the nombre2Asegurado to set
     */
    public void setNombre2Asegurado(String nombre2Asegurado) {
        this.nombre2Asegurado = nombre2Asegurado;
    }

    /**
     * @return the RFCasegurado
     */
    public String getRFCasegurado() {
        return RFCasegurado;
    }

    /**
     * @param RFCasegurado the RFCasegurado to set
     */
    public void setRFCasegurado(String RFCasegurado) {
        this.RFCasegurado = RFCasegurado;
    }

    /**
     * @return the numNominaAsegurado
     */
    public String getNumNominaAsegurado() {
        return numNominaAsegurado;
    }

    /**
     * @param numNominaAsegurado the numNominaAsegurado to set
     */
    public void setNumNominaAsegurado(String numNominaAsegurado) {
        this.numNominaAsegurado = numNominaAsegurado;
    }

    /**
     * @return the fechaNacimientoAsegurado
     */
    public Date getFechaNacimientoAsegurado() {
        return fechaNacimientoAsegurado;
    }

    /**
     * @param fechaNacimientoAsegurado the fechaNacimientoAsegurado to set
     */
    public void setFechaNacimientoAsegurado(Date fechaNacimientoAsegurado) {
        this.fechaNacimientoAsegurado = fechaNacimientoAsegurado;
    }

    /**
     * @return the cveSexoAsegurado
     */
    public String getCveSexoAsegurado() {
        return cveSexoAsegurado;
    }

    /**
     * @param cveSexoAsegurado the cveSexoAsegurado to set
     */
    public void setCveSexoAsegurado(String cveSexoAsegurado) {
        this.cveSexoAsegurado = cveSexoAsegurado;
    }

    /**
     * @return the esFumadorAsegurado
     */
    public String getEsFumadorAsegurado() {
        return esFumadorAsegurado;
    }

    /**
     * @param esFumadorAsegurado the esFumadorAsegurado to set
     */
    public void setEsFumadorAsegurado(String esFumadorAsegurado) {
        this.esFumadorAsegurado = esFumadorAsegurado;
    }

    /**
     * @return the cveEstadoCivilAsegurado
     */
    public String getCveEstadoCivilAsegurado() {
        return cveEstadoCivilAsegurado;
    }

    /**
     * @param cveEstadoCivilAsegurado the cveEstadoCivilAsegurado to set
     */
    public void setCveEstadoCivilAsegurado(String cveEstadoCivilAsegurado) {
        this.cveEstadoCivilAsegurado = cveEstadoCivilAsegurado;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numExterior
     */
    public String getNumExterior() {
        return numExterior;
    }

    /**
     * @param numExterior the numExterior to set
     */
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * @return the numInterior
     */
    public String getNumInterior() {
        return numInterior;
    }

    /**
     * @param numInterior the numInterior to set
     */
    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }

    /**
     * @return the codPostal
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * @param codPostal the codPostal to set
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the entidadFederativa
     */
    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    /**
     * @param entidadFederativa the entidadFederativa to set
     */
    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    /**
     * @return the delegacionMpio
     */
    public String getDelegacionMpio() {
        return delegacionMpio;
    }

    /**
     * @param delegacionMpio the delegacionMpio to set
     */
    public void setDelegacionMpio(String delegacionMpio) {
        this.delegacionMpio = delegacionMpio;
    }

    /**
     * @return the apPaternoContratante
     */
    public String getApPaternoContratante() {
        return apPaternoContratante;
    }

    /**
     * @param apPaternoContratante the apPaternoContratante to set
     */
    public void setApPaternoContratante(String apPaternoContratante) {
        this.apPaternoContratante = apPaternoContratante;
    }

    /**
     * @return the apMaternoContratante
     */
    public String getApMaternoContratante() {
        return apMaternoContratante;
    }

    /**
     * @param apMaternoContratante the apMaternoContratante to set
     */
    public void setApMaternoContratante(String apMaternoContratante) {
        this.apMaternoContratante = apMaternoContratante;
    }

    /**
     * @return the nombre1Contratante
     */
    public String getNombre1Contratante() {
        return nombre1Contratante;
    }

    /**
     * @param nombre1Contratante the nombre1Contratante to set
     */
    public void setNombre1Contratante(String nombre1Contratante) {
        this.nombre1Contratante = nombre1Contratante;
    }

    /**
     * @return the nombre2Contratante
     */
    public String getNombre2Contratante() {
        return nombre2Contratante;
    }

    /**
     * @param nombre2Contratante the nombre2Contratante to set
     */
    public void setNombre2Contratante(String nombre2Contratante) {
        this.nombre2Contratante = nombre2Contratante;
    }

    /**
     * @return the numConsignatario
     */
    public String getNumConsignatario() {
        return numConsignatario;
    }

    /**
     * @param numConsignatario the numConsignatario to set
     */
    public void setNumConsignatario(String numConsignatario) {
        this.numConsignatario = numConsignatario;
    }

    /**
     * @return the numPoliza
     */
    public String getNumPoliza() {
        return numPoliza;
    }

    /**
     * @param numPoliza the numPoliza to set
     */
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    /**
     * @return the agrupacionCIS
     */
    public String getAgrupacionCIS() {
        return agrupacionCIS;
    }

    /**
     * @param agrupacionCIS the agrupacionCIS to set
     */
    public void setAgrupacionCIS(String agrupacionCIS) {
        this.agrupacionCIS = agrupacionCIS;
    }

    /**
     * @return the fechaInicioVigencia
     */
    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    /**
     * @param fechaInicioVigencia the fechaInicioVigencia to set
     */
    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
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
     * @return the sumaAseguradaIndividual
     */
    public Double getSumaAseguradaIndividual() {
        return sumaAseguradaIndividual;
    }

    /**
     * @param sumaAseguradaIndividual the sumaAseguradaIndividual to set
     */
    public void setSumaAseguradaIndividual(Double sumaAseguradaIndividual) {
        this.sumaAseguradaIndividual = sumaAseguradaIndividual;
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

	public Double getSumaDIPMC() {
		return sumaDIPMC;
	}

	public void setSumaDIPMC(Double sumaDIPMC) {
		this.sumaDIPMC = sumaDIPMC;
	}

	public Double getSumaDIPM() {
		return sumaDIPM;
	}

	public void setSumaDIPM(Double sumaDIPM) {
		this.sumaDIPM = sumaDIPM;
	}

	public Double getSumaBITP() {
		return sumaBITP;
	}

	public void setSumaBITP(Double sumaBITP) {
		this.sumaBITP = sumaBITP;
	}

	/**
     * @return the sumaSEVI
     */
    public Double getSumaSEVI() {
        return sumaSEVI;
    }

    /**
     * @param sumaSEVI the sumaSEVI to set
     */
    public void setSumaSEVI(Double sumaSEVI) {
        this.sumaSEVI = sumaSEVI;
    }

    /**
     * @return the sumaGastosFunerarios
     */
    public Double getSumaGastosFunerarios() {
        return sumaGastosFunerarios;
    }

    /**
     * @param sumaGastosFunerarios the sumaGastosFunerarios to set
     */
    public void setSumaGastosFunerarios(Double sumaGastosFunerarios) {
        this.sumaGastosFunerarios = sumaGastosFunerarios;
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
     * @return the nombrePaquete
     */
    public String getNombrePaquete() {
        return nombrePaquete;
    }

    /**
     * @param nombrePaquete the nombrePaquete to set
     */
    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
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
     * @return the importeTarifa
     */
    public Double getImporteTarifa() {
        return importeTarifa;
    }

    /**
     * @param importeTarifa the importeTarifa to set
     */
    public void setImporteTarifa(Double importeTarifa) {
        this.importeTarifa = importeTarifa;
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
	 * @return the capturada
	 */
	public boolean isCapturada() {
		return capturada;
	}

	/**
	 * @param capturada the capturada to set
	 */
	public void setCapturada(boolean capturada) {
		this.capturada = capturada;
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

    

}
