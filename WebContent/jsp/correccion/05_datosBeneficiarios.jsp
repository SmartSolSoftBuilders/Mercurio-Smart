<%@page import="mx.com.seguros.model.Solicitud"%>
<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<script type="text/javascript" >
			numMaxBeneficiarios = <%=Solicitud.NUM_MAX_BENEFICIARIOS%>;
            function agregarBeneficiario() {
                for(var i=0;i<numMaxBeneficiarios;i++){
                	var beneficiario = document.getElementById(
		        			"beneficiarioNuevo_"+i);
                	if(beneficiario.style.display == 'none'){
                		beneficiario.style.display = 'inline';
                		break;
                	}
                }
               
            }

            function quitarBeneficiario() {
            	for(var i=numMaxBeneficiarios-1;i>=0;i--){
                	var beneficiario = document.getElementById(
		        			"beneficiarioNuevo_"+i);
                	if(beneficiario.style.display == 'inline'){
                		beneficiario.style.display = 'none';
                		document.getElementById("datosNuevos.solicitud.beneficiario["+i+"].porcentajeAsignado").value="0";
                		break;
                	}
                }
            }

          
            
            
            
        </script>

<div id="titleg664x16">Datos de Beneficiarios
 <a href="javascript:expandirContraer('seccionBeneficiario')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionBeneficiario"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionBeneficiario')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionBeneficiario"
			><span>[-]</span></a>
</div>
                
                <div class="row660" id="seccionBeneficiario">
                	<table cellpadding="0" cellspacing="2" width="100%">
                		<tr>
                			
                			<td class="fieldRow">
                				&nbsp;&nbsp;Valor Actual
                			</td>
                			<td class="fieldRow" >
                				&nbsp;&nbsp;Seleecione nuevo valor (si aplica)
                			</td>
                		</tr>
                		<tr>
                			
                			<td  valign="top">
                    			<!-- Beneficiarios originales -->
                    				<c:forEach items="${command.datosOriginales.solicitud.beneficiario}"
                    				var="beneficiario" varStatus="varStatus" 
                    				>
                    				<table  cellpadding="0" cellspacing="2" width="100%" 
                    				id="beneficiarioOriginal_${varStatus.index}"
                    				style="display:<c:out value='${beneficiario.apPaternoBeneficiario != null && beneficiario.apPaternoBeneficiario != ""?"inline":"none"}'/>">
                    					<tr>
	                    					<td class="fieldRow"  colspan="2" >
	                    					
	                    						&nbsp;<b>Beneficiario <c:out value="${varStatus.index+1}"></c:out></b>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Apellido Paterno:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].apPaternoBeneficiario">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Apellido Materno:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].apMaternoBeneficiario">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Primer Nombre:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].nombre1Beneficiario">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Segundo Nombre:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].nombre2Beneficiario">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Fecha Nacimiento:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].fechaNacimientoBeneficiario">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Parentesco:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].parentesco">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					
                    					<tr>
	                    					<td class="labelRow">
	                    						Porcentaje Asignado:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosOriginales.solicitud.beneficiario[${varStatus.index}].porcentajeAsignado">
				                    				<input type="text" size="15" class="inputInfo" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
													 readonly/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					
                    				</table>	
                    				</c:forEach>
                    			<!-- /Beneficiarios originales -->
                			</td>
                			<td valign="top">
                    			<!-- Beneficiarios nuevos -->
                    				<c:forEach items="${command.datosNuevos.solicitud.beneficiario}"
                    				var="beneficiario" varStatus="varStatus" 
                    				>
                    				<table  cellpadding="0" cellspacing="2" width="100%" 
                    				id="beneficiarioNuevo_${varStatus.index}"
                    				style="display:<c:out value='${(varStatus.index == 0) || (beneficiario.apPaternoBeneficiario != null && beneficiario.apPaternoBeneficiario != "")?"inline":"none"}'/>">
                    					<tr>
	                    					<td class="fieldRow"  colspan="2" >
	                    					
	                    						&nbsp;<b>Beneficiario <c:out value="${varStatus.index+1}"></c:out></b>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Apellido Paterno:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].apPaternoBeneficiario">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
				                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].apPaternoBeneficiario'),null);"
													 />
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Apellido Materno:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].apMaternoBeneficiario">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
													 onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].apMaternoBeneficiario'),null);"/>
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Primer Nombre:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].nombre1Beneficiario">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
				                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].nombre1Beneficiario'),null);"
													 />
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Segundo Nombre:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].nombre2Beneficiario">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
				                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].nombre2Beneficiario'),null);"
													 />
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Fecha Nacimiento:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].fechaNacimientoBeneficiario">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
				                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].fechaNacimientoBeneficiario'),null);"
													 />
													 <A HREF="#" onClick="cal18.select(document.getElementById('${status.expression}'),'anchorFechaNacBenef${varStatus.index}','dd/MM/yyyy'); return false;" 
						                             NAME="anchorFechaNacBenef${varStatus.index}" ID="anchorFechaNacBenef${varStatus.index}" >
						                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
						                            </A> 
				                    			</spring:bind>
				                    			
	                    						
	                    					</td>
                    					</tr>
                    					<tr>
	                    					<td class="labelRow">
	                    						Parentesco:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].parentesco">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
				                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].parentesco'),null);"
													 />
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					
                    					<tr>
	                    					<td class="labelRow">
	                    						Porcentaje Asignado:
	                    					</td>
	                    					<td class="fieldRow">
	                    						<spring:bind path="datosNuevos.solicitud.beneficiario[${varStatus.index}].porcentajeAsignado">
				                    				<input type="text" size="15" class="input" 
													name="${status.expression}"
				                					id="${status.expression}"
				                					value="${status.value}"
				                					seccion="seccionBeneficiario"
				                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.beneficiario[${varStatus.index}].porcentajeAsignado'),null);"
													 />
				                    			</spring:bind>
	                    						
	                    					</td>
                    					</tr>
                    					
                    				</table>	
                    				</c:forEach>
                    			<!-- /Beneficiarios nuevos -->
                    			<input type="button" value="Agregar Beneficiario" class="input" onclick="agregarBeneficiario();"/>
                    			&nbsp;
                    			<input type="button" value="Quitar Beneficiario" class="input" onclick="quitarBeneficiario();"/>
                    			
                			</td>
                		</tr>
                	</table>
                </div>