<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="mx.com.seguros.web.reportes.GenerarReportesPolizaController"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="org.acegisecurity.GrantedAuthority"%>
<%@page import="org.acegisecurity.context.SecurityContextHolder"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Detalle de la Solicitud de Seguro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/calendario.js" />">
        </script>
        <script type="text/javascript" src="<c:url value="/js/jquery-1.5.1.js"/>"></script>
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
        <script type="text/javascript">
        	function modificarSolicitud(){
        		window.location = 
        		'<c:url value="/app/capturaSolicitudController?folioSolicitud=${poliza.solicitud.folioSolicitud}&formatoSolicitud=${poliza.solicitud.formatoSolicitud}&idRegistro=0&numPoliza=${poliza.numPoliza}&numConsignatario=${poliza.numConsignatario}"/>';
             	}
        	function tramites(){
        		window.location = 
            		'<c:url value="/app/listadoTramitesPolizaController?numPoliza=${poliza.numPoliza}&numConsignatario=${poliza.numConsignatario}"/>';
                 	
        	}
        </script>
        <script language="JavaScript" type="text/javascript">
           function validaEstatusPoliza(){
            var param=document.w01.idEstatusPagosPolizaFrm.value;
           // alert(param);
                if(param >1){
                alert("A continuación de clic en el boton 'Generar Reporte Desc.' ");
                
	                w01.val.type="hidden";
	                w01.desc.type="submit";
	                w01.val.disabled=true;
                }else{
                	alert("La póliza no cuenta aún con descuentos aplicados");
                }
            }
			
           function registrarTicket(){
        		numPoliza = document.getElementById("numPolizaFrm").value;
        		
        		if(numPoliza != ""){
        			 document.location.href = '<c:url value="/app/registrarTicketCorreccion?numPoliza=${poliza.numPoliza}&numConsignatario=${poliza.numConsignatario}&folioSolicitud=${poliza.solicitud.folioSolicitud}&formatoSolicitud=${poliza.solicitud.formatoSolicitud}"/>';
        		}else{
        			alert("La solicitud todavía no cuenta con póliza");
        		}
        	  
           }
           
           function  mostrarTarifas(campoRef){
        	   tarifas =document.getElementById("historialTarifas");
        	   if( tarifas.style.visibility == 'visible'){
        		   tarifas.style.visibility = 'hidden';
        		   return;
        	   }
        	   
        	   
        	   
        	   tarifas.style.left = (getDimensions(campoRef).x+25) + "px";
        	   tarifas.style.top = getDimensions(campoRef).y + "px";
        	   tarifas.style.visibility = 'visible';
           }
           
           function ocultarTarifas(){
        	   document.getElementById("historialTarifas").style.visibility = 'hidden';
           }
           getDimensions = function(oElement) {
        	    var x, y, w, h;
        	    x = y = w = h = 0;
        	    if (document.getBoxObjectFor) { // Mozilla
        	      var oBox = document.getBoxObjectFor(oElement);
        	      x = oBox.x-1;
        	      w = oBox.width;
        	      y = oBox.y-1;
        	      h = oBox.height;
        	    }
        	    else if (oElement.getBoundingClientRect) { // IE
        	      var oRect = oElement.getBoundingClientRect();
        	      x = oRect.left-2;
        	      w = oElement.clientWidth;
        	      y = oRect.top-2;
        	      h = oElement.clientHeight;
        	    }
        	    return {x: x, y: y, w: w, h: h};
        	 }

           
           function abrirPopUpReporte(tipoReporte){

           	numPoliza = document.getElementById("numPolizaFrm").value;
           	numCertificado = document.getElementById("numCertificadoFrm").value;
           	cvePlaza = document.getElementById("cvePlazaFrm").value;
           	folioSolicitud = document.getElementById("folioSolicitudFrm").value;
           	formatoSolicitud = document.getElementById("formatoSolicitudFrm").value;
           	
               urlBase     = '<c:url value="/app/generarReportesPolizaController"/>';
               propiedades = 'width='+700+',height='+800+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes';
               params = 'numPoliza='+numPoliza+'&numCertificado='+numCertificado+'&cvePlaza='+cvePlaza+'&tipoReporte='+tipoReporte+
               '&folioSolicitud='+folioSolicitud+"&formatoSolicitud="+formatoSolicitud;
               url    = urlBase + '?' + params;
              
               vent   = window.open(url, "detalle", propiedades);
               isOpen = true;
           }
           
           function generarCarta(){
           	abrirPopUpReporte('<%= GenerarReportesPolizaController.CARTA_RESUMEN %>');
           }
           
           function generarAcuse(){
           	abrirPopUpReporte('<%= GenerarReportesPolizaController.ACUSE_RECIBO %>');
           }
           
           function generarCertificado(){
        	   abrirPopUpReporte('<%= GenerarReportesPolizaController.CERTIFICADO_INDIVIDUAL %>');
           }
           
           
           function guardarEstatus(){
        	   
        	   if(confirm("¿Está seguro que desea actualizar los datos de la póliza?'")){
        		   document.w01.actualizarEstados.value = "true";
            	   document.w01._finish.disabled = true;
        		   document.w01.submit();
        	   }
        	   
        	
           }

        </script>
    </head>
    <body>
    
    <%GrantedAuthority rol[] = SecurityContextHolder.getContext().getAuthentication().getAuthorities();%>
		                        <%System.out.println("ROLES__"+rol[0].getAuthority().toString()); %>
		                        <%if(rol[0].getAuthority().toString().equals("ROL_VENTAS") || rol[0].getAuthority().toString().equals("rol_ventas")
		                        	|| rol[0].getAuthority().toString().equals("ROL_CONSULTA_ESPECIAL") || rol[0].getAuthority().toString().equals("rol_consulta_especial")) {%>
		                        	<script language="JavaScript" type="text/javascript">
										document.getElementById("img").setAttribute("href","#");
										document.getElementById("img").oncontextmenu=new Function("return false");
									</script>
									<script language="JavaScript" type="text/javascript"
							                src="<c:url value="/js/disableCopyPaste.js"/>">
							        </script>
		                        	<!--  input type="text" name="id" value ="si"/-->
		                        <%}else{%>
		                        	<!--input type="text" name="id" value ="no"/-->
		                        <%} %>
    
    <spring:nestedPath path="poliza">
    
   
    <jsp:include page="../util/infoSumaTotal.jsp"></jsp:include>
    
    
    
    <div id="historialTarifas"  style="visibility:hidden;z-index: 900;position:fixed;background-color: #FFFFFF;" >
    	<table cellpadding="0" cellspacing="2" width="310px" style="line-height:normal;" >
    		<tr>
    			<td class="ContenTablaColor">
    				Tarifa anterior
    			</td>
    			<td class="ContenTablaColor">
    				Modificda por
    			</td>
    			<td class="ContenTablaColor">
    				Fecha
    			</td>
    		</tr>
    		<c:forEach items="${historicoTarifas}" var="historico">
    		<tr>
    			<td class="ContenTabla">
    				<c:out value="${historico.tarifa.descripcion}" />
    			</td>
    			<td class="ContenTabla">
    				${historico.usuario}
    			</td>
    			<td class="ContenTabla">
    				<fmt:formatDate value="${historico.fechaFin}"  pattern="dd/MM/yyyy hh:mm"/>
    			</td>
    			
    		</tr>
    		</c:forEach>
    		<c:if test="${empty historicoTarifas }">
    			<tr>
	    			<td class="ContenTabla" colspan="3" style="text-align: center">
	    				No existe informaci&oacute;n hist&oacute;rica de tarifas.
	    			</td>
    			</tr>
    		</c:if>
    	</table>
    </div>
    
     <form action="#" method="post" name="w01">            
                <input type="hidden" name="_page0" value="0" />
        <div class="row660" align="center">&nbsp;</div>
            <div id="titleg664x16">Resultados de consulta</div>
            
            <div class="row660">
                <input type="hidden" name="importePrimaInd" id="importePrimaIndFrm" />
               
                <label class="label330">Folio de la solicitud:&nbsp;&nbsp;</label>
                <span class="field330">
                   
                        <input type="text" name="folioSolicitudFrm" id="folioSolicitudFrm" value="${poliza.solicitud.folioSolicitud}" readonly class="input"/>
                   
                </span>
            </div>
            <div class="row660">
                <label class="label330">N&uacute;mero de Formato:&nbsp;&nbsp;</label>
                <span class="field330">
                   
                        <input type="text" name="formatoSolicitudFrm" id="formatoSolicitudFrm" value="${poliza.solicitud.formatoSolicitud}" readonly class="input"/>
                   
                </span>
            </div>
            <div class="row660">
                <label class="label330">Estatus de solicitud:&nbsp;&nbsp;</label>
                <span class="field330">
                    <!--spring:bind path="solicitud.estatussolicitud.descripcionEstatusSolicitud"-->
                    <input type="text" name="descripcionEstatusSolicitud" id="descripcionEstatusSolicitudFrm" value="${poliza.solicitud.estatusSolicitud.descripcionEstatusSolicitud}" readonly class="input" />
                    <!--/spring:bind-->
                   
                </span>

            </div>
            <div class="row660" align="center">&nbsp;</div>
            <div id="titleg664x16">Contratante</div>
            <div class="row660">
                <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="apPaternoContratante" value="${poliza.solicitud.contratante.apMaternoContratante}" id="apPaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="apMaternoContratante" value="${poliza.solicitud.contratante.apPaternoContratante}"  id="apMaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
            </div>
            <div class="row660">
            <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
            <span class="field195">
                <input type="text" name="nombre1Contratante" value="${poliza.solicitud.contratante.nombre1Contratante}"  id="nombre1ContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
            </span>
            <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
            <span class="field195">
                <input type="text" name="nombre2Contratante" value="${poliza.solicitud.contratante.nombre2Contratante}"  id="nombre2ContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
            </span>
            </div>
            <div class="row660">
                <label class="label330">No. de empleado:&nbsp;&nbsp;</label>
                <span class="field330">
                    <spring:bind path="solicitud.contratante.numNominaContratante">
                        <input type="text" name="${status.expression}"  id="numNominaContratanteFrm" readonly value="${poliza.solicitud.contratante.numNominaContratante}" class="input"/>
                    </spring:bind>
                </span>
            </div>
            <div class="row660">
                <label class="label330">Tiene Seguro Auto:&nbsp;&nbsp;</label>
                <span class="field330">
                    <spring:bind path="solicitud.contratante.tieneAuto">
                        <input type="text" name="${status.expression}"  id="numNominaContratanteFrm" readonly value="${poliza.solicitud.contratante.tieneAuto != null && poliza.solicitud.contratante.tieneAuto ?"SI" :"NO"}" class="input"/>
                    </spring:bind>
                </span>
            </div>
            <div class="row660" align="center">&nbsp;</div>
            <div id="titleg664x16">Solicitante</div>
            <div class="row660">
                <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>
                <span class="field195">
                  
                        <input type="text" name="apPaternoSolicitanteFrm" id="apPaternoSolicitanteFrm" readonly value="${poliza.solicitud.solicitante.apPaternoSolicitante}" class="input" />
                    
                </span>
                <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="apMaternoSolicitanteFrm" id="apMaternoSolicitanteFrm" readonly value="${poliza.solicitud.solicitante.apMaternoSolicitante}" class="input" />
                </span>
            </div>
            <div class="row660">
                <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                <span class="field195">
                    
                        <input type="text" name="nombre1SolicitanteFrm" id="nombre1SolicitanteFrm" readonly value="${poliza.solicitud.solicitante.nombre1Solicitante}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    
                </span>
                <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                <span class="field195">
                    
                        <input type="text" name="nombre2SolicitanteFrm"  id="nombre2SolicitanteFrm" readonly value="${poliza.solicitud.solicitante.nombre2Solicitante}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    
                </span>
            </div>
            <div class="row660">
                <label class="label135">RFC:&nbsp;&nbsp;</label>
                <span class="field195">
                    
                        <input type="text" name="RFCsolicitanteFrm" id="RFCsolicitanteFrm" readonly value="${poliza.solicitud.solicitante.RFCsolicitante}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                   
                </span>
                <label class="label135">Fecha nacimiento:&nbsp;&nbsp;</label>
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.fechaNacimientoSolicitante">
                        <input type="text" name="fechaNacimientoSolicitanteFrm"  id="fechaNacimientoSolicitanteFrm"
                               readonly value="<fmt:formatDate value="${poliza.solicitud.solicitante.fechaNacimientoSolicitante}" pattern="dd/MM/yyyy"/>" class="input" />
                    </spring:bind>
                </span>
            </div>
            
            
            <div class="row660" align="center">&nbsp;</div>
            <div id="title589x16">Domicilio del Solicitante</div>
            <div class="row592">
                <label class="label195x21">Calle:&nbsp;&nbsp;</label>
                <label class="label195x21">Edificio:&nbsp;&nbsp;</label>
                <label class="label195x21">No. ext./ No. int.:&nbsp;&nbsp;</label>
            </div>
            <div class="row592">
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.calle">
                        <input type="text" name="${status.expression}" id="calleFrm" readonly value="${poliza.solicitud.solicitante.calle}" class="input" size="28" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </spring:bind>
                </span>
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.edificio">
                        <input type="text" name="${status.expression}" id="edificioFrm" readonly value="${poliza.solicitud.solicitante.edificio}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </spring:bind>
                </span>

                <span class="field195">
                    <spring:bind path="solicitud.solicitante.numExtInt">
                        <input type="text" name="${status.expression}" id="numExtIntFrm" readonly value="${poliza.solicitud.solicitante.numExtInt}" class="input"/>
                    </spring:bind>
                </span>
            </div>
            <div class="row592">
                <label class="label195x21">Colonia/Fraccionamiento:&nbsp;&nbsp;</label>
                <label class="label195x21">&nbsp;</label>
                <label class="label195x21">C&oacute;digo Postal:&nbsp;&nbsp;</label>
            </div>
            <div class="row660">
                <span class="field296">
                    <spring:bind path="solicitud.solicitante.colonia">
                        <input type="text" name="${status.expression}" id="coloniaFrm"  size="40" readonly value="${poliza.solicitud.solicitante.colonia}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </spring:bind>
                </span>
                <label class="label97x31">&nbsp;</label>
                <!--span class="field195">&nbsp;&nbsp;</span-->
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.codPostal">
                        <input type="text" name="${status.expression}" id="codPostalFrm" readonly value="${poliza.solicitud.solicitante.codPostal}" class="input"/>
                    </spring:bind>
                </span>
            </div>
            <div class="row592">
                <label class="label195x21">Delegaci&oacute;n/Municipio:&nbsp;&nbsp;</label>
                <label class="label195x21">Ciudad/Poblaci&oacute;n:&nbsp;&nbsp;</label>
                <label class="label195x21">Entidad Federativa:&nbsp;&nbsp;</label>
            </div>
            <div class="row592">
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.delegacionMpio">
                        <input type="text" name="${status.expression}" id="delegacionMpioFrm" readonly value="${poliza.solicitud.solicitante.delegacionMpio}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </spring:bind>
                </span>
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.ciudadPoblacion">
                        <input type="text" name="${status.expression}" id="ciudadPoblacionFrm" readonly value="${poliza.solicitud.solicitante.ciudadPoblacion}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </spring:bind>
                </span>
                <span class="field195">
                    <spring:bind path="solicitud.solicitante.entidadFederativa">
                        <input type="text" name="${status.expression}" id="entidadFederativaFrm" readonly value="${poliza.solicitud.solicitante.entidadFederativa}" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </spring:bind>
                </span>
            </div>
            <div class="row660" align="center">&nbsp;</div>

            <div id="titleg664x16">Escuela</div>
            <div class="row660">
            <label class="label135">Escuela:&nbsp;&nbsp;</label>
            <span class="field195">
            	 <input type="text"
                       value="${poliza.solicitud.empresa.nombreEmpresa}"
                       title="${poliza.solicitud.empresa.nombreEmpresa}"
                       name="nombreEmpresa" id="nombreEmpresaFrm" size="50" readonly class="input" 
                       onChange="javascript:this.value=this.value.toUpperCase();"/>
           		                 
                </span>
                <label class="label135">Colonia:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="colonia"
                           value="${poliza.solicitud.empresa.colonia.asentamiento}"
                           title="${poliza.solicitud.empresa.colonia.asentamiento}"
                           id="coloniaFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                <label class="label135">Municipio o Delegaci&oacute;n:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="nombreSucursal"
                           value="${poliza.solicitud.empresa.sucursal.nombreSucursal}"
                           id="nombreSucursalFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                <label class="label135">Grupo:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="nombreGrupoAsegurado"
                           value="${poliza.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado}"
                            title="${poliza.solicitud.empresa.grupoAsegurado.nombreGrupoAsegurado}"
                           id="nombreGrupoAseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                
            </div>
            

            <div class="row660" align="center">&nbsp;</div>
			<div id="titleg664x16" >P&oacute;liza individual</div>
                <div class="row660">
                    
                    <label class="label135">N&uacute;mero:&nbsp;&nbsp;</label>
                    <span class="field195">
                       
                            <input type="text" name="poliza.numPoliza"  id="numPolizaFrm" value="${poliza.numPoliza}" readonly class="input"/>    
                        
                        
                    </span>                    
                        
                    <label class="label135">Emisor:&nbsp;&nbsp;</label>
                    <span class="field195">    
                        
                            <input type="text" name="poliza.numConsignatario"  id="numConsignatarioFrm" value="${poliza.numConsignatario}" readonly class="input"/>    
                    
                    
                     </span> 
                                        
                    <label class="label135">Certificado individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="poliza.solicitud.asegurado.numCertificadoIndividual"-->
                        <input type="text" name="cvePlaza" id="cvePlazaFrm" value="${poliza.cvePlaza}" size="4" readonly class="input"/>
                        <input type="text" name="numCertificado" value="${poliza.solicitud.certificadoindividual.numCertificado}" id="numCertificadoFrm" size="7" readonly class="input"/>
                        <!--/spring:bind-->
                    </span>
                    
                    <label class="label135">Tipo de Seguro:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="tipoSeguro" value="${poliza.descripcionTipoSeguro}${poliza.descripcionPaqueteVidadxn}"  id="tipoSeguroFrm" readonly class="input"/>    
                    </span>
                    <label class="label135">Imp de Tarifa.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importeTarifa" 
                        value="<c:out  value='${poliza.solicitud.tarifa.descripcion}'  />" id="importeTarifaFrm"  readonly class="input"/>
                       <a href="javascript:void();">
                       <img title="Ver historial de tarifas" src='<c:url value="/img/skin/onebit_39.png"/>' border="0"
                        	onclick="javascript:mostrarTarifas(this);"
                        	width="20"
                        	/>
                       
                       </a>
                        	
                       
                    </span>
                    
                    <label class="label135">Imp prima indiv.:&nbsp;&nbsp;</label>
                    
                    <span class="field195">
                        <input type="text" name="importePrimaInd" value="<c:out  value='${poliza.solicitud.tarifa.importePrimaInd}'  />" id="importePrimaIndFrm"  readonly class="input"/>
                    </span> 
                    <label class="label135">Imp prima colect.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importePrimaColectiva" 
                        value="<c:out value='${poliza.solicitud.tarifa.importePrimaColectiva}'/>"
                        id="importePrimaColectivaFrm"  readonly class="input"/>
                    </span>
                    <label class="label135">Suma asg individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="sumaAseguradaIndividual" 
                        value="<c:out value='${poliza.sumaAseguradaIndividual}'/>"
                        id="sumaAseguradaIndividualFrm"  readonly class="input" />
                    </span>
                    <label class="label135">Suma asg colectiva:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text"  name="sumaAseguradaColectiva" 
                        value="<c:out value='${poliza.solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva}'/>"
                        id="sumaAseguradaColectivaFrm"  readonly class="input" />
                    </span>
                    
                    <label class="label135">Ahorro Mensual Adicional:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importeAhorroAdicionalMensual" 
                        value="<c:out value='${poliza.importeAhorroAdicionalMensual}'/>"
                        id="importeAhorroAdicionalMensualFrm"  readonly class="input" />
                    </span>
                 
                    
                    <label class="label330" >Total de protecci&oacute;n:&nbsp;&nbsp;</label>
                    <span class="field330">
                         <input type="text" name="txtCampo" value="<fmt:formatNumber value="${poliza.sumaAseguradaTotal}" pattern="#,##0"/>" 
                         id="totalProteccionFrm"
                         MAXLENGTH="16" class="input" readonly/>
                       <!--input type="text" name="totalProteccion" id="totalProteccionFrm"   class="input"/-->
                       <a href="javascript:void();">
	                       <img title="Ver Detalle del C&aacute;lculo" src='<c:url value="/img/skin/onebit_39.png"/>' border="0"
	                        	onclick="javascript:mostrarCalculo(this);"
	                        	width="20"
	                        	/>
                       </a>
                        
                    </span>
                    
                    <label class="label330">Estatus General:&nbsp;&nbsp;</label>
                    <span class="field330">
                    
                    	<form:select  cssClass="input" path="idEstatusPolizaGeneral" items="${listaEstatusPolizaGeneral}" itemLabel="descripcion" 
                    	itemValue="idEstatusPolizaGeneral" disabled="true"></form:select>
                    
                        <!--input type="text" name="descripcionEstatusPoliza" 
                        size="40" id="descripcionEstatusPolizaFrm" readonly 
                        value="${poliza.estatusPolizaSeguimiento.descripcionEstatusPoliza}"
                        class="input"/-->
                    </span>
                    <label class="label330">Estatus de seguimiento:&nbsp;&nbsp;</label>
                    <span class="field330">
                    
                    	<form:select  cssClass="input" path="idEstatusPolizaSeguimiento" items="${listaEstatusPolizaSeguimiento}" itemLabel="descripcionEstatusPoliza" 
                    	itemValue="idEstatusPolizaSeguimiento" disabled="${!puedeModificarEstatus}"></form:select>
                    
                        <!--input type="text" name="descripcionEstatusPoliza" 
                        size="40" id="descripcionEstatusPolizaFrm" readonly 
                        value="${poliza.estatusPolizaSeguimiento.descripcionEstatusPoliza}"
                        class="input"/-->
                    </span>
                    <label class="label330">Estatus en pagos:&nbsp;&nbsp;</label>
                    <span class="field330">
                    
                    	<form:select  id="idEstatusPagosPolizaFrm"  cssClass="input" path="idEstatusPagosPoliza" items="${listaEstatusPolizaPagos}" itemLabel="descripcionEstatusPagosPoliza" 
                    	itemValue="idEstatusPagosPoliza" disabled="${!puedeModificarEstatus}"></form:select>
                    
                        <!--input type="hidden" name="idEstatusPagosPolizaFrm"  id="idEstatusPagosPolizaFrm"
                        value="${poliza.idEstatusPagosPoliza}"
                         /  -->
                        <!-- input type="text" name="descripcionEstatusPagosPoliza" size="40" id="descripcionEstatusPagosPolizaFrm" 
                        value="${poliza.estatusPolizaPagos.descripcionEstatusPagosPoliza}"
                        readonly class="input"/-->
                    </span>
                    
                    <label class="label330">Fecha de Tr&aacute;mite de Cancelaci&oacute;n:&nbsp;&nbsp;</label>
                    <span class="field330">
                    <spring:bind path="fechaSolicitudCancelacion">
                    			<div ID="divFechaSolicitudCancelacion"
	                               STYLE="position:absolute;visibility:hidden;background-color:white;">
	                            </div>
                    			<script language="JavaScript" type="text/javascript">
	                                var calFechaSolicitudCancelacion = new CalendarPopup("divFechaSolicitudCancelacion");
	                                calFechaSolicitudCancelacion.setCssPrefix("TEST");
	                            </script>
		                        <input type="text" name="${status.expression}" id="${status.expression}"
		                        value="<fmt:formatDate pattern="dd/MM/yyyy" value="${status.value}" />"  ${puedeModificarEstatus?"":"readonly"} class="input"/>
                        
			                     <c:if test="${puedeModificarEstatus}">
			                     	<A HREF="#" onClick="calFechaSolicitudCancelacion.select(document.forms[0].${status.expression},'anchorFechaSolicitudCancelacion','dd/MM/yyyy'); return false;"
				                              TITLE="calFechaSolicitudCancelacion.select(document.forms[0].${status.expression}},'anchorFechaSolicitudCancelacion','dd/MM/yyyy'); return false;"
				                              NAME="anchorFechaSolicitudCancelacion" ID="anchorFechaSolicitudCancelacion" TABINDEX="11">
				                               <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
				                            </A>
			                     </c:if>
                      </spring:bind>  
                        
                    </span>
                    <label class="label330">Fecha de Cancelaci&oacute;n de Descuento:&nbsp;&nbsp;</label>
                    <span class="field330">
                    	<spring:bind path="fechaCancelacionDescuento">
                    	<div ID="div${status.expression}"
	                               STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
	                        <script language="JavaScript" type="text/javascript">
	                                var cal${status.expression} = new CalendarPopup("div${status.expression}");
	                                cal${status.expression}.setCssPrefix("TEST");
	                        </script>
	                        <input type="text" name="${status.expression}" id="${status.expression}"
		                        value="<fmt:formatDate pattern="dd/MM/yyyy" value="${status.value}" />"  ${puedeModificarEstatus?"":"readonly"} class="input"/>
		                         <c:if test="${puedeModificarEstatus}">
			                     	<A HREF="#" onClick="cal${status.expression}.select(document.forms[0].${status.expression},'anchor${status.expression}','dd/MM/yyyy'); return false;"
				                              TITLE="cal${status.expression}.select(document.forms[0].${status.expression}},'anchor${status.expression}','dd/MM/yyyy'); return false;"
				                              NAME="anchor${status.expression}" ID="anchor${status.expression}" TABINDEX="12">
				                               <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
				                            </A>
			                     </c:if>
                    	</spring:bind>
                    </span>
                    
                    <label class="label330">Quincena &Uacute;ltimo Descuento:&nbsp;&nbsp;</label>
                    <span class="field330">
                    <spring:bind path="numQuincenaUltimoDescuento">
                    	 <input type="text" name="${status.expression}" id="${status.expression}"
		                        value="${status.value}" ${puedeModificarEstatus?"":"readonly"} class="input"/>
		            </spring:bind>           
                    </span>
                    
                    
                    <label class="label330">A&ntilde;o &Uacute;ltimo Descuento:&nbsp;&nbsp;</label>
                    <span class="field330">
                    <spring:bind path="anhoUltimoDescuento">
                    	 <input type="text" name="${status.expression}" id="${status.expression}"
		                        value="${status.value}" ${puedeModificarEstatus?"":"readonly"} class="input"/>
		            </spring:bind>           
                    </span>
         
                    
                    
                    
                    <c:if test="${puedeModificarEstatus}">
                    <label class="label330">&nbsp;&nbsp;</label>
                    <span class="field330">
                        <input type="button" value="Guardar Informaci&oacute;n" class="input" onclick="guardarEstatus();"/>
                        <input type="hidden" name="actualizarEstados" id="actualizarEstados" value="">
                    </span>
                     </c:if>
                    <div class="row660" align="center">&nbsp;</div>
               	 <div id="titleg664x16">Agente</div>
                    <div class="row660">
                        <div align="center" class="submit664">                       
                            <input type="text" name="cveAgente" id="cveAgenteFrm" size="5" readonly
                            value="${poliza.solicitud.agente.cveAgente}"
                             class="input"/>
                            <input type="text" align="center" name="apPaternoEmpleado" id="apPaternoEmpleadoFrm" 
                            value="${poliza.solicitud.agente.empleado.apPaternoEmpleado}"
                            size="15" readonly class="input" />
                            <input type="text" align="center" name="apMaternoEmpleado" id="apMaternoEmpleadoFrm"  
                            value="${poliza.solicitud.agente.empleado.apMaternoEmpleado}"
                            size="15" readonly class="input"/>
                            <input align="center" type="text" name="nombre1Empleado" id="nombre1EmpleadoFrm" 
                            value="${poliza.solicitud.agente.empleado.nombre1Empleado}"
                            size="15" readonly class="input"/>
                            <input type="text" align="center" name="nombre2Empleado" id="nombre2EmpleadoFrm" 
                            value="${poliza.solicitud.agente.empleado.nombre2Empleado}"
                            size="15" readonly class="input"/>
                        </div>
                    </div>
                    
                    <div class="row660" align="center">&nbsp;</div>
                    <div id="titleg664x16">Agente Inbursa</div>
                     	
		                <label class="label135">Clave Promotor:&nbsp;&nbsp;</label>
		                <span class="field195">
		                    <!--spring:bind path="poliza.solicitud.asegurado.fechaExpedicion"-->
		                    <input type="text"  name="cvePromotorForm" id="cvePromotorForm" 
		                    value="<c:out value="${poliza.solicitud.cvePromotor}" />"
		                    readonly class="input"/>
		                    <!--/spring:bind-->
		                </span>
		                <label class="label135">Clave Agente Inbursa:&nbsp;&nbsp;</label>
		                <span class="field195">
		                    <!--spring:bind path="poliza.solicitud.asegurado.fechaExpedicion"-->
		                    <input type="text"  name="fechaExpedicion" id="fechaExpedicionFrm" 
		                    value="<c:out value="${poliza.solicitud.cveAgenteInbursa}" />"
		                    readonly class="input"/>
		                    <!--/spring:bind-->
		                </span>
                    <div class="row660">
		                <label class="label135">Porcentaje Promotor:&nbsp;</label>
		                <span class="field195">
		                    <input type="text"  name="porcentajePromotor" id="porcentajePromotorFrm" readonly
		                    value="<c:out value="${poliza.solicitud.porcentajeComisionPromotor}" />"
		                    class="input"/>
		                </span>
		                <label class="label135">Porcentaje Agente :&nbsp;</label>
		                <span class="field195">
		                    <input type="text"  name="fechaFinVigencia" id="fechaFinVigenciaFrm" 
		                    value="<c:out value="${poliza.solicitud.porcentajeComisionAgenteInbursa}" />"
		                    readonly class="input"/>
		                </span>
                	</div>
                    
                    
                </div>  
                <div class="row660" align="left">&nbsp;</div>
                <div id="titleg664x16">Vigencia</div>
                <div class="row660">
                <label class="label135">Fecha Inicio:&nbsp;&nbsp;</label>
                <span class="field195">
                    <!--spring:bind path="poliza.solicitud.asegurado.fechaInicioVigencia"-->
                    <input type="text"  name="fechaInicioVigencia" id="fechaInicioVigenciaFrm" readonly
                    value="<fmt:formatDate pattern="dd/MM/yyyy" value="${poliza.fechaInicioVigencia}" />"
                    class="input"/>
                    <!--/spring:bind--> 
                </span>
                <label class="label135">Fecha Fin:&nbsp;&nbsp;</label>
                <span class="field195">
                    <!--spring:bind path="poliza.solicitud.asegurado.fechaFinVigencia"-->
                    <input type="text"  name="fechaFinVigencia" id="fechaFinVigenciaFrm" 
                    value="<fmt:formatDate pattern="dd/MM/yyyy" value="${poliza.fechaFinVigencia}" />"
                    readonly class="input"/>
                    <!--/spring:bind-->
                </span>
                <label class="label330">Fecha Expedici&oacute;n:&nbsp;&nbsp;</label>
                <span class="field330">
                    <!--spring:bind path="poliza.solicitud.asegurado.fechaExpedicion"-->
                    <input type="text"  name="fechaExpedicion" id="fechaExpedicionFrm" 
                    value="<fmt:formatDate pattern="dd/MM/yyyy" value="${poliza.fechaExpedicion}" />"
                    readonly class="input"/>
                    <!--/spring:bind-->
                </span>
                </div>
                <div class="row660" align="left">&nbsp;</div>
                                  
                <br/>
                <div class="row660">
                	<table width="100%">
                	<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Tr&aacute;mites de la P&oacute;liza</strong></td>
                        </tr>
                        <c:if test="${empty listaTramites}">
                        <tr>
                        	<td class="fieldRow" colspan="4" align="center" style="text-align: center">
								<strong>No existen tr&aacute;mites asociados a esta p&oacute;liza</strong>
                        	</td>
                        </tr>
                        </c:if>
                        <c:if test="${not empty listaTramites}">
	                        <tr>
	                        	<td  colspan="4" >
									<table width="100%" cellpadding="0" cellspacing="2">
										<tr>
											<td class="ContenTablaColor">
												Fecha del Tr&aacute;mite
											</td>
											<td class="ContenTablaColor">
												Tr&aacute;mite Solicitado
											</td>
											<td class="ContenTablaColor">
												Tr&aacute;mite Final
											</td>
											<td class="ContenTablaColor">
												Sucursal
											</td>
											<td class="ContenTablaColor">
												Usuario
											</td>
											<td class="ContenTablaColor">
												Tel&eacute;fono
											</td>
										<tr/>
								<c:forEach items="${listaTramites}" var="tramite" >
										<tr>
											<td class="ContenTabla">
												<fmt:formatDate value="${tramite.fecha}" pattern="dd/MM/yyyy"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.tipoTramiteInicial.nombre}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.tipoTramiteFinal.nombre}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.oficina.nombre}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.usuario}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.telefono}"/>
											</td>
										</tr>
										<tr>
											<td class="ContenTabla" colspan="6">
												Comentarios Asegurado:
											
												<c:out value="${tramite.comentariosAsegurado}"></c:out>
											</td>
										</tr>
										<tr>
											<td class="ContenTabla" colspan="6">
												Comentarios Asesor:
											
												<c:out value="${tramite.comentariosAsesor}"></c:out>
											</td>
										</tr>
										<tr>
											<td class="ContenTabla"colspan="6">
												Observaciones:
											
												<c:out value="${tramite.observaciones}"></c:out>
											</td>
										</tr>
										<tr>
											<td colspan="6" style="background-color: white;height: 3px"></td>
										</tr>
								</c:forEach>		
									</table>
	                        	</td>
	                        </tr>
                        </c:if>
                     </table>
                </div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Beneficios Adicionales</div>
                <c:forEach var="beneficio" items="${poliza.beneficiosAdicionales}">
	                <div class="row660">
	                		<label class="label330">${beneficio.descripcionBeneficio}:&nbsp;&nbsp;</label>
	                		<span class="field330">
	                   
	                        	<fmt:formatNumber pattern="$ #,##0.00" value="${beneficio.sumaBeneficio}">
	                        	
	                        	</fmt:formatNumber>
	                   
	                		</span>
	                
	                </div>
            	</c:forEach>
            	<div id="titleg664x16" >Productos Adicionales de Inburnomina Integral</div>
                <table cellpadding="0" cellspacing="2" width="664">
                	<tr>
                		<td class="labelRow"  width="25%" rowspan="5">
                				<img src="<c:url value='/img/rclicencia.png'/>" border="0"/>
                		</td>
                		<td class="fieldRow"  width="25%" rowspan="5">
                			<form:radiobutton path="productosInburnomina.indRcLicencia" value="true" disabled="true"/> Si 
							<form:radiobutton path="productosInburnomina.indRcLicencia" value="false" disabled="true"/> No
                		</td>
                		<td class="labelRow"  width="25%">
                			N&uacute;mero de Licencia:&nbsp;
                		</td>
                		<td class="fieldRow"  width="25%">
                			<spring:bind path="productosInburnomina.numLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Prima Mensual:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.primaMensualLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			N&uacute;mero de P&oacute;liza:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.numPolizaRcLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Emisor:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.numConsignatarioRcLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Fecha Vigencia:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.fechaVigenciaRcLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" rowspan="4" >
                			<img src="<c:url value='/img/inburmedic.png'/>" border="0" />
                		</td>
                		<td class="fieldRow" rowspan="4">
	                		<form:radiobutton path="productosInburnomina.indInburmedic" value="true" disabled="true"/> Si 
							<form:radiobutton path="productosInburnomina.indInburmedic" value="false" disabled="true"/> No
                		</td>
                		<td class="labelRow" >
                			Prima Mensual:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.primaMensualInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			N&uacute;mero de P&oacute;liza:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.numPolizaInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Emisor:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.numConsignatarioInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Fecha Vigencia:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.fechaVigenciaInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" rowspan="4">
                				<img src="<c:url value='/img/segucancer.png'/>" border="0"/>
                		</td>
                		<td class="fieldRow" rowspan="4">
                			<form:radiobutton path="productosInburnomina.indSeguCancer" value="true" disabled="true"/> Si 
							<form:radiobutton path="productosInburnomina.indSeguCancer" value="false" disabled="true"/> No
                		</td>
                		<td class="labelRow" >
                			Prima Mensual:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.primaMensualSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			N&uacute;mero de P&oacute;liza:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.numPolizaSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Emisor:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.numConsignatarioSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Fecha Vigencia:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="productosInburnomina.fechaVigenciaSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input" readonly="readonly"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                </table>
            	<div class="row660" align="center">&nbsp;</div>
            		<div class="row660">
	                		<label class="label330"><b>Tarifa Total (Incluyendo beneficios y productos):&nbsp;&nbsp;</b></label>
	                		<span class="field330">
	                   			<b>
	                        	<fmt:formatNumber pattern="$ #,##0.00" value="${poliza.solicitud.tarifaTotal}">
	                        	
	                        	</fmt:formatNumber>
	                  			</b>
	                		</span>
	                
	                </div>
            	
            	<div class="row660" align="center">&nbsp;</div>
            	<div class="row660" align="center">&nbsp;</div>
            <div class="row660" align="center">
            
            <input type="button" class="input" id="val" value="Ver Desc. Aplicados" onClick="validaEstatusPoliza();"/>
            <input type="hidden" class="input" name="_finish" id="desc" value="Generar Reporte Desc." />
            &nbsp;&nbsp;
            <a href="javascript:registrarTicket();"><input class="input" type="button" value="Crear Ticket de Correcci&oacute;n de Datos"/></a>
            &nbsp;&nbsp;&nbsp;
            <c:if test="${puedeModificar == true}">
           	 <input type="button" class="input" value="Modificar" onclick="modificarSolicitud();"/>
            </c:if>
            </div>
            <div align="center" class="row660">
               
                    <input type="button" class="input" name="bntAcuse" 
                    value="Ver Acuse de Recibo" onclick="javascript:generarAcuse();"/>
                    <input type="button" class="input" name="btnCarta" 
                    value="Ver Carta Resumen" onclick="javascript:generarCarta();"/>
                    <input type="button" class="input" name="btnCert" 
                    value="Ver Certificado Individual" onclick="javascript:generarCertificado();"/>
            </div>    
           <c:if test="${not empty poliza.numPoliza}">
           	<div align="center" class="row660">
           	
            	<a href="javascript:tramites();"><input class="input" type="button" value="Trámites de Póliza"/></a>
           	</div>
           </c:if>
           
           <div align="center" class="row660">
           
            <a href="javascript:close();"><input class="input" type="button" value="Cerrar"/></a>
           </div>
            
    </form>       
    
     <script language="JavaScript" type="text/javascript">
	 	cargarDetalleCalculo('${poliza.numPoliza}','${poliza.numConsignatario}');
	 </script>
	 <c:if test="${not empty mensajeUsuario}">
	  	<script language="JavaScript" type="text/javascript">
	 		alert("${mensajeUsuario}");
	 	</script>
	 </c:if>
   
     
    </spring:nestedPath>

	



    </body>
</html>
