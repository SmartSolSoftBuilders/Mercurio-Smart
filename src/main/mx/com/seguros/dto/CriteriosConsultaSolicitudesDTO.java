/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.seguros.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * DTO para transportar los criterios de búsqueda de la consulta general de solicitudes
 * @author Emigdio
 */
public class CriteriosConsultaSolicitudesDTO {

	private static String [] COLUMNAS = new String[]{
		"Plaza",
		"Certificado",
		"Nombre Contratante",
		"Num. Nómina Asegurado",
		"Folio de Solicitud",
		"Formato",
		"Fecha Solicitud",
		"Estado Solicitud",
		"Nombre Asegurado",
		"RFC Asegurado",
		"Tel. Solicitante",
		"Emisor",
		"Num. de Poliza",
		"Fecha Inicio Vigencia",
		"Seguimiento a Póliza",
		"Pagos Póliza",
		"Paquete",
		"Grupo Asegurado",
		"Prima Mensual",
		"Escuela",
		"Sucursal",
		"Agente",
		"Saldo Cuenta",
		"Importe Retiros"};
   
	public static String [] NOMBRE_BD_COLUMNAS = new String[]{
		"plaza.cvePlaza",
		"certificado.numCertificado",
		"concat (trim(contratante.nombre1Contratante), trim(contratante.nombre2Contratante), " +
		"trim(contratante.apPaternoContratante), trim(contratante.apMaternoContratante))",
		"solicitud.numNominaContratante",
		"solicitud.folioSolicitud",
		"solicitud.formatoSolicitud",
		"solicitud.fechaSolicitud",
		"estatusSolicitud.idEstatusSolicitud",
		"concat (trim(solicitante.nombre1Solicitante) ,trim(solicitante.nombre2Solicitante), "+
		"trim(solicitante.apPaternoSolicitante),trim( solicitante.apMaternoSolicitante))",
		"solicitud.rfcSolicitante",
		"solicitante.telefono",
		"polizaIndividual.numConsignatario",
		"polizaIndividual.numPoliza",
		"polizaIndividual.fechaInicioVigencia",
		"estatusPolizaSeguimiento.idEstatusPolizaSeguimiento",
		"estatusPolizaPagos.idEstatusPagosPoliza",
		"paqueteVidaDxN.nombrePaquete",
		"grupoAsegurado.nombreGrupoAsegurado",
		"tarifaAportMensual.importeTarifa",
		"empresa.nombreEmpresa",
		"sucursal.nombreSucursal",
		"concat(trim(empleado.nombre1Empleado),"+
        "trim(empleado.nombre2Empleado), "+
        "trim(empleado.apPaternoEmpleado), "+
        "trim(empleado.apMaternoEmpleado)),",
        "cuenta.saldoCuenta",
        ""
	};
	
    private Date fechaSolicitudInicial;
    private String strFechaSolicitudInicial;
    private Date fechaSolicitudFinal;
    private String strFechaSolicitudFinal;
    private Integer idEstatusSolicitud;
    private Integer idEstatusPoliza;
    private String descripcionEstatusPoliza;
    private String descripcionEstatusSolicitud;
    private String rfcSolicitante;
    private String nombreContratante;
    private String apPaternoContratante;
    private String apMaternoContratante;
    private Integer cveAgente;
    private String nombreAgente;
    private Integer idPlaza;
    private String descripcionPlaza;
    private Integer cveGrupoAsegurado;
    private String descripcionGrupoAsegurado;
    private Integer cveSucursal;
    private String descripcionSucursal;
    private Integer cveColonia;
    private String descripcionColonia;
    private Integer cveEmpresa;
    private String descripcionEmpresa;
    private Date fechaProduccionInicial;
    private Date fechaProduccionFinal;
    private String[] camposOrden;
    private String[] orden = new String[COLUMNAS.length];
    private Boolean count;
    
    private String nombreSolicitante;
    private String apPaternoSolicitante;
    private String apMaternoSolicitante;
    
    Integer folioSolicitud;
    Integer numPoliza;
    String numNominaContratante;
    Integer numCertificado;
    
    /**
     * 
     * @return
     */
    public String[] getColumnas(){
    	return COLUMNAS;
    }
    
