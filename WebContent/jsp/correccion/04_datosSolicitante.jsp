<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<div id="titleg664x16">Datos del solicitante
<a href="javascript:expandirContraer('seccionSolicitante')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionSolicitante"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionSolicitante')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionSolicitante"
			><span>[-]</span></a>
</div>
                
                <div class="row660" id="seccionSolicitante">
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
                				No. emp.:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.RFCsolicitante">
                    				<input type="text" size="15" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.RFCsolicitante">
                    				<input type="text" size="15" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.RFCsolicitante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Paterno:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.solicitante.apPaternoSolicitante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.solicitante.apPaternoSolicitante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.apPaternoSolicitante'),null);"
									 />
                    			</spring:bind>
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Materno:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.apMaternoSolicitante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.apMaternoSolicitante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.apMaternoSolicitante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Primer Nombre:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.nombre1Solicitante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.nombre1Solicitante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.nombre1Solicitante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Segundo Nombre:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.nombre2Solicitante">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.nombre2Solicitante">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.nombre2Solicitante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha Nacimiento:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.fechaNacimientoSolicitante">
                    				<input type="text" size="11" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
	                            
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.fechaNacimientoSolicitante">
                    				<input type="text" size="11" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.fechaNacimientoSolicitante'),null);"
									 />
                    			</spring:bind>
	                            <A HREF="#" onClick="cal18.select(document.getElementById('datosNuevos.solicitud.solicitante.fechaNacimientoSolicitante'),'anchorFechaNacSolicitante','dd/MM/yyyy'); return false;" 
	                             NAME="anchorFechaNacSolicitante" ID="anchorFechaNacSolicitante" >
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A> 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Puesto:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.puestoSolicitante">
                    				<input type="text" size="15" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.puestoSolicitante">
                    				<input type="text" size="15" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.puestoSolicitante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Ingreso Mensual:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.ingresoMensualSolicitante">
                    				<input type="text" size="15" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.ingresoMensualSolicitante">
                    				<input type="text" size="15" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionSolicitante"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.ingresoMensualSolicitante'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Sexo:
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosOriginales.solicitud.solicitante.sexoSolicitanteMasculino">
		                            <input type="radio" 
		                                   name="${status.expression}" 
		                                   value=true
		                                   <c:if test="${status.value}">
		                                       checked="checked" 
		                                   </c:if>
		                                   />
		                            <label>Masculino.&nbsp;&nbsp;</label>       
		                            <input type="radio" 
		                                   name="${status.expression}" 
		                                   value=false
		                                   <c:if test="${!status.value}">
		                                       checked="checked"
		                                   </c:if>
		                                  />
		                            <label>Femenino.&nbsp;&nbsp;</label>
		                        </spring:bind>
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.solicitante.sexoSolicitanteMasculino">
		                            <input type="radio" 
		                                   name="${status.expression}" 
		                                   value=true
		                                   <c:if test="${status.value}">
		                                       checked="checked" 
		                                   </c:if>
		                                  
		                                   seccion="seccionSolicitante"
		                                   />
		                            <label>Masculino.&nbsp;&nbsp;</label>       
		                            <input type="radio" 
		                                   name="${status.expression}" 
		                                   value=false
		                                   <c:if test="${status.value!= null && !status.value}">
		                                       checked="checked"
		                                   </c:if>
		                                   
		                                   seccion="seccionSolicitante"
		                                   />
		                            <label>Femenino.&nbsp;&nbsp;</label>
		                        </spring:bind>
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Estado Civil:
                			</td>
                			<td class="fieldRow">
                				
                    			<%
		                        
		                        Map<String, Long> estadoCivil = new HashMap<String, Long>();
		                        estadoCivil.put("Soltero", 1L);
		                        estadoCivil.put("Casado", 2L);
		                        estadoCivil.put("Divorciado", 3L);
		                        estadoCivil.put("Viudo", 4L);
		                        estadoCivil.put("Separado", 5L);
		                        estadoCivil.put("Uni&oacute;n Libre", 6L);
		                        %>
		                        
                    			
                    			<spring:bind path="datosOriginales.solicitud.solicitante.estadoCivilSolicitante">
		                            <select name="${status.expression}" id="${status.expression}" class="input" 
		                            
		                             >
		                                <c:forEach var="estadoCivilItem" items="<%=estadoCivil%>">
		                                    <option value="<c:out value='${estadoCivilItem.value}'/>"
		                                            <c:if test="${status.value == estadoCivilItem.key}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estadoCivilItem.key}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                    			
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<spring:bind path="datosNuevos.solicitud.solicitante.estadoCivilSolicitante">
		                            <select name="${status.expression}" id="${status.expression}" class="input" 
									seccion="seccionSolicitante"
									onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.estadoCivilSolicitante'),null);"
									 >
									 	<option value=""   >
		                                        -
		                                    </option>
		                                <c:forEach var="estadoCivilItem" items="<%=estadoCivil%>">
		                                    <!--c:forEach var="estadoCivilItem" 
		                                    items="<{solicitudBusiness.estadoCivil}>"-->
		                                    <option value="<c:out value='${estadoCivilItem.value}'/>"
		                                            <c:if test="${status.value != null && status.value == estadoCivilItem.key}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estadoCivilItem.key}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                    			 
                			</td>
                		</tr>
                		
                	</table>
                
                </div>
                <div id="titleg664x16">Domicilio del Solicitante
                <a href="javascript:expandirContraer('seccionDomicilio')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionDomicilio"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionDomicilio')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionDomicilio"
			><span>[-]</span></a>
                </div>
                <div class="row660" id="seccionDomicilio">
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
                				Calle:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.calle">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.calle">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.calle'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Edificio:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.edificio">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.edificio">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.edificio'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				No. ext. / No. Int.:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.numExtInt">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.numExtInt">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.numExtInt'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Colonia / Fraccionamiento:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.colonia">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                    			
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.colonia">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.colonia'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				C&oacute;digo Postal:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.codPostal">
                    				<input type="text" size="7" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.codPostal">
                    				<input type="text" size="7" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.codPostal'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Delegaci&oacute;n / Municipio:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.delegacionMpio">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.delegacionMpio">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.delegacionMpio'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Ciudad / Poblaci&oacute;n:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.ciudadPoblacion">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.ciudadPoblacion">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.ciudadPoblacion'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Entidad Federativa:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.entidadFederativa">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.entidadFederativa">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.entidadFederativa'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				E-mail:
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosOriginales.solicitud.solicitante.email">
                    				<input type="text" size="25" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind>
                			</td>
                			<td class="fieldRow">
                    			<spring:bind path="datosNuevos.solicitud.solicitante.email">
                    				<input type="text" size="25" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
                					onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.email'),null);"
									 />
                    			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Tel&eacute;fono:
                			</td>
                			<td class="fieldRow">
                    			LADA: &nbsp;&nbsp;&nbsp;&nbsp;<spring:bind path="datosOriginales.solicitud.solicitante.lada">
                    				<input type="text" size="5" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind> (S&oacute;lo n&uacute;meros)
                    			 &nbsp; <br/>
                    			 Tel&eacute;fono: 
                    			 <spring:bind path="datosOriginales.solicitud.solicitante.telefono">
                    				<input type="text" size="15" class="inputInfo" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
									 readonly/>
                    			</spring:bind> (S&oacute;lo n&uacute;meros)
                			</td>
                			<td class="fieldRow">
                    			LADA: &nbsp;&nbsp;&nbsp;&nbsp;<spring:bind path="datosNuevos.solicitud.solicitante.lada">
                    				<input type="text" size="5" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
									 onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.lada'),null);"/>
                    			</spring:bind> (S&oacute;lo n&uacute;meros)
                    			 &nbsp; <br/>
                    			 Tel&eacute;fono: 
                    			 <spring:bind path="datosNuevos.solicitud.solicitante.telefono">
                    				<input type="text" size="15" class="input" 
									name="${status.expression}"
                					id="${status.expression}"
                					value="${status.value}"
                					seccion="seccionDomicilio"
									 onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.solicitud.solicitante.telefono'),null);"/>
                    			</spring:bind> (S&oacute;lo n&uacute;meros)
                			</td>
                		</tr>
                	</table>
                </div>