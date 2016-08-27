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
    
    <title>Generar Archivo para Alta de Asegurados</title>
    
</head>


<body>
 <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
<tag:errors name="movimientosDependencia" />
<spring:nestedPath path="movimientosDependencia">
<form action="generarReporteAltaAseguradoController" method="post" name="w01">
<div align="center">
    <input type="hidden" name="_page0" value="0" />
    <!--input type="hidden" name="_target1" value="true" /-->
</div>
<table width="70" height="199" border="0" align="center">
    
    <tr>
        <div id="titleg664x16">Generar Archivo para Alta de Asegurados</div>
        
            <div class="row660">
                <label class="label330">Retenedor:&nbsp;&nbsp;</label>
                <span class="field330">                                       
                        <input type="hidden" name="cveRetenedor"  id="cveRetenedorFrm"/>                        
                    <input  type="text" class="input" name="siglasRetenedor" id="siglasRetenedorFrm" readonly />&nbsp;
                        <a href="javascript:launch('buscarRetenedoresMovDep','Listado de Retenedores -Seleccione un registro de la lista-','Clave Descuento:cveDescuento:cveDescuento:cveDescuentoFrm:t:f,Nombre:nombreRetenedor:nombreRetenedor:nombreRetenedorFrm:t:f,cveRetenedor:cveRetenedor:cveRetenedor:cveRetenedorFrm:f:t, SiglasRetenedor: :siglasRetenedor:siglasRetenedorFrm:f:t','',500,550);" tabindex="2">
                        <img src="<c:url value="/"/>img/helper.png"/>
                    </a>
                </span>
            </div>        
               
            <div align="center" class="submit664">
                <input type="submit" value="Generar archivo" id="Save" width="52" height="19" border="0" class="input" name="_finish"/>
                <a href="<c:url value="/"/>app/logoutcontroller">
                    <input type="button" class="input"  value="Salir" />
                </a>
                <a href="<c:url value="/"/>">
                    <input type="button" value="Inicio" class="input"/>
                </a>                
            </div>
        </tr>
    </table>

</form>
</spring:nestedPath>
</body>
</html>
