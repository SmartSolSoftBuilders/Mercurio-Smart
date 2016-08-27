<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>


			<div id="titleg664x16" >Datos de la Solicitud 
			<a href="javascript:expandirContraer('seccionSolicitud')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionSolicitud"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionSolicitud')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionSolicitud"
			><span>[-]</span></a></div>
                <div class="row660" id="seccionSolicitud">
                	
                	<table cellpadding="0" cellspacing="2" width="100%">
                		<tr>
                			<td class="labelRow">
                				&nbsp;
                			</td>
                			<td class="fieldRow">
                				&nbsp;&nbsp;Valor Actual
                			</td>
                			<td class="fieldRow" >
                				&nbsp;&nbsp;Seleecione nuevo valor (si aplica)
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Clave Agente:
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="20" 
                					class="inputInfo" 
                					title="${command.datosOriginales.solicitud.cveAgente} - ${command.datosOriginales.solicitud.agente.empleado.nombreCompleto}"
                					value="${command.datosOriginales.solicitud.cveAgente} - ${command.datosOriginales.solicitud.agente.empleado.nombreCompleto}" readonly/>
                				<spring:bind path="datosOriginales.solicitud.cveAgente">
                					<input type="hidden" 
                					name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"/>
                				</spring:bind>
                				         				
                				               				
                			</td>
                			<td class="fieldRow" valign="middle" >
                				<spring:bind path="datosNuevos.solicitud.cveAgente" >
                					<input type="text"
                					name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					readonly
                					seccion="seccionSolicitud"
	                				 size="10" class="input" onchange="javascript:cambioCveAgente();" />
	                    			<a href="javascript:launch('buscarAgentes',
	                    			'Listado de Agentes -Seleccione un registro de la lista-',
	                    			'ID Agente: :cveAgente:${status.expression}:t:t,1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f, Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f',
	                    			'',
	                    			700,
	                    			700,
	                    			'cambioCveAgente');">
	                                <img src="<c:url value="/"/>img/helper.png" alt="Buscar Agentes"/></a>&nbsp;
	                                <a href="javascript:borrar('datosNuevos.solicitud.cveAgente');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
                				</spring:bind>
                				
                               
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Tipo de Solicitud:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.tipoSolicitudNormal">
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
                			<td class="fieldRow">
                				<spring:bind path="datosNuevos.solicitud.tipoSolicitudNormal">
			                            <input onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.tipoSolicitudNormal'),null);"
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
			                                   seccion="seccionSolicitud"/>
			
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
			                                   seccion="seccionSolicitud"/>
			                            
			                            <label>Por contrato.&nbsp;&nbsp;</label>              
		                        </spring:bind> 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Folio:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.solicitud.folioSolicitud">
                    				<input type="text" size="10" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.folioSolicitud">
                    				<input type="text" size="10" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitud"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.folioSolicitud'),null);"
									 />
                    			</spring:bind>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				N&uacute;mero de Formato:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.formatoSolicitud">
                    				<input type="text" size="10" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.formatoSolicitud">
                    				<input type="text" size="10" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitud"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.formatoSolicitud'),null);"
									 />
                    			</spring:bind>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Tarifa:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.tarifa.descripcion">
                    				<input type="text" size="20" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			<spring:bind path="datosOriginales.solicitud.cveTarifa">
                    				<input type="hidden" size="10" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.tarifa.descripcion">
                    				<input type="text" size="20" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									readonly
									onchange="borrarCampo(this,'datosNuevos.solicitud.cveTarifa');"
									 />
                    			</spring:bind>
                    			<spring:bind path="datosNuevos.solicitud.cveTarifa">
                    				<input type="hidden" size="10" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitud"
                					
                					onchange="cambioCveTarifa();"
									 />
                    			</spring:bind>
                    			<a href="javascript:launch('buscarTarifas',
                    			'Tarifas -Seleccione un registro de la lista-',
                    			'No.: :cveTarifa:datosNuevos.solicitud.cveTarifa:f:t,Importe:Importe:descripcion:datosNuevos.solicitud.tarifa.descripcion:t:t',
                    			'',
                    			500,
                    			730,
                    			'cambioCveTarifa');" tabindex="7"><img src="<c:url value="/"/>img/helper.png" alt="Buscar Tarifas" /></a>
                    			&nbsp;
                    			<a href="javascript:borrar('datosNuevos.solicitud.tarifa.descripcion');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Clave Promotor:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" class="inputInfo" name="nombrePromotor"  id="nombrePromotor" size="25"
                    			title="${command.datosOriginales.solicitud.cvePromotor} - ${command.datosOriginales.solicitud.promotor.nombrePromotor}"
                    			value="${command.datosOriginales.solicitud.cvePromotor} - ${command.datosOriginales.solicitud.promotor.nombrePromotor}" readonly/>
                    			<spring:bind path="datosOriginales.solicitud.cvePromotor">
                    				<input type="hidden" size="10" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.cvePromotor">
		                            <input type="text" 
		                            name="${status.expression}" 
		                            id="${status.expression}" 
		                            value="${status.value}" size="5" tabindex="8" class="input"  
		                            onchange="cambioCvePromotor();"
		                            seccion="seccionSolicitud"
		                            readonly
		                            />
		                        </spring:bind>
		                        <a href="javascript:launch('buscarPromotores',
		                        'Listado de Promotores -Seleccione un registro de la lista-',
		                        'ID Promotor:cvePromotor:cvePromotor:datosNuevos.solicitud.cvePromotor:t:t,Nombre:nombrePromotor:nombrePromotor: :t:f',
		                        '',
		                        550,
		                        400,'cambioCvePromotor');" tabindex="9">
		                            <img src="<c:url value="/"/>img/helper.png"  alt="Buscar promotores"/></a>
                    			<a href="javascript:borrar('datosNuevos.solicitud.cvePromotor');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de la Solicitud:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.fechaSolicitud">
                    				<input type="text" size="10" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.fechaSolicitud">
		                            <input type="text" name="${status.expression}" id="${status.expression}" 
		                            onChange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.fechaSolicitud'),null);"
		                            value="${status.value}" size="11" 
									seccion="seccionSolicitud"
									 class="input"/>
		                            <A HREF="#" onClick="cal18.select(document.getElementById('${status.expression}'),'anchorfechaSolicitud','dd/MM/yyyy'); return false;" 
		                             NAME="anchorfechaSolicitud" ID="anchorfechaSolicitud" >
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 

                       			</spring:bind>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de producci&oacute;n:
                			</td>
                			<td class="fieldRow">
                				
                				<spring:bind path="datosOriginales.solicitud.fechaProduccion">
                    				<input type="text" size="10" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                				
                				<spring:bind path="datosNuevos.solicitud.fechaProduccion">
		                            <input type="text" name="${status.expression}" id="${status.expression}" 
		                            onChange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.fechaProduccion'),null);"
		                            value="${status.value}" size="11" 
		                            seccion="seccionSolicitud"
		                             class="input"/>
		                            <A HREF="#" onClick="cal18.select(document.getElementById('${status.expression}'),'anchorFechaProduccion','dd/MM/yyyy'); return false;" 
		                             NAME="anchorFechaProduccion" ID="anchorFechaProduccion" TABINDEX="11">
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 

                       			</spring:bind>
                    			
                			</td>
                		</tr>
                	</table>
                	
                </div>