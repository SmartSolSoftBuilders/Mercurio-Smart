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
        <title>Registro de p&oacute;lizas emitidas entregadas a los agentes </title>
       <style type="text/css">
<!--
#Layer1 {
    width:300px;
    height:380px;
    overflow: scroll;
    background-color: #DBE8F9;
    letter-spacing: normal;
    vertical-align: baseline;
    word-spacing: normal;
    white-space: normal;
    display: list-item;
    border-top-style: solid;
    border-right-style: solid;
    border-bottom-style: solid;
    border-left-style: solid;
}
form{
    width:400px;
}

.field {
	height: 31px;
	display: block;
	float: left;
	margin: 0;
	margin-right: 2px;
	background: url(<c:url value="/"/>img/bg_textfieldspan3.gif) no-repeat;
}

#title {
	height: 16px;
	color: #5A698B;
	font: bold 11px/18px "Lucida Grande", "Trebuchet MS", Arial, Helvetica, sans-serif;
	margin-bottom: 2px;
	background: transparent url("<c:url value="/"/>img/bg_legendg2.gif") no-repeat;
	text-transform: uppercase;
	text-align: center;
}
#titleTabla {
	height: 16px;
	color: #5A698B;
	font: bold 9px/14px "Lucida Grande", "Trebuchet MS", Arial, Helvetica, sans-serif;
	margin-bottom: 3px;
	background: transparent url("<c:url value="/"/>img/bg_legendg.gif");
    width: 700px;
	text-transform: uppercase;
	letter-spacing: 2px;
	text-align: center;
}
-->
        </style>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>">
        </script>
        <script>
            function validaChecks(){
                if(document.forms[0].polizaSeleccionada.length==undefined && document.forms[0].polizaSeleccionada.value!=null){
                    checks=1;
                }else{
                    var checks=document.forms[0].polizaSeleccionada.length;
                }
                var checks=document.forms[0].polizaSeleccionada.length
                var cont=0;
                if(checks==1){
                    if(document.forms[0].polizaSeleccionada.checked){
                        cont=1;
                    }
                }else{
                    for (var x=0; x < checks; x++) {
                        if (document.forms[0].polizaSeleccionada[x].checked) {
                            cont = cont + 1;
                        }
                    }
                }
                if(cont>0)
                    return true;
                else
                    return false;
            }
            
            function enviaAgente(valor,agente){
                document.location.href='polizaEntregadaEmitidaAgente?opcion='+valor+'&agente='+agente;
            }
            
            function actualizaEstatus(valor){
                if(validaChecks()){
                    document.forms[0].action='polizaEntregadaEmitidaAgente?opcion='+valor;
                    document.forms[0].submit();
                }else
                    alert("No selecciono ninguna poliza");
            }
        </script>
    </head>
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <center>
        <form name="formulario" action="#" method="post">
            <table border="0" width="400" align="center">
                <tr id="title" width="400" align="center">
                    <td colspan="4">Registro p&oacute;lizas emitidas entregadas a agentes</td>
                </tr>
                <tr class="field" width="400">
                    <td width="120">Clave del Agente:</td>
                    <td width="140"><input type="text" name="Agente" id="Agente" class="input"></td>
                    <td width="140">
                        <a href="javascript:launch('buscarAgentes','Listado de Agentes -Seleccione un registro de la lista-','ID Agente: :cveAgente:Agente:t:t,1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f, Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f','',550,650);">
                            <img src="<c:url value="/"/>img/helper.png"/>
                        </a>
                    </td>
                </tr>
                <tr class="field">
                    <td col="3" width="400" align="center">
                        <input type="button" name="consulta" value="Consultar" class="input" onclick="javascrip:enviaAgente(1,Agente.value)">
                    </td>
               </tr>
            </table>
            <%! java.util.List datos=null;%>
            
            <%datos= (java.util.List)request.getAttribute("listaValores");
                if(datos!=null){%>
                <div id="Layer1">
                    <table border="1">
                         <tr id="titleTabla">
                            <td>Plaza</td>
                            <td>Num. Certif</td>
                            <td>Num. Poliza</td>
                            <td><input type="checkbox" checked="true" name="polizaSeleccionada" value="0" class="input" disabled></td>
                        </tr>
                                              
                        <%
                        for(int i=0;i<datos.size();i++)
                        {
                        mx.com.seguros.model.PolizaIndividual datosAux=(mx.com.seguros.model.PolizaIndividual)datos.get(i);
                        %>
                        
                        <tr>
                            <td><%= datosAux.getCvePlaza() %></td>
                            <td><%= datosAux.getNumCertificado() %></td>
                            <td><%= datosAux.getNumPoliza() %></td>
                            <td><input type="checkbox" name="polizaSeleccionada" value="<%= datosAux.getNumPoliza()%>,<%= datosAux.getNumConsignatario()%>" class="input"></td>
                        </tr>
                        
                        <%}%>
                    </table>
                </div>    
            <%}%>
                <table width="200" border="0">
                <tr class="field" >
                    <td width="100" align="center">
                        <input type="button" name="opciones" value="Aceptar" onclick="actualizaEstatus(2)" class="input">
                    </td>
                    <td width="100" align="center">
                        <a href="<c:url value="/"/>app/logoutcontroller">
                            <input type="button" value="Salir" class="input" />
                        </a>
                    </td>
                </tr>
                </table>
           </form>
        </center>
    </body>
</html>
