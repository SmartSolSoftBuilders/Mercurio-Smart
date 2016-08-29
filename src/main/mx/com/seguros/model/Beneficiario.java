package mx.com.seguros.model;

import java.util.Date;

public class Beneficiario {
    private int cveBeneficiario;
    private boolean tipoBeneficiario;
    private String apPaternoBeneficiario;
    private String apMaternoBeneficiario;
    private String nombre1Beneficiario;
    private String nombre2Beneficiario;
    private Date fechaNacimientoBeneficiario;
    private String parentesco;
    private Double porcentajeAsignado;
    private int folioSolicitud;
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

	private static int numeroBeneficiarios;
    private int numBeneficiarios;
    
    public Beneficiario() {
    }
    
    public int getCveBeneficiario() {
        return cveBeneficiario;
    }
    
    public void setCveBeneficiario(int cveBeneficiario) {
        this.cveBeneficiario = cveBeneficiario;
    }
    
    public boolean getTipoBeneficiario() {
        return tipoBeneficiario;
    }
    
    public void setTipoBeneficiario(boolean tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }
    
    public String getApPaternoBeneficiario() {
        return apPaternoBeneficiario;
    }
    
    public void setApPaternoBeneficiario(String apPaternoBeneficiario) {
        this.apPaternoBeneficiario = apPaternoBeneficiario;
    }
    
    public String getApMaternoBeneficiario() {
        return apMaternoBeneficiario;
    }
    
    public void setApMaternoBeneficiario(String apMaternoBeneficiario) {
        this.apMaternoBeneficiario = apMaternoBeneficiario;
    }
    
    public String getNombre1Beneficiario() {
        return nombre1Beneficiario;
    }
    
    public void setNombre1Beneficiario(String nombre1Beneficiario) {
        this.nombre1Beneficiario = nombre1Beneficiario;
    }
    
    public String getNombre2Beneficiario() {
        return nombre2Beneficiario;
    }
    
    public void setNombre2Beneficiario(String nombre2Beneficiario) {
        this.nombre2Beneficiario = nombre2Beneficiario;
    }
    
    public Date getFechaNacimientoBeneficiario() {
        return fechaNacimientoBeneficiario;
    }
    
    public void setFechaNacimientoBeneficiario(Date fechaNacimientoBeneficiario) {
        this.fechaNacimientoBeneficiario = fechaNacimientoBeneficiario;
    }
    
    public String getParentesco() {
        return parentesco;
    }
    
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
    
    public int getFolioSolicitud() {
        return folioSolicitud;
    }
    
    public void setFolioSolicitud(int folioSolicitud) {
        this.folioSolicitud = folioSolicitud;
    }

/*    public static int getNumeroBeneficiarios() {
        return numeroBeneficiarios;
    }*/

/*    public static void setNumeroBeneficiarios(int numeroBeneficiarios) {
        numeroBeneficiarios = numeroBeneficiarios;
    }*/

    public int getNumBeneficiarios() {
        return numeroBeneficiarios;
    }

    public void setNumBeneficiarios(int numBeneficiarios) {
        this.numBeneficiarios = numBeneficiarios;
        this.numeroBeneficiarios = numBeneficiarios;
    }

    public Double getPorcentajeAsignado() {
        return porcentajeAsignado;
    }

    public void setPorcentajeAsignado(Double porcentajeAsignado) {
        this.porcentajeAsignado = porcentajeAsignado;
    }
    
    
}