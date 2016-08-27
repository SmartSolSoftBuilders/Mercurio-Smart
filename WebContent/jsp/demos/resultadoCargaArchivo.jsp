<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/calendario.js" />">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/AnchorPosition.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/date.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/PopupWindow.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/GUIHelper.js"/>">
        </script>
        
        <!--agregue los nuevos campos del formulario-->
    
         <script language="JavaScript" type="text/javascript">
         
         	function cambioCampo(campo,valorOrig){
         		if(campo.value == valorOrig){
         			campo.style.color="grey";
             		campo.style.backgroundColor="#D7E5F2";
         		}else{
         			campo.style.color="black";
             		campo.style.backgroundColor="cyan";
         		}
         		
         	}
                
         	function quitarValor(campo,valorOrig){
         		if(campo.value == valorOrig){
         			campo.value = "";
         		}
         		
         	}
         	function retornarValor(campo,valor){
         		if(campo.value==""){
         			campo.value = valor;
         		}
         		cambioCampo(campo,valor);
         	}
        </script>


        
        <title>Resultado de Carga de Archivo de P&oacute;lizas de Inbursa</title>
        
        <style type="text/css">
        	.labelRow{
				text-align: right;
				width: 135px;
				min-height: 31px;
				margin: 0;
				
				margin-right: 2px;
				margin-bottom: 2px;
				background-color: #C3D5EF;
				//background-position: left;
				//background: url(../img/bg_labels.gif) no-repeat;
			}
			.fieldRow {
				width: 262px;
				min-height: 31px;
				
				
				margin: 0;
				
				margin-bottom: 2px;
				background-color: #C3D5EF;
				//background-position: right;
				//background: url(../img/bg_field296.gif) no-repeat;
			}
			.inputInfo {
				 font: 9px Verdana, Geneva, Arial, Helvetica, sans-serif;
				 background-color: #D7E5F2;
				 color: grey;
				 margin: 4px 0 5px 8px;
				 
			}
			.inputAlert {
				 font: 9px Verdana, Geneva, Arial, Helvetica, sans-serif;
				 background-color: #96BC5D;
				 color: black;
				 margin: 4px 0 5px 8px;
			}





        </style>
        
    </head>
        
    <body>
      
      
            
            
            <form action="<c:url value="/app/consultaGeneralSolicitudesController"/>" method="post" name="w01">
                <div id="titleg664x16">Resultado de Carga de Archivo de P&oacute;lizas de Inbursa</div>
               
                <div class="row660">
                	<table cellpadding="4" cellspacing="2" width="100%" >
                		<tr>
                			<td class="labelRow">
                				Fecha:
                			</td>
                			<td class="fieldRow" >
                				<b>12/12/2012 14:34</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Archivo:
                			</td>
                			<td class="fieldRow" >
                				<b>polizas_inbursa_3343243.txt</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Usuario:
                			</td>
                			<td class="fieldRow" >
                				<b>masterDir</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Total de Registros:
                			</td>
                			<td class="fieldRow" >
                				<b>115</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Registros V&aacute;lidos:
                			</td>
                			<td class="fieldRow" >
                				<b>110</b>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Registros Inv&aacute;lidos:
                			</td>
                			<td class="fieldRow" >
                				<b>5</b>
                			</td>
                		</tr>
                		<tr>
                			<td colspan="2" class="fieldRow" style="text-align: center">
                				<input type="button" value="Regresar" class="input"/>
                				<input type="button" value="Ver Detalle" class="input"/>
                			</td>
                		</tr>
                	</table>
                </div>
                
            </form>
            
   
    </body>
    
</html>
