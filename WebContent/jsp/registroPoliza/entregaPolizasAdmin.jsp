<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map, java.util.HashMap"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
    <script language="JavaScript" 
            src="<c:url value="/js/GUIHelper.js"/>">
    </script>
    <title>Generar reporte de p&oacute;lizas emitidas</title>
    <script>
        function polizaEntregada(){
            document.location.href='polizaEntregadaEmitida';
        }
        
        
        
        function polizaolizaEmitida(){
            document.forms[0].action="polizaEntregadaEmitida";
            document.forms[0].submit();
        }
    </script>
</head>

<body>
<jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
    <tag:errors name="datosPoliza"/>
    <spring:nestedPath path="datosPoliza">
        <form action="#" method="POST">
            <table width="740" height="199" border="0" align="center">
                <tr >
                    <div id="titleg664x16">Generar reporte de p&oacute;lizas emitidas</div>
                    <td height="169"><table width="776" height="149" border="0" align="center">
                            <tr>
                                <div class="row660">
                                    <label class="label330">Clave del agente:&nbsp;&nbsp;</label>
                                    <span class="field330">
                                        <spring:bind path="polizaIndividual.solicitud.cveAgente">
                                            <input type="text" name="${status.expression}" id="cveAgenteFrm" value="${status.value}" class="input" readonly="true"/>
                                        </spring:bind>
                                        
                                        <a href="javascript:launch('buscarAgentes','Listado de Agentes -Seleccione un registro de la lista-','ID Agente: :cveAgente:cveAgenteFrm:t:t,1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:t,2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:t, Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:t,Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:t','',550,650);">&nbsp;
                                            <img src="<c:url value="/"/>img/helper.png"/>
                                        </a>
                                    </span>
                                    <span>
                                        <spring:bind path="polizaIndividual.solicitud.empleado.apPaternoEmpleado">
                                            <input type="hidden" name="${status.expression}" id="apPaternoAgenteFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="1"/>
                                        </spring:bind>
                                    </span>
                                    <span>
                                        <spring:bind path="polizaIndividual.solicitud.empleado.apMaternoEmpleado">
                                            <input type="hidden" name="${status.expression}" id="apMaternoAgenteFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="1"/>
                                        </spring:bind>
                                    </span>
                                    <span>
                                        <spring:bind path="polizaIndividual.solicitud.empleado.nombre1Empleado">
                                            <input type="hidden" name="${status.expression}" id="nombre1AgenteFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="1"/>
                                        </spring:bind>
                                    </span>
                                    <span>
                                        <spring:bind path="polizaIndividual.solicitud.empleado.nombre2Empleado">
                                            <input type="hidden" name="${status.expression}" id="nombre2AgenteFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="1"/>
                                        </spring:bind>
                                        
                                    </span>
                                </div> 
                                
                                
                                <label class="label330">Estatus de P&oacute;lizas en reporte:&nbsp;&nbsp;</label>
                                <span class="field330">
                                    <%! java.util.List datos=null;%>
                                    
                                    <%datos=(java.util.List)session.getAttribute("listaValores");
                                    if(datos!=null){%>
                                    
                                    <%
                                     Map<String,Integer> estatusPolizaOp = new HashMap<String,Integer>();
                                     for(int i=0;i<datos.size();i++) {
                                     mx.com.seguros.model.EstatusPolizaSeguimiento datosAux=(mx.com.seguros.model.EstatusPolizaSeguimiento)datos.get(i);
                                    
                                        estatusPolizaOp.put(datosAux.getDescripcionEstatusPoliza(),datosAux.getIdEstatusPolizaSeguimiento());
                                        }%>
                                    <spring:bind path="polizaIndividual.estatusPolizaSeguimiento.idEstatusPolizaSeguimiento">
                                        <select name="${status.expression}" class="select" tabindex="7">
                                           <c:forEach var="estatusPolizaItem" items="<%=estatusPolizaOp%>">
                                                <option value="<c:out value='${estatusPolizaItem.value}'/>" 
                                                        <c:if test="${status.value == estatusPolizaItem.value}"> 
                                                            selected="selected"
                                                        </c:if> 
                                                 >
                                                    <c:out value="${estatusPolizaItem.key}"/>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </spring:bind>

                                    <%}%>
                                </span> 
                                <span>
                                    
                                    <div align="center" class="submit664">
                                        
                                        <input type="submit" class="input" name="_finish" value="Generar reporte" />
                                        <a href="<c:url value="/"/>app/logoutcontroller">
                                            <input type="button" class="input"  value="Salir" />
                                        </a>
                                    </div>
                                </span> 
                                
                                
                                
                                <div id="titleg664x16">Registrar Entrega de P&oacute;lizas</div>
                                <div align="center" class="submit664">
                                    <input type="button"  class="input" value="Entrega de pol. a los agentes" onclick="polizaEntregada();" />
                                </div>                                             
                                
                            </tr>
                    </table></td>
                </tr>
            </table>
        </form>
    </spring:nestedPath>
</body>
</html>