    public String getTotalCamposOrden(){

        StringBuilder totalCampos  = new StringBuilder();

        for(int i=0;orden!=null && i<orden.length;i++){
            
        	if(StringUtils.isNotBlank(orden[i])){
        		if(totalCampos.length() == 0){
                    totalCampos.append("order by ");
                }else{
                    totalCampos.append(" , ");
                }
                totalCampos.append(NOMBRE_BD_COLUMNAS[i] + " " + orden[i] );
        	}
        	
        	
        }
        return totalCampos.toString();
    }

    /**
     * @return the fechaSolicitudInicial
     */
    public Date getFechaSolicitudInicial() {
        return fechaSolicitudInicial;
    }

    /**
     * @param fechaSolicitudInicial the fechaSolicitudInicial to set
     */
    public void setFechaSolicitudInicial(Date fechaSolicitudInicial) {
        this.fechaSolicitudInicial = fechaSolicitudInicial;
    }

    /**
     * @return the fechaSolicitudFinal
     */
    public Date getFechaSolicitudFinal() {
        return fechaSolicitudFinal;
    }

    /**
     * @param fechaSolicitudFinal the fechaSolicitudFinal to set
     */
    public void setFechaSolicitudFinal(Date fechaSolicitudFinal) {
        this.fechaSolicitudFinal = fechaSolicitudFinal;
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
     * @return the idEstatusPoliza
     */
    public Integer getIdEstatusPoliza() {
        return idEstatusPoliza;
    }

    /**
     * @param idEstatusPoliza the idEstatusPoliza to set
     */
    public void setIdEstatusPoliza(Integer idEstatusPoliza) {
        this.idEstatusPoliza = idEstatusPoliza;
    }

    /**
     * @return the rfcSolicitante
     */
    public String getRfcSolicitante() {
        return rfcSolicitante;
    }

    /**
     * @param rfcSolicitante the rfcSolicitante to set
     */
    public void setRfcSolicitante(String rfcSolicitante) {
        this.rfcSolicitante = rfcSolicitante;
    }

    /**
     * @return the nombreContratante
     */
    public String getNombreContratante() {
        return nombreContratante;
    }

    /**
     * @param nombreContratante the nombreContratante to set
     */
    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
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
     * @return the idPlaza
     */
    public Integer getIdPlaza() {
        return idPlaza;
    }

    /**
     * @param idPlaza the idPlaza to set
     */
    public void setIdPlaza(Integer idPlaza) {
        this.idPlaza = idPlaza;
    }

    /**
     * @return the cveGrupoAsegurado
     */
    public Integer getCveGrupoAsegurado() {
        return cveGrupoAsegurado;
    }

    /**
     * @param cveGrupoAsegurado the cveGrupoAsegurado to set
     */
    public void setCveGrupoAsegurado(Integer cveGrupoAsegurado) {
        this.cveGrupoAsegurado = cveGrupoAsegurado;
    }

    /**
     * @return the cveSucursal
     */
    public Integer getCveSucursal() {
        return cveSucursal;
    }

    /**
     * @param cveSucursal the cveSucursal to set
     */
    public void setCveSucursal(Integer cveSucursal) {
        this.cveSucursal = cveSucursal;
    }

    /**
     * @return the cveColonia
     */
    public Integer getCveColonia() {
        return cveColonia;
    }

    /**
     * @param cveColonia the cveColonia to set
     */
    public void setCveColonia(Integer cveColonia) {
        this.cveColonia = cveColonia;
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
     * @return the fechaProduccionInicial
     */
    public Date getFechaProduccionInicial() {
        return fechaProduccionInicial;
    }

    /**
     * @param fechaProduccionInicial the fechaProduccionInicial to set
     */
    public void setFechaProduccionInicial(Date fechaProduccionInicial) {
        this.fechaProduccionInicial = fechaProduccionInicial;
    }

    /**
     * @return the fechaProduccionFinal
     */
    public Date getFechaProduccionFinal() {
        return fechaProduccionFinal;
    }

    /**
     * @param fechaProduccionFinal the fechaProduccionFinal to set
     */
    public void setFechaProduccionFinal(Date fechaProduccionFinal) {
        this.fechaProduccionFinal = fechaProduccionFinal;
    }

    /**
     * @return the camposOrden
     */
    public String[] getCamposOrden() {
        return camposOrden;
    }

    /**
     * @param camposOrden the camposOrden to set
     */
    public void setCamposOrden(String[] camposOrden) {
        this.setCamposOrden(camposOrden);
    }

    /**
     * @return the orden
     */
    public String[] getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(String[] orden) {
        this.setOrden(orden);
    }

    /**
     * @return the count
     */
    public Boolean getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Boolean count) {
        this.count = count;
    }

    /**
     * @return the descripcionEstatusPoliza
     */
    public String getDescripcionEstatusPoliza() {
        return descripcionEstatusPoliza;
    }

    /**
     * @param descripcionEstatusPoliza the descripcionEstatusPoliza to set
     */
    public void setDescripcionEstatusPoliza(String descripcionEstatusPoliza) {
        this.descripcionEstatusPoliza = descripcionEstatusPoliza;
    }

    /**
     * @return the descripcionEstatusSolicitud
     */
    public String getDescripcionEstatusSolicitud() {
        return descripcionEstatusSolicitud;
    }

    /**
     * @param descripcionEstatusSolicitud the descripcionEstatusSolicitud to set
     */
    public void setDescripcionEstatusSolicitud(String descripcionEstatusSolicitud) {
        this.descripcionEstatusSolicitud = descripcionEstatusSolicitud;
    }

    /**
     * @return the nombreAgente
     */
    public String getNombreAgente() {
        return nombreAgente;
    }

    /**
     * @param nombreAgente the nombreAgente to set
     */
    public void setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
    }

