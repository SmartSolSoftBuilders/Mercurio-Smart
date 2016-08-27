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
    
        <title>Consulta de Reporte de Trámites</title>
        
        <script type="text/javascript" >
        
        function buscar(){
        	document.w01.formato.value = "";
        	document.forms[0].target="_self";
            document.w01.submit();
        
        }        
        
        
        function formatFechas(){
        	
        	var mesesLetras = [];
        	
        	mesesLetras ["Jan"] = "01";
        	mesesLetras ["Feb"] = "02";
        	mesesLetras ["Mar"] = "03";
        	mesesLetras ["Apr"] = "04";
        	mesesLetras ["May"] = "05";
        	mesesLetras ["Jun"] = "06";
        	
        	mesesLetras ["Jul"] = "07";
        	mesesLetras ["Ago"] = "08";
        	mesesLetras ["Sep"] = "09";
        	mesesLetras ["Oct"] = "10";
        	mesesLetras ["Nov"] = "11";
        	mesesLetras ["Dec"] = "12";        	
        	
        	var fechaInicialLarga = document.getElementsByName('fechaInicial')[0].value;
        	
        	var fechaFinalLarga = document.getElementsByName('fechaFinal')[0].value;
        	
        	if (fechaInicialLarga.length == 28) {
        		
        		var mesLetra = fechaInicialLarga.substring(4, 7);	
        		
        		var mes = mesesLetras[mesLetra];
        		
        		var dia = fechaInicialLarga.substring(8, 10);
        		
        		var anho = fechaInicialLarga.substring(24, 28);
             		 
        		document.getElementsByName('fechaInicial')[0].value = '' + dia + '/' + mes + '/' + anho + '';
        	} 
       	
        	if (fechaFinalLarga.length == 28) {
 
        		var mesLetra = fechaFinalLarga.substring(4, 7);	
        		
        		var mes = mesesLetras[mesLetra];
        		
        		var dia = fechaFinalLarga.substring(8, 10);
        		
        		var anho = fechaFinalLarga.substring(24, 28);        		
        		
        		document.getElementsByName('fechaFinal')[0].value = '' + dia + '/' + mes + '/' + anho + '';
        	}        
        
        	
        	
        }
        
        </script>

        
    </head>
    <body onload="formatFechas()">
       <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
    				
       <form action="<c:url value="/app/consultaReporteTramitesController"/>" method="post" name="w01">
        <spring:nestedPath path="criteriosConsulta">  			
    		
                <table cellpadding="0" cellspacing="2" width="1150">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Consulta General de Tr&aacute;mites</strong></td>
                        </tr>
                		<tr>
                			<td class="labelRow" nowrap width="15%">
                				Fecha Inicial:&nbsp;
                			</td>
                			 
                	        <td class="fieldRow" width="35%">
                				<spring:bind path="fechaInicial" >
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
                			
 
 
                 			<td class="labelRow" nowrap width="15%">
                				Fecha Final:&nbsp;
                			</td>
                			 
                	        <td class="fieldRow" width="35%">
                				<spring:bind path="fechaFinal" >
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
                			
                			<td class="labelRow" nowrap width="15%">
                				Oficina:&nbsp;&nbsp;
                			</td>
                			
                			 <td class="fieldRow" nowrap width="35%">
                				<form:select  id="oficina"  cssClass="input" path="oficina" items="${listaOficinas}" itemLabel="nombre" 
                    			itemValue="idOficina"/>
                			</td>
                			
                			
                			
                			
                			
                			
                	</tr>
              
                	<tr>
                			<td class="labelRow" style="text-align: center" colspan="6">
                					
                						<input type="button" value="Consultar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/app/consultaReporteTramitesController"/>">
				                         
				                         <input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  />
				                         
				                         
				                         </a>
				
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/"/>">
				                          <input type="button" class="input" value="Regresar" />
				                         </a>
                			
                			</td>
                		</tr> 
                		
                		<tr>
                          <td>
                             <input type="hidden" name="formato" id="formato" value=""/>
                             <c:if test="${!empty resultado}">
                             	 <a href="javascript:excel();"><img border="0" src="<c:url value="/img/skin/excel.jpg"/>" width="40" title="Exportar Resultados a Excel"></img></a>
                                
                                <script type="text/javascript">
                                	function excel(){
                                		
                                		document.w01.formato.value = "xls";
                                		document.w01.submit();
                                		
                                	}
                                </script>  
                             </c:if> 
                             
                           </td> 
                         </tr>
                		
                	
                
                </table>  
                
                </div> 
              
                <div align="center" >
                    <table width="100%" border="0" cellpadding="5" cellspacing="1">
                       
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                           <td align="center" class="ContenTablaColor"><strong>Emisor</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Num. de Poliza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha del Tr&aacute;mite</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tr&aacute;mite Solicitado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tr&aacute;mite Final</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Sucursal</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tel&eacute;fono</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Comentarios Asegurado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Comentarios Asesor</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Observaciones</strong></td>
                            
                        </tr>

                         <c:forEach var="tramite" items="${resultado}">
                         <tr>
                           <td class="ContenTabla"><c:out value="${tramite.numConsignatario}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.numPoliza}"/></td>
                           <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${tramite.fecha}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.tipoTramiteInicial.nombre}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.tipoTramiteFinal.nombre}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.oficina.nombre}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.usuario}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.telefono}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.comentariosAsegurado}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.comentariosAsesor}"/></td>
                           <td class="ContenTabla"><c:out value="${tramite.observaciones}"/></td>     
                       
                         </tr>
                         </c:forEach>
                         
                        </table>




                </div>
                  	
    	
    	</spring:nestedPath>
      </form>			
    
    </body>
    
</html>