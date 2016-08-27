<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>">
        </script>
        
        <title>Generar formato de aplicaci&oacute;n de descuentos</title>
        
    </head>
    
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <tag:errors name="datosPoliza" />
        <spring:nestedPath path="datosPoliza">
            <form action="#" method="POST">
                <input type="hidden" name="_page1" value="1" />
                
                <tr >
                    <div id="titleg664x16">Generar formato de aplicacion de descuentos</div>
                </tr>
                <tr>
                <td height="160">
                    <table width="70" height="1" border="0" align="center">
                    <div class="row660">
                        <label class="label330">Introduzca el n&uacute;mero de p&oacute;liza:&nbsp;&nbsp;</label>
                        
                        <span class="field330">                   
                            <spring:bind path="polizaIndividual.numPoliza">
                                <input type="text" name="${status.expression}"  id="numPolizaFrm" value="${status.value}" class="input"/>    
                            </spring:bind>
                        </span>
                        
                        <label class="label330">Introduzca el n&uacute;mero de consignatario:&nbsp;&nbsp;</label>
                        
                        <span class="field330">                   
                            <spring:bind path="polizaIndividual.numConsignatario">
                                <input type="text" name="${status.expression}"  id="numConsignatarioFrm" value="${status.value}" class="input"/>    
                            </spring:bind>
                        </span>
                    </div>
                    
                    
                    
                    <tr>
                    
                    <div align="center" class="submit664">
                        <input type="submit"class="input" name="_finish" value="Generar Reporte" />
                        <a href="<c:url value="/"/>app/logoutcontroller">
                            <input type="button" class="input"  value="Salir" />
                        </a>
                        
                    </div>
                    
                    
                </table>
                </td>
                </tr>
                
                
            </form>
        </spring:nestedPath>
    </body>
</html>
