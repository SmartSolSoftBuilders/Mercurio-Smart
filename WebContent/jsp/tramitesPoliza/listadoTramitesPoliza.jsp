<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Listado de Trámites de la Póliza</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="<c:url value="/js/jquery-1.5.1.js"/>"></script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/calendario.js" />">
        </script>
        
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/AnchorPosition.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/date.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/PopupWindow.js"/>">
        </script>
        <script type="text/javascript">
        	function regresar(){
        		 urlBase     = '<c:url value="/app/consultaDetalleSolicitudController"/>';
                 params = 'numPoliza=${poliza.numPoliza}&emisor=${poliza.numConsignatario}&folioSolicitud=${poliza.solicitud.folioSolicitud}&formatoSolicitud=${poliza.solicitud.formatoSolicitud}';
                 url    = urlBase + '?' + params;
                 window.location = url;
        	}
        	function validarForma(){
        		forma = document.forms[0];
        		if(forma.fechaTramite.value == ""){
        			alert("La fecha del trámite es un dato requerido");
        			return false;
        		}
        		if(confirm("Al registrar un trámite no se puede modificar o eliminar ¿Los datos de registro de trámite son correctos?")){
        			forma.submit();
        		}
        		
        	}
        </script>
        
    </head>
    
    <body>
    <spring:hasBindErrors name="listadoTramitesPolizaCommand">
   <ul>
      <c:forEach var="error" items="${errors.allErrors}">
         ${error.code} ${error.field}
      </c:forEach>
   </ul>
