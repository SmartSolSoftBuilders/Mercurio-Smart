<%@page import="com.sun.tools.internal.ws.processor.model.Request"%>
<%@page import="javax.management.relation.Role"%>
<%@page import="mx.com.seguros.model.seguridad.Rol"%>
<%@page import="javax.activation.CommandObject"%>
<%@page import="net.sf.ehcache.constructs.asynchronous.Command"%>
<%@page import="javax.management.Query"%>
<%@page import="mx.com.seguros.web.seguridad.util.SeguridadUtil"%>
<%@page import="org.acegisecurity.GrantedAuthority"%>
<%@page import="org.acegisecurity.context.SecurityContextHolder"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
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
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/GUIHelper.js"/>">
        </script>
        
        <!--agregue los nuevos campos del formulario-->
    
        


        
        <title>Consulta General de Solicitudes</title>
        <script type="text/javascript" >
            function cambioPagina(pagina){
            	document.w01.formato.value = "";
            	document.forms[0].target="_self";
                document.forms[0].paginaActual.value = pagina;
                document.forms[0].submit();
            }
            function buscarEstatusPoliza(){
                launch('obtenerEstatusPoliza',
                'Listado de Estados de P&oacute;liza -Seleccione un registro de la lista-',
                'ID Estado: :idEstatusPolizaSeguimiento:idEstatusPoliza:t:t,'+
                'Estado: :descripcionEstatusPoliza:descripcionEstatusPoliza:t:t','',700,700);
            }
            function buscarEstatusSolicitud(){
                launch('obtenerEstatusSolicitud',
                'Listado de Estados de Solicitud -Seleccione un registro de la lista-',
                'ID Estado: :idEstatusSolicitud:idEstatusSolicitud:t:t,'+
                'Estado: :descripcionEstatusSolicitud:descripcionEstatusSolicitud:t:t','',700,700);
            }
            function buscarAgente(){
                launch('buscarAgentes',
                'Listado de Agentes -Seleccione un registro de la lista-',
                    'ID Agente: :cveAgente:cveAgente:t:t,'+
                    '1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,'+
                    '2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f,'+
                    'Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,'+
                    'Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f',
                '',700,700);
            }
            function buscarPlaza(){
                
                launch('buscarPlazas',
                'Listado de Plazas -Seleccione un registro de la lista-',
                    'ID Plaza: :idPlaza:idPlaza:t:t,'+
                    'Clave Plaza: :cvePlaza:descripcionPlaza:t:t,'+
                    'Nombre Plaza: :nombrePlaza: :t:f'
                    ,
                '',700,700);
            }

            function buscarGrupoAsegurado(){
                launch('buscarGruposAsegs',
                'Listado de Grupos Asegurados -Seleccione un registro de la lista-',
                'Clave: :cveGrupoAsegurado:cveGrupoAsegurado:t:t,Grupo: :nombreGrupoAsegurado:descripcionGrupoAsegurado:t:t','',500,550);
            }

            function buscarSucursalesPorGrupo(){
                launch('obtenerSucursalesPorGrupo',
                'Sucursales del Grupo Asegurado -Seleccione un registro de la lista-',
                'Clave: :cveSucursal:cveSucursal:t:t,Deleg/Mpio: :sucursal'+'.'+'nombreSucursal:descripcionSucursal:t:t',
                'cveGrupoAsegurado:'+document.getElementById('cveGrupoAsegurado').value,500,550);
            }

            function buscarColoniasPorSucursal(){
                launch('obtenerColoniasPorSucursal',
                'Colonias de la sucursal -Seleccione un registro de la lista-',
                'Clave: :cveColonia:cveColonia:t:t,Colonia: :colonia'+'.'+'asentamiento:descripcionColonia:t:t',
                'cveSucursal:'+document.getElementById('cveSucursal').value+',cveGrupoAsegurado:'+document.getElementById('cveGrupoAsegurado').value,500,550);
            }
            function buscarEmpresasPorColonia(){
                launch('obtenerEmpresasPorColonia',
                'Empresas por colonia -Seleccione un registro de la lista-',
                'Clave: :cveEmpresa:cveEmpresa:t:t,Tipo: :tipoEmpresa'+'.'+'descripcionEmpresa: :t:f,Empresa: :nombreEmpresa:descripcionEmpresa:t:t,Turno: :turnoEmpresa'+'.'+'nombreTurno: :t:f',
                'cveColonia:'+document.getElementById('cveColonia').value,500,550);
            }

            function buscar(){
            	document.w01.formato.value = "";
            	document.forms[0].target="_self";
                document.w01.paginaActual.value = '';
                document.w01.submit();
            }
            function detalle(numPoliza,emisor,folio,formatoSolicitud){

                urlBase     = '<c:url value="/app/consultaDetalleSolicitudController"/>';
                propiedades = 'width='+800+',height='+800+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes,scrollbar=yes,verticalscrollbar=yes';
                params = 'numPoliza='+numPoliza+'&emisor='+emisor+'&folioSolicitud='+folio+'&formatoSolicitud='+formatoSolicitud;
                url    = urlBase + '?' + params;
                //alert('url: ' + url);
                vent   = window.open(url, "detalle", propiedades);
                isOpen = true;
            }
            function detalleRetiros(numPoliza,numConsignatario){

                urlBase     = '<c:url value="/app/consultarDetalleRetirosController"/>';
                propiedades = 'width='+700+',height='+600+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes,scrollbar=yes,verticalscrollbar=yes';
                params = 'numPoliza='+numPoliza+"&numConsignatario="+numConsignatario;
                url    = urlBase + '?' + params;
                //alert('url: ' + url);
                vent   = window.open(url, "detalle", propiedades);
                isOpen = true;
            }



        </script>
        <script type="text/javascript" >
            function cambioPagina(pagina){
            	document.w01.formato.value = "";
            	document.forms[0].target="_self";
                document.w01.paginaActual.value = pagina;
                document.w01.submit();
            }
			function ordenarPor(iCol){
				document.w01.formato.value = "";
				document.forms[0].target="_self";
				document.w01.indiceOrden.value = iCol;
				document.w01.submit();
			}
        </script>
    </head>
        
    <body>
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            
            <form action="<c:url value="/app/consultaGeneralSolicitudesController"/>" method="post" name="w01">
                <input type="hidden" name="indiceOrden"  />
                <spring:nestedPath path="criteriosBusqueda">
              
                
                
                <input type="hidden" name="_page0" value="0" />
                
                <table cellpadding="0" cellspacing="2" width="1150">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Consulta General de Solicitudes</strong></td>
                        </tr>
                		<tr>
                			<td class="labelRow" nowrap width="15%">
                				Fecha de Solicitud entre:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="25%">
                				<spring:bind path="strFechaSolicitudInicial" >
	                            <div ID="divFechaSolicitudInicial"
	                               STYLE="position:absolute;visibility:hidden;background-color:white;">
	                            </div>
	                             <script language="JavaScript" type="text/javascript">
	                                var calFechaSolicitudInicial = new CalendarPopup("divFechaSolicitudInicial");
	                                calFechaSolicitudInicial.setCssPrefix("TEST");
	                            </script>
	                            
	                            <input type="text"
	                                   name="${status.expression}"
	                                   id="${status.expression}"
	                                   size="10"
	                                   tabindex="1"
	                                   value="${status.value}"
	                                   class="input" />
	                       
	                           
	                           <A HREF="#" onClick="calFechaSolicitudInicial.select(document.forms[0].${status.expression},'anchorFechaSolicitudInicial','dd/MM/yyyy'); return false;"
	                              TITLE="calFechaSolicitudInicial.select(document.forms[0].${status.expression}},'anchorFechaSolicitudInicial','dd/MM/yyyy'); return false;"
	                              NAME="anchorFechaSolicitudInicial" ID="anchorFechaSolicitudInicial" TABINDEX="11">
	                               <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A>
	                             </spring:bind>
	                            y
	                            <spring:bind path="strFechaSolicitudFinal">
	                                <div ID="divFechaSolicitudFinal"
	                               STYLE="position:absolute;visibility:hidden;background-color:white;">
	                            </div>
	                             <script language="JavaScript" type="text/javascript">
	                                var calFechaSolicitudFinal = new CalendarPopup("divFechaSolicitudFinal");
	                                calFechaSolicitudFinal.setCssPrefix("TEST");
	                            </script>
	                            <input type="text"
	                                   name="${status.expression}"
	                                   id="${status.expression}"
	                                   size="10"
	                                   value="${status.value}"
	                                   tabindex="1"
	                                   class="input" />
	                           <A HREF="#" onClick="calFechaSolicitudFinal.select(document.forms[0].${status.expression},'anchorFechaSolicitudFinal','dd/MM/yyyy'); return false;"
	                              TITLE="calFechaSolicitudFinal.select(document.forms[0].${status.expression},'anchor1x','dd/MM/yyyy'); return false;"
	                              NAME="anchorFechaSolicitudFinal" ID="anchorFechaSolicitudFinal" TABINDEX="11">
	                               <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A>
	                            </spring:bind>
                			</td>
                			<td class="labelRow" nowrap width="15%">
                				Estado de la Solicitud:&nbsp;&nbsp; 
                			</td>
                			<td class="fieldRow" nowrap width="15%">
                				<spring:bind path="idEstatusSolicitud">
		                             <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                        </spring:bind>
		                        <spring:bind path="descripcionEstatusSolicitud">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="10"
		                                   tabindex="1"
		                                   value="${status.value}"
		                                   class="input" readonly/>
		                            <a href="javascript:buscarEstatusSolicitud();" tabindex="2">
		                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
		                        </spring:bind>
                			</td>
                			<td class="labelRow" width="15%">
                				  Estado de la P&oacute;liza:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" width="20%">
                				<spring:bind path="descripcionEstatusPoliza">
	                            <input type="text"
	                                   name="${status.expression}"
	                                   id="${status.expression}"
	                                   size="10"
	                                   tabindex="1"
	                                   value="${status.value}"
	                                   class="input" readonly/>
	                             </spring:bind>
	                            <spring:bind path="idEstatusPoliza">
	                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
	                            </spring:bind>
	                          
	                            &nbsp;
	                            <a href="javascript:buscarEstatusPoliza();" tabindex="2">
	                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				RFC Solicitante: &nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="rfcSolicitante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="10"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                        </spring:bind>
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				 Nombre Solicitante: &nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="nombreSolicitante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="20"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                				
                			</td>
                			
                			<td class="labelRow" nowrap>
                				 Ap. Paterno Solicitante:&nbsp;
                             
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="apPaternoSolicitante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="20"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                			
                			<td class="labelRow" nowrap>
                				Ap. Materno Solicitante: &nbsp;
                          
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="apMaternoSolicitante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="20"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" nowrap>
                				Num N&oacute;mina Contratante: &nbsp;
	                          
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="numNominaContratante">
	                            <input type="text"
	                                   name="${status.expression}"
	                                   id="${status.expression}"
	                                   size="15"
	                                   
	                                   class="input"
	                                   value="${status.value}"/>
	                         </spring:bind>
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Nombre(s) Contratante: &nbsp;                         
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="nombreContratante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="20"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                			<td class="labelRow" nowrap>
                				Ap. Paterno Contratante:&nbsp;
                             
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="apPaternoContratante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="20"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                			<td class="labelRow" nowrap>
                				Ap. Materno Contratante: &nbsp;
                          
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="apMaternoContratante">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="20"
		                                   tabindex="1"
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Folio de Solicitud:&nbsp; 
                          
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="folioSolicitud">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                			<td class="labelRow">
                				N&uacute;mero de P&oacute;liza:&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="numPoliza">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   
		                                   class="input"
		                                   value="${status.value}"/>
		                         </spring:bind>
                			</td>
                			<td class="labelRow">
                				N&uacute;mero de Certificado:&nbsp;	
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="numCertificado">
	                            <input type="text"
	                                   name="${status.expression}"
	                                   id="${status.expression}"
	                                   size="15"
	                                   
	                                   class="input"
	                                   value="${status.value}"/>
	                         </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Agente:&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="cveAgente">
		                          <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="10"
		                                   tabindex="1"
		                                   class="input" 
		                                   value="${status.value}"
		                                   readonly/>
		                        </spring:bind>
		                        <a href="javascript:buscarAgente();" tabindex="2" id="img">
	                            <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
	                                
		                        <%GrantedAuthority rol[] = SecurityContextHolder.getContext().getAuthentication().getAuthorities();%>
		                        <%System.out.println("ROLES__"+rol[0].getAuthority().toString()); %>
		                        <%if(rol[0].getAuthority().toString().equals("ROL_VENTAS") || rol[0].getAuthority().toString().equals("rol_ventas")) {%>
		                        	<script language="JavaScript" type="text/javascript">
										document.getElementById("img").setAttribute("href","#");
										document.getElementById("img").oncontextmenu=new Function("return false");
									</script>
		                        	<!--  input type="text" name="id" value ="si"/-->
		                        <%}else{%>
		                        	<!--input type="text" name="id" value ="no"/-->
		                        <%} %>

                
                			</td>
                			<td class="labelRow">
                				 Plaza: &nbsp;                                             	     
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="idPlaza">
		                             <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                         </spring:bind>
		                         <spring:bind path="descripcionPlaza" >
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="10"
		                                   tabindex="1"
		                                   value="${status.value}"
		                                   class="input" readonly/>
		                         </spring:bind>
		                            <a href="javascript:buscarPlaza();" tabindex="2">
		                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Grupo Asegurado:&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="cveGrupoAsegurado">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                      </spring:bind>
		                      <spring:bind path="descripcionGrupoAsegurado">
		                          <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                      </spring:bind>
                             <a href="javascript:buscarGrupoAsegurado();" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                        
                         
                			</td>
                			<td class="labelRow">
                				Delegaci&oacute;n/Municipio: &nbsp;
                         
                			<td class="fieldRow">
                				<spring:bind path="cveSucursal">
		                             <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                         </spring:bind>
		                         <spring:bind path="descripcionSucursal">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                         </spring:bind>
                             <a href="javascript:buscarSucursalesPorGrupo()" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>&nbsp;
                			
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Colonia / Barrio: &nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="cveColonia">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                         </spring:bind>
		                         <spring:bind path="descripcionColonia">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                         </spring:bind>
		                             <a href="javascript:buscarColoniasPorSucursal();" tabindex="2">
		                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                			</td>
                			<td class="labelRow">
                				Nombre de la Escuela: &nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="cveEmpresa">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                         </spring:bind>
		                         <spring:bind path="descripcionEmpresa">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                         </spring:bind>

		                         <a href="javascript:buscarEmpresasPorColonia()" tabindex="2">
		                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                			</td>
                			<td class="labelRow">
                			</td>
                			<td class="fieldRow">
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="text-align: center" colspan="6">
                					
                						<input type="button" value="Buscar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/app/consultaGeneralSolicitudesController"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>
				
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/"/>">
				                          <input type="button" class="input" value="Regresar" />
				                        </a>
                			
                			</td>
                		</tr> 
                
                </table>
               
              
                <div align="center" >
                    <table width="100%" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:small;font-weight: bold;">

                                Total de registros: <c:out value="${resultado.totalResultados}"/><br/>
                                Total de Primas: <fmt:formatNumber value="${resultado.totalPrima}" pattern="$ #,##0.00"/> <br/>
                                <input type="hidden" name="totalResultados" value="<c:out value="${resultado.totalResultados}"/>"/>
                                <input type="hidden" name="paginaActual" value="<c:out value="${resultado.paginaActual}"/>"/>
                                <input type="hidden" name="totalPaginas" value="<c:out value="${resultado.totalPaginas}"/>"/>
                                <input type="hidden" name="totalPrima" value="<c:out value="${resultado.totalPrima}"/>"/>
                                <input type="hidden" name="formato" id="formato" value=""/>
                               
                                <c:if test="${resultado.totalResultados > 0}">
                                	
                                	 <c:if test="${resultado.paginaActual>1}"><a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual-1}"/>)" >&lt;</a></c:if> P&aacute;gina <c:out value="${resultado.paginaActual}"/> de <c:out value="${resultado.totalPaginas}"/>
                                 <c:if test="${resultado.paginaActual<resultado.totalPaginas}"><a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual+1}"/>)" >&gt;</a></c:if>
                                
                                
                                <br/>
                                <a href="javascript:excel();"><img border="0" src="<c:url value="/img/skin/excel.jpg"/>" width="40" title="Exportar Resultados a Excel"></img></a>
                                
                                <script type="text/javascript">
                                	function excel(){
                                		document.w01.formato.value = "xlsx";
                                		document.w01.submit();
                                		
                                	}
                                </script>
                                </c:if>
                                
                               

                            </td>

                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                            <td class="ContenTablaColor">&nbsp;</td>
                            
                            	<c:forEach var="columna" items="${criteriosBusqueda.columnas}" varStatus="iCol">
                            		<td align="center" class="ContenTablaColor">
                            		<strong>
                            		<c:if test="${resultado == null }">
                            			${columna} 
                            		</c:if>
                            		<c:if test="${resultado != null }">
                            			<a href="javascript:ordenarPor(${iCol.index})">${columna}
	                            		<c:if test="${criteriosBusqueda.orden[iCol.index] == 'asc' }">
	                            			&#94;
	                            		</c:if>
	                            		<c:if test="${criteriosBusqueda.orden[iCol.index] == 'desc' }">
	                            			v
	                            		</c:if>
	                            		</a>
                            		</c:if>
                            		
                            		
                            		</strong>
                            		<spring:bind path="orden[${iCol.index}]">
                            			<input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
                            		</spring:bind>
                            		</td>
                            	</c:forEach>
                            <td class="ContenTablaColor">&nbsp;</td>
                            
