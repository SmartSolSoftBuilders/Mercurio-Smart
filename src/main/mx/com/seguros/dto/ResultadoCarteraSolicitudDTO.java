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
public class ResultadoCarteraSolicitudDTO {

   
	private Integer numPoliza;
	private Integer numConsignatario;
    private String alias;
    private String apPaternoEmpleado;    
	private String apMaternoEmpleado;
	private String nombre1Empleado;
    private String nombre2Empleado;
    private Integer cveEmpleado;
    private Integer cveAgente;  
    private String nombreEmpresa;
    private String nombreSucursal; 
    private String concatenada;
    
    
    
    
    
    public Integer getCveAgente() {
		return cveAgente;
	}

	public void setCveAgente(Integer cveAgente) {
		this.cveAgente = cveAgente;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getCveEmpleado() {
		return cveEmpleado;
	}

	public void setCveEmpleado(Integer cveEmpleado) {
		this.cveEmpleado = cveEmpleado;
	}

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getConcatenada() {
		return concatenada;
	}

	public void setConcatenada(String concatenada) {
		this.concatenada = concatenada;
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

    
    public String getNombre1Empleado() {
        return nombre1Empleado;
    }

   
    public void setNombre1Empleado(String nombre1Empleado) {
        this.nombre1Empleado = nombre1Empleado;
    }

    public String getNombre2Empleado() {
        return nombre2Empleado;
    }

    
    public void setNombre2Empleado(String nombre2Agente) {
        this.nombre2Empleado = nombre2Agente;
    }

    
    public String getapPaternoEmpleado() {
        return apPaternoEmpleado;
    }

    public void setapPaternoEmpleado(String apPaternoEmpleado) {
        this.apPaternoEmpleado = apPaternoEmpleado;
    }

    
    public String getapMaternoEmpleado() {
        return apMaternoEmpleado;
    }

    
    public void setapMaternoEmpleado(String apMaternoEmpleado) {
        this.apMaternoEmpleado = apMaternoEmpleado;
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
 	
}
