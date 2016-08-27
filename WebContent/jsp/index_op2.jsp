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
      function obtenerEstatusPolizaAdminController(){
         document.location.href='<c:url value="/"/>app/obtenerEstatusPolizaAdmin';
      }
       
    </script>
</head>
<body>
<h2>Bienvenido(a): <%= SecurityContextHolder.getContext().getAuthentication().getName() %></h2>
<p align="center">
<img alt="Logo Estrategas" src="<c:url value="/img/estrategas.png"/>">

<table width="605" border="0" align="center" bgcolor="#DDDDDD">
    <td width="599"><table width="590" border="0" align="center" bordercolor="#DDDDDD" bgcolor="#aaaaaa">
            <tr align="center">
            <td width="177" ><div align="center">
                    <input name="button2" type="button" 
                           onclick="obtenerEstatusPolizaAdminController();" 
                           value="Registrar entrega de p&oacute;lizas"/>
            </div></td>
    </tr>
    </table></td>

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