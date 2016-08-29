package mx.com.seguros.web.solicitud;

import com.mysql.jdbc.StringUtils;
import java.util.Date;
import mx.com.seguros.model.Beneficiario;
import mx.com.seguros.model.Contratante;
import mx.com.seguros.model.Empresa;
import mx.com.seguros.model.Solicitante;
import mx.com.seguros.model.Solicitud;
import org.apache.log4j.Logger;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

public class DatosSolicitudValidator implements Validator {
    DatosSolicitudCommand datosSolicitud;
    Solicitud solicitud;
    Logger logger = Logger.getLogger(DatosSolicitudValidator.class);
    
    public DatosSolicitudValidator() {
    }
    
    @Override
    public boolean supports(Class clazz) {
        return DatosSolicitudCommand.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
    }
    
    int validatePage0(Object command, Errors errors) {
        datosSolicitud = (DatosSolicitudCommand) command;
        solicitud = datosSolicitud.getSolicitud();
        Date fechaSolicitud = solicitud.getFechaSolicitud();
        
        if(solicitud.getCveAgente()== null || solicitud.getCveAgente() == 0) {
            errors.rejectValue(
                    "solicitud.cveAgente",
                    "campo-vacio",
                    new Object[]{"El campo Clave agente"},
                    "Mensaje default");
        }
        
        if(solicitud.getFolioSolicitud() == null || solicitud.getFolioSolicitud() == 0) {
            errors.rejectValue(
                    "solicitud.folioSolicitud",
                    "campo-vacio",
                    new Object[]{"El campo Folio Solicitud"},
                    "Mensaje default");
        }
        if(org.apache.commons.lang.StringUtils.isBlank(solicitud.getFormatoSolicitud())) {
            errors.rejectValue(
                    "solicitud.formatoSolicitud",
                    "campo-vacio",
                    new Object[]{"El campo N�mero de Formato de la Solicitud"},
                    "Mensaje default");
        }
        if(solicitud.getCveTarifa() == null || solicitud.getCveTarifa().intValue() ==0) {
            errors.rejectValue(
                    "solicitud.cveTarifa",
                    "campo-vacio",
                    new Object[]{"El campo prima quincenal"},
                    "Mensaje default");
        }

        if (solicitud.getCvePromotor() == null || solicitud.getCvePromotor() == 0) {
            errors.rejectValue(
                    "solicitud.promotor.cvePromotor",
                    "campo-vacio",
                    new Object[]{"El campo Clave Promotor"},
                    "Mensaje default");
        }
        
        if(solicitud.getFechaSolicitud()== null){
            errors.rejectValue( "solicitud.fechaSolicitud","campo-vacio",
                    new Object[]{"El campo Fecha Solicitud"},
                    "Mensaje default");
        }
        /*
        
         Validacion de negocio: No puede generarse una solicitud
         que halla sido llenada hace mas de un mes:
         Se desactiva validacion por requerimiento de l cliente para recaptura 09/01/2009
        */
        /*
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date $30Dias = null;
        try {
            $30Dias = dateFormat.parse("31/01/1970");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Date fechaSolicitudLimite =
                new Date(new Date().getTime() - $30Dias.getTime());
        if(fechaSolicitud != null) {
            if(fechaSolicitud.compareTo(fechaSolicitudLimite) < 0){
                errors.reject("200",
                        "La fecha de solicitud rebasa los 30 días posteriores a la captura.");
            }
        }
        */
        
        return 0;
    }
    
