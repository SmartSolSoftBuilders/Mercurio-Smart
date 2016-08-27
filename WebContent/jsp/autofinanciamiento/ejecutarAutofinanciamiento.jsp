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
    
        


        
        <title>Ejecutar Proceso de Autofinanciamiento</title>
      
        
    </head>
        <script type="text/javascript" >
           
            

            function buscar(){
            	
                document.w01.submit();
            }
   
        </script>
        
    <body>
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
      
            
            
            <form action="<c:url value="/app/ejecutarAutofinanciamientoController"/>" method="post" name="w01">
                <spring:nestedPath path="criteriosBusqueda">
                              
                <table cellpadding="0" cellspacing="2" width="1150">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Ejecutar Autofinanciamiento</strong></td>
                        </tr>
                		<tr>
                			<td class="labelRow" nowrap width="15%">
                				Plaza:&nbsp;
                			</td>
                			<td class="fieldRow" nowrap width="35%">
                				<form:select  id="idPlaza"  cssClass="input" path="idPlaza" items="${listaPlazas}" itemLabel="cvePlaza" 
                    			itemValue="idPlaza"/>
                			</td>
                	        
                	        <td class="labelRow" nowrap width="15%">
                				Estatus Pago Póliza:&nbsp;
                			</td>
                			
                			<td class="fieldRow" nowrap width="35%">
                				<form:select  id="idEstatusPolizaPagos"  cssClass="input" path="idEstatusPolizaPagos" items="${listaEstatusPolizaPagos}" itemLabel="descripcionEstatusPagosPoliza" 
                    			itemValue="idEstatusPagosPoliza"/>
                			</td>                			
                			
                		</tr>
                		
                		<tr>
                			<td class="labelRow" style="text-align: center" colspan="6">
                					
                						<input type="button" value="Ejecutar Autofinanciamiento" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/app/ejecutarAutofinanciamientoController"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>
				
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/"/>">
				                          <input type="button" class="input" value="Regresar" />
				                        </a>
                			
                			</td>
                		</tr> 
                
                </table>
              	<c:if test="${not empty cifrasControl}">
	                <div align="center"  >
	                    <table width="1150px" border="0" cellpadding="5" cellspacing="1">
	                          
	                        <tr align="left" valign="middle" height="20">
	                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado del proceso</strong></td>
	                        </tr>
	                       
	                       <tr>
	                       		<td>
	                       			Hora de Inicio:
	                       		</td>
	                       		<td>
	                       			<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${cifrasControl.fechaHoraInicio}" />
	                       		</td>
	                       		<td>
	                       			Hora de Fin:
	                       		</td>
	                       		<td>
	                       			<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${cifrasControl.fechaHoraFin}" />
	                       		</td>
	                       </tr>  
	                       <tr>
	                       		<td>
	                       			Registros Procesados:
	                       		</td>
	                       		<td>
	                       			${cifrasControl.totalRegistrosProcesados}
	                       		</td>
	                       		<td>
	                       			Descuentos Aplicados:
	                       		</td>
	                       		<td>
	                       			${cifrasControl.totalDescuentosAplicados}
	                       		</td>
	                       </tr>     
	                       <tr>
	                       		<td>
	                       			Registro:
	                       		</td>
	                       		<td>
	                       		
	                       		</td>
	                       		<td>
	                       			
	                       		</td>
	                       		<td>
	                       		
	                       		</td>
	                       </tr>    
	                       <tr>
	                       		<td colspan="4">
	                       			
	                       			<textarea rows="40" cols="100">${cifrasControl.log}</textarea>
	                       			
	                       		</td>
	                       </tr>                        
	                       
	                    </table>
	                </div>
               </c:if>                        
           </spring:nestedPath>
            </form>
    <c:if test="${not empty mensaje}">
    	 <script type="text/javascript" >
   				
    	 		alert("${mensaje}");
    		
   		 </script>
    </c:if>
   
    </body>
    
</html>
