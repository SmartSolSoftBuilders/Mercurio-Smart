/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.seguros.dto;

import java.util.Date;

/**
 * Data transfer object para presentar los resultados de la consulta general de solicitudes
 * @author Emigdio Hernández
 */
public class ResultadoConsultaSolicitudDTO {

    private Integer folioSolicitud;
    private String formatoSolicitud;
	private Integer numConsignatario;
    private Integer numCertificado;
    private String descripcionEstadoSolicitud;
    private String descripcionEstadoPoliza;
    private Integer numPoliza;
    private String nombreGrupoAsegurado;
    private String apPaternoAsegurado;
    private String apMaternoAsegurado;
    private String nombre1Asegurado;
    private String nombre2Asegurado;
    private String numNominaAsegurado;
    private String RFCasegurado;
    private String nombre2Contratante;
    private String nombre1Contratante;
    private String apPaternoContratante;
    private String apMaternoContratante;
    private String telefonoSolicitante;
    private Date fechaInicioVigencia;
    private Date fechaSolicitud;
    private String nombrePaquete;
    private Integer plazoSeguro;
    private String nombre1Agente;
    private String nombre2Agente;
    private String apPaternoAgente;
    private String apMaternoAgente;
    private Double primaMensual;
    private Double sumaAseguradaIndividual;
    private Double sumaBAF;
    private Double sumaGastosFunerarios;
    private Double sumaSEVI;
    private Double totalProteccion;

    private Integer totalRegistros;

    private String cvePlaza;
    private String nombreEmpresa;
    private String nombreSucursal;
    
    private String descripcionEstadoPolizaPagos;
    
    private Double saldoCuenta = new Double(0);
    private Double importeRetiros = new Double(0);
    
    private String descripcionTarifa = "";
    
    private Date fechaSolicitudCancelacion = null;
    
    private Integer numQuincenaUltimoDescuento = null;
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
     * @return the numConsignatario
     */
    public Integer getNumConsignatario() {
        return numConsignatario;
    }

    /**
     * @param numConsignatario the numConsignatario to set
     */
    public void setNumConsignatario(Integer numConsignatario) {
        this.numConsignatario = numConsignatario;
    }

    /**
     * @return the numCertificado
     */
    public Integer getNumCertificado() {
        return numCertificado;
    }

    /**
     * @param numCertificado the numCertificado to set
     */
    public void setNumCertificado(Integer numCertificado) {
        this.numCertificado = numCertificado;
    }

    /**
     * @return the descripcionEstadoSolicitud
     */
    public String getDescripcionEstadoSolicitud() {
        return descripcionEstadoSolicitud;
    }

    /**
     * @param descripcionEstadoSolicitud the descripcionEstadoSolicitud to set
     */
    public void setDescripcionEstadoSolicitud(String descripcionEstadoSolicitud) {
        this.descripcionEstadoSolicitud = descripcionEstadoSolicitud;
    }

    /**
     * @return the descripcionEstadoPoliza
     */
    public String getDescripcionEstadoPoliza() {
        return descripcionEstadoPoliza;
    }

    /**
     * @param descripcionEstadoPoliza the descripcionEstadoPoliza to set
     */
    public void setDescripcionEstadoPoliza(String descripcionEstadoPoliza) {
        this.descripcionEstadoPoliza = descripcionEstadoPoliza;
    }

    /**
     * @return the numPoliza
     */
    public Integer getNumPoliza() {
        return numPoliza;
    }

