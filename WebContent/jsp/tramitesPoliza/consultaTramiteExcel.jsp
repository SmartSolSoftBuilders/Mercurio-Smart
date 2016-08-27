<% response.setContentType("application/vnd.ms-excel");%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html>
	<head>
	</head>
	<body>
    	   <spring:nestedPath path="criteriosConsulta">
    	   <div align="center" >
                   <table width="100%" border="0" cellpadding="5" cellspacing="1">
						  <tr>
                          	<td colspan="24" style="font-size:medium;font-weight: bold;">
                          		<strong>Consulta General de Tramites</strong>
                          	</td>
                          </tr>
                          <tr>
                          	<td colspan="24">
                          	</td>
                          </tr>
                          <tr>
                            <td  align="left" style="font-size:small;font-weight: bold;">
                                Total de registros 
                            </td>
                            <td>
                            	<c:out value="${fn:length(resultado)}"/>
                            </td>
                            
                            <td colspan="22">
                            </td>
							<!-- 26 cols -->
                        </tr>
     
                        <tr align="left" valign="middle" height="20">
                            <td colspan="24" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>


                        <tr>
                           <td align="center" class="ContenTablaColor"><strong>Emisor</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Num. de Poliza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha del Tr&aacute;mite</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tr&aacute;mite Solicitado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tr&aacute;mite Final</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Sucursal</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tel&eacute;fono</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Comentarios Asegurado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Comentarios Asesor</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Observaciones</strong></td>
                            
                        </tr>                       

                        
                        
                        <c:forEach var="registro" items="${resultado}">
                                    <tr align="left" valign="middle">
                                        <td class="ContenTabla"><c:out value="${registro.numConsignatario}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numPoliza}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fecha}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.tipoTramiteInicial.nombre}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.tipoTramiteFinal.nombre}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.oficina.nombre}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.usuario}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.telefono}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.comentariosAsegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.comentariosAsesor}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.observaciones}"/></td>                                
                                    </tr>
                        </c:forEach>
               
                   </table> 
            </div>
            </spring:nestedPath>	
	</body>
</html>