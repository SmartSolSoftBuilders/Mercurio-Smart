<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<div id="titleg664x16">Datos de la Escuela
	<a href="javascript:expandirContraer('seccionEscuela')" 
			style="text-decoration: none" title="Expandir" 
			id="expandir_seccionEscuela"
			><span>[+]</span></a> 
			<a href="javascript:expandirContraer('seccionEscuela')" 
			style="text-decoration: none" title="Contraer"
			id="contraer_seccionEscuela"
			><span>[-]</span></a>
</div>
                <div class="row660" id="seccionEscuela">
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
                				Grupo Asegurado:
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="35" class="inputInfo" 
									name="nombreGrupoAsegurado"
                					id="nombreGrupoAsegurado"
                					title="${command.datosOriginales.solicitud.empresa.cveGrupoAsegurado} - ${command.datosOriginales.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado}"
                					value="${command.datosOriginales.solicitud.empresa.cveGrupoAsegurado} - ${command.datosOriginales.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado}"
									 readonly/>	
                				<spring:bind path="datosOriginales.solicitud.empresa.cveGrupoAsegurado">
		                            <input type="hidden" name="${status.expression}"  
		                            id="${status.expression}"  value="${status.value}"/>    
		                        </spring:bind>
                			</td>
                			<td class="fieldRow" >
                				 <spring:bind path="datosNuevos.solicitud.empresa.cveGrupoAsegurado">
			                          <input type="hidden" name="${status.expression}"  id="${status.expression}" value="${status.value}"
			                          onchange="cambioCveGrupoAsegurado();"
			                          seccion="seccionEscuela"
			                          />    
			                     </spring:bind>
			                     <spring:bind path="datosNuevos.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado">
			                     	 <input type="text" name="${status.expression}"
			                        id="${status.expression}" value="${status.value}" 
			                        class="input" size="30"  readonly
			                        onchange="borrarCampo(this,'datosNuevos.solicitud.empresa.cveGrupoAsegurado');"
			                         />
			                     </spring:bind>   
			                     <a href="javascript:launch('buscarGruposAsegs',
			                     'Listado de Grupos Asegurados -Seleccione un registro de la lista-',
			                     'Clave:cveGrupoAsegurado:cveGrupoAsegurado:datosNuevos.solicitud.empresa.cveGrupoAsegurado:f:t,Grupo:nombreGrupoAsegurado:nombreGrupoAsegurado:datosNuevos.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado:t:t',
			                     '',
			                     500,
			                     550,
			                     'cambioCveGrupoAsegurado'
			                     );" tabindex="2">
			                        <img src="<c:url value="/"/>img/helper.png" /></a>  
			                        <a href="javascript:borrar('datosNuevos.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
			                     
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Delegaci&oacute;n / Municipio:
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="35" class="inputInfo" 
									name="nombreSucursal"
                					id="nombreSucursal"
                					title="${command.datosOriginales.solicitud.empresa.cveSucursal} - ${command.datosOriginales.solicitud.empresa.sucursal.nombreSucursal}"
                					value="${command.datosOriginales.solicitud.empresa.cveSucursal} - ${command.datosOriginales.solicitud.empresa.sucursal.nombreSucursal}"
									 readonly/>	
                				<spring:bind path="datosOriginales.solicitud.empresa.cveSucursal">
		                            <input type="hidden" name="${status.expression}"  
		                            id="${status.expression}" value="${status.value}"/>    
		                        </spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.solicitud.empresa.cveSucursal">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}" 
		                            onchange="cambioCveSucursal()"
		                            seccion="seccionEscuela"
		                            />
		                        </spring:bind>
		                        <spring:bind path="datosNuevos.solicitud.empresa.sucursal.nombreSucursal">
		                        	<input type="text"
		                        	name="${status.expression}" id="${status.expression}"
		                        	 value="${status.value}" class="input"  
		                        	  size="30" readonly
										onchange="borrarCampo(this,'datosNuevos.solicitud.empresa.cveSucursal');"
										 />
		                        </spring:bind>
		                        
		                        <a href="javascript:launch('obtenerSucursalesPorGrupo',
		                        'Sucursales del Grupo Asegurado -Seleccione un registro de la lista-',
		                        'Clave: :cveSucursal:datosNuevos.solicitud.empresa.cveSucursal:t:t, Deleg/Mpio: :sucursal'+'.'+'nombreSucursal:datosNuevos.solicitud.empresa.sucursal.nombreSucursal:t:t',
		                        'cveGrupoAsegurado:'+document.getElementById('datosNuevos.solicitud.empresa.cveGrupoAsegurado').value,
		                        500,
		                        550,
		                        'cambioCveSucursal');" >
		                        <img src="<c:url value="/"/>img/helper.png" /></a>
                				 <a href="javascript:borrar('datosNuevos.solicitud.empresa.sucursal.nombreSucursal');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
			                     
                				
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Colonia / Barrio:
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="35" class="inputInfo" 
									name="nombreColonia"
                					id="nombreColonia"
                					title="${command.datosOriginales.solicitud.empresa.cveColonia} - ${command.datosOriginales.solicitud.empresa.colonia.tipoAsentamiento} ${command.datosOriginales.solicitud.empresa.colonia.asentamiento}"
                					value="${command.datosOriginales.solicitud.empresa.cveColonia} - ${command.datosOriginales.solicitud.empresa.colonia.tipoAsentamiento} ${command.datosOriginales.solicitud.empresa.colonia.asentamiento}"
									 readonly/>	
                				<spring:bind path="datosOriginales.solicitud.empresa.cveColonia">
		                            <input type="hidden" name="${status.expression}"  
		                            id="${status.expression}" value="${status.value}"/>    
		                        </spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.solicitud.empresa.colonia.asentamiento">
                					<input type="text" 
									name="${status.expression}"  
		                            id="${status.expression}" 
		                            seccion="seccionEscuela" readonly
		                            value="${status.value}" class="input" size="30" onchange="borrarCampo(this,'datosNuevos.solicitud.empresa.cveColonia');" />
                				</spring:bind>
                				<spring:bind path="datosNuevos.solicitud.empresa.cveColonia">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" 
		                            onchange="cambioCveColonia();"
		                            value="${status.value}"/>
		                        </spring:bind>
		                        <a href="javascript:launch('obtenerColoniasPorSucursal',
		                        'Colonias de la sucursal -Seleccione un registro de la lista-',
		                        'Clave: :cveColonia:datosNuevos.solicitud.empresa.cveColonia:t:t,Colonia: :colonia'+'.'+'asentamiento:datosNuevos.solicitud.empresa.colonia.asentamiento:t:t',
		                        'cveSucursal:'+document.getElementById('datosNuevos.solicitud.empresa.cveSucursal').value+',
		                        cveGrupoAsegurado:'+document.getElementById('datosNuevos.solicitud.empresa.cveGrupoAsegurado').value,
		                        500,
		                        550,
		                        'cambioCveColonia'
		                        );">
		                            <img src="<c:url value="/"/>img/helper.png" /></a>
		                         <a href="javascript:borrar('datosNuevos.solicitud.empresa.colonia.asentamiento');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
			                   
		                       
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Nombre de la Escuela:
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="35" class="inputInfo" 
									name="nombreEmpresa"
                					id="nombreEmpresa"
                					title="${command.datosOriginales.solicitud.cveEmpresa} - ${command.datosOriginales.solicitud.empresa.nombreEmpresa}"
                					value="${command.datosOriginales.solicitud.cveEmpresa} - ${command.datosOriginales.solicitud.empresa.nombreEmpresa}"
									 readonly/>	
                				<spring:bind path="datosOriginales.solicitud.cveEmpresa">
		                            <input type="hidden" name="${status.expression}"  
		                            id="${status.expression}" value="${status.value}"/>    
		                        </spring:bind>
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="datosNuevos.solicitud.empresa.nombreEmpresa">
	                				<input type="text" 
	                				name="${status.expression}"  
			                            id="${status.expression}" value="${status.value}" 
			                            readonly
	                				class="input" size="30" onchange="borrarCampo(this,'datosNuevos.solicitud.cveEmpresa');"  />
                				</spring:bind>
		                        <a href="javascript:launch('obtenerEmpresasPorColonia',
		                        'Empresas por colonia -Seleccione un registro de la lista-',
		                        'Clave: :cveEmpresa:datosNuevos.solicitud.cveEmpresa:t:t,Tipo: :tipoEmpresa'+'.'+'descripcionEmpresa:descripcionEmpresaFrm:t:f,Empresa: :nombreEmpresa:datosNuevos.solicitud.empresa.nombreEmpresa:t:t,Turno: :turnoEmpresa'+'.'+'nombreTurno:nombreTurnoFrm:t:f',
		                        'cveColonia:'+document.getElementById('datosNuevos.solicitud.empresa.cveColonia').value,
		                        500,
		                        550,
		                        'cambioCveEmpresa');" >
		                            <img src="<c:url value="/"/>img/helper.png" /></a>
		                        <a href="javascript:borrar('datosNuevos.solicitud.empresa.nombreEmpresa');" ><img border="0" src="<c:url value="/"/>img/borrar.png" alt="Borrar Valor"/></a>
			                   
		                        <spring:bind path="datosNuevos.solicitud.cveEmpresa">
		                            <input type="hidden"  name="${status.expression}"  
		                            id="${status.expression}" value="${status.value}"
		                            seccion="seccionEscuela"
		                            onchange="cambioCveEmpresa();"
		                            />
		                        </spring:bind>
                				
                			</td>
                		</tr>
                	</table>
                </div>