    int validatePage1(Object command, Errors errors) {
        datosSolicitud = (DatosSolicitudCommand)command;
        solicitud = datosSolicitud.getSolicitud();
        Contratante contratante = solicitud.getContratante();
      
        if(contratante.getNumNominaContratante()== null){
            errors.rejectValue( "solicitud.contratante.numNominaContratante","campo-vacio",
                    new Object[]{"El campo No. de Empleado"},
                    "Mensaje default");
        }
        
        if (contratante.getNumNominaContratante().length()!=13){
            errors.reject("200","Ingresar 13 caracteres en el número de empleado, si el valor contiene menos caracteres complete con ceros a la izquierda");
        }
        
        if(contratante.getApPaternoContratante()==null){
            errors.rejectValue("solicitud.contratante.apPaternoContratante","campo-vacio",
                    new Object[]{"El campo Apellido Paterno"},
                    "Mensaje default");
        }
        
        if(contratante.getNombre1Contratante()==null){
            errors.rejectValue("solicitud.contratante.nombre1Contratante","campo-vacio",
                    new Object[]{"El campo Primer Nombre"},
                    "Mensaje default");
        }
        
        return 0;
    }
    
    int validatePage2(Object command, Errors errors) {
        datosSolicitud = (DatosSolicitudCommand)command;
        solicitud = datosSolicitud.getSolicitud();
        Empresa empresa = solicitud.getEmpresa();
        
        if(empresa.getCveGrupoAsegurado() == null || empresa.getCveGrupoAsegurado() == 0){
            errors.rejectValue(
                    "solicitud.empresa.cveGrupoAsegurado",
                    "campo-vacio",
                    new Object[]{"El campo Grupo asegurado: "},
                    "Mensaje default");
            errors.rejectValue(
                    "solicitud.empresa.cveGrupoAsegurado",
                    "campo-vacio",
                    new Object[]{"El campo Grupo asegurado: "},
                    "No puede ir nulo, y debe capturarse a través del helper.");
            
        }
        
        if(empresa.getCveSucursal() == null || empresa.getCveSucursal() == 0){
            errors.rejectValue(
                    "solicitud.empresa.cveSucursal",
                    "campo-vacio",
                    new Object[]{" El campo Sucursal: "},
                    "Mensaje default");
        }
        
        if(empresa.getCveColonia() == null || empresa.getCveColonia() == 0){
            errors.rejectValue(
                    "solicitud.empresa.cveColonia",
                    "campo-vacio",
                    new Object[]{"El campo Colonia/Barrio: "},
                    "Mensaje default");
        }
        
        if(empresa.getCveEmpresa()  == null || empresa.getCveEmpresa() == 0){
            errors.rejectValue(
                    "solicitud.empresa.cveEmpresa",
                    "campo-vacio",
                    new Object[]{"El campo Empresa: "},
                    "Mensaje default");
        }
        
        return 0;
    }
    
    int validatePage3(Object command, Errors errors) {
        datosSolicitud = (DatosSolicitudCommand)command;
        solicitud = datosSolicitud.getSolicitud();
        Contratante contratante = solicitud.getContratante();
        Solicitante solicitante = solicitud.getSolicitante();
        
        if(contratante.getNumNominaContratante()== null){
            errors.rejectValue(
                    "solicitud.contratante.numNominaContratante",
                    "campo-vacio",
                    new Object[]{"El campo No. de Empleado: "},
                    "Mensaje default");
        }
        
        if(solicitante.getApPaternoSolicitante() == null){
            errors.rejectValue(
                    "solicitud.solicitante.apPaternoSolicitante",
                    "campo-vacio",
                    new Object[]{"El campo Apellido Paterno: "},
                    "Mensaje default");
        }
        
        if(solicitante.getNombre1Solicitante() == null){
            errors.rejectValue(
                    "solicitud.solicitante.nombre1Solicitante",
                    "campo-vacio",
                    new Object[]{"El campo Primer Nombre: "},
                    "Mensaje default");
        }
        
        if(solicitante.getRFCsolicitante()== null){
            errors.rejectValue(
                    "solicitud.solicitante.RFCsolicitante",
                    "campo-vacio",
                    new Object[]{"El campo RFC Solicitante: "},
                    "Mensaje default");
        }
        
        
        if(solicitante.getRFCsolicitante().length() !=13){
            errors.reject("200","Ingresar 13 caracteres en el RFC del solicitante, si el valor contiene menos caracteres complete con ceros a la izquierda");
        }
        
        if(solicitante.getFechaNacimientoSolicitante()==null){
            errors.rejectValue("solicitud.solicitante.fechaNacimientoSolicitante",
                    "campo-vacio",
                    new Object[]{"El campo Fecha De Nacimiento"},
                    "Mensaje default");
        }
        
        if(solicitante.getSexoSolicitanteMasculino()==null){
            errors.rejectValue("solicitud.solicitante.sexoSolicitanteMasculino",
                    "campo-vacio",
                    new Object[]{"El campo Sexo"},
                    "Mensaje default");
        }
        
        if(solicitante.getEstadoCivilSolicitante()==null){
            errors.rejectValue("solicitud.solicitante.estadoCivilSolicitante",
                    "campo-vacio",
                    new Object[]{"El campo Estado Civil"},
                    "Mensaje default");
        }
        
        return 0;
    }
    
