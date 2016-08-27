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
    
        

 		<script type="text/javascript" >
            function regresar(){
            	document.location.href = '<c:url value="/app/consultarArchivosPolizasCargadosController"/>';
            }
            
			function filtrarResultados(idEstado){
				document.location.href = 
					'<c:url value="/app/consultarDetalleArchivoPolizasController"/>?idResumenCargaArchivoPolizas=${idResumenCargaArchivoPolizas}'+
					'&idEstadoRegistroPoliza='+idEstado;
			}
			function eliminar(id){
				if(confirm("¿Está seguro que desea eliminar este registro?")){
					document.w01.idEliminar.value = id;
					document.w01.submit();
				}
				
				
			}

        </script>
        <title>Detalle de Registros Cargados por Archivo de P&oacute;lizas de Inbursa</title>
        <script type="text/javascript" >
            

        </script>
   
  
   
    </head>
        
    <body>
        
        <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
     
            <div ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
            <form action="#" method="post" name="w01">
                <input type="hidden"  name="idEliminar" id="idEliminar"/>                
                <div align="center" >
                	<table width="589%">
                		<tr>
                			<td>
                				<div id="title589x16" align="left"  >Detalle de Registros Cargados por Archivo de P&oacute;lizas de Inbursa</div>
               					
               					<table cellpadding="4" cellspacing="2" width="589" >
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
                				
                			</td>
                		</tr>
                	</table>
				                
				               
                				<table width="100%" border="0" cellpadding="0" cellspacing="1">
			                		<tr align="left" valign="middle" height="20">
			                            <td colspan="80" class="TopTabla" align="center"><strong>
												Registros cargados
										</strong></td>
			                        </tr>
			                	</table>
                			</td>
                		</tr>
                		<tr>
                			<td>
                					<div class="">
                    <table width="100%" border="0" cellpadding="5" cellspacing="1"  >
                 
                        <tr >
                            <td class="ContenTablaColor" id="header1">&nbsp;</td>
                            
                            <td align="center" class="ContenTablaColor" ><strong>Folio Solicitud</strong></td>
                            <td align="center" class="ContenTablaColor" ><strong>Num. de Poliza</strong></td>
                            <td align="center" class="ContenTablaColor" ><strong>Grupo Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Paterno Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Materno Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Primer Nombre Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Segundo Nombre Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>RFC Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. N&oacute;mina Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Nacimiento Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Cve. Sexo Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Es Fumador Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Cve. Estado Civil Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Calle</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. Exterior</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. Interior</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Cod. Postal</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Colonia</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Entidad Federativa</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Delegaci&oacute;n / Mpio.</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Paterno Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Materno Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Primer Nombre Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Segundo Nombre Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Emisor</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>CIS</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Suma Asegurada Individual</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>BAF</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>BITP</strong></td>
	                        <td align="center" class="ContenTablaColor"><strong>DIPM</strong></td>
	                        <td align="center" class="ContenTablaColor"><strong>DIPMC</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>SEVI</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Gastos Funerarios</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>CPF</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Paquete</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Plazo</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Importe Tarifa</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Promotor</strong></td>
                            <td class="ContenTablaColor" id="header1">&nbsp;</td>
                            
                            
                            
                        </tr>
                       	<c:forEach items="${listaRegistrosArchivo}" var="registro">
                       		<tr >
                            <td class="ContenTabla" > 
                            	<c:if test="${registro.idEstadoRegistroPoliza == 1}">
                            		<img border="0" src="<c:url value='/img/skin/onebit_36.png'/>" title="Pendiente" width="24" height="24"/>
                            	</c:if>
                            	<c:if test="${registro.idEstadoRegistroPoliza == 2}">
                            		<img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="Procesado" width="24" height="24"/>
                            	</c:if>
                            	<c:if test="${registro.idEstadoRegistroPoliza == 3}">
                            		<img border="0" src="<c:url value='/img/skin/onebit_33.png'/>" title="Inv&aacute;lido" width="24" height="24"/>
                            	</c:if>
                            
                            
                            </td>
                            <td  class="ContenTabla" ><strong>${registro.folioSolicitud}</strong></td>
                            <td  class="ContenTabla" nowrap valign="middle"> <strong>${registro.numPoliza} <c:if test="${registro.capturada}"> <img border="0" align="middle" src="<c:url value='/img/skin/onebit_48.png'/>" title="Ya capturada en sistema" width="18" height="18"/> </c:if></strong></td>
                            <td  class="ContenTabla" ><strong>${registro.nombreGrupoAsegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.apPaternoAsegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.apMaternoAsegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.nombre1Asegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.nombre2Asegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.RFCasegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.numNominaAsegurado}</strong></td>
                            <td  class="ContenTabla" nowrap><strong ><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaNacimientoAsegurado}" /></strong></td>
                            <td  class="ContenTabla"><strong>${registro.cveSexoAsegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.esFumadorAsegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.cveEstadoCivilAsegurado}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.calle}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.numExterior}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.numInterior}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.codPostal}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.colonia}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.entidadFederativa}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.delegacionMpio}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.apPaternoContratante}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.apMaternoContratante}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.nombre1Contratante}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.nombre2Contratante}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.numConsignatario}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.agrupacionCIS}</strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaInicioVigencia}" /></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaSolicitud}" /></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaAseguradaIndividual}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaBAF}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaDI}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaPM}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaBITP}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaSEVI}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaGastosFunerarios}"/></strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.sumaCPF}"/></strong></td>
                            <td  class="ContenTabla"><strong>${registro.nombrePaquete}</strong></td>
                            <td  class="ContenTabla"><strong>${registro.plazoSeguro}</strong></td>
                            <td  class="ContenTabla" nowrap><strong><fmt:formatNumber pattern="$ #,##0.00" value="${registro.importeTarifa}"/></strong></td>
                            <td  class="ContenTabla"><strong>${registro.cvePromotor}</strong></td>
                            <td  class="ContenTabla" ><a href="javascript:eliminar('${registro.idRegistroArchivoPolizas}');"><img border="0" src="<c:url value='/img/skin/onebit_32.png'/>" title="Eliminar" width="24" height="24"/></a></td>
                        </tr>
                       	</c:forEach>
                         
                                          
                    
                      
                        </table>
					</div>
                			
                			</td>
                		</tr>
                	
                	</table>
                	
                	
                	



                </div>
               
               
                
             


                
                  
            </form>
            
       
     
    </body>
</html>
