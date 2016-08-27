<%@page import="mx.com.seguros.web.reportes.GenerarReportesPolizaController"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
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
            						'Id Pagos: :idEstatusPagosPoliza:idEstatusPagosPolizaFrm:f:t,'+
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
            						'Ap. Paterno (asegurado): :asegurado.apPaternoAsegurado:apPaternoAseguradoFrm:t:t,'+
            						'Ap. Materno (asegurado): :asegurado.apMaternoAsegurado:apMaternoAseguradoFrm:t:t,'+
            						'Primer Nombre (asegurado): :asegurado.nombre1Asegurado:nombre1AseguradoFrm:t:t,'+
            						'Segundo Nombre (asegurado): :asegurado.nombre2Asegurado:nombre2AseguradoFrm:t:t,'+
            						'Suma Asegurada Individual: :sumaAseguradaIndividual:sumaAseguradaIndividualFrm:t:t,'+
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
                alert("A continuación de clic en el boton 'Generar Reporte Desc.' ");
                
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
            document.w01.totalProteccionFrm.value =tot;
            
            document.w01.totalProteccionFrm.value=formatMoneda(document.w01.totalProteccionFrm.value, 9);
            cambiarColor();
            cargarTarifas();
            cargarDetalleCalculo(document.w01.numPolizaFrm2.value,document.w01.numConsignatarioFrm2.value);
            cargarTramites(document.w01.numPolizaFrm2.value,document.w01.numConsignatarioFrm2.value);
            cargarInburnomina(document.w01.numPolizaFrm2.value,document.w01.numConsignatarioFrm2.value);
        }
            
            function cambiarColor(){ 
                document.w01.totalProteccionFrm.style.backgroundColor="#ffefab"; 
                document.w01.importeTarifaFrm.style.backgroundColor="#ffefab";
                
            }
          
             
            

        </script>
        <script language="javascript"> 

