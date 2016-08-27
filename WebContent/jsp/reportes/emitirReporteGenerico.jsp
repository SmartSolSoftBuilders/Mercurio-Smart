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
        
        <!--agregue los nuevos campos del formulario-->
    
        <script type="text/javascript" >
            function regresar(){
            	document.location.href = '<c:url value="/"/>';
            }
            
			function generar(){
				document.w01.submit();
            }
			function cargarParametros(claveReporte){
				document.location.href = '<c:url value="/app/generarReporteGenericoController"/>?claveReporteTmp='+claveReporte;
			}

        </script>


        
        <title>Emitir Reporte</title>
        
       
        
    </head>
        
    <body>
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            <spring:nestedPath path="command">
            <form action="<c:url value="/app/generarReporteGenericoController"/>" method="post" name="w01">
             
                <div id="titleg664x16">Emitir un Reporte</div>
               <div id="titleg664x16">Seleccione un Reporte y Llene los Par&aacute;metros Solicitados</div>
                <div class="row660">
                	<table cellpadding="0" cellspacing="2" width="100%" style="line-height:normal;">
                		<tr>
                			<td class="labelRow">
                				Reporte:
                			</td>
                			<td class="fieldRow" >
                				<spring:bind path="claveReporte">
		                            <select name="${status.expression}" id="${status.expression}" class="inputInfo" 
		                            onchange="cargarParametros(this.value);"
		                             >	
		                             	<option value="">Seleccione</option>
		                                <c:forEach var="reporte" items="${inventarioReportes}">
		                                    
		                                    <option value="<c:out value='${reporte.claveReporte}'/>"
		                                            <c:if test="${status.value == reporte.claveReporte}">
		                                                selected="selected"
		                                            </c:if>
		                                    >
		                                        <c:out value="${reporte.nombreReporte}"/>
		                                    </option>
		                                </c:forEach>
		                            </select>
		                            
		                        </spring:bind>
                			</td>
                		</tr>
                		<c:if test="${not empty  command.claveReporte}">
	                		<c:forEach items="${listaParams}" var="parametro" varStatus="iStatus">
	                			<tr>
		                			<td class="labelRow">
		                				<b>${nombreParams[iStatus.index]}</b>:
		                			</td>
		                			<td class="fieldRow" >
		                				
		                				
		                				<input type="text" 
		                				 name="${parametro}" id="${parametro}"
		                				 class="input" size="15" onblur="this.value = this.value.toUpperCase();"/>
		                				
		                			</td>
	                			</tr>
	                		</c:forEach>
	                	</c:if>
                		
                		<tr>
                			<td class="labelRow" colspan="2" style="text-align: center">
                			<c:if test="${not empty  command.claveReporte}">
                				<input type="button" class="input" value="Generar Reporte" onclick="generar();"/>
                				&nbsp;&nbsp;
                			</c:if>
                				<input type="button" class="input" value="Regresar" onclick="regresar();"/>
                			</td>
                		</tr>
                		<c:if test="${not empty rutaReporte}">
                			
                			<tr>
	                			<td class="labelRow" colspan="2" style="text-align: center">
	                				<br/>
	                				<h2>Reporte Generado Exitosamente  &nbsp;&nbsp; <a href ="<c:url value="/reportes/${rutaReporte}"/>">Ver Reporte</a></h2>
	                				<br/>
	                				<br/>&nbsp;	
	                			</td>
                			</tr>
                		
                		</c:if>
                		
                		 
                		
                		
                	</table>
                </div>
                
            </form>
            </spring:nestedPath>
   
    </body>
    
</html>
