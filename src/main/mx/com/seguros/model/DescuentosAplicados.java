package mx.com.seguros.model;

import java.math.BigDecimal;
import java.util.Date;


public class DescuentosAplicados {
    
    private int numPoliza=0;
    private int numQuincenaPagada=0;
    private int numQuincenaArchivo=0;
    private Double impDescuentoAplicadoPoliza = null;
    private double impRealPagoPrima = 0;
    private double impRealAhorro=0;
    private String grupoAsegurado;
    private int identificadorArchivo=0;
    private Date fechaCalculo;
    private double impDescReportado=0;
    private Date fechaDepositoDep;
    private int numConsignatario=0;
    private Long transaccionId;
    private Date fechaInicioCobertura;
    private Date fechaFinalCobertura;
    private BigDecimal saldoCuenta;
    private String numNominaContratante;
    public int getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(int numPoliza) {
        this.numPoliza = numPoliza;
    }

    public int getNumQuincenaPagada() {
        return numQuincenaPagada;
    }

    public void setNumQuincenaPagada(int numQuincenaPagada) {
        this.numQuincenaPagada = numQuincenaPagada;
    }

    public int getNumQuincenaArchivo() {
        return numQuincenaArchivo;
    }

    public void setNumQuincenaArchivo(int numQuincenaArchivo) {
        this.numQuincenaArchivo = numQuincenaArchivo;
    }

    public Double getImpDescuentoAplicadoPoliza() {
        return impDescuentoAplicadoPoliza;
    }

    public void setImpDescuentoAplicadoPoliza(Double impDescuentoAplicadoPoliza) {
        this.impDescuentoAplicadoPoliza = impDescuentoAplicadoPoliza;
    }

    public double getImpRealPagoPrima() {
        return impRealPagoPrima;
    }

    public void setImpRealPagoPrima(double impRealPagoPrima) {
        this.impRealPagoPrima = impRealPagoPrima;
    }

    public double getImpRealAhorro() {
        return impRealAhorro;
    }

    public void setImpRealAhorro(double impRealAhorro) {
        this.impRealAhorro = impRealAhorro;
    }

    public String getGrupoAsegurado() {
        return grupoAsegurado;
    }

    public void setGrupoAsegurado(String grupoAsegurado) {
        this.grupoAsegurado = grupoAsegurado;
    }

    public int getIdentificadorArchivo() {
        return identificadorArchivo;
    }

    public void setIdentificadorArchivo(int identificadorArchivo) {
        this.identificadorArchivo = identificadorArchivo;
    }

    public Date getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(Date fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    public double getImpDescReportado() {
        return impDescReportado;
    }

    public void setImpDescReportado(double impDescReportado) {
        this.impDescReportado = impDescReportado;
    }

    public Date getFechaDepositoDep() {
        return fechaDepositoDep;
    }

    public void setFechaDepositoDep(Date fechaDepositoDep) {
        this.fechaDepositoDep = fechaDepositoDep;
    }

    public int getNumConsignatario() {
        return numConsignatario;
    }

    public void setNumConsignatario(int numConsignatario) {
        this.numConsignatario = numConsignatario;
    }

	/**
	 * @return the transaccionId
	 */
	public Long getTransaccionId() {
		return transaccionId;
	}

	/**
	 * @param transaccionId the transaccionId to set
	 */
	public void setTransaccionId(Long transaccionId) {
		this.transaccionId = transaccionId;
	}

	/**
	 * @return the fechaInicioCobertura
	 */
	public Date getFechaInicioCobertura() {
		return fechaInicioCobertura;
	}

	/**
	 * @param fechaInicioCobertura the fechaInicioCobertura to set
	 */
	public void setFechaInicioCobertura(Date fechaInicioCobertura) {
		this.fechaInicioCobertura = fechaInicioCobertura;
	}

	/**
	 * @return the fechaFinalCobertura
	 */
	public Date getFechaFinalCobertura() {
		return fechaFinalCobertura;
	}

	/**
	 * @param fechaFinalCobertura the fechaFinalCobertura to set
	 */
	public void setFechaFinalCobertura(Date fechaFinalCobertura) {
		this.fechaFinalCobertura = fechaFinalCobertura;
	}

	/**
	 * @return the saldoCuenta
	 */
	public BigDecimal getSaldoCuenta() {
		return saldoCuenta;
	}

	/**
	 * @param saldoCuenta the saldoCuenta to set
	 */
	public void setSaldoCuenta(BigDecimal saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
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

   
}