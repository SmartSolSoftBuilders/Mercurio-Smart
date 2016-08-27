<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Calcular Bono de Pólizas para Agentes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            .form{

            }
            .field {
            height: 31px;
            display: block;
            float: left;
            margin: 0;
            margin-right: 2px;
            background: url(<c:url value="/"/>img/bg_textfieldspan3.gif) no-repeat;
            }
        </style>
        
        <script language="JavaScript" type="text/javascript"> 
            function procesando(){ 
                document.getElementById('img').style.visibility = "visible"; 
            } 
            function mostrarOcultarDetalle(idRenglon){
            	renglon = document.getElementById("renglon_detalle_"+idRenglon);
            	
            	if(renglon.style.display == "none" ){
            		renglon.style.display = "";
            	}else{
            		renglon.style.display = "none";
            	}
            }
        </script>
    </head>
    <body onSubmit="procesando()">
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <form action="<c:url value="/app/calcularBonoPolizaAgenteController"/>" method="POST"  id="formulario" >
            
                  
             <c:if test="${not empty error }">
	              <div align="center" class="submit664">
		                   <span style="color:red;font-weight: bold;font-size: small; margin: 10px">
		                		${error }
		                	</span>
		          </div>
	              <br/>
	         </c:if>
	         
			<table cellpadding="0" cellspacing="2" width="800">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Calcular Bono de Pólizas para Agentes</strong></td>
                        </tr>
                		<tr>
                			<td class="fieldRow" >
                				<strong>
                					Esta pantalla permite realizar el c&aacute;lculo del bono de p&oacute;lizas para Agentes 
                					tomando en cuenta la totalidad de la cartera de p&oacute;lizas u opcionalmente s&oacute;lo las p&oacute;lizas
                					de la plaza seleccionada que cuenten con descuentos aplicados
                					y que no han sido ya considerados para un c&aacute;lculo de bono.
                				</strong>
                			</td>
                		</tr>
                		<tr>
                			<td class="fieldRow" >
                				<strong>
                					De Clic en el bot&oacute;n de "Realizar C&aacute;lculo Previo" para ver tener una lista previa 
                					del cálculo actual del bono para todas las pólizas pendientes.
                				</strong>
                			</td>
                		</tr>
                		
                		<tr>
                			<td class="fieldRow" style="text-align: center">
                				<div style="display:${listaResumenCalculo == null?"block":"none"}">
                					<b>Plaza a considerar para el c&aacute;lculo:</b> <form:select path="calcularBonoPolizaAgenteCommand.idPlaza"  >
                						<form:options items="${plazas}" itemValue="idPlaza" itemLabel="nombrePlaza" />
                					</form:select>
                				
                					<input type="submit" value="Realizar C&aacute;lculo Previo" class="input" name="btnCalculo" id="btnCalculo"/>
                				</div >
                				
                					
                				
                				<c:if test="${not empty listaResumenCalculo}">
                					<input type="submit" value="Guardar C&aacute;lculo de Bono" class="input" name="btnGuardar" id="btnGuardar"/>
                				 	
                				 		<spring:bind path="calcularBonoPolizaAgenteCommand.guardar">
                				 		<input type="hidden" value="true" 
                						id="${status.expression}" name="${status.expression}"/>
                				 		</spring:bind>
                				</c:if>
                				 	
                				</div>
                			</td>
                		</tr>
           </table>
           <div id="img" style="visibility:hidden">
                <img alt="Procesando"  src="<c:url value="/img/procesando.gif"/>">
           </div> 
           <c:if test="${ listaResumenCalculo != null and empty listaResumenCalculo}">
           		<table cellpadding="0" cellspacing="2" width="800">
	           		<tr align="left" valign="middle" height="20">
	                     <td class="TopTabla" align="center"><strong>
	                     	No existen resultados de cálculo de bonos en este momento.
	                     </strong></td>
	                 </tr>
	              </table>
           </c:if>
           <c:if test="${listaResumenCalculo != null and  not empty listaResumenCalculo}">
	           <table cellpadding="0" cellspacing="2" width="800">
	           		<tr align="left" valign="middle" height="20">
	                     <td class="TopTabla" align="center"><strong>Resultado del c&aacute;lculo. 
	                     <br>
	                     Este c&aacute;lculo se realiza &uacute;nicamente
	                     para mostrarse un previo del resultado del proceso.</strong></td>
	                 </tr>
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
	                 			
	                 			</tr>
	                 			<c:forEach items="${listaResumenCalculo}" var="registro">
	                 				<tr>
	                 					<td align="center" class="ContenTabla">
	                 						<a href="javascript:mostrarOcultarDetalle('${registro.cveAgente}')" title="Detalle">
	                                        <img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/>
	                                        </a>
	                 					</td>
                                        <td class="ContenTabla"><c:out value="${registro.cveAgente}"/> - <c:out value="${registro.agente.empleado.nombreCompleto}"/></td>
                                        <td class="ContenTabla" style="text-align: right;"><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.montoBono}"/></strong></td>
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
					                 					Quincena Inicial
					                 				</td>
					                 				<td align="center" class="ContenTablaColor" nowrap="nowrap">
					                 					Quincena Final
					                 				</td>
					                 				<td align="center" class="ContenTablaColor">
					                 					Monto Bono
					                 				</td>
	                 							</tr>
	                 							<c:forEach items="${registro.listaDetalleCalculo}" var="detalle" varStatus="statDetalle">
	                 							<tr>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.numPoliza}</td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.numConsignatario}</td>
	                 								<td class="ContenTabla" nowrap="nowrap" style="text-align: right;"><fmt:formatNumber pattern="$ #,##0.00" value="${detalle.tarifa}"/></td>
	                 								<td class="ContenTabla" nowrap="nowrap" style="text-align: right;"><fmt:formatNumber pattern="0.00 %" value="${detalle.porcentaje}"/></td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.numeroQuincenas}</td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.quincenaInicial}</td>
	                 								<td class="ContenTabla" nowrap="nowrap">${detalle.quincenaFinal}</td>
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
           
        </form>
    </body>
</html>
