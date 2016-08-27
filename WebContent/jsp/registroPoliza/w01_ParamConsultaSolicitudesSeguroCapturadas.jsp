<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css" />
    
    <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>" type="text/javascript"></script>
    <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>" type="text/javascript"></script>
    
    <script language="JavaScript" type="text/javascript">
            function seleccionarQuery(){
            var i, valorRadioButton;
            for (i=0;i<document.w01.tipoConsulta.length;i++){ 
                if (document.w01.tipoConsulta[i].checked) 
                    break; 
            }  
            valorRadioButton = document.w01.tipoConsulta[i].value;
                    if (valorRadioButton==1){                                                                                                           
                        launch('seleccionarSolicitudNumCertif','Lista de Solicitudes -Seleccione un registro de la lista-','IdEstSol: :idEstatusSolicitud:idEstatusSolicitudFrm:f:t,Num. de Certificado: :certificadoindividual.numCertificado:numCertificadoFrm:t:t,Estatus de la Solicitud: :estatusSolicitud.descripcionEstatusSolicitud:descripcionEstatusSolicitudFrm:f:t,Ap. Paterno (solicitante): :solicitante.apPaternoSolicitante:apPaternoSolicitanteFrm:t:t,Ap. Materno (solicitante): :solicitante.apMaternoSolicitante:apMaternoSolicitanteFrm:t:t,Primer Nombre (solicitante): :solicitante.nombre1Solicitante:nombre1SolicitanteFrm:t:t,Segundo Nombre (solicitante): :solicitante.nombre2Solicitante:nombre2SolicitanteFrm:t:t,RFC (solicitante): :solicitante.RFCsolicitante:RFCsolicitanteFrm:t:t,Tarifa aport. mensual: :tarifa.descripcion:importePrimaIndFrm:t:t,Folio de la solicitud: :folioSolicitud:folioSolicitudFrm:f:t,Formato de la solicitud: :formatoSolicitud:formatoSolicitudFrm:f:t,Fecha de nacimiento: :solicitante.fechaNacimientoSolicitante:fechaNacimientoSolicitanteFrm:f:t,Calle: :solicitante.calle:calleFrm:f:t,Edificio: :solicitante.edificio:edificioFrm:f:t,Num. Ext/Int. : :solicitante.numExtInt:numExtIntFrm:f:t,Colonia: :solicitante.colonia:coloniaFrm:t:t,Codigo Postal: :solicitante.codPostal:codPostalFrm:f:t,Delegacion/Mpio: :solicitante.delegacionMpio:delegacionMpioFrm:f:t,Ciudad/Poblacion: :solicitante.ciudadPoblacion:ciudadPoblacionFrm:f:t,Entidad Federativa: :solicitante.entidadFederativa:entidadFederativaFrm:f:t,Suma asegurada colectiva: :tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Empresa: :empresa.nombreEmpresa:nombreEmpresaFrm:f:t,Sucursal: :empresa.sucursal.nombreSucursal:nombreSucursalFrm:f:t,Grupo Asegurado: :empresa.grupoAsegurado.nombreGrupoAsegurado:nombreGrupoAseguradoFrm:f:t,Ap. Paterno (contratante): :contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :contratante.nombre2Contratante:nombre2ContratanteFrm:f:t,Fecha de solicitud: :fechaSolicitud:fechaSolicitudFrm:t:f,Puesto: :solicitante.puestoSolicitante:puestoSolicitanteFrm:f:t,Sexo: :solicitante.sexoSolicitanteMasculino:sexoSolicitanteFrm:f:t,Estado civil: :solicitante.estadoCivilSolicitante:estadoCivilFrm:f:t,Ingreso mensual: :solicitante.ingresoMensualSolicitante:ingresoMensualFrm:f:t,Lada: :solicitante.lada:ladaFrm:f:t,Telefono: :solicitante.telefono:telefonoFrm:f:t,Email: :solicitante.email:emailFrm:f:t','numCertificado:'+document.getElementById('paramConsultaFrm').value,1024,400);
                        return;
                    }
            if (valorRadioButton==2){                                                                                                           
                        launch('seleccionarSolicitudRFC','Lista de Solicitudes -Seleccione un registro la lista-','IdEstSol: :idEstatusSolicitud:idEstatusSolicitudFrm:f:t,Num. de Certificado: :certificadoindividual.numCertificado:numCertificadoFrm:t:t,Estatus de la Solicitud: :estatusSolicitud.descripcionEstatusSolicitud:descripcionEstatusSolicitudFrm:f:t,Ap. Paterno (solicitante): :solicitante.apPaternoSolicitante:apPaternoSolicitanteFrm:t:t,Ap. Materno (solicitante): :solicitante.apMaternoSolicitante:apMaternoSolicitanteFrm:t:t,Primer Nombre (solicitante): :solicitante.nombre1Solicitante:nombre1SolicitanteFrm:t:t,Segundo Nombre (solicitante): :solicitante.nombre2Solicitante:nombre2SolicitanteFrm:t:t,RFC (solicitante): :solicitante.RFCsolicitante:RFCsolicitanteFrm:t:t,Tarifa aport. mensual: :tarifa.descripcion:importePrimaIndFrm:t:t,Folio de la solicitud: :folioSolicitud:folioSolicitudFrm:f:t,Formato de la solicitud: :formatoSolicitud:formatoSolicitudFrm:f:t,Fecha de nacimiento: :solicitante.fechaNacimientoSolicitante:fechaNacimientoSolicitanteFrm:f:t,Calle: :solicitante.calle:calleFrm:f:t,Edificio: :solicitante.edificio:edificioFrm:f:t,Num. Ext/Int. : :solicitante.numExtInt:numExtIntFrm:f:t,Colonia: :solicitante.colonia:coloniaFrm:t:t,Codigo Postal: :solicitante.codPostal:codPostalFrm:f:t,Delegacion/Mpio: :solicitante.delegacionMpio:delegacionMpioFrm:f:t,Ciudad/Poblacion: :solicitante.ciudadPoblacion:ciudadPoblacionFrm:f:t,Entidad Federativa: :solicitante.entidadFederativa:entidadFederativaFrm:f:t,Suma asegurada colectiva: :tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Empresa: :empresa.nombreEmpresa:nombreEmpresaFrm:f:t,Sucursal: :empresa.sucursal.nombreSucursal:nombreSucursalFrm:f:t,Grupo Asegurado: :empresa.grupoAsegurado.nombreGrupoAsegurado:nombreGrupoAseguradoFrm:f:t,Ap. Paterno (contratante): :contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :contratante.nombre2Contratante:nombre2ContratanteFrm:f:t,Fecha de solicitud: :fechaSolicitud:fechaSolicitudFrm:t:f,Puesto: :solicitante.puestoSolicitante:puestoSolicitanteFrm:f:t,Sexo: :solicitante.sexoSolicitanteMasculino:sexoSolicitanteFrm:f:t,Estado civil: :solicitante.estadoCivilSolicitante:estadoCivilFrm:f:t,Ingreso mensual: :solicitante.ingresoMensualSolicitante:ingresoMensualFrm:f:t,Lada: :solicitante.lada:ladaFrm:f:t,Telefono: :solicitante.telefono:telefonoFrm:f:t,Email: :solicitante.email:emailFrm:f:t','RFCsolicitante:'+document.getElementById('paramConsultaFrm').value,1024,400);
                        return;
                    }
                    if (valorRadioButton==3){
                        launch('seleccionarSolicitudNombre','Lista de Solicitudes -Seleccione un registro de la lista-','IdEstSol: :idEstatusSolicitud:idEstatusSolicitudFrm:f:t,Num. de Certificado: :certificadoindividual.numCertificado:numCertificadoFrm:t:t,Estatus de la Solicitud: :estatusSolicitud.descripcionEstatusSolicitud:descripcionEstatusSolicitudFrm:f:t,Ap. Paterno (solicitante): :solicitante.apPaternoSolicitante:apPaternoSolicitanteFrm:t:t,Ap. Materno (solicitante): :solicitante.apMaternoSolicitante:apMaternoSolicitanteFrm:t:t,Primer Nombre (solicitante): :solicitante.nombre1Solicitante:nombre1SolicitanteFrm:t:t,Segundo Nombre (solicitante): :solicitante.nombre2Solicitante:nombre2SolicitanteFrm:t:t,RFC (solicitante): :solicitante.RFCsolicitante:RFCsolicitanteFrm:t:t,Tarifa aport. mensual: :tarifa.descripcion:importePrimaIndFrm:t:t,Folio de la solicitud: :folioSolicitud:folioSolicitudFrm:f:t,Formato de la solicitud: :formatoSolicitud:formatoSolicitudFrm:f:t,Fecha de nacimiento: :solicitante.fechaNacimientoSolicitante:fechaNacimientoSolicitanteFrm:f:t,Calle: :solicitante.calle:calleFrm:f:t,Edificio: :solicitante.edificio:edificioFrm:f:t,Num. Ext/Int. : :solicitante.numExtInt:numExtIntFrm:f:t,Colonia: :solicitante.colonia:coloniaFrm:t:t,Codigo Postal: :solicitante.codPostal:codPostalFrm:f:t,Delegacion/Mpio: :solicitante.delegacionMpio:delegacionMpioFrm:f:t,Ciudad/Poblacion: :solicitante.ciudadPoblacion:ciudadPoblacionFrm:f:t,Entidad Federativa: :solicitante.entidadFederativa:entidadFederativaFrm:f:t,Suma asegurada colectiva: :tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Empresa: :empresa.nombreEmpresa:nombreEmpresaFrm:f:t,Sucursal: :empresa.sucursal.nombreSucursal:nombreSucursalFrm:f:t,Grupo Asegurado: :empresa.grupoAsegurado.nombreGrupoAsegurado:nombreGrupoAseguradoFrm:f:t,Ap. Paterno (contratante): :contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :contratante.nombre2Contratante:nombre2ContratanteFrm:f:t,Fecha de solicitud: :fechaSolicitud:fechaSolicitudFrm:t:f,Puesto: :solicitante.puestoSolicitante:puestoSolicitanteFrm:f:t,Sexo: :solicitante.sexoSolicitanteMasculino:sexoSolicitanteFrm:f:t,Estado civil: :solicitante.estadoCivilSolicitante:estadoCivilFrm:f:t,Ingreso mensual: :solicitante.ingresoMensualSolicitante:ingresoMensualFrm:f:t,Lada: :solicitante.lada:ladaFrm:f:t,Telefono: :solicitante.telefono:telefonoFrm:f:t,Email: :solicitante.email:emailFrm:f:t','nombreSolicitante:'+document.getElementById('paramConsultaFrm').value,1024,400);
                        return;
                    }
                    
                    if (valorRadioButton==4){
                        launch('seleccionarSolicitudSoloFolio','Lista de Solicitudes -Seleccione un registro de la lista-','IdEstSol: :idEstatusSolicitud:idEstatusSolicitudFrm:f:t,Num. de Certificado: :certificadoindividual.numCertificado:numCertificadoFrm:t:t,Estatus de la Solicitud: :estatusSolicitud.descripcionEstatusSolicitud:descripcionEstatusSolicitudFrm:f:t,Ap. Paterno (solicitante): :solicitante.apPaternoSolicitante:apPaternoSolicitanteFrm:t:t,Ap. Materno (solicitante): :solicitante.apMaternoSolicitante:apMaternoSolicitanteFrm:t:t,Primer Nombre (solicitante): :solicitante.nombre1Solicitante:nombre1SolicitanteFrm:t:t,Segundo Nombre (solicitante): :solicitante.nombre2Solicitante:nombre2SolicitanteFrm:t:t,RFC (solicitante): :solicitante.RFCsolicitante:RFCsolicitanteFrm:t:t,Tarifa aport. mensual: :tarifa.descripcion:importePrimaIndFrm:t:t,Folio de la solicitud: :folioSolicitud:folioSolicitudFrm:f:t,Formato de la solicitud: :formatoSolicitud:formatoSolicitudFrm:f:t,Fecha de nacimiento: :solicitante.fechaNacimientoSolicitante:fechaNacimientoSolicitanteFrm:f:t,Calle: :solicitante.calle:calleFrm:f:t,Edificio: :solicitante.edificio:edificioFrm:f:t,Num. Ext/Int. : :solicitante.numExtInt:numExtIntFrm:f:t,Colonia: :solicitante.colonia:coloniaFrm:f:t,Codigo Postal: :solicitante.codPostal:codPostalFrm:f:t,Delegacion/Mpio: :solicitante.delegacionMpio:delegacionMpioFrm:f:t,Ciudad/Poblacion: :solicitante.ciudadPoblacion:ciudadPoblacionFrm:f:t,Entidad Federativa: :solicitante.entidadFederativa:entidadFederativaFrm:f:t,Suma asegurada colectiva: :tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,Empresa: :empresa.nombreEmpresa:nombreEmpresaFrm:f:t,Sucursal: :empresa.sucursal.nombreSucursal:nombreSucursalFrm:f:t,Grupo Asegurado: :empresa.grupoAsegurado.nombreGrupoAsegurado:nombreGrupoAseguradoFrm:f:t,Ap. Paterno (contratante): :contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,No. de empleado: :contratante.numNominaContratante:numNominaContratanteFrm:f:t,Ap. Materno (contratante): :contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,Primer Nombre (contratante): :contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,Segundo Nombre (contratante): :contratante.nombre2Contratante:nombre2ContratanteFrm:f:t,Fecha de solicitud: :fechaSolicitud:fechaSolicitudFrm:t:f,Puesto: :solicitante.puestoSolicitante:puestoSolicitanteFrm:f:t,Sexo: :solicitante.sexoSolicitanteMasculino:sexoSolicitanteFrm:f:t,Estado civil: :solicitante.estadoCivilSolicitante:estadoCivilFrm:f:t,Ingreso mensual: :solicitante.ingresoMensualSolicitante:ingresoMensualFrm:f:t,Lada: :solicitante.lada:ladaFrm:f:t,Telefono: :solicitante.telefono:telefonoFrm:f:t,Email: :solicitante.email:emailFrm:f:t','folioSolicitud:'+document.getElementById('paramConsultaFrm').value,1024,400);
                        return;
                    }
           }
    </script>
    
    <script language="JavaScript" type="text/javascript">
           function validaEstatusSolicitud(){
                var param=document.w01.idEstatusSolicitudFrm.value;
                if(param ==1){
                    alert("A continuación de clic en el botón 'Siguiente' para continuar la captura");
                    w01.val.type="hidden";
                    w01.sig.type="submit";
                    w01.val.disabled=true;
                }
                else{
                    alert("Como se indica en la pantalla,esta Solicitud ya cuenta con una poliza emitida.No lo intente nuevamente");
                    cambiarColor();
                }
            }
            
            
            function cambiarColor(){ 
                document.w01.descripcionEstatusSolicitudFrm.style.backgroundColor="ffefab" 
                           
            }

    </script>
    
    <title>Consulta de solicitudes de seguro capturadas</title>
