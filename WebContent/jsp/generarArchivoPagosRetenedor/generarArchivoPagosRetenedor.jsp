<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<html>
    <head>
        <title>Generar hoja de calculo del archivo de pagos por dependencia</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <style type="text/css">
            form{
            }
            
            .field {
            height: 31px;
            display: block;
            float: left;
            margin: 0;
            margin-right: 2px;
            background: url(<c:url value="/"/>img/bg_textfieldspan3.gif) no-repeat;
            }
        </style>
        <script type="text/javascript">
            function valida(){
                var archivo=document.forms[0].file.value;
                if(archivo==""){
                    alert("No selecciono un archivo");
                    return false;
                    }
                else if(archivo.lastIndexOf(".txt")<0){
                    alert("El archivo que selecciono no tiene extensión .txt");
                    return false;
                    }
                else
                    return true;
            }
        </script>
        <script language="JavaScript" type="text/javascript"> 
            function procesando(){ 
                document.getElementById('img').style.visibility = "visible"; 
            } 
        </script>
        <script language="JavaScript">
        function getFolder(){
            return showModalDialog("generarArchivoPagosRetenedor/folderDialog.jsp","","width:400px;height:400px;resizeable:yes;");
        }
        </script>
    </head>
    <body onsubmit="procesando()">
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <form action="generarArchivoPagosRetenedorController" method="post" name="w01" enctype="multipart/form-data">
        <div id="titleg664x16">Generar hoja de calculo del archivo de pagos por dependencia</div>
            
	                    <div align="center" class="submit664">
	                    <label>Introduzca la ruta del archivo de pagos ubicado en el servidor</label>
	                    </div>
	             
                    <div align="center" class="submit664">
                    	<spring:bind path="command.file">
                		<input type="file" name="${status.expression }" id="${status.expression }" size="70" align="center" class="input">
                		</spring:bind>
                    </div>
              
                    <div align="center" class="submit664">                        
                       <input type="submit" value="Enviar"class="input" name="_finish"/>
                        <a href="<c:url value="/"/>app/logoutcontroller">
                            <input type="button" value="Salir" class="input"/>
                        </a>
                    </div>
               
            <div id="img" style="visibility:hidden">
                    <img src="<c:url value="/img/procesando.gif"/>">
            </div> 
        </form>
    </body>
</html>
