package mx.com.seguros.model;

//import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import mx.com.seguros.model.Solicitud;
import java.util.ArrayList;

public class Solicitante {
    private String RFCsolicitante;
    private String apPaternoSolicitante;
    private String apMaternoSolicitante;
    private String nombre1Solicitante;
    private String nombre2Solicitante;
    private Date fechaNacimientoSolicitante;
    private String puestoSolicitante = "";
    private Boolean sexoSolicitanteMasculino;// = null;
    //private Character estadoCivilSolicitante;
    private String estadoCivilSolicitante;
    //private BigDecimal ingresoMensualSolicitante;
    private String ingresoMensualSolicitante = "";
    private Date fechaAltaDependencia;
    private Date fechaBajaDependencia;
    private String calle;
    private String edificio;
    private String numExtInt;
    private String colonia;
    private String delegacionMpio;
    private String ciudadPoblacion;
    private String entidadFederativa;
    private String email;
    private Integer numOficioAltaDependencia;
    private Integer numOficioBajaDependencia;
    private Integer codPostal;
    private Integer lada;
    private Integer telefono;
    private List<Solicitud> solicitud = new ArrayList<Solicitud>();
    private Boolean esFumadorAsegurado;
    
    public Solicitante(){
        //ingresoMensualSolicitante = new BigDecimal(0.00);
        //System.out.println("Solicitante = " + this);
    }
    
    public void setRFCsolicitante(String RFCsolicitante) {
        this.RFCsolicitante = RFCsolicitante;
    }
    
    public String getRFCsolicitante() {
        return this.RFCsolicitante;
    }
    
    public void setApPaternoSolicitante(String apPaternoSolicitante) {
        this.apPaternoSolicitante = apPaternoSolicitante;
    }
    
    public String getApPaternoSolicitante() {
        return this.apPaternoSolicitante;
    }
    
    public void setApMaternoSolicitante(String apMaternoSolicitante) {
        this.apMaternoSolicitante = apMaternoSolicitante;
    }
    
    public String getApMaternoSolicitante() {
        return this.apMaternoSolicitante;
    }
    
    public void setNombre1Solicitante(String nombre1Solicitante) {
        this.nombre1Solicitante = nombre1Solicitante;
    }
    
    public String getNombre1Solicitante() {
        return this.nombre1Solicitante;
    }
    
    public void setNombre2Solicitante(String nombre2Solicitante) {
        this.nombre2Solicitante = nombre2Solicitante;
    }
    
    public String getNombre2Solicitante() {
        return this.nombre2Solicitante;
    }
    
    public void setFechaNacimientoSolicitante(Date fechaNacimientoSolicitante) {
        this.fechaNacimientoSolicitante = fechaNacimientoSolicitante;
    }
    
    public Date getFechaNacimientoSolicitante() {
        return this.fechaNacimientoSolicitante;
    }
    
    public void setPuestoSolicitante(String puestoSolicitante) {
        this.puestoSolicitante = puestoSolicitante;
    }
    
    public String getPuestoSolicitante() {
        return this.puestoSolicitante;
    }
    
    public void setIngresoMensualSolicitante(String ingresoMensualSolicitante) {
        this.ingresoMensualSolicitante = ingresoMensualSolicitante;
    }
    
    public String getIngresoMensualSolicitante() {
        return this.ingresoMensualSolicitante;
    }
    
    public void setFechaAltaDependencia(Date fechaAltaDependencia) {
        this.fechaAltaDependencia = fechaAltaDependencia;
    }
    
    public Date getFechaAltaDependencia() {
        return this.fechaAltaDependencia;
    }
    
     
    public void setFechaBajaDependencia(Date fechaBajaDependencia) {
        this.fechaBajaDependencia = fechaBajaDependencia;
    }
    
    public Date getFechaBajaDependencia() {
        return this.fechaBajaDependencia;
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
    
       
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Boolean getSexoSolicitanteMasculino() {
        return sexoSolicitanteMasculino;
    }
    
    public void setSexoSolicitanteMasculino(Boolean sexoSolicitanteMasculino) {
        this.sexoSolicitanteMasculino = sexoSolicitanteMasculino;
    }
    
/*    public String getEstadoCivilSolicitante() {
        return estadoCivilSolicitante;
    }*/
    
//    public void setEstadoCivilSolicitante(Character estadoCivilSolicitante) {
//        this.estadoCivilSolicitante = estadoCivilSolicitante;
//    }
//
//    public Character getEstadoCivilSolicitante() {
//        return estadoCivilSolicitante;
//    }
    
    public String getEstadoCivilSolicitante() {
        // Paso de los códigos numéricos del estado civil a cadenas descriptivas:
/*        int cveEstadoCivil = Integer.parseInt(estadoCivilSolicitante);
        
        switch(cveEstadoCivil){
            case 1:
                estadoCivilSolicitante = "Soltero";
                break;
            case 2:
                estadoCivilSolicitante = "Casado";
                break;
            case 3:
                estadoCivilSolicitante = "Divorciado";
                break;
            case 4:
                estadoCivilSolicitante = "Viudo";
                break;
            case 5:
                estadoCivilSolicitante = "Separado";
                break;
            case 6:
                estadoCivilSolicitante = "Unión Libre";
                break;
            default:
                estadoCivilSolicitante = "Soltero";
        }*/
        
        return estadoCivilSolicitante;
    }
    
    public void setEstadoCivilSolicitante(String estadoCivilSolicitante) {
        this.estadoCivilSolicitante = estadoCivilSolicitante;
    }

    public Integer getNumOficioBajaDependencia() {
        return numOficioBajaDependencia;
    }

    public void setNumOficioBajaDependencia(Integer numOficioBajaDependencia) {
        this.numOficioBajaDependencia = numOficioBajaDependencia;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public Integer getLada() {
        return lada;
    }

    public void setLada(Integer lada) {
        this.lada = lada;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getNumOficioAltaDependencia() {
        return numOficioAltaDependencia;
    }

    public void setNumOficioAltaDependencia(Integer numOficioAltaDependencia) {
        this.numOficioAltaDependencia = numOficioAltaDependencia;
    }

    /**
     * @return the esFumadorAsegurado
     */
    public Boolean getEsFumadorAsegurado() {
        return esFumadorAsegurado;
    }

    /**
     * @param esFumadorAsegurado the esFumadorAsegurado to set
     */
    public void setEsFumadorAsegurado(Boolean esFumadorAsegurado) {
        this.esFumadorAsegurado = esFumadorAsegurado;
    }
    
}