</head>

<body>
<jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
<tag:errors name="datosPoliza"/>
<spring:nestedPath path="datosPoliza">
<div ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
<form action="#" method="post" name="w01">            
<input type="hidden" name="_page0" value="0" />
<div id="title589x16">Consulta de solicitudes de seguro capturadas</div>
<div class="row660" align="center">
    <span class="field588">
        Consultar por:&nbsp;&nbsp;
        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="4" onclick="elegirSolicitudFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="4"/>Folio de Solicitud
        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="1" onclick="elegirSolicitudFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de certificado
    </span>
</div>
<div class="row660" align="center">
    <span class="field588">
        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="2" onclick="elegirSolicitudFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2"/>RFC del solicitante
        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="3" onclick="elegirSolicitudFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del solicitante
        
    </span>
</div>
<div class="row660" align="center">
    <span class="field588">
        Par&aacute;metro:&nbsp;&nbsp;
        <input type="text" name="paramConsulta" id="paramConsultaFrm" disabled="true"  class="input" tabindex="4"/>
        <input type="button" class="input" name="elegirSolicitud" id="elegirSolicitudFrm" value="Consultar" disabled="true" onclick="seleccionarQuery(),paramConsultaFrm.disabled=true, _target1.disabled=false;" tabindex="5"/>
        <input type="reset" class="input" value="Limpiar." tabindex="6"/>
    </span>