<!--                            <td align="center" class="ContenTablaColor"><strong>Plaza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Certificado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Nombre Contratante</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Num. N&oacute;mina Asegurado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Folio de Solicitud</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Estado Solicitud</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Nombre Asegurado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>RFC Asegurado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Tel. Solicitante</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Emisor</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Num. de Poliza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>                            -->
<!--                            <td align="center" class="ContenTablaColor"><strong>Seguimiento a P&oacute;liza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Pagos P&oacute;liza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Paquete</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Grupo Asegurado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Prima Mensual</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Escuela</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Sucursal</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Agente</strong></td>-->
                            
                            
                        </tr>
                        <c:forEach var="registro" items="${resultado.resultados}">
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla"><a href="javascript:void();" 
                                        onclick="javascript:detalle('${registro.numPoliza}','${registro.numConsignatario}','${registro.folioSolicitud}','${registro.formatoSolicitud}')">Detalle</a></td>
                                        <td class="ContenTabla"><c:out value="${registro.cvePlaza}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numCertificado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombre1Contratante}"/>
                                                                                <c:out value="${registro.nombre2Contratante}"/>
                                                                                <c:out value="${registro.apPaternoContratante}"/>
                                                                                <c:out value="${registro.apMaternoContratante}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numNominaAsegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.folioSolicitud}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.formatoSolicitud}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaSolicitud}" /></td>
                                        <td class="ContenTabla"><c:out value="${registro.descripcionEstadoSolicitud}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombre1Asegurado}"/>
                                                                                <c:out value="${registro.nombre2Asegurado}"/>
                                                                                <c:out value="${registro.apPaternoAsegurado}"/>
                                                                                <c:out value="${registro.apMaternoAsegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.RFCasegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.telefonoSolicitante}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numConsignatario}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numPoliza}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaInicioVigencia}" /></td>
                                        <td class="ContenTabla"><c:out value="${registro.descripcionEstadoPoliza}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.descripcionEstadoPolizaPagos}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombrePaquete}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombreGrupoAsegurado}"/></td>
                                        <td class="ContenTabla" nowrap>$ <c:out value="${registro.descripcionTarifa}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombreEmpresa}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombreSucursal}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombre1Agente}"/>
                                                                                <c:out value="${registro.nombre2Agente}"/>
                                                                                <c:out value="${registro.apPaternoAgente}"/>
                                                                                <c:out value="${registro.apMaternoAgente}"/></td>
                                        <td class="ContenTabla" nowrap>
                                        	<c:if test="${empty registro.saldoCuenta }">
                                        		$ 0.00
                                        	</c:if>
                                        	<c:if test="${not empty registro.saldoCuenta }">
                                        		<fmt:formatNumber pattern="$ #,##0.00" value="${registro.saldoCuenta}"/>
                                        	</c:if>
                                        	
                                        </td>
                                        <td class="ContenTabla" nowrap>
                                        	<c:if test="${empty registro.importeRetiros }">
                                        		$ 0.00
                                        	</c:if>
                                        	<c:if test="${not empty registro.importeRetiros }">
                                        		<fmt:formatNumber pattern="$ #,##0.00" value="${registro.importeRetiros}"/>
                                        	</c:if>
                                        
                                       </td>
                                       <td class="ContenTabla" nowrap>
                                        	<c:if test="${not empty registro.importeRetiros }">
                                        		<a href="javascript:void();" 
                                       					 onclick="javascript:detalleRetiros('${registro.numPoliza}','${registro.numConsignatario}')">Detalle de Retiros</a>
                                        	</c:if>
                                       </td>
                                    </tr>
                        </c:forEach>
                        </table>




                </div>
               
               
                
                <!--Seccion de poliza individual-->


                
                    </spring:nestedPath>
            </form>
            
    <script type="text/javascript" >
    esRolVentas = ${rolVentas};
    esRolAdministrador = ${rolAdministrador};
    //esconder la clave del agente
    if(esRolVentas){
    	
    	document.getElementById("camposAgente").style.display = "none";
    }
    
    //esconder la clave de plaza
    if(esRolAdministrador){
    	document.getElementById("camposPlaza").style.display = "none";
    }
    
    
    </script>
    </body>
    
</html>
