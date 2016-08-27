<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="mx.com.seguros.web.reportes.GenerarReportesPolizaController"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Detalle Retiros de Asegurado</title>
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
        
    </head>
    <body>
    
    
    
     <form action="#" method="post" name="w01">            
                <input type="hidden" name="_page0" value="0" />
        <div class="row660" align="center">&nbsp;</div>
            <div id="titleg664x16">Resultados de consulta</div>
            
           
                   
            
                 <div class="row660" align="left">&nbsp;</div>
                <div class="row660">
                	<table width="100%">
                	<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Tr&aacute;mites de Retiro</strong></td>
                        </tr>
                        <c:if test="${empty listaTramites}">
                        <tr>
                        	<td class="fieldRow" colspan="4" align="center" style="text-align: center">
								<strong>No existen tr&aacute;mites de retiro asociados a este asegurado</strong>
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
												Monto Solicitado
											</td>
											<td class="ContenTablaColor">
												Monto Aplicado
											</td>
											<td class="ContenTablaColor">
												Concepto
											</td>
											<td class="ContenTablaColor">
												Operador
											</td>
											<td class="ContenTablaColor">
												Sucursal
											</td>
										<tr/>
								<c:forEach items="${listaTramites}" var="tramite" >
										<tr>
											<td class="ContenTabla">
												<fmt:formatDate value="${tramite.fechaTramite}" pattern="dd/MM/yyyy"/>
											</td>
											<td class="ContenTabla">
												<fmt:formatNumber pattern="$ #,##0.00" value="${tramite.importeOriginal}"/>
											</td>
											<td class="ContenTabla">
												<fmt:formatNumber pattern="$ #,##0.00" value="${tramite.importeAplicado}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.observacionConcepto}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.nombreOperador}"/>
											</td>
											<td class="ContenTabla">
												<c:out value="${tramite.nombreSucursal}"/>
											</td>
										</tr>
								</c:forEach>		
									</table>
	                        	</td>
	                        </tr>
                        </c:if>
                     </table>
                </div>
               
                        
    </form>       
    
    
    </body>
</html>