</div>

<div class="row660" align="center">&nbsp;</div>
<div id="titleg664x16">Resultados de consulta</div>
<div class="row660">
    <input type="hidden" name="importePrimaInd" id="importePrimaIndFrm" />
    <spring:bind path="polizaIndividual.solicitud.certificadoindividual.numCertificado">
        <input type="hidden" name="${status.expression}" id="numCertificadoFrm" value="${status.value}" readonly class="input"/> 
    </spring:bind>
    <label class="label330">Folio de la solicitud:&nbsp;&nbsp;</label>
    <span class="field330">
        <spring:bind path="polizaIndividual.solicitud.folioSolicitud">
            <input type="text" name="${status.expression}" id="folioSolicitudFrm" value="${status.value}" readonly class="input"/>
        </spring:bind>
    </span>  
</div>
<div class="row660">
    <label class="label330">N&uacute;mero de Formato:&nbsp;&nbsp;</label>
    <span class="field330">
        <spring:bind path="polizaIndividual.solicitud.formatoSolicitud">
            <input type="text" name="${status.expression}" id="formatoSolicitudFrm" value="${status.value}" readonly class="input"/>
        </spring:bind>
    </span>
    
</div>
<div class="row660">
    <label class="label330">Estatus de solicitud:&nbsp;&nbsp;</label>
    <span class="field330">
        <!--spring:bind path="polizaIndividual.solicitud.estatussolicitud.descripcionEstatusSolicitud"-->
        <input type="text" name="descripcionEstatusSolicitud" id="descripcionEstatusSolicitudFrm" readonly class="input" />
        <!--/spring:bind-->
        <input type="hidden" name="idEstatusSolicitud" id="idEstatusSolicitudFrm" readonly class="input" />
    </span>
    
