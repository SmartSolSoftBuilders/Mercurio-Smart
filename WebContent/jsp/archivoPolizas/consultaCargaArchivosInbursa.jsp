<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
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
            function cargarArchivo(){
            	if(document.getElementById("archivoInbursa").value == ""){
            		altert("Debe elegir un archivo para poder cargarlo en el sistema");	
            		return;
            	}
            	document.w01.submit();
                
            }
            function verDetalle(id){
            	document.location.href = 
            		'<c:url value="/app/consultarDetalleArchivoPolizasController"/>?idResumenCargaArchivoPolizas='+id;
            }
            function regresar(){
            	document.location.href = 
            		'<c:url value="/"/>';
            }

        </script>


        
        <title>Consulta de Cargas de Archivos de P&oacute;lizas de Inbursa</title>
        
    </head>
        
    <body>
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            
            <form action="#" method="post" name="w01" enctype="multipart/form-data">
               
                
                <div id="title589x16" align="center" style="margin-left: auto;margin-right: auto" >Consulta de Cargas de Archivos de P&oacute;lizas de Inbursa</div>
                <c:if test="${not empty command.mensajeError }">
                	<span style="color:red;font-weight: bold;font-size: x-small">
                		${command.mensajeError }
                	</span>
                </c:if>
				<div class="row660">
                   <span class="field588"  >
                     &nbsp;&nbsp; Cargar nuevo archivo de p&oacute;lizas: &nbsp;&nbsp;
                      		<spring:bind path="command.archivoInbursa">
                      			<input type="file" class="input" name="${status.expression }" id="${status.expression }" value="${status.value }"/>
                      		</spring:bind>
                      		
                            <input type="button" value = "  Cargar...  " class="input" onclick="javascript:cargarArchivo();"/>
                        

                   </span>
                </div>
                <div class="row660">
                   <span class="field588"   style="text-align: center;">
                     
                      		
                      		
                            <input type="button" value = "  Regresar  " class="input" onclick="javascript:regresar();"/>
                        

                   </span>
                </div>
               
                 
                 
                <div align="center" >
                    <table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:x-small;font-weight: bold;">
                                Total de registros: ${fn:length(listaResumenCarga)}
                            </td>

                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                            <td class="ContenTablaColor">&nbsp;</td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha de Carga</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Archivo</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Total Registros</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Registros V&aacute;lidos</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Registros Inv&aacute;lidos</strong></td>
                           
                            
                        </tr>
                        <c:forEach items="${listaResumenCarga}"  var="resumen">
                        	<tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="javascript:verDetalle('${resumen.idResumenCargaArchivoPolizas}')" title="Detalle">
	                                        <img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/>
	                                        </a>
										</td>
                                        <td class="ContenTabla"><fmt:formatDate value="${resumen.fechaCarga}" pattern="dd/MM/yyyy"/></td>
                                        <td class="ContenTabla">${resumen.usuario}</td>
                                        <td class="ContenTabla">${resumen.nombreArchivo}</td>
                                        <td class="ContenTabla">${resumen.totalRegistros}</td>
                                        <td class="ContenTabla">${resumen.registrosValidos}</td>
                                        <td class="ContenTabla">${resumen.totalRegistros-resumen.registrosValidos }</td>
                                
                            </tr>
                        
                        </c:forEach>
                        
                                                                  

                      
                        
                    
                       
                        </table>




                </div>
            </form>
            
   
    </body>
    
</html>
