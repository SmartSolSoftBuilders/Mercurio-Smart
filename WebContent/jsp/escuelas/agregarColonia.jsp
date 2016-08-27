<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Agregar Nueva Colonia</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
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
        <script type="text/javascript">
        
        
        function guardar(){
        	forma = document.forms[0];
        	
        	if(forma.tipoAsentamiento.value == ""){
        		alert("El Tipo de Asentamiento es un dato obligatorio");
        		return;
        	}
        	
        	if(forma.asentamiento.value == ""){
        		alert("El Nombre del Asentamiento es un dato obligatorio");
        		return;
        	}
        	
        	if(forma.municipio.value == ""){
        		alert("El Municipio es un dato obligatorio");
        		return;
        	}
        	
        	if(forma.estado.value == ""){
        		alert("El Estado es un dato obligatorio");
        		return;
        	}
        	
        	
        	forma.submit();
        	
        }
        </script>
    </head>
    <body >
    		<form action="<c:url value="/app/agregarColoniaController"/>" method="post">
             <c:if test="${not empty error }">
	              <div align="center" class="submit664">
		                   <span style="color:red;font-weight: bold;font-size: x-small; margin: 10px">
		                		${error }
		                	</span>
		          </div>
	              <br/>
	         </c:if>
	         <c:if test="${not empty cerrar }">
	              <script type="text/javascript">
	              	window.opener.document.getElementById('cveColonia').value = '<c:out value="${agregarSucursalColoniaCommand.cveColonia}"/>';
	              	window.opener.document.getElementById('descripcionColonia').value = '<c:out value="${agregarSucursalColoniaCommand.asentamiento}"/>';
	              	window.close();
	              </script>
	         </c:if>
	         <spring:nestedPath path="agregarSucursalColoniaCommand">
			 <table cellpadding="2" cellspacing="2" width="600">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="4" class="TopTabla" align="center"><strong>AGREGAR COLONIA</strong></td>
                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="4" class="TopTabla" align="center"><strong>CAPTURE LOS SIGUIENTES DATOS PARA AGREGAR UNA COLONIA</strong></td>
                        </tr>
                        <tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Tipo Asentamiento :&nbsp;
                			</td>
                			<td class="fieldRow">
		                      <form:input path="tipoAsentamiento" cssClass="input" size="20" maxlength="45"/>
                         
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Nombre Asentamiento :&nbsp;
                			</td>
                			<td class="fieldRow">
		                      <form:input path="asentamiento" cssClass="input" size="25" maxlength="60"/>
                         
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Municipio :&nbsp;
                			</td>
                			<td class="fieldRow">
		                      <form:input path="municipio" cssClass="input" size="20" maxlength="45"/>
                         
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Estado :&nbsp;
                			</td>
                			<td class="fieldRow">
		                      <form:input path="estado" cssClass="input" size="20" maxlength="45"/>
                         
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="text-align: center" colspan="4">
                					
                						<input type="button" value="Guardar" class="input" name="btnGuardar" id="btnGuardar" onclick="javascript:guardar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="javascript:window.close()"><input type="button" value="Cancelar" class="input" name="btnCancelar" id="btnCancelar"  /></a>
                			</td>
                		</tr> 
                		
           </table>
           </spring:nestedPath>
          
          	
           
        	</form>
    </body>
</html>
