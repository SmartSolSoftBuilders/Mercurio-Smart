<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
       
        <!--agregue los nuevos campos del formulario-->
    
        


        
        <title>Consulta de Pólizas por Baja</title>
        <script type="text/javascript" >
            function cambioPagina(pagina){
            	
            	document.forms[0].target="_self";
                document.forms[0].paginaActual.value = pagina;
                document.forms[0].submit();
            }
            

            function buscar(){
            	
            	document.forms[0].target="_self";
                document.w01.paginaActual.value = '';
                document.w01.submit();
            }
   
            
            function marcarPolizas(){
            	document.forms[0].actualizar.value="true";
            	 document.forms[0].submit();
            }
        </script>
        
    </head>
        
    <body>
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            
            <form action="<c:url value="/app/consultaPolizasPorBajaController"/>" method="post" name="w01">
                <input type="hidden" name="indiceOrden"  />
                <input type="hidden" name="actualizar" value=""  />
                <spring:nestedPath path="criteriosBusqueda">
              					
                
                
                <input type="hidden" name="_page0" value="0" />
                
                <table cellpadding="0" cellspacing="2" width="1150">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Consulta de P&oacute;lizas Por Baja</strong></td>
                        </tr>
                		<tr>
                			<td class="labelRow" nowrap width="15%">
                				Plaza:&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="35%">
                				<form:select  id="idPlaza"  cssClass="input" path="idPlaza" items="${listaPlazas}" itemLabel="cvePlaza" 
                    			itemValue="idPlaza"/>
                			</td>
                	
                			<td class="labelRow" width="15%">
                				 Estatus P&oacute;liza Pagos:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" width="35%">
                				<form:select  id="idEstatusPagosPoliza"  cssClass="input" path="idEstatusPagosPoliza" items="${listaEstatusPolizaPagos}" itemLabel="descripcionEstatusPagosPoliza" 
                    			itemValue="idEstatusPagosPoliza">
                    				
                    			</form:select>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" nowrap width="15%">
                				Quincena &Uacute;ltimo Descuento:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="35%">
                				<spring:bind path="quincenaSuspension">
			                    	 <input type="text" name="${status.expression}" id="${status.expression}"
					                        value="${status.value}" class="input"/>
					            </spring:bind>
                			</td>
                	
                			<td class="labelRow" width="15%">
                				  Fecha de Solicitud de Cancelaci&oacute;n:&nbsp;&nbsp;
                			</td>
                			<td class="fieldRow" width="35%">
                				 
                				 
                				 <spring:bind path="fechaSolicitudCancelacion" >
	                            <div ID="div${status.expression}"
	                               STYLE="position:absolute;visibility:hidden;background-color:white;">
	                            </div>
	                             <script language="JavaScript" type="text/javascript">
	                                var cal${status.expression} = new CalendarPopup("div${status.expression}");
	                                cal${status.expression}.setCssPrefix("TEST");
	                            </script>
	                            
	                            <input type="text"
	                                   name="${status.expression}"
	                                   id="${status.expression}"
	                                   size="10"
	                                   tabindex="1"
	                                   value="${status.value}"
	                                   class="input" />
	                       
	                           
	                           <A HREF="#" onClick="cal${status.expression}.select(document.forms[0].${status.expression},'anchor${status.expression}','dd/MM/yyyy'); return false;"
	                              TITLE="cal${status.expression}.select(document.forms[0].${status.expression}},'anchor${status.expression}','dd/MM/yyyy'); return false;"
	                              NAME="anchor${status.expression}" ID="anchor${status.expression}" TABINDEX="11">
	                               <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A>
	                             </spring:bind>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="text-align: center" colspan="6">
                					
                						<input type="button" value="Buscar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/app/consultaPolizasPorBajaController"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>
				
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/"/>">
				                          <input type="button" class="input" value="Regresar" />
				                        </a>
                			
                			</td>
                		</tr> 
                
                </table>
                  <div style="text-align: right; width: 1150px" >
               	<c:if test="${not empty resultado.resultados}">
               	<br/>
               	<input type="button" value="Marcar como Canceladas a Petición del Cliente" onclick="marcarPolizas();"/> 
               	</c:if>
               
               </div> 
              
                <div align="center" >
                    <table width="100%" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:small;font-weight: bold;">

                                Total de registros: <c:out value="${resultado.totalResultados}"/><br/>
                                                               
                                <c:if test="${resultado.totalResultados > 0}">
                                	 <c:if test="${resultado.paginaActual>1}">
                                	 	<a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual-1}"/>)" >&lt;</a>
                                	 </c:if> 
                                	 P&aacute;gina <c:out value="${resultado.paginaActual}"/> de <c:out value="${resultado.totalPaginas}"/>
                                 	<c:if test="${resultado.paginaActual<resultado.totalPaginas}">
                                 		<a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual+1}"/>)" >&gt;</a>
                                 	</c:if>
                                	<br/>
                                </c:if>
                                <input type="hidden" name="totalResultados" value="<c:out value="${resultado.totalResultados}"/>"/>
                                <input type="hidden" name="paginaActual" value="<c:out value="${resultado.paginaActual}"/>"/>
                                <input type="hidden" name="totalPaginas" value="<c:out value="${resultado.totalPaginas}"/>"/>
                            </td>
                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                              
                           <td align="center" class="ContenTablaColor"><strong>Plaza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Certificado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Nombre Contratante</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Num. N&oacute;mina Asegurado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Folio de Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Formato Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Nombre Asegurado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>RFC Asegurado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tel. Solicitante</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Emisor</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Num. de Poliza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>                           
                           <td align="center" class="ContenTablaColor"><strong>Seguimiento a P&oacute;liza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Pagos P&oacute;liza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud Cancelaci&oacute;n</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Quincena &Uacute;ltimo Descuento</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Seleccionar</strong></td>
                            
                        </tr>
                        <c:forEach var="registro" items="${resultado.resultados}">
                                    <tr align="left" valign="middle">
                                       
                                        <td class="ContenTabla"><c:out value="${registro.cvePlaza}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numCertificado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombre1Contratante}"/>
                                                                                <c:out value="${registro.nombre2Contratante}"/>
                                                                                <c:out value="${registro.apPaternoContratante}"/>
                                                                                <c:out value="${registro.apMaternoContratante}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numNominaAsegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.folioSolicitud}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.formatoSolicitud}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaSolicitud}" /></td>
                                        <td class="ContenTabla"><c:out value="${registro.nombre1Asegurado}"/>
                                                                                <c:out value="${registro.nombre2Asegurado}"/>
                                                                                <c:out value="${registro.apPaternoAsegurado}"/>
                                                                                <c:out value="${registro.apMaternoAsegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.RFCasegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.telefonoSolicitante}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numConsignatario}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.numPoliza}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaInicioVigencia}" /></td>
                                        <td class="ContenTabla"><c:out value="${registro.descripcionEstadoPoliza}"/></td>
                                        <td class="ContenTabla"><c:out value="${registro.descripcionEstadoPolizaPagos}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaSolicitudCancelacion}" /></td>
                                        <td class="ContenTabla"><c:out value="${registro.numQuincenaUltimoDescuento}"/></td>
                                        <td class="ContenTabla" align="center"><input type="checkbox" name="polizasMarcadas" value="${registro.numPoliza}-${registro.numConsignatario}" /></td>
                                       
                                    </tr>
                        </c:forEach>
                        </table>




                </div>
                  <div style="text-align: right; width: 1150px" >
               	<c:if test="${not empty resultado.resultados}">
               	<input type="button" value="Marcar como Canceladas a Petición del Cliente" onclick="marcarPolizas();"/> 
               	</c:if>
               
               </div> 
               
                
                <!--Seccion de poliza individual-->


                
                    </spring:nestedPath>
            </form>
    <c:if test="${not empty mensaje}">
    	 <script type="text/javascript" >
   				
    	 		alert("${mensaje}");
    		
   		 </script>
    </c:if>
   
    </body>
    
</html>