    /**
     * @param numPoliza the numPoliza to set
     */
    public void setNumPoliza(Integer numPoliza) {
        this.numPoliza = numPoliza;
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
     * @return the telefonoSolicitante
     */
    public String getTelefonoSolicitante() {
        return telefonoSolicitante;
    }

    /**
     * @param telefonoSolicitante the telefonoSolicitante to set
     */
    public void setTelefonoSolicitante(String telefonoSolicitante) {
        this.telefonoSolicitante = telefonoSolicitante;
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
     * @return the primaMensual
     */
    public Double getPrimaMensual() {
        return primaMensual;
    }

    /**
     * @param primaMensual the primaMensual to set
     */
    public void setPrimaMensual(Double primaMensual) {
        this.primaMensual = primaMensual;
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
     * @return the totalProteccion
     */
    public Double getTotalProteccion() {

        /*
                tarifaAportMensual.importeTarifa+
                polizaIndividual.sumaAseguradaIndividual+
                polizaIndividual.sumaBAF+
                polizaIndividual.sumaGastosFunerarios+
                polizaIndividual.sumaSEVI as totalProteccion*/
        return
        (primaMensual!=null?primaMensual.doubleValue():0)+
        (sumaAseguradaIndividual!=null?sumaAseguradaIndividual.doubleValue():0)+
        (sumaBAF!=null?sumaBAF.doubleValue():0)+
        (sumaGastosFunerarios!=null?sumaGastosFunerarios.doubleValue():0);



    }

    /**
     * @param totalProteccion the totalProteccion to set
     */
    public void setTotalProteccion(Double totalProteccion) {
        this.totalProteccion = totalProteccion;
    }

    /**
     * @return the totalRegistros
     */
    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    /**
     * @param totalRegistros the totalRegistros to set
     */
    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    /**
     * @return the nombre1Agente
     */
    public String getNombre1Agente() {
        return nombre1Agente;
    }

    /**
     * @param nombre1Agente the nombre1Agente to set
     */
    public void setNombre1Agente(String nombre1Agente) {
        this.nombre1Agente = nombre1Agente;
    }

    /**
     * @return the nombre2Agente
     */
    public String getNombre2Agente() {
        return nombre2Agente;
    }

    /**
     * @param nombre2Agente the nombre2Agente to set
     */
    public void setNombre2Agente(String nombre2Agente) {
        this.nombre2Agente = nombre2Agente;
    }

    /**
     * @return the apPaternoAgente
     */
    public String getApPaternoAgente() {
        return apPaternoAgente;
    }

    /**
     * @param apPaternoAgente the apPaternoAgente to set
     */
    public void setApPaternoAgente(String apPaternoAgente) {
        this.apPaternoAgente = apPaternoAgente;
    }

    /**
     * @return the apMaternoAgente
     */
    public String getApMaternoAgente() {
        return apMaternoAgente;
    }

    /**
     * @param apMaternoAgente the apMaternoAgente to set
     */
    public void setApMaternoAgente(String apMaternoAgente) {
        this.apMaternoAgente = apMaternoAgente;
    }

	/**
	 * Método de acceso al campo cvePlaza.
	 * @return El valor del campo cvePlaza
	 */
	public String getCvePlaza() {
		return cvePlaza;
	}

	/**
	 * Asigna el valor al campo cvePlaza.
	 * @param cvePlaza el valor cvePlaza a asignar
	 */
	public void setCvePlaza(String cvePlaza) {
		this.cvePlaza = cvePlaza;
	}

	
	/**
	 * Método de acceso al campo nombreSucursal.
	 * @return El valor del campo nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Asigna el valor al campo nombreSucursal.
	 * @param nombreSucursal el valor nombreSucursal a asignar
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Método de acceso al campo nombreEmpresa.
	 * @return El valor del campo nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * Asigna el valor al campo nombreEmpresa.
	 * @param nombreEmpresa el valor nombreEmpresa a asignar
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * Método de acceso al campo descripcionEstadoPolizaPagos.
	 * @return El valor del campo descripcionEstadoPolizaPagos
	 */
	public String getDescripcionEstadoPolizaPagos() {
		return descripcionEstadoPolizaPagos;
	}

	/**
	 * Asigna el valor al campo descripcionEstadoPolizaPagos.
	 * @param descripcionEstadoPolizaPagos el valor descripcionEstadoPolizaPagos a asignar
	 */
	public void setDescripcionEstadoPolizaPagos(String descripcionEstadoPolizaPagos) {
		this.descripcionEstadoPolizaPagos = descripcionEstadoPolizaPagos;
	}

	/**
	 * @return the saldoCuenta
	 */
	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	/**
	 * @param saldoCuenta the saldoCuenta to set
	 */
	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	/**
	 * @return the importeRetiros
	 */
	public Double getImporteRetiros() {
		return importeRetiros;
	}

	/**
	 * @param importeRetiros the importeRetiros to set
	 */
	public void setImporteRetiros(Double importeRetiros) {
		this.importeRetiros = importeRetiros;
	}

	/**
	 * @return the descripcionTarifa
	 */
	public String getDescripcionTarifa() {
		return descripcionTarifa;
	}

	/**
	 * @param descripcionTarifa the descripcionTarifa to set
	 */
	public void setDescripcionTarifa(String descripcionTarifa) {
		this.descripcionTarifa = descripcionTarifa;
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
}
