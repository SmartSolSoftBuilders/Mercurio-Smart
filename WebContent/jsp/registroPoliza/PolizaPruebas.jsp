<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
        
        <!--agregue los nuevos campos del formulario-->
    
        <script language="JavaScript" type="text/javascript">
            function seleccionarQuery(){
            var i, valorRadioButton;
            for (i=0;i<document.w01.tipoConsulta.length;i++){ 
                if (document.w01.tipoConsulta[i].checked) 
                    break; 
            }  
            
                  
            valorRadioButton = document.w01.tipoConsulta[i].value;
                    if (valorRadioButton==1){ 
                    launch('seleccionarPolizaNumeroCertificado','Lista de Polizas -Seleccione un registro de la lista-','Tipo Seg: :tipoSeguro:tipoSeguroFrm:f:t,ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,Num. de Poliza: :numPoliza:numPolizaFrm:t:t,Num Consignatario: :numConsignatario:numConsignatarioFrm:f:t,Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t','numCertificado:'+document.getElementById('paramConsultaFrm').value,1200,600);
                    return;
                    }
            if (valorRadioButton==2){
                    launch('seleccionarPolizaRFC','Lista de Polizas -Seleccione un registro de la lista-','Tipo Seg: :tipoSeguro:tipoSeguroFrm:f:t,ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,Num. de Poliza: :numPoliza:numPolizaFrm:t:t,Num Consignatario: :numConsignatario:numConsignatarioFrm:f:t,Num Consignatario: :numConsignatario:numConsignatarioFrm2:f:t,Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t','RFCasegurado:'+document.getElementById('paramConsultaFrm').value,1200,600);
                      return;
                    }
                    if (valorRadioButton==3){
                    launch('seleccionarPolizaApPaterno','Lista de Polizas -Seleccione un registro de la lista-','Tipo Seg: :tipoSeguro:tipoSeguroFrm:f:t,ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,Num. de Poliza: :numPoliza:numPolizaFrm:t:t,Num Consignatario: :numConsignatario:numConsignatarioFrm:f:t,Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t','apPaternoAsegurado:'+document.getElementById('paramConsultaFrm').value,1200,600);
                          return;
                    }
                    if (valorRadioButton==4){
                    launch('seleccionarPolizaNum','Lista de Polizas -Seleccione un registro de la lista-','Tipo Seg: :tipoSeguro:tipoSeguroFrm:f:t,ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,Num. de Poliza: :numPoliza:numPolizaFrm:t:t,Num Consignatario: :numConsignatario:numConsignatarioFrm:f:t,Num Consignatario: :numConsignatario:numConsignatarioFrm2:f:t,Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t','numPoliza:'+document.getElementById('paramConsultaFrm').value,1200,600);
                          return;
                    }
                    if (valorRadioButton==5){
                    launch('seleccionarPolizaNumContratante','Lista de Polizas -Seleccione un registro de la lista-','Tipo Seg: :tipoSeguro:tipoSeguroFrm:f:t,ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,Num. de Poliza: :numPoliza:numPolizaFrm:t:t,Num Consignatario: :numConsignatario:numConsignatarioFrm:f:t,Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t','numNominaContratante:'+document.getElementById('paramConsultaFrm').value,1200,600);
                          return;
                    }
                    if (valorRadioButton==6){
                    launch('seleccionarPolizaApPaternoContratante','Lista de Polizas -Seleccione un registro de la lista-','Tipo Seg: :tipoSeguro:tipoSeguroFrm:f:t,ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,Num. de Poliza: :numPoliza:numPolizaFrm:t:t,Num Consignatario: :numConsignatario:numConsignatarioFrm:f:t,Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t, TipoMovimientoPoliza: :tipoMovimientoPoliza:tipoMovimientoPolizaFrm:t:f','apPaternoContratante:'+document.getElementById('paramConsultaFrm').value,1200,600);
                   // alert("gjhgjh1");
                          return;
                    }
                   
           }
                                                   </script>
        <script language="JavaScript" type="text/javascript">
           function validaEstatusPoliza(){
            var param=document.w01.idEstatusPagosPolizaFrm.value;
           // alert(param);
                if(param >1){
                alert("A continuación de clic en el botón 'Generar Reporte Desc.' ");
                
                w01.val.type="hidden";
                w01.desc.type="submit";
                w01.val.disabled=true;
                            }
                            
                            else{alert("La póliza no cuenta aún con descuentos aplicados");}
            }

        </script>
        
        <script language="JavaScript" type="text/javascript">
        function concatenar(){
        
        var param=1;
        var param=2;
        var r=param1+param2;
        document.w01.nadaFrm.value=r;
        
       
        }
        
        
        function calcularTotalProteccion() {
            var sumind = parseFloat(document.w01.sumaAseguradaIndividualFrm.value);
            var sumcol = parseFloat(document.w01.sumaAseguradaColectivaFrm.value);
            var tot=sumind+sumcol;
            document.w01.totalProteccionFrm.value =tot,2;
            }
            
            function cambiarColor(){ 
                document.w01.totalProteccionFrm.style.backgroundColor="ffefab" 
                document.w01.importeTarifaFrm.style.backgroundColor="ffefab"
                
            }
            
            

        </script>
        <script language="javascript"> 

