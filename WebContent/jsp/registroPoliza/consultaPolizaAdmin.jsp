<%@page import="mx.com.seguros.web.reportes.GenerarReportesPolizaController"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        
        <script type="text/javascript"  language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script type="text/javascript"  language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-1.5.1.js"/>"></script>
        
        <!--agregue los nuevos campos del formulario-->
    
        <script language="JavaScript" type="text/javascript">
          
        
        	function seleccionarQuery(){
            var i, valorRadioButton;
            for (i=0;i<document.w01.tipoConsulta.length;i++){ 
                if (document.w01.tipoConsulta[i].checked) 
                    break; 
            }  
            configuracionCampos =   'Tipo Seg: :descripcionPaqueteVidadxn:tipoSeguroFrm:f:t,'+
			'ApPaternoAgente: :solicitud.empleado.apPaternoEmpleado:apPaternoEmpleadoFrm:f:t,'+
			'ApMaternoAgente: :solicitud.empleado.apMaternoEmpleado:apMaternoEmpleadoFrm:f:t,'+
			'PrimerNombreEmp: :solicitud.empleado.nombre1Empleado:nombre1EmpleadoFrm:f:t,'+
			'SegundoNombreEmp: :solicitud.empleado.nombre2Empleado:nombre2EmpleadoFrm:f:t,'+
			'Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,'+
			'CveAgente: :solicitud.agente.cveAgente:cveAgenteFrm:f:t,'+
			'Num. de Poliza: :numPoliza:numPolizaFrm2:f:t,'+
			'Num. de Poliza: :numPoliza:numPolizaFrm:t:t,'+
			'Emisor: :numConsignatario:numConsignatarioFrm:t:t,'+
			'Num Consignatario: :numConsignatario:numConsignatarioFrm2:f:t,'+
			'Clave Plaza: :solicitud.certificadoindividual.plaza.cvePlaza:cvePlazaFrm:t:t,'+
			'Num. de certificado ind: :solicitud.certificadoindividual.numCertificado:numCertificadoFrm:t:t,'+
			'Importe Tarifa: :solicitud.tarifa.descripcion:importeTarifaFrm:f:t,'+
			'Importe Individual: :solicitud.tarifa.importePrimaInd:importePrimaIndFrm:f:t,'+
			'Importe Colectivo: :solicitud.tarifa.importePrimaColectiva:importePrimaColectivaFrm:f:t,'+
			'Estatus de poliza en pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:f:t,'+
			'Estatus de la Poliza: :estatusPolizaSeguimiento.descripcionEstatusPoliza:descripcionEstatusPolizaFrm:f:t,'+
			'Fecha Inicio Vigencia: :fechaInicioVigencia:fechaInicioVigenciaFrm:t:t,'+
			'Fecha Fin Vigencia: :fechaFinVigencia:fechaFinVigenciaFrm:t:t,'+
			'Fecha De Expedicion: :fechaExpedicion:fechaExpedicionFrm:t:t,'+
			'RFC (asegurado): :asegurado.RFCasegurado:RFCaseguradoFrm:t:t,'+
			'Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,'+
			'Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,'+
			'Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,'+
			'Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,'+
			'Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,'+
			'Fecha de nacimiento: :asegurado.fechaNacimientoAsegurado:fechaNacimientoAseguradoFrm:f:t,'+
			'Suma asegurada colectiva: :solicitud.tarifa.primaMensualSeguroColectivo.sumaAseguradaColectiva:sumaAseguradaColectivaFrm:f:t,'+
			'Ap. Paterno (contratante): :solicitud.contratante.apPaternoContratante:apPaternoContratanteFrm:f:t,'+
			'No. de empleado: :solicitud.contratante.numNominaContratante:numNominaContratanteFrm:f:t,'+
			'Ap. Materno (contratante): :solicitud.contratante.apMaternoContratante:apMaternoContratanteFrm:f:t,'+
			'Primer Nombre (contratante): :solicitud.contratante.nombre1Contratante:nombre1ContratanteFrm:f:t,'+
			'Segundo Nombre (contratante): :solicitud.contratante.nombre2Contratante:nombre2ContratanteFrm:f:t,'+
			'TipoMovPoliza: :tipoMovimientoPoliza:tipoMovimientoPolizaFrm:f:t,'+
			'Suma SEVI: :sumaSEVI:sumaSEVIFrm:f:t,'+
			'Suma Gastos Funerarios: :sumaGastosFunerarios:sumaGastosFunerariosFrm:f:t,'+
			'Suma BAF: :sumaBAF:sumaBAFFrm:f:t,'+
			'Suma Beneficios: :montoCoberturaBeneficios:montoCoberturaBeneficiosFrm:f:t,'+
			'Folio Solicitud: :solicitud.folioSolicitud:folioSolicitud:f:t,'+
			'Formato Solicitud: :solicitud.formatoSolicitud:formatoSolicitud:f:t';

                  
            valorRadioButton = document.w01.tipoConsulta[i].value;
            if (valorRadioButton==1){ 
            launch('seleccionarPolizaNumeroCertificado','Lista de Polizas -Seleccione un registro de la lista-',configuracionCampos,'numCertificado:'+document.getElementById('paramConsultaFrm').value,1600,600,'calcularTotalProteccion');
            return;
            }
    if (valorRadioButton==2){
            launch('seleccionarPolizaRFC','Lista de Polizas -Seleccione un registro de la lista-',configuracionCampos,'RFCasegurado:'+document.getElementById('paramConsultaFrm').value,1200,600,'calcularTotalProteccion');
              return;
            }
            if (valorRadioButton==3){
            launch('seleccionarPolizaApPaterno','Lista de Polizas -Seleccione un registro de la lista-',configuracionCampos,'apPaternoAsegurado:'+document.getElementById('paramConsultaFrm').value,1200,600,'calcularTotalProteccion');
                  return;
            }
            if (valorRadioButton==4){
            launch('seleccionarPolizaNum','Lista de Polizas -Seleccione un registro de la lista-',configuracionCampos,'numPoliza:'+document.getElementById('paramConsultaFrm').value,1200,600,'calcularTotalProteccion');
                  return;
            }
            if (valorRadioButton==5){
            launch('seleccionarPolizaNumContratante','Lista de Polizas -Seleccione un registro de la lista-',configuracionCampos,'numNominaContratante:'+document.getElementById('paramConsultaFrm').value,1200,600,'calcularTotalProteccion');
                  return;
            }
            if (valorRadioButton==6){
            launch('seleccionarPolizaApPaternoContratante','Lista de Polizas -Seleccione un registro de la lista-',configuracionCampos,'apPaternoContratante:'+document.getElementById('paramConsultaFrm').value,1200,600,'calcularTotalProteccion');
           // alert("gjhgjh1");
                  return;
            }
                   
           }
                                                   </script>
        <script language="JavaScript" type="text/javascript">
           function validaEstatusPoliza(){
            var param=document.w01.idEstatusPagosPolizaFrm.value;
           // alert(param);
                if(param >1){
                alert("A continuación de clic en el botón 'Generar Reporte Desc.' ");
                
                w01.val.type="hidden";
                w01.desc.type="submit";
                w01.val.disabled=true;
                            }
                            
                            else{alert("La póliza no cuenta aún con descuentos aplicados");}
            }

        </script>
        
        <script language="JavaScript" type="text/javascript">
        function concatenar(){
        
        var param=1;
        var param=2;
        var r=param1+param2;
        document.w01.nadaFrm.value=r;
        
       
        }
        
        
		function calcularTotalProteccion() {
        	
        	
            var sumind = toDecimal(document.w01.sumaAseguradaIndividualFrm.value);
            var sumcol = toDecimal(document.w01.sumaAseguradaColectivaFrm.value);
            var sumaSEVI = toDecimal(document.w01.sumaSEVIFrm.value);
            var sumaGastosFunerarios = toDecimal(document.w01.sumaGastosFunerariosFrm.value);
            var sumaBAF = toDecimal(document.w01.sumaBAFFrm.value);
            var montoCoberturaBeneficios = toDecimal(document.w01.montoCoberturaBeneficiosFrm.value);
          
            var tot=sumind+sumcol+sumaSEVI+sumaGastosFunerarios+sumaBAF+montoCoberturaBeneficios;
            document.w01.totalProteccionFrm.value = parseInt(tot);
            
            document.w01.totalProteccionFrm.value=formatMoneda(document.w01.totalProteccionFrm.value, 9);
            cambiarColor();
            cargarTarifas();
            cargarDetalleCalculo(document.w01.numPolizaFrm2.value,document.w01.numConsignatarioFrm2.value);
            cargarTramites(document.w01.numPolizaFrm2.value,document.w01.numConsignatarioFrm2.value);
            
        }
            
            function cambiarColor(){ 
                document.w01.totalProteccionFrm.style.backgroundColor="#ffefab"; 
                document.w01.importeTarifaFrm.style.backgroundColor="#ffefab";
                
            }
            
            

        </script>
        <script type="text/javascript" language="javascript">

