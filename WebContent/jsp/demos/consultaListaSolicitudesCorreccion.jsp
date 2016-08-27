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
    
        


        
        <title>Consulta de Solicitudes de Correcci&oacute;n de Datos</title>
        
    </head>
        
    <body>
      
      
            
            
            <form action="<c:url value="/app/consultaGeneralSolicitudesController"/>" method="post" name="w01">
               
                
                <div id="title589x16" align="center" style="margin-left: auto;margin-right: auto" >Consulta de Solicitudes de Correcci&oacute;n de Datos</div>
                

                
                <div class="row660">
                   <span class="field588"  >
                     &nbsp;&nbsp; Mostrar: &nbsp;&nbsp;
                      		<select class="input">
                      			<option>Todos</option>
                      			<option>Aplicado</option>
                      			<option>Pendientes</option>
                      		</select>
                           
                        

                   </span>
                </div>
                 <div class="row660">
                   <span class="field588" style="text-align: left">
                      &nbsp;&nbsp;Filtrar por fecha de Solicitud etre: <input type="text"  id="fechaSolicitudFrm" 
	                            onClick=""
	                             size="11" tabindex="10" class="input" value=""/>
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaSolicitudFrm,'anchor17','dd/MM/yyyy'); return false;" 
	                             NAME="anchor17" ID="anchor17" TABINDEX="11">
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/></A>  
	                                 y 
	                                    <input type="text"  id="fechaSolicitudFrm" 
	                            onClick=""
	                             size="11" tabindex="10" class="input" value=""/>
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaSolicitudFrm,'anchor17','dd/MM/yyyy'); return false;" 
	                             NAME="anchor17" ID="anchor17" TABINDEX="11">
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A> 

                         
                           
                   </span>
                </div>
                 <div class="row660">
                     <span class="field588" style="margin-left: auto;margin-right: auto;text-align: center" >
                         <input type="button" value="Buscar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
                         &nbsp;
                         &nbsp;
                         &nbsp;
                         <a href="<c:url value="/app/consultaGeneralSolicitudesController"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>

                         &nbsp;
                         &nbsp;
                         &nbsp;
                         <a href="<c:url value="/"/>">
                          <input type="button" class="input" value="Regresar" />
                        </a>
                          
                     </span>
                </div>
                <div align="center" >
                    <table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:small;font-weight: bold;">

                                Total de registros: 34 --    P&aacute;gina 1 de 1
                                                                  
                              

                            </td>

                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                            <td class="ContenTablaColor">&nbsp;</td>
                            
                            	
                                                      
                            
                           <td align="center" class="ContenTablaColor"><strong>Folio y Formato Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>N&uacute;mero de P&oacute;liza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario Solicitante</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Motivo</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Estado</strong></td>
                          
<!--                            <td align="center" class="ContenTablaColor"><strong>Num. de Poliza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>                            -->
<!--                            <td align="center" class="ContenTablaColor"><strong>Seguimiento a P&oacute;liza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Pagos P&oacute;liza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Paquete</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Grupo Asegurado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Prima Mensual</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Escuela</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Sucursal</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Agente</strong></td>-->
                            
                            
                        </tr>
                        
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/></a>
										</td>
                                        <td class="ContenTabla">34485950 / 1-222</td>
                                        <td class="ContenTabla">9808998</td>
                                        <td class="ContenTabla">11/12/2011</td>
                                        <td class="ContenTabla">oGalvan</td>
                                        <td class="ContenTabla">Reclamaci&oacute;n por parte del aseguraddo</td>
                                        <td class="ContenTabla"><img border="0" src="<c:url value='/img/skin/onebit_36.png'/>" title="Pediente" width="24" height="24"/></td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/></a>
										</td>
                                        <td class="ContenTabla">34485950 / 1-222</td>
                                        <td class="ContenTabla">9808998</td>
                                        <td class="ContenTabla">11/12/2011</td>
                                        <td class="ContenTabla">oGalvan</td>
                                        <td class="ContenTabla">Reclamaci&oacute;n por parte del aseguraddo</td>
                                        <td class="ContenTabla"><img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="Aplicado" width="24" height="24"/></td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" title="Detalle" width="24" height="24"/></a>
										</td>
                                        <td class="ContenTabla">34485950 / 1-222</td>
                                        <td class="ContenTabla">9808998</td>
                                        <td class="ContenTabla">11/12/2011</td>
                                        <td class="ContenTabla">oGalvan</td>
                                        <td class="ContenTabla">Reclamaci&oacute;n por parte del aseguraddo</td>
                                        <td class="ContenTabla"><img border="0" src="<c:url value='/img/skin/onebit_33.png'/>" title="Rechazado" width="24" height="24"/></td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    

                      
                        
                    
                       
                        </table>




                </div>
            </form>
            
   
    </body>
    
</html>
