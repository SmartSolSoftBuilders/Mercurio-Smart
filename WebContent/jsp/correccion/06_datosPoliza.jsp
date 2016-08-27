<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<div id="titleg664x16">Datos de la P&oacute;liza
<a href="javascript:expandirContraer('seccionPoliza')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionPoliza"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionPoliza')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionPoliza"
			><span>[-]</span></a>
</div>
                
                <div class="row660" id="seccionPoliza">
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
                				Emisor:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.numConsignatario">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.numConsignatario">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10" 
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.numConsignatario'),null);"
                          		  />
                       			</spring:bind>
                			</td>
                		</tr>	
                		<tr>
                			<td class="labelRow"> 
                				P&oacute;liza:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.numPoliza">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.numPoliza">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  seccion="seccionPoliza"
                          		  class="input" size="10"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.numPoliza'),null);"
                          		   />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				CIS:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.agrupacionCIS">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.agrupacionCIS">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10"
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.agrupacionCIS'),null);"
                          		   />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Fecha de expedici&oacute;n:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.fechaExpedicion">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.fechaExpedicion">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  seccion="seccionPoliza"
                          		  class="input" size="10"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.fechaExpedicion'),null);"
                          		   />
                          		   <A HREF="#" onClick="cal18.select(document.getElementById('${status.expression}'),'anchorFechaExpedicion','dd/MM/yyyy'); return false;" 
		                             NAME="anchorFechaExpedicion" ID="anchorFechaExpedicion" >
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 
                       			</spring:bind>
                			</td>
                		</tr>	
                		<tr>
                			<td class="labelRow"> 
                				Fecha inicio vigencia:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.fechaInicioVigencia">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.fechaInicioVigencia">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  seccion="seccionPoliza"
                          		  class="input" size="10"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.fechaInicioVigencia'),null);"
                          		   />
                          		   <A HREF="#" onClick="cal18.select(document.getElementById('${status.expression}'),'anchorFechaInicioVigencia','dd/MM/yyyy'); return false;" 
		                             NAME="anchorFechaInicioVigencia" ID="anchorFechaInicioVigencia" >
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Fecha fin vigencia:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.fechaFinVigencia">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.fechaFinVigencia">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10"
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.fechaFinVigencia'),null);"
                          		  />
                          		  <A HREF="#" onClick="cal18.select(document.getElementById('${status.expression}'),'anchorFechaFinVigencia','dd/MM/yyyy'); return false;" 
		                             NAME="anchorFechaFinVigencia" ID="anchorFechaFinVigencia" >
		                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
		                            </A> 
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Suma BAF:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.sumaBAF">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.sumaBAF">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10" 
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.sumaBAF'),null);"
                          		  />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Suma asegurada individual:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.sumaAseguradaIndividual">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.sumaAseguradaIndividual">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10"
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.sumaAseguradaIndividual'),null);"
                          		   />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Suma gastos funerarios:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.sumaGastosFunerarios">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.sumaGastosFunerarios">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10" 
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.sumaGastosFunerarios'),null);"
                          		  />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Suma SEVI:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.sumaSEVI">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.sumaSEVI">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10" 
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.sumaSEVI'),null);"
                          		  />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Ahorro Adicional Mensual:
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="datosOriginales.importeAhorroAdicionalMensual">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.importeAhorroAdicionalMensual">
                          		  <input type="text" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="input" size="10" 
                          		  seccion="seccionPoliza"
                          		  onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.importeAhorroAdicionalMensual'),null);"
                          		  />
                       			</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Tipo de Seguro:
                			</td>
                			<td class="fieldRow">
                				<input type="text" name="descripcionTipoSeguro"
                				id="descripcionTipoSeguro"
                				title="${command.datosOriginales.tipoSeguro} - ${command.datosOriginales.descripcionPaqueteVidadxn}"
                				value="${command.datosOriginales.tipoSeguro} - ${command.datosOriginales.descripcionPaqueteVidadxn}"
                				class="inputInfo" size="15" readonly="readonly"
                				 />
                				<spring:bind path="datosOriginales.tipoSeguro">
                          		  <input type="hidden" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  class="inputInfo" size="10" readonly="readonly"/>
                       			</spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.descripcionPaqueteVidadxn">
                					<input type="text" 
                					name="${status.expression}" 
                          		  	id="${status.expression}" 
                          		  	value="${status.value}" 
                          		  	readonly
                					class="input" size="10" onchange="borrarCampo(this,'datosNuevos.tipoSeguro');"
                				 />
                				</spring:bind>
                				
                				<spring:bind path="datosNuevos.tipoSeguro">
                          		  <input type="hidden" 
                          		  name="${status.expression}" 
                          		  id="${status.expression}" 
                          		  value="${status.value}" 
                          		  seccion="seccionPoliza"
                          		  
                          		  onchange="cambioTipoSeguro();"
                          		  class="input" size="10" />
                       			</spring:bind>
                       			<a href="javascript:launch('obtenerTipoSeguro',
                       			'Paquetes Descuento x Nomina -Seleccione un registro de la lista-',
                       			'Id: :idPaqueteVidaDxN:datosNuevos.tipoSeguro:f:t,Paquete: :nombrePaquete:datosNuevos.descripcionPaqueteVidadxn:t:t,Descripcion: :descripcionPaquete:descripcionPaqueteFrm:t:f',
                       			'',
                       			500,
                       			300,
                       			'cambioTipoSeguro');" tabindex="14">
                                <img src="<c:url value="/"/>img/helper.png" alt="Buscar Paquetes"/></a>
                       			 <a href="javascript:borrar('datosNuevos.descripcionPaqueteVidadxn');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
			                   
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Estado de Seguimiento:
                			</td>
                			<td class="fieldRow">
                				 <spring:bind path="datosOriginales.idEstatusPolizaSeguimiento">
		                            <select name="${status.expression}" id="${status.expression}" class="inputInfo" 
		                            
		                             >
		                                <c:forEach var="estado" items="${listaEstatusPolizaSeguimiento}">
		                                    
		                                    <option value="<c:out value='${estado.idEstatusPolizaSeguimiento}'/>"
		                                            <c:if test="${status.value == estado.idEstatusPolizaSeguimiento}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estado.descripcionEstatusPoliza}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                				
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.idEstatusPolizaSeguimiento">
		                            <select name="${status.expression}" id="${status.expression}" class="input" 
		                            seccion="seccionPoliza"
		                            onchange="cambioCampo(this,document.getElementById('datosOriginales.idEstatusPolizaSeguimiento'),null);"
		                             ><option value="">-</option>
		                                <c:forEach var="estado" items="${listaEstatusPolizaSeguimiento}">
		                                    
		                                    <option value="<c:out value='${estado.idEstatusPolizaSeguimiento}'/>"
		                                            <c:if test="${status.value == estado.idEstatusPolizaSeguimiento}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estado.descripcionEstatusPoliza}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                       			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow"> 
                				Estado de Pagos:
                			</td>
                			<td class="fieldRow">
                				 <spring:bind path="datosOriginales.idEstatusPagosPoliza">
		                            <select name="${status.expression}" id="${status.expression}" class="inputInfo" 
		                            
		                             >
		                                <c:forEach var="estado" items="${listaEstatusPolizaPagos}">
		                                    
		                                    <option value="<c:out value='${estado.idEstatusPagosPoliza}'/>"
		                                            <c:if test="${status.value == estado.idEstatusPagosPoliza}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estado.descripcionEstatusPagosPoliza}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                				
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.idEstatusPagosPoliza">
		                            <select name="${status.expression}" id="${status.expression}" class="input" 
		                            seccion="seccionPoliza"
		                            onchange="cambioCampo(this,document.getElementById('datosOriginales.idEstatusPagosPoliza'),null);"
		                             ><option value="">-</option>
		                                <c:forEach var="estado" items="${listaEstatusPolizaPagos}">
		                                    
		                                    <option value="<c:out value='${estado.idEstatusPagosPoliza}'/>"
		                                            <c:if test="${status.value == estado.idEstatusPagosPoliza}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${estado.descripcionEstatusPagosPoliza}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                       			
                			</td>
                		</tr>
                		
            		</table>
            	</div>
            	<div id="titleg664x16">Beneficios Adicionales
            	<a href="javascript:expandirContraer('seccionBeneficios')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionBeneficios"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionBeneficios')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionBeneficios"
			><span>[-]</span></a>
            	</div>
                <div class="row660" id="seccionBeneficios">
                	<table cellpadding="0" cellspacing="2" width="100%">
                		<tr>
                			<td class="fieldRow"> 
                				&nbsp;&nbsp;Valor Actual
                			</td>
                			<td class="fieldRow">
                				&nbsp;&nbsp;Selecccione nuevo valor(si aplica)
                			</td>
                			
                		</tr>		
                		<tr>
                			<td class=""> 
                				<!-- Inicio Benficios Originales-->
                				<table cellpadding="0" cellspacing="2" width="100%">
                					<tr>
                						<td class="labelRow"> 
                							&nbsp;
                						</td>
                						<td class="fieldRow" nowrap="nowrap">
                							Costo del Beneficio
                						</td>
                						<td class="fieldRow" nowrap="nowrap">
                							Monto de la Cobertura
                						</td>
                					</tr>
                					<c:forEach items="${command.datosOriginales.beneficiosAdicionales}" var="beneficio" varStatus="iStatus">
	                					<tr>
	                						<td class="labelRow" nowrap> 
	                							${beneficio.descripcionBeneficio}:
	                						</td>
	                						<td class="fieldRow">
	                							<spring:bind path="datosOriginales.beneficiosAdicionales[${iStatus.index}].sumaBeneficio">
						                           	 <input type="text" name="${status.expression}" 
						                           	 size="13"
						                           	 id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/>
						                        </spring:bind>
	                						</td>
	                						<td class="fieldRow">
	                							<spring:bind path="datosOriginales.beneficiosAdicionales[${iStatus.index}].montoCobertura">
						                           	 <input type="text" name="${status.expression}" 
						                           	 size="13"
						                           	 id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/>
						                         </spring:bind>
	                						</td>
	                					</tr>
                					</c:forEach>
                				</table>
                				
					                    
                				
                				<!-- /Inicio Benficios Originales-->
                			</td>
                			<td class="">
                				<!-- Inicio Benficios Nuevos-->
                				<table cellpadding="0" cellspacing="2" width="100%">
                					<tr>
                						<td class="labelRow"> 
                							&nbsp;
                						</td>
                						<td class="fieldRow" nowrap="nowrap">
                							Costo del Beneficio
                						</td>
                						<td class="fieldRow" nowrap="nowrap">
                							Monto de la Cobertura
                						</td>
                					</tr>
                					<c:forEach items="${command.datosNuevos.beneficiosAdicionales}" var="beneficio" varStatus="iStatus">
	                					<tr>
	                						<td class="labelRow" nowrap> 
	                							${beneficio.descripcionBeneficio}:
	                						</td>
	                						<td class="fieldRow">
	                							<spring:bind path="datosNuevos.beneficiosAdicionales[${iStatus.index}].sumaBeneficio">
						                           	 <input type="text" name="${status.expression}" 
						                           	 size="13"
						                           	 id="${status.expression}" value="${status.value}" class="input"
						                           	 seccion="seccionBeneficios"
						                           	 onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.beneficiosAdicionales[${iStatus.index}].sumaBeneficio'),null);"
						                           	 />
						                        </spring:bind>
	                						</td>
	                						<td class="fieldRow">
	                							<spring:bind path="datosNuevos.beneficiosAdicionales[${iStatus.index}].montoCobertura">
						                           	 <input type="text" name="${status.expression}" 
						                           	 size="13"
						                           	 seccion="seccionBeneficios"
						                           	 id="${status.expression}" value="${status.value}" class="input"
						                           	 onchange="javascript:cambioCampo(this,document.getElementById('datosOriginales.beneficiosAdicionales[${iStatus.index}].montoCobertura'),null);"
						                           	 />
						                         </spring:bind>
	                						</td>
	                					</tr>
                					</c:forEach>
                				</table>
                				
					                    
                				
                				<!-- /Inicio Benficios Nuevos-->
                			</td>
                		</tr>
                		
                		
                		
                	</table>
                </div>