<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <title>Ticket de Correcci&oacute;n Registrado</title>
    </head>
    <body>
         <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <h2 align="center" class="Estilo1">${mensaje}</h2>
        <table width="320" border="0" align="center">
             <tr align="center">
                 <td width="150" >
                     <div align="center">
                         <a href="javascript:window.close();">
                            <input type="button" class="input" value="Cerrar" />
                         </a>
                     </div>
                 </td>
               
                 
                 
             </tr>
         </table>
        
        
      
    </body>
</html>
