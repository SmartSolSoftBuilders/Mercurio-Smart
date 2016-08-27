<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <script language="JavaScript" 
                src="<c:url value="/js/calendario.js" />">
        </script>
        <script language="JavaScript" 
                src="<c:url value="/js/AnchorPosition.js"/>">
        </script>
        <script language="JavaScript" 
                src="<c:url value="/js/date.js"/>">
        </script>
        <script language="JavaScript" 
                src="<c:url value="/js/PopupWindow.js"/>">
        </script>
        <script language="JavaScript" 
                src="<c:url value="/js/GUIHelper.js"/>">
        </script>
        <script language="JavaScript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
        </script>
        
        <title>Registro de p&oacute;lizas emitidas entregadas a los agentes </title>
       <style type="text/css">
<!--
#Layer1 {
    width:800px;
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
    width:700px;
	text-transform: uppercase;
	letter-spacing: 2px;
	text-align: center;
}
-->
        </style>
        
        
        <script type="text/javascript">
            
            function validaForm(){
                var checks=document.forms[0].polizaSeleccionada.length;
                var nombres=document.forms[0].nombre.length;
                var fechas=document.forms[0].fecha.length;
                var count;
                var bandera=true;
                if(validaChecks()){
                
                    for(var x=1;x < checks; x++){
                        if(document.forms[0].polizaSeleccionada[x].checked){
                            if(document.forms[0].nombre[x].value!=""){
                                if(document.forms[0].fecha[x].value!=""){
                                    count=1;
                                }else{
                                    alert("No se registro la fecha en que se entrego la póliza "+document.forms[0].polizaSeleccionada[x].value);
                                    return false;
                                }
                            }
                            else{
                                alert("No se registro el nombre de quien recibio la póliza "+document.forms[0].polizaSeleccionada[x].value);
                                return false;
                            }
                        }
                    }
                }else{
                    alert("No ha seleccionado ninguna póliza");
                    return false;
                    }
                return bandera=true;
            }
            
            
            function validaChecks(){
                if(document.forms[0].polizaSeleccionada.length==undefined && document.forms[0].polizaSeleccionada.value !=null){
                    checks=1;
                }else{
                    var checks=document.forms[0].polizaSeleccionada.length;
                }
                var cont=0;
                
               for (var x=1; x < checks; x++) {
                    if (document.forms[0].polizaSeleccionada[x].checked) {
                        cont = cont + 1;
                    }
                }
                if(cont>0)
                    return true;
                else
                    return false;
            }
            
            function consultaAgente(agente){
                document.location.href='emitidasEntregadasAsegurados?opcion=1&agente='+agente;
            }
            
                                
            function actualizaEstatus(valor){
                if(validaForm()){
                    document.forms[0].action='emitidasEntregadasAsegurados?opcion='+valor;
                    document.forms[0].submit();
                }
            }
        </script>
        
    </head>
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <div
            ID="testdiv1"
            STYLE="
                position:absolute;
                left:auto;
                visibility:hidden;
                background-color:white;">
            </div>
        <form name="formulario" action="#" method="POST">
            <table border="0" width="400" align="center">
                <tr id="title" width="400" align="center">
                    <td colspan="4">Registro p&oacute;lizas emitidas entregadas a agentes</td>
                </tr>
                <tr class="field">
                    <td width="120">Clave del Agente:</td>
                    <td width="140"><input type="text" name="Agente" id="Agente" class="input"></td>
                    <td width="140">
                        <a href="javascript:launch('buscarAgentes','Listado de Agentes -Seleccione un registro de la lista-','ID Agente: :cveAgente:Agente:t:t,1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f, Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f','',550,600);">
                            <img src="<c:url value="/"/>img/helper.png"/>
                        </a>
                    </td>
                </tr>
                <tr class="field">
                    <td col="3" width="400" align="center">
                        <input type="button" name="consulta" value="Consultar" class="input" onclick="consultaAgente(Agente.value)">
                    </td>
                </tr>
                <tr></tr>
                <tr class="field" >
                <tr id="title" width="600">
                    <td colspan="4">P&oacute;lizas por entregar</td>
                </tr>
                </table>
                <div class="row660" align="center">&nbsp;</div>
            <%! java.util.List datos=null;%>
            
            <%datos=(java.util.List)request.getAttribute("listaValores");
                
                if(datos!=null){%>
                <div id="Layer1">
                    <table border="1">
                       <tr id="titleTabla">
                            <td>Plaza</td>
                            <td>N&uacute;m. Certif.</td>
                            <td>N&uacute;m. P&oacute;liza </td>
                            <td>Nombre del asegurado </td>
                            <td><input type="checkbox" name="polizaSeleccionada" checked="true"   class="input">
                                <input type="hidden" name="hiddenPoliza" value="0" class="input" >
                            </td>
                            <td>Nombre de quien recibe<input type="hidden" name="nombre" value="0" class="input" ></td>
                            <td>Fecha de recepci&oacute;n <input type="hidden" name="fecha" value="00/00/0000" class="input" ></td>
                            <td></td>
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
                            <td><%=datosAux.getAsegurado().getNombre1Asegurado() %>
                                <% if (datosAux.getAsegurado().getNombre2Asegurado()!=null){%>
                                    <%=datosAux.getAsegurado().getNombre2Asegurado() %>
                                <%}%>
                                <%= datosAux.getAsegurado().getApPaternoAsegurado()%>
                                <%= datosAux.getAsegurado().getApMaternoAsegurado()%>
                            </td>
                            <td><input type="checkbox" name="polizaSeleccionada" value="<%= i%>" class="input">
                                <input type="hidden" name="hiddenPoliza" value="<%= datosAux.getNumPoliza()%>,<%= datosAux.getNumConsignatario()%>">
                            </td>
                            <td><input type="text" name="nombre" class="input" onChange="javascript:this.value=this.value.toUpperCase();"></td>
                            <td>
                                <input type="text" name="fecha" class="input" id="Texto<%= i%>">
                            </td>
                            <td>
                                <A HREF="#" onClick="cal18.select(document.forms[0].Texto<%= i%>,'Date<%= i%>','dd/MM/yyyy'); return false;" NAME="Date<%= i%>" ID="Date<%= i%>">
                                    <img src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </td>
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
    </body>
</html>