    int validatePage4(Object command, Errors errors) {
        datosSolicitud = (DatosSolicitudCommand)command;
        solicitud = datosSolicitud.getSolicitud();
        Solicitante solicitante = solicitud.getSolicitante();
        
        if(solicitante.getCalle()==null){
            errors.rejectValue("solicitud.solicitante.calle",
                    "campo-vacio",
                    new Object[]{"El campo Calle"},
                    "Mensaje default");
        }
        
        if(solicitante.getColonia()==null){
            errors.rejectValue("solicitud.solicitante.colonia",
                    "campo-vacio",
                    new Object[]{"El campo Colonia"},
                    "Mensaje default");
        }
        
        if(solicitante.getCodPostal()==0){
            errors.rejectValue("solicitud.solicitante.codPostal",
                    "campo-vacio",
                    new Object[]{"El campo Codigo Postal"},
                    "Mensaje default");
        }
        
        if(solicitante.getDelegacionMpio()==null){
            errors.rejectValue("solicitud.solicitante.delegacionMpio",
                    "campo-vacio",
                    new Object[]{"El campo Delegacion/Mpio"},
                    "Mensaje default");
        }
        
        if(solicitante.getEntidadFederativa()==null){
            errors.rejectValue("solicitud.solicitante.entidadFederativa",
                    "campo-vacio",
                    new Object[]{"El campo Entidad Federativa"},
                    "Mensaje default");
        }
        
      /*  if(solicitante.getTelefono() == 0){
            errors.rejectValue(
                    "solicitud.solicitante.telefono",
                    "campo-vacio",
                    new Object[]{"El campo Teléfono: "},
                    "Mensaje default");
        }*/
        
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacLimite=dateFormat.parse("01/01/1937");
        Date fechaNacSolic=dateFormat.parse("solicitante.getFechaNacimientoSolicitante()");
        if(().before fechaNacLimite){
            errors.rejectValue(
                    "solicitud.solicitante.fechaNacimientoSolicitante",
                    "información incorrecta",
                    new Object[]{"Fecha de nacimiento: "},
                    "Mensaje default");
        }*/
        
        return 0;
    }
    /**
     * Valida la página de registro de beneficiarios.
     */
    int validatePage5(Object command, Errors errors) {
        double sumaPorcentajes;
        datosSolicitud = (DatosSolicitudCommand)command;
        solicitud = datosSolicitud.getSolicitud();
        Beneficiario[] beneficiario = solicitud.getBeneficiario();
        
        sumaPorcentajes = 0;
        logger.debug("El numero de beneficiarios es " + beneficiario[0].getNumBeneficiarios());
        for(int i=0; i < beneficiario[0].getNumBeneficiarios(); i++){
            
            validarCampo(beneficiario[i].getApPaternoBeneficiario(),
                    "solicitud.beneficiario["+i+"].apPaternoBeneficiario",errors);
                        
            validarCampo(beneficiario[i].getNombre1Beneficiario(),
                    "solicitud.beneficiario["+i+"].nombre1Beneficiario",errors);
           
            validarCampo(beneficiario[i].getParentesco(),
                   "solicitud.beneficiario["+i+"].parentesco",errors);
            
            
            
           
        /*  validarCampo(new Integer(beneficiario[i].getPorcentajeAsignado()),
                "solicitud.beneficiario["+i+"].porcentajeAsignado", errors);*/
            if(beneficiario[i].getPorcentajeAsignado() != null && beneficiario[i].getPorcentajeAsignado() == 0){
                errors.rejectValue(
                        "solicitud.beneficiario["+i+"].porcentajeAsignado",
                        "campo-vacio",
                        new Object[]{"El campo Porcentaje Asignado: "},
                        "Mensaje default");
            }
            //validarCampo(beneficiario[i].getFechaNacimientoBeneficiario(),
            //      "solicitud.beneficiario["+i+"].fechaNacimientoBeneficiario", errors);
            /*validarCampo(beneficiario[i].getTipoBeneficiario(),
                    "solicitud.beneficiario["+i+"].tipoBeneficiario", errors);
            //*/
            sumaPorcentajes += beneficiario[i].getPorcentajeAsignado();
        }
        //*/
        // Validación de Negocio: si la suma de los porcentajes no es 100, error:
       /* if(sumaPorcentajes != 100){
            errors.reject("200", "La suma de los porcentajes no es 100.");
        }*/
        
        return 0;
    }

