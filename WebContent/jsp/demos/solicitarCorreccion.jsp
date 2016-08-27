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


        
        <title>Solicitar Correcci&oacute;n de Datos</title>
        
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
                <div id="titleg664x16">Solicitar Correcci&oacute;n de Datos</div>
               
                <div class="row660">
                	<table cellpadding="0" cellspacing="2" width="100%" style="line-height:normal;">
                		<tr>
                			<td class="labelRow">
                				Usuario que solicita:
                			</td>
                			<td class="fieldRow" >
                				<input type="text" class="inputInfo" readonly value="oGutierrez"/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Motivo de la Solicitud:
                			</td>
                			<td class="fieldRow" >
                				<textarea rows="4" cols="45" class="textarea"></textarea>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Estado de la Solicitud:
                			</td>
                			<td class="fieldRow" >
                				<input type="text" value="Nueva" class="inputInfo" readonly/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de la Solicitud:
                			</td>
                			<td class="fieldRow" >
                				<input type="text" value="23/12/2012" class="inputInfo" readonly/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Comentarios sobre la solicitud:
                			</td>
                			<td class="fieldRow" >
                				<table cellpadding="2" cellspacing="0" width="100%">
                					<tr>
                						<td valign="top">
                							<b>nGomez</b>:<br/>23/12/2012 16:34
                						</td>
                						<td valign="top">
                							Se requiere que el asegurado entre la documentaci&oacute;n requerida para completar la correcci&oacute;n a su p&oacute;liza.
                						</td>
                					</tr>
                					<tr>
                						<td colspan="2"><hr/></td>
                					</tr>
                					<tr>
                						<td valign="top">
                							<b>oGutierrez</b>:<br/>23/12/2012 18:34
                						</td>
                						<td valign="top">
                							Se solicita al asegurado y entrega los documentos requeridos.
                						</td>
                					</tr>
                					<tr>
                						<td colspan="2"><hr/></td>
                					</tr>
                					<tr>
                						<td  valign="top">
                						 &nbsp;
                						</td>
                						<td>
                							<textarea rows="3" cols="45" class="textarea"></textarea>
                							<br/>
                							<input type="button" onclick="" value="Agregar Comentario" class="input"/>
                						</td>
                					</tr>
                				</table>
                			</td>
                		</tr>
                	</table>
                </div>
                <div id="titleg664x16">Datos de la Solicitud</div>
                <div class="row660">
                	<table cellpadding="0" cellspacing="2" width="100%">
                		<tr>
                			<td class="labelRow">
                				&nbsp;
                			</td>
                			<td class="fieldRow">
                				&nbsp;&nbsp;Valor Actual
                			</td>
                			<td class="fieldRow" >
                				&nbsp;&nbsp;Seleecione nuevo valor (si aplica)
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Clave Agente:
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="20" class="inputInfo" value="1 - Gerardo Garduño" readonly/>
                				
                			</td>
                			<td class="fieldRow">
                				<input type="text" size="20" class="input"/>
                    			<a href="javascript:launch('buscarAgentes','Listado de Agentes -Seleccione un registro de la lista-','ID Agente: :cveAgente:cveAgenteFrm:t:t,1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f, Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f','',700,700);" tabindex="2">
                                <img src="<c:url value="/"/>img/helper.png" alt="Buscar Agentes"/></a>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Tipo de Solicitud:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="radio" name="rd" class="inputInfo" checked="checked" readonly/> Normal 
                    			<input type="radio" name="rd" class="inputInfo" readonly/> Por contrato
                    			
                			</td>
                			<td class="fieldRow">
                				<input type="radio" name="rd"/> Normal <input type="radio" name="rd"/> Por contrato
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Folio:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="10" class="inputInfo" value="332443" readonly/>
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="10" class="input"/>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				N&uacute;mero de Formato:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="10" class="inputInfo" value="11-22" readonly/>
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="10" class="input"/>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Prima Quincenal:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" class="inputAlert" name="importeTarifaFrm"  id="importeTarifaFrm" size="10"
                    			value="360.00"
                    			/>
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" class="input" name="importeTarifaFrm"  id="importeTarifaFrm" size="10"
                    			value="450.00"
                    			/>
                    			<a href="javascript:launch('buscarTarifas','Tarifas -Seleccione un registro de la lista-','No.: :cveTarifa:cveTarifaFrm:f:t,Importe:importeTarifa:importeTarifa:importeTarifaFrm:t:t','',500,730);" tabindex="7">
                            <img src="<c:url value="/"/>img/helper.png" alt="Buscar Tarifas" />
                        </a>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Clave Promotor:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" class="inputInfo" name="importeTarifaFrm"  id="importeTarifaFrm" size="25"
                    			value="110677 - Huicochea y SAV, Agente de Seguros, SA de CV" readonly/>
                    			
                    			
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" class="input" name="importeTarifaFrm"  id="importeTarifaFrm" size="25"
                    			value=""/>
                    			<a href="javascript:launch('buscarTarifas','Tarifas -Seleccione un registro de la lista-','No.: :cveTarifa:cveTarifaFrm:f:t,Importe:importeTarifa:importeTarifa:importeTarifaFrm:t:t','',500,730);" tabindex="7">
                            <img src="<c:url value="/"/>img/helper.png" alt="Buscar Tarifas" />
                        </a>
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de la Solicitud:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text"  id="fechaSolicitudFrm" 
	                            onClick="" value="17/12/2011" readonly
	                             size="11" tabindex="10" class="inputInfo"/>
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text"  id="fechaSolicitudFrm" 
	                            onClick="" value="" readonly
	                             size="11" tabindex="10" class="input"/>
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaSolicitudFrm,'anchor17','dd/MM/yyyy'); return false;" 
	                             NAME="anchor17" ID="anchor17" TABINDEX="11">
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A> 
                    			
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha de producci&oacute;n:
                			</td>
                			<td class="fieldRow">
                				
                				<input type="text"  id="fechaSolicitudFrm" 
	                            onClick=""
	                             size="11" tabindex="10" class="inputInfo" value="17/12/2011"/>
                			</td>
                			<td class="fieldRow">
                				
                				<input type="text"  id="fechaSolicitudFrm" 
	                            onClick=""
	                             size="11" tabindex="10" class="input" value=""/>
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaSolicitudFrm,'anchor17','dd/MM/yyyy'); return false;" 
	                             NAME="anchor17" ID="anchor17" TABINDEX="11">
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A> 
                    			
                			</td>
                		</tr>
                	</table>
                	
                </div>
                <div id="titleg664x16">Datos del contratante</div>
                <div class="row660">
                	<table cellpadding="0" cellspacing="2" width="100%">
                		<tr>
                			<td class="labelRow">
                				&nbsp;
                			</td>
                			<td class="fieldRow">
                				&nbsp;&nbsp;Valor Actual
                			</td>
                			<td class="fieldRow" >
                				&nbsp;&nbsp;Seleecione nuevo valor (si aplica)
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				No. emp. (13 D&iacute;gitos):
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="15" class="inputAlert" id="rfc" name="rfc" 
                    			value="HERE821227Q12"
                    			readonly
                    			/>
                    			
                			</td>
                			<td class="fieldRow">
	                			<input type="text" size="15" class="input" id="rfc" name="rfc" value="HERE901227U12"
	                    			/>
                				 <input type="button" value="Consultar registros previos" class="input" tabindex="9" id="validarFrm"
                         	  onclick="javascript:launch('buscarPolizasAnteriores','Polizas anteriores -Seleccione el resultado mostrado-','Plaza: :cvePlaza:cvePlazaFrm:t:f, Certificado: :numCertificado:numCertificadoFrm:t:t, Tarifa: :solicitud.tarifa.importeTarifa:importeTarifaFrm:t:f, Estatus segun pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:t:f','numNominaContratante:'+document.getElementById('numNominaContratanteFrm').value,400,600);"
                        		/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Paterno:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="25" class="inputAlert" id="rfc" name="rfc" 
                    			value="HERNANDEZ" readonly
                    			/>
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value="HERRERA"
                    			/>
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Materno:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="inputAlert" id="rfc" name="rfc" 
                    			value="RODRIGUEZ" readonly	/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value="ROLDAN" 	/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Primer Nombre:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="inputAlert" id="rfc" name="rfc" 
                    			value="EMIGDIO" readonly/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value="ERNESTO"/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Segundo Nombre:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="inputInfo" id="rfc" name="rfc" 
                    			value="" readonly/> 
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value=""/>
                			</td>
                		</tr>
                	</table>
                
                </div>
                <div id="titleg664x16">Datos del solicitante</div>
                <div class="row660">
                	<table cellpadding="0" cellspacing="2" width="100%">
                		<tr>
                			<td class="labelRow">
                				&nbsp;
                			</td>
                			<td class="fieldRow">
                				&nbsp;&nbsp;Valor Actual
                			</td>
                			<td class="fieldRow" >
                				&nbsp;&nbsp;Seleecione nuevo valor (si aplica)
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				No. emp.:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="15" class="inputInfo" id="rfc" name="rfc" 
                    			value="HERE821227Q12" readonly/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="15" class="input" id="rfc" name="rfc" 
                    			value=""/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Paterno:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="25" class="inputInfo" id="rfc" name="rfc" 
                    			value="HERNANDEZ" readonly
                    			/>
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			
                    			/>
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Apellido Materno:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="inputInfo" id="rfc" name="rfc" 
                    			value="RODRIGUEZ" readonly	/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value="" 	/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Primer Nombre:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="inputInfo" id="rfc" name="rfc" 
                    			value="EMIGDIO" readonly/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value=""/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Segundo Nombre:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="inputInfo" id="rfc" name="rfc" 
                    			value="" readonly/> 
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="25" class="input" id="rfc" name="rfc" 
                    			value=""/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Fecha Nacimiento:
                			</td>
                			<td class="fieldRow">
                    			<input type="text"  id="fechaSolicitudFrm" 
	                            onClick="" value="12/12/2011" readonly
	                             size="11" tabindex="10" class="inputInfo"/>
	                            
                			</td>
                			<td class="fieldRow">
                    			<input type="text"  id="fechaSolicitudFrm" 
	                            onClick="" value="" 
	                             size="11" tabindex="10" class="input"/>
	                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaSolicitudFrm,'anchor17','dd/MM/yyyy'); return false;" 
	                             NAME="anchor17" ID="anchor17" TABINDEX="11">
	                                <img src="<c:url value="/"/>img/calendario3.png" alt="Calendario"/>
	                            </A> 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Puesto:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="15" class="inputInfo" id="rfc" name="rfc" 
                    			value="MAESTRO" readonly/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="15" class="input" id="rfc" name="rfc" 
                    			value=""/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Ingreso Mensual:
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="15" class="inputInfo" id="rfc" name="rfc" 
                    			value="2,500" readonly/>
                			</td>
                			<td class="fieldRow">
                    			<input type="text" size="15" class="input" id="rfc" name="rfc" 
                    			value=""/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Sexo:
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="radio" id="sexo" checked="checked"/>Masculino <input type="radio" id="sexo"/>Femenino
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<input type="radio" id="sexo" />Masculino <input type="radio" id="sexo"/>Femenino
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow">
                				Estado Civil:
                			</td>
                			<td class="fieldRow">
                				
                    			<select class="inputInfo" readonly>
                    				<option>Soltero</option>
                    				<option>Casado</option>
                    				<option>Divorciado</option>
                    				<option>Uni&oacute;n Libre</option>
                    			</select>
                    			 
                			</td>
                			<td class="fieldRow">
                				
                    			<select class="input">
                    				<option>Soltero</option>
                    				<option>Casado</option>
                    				<option>Divorciado</option>
                    				<option>Uni&oacute;n Libre</option>
                    			</select>
                    			 
                			</td>
                		</tr>
                		<tr>
                			<td colspan="3" class="labelRow" style="text-align: center">
                				<input type="button" value="Guardar Solicitud" class="input"/>
                				&nbsp; ( <input type="button" value="Aplicar" class="input"/>
                						<input type="button" value="Rechazar" class="input"/> )
                				<input type="button" value="Cancelar" class="input"/>
                			</td>
                		</tr>
                	</table>
                
                </div>
            </form>
            
   
    </body>
    
</html>