function formatMoneda(num,longEntera, decSep,thousandSep) {
var arg;
var entero;

if(typeof(num) == 'undefined') return;
if(typeof(decSep) == 'undefined') decSep = '.';
if(typeof(thousandSep) == 'undefined') thousandSep = ',';

if(thousandSep == '.'){
arg=/\./g;
}else if(thousandSep == ','){
arg=/\,/g;
}

if(typeof(arg) != 'undefined'){
num = num.toString().replace(arg,'');
}

num = num.toString().replace(/,/g,'.');

if (num.indexOf('.') != -1)
{
entero = num.substring(0, num.indexOf('.'));
}
else entero = num;


if (entero.length > longEntera)
{
alert("El número introducido excede de " + longEntera + " digitos en su parte entera");
return "0,00";
}

if(isNaN(num))
num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();

if(cents<10)
cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3))+thousandSep+ num.substring(num.length-(4*i+3));
return (((sign)?'':'-') + num);
}


function abrirPopUpReporte(tipoReporte){

	numPoliza = document.getElementById("numPolizaFrm").value;
	numCertificado = document.getElementById("numCertificadoFrm").value;
	cvePlaza = document.getElementById("cvePlazaFrm").value;
	folioSolicitud = document.getElementById("folioSolicitud").value;
   	formatoSolicitud = document.getElementById("formatoSolicitud").value;
   	
    urlBase     = '<c:url value="/app/generarReportesPolizaController"/>';
    propiedades = 'width='+700+',height='+800+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes';
    params = 'numPoliza='+numPoliza+'&numCertificado='+numCertificado+'&cvePlaza='+cvePlaza+'&tipoReporte='+tipoReporte+
    '&folioSolicitud='+folioSolicitud+"&formatoSolicitud="+formatoSolicitud;;
    url    = urlBase + '?' + params;
   
    vent   = window.open(url, "detalle", propiedades);
    isOpen = true;
}

