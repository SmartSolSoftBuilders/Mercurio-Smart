<% response.setContentType("application/vnd.ms-excel");%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html>
	<head>
	</head>
	<body>

    	   <spring:nestedPath path="criteriosBusqueda">
    	<div align="center" >
                    <table width="100%" border="0" cellpadding="5" cellspacing="1">
                          <tr>	
                          	<td colspan="24" style="font-size:medium;font-weight: bold;">
                          		<strong>Consulta General de Solicitudes</strong>
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
                            	<c:out value="${resultado.totalResultados}"/>
                            </td>
                            
                            <td colspan="22">
                            </td>
							<!-- 26 cols -->
                        </tr>
                        <tr>
                        
                        	 <td  align="left" style="font-size:small;font-weight: bold;">
                                Total de Primas
                            </td>
                            <td>
                            	<fmt:formatNumber value="${resultado.totalPrima}" pattern="$ #,##0.00"/>
                            </td>
                            
                            <td colspan="22">
                            </td>
                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="24" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                           
                            
                            	<c:forEach var="columna" items="${criteriosBusqueda.columnas}" varStatus="iCol">
                            		<td align="center" class="ContenTablaColor">
                            		<strong>
                            		<c:if test="${resultado == null }">
                            			${columna} 
                            		</c:if>
                            		<c:if test="${resultado != null }">
	                            		${columna} 
	                            		<c:if test="${criteriosBusqueda.orden[iCol.index] == 'asc' }">
	                            			&#94;
	                            		</c:if>
	                            		<c:if test="${criteriosBusqueda.orden[iCol.index] == 'desc' }">
	                            			v
	                            		</c:if>
                            		</c:if>
                            		
                            		
                            		</strong>
                            		</td>
                            	</c:forEach>
                                                        
                        </tr>
                        <c:forEach var="registro" items="${resultado.resultados}">
                                    <tr align="left" valign="middle">
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
                                        <td class="ContenTabla" nowrap><c:out value="${registro.primaMensual}"/></td>
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
                                    </tr>
                        </c:forEach>
                        </table>
                </div>
                </spring:nestedPath>
	
	</body>
</html>