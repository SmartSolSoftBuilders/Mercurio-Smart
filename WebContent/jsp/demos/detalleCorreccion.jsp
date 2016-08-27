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


        
        <title>Detalle de Solicitud de Correcci&oacute;n de Datos</title>
        
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
	width: 527px;
	min-height: 31px;
	
	
	margin: 0;
	
	margin-bottom: 2px;
	background-color: #C3D5EF;
	//background-position: right;
	//background: url(../img/bg_field296.gif) no-repeat;
}
        </style>
        
    </head>
        
    <body>
      
      
            
            
            <form action="<c:url value="/app/consultaGeneralSolicitudesController"/>" method="post" name="w01">
                <div id="titleg664x16">Solicitud de Correcci&oacute;n de Datos</div>
                <div id="title430x16">
                    &nbsp;
                </div>
                <div id="titleg664x16">Datos de la Solicitud</div>
                <div class="row660">
                	<table cellpadding="2" cellspacing="2">
                		<tr>
                			<td class="labelRow">
                				Clave Agente:
                			</td>
                			<td class="fieldRow">
                				<font style="font-weight: bold;">1 - Gerardo Garduño</font><br/>
                    			<font color="green" style="font-weight: bold; font-size: x-small;" ><b>1 - Gerardo Garduño</b></font>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Tipo de Solicitud:
                			</td>
                			<td class="fieldRow">
                				Normal
                				                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Folio:
                			</td>
                			<td class="fieldRow">
                				11524546
                    			
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				N&uacute;mero de Formato:
                			</td>
                			<td class="fieldRow">
                				FF-2030
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Prima Quincenal:
                			</td>
                			<td class="fieldRow">
                				$ 360.00<br/>
                    			<font color="green" style="font-weight: bold; font-size: x-small;" ><b>$ 450.00</b></font>
                        </a>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Clave Promotor:
                			</td>
                			<td class="fieldRow">
                				110677 - Huicochea y SAV, Agente de Seguros, SA de CV
                        </a>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de la Solicitud:
                			</td>
                			<td class="fieldRow">
                				17/12/2011<br/>
                				<font color="green" style="font-weight: bold; font-size: x-small;" ><b>17/12/2011</b></font>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de producci&oacute;n:
                			</td>
                			<td class="fieldRow">
                				17/12/2011                    			
                			</td>
                		</tr>
                	</table>
                	
                </div>
               
            </form>
            
   
    </body>
    
</html>
