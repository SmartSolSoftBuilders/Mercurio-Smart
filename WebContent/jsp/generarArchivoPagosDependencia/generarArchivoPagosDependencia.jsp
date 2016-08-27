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
                else if(archivo.lastIndexOf(".xls")<0){
                    alert("El archivo que selecciono no tiene extensión .xls");
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
    </head>
    <body onsubmit="procesando()">
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <form action="cargaArchivo" method="POST"  enctype="multipart/form-data" id="formulario" onsubmit="return valida()">
            
                <%try{
               String error=request.getAttribute("Error").toString();
                if(!error.isEmpty()){
            %>
            <script>
                       alert("La carga del archivo ya fue realizada en otro momento por lo que no se realizara nuevamente");
            </script>
            <%}
               
           } catch(NullPointerException er){}%>
            
         <%try{
               String error=request.getAttribute("Error2").toString();
                if(!error.isEmpty()){
            %>
            <script>
                       alert("El archivo contiene valores que no son de tipo numerico.No se realizara la carga");
            </script>
            <%}
               
           } catch(NullPointerException er){}%>
         
            <table width="250">
                <div id="titleg664x16">Generar hoja de calculo del archivo de pagos por dependencia</div>
                
                
                <tr width="250" class="field296" align="center">
                    <div align="center" class="submit664">
                    <input type="file" name="file" class="input" size="70">
                    </div>
                    
                </tr>
                <tr width="250" class="field296" align="center">
                    <div align="center" class="submit664">
                        <input type="submit" name="enviar" value="Enviar" class="input">
                        <a href="<c:url value="/"/>app/logoutcontroller">
                            <input type="button" value="Salir" class="input"/>
                        </a>
                    </div>
                </tr>
                
            </table>
            <div id="img" style="visibility:hidden">
                    <img src="<c:url value="/img/procesando.gif"/>">
                </div> 
        </form>
    </body>
</html>