</div>
<div class="row660" align="center">&nbsp;</div>
<div id="titleg664x16">Solicitante</div>
<div class="row660">
    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.apPaternoSolicitante">
            <input type="text" name="${status.expression}" id="apPaternoSolicitanteFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>
    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.apMaternoSolicitante">
            <input type="text" name="${status.expression}" id="apMaternoSolicitanteFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
        </spring:bind>
    </span>
</div>
<div class="row660">
    <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.nombre1Solicitante">
            <input type="text" name="${status.expression}" id="nombre1SolicitanteFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>
    <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.nombre2Solicitante">
            <input type="text" name="${status.expression}"  id="nombre2SolicitanteFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
        </spring:bind>
    </span>
</div>
<div class="row660">    
    <label class="label135">RFC:&nbsp;&nbsp;</label>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.RFCsolicitante">
            <input type="text" name="${status.expression}" id="RFCsolicitanteFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>
    <label class="label135">Fecha nacimiento:&nbsp;&nbsp;</label>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.fechaNacimientoSolicitante">
            <input type="text" name="${status.expression}"  id="fechaNacimientoSolicitanteFrm" readonly value="${status.value}" class="input" />
        </spring:bind>
    </span>                 
</div>
<div class="row660">
    <label class="label330">Suma asegurada colectiva:&nbsp;&nbsp</label>
    <span class="field330">
        <input type="text" name="sumaAseguradaColectiva" id="sumaAseguradaColectivaFrm" readonly class="input"/>
    </span>
