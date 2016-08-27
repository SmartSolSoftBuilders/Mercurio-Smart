<%@page import="mx.com.seguros.web.seguridad.util.SeguridadUtil"%>
<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%--
========================================================
views should be stored under the web-inf folder so that
they are not accessible except through controller process

this jsp is here to provide a redirect to your controller
servlet but should be the only jsp outide of the web-inf
========================================================
--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
    <script type="text/javascript">
      function capturaSolicitudController(){
         document.location.href='<c:url value="/"/>app/capturaSolicitudController'
      }
      function registroPolizaController(){
         document.location.href='<c:url value="/"/>app/registroPolizaController'
      }
      function consultaPolizaAdminController(){
         document.location.href='<c:url value="/"/>app/consultaPolizaController'
      }
      
      function obtenerEstatusPolizaOp1Controller(){
         document.location.href='<c:url value="/"/>app/obtenerEstatusPolizaOp1';
      }
      function consultarRegistrosArchivoPoliza(){
          document.location.href='<c:url value="/app/consultarRegistrosPendientesArchivoPolizasController" />';
      }
      function consultaGeneralSolicitudes(){
          document.location.href = '<c:url value="/app/consultaGeneralSolicitudesController"/>';
      }
      
      function consultarTicketsCorreccion(){
          document.location.href = '<c:url value="/app/consultarTicketsCorreccion"/>';
      }
      
      
      
     
           
    </script>
   
</head>
<body>






<h2>Bienvenido(a): <%= SecurityContextHolder.getContext().getAuthentication().getName() %></h2>
<p align="center">
<img alt="Logo Estrategas" src="<c:url value="/img/estrategas.png"/>">
<table width="631" border="0" align="center" bgcolor="#DDDDDD">
    
    <td width="625"><table width="618" height="32" border="0" align="center" bordercolor="#DDDDDD" bgcolor="#aaaaaa">
            <tr align="center">
                <td width="320"> <input name="button4" type="button" 
                                            onClick="javascript:capturaSolicitudController()" 
                                        value="Captura de Solicitudes" /></td>
                
                <td width="288"><input name="button5" type="button"
                                           onclick="javascript:registroPolizaController()" 
                                       value="Captura de P&oacute;lizas" /></td>
            </tr>
    </table></td>
    
</table>
<table width="632" border="0" align="center" bgcolor="#DDDDDD">
    <td><table width="617" border="0" align="center" bordercolor="#DDDDDD" bgcolor="#aaaaaa">
            <tr align="center">                
            <td width="321"><input name="button" type="button"
                                       onclick="javascript:consultaPolizaAdminController()"
                                   value="Consulta de P&oacute;lizas"/></td>
            <td width="286"><input name="button2" type="button" 
                                       onclick="obtenerEstatusPolizaOp1Controller();" 
                                   value="Registrar entrega de p&oacute;lizas"/></td>
    </tr>
    </table></td>

</table>
<table width="632" border="0" align="center" bgcolor="#DDDDDD">
    <td><table width="617" border="0" align="center" bordercolor="#DDDDDD" bgcolor="#aaaaaa">
            <tr align="center">

            <td width="286"><input name="button3" type="button"
                                       onclick="consultarRegistrosArchivoPoliza();"
                                   value="P&oacute;lizas de seguro cargadas por archivo y pendientes de complementar"/></td>
    </tr>
    <tr align="center">

            <td width="286"><input name="button4" type="button"
                                       onclick="consultaGeneralSolicitudes();"
                                   value="Consulta General de Solicitudes"/></td>
    </tr>
    </table></td>

</table>
<table width="632" border="0" align="center" bgcolor="#DDDDDD">
   	<tr>
    	<td>
    	
    	<table width="617" border="0" align="center" bordercolor="#DDDDDD" bgcolor="#aaaaaa">
            <tr align="center">

            <td width="286"><input name="button4" type="button"
                                       onclick="consultarTicketsCorreccion();"
                                   value="Ver estado de tickets de correcci&oacute;n de datos"/></td>
    	</tr>
    
   	 </table>
    </td>
   </tr>

</table>
<p>&nbsp;</p>
<table width="200" border="0" align="center">
    <tr>
        <td><div align="center">
                <label>
                    <a href="<c:url value="/"/>app/logoutcontroller">
                        <input type="button" name="Submit" value="Terminar Sesi&oacute;n">
                    </a>
                </label>
        </div></td>
    </tr>
</table>

</body>

</html>