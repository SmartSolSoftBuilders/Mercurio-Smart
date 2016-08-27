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
        
        
        <!--agregue los nuevos campos del formulario-->
    
        


        
        <title>Consulta de p&oacute;lizas de seguro cargadas por archivo y pendientes de complementar</title>
        <script type="text/javascript" >
            function cambioPagina(pagina){
            
                document.forms[0].paginaActual.value = pagina;
                document.forms[0].submit();
            }

        </script>
   
   <style type="text/css">
   

div.fixedHeaderTable {
         position: relative;
}


div.fixedHeaderTable table {
    
    border-collapse: collapse;
    
}


div.fixedHeaderTable thead {
    
}


div.fixedHeaderTable tbody {
    
    overflow-y: auto;
    overflow-x: hidden;
}

div.fixedHeaderTable table th {
    
}

div.fixedHeaderTable table tr {
}
  

div.fixedHeaderTable table td {
   

}

 div.fixedHeaderTable thead td, div.fixedHeaderTable thead th {
     position:relative;
 }
   
   
   table#tablaResultados {
	overflow: auto;
	height: 800px; 
	}
	tr#m-header td {
	/*position: fixed*/
	}
   
   
   </style>
   
    </head>
        
    <body>
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <tag:errors name="datosPoliza"/>
        <spring:nestedPath path="consultaRegistrosPolizas">
            <!--tag:errors name="datosPoliza"/-->
            <!--spring:nestedPath path="datosPoliza"-->
            <div ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
            <form action="<c:url value="/app/consultarRegistrosPendientesArchivoPolizasController"/>" method="post" name="w01">
                <input type="hidden" name="_page0" value="0" />
                
                <div align="center" >
                	<table width="100%">
                		<tr>
                			<td>
                				<div id="title589x16" align="center" style="margin-left: auto;margin-right: auto" >P&oacute;lizas de seguro cargadas por archivo y pendientes de complementar</div>
               
                				<table width="100%" border="0" cellpadding="0" cellspacing="1">
			                		<tr align="left" valign="middle" height="20">
			                            <td colspan="80" class="TopTabla" align="center"><strong>Lista de Polizas pendientes<br/>Los siguientes registros fueron cargados desde el archivo de p&oacute;lizas de Inbursa y est&aacute; pendientes de complementar
			                        sus datos para terminar de ingresarlos al sistema</strong></td>
			                        </tr>
			                	</table>
                			</td>
                		</tr>
                		<tr>
                			<td>
                					<div class="">
                    <table width="100%" border="0" cellpadding="5" cellspacing="1" id="tablaResultados" style="height: 900px; overflow:scroll;">
                        
                      
                        <tr id="m-header">
                            <td class="ContenTablaColor" id="header1">&nbsp;</td>
                            <td align="center" class="ContenTablaColor" id="header2"><strong>Consignatario</strong></td>
                            <td align="center" class="ContenTablaColor" id="header3"><strong>Num. de Poliza</strong></td>
                            <td align="center" class="ContenTablaColor" id="header4"><strong>Folio de Solicitud</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Grupo Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Nombre Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>RFC Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. N&oacute;mina Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Nacimiento Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Nombre Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha de Carga</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Archivo</strong></td>
                        </tr>
                    
                        <tbody >
                        <c:forEach var="registroPoliza" items="${resultado.resultados}">
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
                                            <a
                                                href=
                                            "<c:url value="/app/capturaSolicitudController?folioSolicitud=${registroPoliza.folioSolicitud}&idRegistro=${registroPoliza.idRegistroArchivoPolizas}&numPoliza=${registroPoliza.numPoliza}&numConsignatario=${registroPoliza.numConsignatario}"/>">Complementar</a></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.numConsignatario}"/></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.numPoliza}"/></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.folioSolicitud}"/></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.nombreGrupoAsegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.apPaternoAsegurado}"/> <c:out value="${registroPoliza.apMaternoAsegurado}"/> <c:out value="${registroPoliza.nombre1Asegurado}"/> <c:out value="${registroPoliza.nombre2Asegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.RFCasegurado}"/></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.numNominaAsegurado}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registroPoliza.fechaNacimientoAsegurado}" /></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.apPaternoContratante}"/> <c:out value="${registroPoliza.apMaternoContratante}"/> <c:out value="${registroPoliza.nombre1Contratante}"/> <c:out value="${registroPoliza.nombre2Contratante}"/></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registroPoliza.fechaInicioVigencia}" /></td>
                                        <td class="ContenTabla"><fmt:formatDate pattern="dd/MM/yyyy" value="${registroPoliza.resumenCargaArchivoPolizas.fechaCarga}" /></td>
                                        <td class="ContenTabla"><c:out value="${registroPoliza.resumenCargaArchivoPolizas.nombreArchivo}"/></td>

                                
                                    </tr>

                        </c:forEach>
                      </tbody>
                        <tr>
                            <td colspan="80" align="left">

                                Total de registros: <c:out value="${resultado.totalResultados}"/><br/>
                                <c:if test="${resultado.paginaActual>1}"><a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual-1}"/>)" >&lt;</a></c:if> P&aacute;gina <c:out value="${resultado.paginaActual}"/> de <c:out value="${resultado.totalPaginas}"/>
                                 <c:if test="${resultado.paginaActual<resultado.totalPaginas}"><a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual+1}"/>)" >&gt;</a></c:if>
                                <input type="hidden" name="totalResultados" value="<c:out value="${resultado.totalResultados}"/>"/>
                                <input type="hidden" name="paginaActual" value="<c:out value="${resultado.paginaActual}"/>"/>
                                <input type="hidden" name="totalPaginas" value="<c:out value="${resultado.totalPaginas}"/>"/>
                               
                            </td>

                        </tr>
                        </table>
					</div>
                			
                			</td>
                		</tr>
                	
                	</table>
                	
                	
                	



                </div>
               
               
                
                <!--Seccion de poliza individual-->


                
                  
            </form>
            
        </spring:nestedPath>
        <script type="text/javascript">
        	//document.getElementById("header1").style.position = "fixed";
        	//document.getElementById("header2").style.position = "fixed";
        	//document.getElementById("header3").style.position = "fixed";
        </script>
    </body>
</html>
