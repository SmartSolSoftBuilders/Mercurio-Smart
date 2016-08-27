<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
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
        
        <!--agregue los nuevos campos del formulario-->
    
        <script language="JavaScript" type="text/javascript">
            
        	secciones = new Array("seccionSolicitud","seccionContratante","seccionEscuela",
        			"seccionSolicitante","seccionBeneficiario","seccionPoliza","seccionDomicilio","seccionBeneficios");
        	
        
        	//banderas de control del cambio de secciones
        	existeCambio = new Array();
        	for(var i=0;i<secciones.length;i++)
        		existeCambio[secciones[i]] = false;
        	
        	
        
        
        	var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
            
            function guardar(){
            	
            	if(document.getElementById("existenPagosAplicados").value == "true" && 
            			document.getElementById("datosOriginales.fechaInicioVigencia").value != 
            				document.getElementById("datosNuevos.fechaInicioVigencia").value &&
            				document.getElementById("datosNuevos.fechaInicioVigencia").value != ""){
            		if(!confirm("La póliza ya cuenta con pagos aplicados, ¿Está seguro que desea guardar el ticket de corrección con un cambio en la fecha de inicio de vigencia?")){
            			return false;
            		}
            	}
            	
            	document.w01.submit();
            }
            
            function guardarConEstado(estado){
            	document.getElementById("ticket.idEstadoTicketCorreccion").value = estado;
            	guardar();
            }
            function expandirContraer(nombreSeccion){
            	seccion = document.getElementById(nombreSeccion);
            	botonContraer = document.getElementById("contraer_"+nombreSeccion);
            	botonExpandir = document.getElementById("expandir_"+nombreSeccion);
            	if(seccion.style.display == 'none'){
            		seccion.style.display = 'block';
            		botonContraer.style.display = 'inline';
            		botonExpandir.style.display = 'none';
            	}else{
            		seccion.style.display = 'none';
            		botonContraer.style.display = 'none';
            		botonExpandir.style.display = 'inline';
            	}
            	
            	
            	
            }
        </script>
		<script language="JavaScript" type="text/javascript">
         
         	function cambioCampo(campo,campoOriginal,campoAlterno){
         		
         		if(campo.value == campoOriginal.value || campo.value == ""){
         			campo.setAttribute("class","input");
         			if(campoAlterno != null && campoAlterno !== undefined)
         			{
         				campoAlterno.setAttribute("class","input");
         			}
         			
         		}else{
         			
         			campo.setAttribute("class","inputAlert");
         			if(campoAlterno!= null && campoAlterno !== undefined)
         			{
         				campoAlterno.setAttribute("class","inputAlert");
         			}
         			try{
         				existeCambio[campo.getAttribute("seccion")] = true;
         			}catch(ex){}
         		}
         		
         	}
         	
         	
         	function cambioCveAgente(){
         		
         		cambioCampo(document.getElementById('datosNuevos.solicitud.cveAgente'),document.getElementById('datosOriginales.solicitud.cveAgente'),null);
         	}
                
         	function cambioCveTarifa(){
         		cambioCampo(document.getElementById('datosNuevos.solicitud.cveTarifa'),
						 document.getElementById('datosOriginales.solicitud.cveTarifa'),
						 document.getElementById('datosNuevos.solicitud.tarifa.descripcion'));
         	}
         	
         	function cambioCvePromotor(){
         		cambioCampo(document.getElementById('datosNuevos.solicitud.cvePromotor'),
						 document.getElementById('datosOriginales.solicitud.cvePromotor'),
						 null);
         	}
         	
         	function cambioCveGrupoAsegurado(){
         		cambioCampo(document.getElementById('datosNuevos.solicitud.empresa.cveGrupoAsegurado'),
						 document.getElementById('datosOriginales.solicitud.empresa.cveGrupoAsegurado'),
						 document.getElementById('datosNuevos.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado'));
         	}
         	
         	function cambioCveSucursal(){
         		cambioCampo(document.getElementById('datosNuevos.solicitud.empresa.cveSucursal'),
						 document.getElementById('datosOriginales.solicitud.empresa.cveSucursal'),
						 document.getElementById('datosNuevos.solicitud.empresa.sucursal.nombreSucursal'));
         	}
         	
         	function cambioCveColonia(){
         		cambioCampo(document.getElementById('datosNuevos.solicitud.empresa.cveColonia'),
						 document.getElementById('datosOriginales.solicitud.empresa.cveColonia'),
						 document.getElementById('datosNuevos.solicitud.empresa.colonia.asentamiento'));
         	}
         	function cambioCveEmpresa(){
         		cambioCampo(document.getElementById('datosNuevos.solicitud.cveEmpresa'),
						 document.getElementById('datosOriginales.solicitud.cveEmpresa'),
						 document.getElementById('datosNuevos.solicitud.empresa.nombreEmpresa'));
         	}
         	
         	function cambioTipoSeguro(){
         		cambioCampo(document.getElementById('datosNuevos.tipoSeguro'),
						 document.getElementById('datosOriginales.tipoSeguro'),
						 document.getElementById('datosNuevos.descripcionPaqueteVidadxn'));
         	}
         	
         	
         	function incializarPantalla(){

         		
         			//Nuevo ticket
         		
         			<c:forEach items="${command.datosOriginales.solicitud.beneficiario}"
                    				var="beneficiario" varStatus="varStatus" 
                    				>
         				
         				document.getElementById('beneficiarioNuevo_${varStatus.index}').style.display = 
         				document.getElementById('beneficiarioOriginal_${varStatus.index}').style.display;
         				if(document.getElementById("datosNuevos.solicitud.beneficiario[${varStatus.index}].porcentajeAsignado").value != "0" &&
         						document.getElementById("datosNuevos.solicitud.beneficiario[${varStatus.index}].porcentajeAsignado").value != "0.0"&&
         						document.getElementById("datosNuevos.solicitud.beneficiario[${varStatus.index}].porcentajeAsignado").value != ""){
         					document.getElementById('beneficiarioNuevo_${varStatus.index}').style.display = 'inline';
         				}
         			</c:forEach>
                    			
         		
         			<c:if  test="${command.ticket.idTicketCorreccion != null}">
    				 //consulta de ticket
    				 if(document.getElementById("btnGuardar")){
    					 document.getElementById("btnGuardar").value="Guardar Cambios";
    				 }
    				 if(document.getElementById("btnCancelar")){
    					 document.getElementById("btnCancelar").value="Cancelar";
    				 }
        				
        				
        				//activar eventos change de los objetos
        				
               			for(var i=0; i<document.w01.elements.length; i++)
						{
               				
							if(document.w01.elements[i].type=="text" || document.w01.elements[i].type=="select-one"
								|| document.w01.elements[i].type=="radio" || document.w01.elements[i].type=="hidden")
							{
								
								try{document.w01.elements[i].onchange();}catch(ex){}
								//si no se puede guardar ni aplicar ni rechazar, deshabilitar controles
								<c:if test="${!command.mostrarBotonGuardar && !command.mostrarBotonAplicarRechazar}">
									document.w01.elements[i].disabled = true;
									
            					</c:if>
            				
							}
						}

    				</c:if>
    				<c:if test="${command.mostrarBotonGuardar || command.mostrarBotonAplicarRechazar}">
	    				document.getElementById("usuarioAutoriza").style.display = 'none';
						document.getElementById("fechaAutorizacion").style.display = 'none';
						
					</c:if>
					<c:if test="${!command.mostrarBotonGuardar && !command.mostrarBotonAplicarRechazar}">
						document.getElementById("btnCancelar").value="Regresar";
					</c:if>
					
					//esconder mostrar secciones
					for(var i=0;i<secciones.length;i++){
						expandirContraer(secciones[i]);
						if(existeCambio[secciones[i]]){
							expandirContraer(secciones[i]);
						}
					}
		        		
					
					
				
         	}
         	
         	
         	function cancelar(){
         		<c:if  test="${command.ticket.idTicketCorreccion == null}">
     				//Nuevo ticket
	     		
	     			window.close();
                			
     			</c:if>
     			<c:if  test="${command.ticket.idTicketCorreccion != null}">
 				 //consulta de ticket
     		
     			window.location = '<c:url value='/app/consultarTicketsCorreccion'/>';
            			
 				</c:if>
     			
         	}
         	function borrar(nombreCampo,nombreCampo2){
         		campo1 = document.getElementById(nombreCampo);
         		
         		campo2 = document.getElementById(nombreCampo2?nombreCampo2:"");
         		
         		if(campo1){
         			campo1.value ="";
         			campo1.onchange();
         		}
         		if(campo2){
         			campo2.value ="";
         			campo2.onchage();
         		}
         		
         		
         		
         	}
         	function borrarCampo(campo,nombreCampoClave){
         		
         		if(campo.value == ""){
         			document.getElementById(nombreCampoClave).value="";
         			document.getElementById(nombreCampoClave).onchange();
         		}
         		
         	}
         	
         	
        </script>

        
        <title>Registrar Ticket de Correcci&oacute;n de Datos</title>
        
        <style type="text/css">
        	



        </style>
        
    </head>
        
    <body>
      	
      		 <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            <div ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;background-color:white;">
            </div>
            <tag:errors name="command"/>
            
            <form action="#" method="post" name="w01">
            <input type="hidden" name="_page0" value="0" />
            <spring:nestedPath path="command">
           						 <spring:bind path="existenPagosAplicados">
            		    			<input type="hidden"  value="${status.value}" 
                					id="${status.expression}" name="${status.expression}"/>
                				</spring:bind>
            	<table width="1328" cellpadding="0" cellspacing="0">
            		<tr>
            			<td>
            			
            				<div id="titleg664x16">Registrar Ticket de Correcci&oacute;n de Datos</div>
               
                <div class="row660">
                	<table cellpadding="0" cellspacing="2" width="100%" style="line-height:normal;">
                		<tr>
                			<td class="labelRow">
                				Usuario que solicita:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="ticket.usuarioSolicitante">
                					<input type="text" class="inputInfo" readonly value="${status.value}" 
                					id="${status.expression}" name="${status.expression}"/>
                				</spring:bind>
                				
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Motivo del Ticket:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="ticket.motivoSolicitud">
                					<textarea rows="4" cols="45" class="textarea"
                					id="${status.expression}" name="${status.expression}"
                					>${status.value}</textarea>
                				</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Estado del Ticket:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="ticket.estadoTicketCorreccion.descripcionEstadoTicketCorreccion">
                					<input type="text" value="${status.value}" class="inputInfo" readonly/>
                				</spring:bind>
                				<spring:bind path="ticket.idEstadoTicketCorreccion">
                					<input type="hidden" value="${status.value}" 
									id="${status.expression}" name="${status.expression}"
									/>
                				</spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha del Ticket:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="ticket.fechaSolicitud">
                					<input type="text"  class="inputInfo" readonly
                					value="${status.value}"
									
									/>
                				</spring:bind>
                			</td>
                		</tr>
                		<tr  id="usuarioAutoriza">
                			<td class="labelRow">
                				Usuario que Autoriza:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="ticket.usuarioAutoriza">
                					<input type="text"  class="inputInfo" readonly
                					value="${status.value}"
									
									/>
                				</spring:bind>
                			</td>
                		</tr>
                		<tr  id="fechaAutorizacion">
                			<td class="labelRow">
                				Fecha de Autorizaci&oacute;n:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="ticket.fechaAutorizacion">
                					<input type="text"  class="inputInfo" readonly
                					value="${status.value}"
									/>
                				</spring:bind>
                			</td>
                		</tr>
                		
                	</table>
                </div>
                <c:if test="${command.aseguradoInexistente }">
					<div class="row660" style="text-align: center;font-size: x-small; font-weight: bold;color: red">
	            		No existen datos registrados de Asegurado para esta P&oacute;liza Individual, se crear&aacute;n cuando se autorice el ticket.
	            	</div>
            	</c:if>
                <jsp:include page="01_datosSolicitud.jsp" />
                <jsp:include page="02_datosContratante.jsp" />
                <jsp:include page="03_datosEmpresa.jsp" />
                <jsp:include page="04_datosSolicitante.jsp" />
                <jsp:include page="05_datosBeneficiarios.jsp" />
                <jsp:include page="06_datosPoliza.jsp" />
                
                 <div class="row660" >
                	<table width="100%" cellpadding="2" cellspacing="2">
                		<tr>
                			<td colspan="3" class="labelRow" style="text-align: center">
       						
       							<table cellpadding="2" cellspacing="2">
       								<tr>
       									<td valign="top">
       										Comentarios extra:
       									</td>
       									<td>
       										<spring:bind path="comentarioNuevo">
       										<textarea rows="5" cols="65" class="textarea" name="${status.expression }"
       										id="${status.expression }"
       										></textarea>
       										</spring:bind>
       									</td>
       								</tr>
       							
       							</table>
       						</td>
       					</tr>
       				</table>
       			</div>
                	
                
                
                <div class="row660" >
                	<table width="100%" cellpadding="2" cellspacing="2">
                		<tr>
                			<td colspan="3" class="labelRow" style="text-align: center">
                				<c:if test="${command.mostrarBotonGuardar}">
                					<input type="button" value="Crear Ticket" class="input" onclick="javascript:guardar();" 
                					name="btnGuardar" id="btnGuardar"/>
                				</c:if>
                				
                				&nbsp; 
                				<c:if test="${command.mostrarBotonAplicarRechazar}">
                					<input type="button" value="Aplicar" class="input" onclick="javascript:guardarConEstado('<%=EstadoTicketCorreccion.APLICADO %>');"/>
                					<input type="button" value="Rechazar" class="input" onclick="javascript:guardarConEstado('<%=EstadoTicketCorreccion.RECHAZADO %>');"/> 
                					&nbsp;
                				</c:if>	
                				
                					<input type="button" value="Cancelar" class="input" id="btnCancelar"
                					onclick="javascript:cancelar();"
                					/>
                				
                			</td>
                		</tr>		
                	</table>
                
                
                </div>
                
                
                
                
                
                
            	
            			
            			
            			</td>
            			<td valign="top">
            			<c:if test="${not empty command.ticket.comentariosTicket}">
            				<div id="titleg664x16">Comentarios sobre el Ticket de Correcci&oacute;n</div>
               
	              				<div class="row660">
	                				<table cellpadding="3" cellspacing="2" width="100%" style="line-height:normal;">
	            						<c:forEach items="${command.ticket.comentariosTicket}"  var="comentario">
	            							<tr>
					                			<td class="labelRow" valign="top">
					                				<b>${comentario.usuario }</b>:<br/><fmt:formatDate value="${comentario.fecha }" pattern="dd/MM/yyyy hh:mm"/>
					                			</td>
					                			<td class="fieldRow" >
				                					${comentario.comentario}
			                					</td>
		                					</tr>
	            						</c:forEach>
	                					
	            					
	            					</table>
	            				</div>
            			</c:if>
            				
            				
            				
            			
            			</td>
            		</tr>
            	
            	</table>
            
                
               </spring:nestedPath>
            </form>
            
   <script language="JavaScript" type="text/javascript">
		incializarPantalla();
	</script>
    </body>
    
</html>
