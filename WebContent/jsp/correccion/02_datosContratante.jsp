<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<div id="titleg664x16">Datos del contratante
				<a href="javascript:expandirContraer('seccionContratante')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionContratante"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionContratante')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionContratante"
			><span>[-]</span></a>
</div>
                <div class="row660" id="seccionContratante">
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
                				No. emp. (13 D&iacute;gitos):
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.numNominaContratante">
                    				<input type="text" size="15" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			
                			</td>
                			<td class="fieldRow">
	                			<spring:bind path="datosNuevos.solicitud.numNominaContratante">
                    				<input type="text" size="15" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionContratante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.numNominaContratante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Paterno:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.contratante.apPaternoContratante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.contratante.apPaternoContratante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionContratante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.contratante.apPaternoContratante'),null);"
									 />
                    			</spring:bind>
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Materno:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.contratante.apMaternoContratante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.contratante.apMaternoContratante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionContratante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.contratante.apMaternoContratante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Primer Nombre:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.contratante.nombre1Contratante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.contratante.nombre1Contratante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionContratante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.contratante.nombre1Contratante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Segundo Nombre:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.contratante.nombre2Contratante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.contratante.nombre2Contratante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionContratante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.contratante.nombre2Contratante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                	</table>
                
                </div>