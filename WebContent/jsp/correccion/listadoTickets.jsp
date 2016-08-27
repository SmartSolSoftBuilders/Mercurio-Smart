<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

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
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/GUIHelper.js"/>">
        </script>
         <script language="JavaScript" type="text/javascript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
        </script>
       
    	<script language="JavaScript" type="text/javascript">
           function buscar(){
        	   document.w01.submit();
           }
            
        </script>
        


        
        <title>Consulta de Tickets de Correcci&oacute;n de Datos</title>
        
    </head>
        
    <body>
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            <div ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;background-color:white;">
            </div>
             <tag:errors name="command"/>
            <form action="#" method="post" name="w01">
               
                
                <div id="title589x16" align="center" style="margin-left: auto;margin-right: auto" >Consulta de Tickets de Correcci&oacute;n de Datos</div>
                
				<c:if test="${mensaje != null}">
					<div style="color: RED;font-size: small;" >${mensaje}</div>
				</c:if>
                
                <div class="row660">
                   <span class="field588"  >
                     &nbsp;&nbsp; Mostrar: &nbsp;&nbsp;
                      		
	                            <select name="idEstadoTicketCorreccion" class="select" tabindex="12" >
	                                <c:forEach var="estado" items="${estadosTicketCorreccion}">
	                                   
	                                    <option value="<c:out value='${estado.idEstadoTicketCorreccion}'/>"
	                                            <c:if test="${idEstadoTicketCorreccion == estado.idEstadoTicketCorreccion}">
	                                                selected="selected"
	                                            </c:if>
	                                    >
	                                        <c:out value="${estado.descripcionEstadoTicketCorreccion}"/>
	                                    </option>
	                                </c:forEach>
	                            </select>
	                            
	
                        

                   </span>
                </div>
                 <div class="row660">
                   <span class="field588" style="text-align: left">
                      &nbsp;&nbsp;Filtrar por fecha de Solicitud entre: 
                      		
                      			<input type="text" 
                      			name="fechaInicioConsulta"
                      			id="fechaInicioConsulta"
                      			value="${fechaInicioConsulta}"
	                             size="11" tabindex="10" class="input"/>
                      		
                      			
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaInicioConsulta,'anchor17','dd/MM/yyyy'); return false;" 
	                             NAME="anchor17" ID="anchor17" >
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/></A>  
	                                 y 
	                                 
	                       
                      			<input type="text" 
                      			name="fechaFinConsulta"
                      			id="fechaFinConsulta"
                      			value="${fechaFinConsulta}"
	                             size="11" tabindex="10" class="input"/>
                      		
	                                   
	                            
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaFinConsulta,'anchor18','dd/MM/yyyy'); return false;" 
	                             NAME="anchor18" ID="anchor18" >
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A> 

                         
                           
                   </span>
                </div>
                 <div class="row660">
                     <span class="field588" style="margin-left: auto;margin-right: auto;text-align: center" >
                         <input type="button" value="Buscar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
                         &nbsp;
                         &nbsp;
                         &nbsp;
                         <a href="<c:url value="/app/consultarTicketsCorreccion"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>

                         &nbsp;
                         &nbsp;
                         &nbsp;
                         <a href="<c:url value="/"/>">
                          <input type="button" class="input" value="Regresar"  />
                        </a>
                          
                     </span>
                </div>
                <div align="center" >
                    <table width="1300" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:small;font-weight: bold;">

                                Total de registros: <c:out value="${resultado.totalResultados}"/><br/>
                                <c:if test="${resultado.paginaActual>1}"><a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual-1}"/>)" >&lt;</a></c:if> P&aacute;gina <c:out value="${resultado.paginaActual}"/> de <c:out value="${resultado.totalPaginas}"/>
                                 <c:if test="${resultado.paginaActual<resultado.totalPaginas}"><a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual+1}"/>)" >&gt;</a></c:if>
                                <input type="hidden" name="totalResultados" value="<c:out value="${resultado.totalResultados}"/>"/>
                                <input type="hidden" name="paginaActual" value="<c:out value="${resultado.paginaActual}"/>"/>
                                <input type="hidden" name="totalPaginas" value="<c:out value="${resultado.totalPaginas}"/>"/>
                                                                  
                              

                            </td>

                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                            <td class="ContenTablaColor">&nbsp;</td>
                            
                            	
                                                      
                           <td align="center" class="ContenTablaColor"><strong>Folio del Ticket de Correcci&oacute;n</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Folio y Formato Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>N&uacute;mero de P&oacute;liza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario Solicitante</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario que Autoriza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Autorizaci&oacute;n</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Motivo</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Estado</strong></td>
                          
                 
                            
                        </tr>
                        <c:forEach var="registro" items="${resultado.resultados}">
                        	<tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="<c:url value='/app/consultarDetalleTicketController?idTicketCorreccion=${registro.idTicketCorreccion}'/>" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/></a>
										</td>
										<td class="ContenTabla">${registro.idTicketCorreccion}</td>
                                        <td class="ContenTabla">${registro.folioSolicitud} / ${registro.formatoSolicitud}</td>
                                        <td class="ContenTabla">${registro.numPoliza}</td>
                                        <td class="ContenTabla">${registro.usuarioSolicitante}</td>
                                        <td class="ContenTabla"><fmt:formatDate value="${registro.fechaSolicitud}" pattern="dd/MM/yyyy"/></td>
                                        <td class="ContenTabla">${registro.usuarioAutoriza}</td>
                                        <td class="ContenTabla"><fmt:formatDate value="${registro.fechaAutorizacion}" pattern="dd/MM/yyyy"/></td>
                                        <td class="ContenTabla">${registro.motivoSolicitud }</td>
                                        <td class="ContenTabla">
                                        <c:if test="${registro.idEstadoTicketCorreccion == 1}">
                                        	<img border="0" src="<c:url value='/img/skin/onebit_36.png'/>" title="Pendiente" width="24" height="24"/>
                                        </c:if>
                                        <c:if test="${registro.idEstadoTicketCorreccion == 2}">
                                        	<img border="0" src="<c:url value='/img/skin/onebit_33.png'/>" title="Rechazado" width="24" height="24"/>
                                        </c:if>
                                        <c:if test="${registro.idEstadoTicketCorreccion == 3}">
                                        	<img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="Aplicado" width="24" height="24"/>
                                        </c:if>
                                        
                                        
                                        </td>
                                        
                                                                             
                                       
                                
                              </tr>
                        
                        </c:forEach>
                        </table>




                </div>
          
            </form>
            
   
    </body>
    
</html>
