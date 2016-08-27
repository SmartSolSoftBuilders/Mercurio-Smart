<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" 
              rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" 
              rel="stylesheet" type="text/css">
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
       
       <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/jquery-1.5.1.js"/>">
        </script>
        
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/jquery.keyfilter-1.7.js"/>">
        </script>
      
        <script language="JavaScript" type="text/javascript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
            
            function validaForma(forma){
            	
            	var stringPorcentajePromotr = document.getElementById("porcentajeComisionPromotorFrm").value;
            	var stringPorcentajeAgente = document.getElementById("porcentajeComisionAgenteInbursaFrm").value;
            	var stringCveAgenteInbursa = document.getElementById("cveAgenteInbursaFrm").value;
            	var porcentajePromotor = isNaN(stringPorcentajePromotr)?0.0:parseFloat(stringPorcentajePromotr);
            	var porcentajeAgente = isNaN(stringPorcentajeAgente)?0.0:parseFloat(stringPorcentajeAgente);
            	//solo se valida si la clave del agente inbursa es mayor a cero
            	var cveAgenteInbursa = isNaN(stringCveAgenteInbursa)?0:parseInt(stringCveAgenteInbursa);
            	
            	if(cveAgenteInbursa> 0 && porcentajePromotor+porcentajeAgente != 100.0){
            		alert("La suma de los porcentajes de comisión debe sumar un 100%, favor de corregir");
            		document.getElementById("porcentajeComisionPromotorFrm").focus();
            		return false;
            	}
            	 
            	
            	return true;
            }
            
        </script>
        <title>
            Identificar solicitud de seguro de vida
        </title>
    </head>
    <body>
    				<jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/>
    			<tag:errors name="datosSolicitud"/>
        <spring:nestedPath path="datosSolicitud">
            <div ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;background-color:white;">
            </div>
            
            <form action="#" method="post" onsubmit="return validaForma(this);">            
            
                <div align="center">
                    <input type="hidden" name="_page0" value="0" />
                    <!--input type="hidden" name="_target1" value="true" /-->
                </div>

                <div id="title430x16">
                    Identificar solicitud.
                </div>
                <br/>
                
                <div class="row335" id="seccionSolicitud" style="width: 450px">
                	
                	<table cellpadding="2" cellspacing="2" width="100%">
                		<tr>
                			<td class="fieldRow" style="width: 30%; text-align: right;">
                				Clave Asesor:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="solicitud.cveAgente">
		                            <input type="text" 
		                                   name="${status.expression}" 
		                                   id="cveAgenteFrm" 
		                                   value="${status.value}" 
		                                   size="10" 
		                                   tabindex="1" 
		                                   class="input" readonly/>&nbsp;
		                            <a href="javascript:launch('buscarAgentes','Listado de Agentes -Seleccione un registro de la lista-','ID Agente: :cveAgente:cveAgenteFrm:t:t,1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f, Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f','',700,700);" tabindex="2">
		                                <img src="<c:url value="/"/>img/helper.png" alt="Buscar Agentes"/></a>
                            </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Clave Promotor / Agente Inbursa:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.cvePromotor">
		                            <input type="text" name="${status.expression}" id="cvePromotorFrm" value="${status.value}" size="5" tabindex="8" class="input"  readonly/>
		                        </spring:bind>
		                        <a href="javascript:launch('buscarPromotores','Listado de Promotores -Seleccione un registro de la lista-','ID Promotor:cvePromotor:cvePromotor:cvePromotorFrm:t:t,Nombre:nombrePromotor:nombrePromotor:nombrePromotorFrm:t:f','',550,400);" tabindex="9">
		                            <img src="<c:url value="/"/>img/helper.png"  alt="Buscar promotores"/></a>
		                             <input type="hidden" name="nombre1Promotor" id="nombre1PromotorFrm" size="20" tabindex="2" class="input"/>      
					                <input type="hidden" name="nombre2Promotor" id="nombre2PromotorFrm" size="20" tabindex="2" class="input"/>      
					                <input type="hidden" name="apPaternoPromotor" id="apPaternoPromotorFrm" size="20" tabindex="2" class="input"/>      
					                <input type="hidden" name="apMaternoPromotor" id="apMaternoPromotorFrm" size="20" tabindex="2" class="input"/>     
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Porcentaje de Comisi&oacute;n Promotor:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.porcentajeComisionPromotor">
                            <input type="text" 
                                   name="${status.expression}" 
                                   id="porcentajeComisionPromotorFrm" 
                                   value="${status.value}" 
                                   size="10" 
                                   tabindex="1" 
                                   maxlength="5"
                                   class="input mask-decimal5_2" />&nbsp;
                            </spring:bind>
                            (Capture solo n&uacute;meros)
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Clave Agente Inbursa:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.cveAgenteInbursa">
                            <input type="text" 
                                   name="${status.expression}" 
                                   id="cveAgenteInbursaFrm" 
                                   value="${status.value}" 
                                   size="10" 
                                   tabindex="1" 
                                   maxlength="10"
                                   class="input mask-pint" />&nbsp;
                            </spring:bind>
                            (Capture solo n&uacute;meros)
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Porcentaje de Comisi&oacute;n Agente Inbursa:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.porcentajeComisionAgenteInbursa">
		                            <input type="text" 
		                                   name="${status.expression}" 
		                                   id="porcentajeComisionAgenteInbursaFrm" 
		                                   value="${status.value}" 
		                                   size="10" 
		                                   tabindex="1" 
		                                   maxlength="5"
		                                   class="input mask-decimal5_2" />&nbsp;
		                            </spring:bind>
		                            (Capture solo n&uacute;meros)
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Tipo de Solicitud:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.tipoSolicitudNormal">
                            <input
                                type="radio"
                                   name="${status.expression}"
                                   <c:choose>
                                       <c:when test="${status.value}">
                                           value=true
                                           checked="checked"
                                       </c:when>
                                       <c:otherwise>
                                           value=true
                                       </c:otherwise>
                                   </c:choose>
                                   tabindex="3"/>

                            <label>Normal.&nbsp;&nbsp;</label>
                            <input type="radio"  
                                   name="${status.expression}" 
                                   <c:choose>
                                       <c:when test="${!status.value}" >
                                           value=false
                                           checked="checked" 
                                       </c:when>
                                       <c:otherwise>
                                           value=false
                                       </c:otherwise>
                                   </c:choose>
                                   tabindex="4"/>
                            
                            <label>Por contrato.&nbsp;&nbsp;</label>              
                        </spring:bind>    
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Folio:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path = "solicitud.folioSolicitud">
                           			 <input type="text" name="${status.expression}" id="folioSolicitudFrm" value="${status.value}" size="10" tabindex="5" class="input" maxlength="10"/>    
                        		</spring:bind>  
                        		(Capture solo n&uacute;meros)
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 N&uacute;mero de Formato:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path = "solicitud.formatoSolicitud">
		                            <input type="text" name="${status.expression}" id="formatoSolicitudFrm" value="${status.value}" size="10" tabindex="5" class="input" maxlength="10"/>    
		                        </spring:bind>  
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Prima quincenal:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<input type="text" name="importeTarifaFrm"  id="importeTarifaFrm"
                                    value="${datosSolicitud.solicitud.tarifa.importeTarifa}" class="input" size="15" tabindex="6" readonly />
                  

		                        <a href="javascript:launch('buscarTarifas','Tarifas -Seleccione un registro de la lista-','No.: :cveTarifa:cveTarifaFrm:f:t,Importe:importeTarifa:descripcion:importeTarifaFrm:t:t','',500,730);" tabindex="7">
		                            <img src="<c:url value="/"/>img/helper.png" alt="Buscar Tarifas" />
		                        </a>
		                        <spring:bind path="solicitud.cveTarifa">
		                            <input type="hidden" name="${status.expression}" id="cveTarifaFrm" value="${status.value}" size="5" class="input" />
		                        </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Fecha de la solicitud:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.fechaSolicitud">
		                            <input type="text" name="${status.expression}" id="fechaSolicitudFrm" 
		                            onClick=""
		                            value="${status.value}" size="11" tabindex="10" class="input"/>
		                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaSolicitudFrm,'anchor17','dd/MM/yyyy'); return false;" 
		                             NAME="anchor17" ID="anchor17" TABINDEX="11">
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 

                       			 </spring:bind>  
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: right;">
                				 Fecha de producci&oacute;n:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.fechaProduccion">
		                            <input type="text" name="${status.expression}" id="fechaProduccionFrm" value="${status.value}" size="11" tabindex="10" class="input"/>
		                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaProduccionFrm,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18" TABINDEX="11">
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 
		
		                        </spring:bind>
                			</td>
                		</tr>
                		<tr
                			<c:if test="${rolOperaciones}">
		                		style="display:none;"
		               		 </c:if>
                		>
                			<td class="fieldRow" style="text-align: right;">
                				 Estatus de la Solicitud:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="solicitud.idEstatusSolicitud" >
		                            <select name="${status.expression}" class="select" tabindex="12" >
		                                <c:forEach var="estatus" items="${estatusSolicitud}">
		                                   
		                                    <option value="<c:out value='${estatus.idEstatusSolicitud}'/>"
		                                            <c:if test="${status.value == estatus.idEstatusSolicitud}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estatus.descripcionEstatusSolicitud}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                        </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" style="text-align: center;" colspan="2">
                				 <a href="<c:url value="/"/>">
			                        <input type="button" value="Salir" class="input"/>
			                    </a>
			                    <input type="reset" class="input" value="Limpiar." tabindex="13"/>
                   				 <input type="submit" class="input" value="Siguiente." name="_target1" tabindex="14"/>
                			</td>
                		</tr>
                	</table>
                </div>
            </form>
        </spring:nestedPath>
    			
    			
    			
    			
    			
    			
    			
    
    
    
        

    </body>

</html>
