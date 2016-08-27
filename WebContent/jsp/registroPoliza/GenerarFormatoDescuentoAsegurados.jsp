<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>  
<%@page import="java.util.Map, java.util.HashMap"%>

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

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
    <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>">
    </script>
    
    <title>Generar formato para el registro de descuentos aplicados a los asegurados</title>
    
</head>


<body>
<jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
<tag:errors name="datosPoliza" />
<spring:nestedPath path="datosPoliza">
<form action="#" method="POST">
<table width="70" height="199" border="0" align="center">
    
    <tr>
        <div id="titleg664x16">Generar formato para el registro de descuentos aplicados a asegurados</div>
        
            <div class="row660">
                <label class="label330">Retenedor:&nbsp;&nbsp;</label>
                <span class="field330">                   
                    <spring:bind path="polizaIndividual.solicitud.empresa.grupoAsegurado.cveRetenedor">
                        <input type="hidden" name="${status.expression}"  id="cveRetenedorFrm" value="${status.value}"/>    
                    </spring:bind>
                    <input  type="text" class="input" name="nombreRetenedor" id="nombreRetenedorFrm" readonly/>&nbsp;
                        <a href="javascript:launch('buscarRetenedores','Listado de Retenedores -Seleccione un registro de la lista-','Clave del Retenedor:cveRetenedor:cveRetenedor:cveRetenedorFrm:t:t,Nombre:nombreRetenedor:nombreRetenedor:nombreRetenedorFrm:t:t','',500,550);" tabindex="2">
                        <img src="<c:url value="/"/>img/helper.png"/>
                    </a>
                </span>
            </div>
        
            <label class="label330">Quincena:&nbsp;&nbsp;</label>
            <span class="field330"> 
                <%
                        Map<String, Long> añoQuincenaOp = new HashMap<String, Long>();
                        añoQuincenaOp.put("2007", 2007L);
                        añoQuincenaOp.put("2008", 2008L);
                        añoQuincenaOp.put("2009", 2009L);
                        añoQuincenaOp.put("2010", 2010L);
                        añoQuincenaOp.put("2011", 2011L);
                        %>  
                        Año:
                        <spring:bind path="polizaIndividual.anoQuincena">                            
                            <select name="${status.expression}" class="select" tabindex="7">
                                <c:forEach var="añoQuincenaItem" items="<%=añoQuincenaOp%>">
                                    <option value="<c:out value='${añoQuincenaItem.value}'/>" 
                                            <c:if test="${status.value == añoQuincena.value}"> 
                                                selected="selected"                                            
                                            </c:if> 
                                    >
                                        <c:out value="${añoQuincenaItem.key}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </spring:bind>
                        <%
                        Map<String, Long> numQuincenaOp = new HashMap<String, Long>();
                        numQuincenaOp.put("01", 1L); numQuincenaOp.put("06", 6L);
                        numQuincenaOp.put("02", 2L); numQuincenaOp.put("07", 7L);
                        numQuincenaOp.put("03", 3L); numQuincenaOp.put("08", 8L);
                        numQuincenaOp.put("04", 4L); numQuincenaOp.put("09", 9L);
                        numQuincenaOp.put("05", 5L); numQuincenaOp.put("10", 10L);
                        numQuincenaOp.put("11", 11L); numQuincenaOp.put("16", 16L);
                        numQuincenaOp.put("12", 12L); numQuincenaOp.put("17", 17L);
                        numQuincenaOp.put("13", 13L); numQuincenaOp.put("18", 18L);
                        numQuincenaOp.put("14", 14L); numQuincenaOp.put("19", 19L);
                        numQuincenaOp.put("15", 15L); numQuincenaOp.put("20", 20L);
                        numQuincenaOp.put("21", 21L); numQuincenaOp.put("22", 22L);
                        numQuincenaOp.put("23", 23L); numQuincenaOp.put("24", 24L);
                       
                        %>   
                        N&uacute;mero:
                        <spring:bind path="polizaIndividual.numQuincena">                            
                            <select name="${status.expression}" class="select" tabindex="7" sorted="true">
                                <c:forEach var="numQuincenaItem" items="<%=numQuincenaOp%>">
                                    <option value="<c:out value='${numQuincenaItem.value}'/>" 
                                            <c:if test="${status.value == numQuincena.value}"> 
                                                selected="selected"                                            
                                            </c:if> 
                                    >
                                        <c:out value="${numQuincenaItem.key}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </spring:bind>
            </span>
       
        
            <span>
            
            <div align="center" class="submit664">
                <input type="submit"class="input" name="_finish" value="Generar Formato"/>
                <a href="<c:url value="/"/>app/logoutcontroller">
                    <input type="button" class="input"  value="Salir" />
                </a>
            </div>
        </span>
</tr>
</table>

</form>
</spring:nestedPath>
</body>
</html>