</div>
<spring:bind path="polizaIndividual.solicitud.solicitante.puestoSolicitante">
    <input type="hidden" name="${status.expression}" id="puestoSolicitanteFrm" value="${status.value}"/>
</spring:bind>
<spring:bind path="polizaIndividual.solicitud.solicitante.sexoSolicitanteMasculino">
    <input type="hidden" name="${status.expression}" id="sexoSolicitanteFrm" value="${status.value}"/>
</spring:bind>
<spring:bind path="polizaIndividual.solicitud.solicitante.estadoCivilSolicitante">
    <input type="hidden" name="${status.expression}" id="estadoCivilFrm"  value="${status.value}"/>
</spring:bind>
<spring:bind path="polizaIndividual.solicitud.solicitante.ingresoMensualSolicitante">
    <input type="hidden" name="${status.expression}" id="ingresoMensualFrm" value="${status.value}"/>
</spring:bind>
<spring:bind path="polizaIndividual.solicitud.solicitante.lada">
    <input type="hidden" name="${status.expression}" id="ladaFrm" value="${status.value}"/>
</spring:bind>
<spring:bind path="polizaIndividual.solicitud.solicitante.telefono">
    <input type="hidden" name="${status.expression}" id="telefonoFrm" value="${status.value}"/>
</spring:bind>
<spring:bind path="polizaIndividual.solicitud.solicitante.email">
    <input type="hidden" name="${status.expression}" id="emailFrm" value="${status.value}"/>
</spring:bind>
<div class="row660" align="center">&nbsp;</div>
<div id="title589x16">Domicilio del Solicitante</div>
<div class="row592">
    <label class="label195x21">Calle:&nbsp;&nbsp;</label>          
    <label class="label195x21">Edificio:&nbsp;&nbsp;</label>
    <label class="label195x21">No. ext./ No. int.:&nbsp;&nbsp;</label>    
