<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <title>Operaci&#243;n correcta</title>
    </head>
    <body>
        
        <h2 align="center" class="Estilo1">
        <c:out value="${error}" />
        </h2>
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
                    <a href="<c:url value="/"/>app/cargaArchivoDescuento">
                        <input type="button" class="input" value="Cargar nuevo Archivo" />
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
        
        <tr align="center">
            <td width="150" >
                <div align="center">
                <!-- TODO - To Add qnaNum to rejected's file -->
	                <a href="<c:url value='<%="/reportes/Archivos/ArchivoRechazos" + request.getAttribute("numQna") + ".xls"%>' /> ">
                        Ver Archivo de Rechazos
                    </a>
                </div>
                
            </td>
        </tr>
        </table>
    </body>
</html>