function formatMoneda(num,longEntera, decSep,thousandSep) {
var arg;
var entero;

if(typeof(num) == 'undefined') return;
if(typeof(decSep) == 'undefined') decSep = ',';
if(typeof(thousandSep) == 'undefined') thousandSep = '.';

if(thousandSep == '.'){
arg=/\./g;
}else if(thousandSep == ','){
arg=/\,/g;
}

if(typeof(arg) != 'undefined'){
num = num.toString().replace(arg,'');
}

num = num.toString().replace(/,/g,'.');

if (num.indexOf('.') != -1)
{
entero = num.substring(0, num.indexOf('.'));
}
else entero = num;


if (entero.length > longEntera)
{
alert("El número introducido excede de " + longEntera + " digitos en su parte entera");
return "0,00";
}

if(isNaN(num))
num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();

if(cents<10)
cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3))+thousandSep+ num.substring(num.length-(4*i+3));
return (((sign)?'':'-') + num + decSep + cents);
}





        </script>
        
        
        
        <title>Consulta de p&oacute;lizas de seguro capturadas</title>
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <tag:errors name="datosPoliza"/>
        <spring:nestedPath path="datosPoliza">
            <!--tag:errors name="datosPoliza"/-->
            <!--spring:nestedPath path="datosPoliza"-->
            <div ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
            <form action="#" method="post" name="w01">            
                <input type="hidden" name="_page0" value="0" />
                <div id="title589x16">Consulta de polizas de seguro</div>
                <div class="row660" align="center">
                    <span class="field588">
                        Consultar por:&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="1" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de certificado&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="2" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2">RFC del asegurado&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="3" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del asegurado&nbsp;&nbsp;
                    </span>
                </div>
                <div class="row660" align="center">
                    <span class="field588">
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="4" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de P&oacute;liza&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="5" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2">Num n&oacute;mina contratante&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="6" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del contratante&nbsp;&nbsp;
                    </span>
                </div>
                <div class="row660" align="center">
                    <span class="field588">
                        Por:&nbsp;&nbsp;
                        <input type="text" name="paramConsulta" id="paramConsultaFrm" disabled="true"  class="input" tabindex="4"/><br>
                        <input type="button" class="input" name="elegirPoliza" id="elegirPolizaFrm" value="Consultar" disabled="true" onclick="seleccionarQuery(),paramConsultaFrm.disabled=true, _target1.disabled=false;" tabindex="5"/>
                        <input type="reset" class="input" value="Limpiar." width="52" height="19" border="0" tabindex="6"/>
                    </span>
                </div>
                
                <!--Seccion de poliza individual-->
                <div class="row660" align="center">&nbsp;</div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16" onmouseover="calcularTotalProteccion();cambiarColor();">P&oacute;liza individual</div>
                <div class="row660">
                    <!--input type="hidden" name="importePrimaInd" id="importePrimaIndFrm" /-->
                    <!--spring:bind path="polizaIndividual.solicitud.certificadoindividual.numCertificado"-->
                    <!--input type="hidden" name="numCertificado" id="numCertificadoFrm"  readonly class="input"/--> 
                    <!--/spring:bind-->
                      
                    <label class="label135">N&uacute;mero:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <spring:bind path="polizaIndividual.numPoliza">
                            <input type="text" name="${status.expression}"  id="numPolizaFrm" value="${status.value}" readonly class="input"/>    
                        </spring:bind>
                        
                    </span>
                    
                    <spring:bind path="polizaIndividual.numConsignatario">
                            <input type="hidden" name="${status.expression}"  id="numConsignatarioFrm" value="${status.value}" readonly class="input"/>    
                    </spring:bind>
                    
                    <spring:bind path="polizaIndividual.tipoMovimientoPoliza">
                            <input type="hidden" name="${status.expression}"  id="tipoMovimientoPolizaFrm" value="${status.value}" readonly class="input"/>    
                    </spring:bind>
                    
                    <label class="label135">Certificado individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.numCertificadoIndividual"-->
                        <input type="text" name="cvePlaza" id="cvePlazaFrm" size="3" readonly class="input"/>
                        <input type="text" name="numCertificado" id="numCertificadoFrm" size="3" readonly class="input"/>
                        <!--/spring:bind-->
                    </span>
                    
                    <label class="label135">Tipo de S&eacute;guro:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="tipoSeguro"  id="tipoSeguroFrm" readonly class="input"/>    
                    </span>
                    <label class="label135">Imp de Tarifa.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importeTarifa" id="importeTarifaFrm"  readonly class="input"/>
                    </span>
                    
                    <label class="label135">Imp prima indiv.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importePrimaInd" id="importePrimaIndFrm"  readonly class="input"/>
                    </span> 
                    <label class="label135">Imp prima colect.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importePrimaColectiva" id="importePrimaColectivaFrm"  readonly class="input"/>
                    </span>
                    <label class="label135">Suma asg individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="sumaAseguradaIndividual" id="sumaAseguradaIndividualFrm"  readonly class="input" onChange="suma();"/>
                    </span>
                    <label class="label135">Suma asg colectiva:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text"  name="sumaAseguradaColectiva" id="sumaAseguradaColectivaFrm"  readonly class="input" onChange="suma();"/>
                    </span>
                    <label class="label330" >Total de proctecci&oacute;n:&nbsp;&nbsp;</label>
                    <span class="field330">
                         <INPUT type="text" name="txtCampo" value="" id="totalProteccionFrm"  ONMOUSEMOVE="this.value=formatMoneda(this.value, 9);" MAXLENGTH="16" class="input" readonly>
                       <!--input type="text" name="totalProteccion" id="totalProteccionFrm"   class="input"/-->
                        
                    </span>
                    
                    <label class="label330">Estatus de seguimiento:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <input type="text" name="descripcionEstatusPoliza" size="40" id="descripcionEstatusPolizaFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                    <label class="label330">Estatus en pagos:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <input type="hidden" name="idEstatusPagosPolizaFrm"  id="idEstatusPagosPolizaFrm" />
                        <input type="text" name="descripcionEstatusPagosPoliza" size="40" id="descripcionEstatusPagosPolizaFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                    
                    <div class="row660" align="center">&nbsp;</div>
                    <div id="titleg664x16">Agente</div>
                    <div class="row660">
                        <div align="center" class="submit664">                       
                            <input type="text" name="cveAgente" id="cveAgenteFrm" size="5" readonly class="input"/>
                            <input type="text" align="center" name="apPaternoEmpleado" id="apPaternoEmpleadoFrm" size="15" readonly class="input" />
                            <input type="text" align="center" name="apMaternoEmpleado" id="apMaternoEmpleadoFrm"  size="15" readonly class="input"/>
                            <input align="center" type="text" name="nombre1Empleado" id="nombre1EmpleadoFrm" size="15" readonly class="input"/>
                            <input type="text" align="center" name="nombre2Empleado" id="nombre2EmpleadoFrm" size="15" readonly class="input"/>
                        </div>
                    </div>
                </div>  
                <div class="row660" align="left">&nbsp;</div>
                <div id="titleg664x16">Vigencia</div>
                <div class="row660">
                <label class="label135">Fecha Inicio:&nbsp;&nbsp;</label>
                <span class="field195">
                    <!--spring:bind path="polizaindividual.solicitud.asegurado.fechaInicioVigencia"-->
                    <input type="text"  name="fechaInicioVigencia" id="fechaInicioVigenciaFrm" readonly  class="input"/>
                    <!--/spring:bind--> 
                </span>
                <label class="label135">Fecha Fin:&nbsp;&nbsp;</label>
                <span class="field195">
                    <!--spring:bind path="polizaindividual.solicitud.asegurado.fechaFinVigencia"-->
                    <input type="text"  name="fechaFinVigencia" id="fechaFinVigenciaFrm" readonly class="input"/>
                    <!--/spring:bind-->
                </span>
                <label class="label330">Fecha Expedici&oacute;n:&nbsp;&nbsp;</label>
                <span class="field330">
                    <!--spring:bind path="polizaindividual.solicitud.asegurado.fechaExpedicion"-->
                    <input type="text"  name="fechaExpedicion" id="fechaExpedicionFrm" readonly class="input"/>
                    <!--/spring:bind-->
                </span>
                </div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Contratante</div>
                <div class="row660">
                    <div class="row660">
                        <label class="label330">No. de empleado:&nbsp;&nbsp;</label>
                        <span class="field330">
                            <!--spring:bind path="polizaIndividual.solicitud.contratante.numNominaContratante"-->
                            <input type="text" name="numNominaContratante"  id="numNominaContratanteFrm" readonly  class="input"/>
                            <!--/spring:bind-->
                        </span>
                    </div>
                    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>                    
                    <span class="field195">
                        <input type="text" name="apPaternoContratante"  id="apPaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="apMaternoContratante"  id="apMaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                </div>               
                <div class="row660">    
                <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="nombre1Contratante"  id="nombre1ContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="nombre2Contratante"  id="nombre2ContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                </div>
                
                
                <!--Seccion del asegurado-->
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Asegurado</div>
                <div class="row660">
                    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.apPaternoAsegurado"-->
                        <input type="text" name="apPaternoAsegurado" id="apPaternoAseguradoFrm"  class="input" readonly onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <!--/spring:bind-->
                    </span>
                    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.apMaternoAsegurado"-->
                        <input type="text" name="apMaternoAsegurado" id="apMaternoAseguradoFrm" readonly  class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        <!--/spring:bind-->
                    </span>
                </div>
                <div class="row660">
                    <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.nombre1Asegurado"-->
                        <input type="text" name="nombre1Asegurado" id="nombre1AseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <!--/spring:bind-->
                    </span>
                    <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.nombre2Asegurado"-->
                        <input type="text" name="nombre2Asegurado"  id="nombre2AseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        <!--/spring:bind-->
                    </span>
                </div>
                <div class="row660">    
                    <label class="label135">RFC:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.RFCasegurado"-->
                        <input type="text" name="RFCasegurado" id="RFCaseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <!--/spring:bind-->
                    </span>
                    <label class="label135">Fecha nacimiento:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.fechaNacimientoAsegurado"-->
                        <input type="text" name="fechaNacimientoAsegurado" readonly id="fechaNacimientoAseguradoFrm"  class="input"/>
                        <!--/spring:bind-->
                    </span>                 
                </div>
                
                
                <div>
                    <span><input type="hidden" name="numPoliza"  id="numPolizaFrm2"  class="input"/>    </span>
                </div>
                <div>
                    <span><input type="hidden" name="numConsignatario"  id="numConsignatarioFrm2"  class="input"/>    </span>
                </div>
                                
                <div class="row660" align="center">&nbsp;</div>
                <div align="center" class="submit664">
                    <!--<input type="button" class="input" id="val" value="Ver Desc. Aplicados" onClick="validaEstatusPoliza();"/>
                    <input type="hidden" class="input" name="_finish" id="desc" value="Generar Reporte Desc." /> -->
                    <a href="<c:url value="/"/>app/logoutcontroller">
                        <input type="button" value="Salir" class="input" tabindex="9"/>
                    </a>
                    
                </div>
            <!--</form>-->
            
            <!--<form name="w02" method="POST">-->
                
                <!--<script>
                    /*function obtenNumeroPoliza(){
                                               
                        document.forms[1].action = "<c:url value="/"/>app/cancelarPolizaController?poliza=" + document.forms[0].numPoliza.value + "&numConsignatario=" + document.forms[0].numConsignatario.value;                        
                        document.forms[1].submit();
                    }*/
                </script>-->
                <!--<script>
                    /*function obtenNumeroPoliza2(){
                        document.forms[1].action="<c:url value="/"/>app/autofinanciarPolizaCancelController?poliza="+document.forms[0].numPoliza.value;
                        document.forms[1].submit();
                    }*/
                </script>-->
                <!--<script>
                    /*function prueba(){                    
                    var param = document.forms[0].numPoliza.value;
                        alert("numPoliza "+param);
                    }*/
                </script>-->
                <div align="center" class="submit664">
                    <!--<a href="cancelar" id="cancelar" name="finish" onclick="javascript:obtenNumeroPoliza()" >Cancelar</a>-->
                    <input type="submit" class="input" name="_target1" value="Cancelar p&oacute;liza"/>
                    <input type="button" class="input" name="finish" value="Suspender p&oacute;liza"/>
                </div>    
            </form>
            
        </spring:nestedPath>
    </body>
</html>
