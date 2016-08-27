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
        <title>Operaci&oacute;n incorrectaorrecta</title>
    </head>
    <body>
        
        <h2 align="center" class="Estilo1">El archivo no fue cargado, revise que los datos sean correctos</h2>
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
            
        </tr>
        </table>
    </body>
</html>