function generarCarta(){
	abrirPopUpReporte('<%= GenerarReportesPolizaController.CARTA_RESUMEN %>');
}

function generarAcuse(){
	abrirPopUpReporte('<%= GenerarReportesPolizaController.ACUSE_RECIBO %>');
}
function generarCertificado(){
	   abrirPopUpReporte('<%= GenerarReportesPolizaController.CERTIFICADO_INDIVIDUAL %>');
}

function  mostrarTarifas(campoRef){
	   tarifas =document.getElementById("historialTarifas");
	   if( tarifas.style.visibility == 'visible'){
		   tarifas.style.visibility = 'hidden';
		   return;
	   }
	   
	   
	   
	   tarifas.style.left = (getDimensions(campoRef).x+25) + "px";
	   tarifas.style.top = getDimensions(campoRef).y + "px";
	   tarifas.style.visibility = 'visible';
 }
 
 function ocultarTarifas(){
	   document.getElementById("historialTarifas").style.visibility = 'hidden';
 }
 getDimensions = function(oElement) {
	    var x, y, w, h;
	    x = y = w = h = 0;
	    if (document.getBoxObjectFor) { // Mozilla
	      var oBox = document.getBoxObjectFor(oElement);
	      x = oBox.x-1;
	      w = oBox.width;
	      y = oBox.y-1;
	      h = oBox.height;
	    }
	    else if (oElement.getBoundingClientRect) { // IE
	      var oRect = oElement.getBoundingClientRect();
	      x = oRect.left-2;
	      w = oElement.clientWidth;
	      y = oRect.top-2;
	      h = oElement.clientHeight;
	    }
	    return {x: x, y: y, w: w, h: h};
	 }
 
 function cargarTarifas(){
 	
 	$.ajax({
 		type: 'POST',
 		url: '<c:url value="/app/consultarTarifasController"/>',
 		data: 'folioSolicitud='+document.w01.folioSolicitud.value+'&formatoSolicitud='+document.w01.formatoSolicitud.value,
 		dataType: 'xml',
 		async: false,
 		success: function(xml){
 			conTarifas = false;
 			
 			$(xml).find('historicoTarifa').each(function(){
 				conTarifas = true;
 				
 			    $('#tablaTarifas').append(
 			    		'<tr>'+
 		    			'<td class="ContenTabla">' + 
 		    			$(this).find("importeTarifa").text() +
 		    			'</td>'+
 		    			'<td class="ContenTabla">'+
 		    				$(this).find("usuario").text()+
 		    			'</td>'+
 		    			'<td class="ContenTabla">'+
 		    			$(this).find("fecha").text()+
 		    			'</td>'+		    		    			
 		    		'</tr>');
 			    		
 			});
 			if(!conTarifas){
 				$('#tablaTarifas').append(
 						'<tr>'+
 		    			'<td class="ContenTabla" colspan="3" style="text-align: center">'+
 		    				'No existe informaci&oacute;n hist&oacute;rica de tarifas.'+
 		    			'</td>'+
 	    			'</tr>');
 			}
 		}
 		
 	});
 }


        </script>
        <script type="text/javascript" language="javascript">
			function cargarTramites(numPoliza,numConsignatario){
 	
			 	$.ajax({
			 			type: 'POST',
			 			url: '<c:url value="/app/consultarListaTramitesController"/>',
			 			data: 'numPoliza='+numPoliza+'&numConsignatario='+numConsignatario,
			 			dataType: 'xml',
			 			async: false,
			 			success: function(xml){
			 			conTramite = false;
			 			resultados = "";
			 			$(xml).find('tramitePoliza').each(function(){
			 				conTramite = true;
			 				resultados +=		
			 			'<tr>'+
							'<td class="ContenTabla">'+
							$(this).find("fecha").text()+
							'</td>'+
							'<td class="ContenTabla">'+
							$(this).find("tipoTramiteInicial").text()+
							'</td>'+
							'<td class="ContenTabla">'+
							$(this).find("tipoTramiteFinal").text()+
							'</td>'+
							'<td class="ContenTabla">'+
							$(this).find("oficina").text()+
							'</td>'+
							'<td class="ContenTabla">'+
							$(this).find("usuario").text()+
							'</td>'+
							'<td class="ContenTabla">'+
							$(this).find("telefono").text()+
							'</td>'+
						'</tr>'+
						'<tr>'+
							'<td class="ContenTabla" colspan="6">'+
								'Comentarios Asegurado:'+
							
									$(this).find("comentariosAsegurado").text()+
							'</td>'+
						'</tr>'+
						'<tr>'+
							'<td class="ContenTabla" colspan="6">'+
								'Comentarios Asesor:'+
							
									$(this).find("comentariosAsesor").text()+
							'</td>'+
						'</tr>'+
						'<tr>'+
							'<td class="ContenTabla"colspan="6">'+
								'Observaciones:'+
							
									$(this).find("observaciones").text()+
							'</td>'+
						'</tr>'+
						'<tr>'+
							'<td colspan="6" style="background-color: white;height: 3px"></td>'+
						'</tr>';		
		 		    		
		 		    		
		 		    		
		 		    		
			 			});
			 			if(!conTramite){
			 				$('#tablaTramites').append(
			 						'<tr>'+
			 		    			'<td class="ContenTabla" colspan="3" style="text-align: center">'+
			 		    				'No existen tr&aacute;mites relacionados a la p&oacute;liza.'+
			 		    			'</td>'+
			 	    			'</tr>');
			 			}else{
			 				$('#tablaTramites').append(
			 					'<tr>'+
									'<td class="ContenTablaColor">'+
									'	Fecha del Tr&aacute;mite'+
									'</td>'+
									'<td class="ContenTablaColor">'+
									'	Tr&aacute;mite Solicitado'+
									'</td>'+
									'<td class="ContenTablaColor">'+
									'	Tr&aacute;mite Final'+
									'</td>'+
									'<td class="ContenTablaColor">'+
									'	Sucursal'+
									'</td>'+
									'<td class="ContenTablaColor">'+
									'	Usuario'+
									'</td>'+
									'<td class="ContenTablaColor">'+
									'	Tel&eacute;fono'+
									'</td>'+
								'<tr/>'
			 				);
			 				$('#tablaTramites').append(resultados);
			 			}
			 		}
			 		
			 	});
		 }

		</script>       
        <title>Consulta de p&oacute;lizas de seguro capturadas</title>
    </head>
    
    <body>
    
    	<jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
    
    
        <tag:errors name="datosPoliza"/>
        <spring:nestedPath path="datosPoliza">
            <!--tag:errors name="datosPoliza"/-->
            <!--spring:nestedPath path="datosPoliza"-->
            
            <div id="historialTarifas"  style="visibility:hidden;z-index: 900;position:fixed;background-color: #FFFFFF;" >
    	<table cellpadding="0" cellspacing="2" width="310px" style="line-height:normal;" id="tablaTarifas" >
    		<tr>
    			<td class="ContenTablaColor">
    				Tarifa anterior
    			</td>
    			<td class="ContenTablaColor">
    				Modificda por
    			</td>
    			<td class="ContenTablaColor">
    				Fecha
    			</td>
    		</tr>
    		
    	</table>
    </div>
    
     <jsp:include page="../util/infoSumaTotal.jsp"></jsp:include>
    
            <div ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
            <form action="#" method="post" name="w01">           
            <input type="hidden" name="folioSolicitud" id="folioSolicitud" value="" />
                <input type="hidden" name="formatoSolicitud" id="formatoSolicitud" value="" /> 
                <input type="hidden" name="_page0" value="0" />
                <div id="title589x16">Consulta de polizas de seguro - Administrador</div>
                <div class="row660" align="center">
                    <span class="field588">
                        Consultar por:&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="1" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de certificado&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="2" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2"/>RFC del asegurado&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="3" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del asegurado&nbsp;&nbsp;
                    </span>
                </div>
                <div class="row660" align="center">
                    <span class="field588">
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="4" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de P&oacute;liza&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="5" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2"/>Num n&oacute;mina contratante&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="6" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del contratante&nbsp;&nbsp;
                    </span>
                </div>
                <div class="row660" align="center">
                    <span class="field588">
                        Por:&nbsp;&nbsp;
                        <input type="text" name="paramConsulta" id="paramConsultaFrm" disabled="true"  class="input" tabindex="4"/><br>
                        <input type="button" class="input" name="elegirPoliza" id="elegirPolizaFrm" value="Consultar" disabled="true" onclick="seleccionarQuery(),paramConsultaFrm.disabled=true, _target1.disabled=false;" tabindex="5"/>
                        <a href="<c:url value="/app/consultaPolizaAdminController"/>">
                        	<input type="button" class="input" name="_target0" value="Limpiar."  tabindex="6"/>
                        </a>
                        <br/> 
                        <font color="red" style="font-weight: bold;">Antes de volver a hacer una consulta aseg&uacute;rese de dar clic al bot&oacute;n Limpiar</font>
                   
                    </span>
                    
                  
                </div>
                
                <!--Seccion de poliza individual-->
                <div class="row660" align="center">&nbsp;</div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16" >P&oacute;liza individual</div>
                <div class="row660">
                    <!--input type="hidden" name="importePrimaInd" id="importePrimaIndFrm" /-->
                    <!--spring:bind path="polizaIndividual.solicitud.certificadoindividual.numCertificado"-->
                    <!--input type="hidden" name="numCertificado" id="numCertificadoFrm"  readonly class="input"/--> 
                    <!--/spring:bind-->
                    <label class="label135">Emisor:&nbsp;&nbsp;</label>
                     <span class="field195">
                     <spring:bind path="polizaIndividual.numConsignatario">
                            <input type="text" name="${status.expression}"  id="numConsignatarioFrm" value="${status.value}" readonly class="input" size="7"/>    
                        </spring:bind>   
                     </span>
                     <label class="label135">&nbsp;</label>
                     <span class="field195">&nbsp;</span>
                    <label class="label135">N&uacute;mero:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <spring:bind path="polizaIndividual.numPoliza">
                            <input type="text" name="${status.expression}"  id="numPolizaFrm" value="${status.value}" readonly class="input"/>    
                        </spring:bind>
                        
                    </span>                    
                                        
                    <input type="hidden" name="${status.expression}"  id="tipoMovimientoPolizaFrm" value="${status.value}" readonly class="input"/>    
                                        
                    <label class="label135">Certificado individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.numCertificadoIndividual"-->
                        <input type="text" name="cvePlaza" id="cvePlazaFrm" size="4" readonly class="input"/>
                        <input type="text" name="numCertificado" id="numCertificadoFrm" size="7" readonly class="input"/>
                        <!--/spring:bind-->
                    </span>
                    
                    <label class="label135">Tipo de S&eacute;guro:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="tipoSeguro"  id="tipoSeguroFrm" readonly class="input"/>    
                    </span>
                    <label class="label135">Imp de Tarifa.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importeTarifa" id="importeTarifaFrm"  readonly class="input"/>
                        <a href="javascript:void();">
		                       <img title="Ver historial de tarifas" src='<c:url value="/img/skin/onebit_39.png"/>' border="0"
		                        	onclick="javascript:mostrarTarifas(this);"
		                        	width="20"
		                        	/>
		                       
		                       </a>       
                    </span>
                    
                    <label class="label135">Imp prima indiv.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importePrimaInd" id="importePrimaIndFrm"  readonly class="input"/>
                    </span> 
                    <label class="label135">Imp prima colect.:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="importePrimaColectiva" id="importePrimaColectivaFrm"  readonly class="input"/>
                    </span>
                    <label class="label135">Suma asg individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="sumaAseguradaIndividual" id="sumaAseguradaIndividualFrm"  readonly class="input" onChange="suma();"/>
                    </span>
                    <label class="label135">Suma asg colectiva:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text"  name="sumaAseguradaColectiva" id="sumaAseguradaColectivaFrm"  readonly class="input" onChange="suma();"/>
                    </span>
                    <label class="label330" >Total de protecci&oacute;n:&nbsp;&nbsp;</label>
                    <span class="field330">
                         <input type="text" name="txtCampo" value="" id="totalProteccionFrm"  MAXLENGTH="16" class="input" readonly/>
                       <!--input type="text" name="totalProteccion" id="totalProteccionFrm"   class="input"/-->
                       <a href="javascript:void();">
	                       <img title="Ver Detalle del C&aacute;lculo" src='<c:url value="/img/skin/onebit_39.png"/>' border="0"
	                        	onclick="javascript:mostrarCalculo(this);"
	                        	width="20"
	                        	/>
                       </a>
                        
                    </span>
                    
                    
                    <label class="label330">Estatus de seguimiento:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <input type="text" name="descripcionEstatusPoliza" size="40" id="descripcionEstatusPolizaFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                    <label class="label330">Estatus en pagos:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <input type="hidden" name="idEstatusPagosPolizaFrm"  id="idEstatusPagosPolizaFrm" />
                        <input type="text" name="descripcionEstatusPagosPoliza" size="40" id="descripcionEstatusPagosPolizaFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                    
                    <div class="row660" align="center">&nbsp;</div>
                    <div id="titleg664x16">Agente</div>
                    <div class="row660">
                        <div align="center" class="submit664">                       
                            <input type="text" name="cveAgente" id="cveAgenteFrm" size="5" readonly class="input"/>
                            <input type="text" align="center" name="apPaternoEmpleado" id="apPaternoEmpleadoFrm" size="15" readonly class="input" />
                            <input type="text" align="center" name="apMaternoEmpleado" id="apMaternoEmpleadoFrm"  size="15" readonly class="input"/>
                            <input align="center" type="text" name="nombre1Empleado" id="nombre1EmpleadoFrm" size="15" readonly class="input"/>
                            <input type="text" align="center" name="nombre2Empleado" id="nombre2EmpleadoFrm" size="15" readonly class="input"/>
                        </div>
                    </div>
                </div>  
                <div class="row660" align="left">&nbsp;</div>
                <div id="titleg664x16">Vigencia</div>
                <div class="row660">
                <label class="label135">Fecha Inicio:&nbsp;&nbsp;</label>
                <span class="field195">
                    <!--spring:bind path="polizaindividual.solicitud.asegurado.fechaInicioVigencia"-->
                    <input type="text"  name="fechaInicioVigencia" id="fechaInicioVigenciaFrm" readonly  class="input"/>
                    <!--/spring:bind--> 
                </span>
                <label class="label135">Fecha Fin:&nbsp;&nbsp;</label>
                <span class="field195">
                    <!--spring:bind path="polizaindividual.solicitud.asegurado.fechaFinVigencia"-->
                    <input type="text"  name="fechaFinVigencia" id="fechaFinVigenciaFrm" readonly class="input"/>
                    <!--/spring:bind-->
                </span>
                <label class="label330">Fecha Expedici&oacute;n:&nbsp;&nbsp;</label>
                <span class="field330">
                    <!--spring:bind path="polizaindividual.solicitud.asegurado.fechaExpedicion"-->
                    <input type="text"  name="fechaExpedicion" id="fechaExpedicionFrm" readonly class="input"/>
                    <!--/spring:bind-->
                </span>
                </div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Contratante</div>
                <div class="row660">
                    <div class="row660">
                        <label class="label330">No. de empleado:&nbsp;&nbsp;</label>
                        <span class="field330">
                            <!--spring:bind path="polizaIndividual.solicitud.contratante.numNominaContratante"-->
                            <input type="text" name="numNominaContratante"  id="numNominaContratanteFrm" readonly  class="input"/>
                            <!--/spring:bind-->
                        </span>
                    </div>
                    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>                    
                    <span class="field195">
                        <input type="text" name="apPaternoContratante"  id="apPaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="apMaternoContratante"  id="apMaternoContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                    </span>
                </div>               
                <div class="row660">    
                <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="nombre1Contratante"  id="nombre1ContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                <span class="field195">
                    <input type="text" name="nombre2Contratante"  id="nombre2ContratanteFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                </span>
                </div>
                
                
                <!--Seccion del asegurado-->
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Asegurado</div>
                <div class="row660">
                    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.apPaternoAsegurado"-->
                        <input type="text" name="apPaternoAsegurado" id="apPaternoAseguradoFrm"  class="input" readonly onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <!--/spring:bind-->
                    </span>
                    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.apMaternoAsegurado"-->
                        <input type="text" name="apMaternoAsegurado" id="apMaternoAseguradoFrm" readonly  class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        <!--/spring:bind-->
                    </span>
                </div>
                <div class="row660">
                    <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.nombre1Asegurado"-->
                        <input type="text" name="nombre1Asegurado" id="nombre1AseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <!--/spring:bind-->
                    </span>
                    <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.nombre2Asegurado"-->
                        <input type="text" name="nombre2Asegurado"  id="nombre2AseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        <!--/spring:bind-->
                    </span>
                </div>
                <div class="row660">    
                    <label class="label135">RFC:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.RFCasegurado"-->
                        <input type="text" name="RFCasegurado" id="RFCaseguradoFrm" readonly class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <!--/spring:bind-->
                    </span>
                    <label class="label135">Fecha nacimiento:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <!--spring:bind path="polizaIndividual.solicitud.asegurado.fechaNacimientoAsegurado"-->
                        <input type="text" name="fechaNacimientoAsegurado" readonly id="fechaNacimientoAseguradoFrm"  class="input"/>
                        <!--/spring:bind-->
                    </span>                 
                </div>
                <div class="row660" align="center">&nbsp;</div>
                <div class="row660">
                	<div id="titleg664x16">Tr&aacute;mites de la P&oacute;liza</div>
                 	<table width="100%" cellpadding="0" cellspacing="2" id="tablaTramites">
                 	</table>
                 </div>
                                                              
                <div>
                    <span><input type="hidden" name="numPoliza"  id="numPolizaFrm2"  class="input"/>    </span>
                </div>
                <div>
                    <span><input type="hidden" name="numConsignatario"  id="numConsignatarioFrm2"  class="input"/>    </span>
                </div>
                                
                <div class="row660" align="center">&nbsp;</div>
                <div align="center" class="submit664">
                    <input type="button" class="input" id="val" value="Ver Desc. Aplicados" onClick="validaEstatusPoliza();"/>
                    <input type="hidden" class="input" name="_finish" id="desc" value="Generar Reporte Desc." />
                    
                    <a href="<c:url value="/"/>">
                        <input type="button" value="Salir" class="input" tabindex="9"/>
                    </a>
                    
                </div>
                 <div align="center" class="submit664">
               
                    <input type="button" class="input" name="bntAcuse" 
                    value="Ver Acuse de Recibo" onclick="javascript:generarAcuse();"/>
                    <input type="button" class="input" name="btnCarta" 
                    value="Ver Carta Resumen" onclick="javascript:generarCarta();"/>
                    <input type="button" class="input" name="btnCarta" 
                    value="Ver Certificado Individual" onclick="javascript:generarCertificado();"/>
                </div>  
                 <input type="hidden" name="sumaSEVIFrm" id="sumaSEVIFrm" />
                        <input type="hidden" name="sumaGastosFunerariosFrm" id="sumaGastosFunerariosFrm" />
                        <input type="hidden" name="sumaBAFFrm" id="sumaBAFFrm" />
                        <input type="hidden" name="montoCoberturaBeneficiosFrm" id="montoCoberturaBeneficiosFrm" />
            
            </form>
            
                    <form action="#"  name="w02" method="POST">
                
                <script type="text/javascript" >
                    function obtenNumeroPoliza(){
                        document.forms[1].action="<c:url value="/"/>app/cancelarPolizaController?poliza="+document.forms[0].numPoliza.value;
                        document.forms[1].submit();
                    }
                </script>
                <script type="text/javascript" >
                    function obtenNumeroPoliza2(){
                        document.forms[1].action="<c:url value="/"/>app/autofinanciarPolizaCancelController?poliza="+document.forms[0].numPoliza.value;
                        document.forms[1].submit();
                    }
                </script>
                  
            </form>
            
        </spring:nestedPath>
    </body>
</html>