    int validatePage6(Object command, Errors errors) {
        DatosSolicitudCommand datosPoliza = (DatosSolicitudCommand)command;
        if(datosPoliza.getPolizaIndividual().getNumConsignatario()==0){
            errors.rejectValue("polizaIndividual.numConsignatario","campo-vacio",new Object[]{"El campo Numero de Consignatario"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getNumPoliza()==0){
            errors.rejectValue("polizaIndividual.numPoliza","campo-vacio",new Object[]{"El campo Numero de P&oacute;liza"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getFechaExpedicion()==null||datosPoliza.getPolizaIndividual().getFechaExpedicion().toString()==""){
            errors.rejectValue("polizaIndividual.fechaExpedicion","campo-vacio",new Object[]{"El campo Fecha de expedici&oacute;n"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getFechaInicioVigencia()==null){
            errors.rejectValue("polizaIndividual.fechaInicioVigencia","campo-vacio",new Object[]{"El campo Fecha Inicio de vigencia"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getFechaFinVigencia()==null){
            errors.rejectValue("polizaIndividual.fechaFinVigencia","campo-vacio",new Object[]{"El campo Fecha Fin de vigencia"},"Mensaje default");
        }
        if(org.apache.commons.lang.StringUtils.isEmpty(datosPoliza.getPolizaIndividual().getTipoSeguro())){
            errors.rejectValue("polizaIndividual.tipoSeguro","campo-vacio",new Object[]{"El campo Tipo de seguro"},"Mensaje default");
        }
        if(datosPoliza.getPolizaIndividual().getSumaAseguradaIndividual()==0){
            errors.rejectValue("polizaIndividual.sumaAseguradaIndividual","campo-vacio",new Object[]{"El campo Suma asegurada individual"},"Mensaje default");
        }
        return 0;
    }


    
    //* Valida Campo Tipo String
    private void validarCampo(Object campo, String pathCampo, Errors errors) {
        if(campo == null){
            errors.rejectValue(
                    pathCampo,
                    "campo-vacio",
                    new Object[]{pathCampo + ": Campo Nulo."},
                    "Mensaje default");
        } else if(campo.toString() == null) {
            errors.rejectValue(
                    pathCampo,
                    "campo-vacio",
                    new Object[]{pathCampo},
                    "Mensaje default");
      /*} else if((Integer)campo.getValue() == 0) {
         errors.rejectValue(
                 pathCampo,
                 "campo-vacio",
                 new Object[]{pathCampo},
                 "Mensaje default");*/
        }
    }
    
}
