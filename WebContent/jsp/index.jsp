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
       
    </head>
  
    
    <body>
   
    <jsp:include page="menu.jsp"></jsp:include>
        <h2 align="right">Bienvenido(a): <%= SecurityContextHolder.getContext()!=null && SecurityContextHolder.getContext().getAuthentication()!=null?
        		SecurityContextHolder.getContext().getAuthentication().getName():"" %>&nbsp;&nbsp;&nbsp;&nbsp;</h2>
        <p align="center">
        <img alt="Logo Estrategas" src="<c:url value="/img/estrategas.png"/>">
        <table width="846" border="0" align="center" bgcolor="">
            <tr>
                <td width="840">
                
                	 
                
                </td>
            </tr>
        </table>
       
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        
    </body>
</html>