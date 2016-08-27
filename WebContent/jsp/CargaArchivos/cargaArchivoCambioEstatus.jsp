<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Cargar archivo para cambio de estatus de pólizas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
       
        <script type="text/javascript">
            function valida(){
                var archivo=document.forms[0].file.value;
                if(archivo==""){
                    alert("No selecciono un archivo");
                    return false;
                }
                else if(archivo.lastIndexOf(".xls")<0){
                    alert("El archivo que selecciono no tiene extensión .xls");
                    return false;
                }
                
                document.forms[0].submit();
                procesando();
            }
        </script>
        <script language="JavaScript" type="text/javascript"> 
            function procesando(){ 
                document.getElementById('img').style.visibility = "visible"; 
                document.getElementById('enviar').disabled = true;
            } 
            function verDetalle(id){
            	document.location.href = 
            		'<c:url value="/app/consultarArchivoCambioEstatusController"/>?idArchivosCambioEstatus='+id;
            }
            
            
        </script>
    </head>
    <body >
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <form action="cargaArchivoCambioEstatusPolizaController" method="POST"  enctype="multipart/form-data" id="formulario" onsubmit="return valida()">
            
                        
           
             <c:if test="${not empty error }">
              <div align="center" class="submit664">
	                   <span style="color:red;font-weight: bold;font-size: x-small; margin: 10px">
	                		${error }
	                	</span>
	          </div>
	                	<br/>
	               </c:if>
           
          
	        <div id="titleg664x16">Cargar Archivo Para el Cambio de Estatus de P&oacute;liza</div>
	               
	             
	                
	                    <div align="center" class="submit664">
	                   	Descargar Archivo de Muestra de Formato: 
	                   	<a href="<c:url value="/formatos/AcuseCaptura.xls"/>">Entrega de P&oacute;lizas al Asegurado</a> 
	                   		<a href="<c:url value="/formatos/EntregaPolizasAsesores.xls"/>">Entrega de P&oacute;lizas al Agente</a> 
	                    </div>
	                
	                    <div align="center" class="submit664">
	                    	<input type="file" name="file" class="input" size="70">
	                    </div>
                
                    <div align="center" class="submit664">
                        <input type="button" name="enviar" id="enviar" value="Enviar" class="input" onclick="valida();"/>
                        <a href="<c:url value="/"/>">
                            <input type="button" value="Salir" class="input"/>
                        </a>
                    </div>
                  
            <div id="img" style="visibility:hidden">
                <img alt="Procesando"  src="<c:url value="/img/procesando.gif"/>">
            </div> 
            <div align="center" >
            	 <c:if test="${empty listaArchivosCambioEstatus}">
            	 	<table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td align="center" class="ContenTablaColor"><strong>
                                No existen archivo de cambio de estatus cargados todav&iacute;a.
                                </strong>
                           </td>

                        </tr>
                    </table>
            	 </c:if>
           	 	<c:if test="${not empty listaArchivosCambioEstatus}">
                    <table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:x-small;font-weight: bold;">
                                Total de registros: ${fn:length(listaArchivosCambioEstatus)}
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
                           <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Carga</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Fin Carga</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Bit&aacute;cora</strong></td>
                            
                        </tr>
                        <c:forEach items="${listaArchivosCambioEstatus}"  var="resumen">
                        	<tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="javascript:verDetalle('${resumen.idArchivoTramitePoliza}')" title="Detalle">
	                                        <img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/>
	                                        </a>
										</td>
                                        <td class="ContenTabla"><fmt:formatDate value="${resumen.fechaCarga}" pattern="dd/MM/yyyy"/></td>
                                        <td class="ContenTabla">${resumen.usuario}</td>
                                        <td class="ContenTabla">${resumen.nombreArchivo}</td>
                                        <td class="ContenTabla">${resumen.numeroRegistros}</td>
                                        <td class="ContenTabla"><fmt:formatDate value="${resumen.fechaHoraInicio}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                        <td class="ContenTabla"><fmt:formatDate value="${resumen.fechaHoraFin}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                        <td class="ContenTabla">
											<textarea rows="4" cols="80">${resumen.log}</textarea>
										</td>
                                
                            </tr>
                        
                        </c:forEach>
                        
                                                                  

                      
                        
                    
                       
                        </table>
					</c:if>


                </div>
        </form>
    </body>
</html>
