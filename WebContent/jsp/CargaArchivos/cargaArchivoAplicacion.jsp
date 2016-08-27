<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Cargar archivo de aplicación de pagos a pólizas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
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
            		'<c:url value="/app/consultarArchivoAplicacionCargadoController"/>?idArchivosAplicacionCargados='+id;
            }
            
            
        </script>
    </head>
    <body >
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <form action="cargaArchivoAplicacionController" method="POST"  enctype="multipart/form-data" id="formulario" onsubmit="return valida()">
            
                <%try{
               String error=request.getAttribute("Error").toString();
                if(!error.isEmpty()){
            %>
            <script type="text/javascript" >
                       alert("La carga del archivo ya fue realizada en otro momento por lo que no se realizara nuevamente");
            </script>
            <%}
               
           } catch(NullPointerException er){}%>
            
         <%try{
               String error=request.getAttribute("Error2").toString();
                if(!error.isEmpty()){
            %>
            <script type="text/javascript" >
                       alert("El archivo contiene valores que no son de tipo numerico.No se realizara la carga");
            </script>
            <%}
               
           } catch(NullPointerException er){}%>
         
           
             <c:if test="${not empty error }">
              <div align="center" class="submit664">
	                   <span style="color:red;font-weight: bold;font-size: x-small; margin: 10px">
	                		${error }
	                	</span>
	          </div>
	                	<br/>
	               </c:if>
           
          
	        <div id="titleg664x16">Cargar Archivo de Aplicaci&oacute;n de Pagos</div>
	               
	             
	                
	                
	                
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
            	 <c:if test="${empty listaArchivosAplicacion}">
            	 	<table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td align="center" class="ContenTablaColor"><strong>
                                No existen archivo de aplicaci&oacute;n cargados todav&iacute;a.
                                </strong>
                           </td>

                        </tr>
                    </table>
            	 </c:if>
           	 	<c:if test="${not empty listaArchivosAplicacion}">
                    <table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:x-small;font-weight: bold;">
                                Total de registros: ${fn:length(listaArchivosAplicacion)}
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
                           <td align="center" class="ContenTablaColor"><strong>Quincena</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Total Registros</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Carga</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Fin Carga</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Bit&aacute;cora</strong></td>
                            
                        </tr>
                        <c:forEach items="${listaArchivosAplicacion}"  var="resumen">
                        	<tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="javascript:verDetalle('${resumen.idArchivosAplicacionCargados}')" title="Detalle">
	                                        <img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/>
	                                        </a>
										</td>
                                        <td class="ContenTabla"><fmt:formatDate value="${resumen.fechaCarga}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                                        <td class="ContenTabla">${resumen.username}</td>
                                        <td class="ContenTabla">${resumen.nombreArchivo}</td>
                                        <td class="ContenTabla">${resumen.numQuincena}</td>
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
