<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Detalle de C&aacute;lculo de Bono</title>
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
         <script language="JavaScript" type="text/javascript"> 
            function mostrarOcultarDetalle(idRenglon){
            	renglon = document.getElementById("renglon_detalle_"+idRenglon);
            	
            	if(renglon.style.display == "none" ){
            		renglon.style.display = "";
            	}else{
            		renglon.style.display = "none";
            	}
            }
			function reporte(id){
	        	
	            urlBase     = '<c:url value="/app/generarReportesBonoController"/>';
	            propiedades = 'width='+800+',height='+800+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes';
	            params = 'idResumenCalculoBonoPolizaAgente='+id;
	            url    = urlBase + '?' + params;
	            vent   = window.open(url, "reporteProceso", propiedades);
	            isOpen = true;
	        }
        </script>
    </head>
    <body >
			<table cellpadding="0" cellspacing="2" width="800">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Detalle del Proceso de C&aacute;lculo de Bono</strong></td>
                        </tr>
                		
                		<tr>
                			<td class="ContenTablaColor" align="center">
                					Proceso del d&iacute;a <fmt:formatDate pattern="dd/MM/yyyy" value="${resumen.fechaCalculo}"/> <br/>
                					Por un monto de: <fmt:formatNumber pattern="$ #,##0.00" value="${resumen.montoTotal}"/>
                			</td>
                		</tr>
                		
                		
           </table>
           <c:if test="${empty resumen.listaDetalleAgente}">
           		<table cellpadding="0" cellspacing="2" width="800">
	           		<tr align="left" valign="middle" height="20">
	                     <td class="TopTabla" align="center"><strong>
	                     	No existen resultados de cálculo de bonos
	                     </strong></td>
	                 </tr>
	              </table>
           </c:if>
           <c:if test="${not empty resumen.listaDetalleAgente}">
	           <table cellpadding="0" cellspacing="2" width="800">
	                 <tr>	
	                 	<td>
	                 		<table width="800" cellpadding="0" cellspacing="1" border="0"> 
	                 			<tr>
	                 				<td align="center" class="ContenTablaColor" width="1px" >
	                 					&nbsp;
	                 				</td>
	                 				<td align="center" class="ContenTablaColor">
	                 					Agente
	                 				</td>
	                 				<td align="center" class="ContenTablaColor">
	                 					Monto del Bono
	                 				</td>
	                 				<td align="center" class="ContenTablaColor">
	                 					&nbsp;
	                 				</td>
	                 			
	                 			</tr>
	                 			<c:forEach items="${resumen.listaDetalleAgente}" var="registro">
	                 				<tr>
	                 					<td align="center" class="ContenTabla">
	                 						<a href="javascript:mostrarOcultarDetalle('${registro.cveAgente}')" title="Detalle">
	                                        <img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/>
	                                        </a>
	                 					</td>
                                        <td class="ContenTabla"><c:out value="${registro.cveAgente}"/> - <c:out value="${registro.agente.empleado.nombreCompleto}"/></td>
                                        <td class="ContenTabla" style="text-align: right;"><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.montoBono}"/></strong></td>
                                        <td align="center" class="ContenTabla">
		               						<a href="javascript:reporte('${registro.idResumenCalculoBonoPolizaAgente}')" title="Generar Reporte">
		                                      <img border="0" src="<c:url value='/img/skin/onebit_39.png'/>" width="24" height="24"/>
		                                      </a>
		               					</td>
                                
	                 				</tr>
	                 				<tr >
	                 					<td colspan="8" >
	                 						<table width="100%" cellpadding="1" cellspacing="1" id="renglon_detalle_${registro.cveAgente}" style="display:none" >
	                 							<tr>
	                 								<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Num. P&oacute;liza
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Emisor
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Tarifa
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Porcentaje
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Meses
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Folio Solicitud
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Nombre Solicitante
					                 				</td>
					                 				<td align="center" class="ContenTablaColor">
					                 					Monto Bono
					                 				</td>
	                 							</tr>
	                 							<c:forEach items="${registro.resultadoDetalleCalculo}" var="detalle" varStatus="statDetalle">
	                 							<tr>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.numPoliza}</td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.numConsignatario}</td>
	                 								<td class="ContenTabla" nowrap="nowrap" style="text-align: right;"><fmt:formatNumber pattern="$ #,##0.00" value="${detalle.tarifa}"/></td>
	                 								<td class="ContenTabla" nowrap="nowrap" style="text-align: right;"><fmt:formatNumber pattern="0.00 %" value="${detalle.porcentaje}"/></td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.numeroQuincenas}</td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.folioSolicitud}</td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.nombre1Solicitante} ${detalle.apPaternoSolicitante} ${detalle.apMaternoSolicitante}</td>
	                 								<td class="ContenTabla" nowrap="nowrap" style="text-align: right;"><fmt:formatNumber pattern="$ #,##0.00" value="${detalle.montoBono}"/></td>
	                 							</tr>
	                 							</c:forEach>
	                 						</table>
	                 					</td>
	                 				</tr>
	                 				
	                 			
	                 			</c:forEach>
	                 		
	                 		
	                 		</table>
	                 	
	                 	
	                 	
	                 	</td>
	                 	
	                 
	                 </tr>
	           
	           </table>
           </c:if>
           
    </body>
</html>
