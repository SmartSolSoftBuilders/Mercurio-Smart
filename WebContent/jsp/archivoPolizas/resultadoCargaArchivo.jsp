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
            	document.location.href = '<c:url value="/app/consultarArchivosPolizasCargadosController"/>';
            }
            
			function verDetalle(){
				document.location.href = '<c:url value="/app/consultarDetalleArchivoPolizasController"/>?idResumenCargaArchivoPolizas=${resumen.idResumenCargaArchivoPolizas}';
            }

        </script>
       
         
         	


        
        <title>Resultado de Carga de Archivo de P&oacute;lizas de Inbursa</title>
        
        
        
    </head>
        
    <body>
      
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
            
            
            <form action="#" method="post" name="w01">
                <div id="titleg664x16">Resultado de Carga de Archivo de P&oacute;lizas de Inbursa</div>
               
                <div class="row660">
                	<table cellpadding="4" cellspacing="2" width="100%" >
                		<tr>
                			<td class="labelRow">
                				Fecha:
                			</td>
                			<td class="fieldRow" >
                				<b><fmt:formatDate value="${resumen.fechaCarga}" pattern="dd/MM/yyyy hh:mm" /> </b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Archivo:
                			</td>
                			<td class="fieldRow" >
                				<b>${resumen.nombreArchivo }</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Usuario:
                			</td>
                			<td class="fieldRow" >
                				<b>${resumen.usuario }</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Total de Registros:
                			</td>
                			<td class="fieldRow" >
                				<b>${resumen.totalRegistros }</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Registros V&aacute;lidos:
                			</td>
                			<td class="fieldRow" >
                				<b>${resumen.registrosValidos }</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Registros Inv&aacute;lidos:
                			</td>
                			<td class="fieldRow" >
                				<b>${resumen.totalRegistros-resumen.registrosValidos }</b>
                			</td>
                		</tr>
                		<tr>
                			<td colspan="2" class="fieldRow" style="text-align: center">
                				<input type="button" value="Regresar" class="input" onclick="regresar();"/>
                				<input type="button" value="Ver Detalle" class="input" onclick="verDetalle();"/>
                			</td>
                		</tr>
                	</table>
                </div>
                
            </form>
            
   
    </body>
    
</html>