function formatMoneda(num,longEntera,decSep,thousandSep) {
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
alert("El n&uacute;mero introducido excede de " + longEntera + " digitos en su parte entera");
return "0.a00";
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
return (((sign)?'':'-') + num );
}





        </script>
        
        <script language="JavaScript" type="text/javascript">
            function validarTipoMovimiento(){
                if(document.w01.tipoMovimientoPolizaFrm.value == "B")
                {
                    alert("No se puede cancelar la poliza seleccionada porque no es una poliza vigente");
                }
                else if(document.w01.tipoMovimientoPolizaFrm.value == "R"){
                    alert("No se puede cancelar la poliza seleccionada porque no es una poliza vigente");               
                }else{
                    document.w02.botonValidarCancelacionFrm.type="hidden"
                    document.w02.botonCancelarFrm.type="button"
                }
            }
            
            function beneficiosAdicionales(){
               	numPoliza = document.getElementById("numPolizaFrm2").value;
            	numConsignatario = document.getElementById("numConsignatarioFrm2").value;
            	window.location = '<c:url value="/app/registroBeneficiosaAdicionalesPolizaController" />?numPoliza='+numPoliza+
            			'&numConsignatario='+numConsignatario;
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
        <script type="text/javascript">
        function cargarInburnomina(numPoliza,numConsignatario){
	    	
        	$.ajax({
	 			type: 'POST',
	 			url: '<c:url value="/app/consultarProductosInburnominaController"/>',
	 			data: 'numPoliza='+numPoliza+'&numConsignatario='+numConsignatario,
	 			dataType: 'xml',
	 			async: false,
	 			success: function(xml){
	 			
	 			resultados = "";
	 			$(xml).find('ProductosInburnomina').each(function(){
	 				conTramite = true;
	 				
	 				if($(this).find("indRcLicencia").text() == "true"){
	 					document.getElementById("indRcLicencia1").checked = "checked";
	 					document.getElementById("numLicencia").value = $(this).find("numLicencia").text();
	 					document.getElementById("primaMensualLicencia").value = $(this).find("primaMensualLicencia").text();
	 					
	 					document.getElementById("numPolizaRcLicencia").value = $(this).find("numPolizaRcLicencia").text();
	 					document.getElementById("numConsignatarioRcLicencia").value = $(this).find("numConsignatarioRcLicencia").text();
	 					document.getElementById("fechaVigenciaRcLicencia").value = $(this).find("fechaVigenciaRcLicencia").text();
	 					
	 				}else{
	 					document.getElementById("indRcLicencia2").checked = "checked";
	 				}
	 				
	 				if($(this).find("indInburmedic").text() == "true"){
	 					document.getElementById("indInburmedic1").checked = "checked";
	 					document.getElementById("primaMensualInburmedic").value = $(this).find("primaMensualInburmedic").text();
	 					
	 					document.getElementById("numPolizaInburmedic").value = $(this).find("numPolizaInburmedic").text();
	 					document.getElementById("numConsignatarioInburmedic").value = $(this).find("numConsignatarioInburmedic").text();
	 					document.getElementById("fechaVigenciaInburmedic").value = $(this).find("fechaVigenciaInburmedic").text();
	 					
	 				}else{
	 					document.getElementById("indInburmedic2").checked = "checked";
	 				}
	 				
	 				if($(this).find("indSeguCancer").text() == "true"){
	 					document.getElementById("indSeguCancer1").checked = "checked";
	 					document.getElementById("primaMensualSeguCancer").value = $(this).find("primaMensualSeguCancer").text();
	 					
	 					document.getElementById("numPolizaSeguCancer").value = $(this).find("numPolizaSeguCancer").text();
	 					document.getElementById("numConsignatarioSeguCancer").value = $(this).find("numConsignatarioSeguCancer").text();
	 					document.getElementById("fechaVigenciaSeguCancer").value = $(this).find("fechaVigenciaSeguCancer").text();
	 					
	 				}else{
	 					document.getElementById("indSeguCancer2").checked = "checked";
	 				}
	 				
	 				
	 			});
	 			
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
		<script type="text/javascript" language="javascript">
			function guardarInburnomina(forma){
				if(forma.numPoliza.value == ""){
					alert("No se ha seleccionado ninguna póliza");
					return ;
				}
				if(forma.numConsignatario.value == ""){
					alert("No se ha seleccionado ninguna póliza");
					return ;
				}
				if(forma.indRcLicencia1.checked){
					if(forma.primaMensualLicencia.value == ""){
						alert("La prima mensual de RC Licencia es requerida");
						return;
					}
					if(isNaN(forma.primaMensualLicencia.value)){
						alert("La prima mensual de RC Licencia debe ser un número válido");
						return;
					}
				}else{
					forma.primaMensualLicencia.value = "";
					forma.numLicencia.value = "";
				}
				
				if(forma.indInburmedic1.checked){
					if(forma.primaMensualInburmedic.value == ""){
						alert("La prima mensual de Inburmedic es requerida");
						return;
					}
					if(isNaN(forma.primaMensualInburmedic.value)){
						alert("La prima mensual de Inburmedic debe ser un número válido");
						return;
					}
				}else{
					forma.primaMensualInburmedic.value = "";
				}
				
				if(forma.indSeguCancer1.checked){
					if(forma.primaMensualSeguCancer.value == ""){
						alert("La prima mensual de SeguCancer es requerida");
						return;
					}
					if(isNaN(forma.primaMensualSeguCancer.value)){
						alert("La prima mensual de SeguCancer debe ser un número válido");
						return;
					}
				}else{
					forma.primaMensualSeguCancer.value = "";
				}
				
				
				forma.submit();
			}
		
		</script>  
        <title>Consulta de p&oacute;lizas de Seguro de Vida</title>
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        
       
            <!--tag:errors name="datosPoliza"/-->
            <!--spring:nestedPath path="datosPoliza"-->
            <div ID="testdiv1" 
            STYLE="position:absolute;visibility:hidden;background-color:white;">

            </div>
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
            
             <spring:nestedPath path="command">
            <form action="<c:url value="/app/registrarProductosInburnominaController"/>" method="post" name="w01">            
                <input type="hidden" name="_page0" value="0" />
                <input type="hidden" name="folioSolicitud" id="folioSolicitud" value="" />
                <input type="hidden" name="formatoSolicitud" id="formatoSolicitud" value="" />
                <input type="hidden" name="apPaternoAseguradoFrm" id="apPaternoAseguradoFrm" value="" />
                
                <input type="hidden" name="apMaternoAseguradoFrm" id="apMaternoAseguradoFrm" value="" />
                <input type="hidden" name="nombre1AseguradoFrm" id="nombre1AseguradoFrm" value="" />
                <input type="hidden" name="nombre2AseguradoFrm" id="nombre2AseguradoFrm" value="" />
                <div id="title589x16">Consulta de polizas de seguro</div>
                <div class="row660" align="center">
                    <span class="field588">
                        Consultar por:&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="1" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de certificado&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="2" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2">RFC del asegurado&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="3" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del asegurado&nbsp;&nbsp;
                    </span>
                </div>
                <div class="row660" align="center">
                    <span class="field588">
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="4" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="1"/>No. de P&oacute;liza&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="5" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="2">Num n&oacute;mina contratante&nbsp;&nbsp;
                        <input type="radio" name="tipoConsulta" id=tipoConsultaFrm value="6" onclick="elegirPolizaFrm.disabled=false, paramConsultaFrm.disabled=false, paramConsultaFrm.value=0" tabindex="3"/>Apellido paterno del contratante&nbsp;&nbsp;
                    </span>
                </div>
                <div class="row660" align="center">
                    <span class="field588">
                        Por:&nbsp;&nbsp;
                        <input type="text" name="paramConsulta" id="paramConsultaFrm" disabled="true"  class="input" tabindex="4"/><br>
                        <input type="button" class="input" name="elegirPoliza" id="elegirPolizaFrm" value="Consultar" disabled="true" onclick="seleccionarQuery(),paramConsultaFrm.disabled=true;" tabindex="5"/>
                        <a href="<c:url value="/app/registrarProductosInburnominaController"/>">
                        	<input type="button" class="input" value="Limpiar." width="52" height="19" border="0" tabindex="6"/>
                        </a>
                        <br/>
                        <font color="red" style="font-weight: bold;">Antes de volver a hacer una consulta aseg&uacute;rese de dar clic al bot&oacute;n Limpiar</font>
                    </span>
                </div>
                
                <!--Seccion de poliza individual-->
                <div class="row660" align="center">&nbsp;</div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Contratante</div>
                <div class="row660">
                    <div class="row660">
                        <label class="label330">No. de empleado:&nbsp;&nbsp;</label>
                        <span class="field330">
                            <!--spring:bind path="polizaIndividual.solicitud.contratante.numNominaContratante"-->
                            <input type="text" name="numNominaContratante" id="numNominaContratanteFrm" readonly  class="input"/>
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
                    <div class="row660">
                        <label class="label330">Tel&eacute;fono:&nbsp;&nbsp;</label>
                        <span class="field330">
                            <input type="text" name="telefono" id="telefonoFrm" readonly  class="input"/>
                        </span>
                    </div>
                    <div class="row660">
                        <label class="label330">Centro de trabajo:&nbsp;&nbsp;</label>
                        <span class="field330">
                            <input type="text" name="nombreEmpresa" id="nombreEmpresa" readonly  class="input"/>
                        </span>
                    </div>
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
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16" >P&oacute;liza individual</div>
                <div class="row660">
                    <!--input type="hidden" name="importePrimaInd" id="importePrimaIndFrm" /-->
                    <!--spring:bind path="polizaIndividual.solicitud.certificadoindividual.numCertificado"-->
                    <!--input type="hidden" name="numCertificado" id="numCertificadoFrm"  readonly class="input"/--> 
                    <!--/spring:bind-->
                    <label class="label135">Emisor:&nbsp;&nbsp;</label>
                     <span class="field195">
	                     <spring:bind path="numConsignatario" >
	                     		<input type="text" name="${status.expression}"  id="numConsignatarioFrm" value="${status.value}" readonly class="input" size="7"/> 
	                    </spring:bind>
                               
                     </span>
                     <label class="label135">&nbsp;</label>
                     <span class="field195">&nbsp;</span>
                    <label class="label135">N&uacute;mero:&nbsp;&nbsp;</label>
                    <span class="field195">
                    	<spring:bind path="numPoliza" >
                    		<input type="text" name="${status.expression}"  id="numPolizaFrm" value="${status.value}" readonly class="input"/> 
                    	</spring:bind>
                               
                    </span>
                    
                   
                    
                    <input type="hidden" name="tipoMovimientoPolizaFrm"  id="tipoMovimientoPolizaFrm" value="${status.value}" readonly class="input"/>    
                                        
                    <label class="label135">Certificado individual:&nbsp;&nbsp;</label>
                    <span class="field195">
                    <spring:bind path="cvePlaza" >
                        <input type="text" name="${status.expression}" id="cvePlazaFrm" size="4" readonly class="input" value="${status.value}"/>
                    </spring:bind>
                        <spring:bind path="numCertificado" >
                        <input type="text" name="${status.expression}" id="numCertificadoFrm" size="7" readonly class="input" value="${status.value}"/>
                        </spring:bind>
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
                         <INPUT type="text" name="txtCampo" value="" id="totalProteccionFrm"  ONMOUSEMOVE="" MAXLENGTH="16" class="input" readonly>
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
                </div>  
                
                <div id="titleg664x16" >Productos Adicionales de Inburnomina Integral</div>
                <table cellpadding="0" cellspacing="2" width="664">
                	<tr>
                		<td class="labelRow"  width="25%" rowspan="5">
                				<img src="<c:url value='/img/rclicencia.png'/>" border="0"/>
                		</td>
                		<td class="fieldRow"  width="25%" rowspan="5">
                			<form:radiobutton path="indRcLicencia" value="true"/> Si 
							<form:radiobutton path="indRcLicencia" value="false"/> No
                		</td>
                		<td class="labelRow"  width="25%">
                			N&uacute;mero de Licencia:&nbsp;
                		</td>
                		<td class="fieldRow"  width="25%">
                			<spring:bind path="numLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Prima Mensual:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="primaMensualLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			N&uacute;mero de P&oacute;liza:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="numPolizaRcLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Emisor:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="numConsignatarioRcLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Fecha Vigencia:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="fechaVigenciaRcLicencia" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow"  rowspan="4">
                			<img src="<c:url value='/img/inburmedic.png'/>" border="0" />
                		</td>
                		<td class="fieldRow"  rowspan="4">
	                		<form:radiobutton path="indInburmedic" value="true"/> Si 
							<form:radiobutton path="indInburmedic" value="false"/> No
                		</td>
                		<td class="labelRow" >
                			Prima Mensual:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="primaMensualInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			N&uacute;mero de P&oacute;liza:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="numPolizaInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Emisor:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="numConsignatarioInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Fecha Vigencia:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="fechaVigenciaInburmedic" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" rowspan="4" >
                				<img src="<c:url value='/img/segucancer.png'/>" border="0"/>
                		</td>
                		<td class="fieldRow" rowspan="4" >
                			<form:radiobutton path="indSeguCancer" value="true"/> Si 
							<form:radiobutton path="indSeguCancer" value="false"/> No
                		</td>
                		<td class="labelRow" >
                			Prima Mensual:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="primaMensualSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			N&uacute;mero de P&oacute;liza:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="numPolizaSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Emisor:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="numConsignatarioSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                	<tr>
                		<td class="labelRow" >
                			Fecha Vigencia:&nbsp;
                		</td>
                		<td class="fieldRow" >
                			<spring:bind path="fechaVigenciaSeguCancer" >
                    			<input type="text" name="${status.expression}"  id="${status.expression}" value="${status.value}" class="input"/> 
                    		</spring:bind>
                		</td>
                	</tr>
                </table>
                			
                
                
                <div>
                    <span><input type="hidden" name="numPoliza2"  id="numPolizaFrm2"  class="input"/>    </span>
                </div>
                <div>
                    <span>
                    		<input type="hidden" name="numConsignatarioFrm2"  id="numConsignatarioFrm2" value=""/> 
                    </span>
                </div>
                                
                <div class="row660" align="center">&nbsp;</div>
                <div align="center" class="submit664">
                    <input type="button" value="Registrar" class="input" tabindex="9" onclick="javascript:guardarInburnomina(this.form);"/>
                      &nbsp; &nbsp;  &nbsp; &nbsp;
                    <a href="<c:url value="/"/>"><input type="button" value="Cancelar" class="input" tabindex="9"/></a>
                    <br/>
                <c:if test="${not empty registroProductosInburnomina}">
                	<div id="botonesReporte" align="center" class="submit664">
                     <input type="button" class="input" name="bntAcuse" 
	                    value="Ver Acuse de Recibo" onclick="javascript:generarAcuse();"/>
	                    &nbsp;
	                    <input type="button" class="input" name="btnCarta" 
	                    value="Ver Carta Resumen" onclick="javascript:generarCarta();"/>
                    </div>
                    <script type="text/javascript">
                    	alert("Se registraron correctamente los datos de los productos Inburnomina");
                    </script>
                </c:if>
                    
                </div>
                <input type="hidden" name="sumaSEVIFrm" id="sumaSEVIFrm" />
                        <input type="hidden" name="sumaGastosFunerariosFrm" id="sumaGastosFunerariosFrm" />
                        <input type="hidden" name="sumaBAFFrm" id="sumaBAFFrm" />
                        <input type="hidden" name="montoCoberturaBeneficiosFrm" id="montoCoberturaBeneficiosFrm" />
            </form>
            </spring:nestedPath>
            
            
    </body>
</html>