    /**
     * @return the descripcionPlaza
     */
    public String getDescripcionPlaza() {
        return descripcionPlaza;
    }

    /**
     * @param descripcionPlaza the descripcionPlaza to set
     */
    public void setDescripcionPlaza(String descripcionPlaza) {
        this.descripcionPlaza = descripcionPlaza;
    }

    /**
     * @return the descripcionGrupoAsegurado
     */
    public String getDescripcionGrupoAsegurado() {
        return descripcionGrupoAsegurado;
    }

    /**
     * @param descripcionGrupoAsegurado the descripcionGrupoAsegurado to set
     */
    public void setDescripcionGrupoAsegurado(String descripcionGrupoAsegurado) {
        this.descripcionGrupoAsegurado = descripcionGrupoAsegurado;
    }

    /**
     * @return the descripcionSucursal
     */
    public String getDescripcionSucursal() {
        return descripcionSucursal;
    }

    /**
     * @param descripcionSucursal the descripcionSucursal to set
     */
    public void setDescripcionSucursal(String descripcionSucursal) {
        this.descripcionSucursal = descripcionSucursal;
    }

    /**
     * @return the descripcionColonia
     */
    public String getDescripcionColonia() {
        return descripcionColonia;
    }

    /**
     * @param descripcionColonia the descripcionColonia to set
     */
    public void setDescripcionColonia(String descripcionColonia) {
        this.descripcionColonia = descripcionColonia;
    }

    /**
     * @return the descripcionEmpresa
     */
    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    /**
     * @param descripcionEmpresa the descripcionEmpresa to set
     */
    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    /**
     * @return the strFechasolicitudInicial
     */
    public String getStrFechaSolicitudInicial() {
        return strFechaSolicitudInicial;
    }

    /**
     * @param strFechasolicitudInicial the strFechasolicitudInicial to set
     */
    public void setStrFechaSolicitudInicial(String strFechasolicitudInicial) {
        this.strFechaSolicitudInicial = strFechasolicitudInicial;
    }

    /**
     * @return the strFechaSolicitudFinal
     */
    public String getStrFechaSolicitudFinal() {
        return strFechaSolicitudFinal;
    }

    /**
     * @param strFechaSolicitudFinal the strFechaSolicitudFinal to set
     */
    public void setStrFechaSolicitudFinal(String strFechaSolicitudFinal) {
        this.strFechaSolicitudFinal = strFechaSolicitudFinal;
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
	 * @return the nombreSolicitante
	 */
	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	/**
	 * @param nombreSolicitante the nombreSolicitante to set
	 */
	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	/**
	 * @return the apPaternoSolicitante
	 */
	public String getApPaternoSolicitante() {
		return apPaternoSolicitante;
	}

	/**
	 * @param apPaternoSolicitante the apPaternoSolicitante to set
	 */
	public void setApPaternoSolicitante(String apPaternoSolicitante) {
		this.apPaternoSolicitante = apPaternoSolicitante;
	}

	/**
	 * @return the apMaternoSolicitante
	 */
	public String getApMaternoSolicitante() {
		return apMaternoSolicitante;
	}

	/**
	 * @param apMaternoSolicitante the apMaternoSolicitante to set
	 */
	public void setApMaternoSolicitante(String apMaternoSolicitante) {
		this.apMaternoSolicitante = apMaternoSolicitante;
	}

    
}