</spring:hasBindErrors>
     <form:form  id="w01" commandName="listadoTramitesPolizaCommand" method="post">
     
     	
        <table cellpadding="2" cellspacing="2" width="750">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>P&oacute;liza</strong></td>
                        </tr>
                		<tr>
                			<td class="labelRow" nowrap width="15%">
                				P&oacute;liza:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="25%">
                				<strong><c:out value="${poliza.numPoliza}"/></strong>
                			</td>
                			<td class="labelRow" nowrap width="15%">
                				Emisor:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="25%">
                				<strong><c:out value="${poliza.numConsignatario}"/></strong>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" nowrap >
                				Solicitud:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap >
                				<strong><c:out value="${poliza.solicitud.folioSolicitud}"/></strong>
                			</td>
                			<td class="labelRow" nowrap>
                				Formato:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap>
                				<strong><c:out value="${poliza.solicitud.formatoSolicitud}"/></strong>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" nowrap >
                				Ap. Paterno:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap >
                				<strong><c:out value="${poliza.solicitud.contratante.apPaternoContratante}"/>
                			</td>
                			<td class="labelRow" nowrap >
                				Ap. Materno:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="25%">
                				<strong><c:out value="${poliza.solicitud.contratante.apMaternoContratante}"/></strong>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" nowrap colspan="2">
                				Nombre:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap  colspan="2">
                				<strong><c:out value="${poliza.solicitud.contratante.nombre1Contratante}"/>
                				<c:out value="${poliza.solicitud.contratante.nombre2Contratante}"/></strong>
                			</td>
                			
                		</tr>
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Tr&aacute;mites de la P&oacute;liza</strong></td>
                        </tr>
                        <c:if test="${empty listaTramites}">
                        <tr>
                        	<td class="fieldRow" colspan="4" align="center" style="text-align: center">
								<strong>No existen tr&aacute;mites asociados a esta p&oacute;liza</strong>
                        	</td>
                        </tr>
                        </c:if>
                        <c:if test="${not empty listaTramites}">
	                        <tr>
	                        	<td  colspan="4" >
									<table width="100%" cellpadding="0" cellspacing="2">
										<tr>
											<td class="ContenTablaColor">
												Fecha del Tr&aacute;mite
											</td>
											<td class="ContenTablaColor">
												Tr&aacute;mite Solicitado
											</td>
											<td class="ContenTablaColor">
												Tr&aacute;mite Final
											</td>
											<td class="ContenTablaColor">
												Sucursal
											</td>
											<td class="ContenTablaColor">
												Usuario
											</td>
											<td class="ContenTablaColor">
												Tel&eacute;fono
											</td>
										<tr/>
										
								<c:forEach items="${listaTramites}" var="tramite" >
										<tr>
											<td class="ContenTabla">
												<fmt:formatDate value="${tramite.fecha}" pattern="dd/MM/yyyy"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.tipoTramiteInicial.nombre}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.tipoTramiteFinal.nombre}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.oficina.nombre}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.usuario}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.telefono}"/>
											</td>
										</tr>
										<tr>
											<td class="ContenTabla" colspan="6">
												Comentarios Asegurado:
											
												<c:out value="${tramite.comentariosAsegurado}"></c:out>
											</td>
										</tr>
										<tr>
											<td class="ContenTabla" colspan="6">
												Comentarios Asesor:
											
												<c:out value="${tramite.comentariosAsesor}"></c:out>
											</td>
										</tr>
										<tr>
											<td class="ContenTabla"colspan="6">
												Observaciones:
											
												<c:out value="${tramite.observaciones}"></c:out>
											</td>
										</tr>
										<tr>
											<td colspan="6" style="background-color: white;height: 3px"></td>
										</tr>
								</c:forEach>		
									</table>
	                        	</td>
	                        </tr>
                        </c:if>
                       <tr  valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Registrar Un Nuevo Tr&aacute;mite</strong></td>
                        </tr>
                        <tr>
                        	<td class="labelRow" nowrap>
                				Tipo de Tr&aacute;mite Solicitado:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" colspan="3">
                				<form:select path="idTipoTramiteInicial"   cssClass ="input">
                					<form:options items="${listaTiposTramite}" itemValue="idTipoTramite" itemLabel="nombre" />
                				</form:select>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" nowrap>
                				Tipo de Tr&aacute;mite Final:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" colspan="3">
                				<form:select path="idTipoTramiteFinal"   cssClass ="input">
                					<form:options items="${listaTiposTramite}" itemValue="idTipoTramite" itemLabel="nombre" />
                				</form:select>
                			</td>
                        </tr>
                        <tr>
                        	<td class="labelRow" nowrap >
                				Fecha:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap >
                			 <div ID="divFecha"
	                               STYLE="position:absolute;visibility:hidden;background-color:white;">
	                            </div>
                			 <script language="JavaScript" type="text/javascript">
	                                var cal18 = new CalendarPopup("divFecha");
	                                cal18.setCssPrefix("TEST");
	                            </script>
                				 <form:input path="fechaTramite" size="11" readonly="true" cssClass="input"/>
                				 <A HREF="#" onClick="cal18.select(document.getElementById('fechaTramite'),'anchorfechaSolicitud','dd/MM/yyyy'); return false;" 
		                             NAME="anchorfechaSolicitud" ID="anchorfechaSolicitud" >
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                         </A> 
                			</td>
                			<td class="labelRow" nowrap>
                				Sucursal:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" >
                				<form:select path="idOficina"   cssClass ="input">
                					<form:options items="${listaOficinas}" itemValue="idOficina" itemLabel="nombre" />
                				</form:select>
                			</td>
                        </tr>
                         <tr>
                        	<td class="labelRow" nowrap>
                				Tel&eacute;fono:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap colspan="3">
                				<form:input path="telefono" size="15"  cssClass="input"/>
                			</td>
                			
                        </tr>
                        <tr>
                        	<td class="labelRow" nowrap>
                				Comentarios Asegurado:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap colspan="3">
                				<form:textarea path="comentariosAsegurado" rows="3" cols="60"/>
                			</td>
                        </tr>
                        <tr>
                        	<td class="labelRow" nowrap>
                				Comentarios Asesor:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap colspan="3">
                				<form:textarea path="comentariosAsesor" rows="3" cols="60"/>
                			</td>
                        </tr>
                        <tr>
                        	<td class="labelRow" nowrap>
                				Observaciones:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap colspan="3">
                				<form:textarea path="observaciones" rows="3" cols="60"/>
                			</td>
                        </tr>
                        <tr>
                        	<td class="fieldRow" style="text-align: center" colspan="4">
                        		<input type="button" value="Guardar Trámite" class="input" onclick="validarForma();"/>
                        		&nbsp;&nbsp;
                        		<input type="button" value="Regresar" class="input" onclick="regresar();"/>
                        	</td>
                        </tr>
        	</table>
        </form:form>
        	
        
    </body>
</html>