</div>
<div class="row592">
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.calle">
            <input type="text" name="${status.expression}" id="calleFrm" readonly value="${status.value}" class="input" size="28" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>             
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.edificio">
            <input type="text" name="${status.expression}" id="edificioFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>	      
    
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.numExtInt">
            <input type="text" name="${status.expression}" id="numExtIntFrm" readonly value="${status.value}" class="input"/>    
        </spring:bind>
    </span>	      
</div>             
<div class="row592">
    <label class="label195x21">Colonia/Fraccionamiento:&nbsp;&nbsp;</label>       
    <label class="label195x21">&nbsp;</label>
    <label class="label195x21">C&oacute;digo Postal:&nbsp;&nbsp;</label>                
</div>               
<div class="row660">
    <span class="field296">
        <spring:bind path="polizaIndividual.solicitud.solicitante.colonia">
            <input type="text" name="${status.expression}" id="coloniaFrm"  size="40" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/> 
        </spring:bind>
    </span>
    <label class="label97x31">&nbsp;</label>
    <!--span class="field195">&nbsp;&nbsp;</span-->
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.codPostal">
            <input type="text" name="${status.expression}" id="codPostalFrm" readonly value="${status.value}" class="input"/>    
        </spring:bind>
    </span>       
</div>
<div class="row592">
    <label class="label195x21">Delegaci&oacute;n/Municipio:&nbsp;&nbsp;</label>    
    <label class="label195x21">Ciudad/Poblaci&oacute;n:&nbsp;&nbsp;</label>                
    <label class="label195x21">Entidad Federativa:&nbsp;&nbsp;</label>
</div>
<div class="row592">
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.delegacionMpio">
            <input type="text" name="${status.expression}" id="delegacionMpioFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>	      
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.ciudadPoblacion">
            <input type="text" name="${status.expression}" id="ciudadPoblacionFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>
    <span class="field195">
        <spring:bind path="polizaIndividual.solicitud.solicitante.entidadFederativa">
            <input type="text" name="${status.expression}" id="entidadFederativaFrm" readonly value="${status.value}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
        </spring:bind>
    </span>
</div>
<div class="row660" align="center">&nbsp;</div>

<div id="titleg664x16">Grupo asegurado</div>
<div class="row660">
    <label class="label135">Grupo:&nbsp;&nbsp;</label>
    <span class="field195">
        <input type="text" name="nombreGrupoAsegurado" id="nombreGrupoAseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/> 
    </span>
    <label class="label135">Sucursal:&nbsp;&nbsp;</label>
    <span class="field195">
        <input type="text" name="nombreSucursal" id="nombreSucursalFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
    </span>	 
</div>               
<div align="center" class="submit664">
    Empresa:&nbsp;&nbsp;
    <input type="text" name="nombreEmpresa" id="nombreEmpresaFrm" size="60" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
</div>

<div class="row660" align="center">&nbsp;</div>

<div id="titleg664x16">Contratante</div>
<div class="row660">
    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>                    
    <span class="field195">
        <input type="text" name="apPaternoContratante"  id="apPaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
    </span>
    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>
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
    <div class="row660">
        <label class="label330">No. de empleado:&nbsp;&nbsp;</label>
        <span class="field330">
            <spring:bind path="polizaIndividual.solicitud.contratante.numNominaContratante">
                <input type="text" name="${status.expression}"  id="numNominaContratanteFrm" readonly value="${status.value}" class="input"/>
            </spring:bind>
        </span>
    </div>
    <div class="row660" align="center">&nbsp;</div>
    <div align="center" class="submit664">
        <input type="hidden" value="Siguiente" id="sig" class="input" name="_target1"  disabled="true" tabindex="8"/>
        <input type="button" class="input" id="val" value="Autorizar Captura" onClick="validaEstatusSolicitud();"/>
        <a href="<c:url value="/"/>app/logoutcontroller">
            <input type="button" value="Salir" class="input" tabindex="9"/>
        </a>
        <a href="<c:url value="/"/>">
            <input type="button" value="Inicio" class="input"/>
        </a>   
    </div>
</form>
</spring:nestedPath>
</body>
</html>
