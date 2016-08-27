<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
                
        <title>P&oacute;liza Cancelada</title>
    </head>
    <body>
        <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <tag:errors name="datosPoliza"/>
        <spring:nestedPath path="datosPoliza">
            <form action="#" method="POST">
                
                <h2 align="center">Para cancelar la p&oacute;liza oprima el boton "Cancelar P&oacute;liza"</h2>
                <table width="450" border="0" align="center">
                    
                    <spring:bind path="polizaIndividual.numPoliza">                        
                        <input type="hidden" name="${status.expression}"  id="numPolizaFrm2" value="<%= request.getParameter("poliza")%>" class="input"/>    
                    </spring:bind>
                    <spring:bind path="polizaIndividual.numConsignatario">                        
                        <input type="hidden" name="${status.expression}"  id="numConsignatarioFrm2" value="<%= request.getParameter("numConsignatario")%>" class="input"/>    
                    </spring:bind>
                    
                    <tr align="center">
                        <td width="150" >
                            <div align="center">                                
                                <input type="submit" class="input" value="Cancelar Poliza" name="_finish"/>
                            </div>
                            
                        </td>
                    </tr>
                </table>
            </form>
        </spring:nestedPath>
    </body>
</html>