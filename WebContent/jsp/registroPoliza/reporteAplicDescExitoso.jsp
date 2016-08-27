<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <title>Reporte generado con &eacute;xito</title>
    </head>
    <body>
        <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <h2 align="center" class="Estilo1">El reporte se realiz&oacute; correctamente</h2>
        <table width="450" border="0" align="center">
            <tr align="center">
                <td width="150" >
                    <div align="center">
                        <a href="<c:url value="/"/>app/logoutcontroller">
                            <input type="button" class="input" value="Salir" />
                        </a>
                    </div>
                </td>
                <td width="150" >
                    <div align="center">
                        <a href="<c:url value="/"/>app/consultaPolizaController">
                            <input type="button" class="input" value="Generar otro Reporte" />
                        </a>
                    </div>
                </td>
                <td width="150" >
                    <div align="center">
                        <a href="<c:url value="/"/>">
                            <input type="button" value="Inicio" class="input"/>
                        </a>   
                    </div>
                    
                </td>
            </tr>
            <div class="row660" align="center">&nbsp;</div>
            <tr align="center">
                <td width="150" >
                    <div align="center">
                        <a href="<c:url value='/reportes/${ReportesPDF.rutaFormatoAplicacionDescuentos2}'/> ">
                            Ver Reporte Final
                        </a>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>