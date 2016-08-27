<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <title>Generaci&oacute;n de reporte exitoso</title>
    </head>
    <body>
        
        <h2 align="center" class="Estilo1">La operaci&oacute;n se realiz&oacute; correctamente</h2>
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
                        <a href="<c:url value="/"/>app/generarPagoComisionesController">
                            <input type="button" class="input" value="Generar nuevos Reportes" />
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
            </tr><tr height="20"></tr>
            <tr align="center">
                <td width="150" >
                    <div align="center">
                        <a href="<c:url value="/reportes/${ReportesPDF.rutaVista}" /> ">
                          Descargar Reportes de Pago de Comisiones Generados
                        </a>
                    </div>
                    
                </td>
     
            </tr>
            
        </table>
      </body>
</html>