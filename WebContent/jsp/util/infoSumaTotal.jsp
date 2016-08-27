<%@page import="mx.com.seguros.model.EstadoTicketCorreccion"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script language="JavaScript" type="text/javascript">
           
           
           function  mostrarCalculo(campoRef){
        	   detalle =document.getElementById("detalleCalculo");
        	   if( detalle.style.visibility == 'visible'){
        		   detalle.style.visibility = 'hidden';
        		   return;
        	   }
        	   
        	   
        	   
        	   detalle.style.left = (getDimensions(campoRef).x+25) + "px";
        	   detalle.style.top = getDimensions(campoRef).y + "px";
        	   detalle.style.visibility = 'visible';
           }
           
           function ocultarCalculo(){
        	   document.getElementById("detalleCalculo").style.visibility = 'hidden';
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

           
           function cargarDetalleCalculo(numPoliza,numConsignatario){
        	   
        	   $.ajax({
		    		type: 'POST',
		    		url: '<c:url value="/app/consultarDetalleCalculoSumaAseguradaController"/>',
		    		data: 'numPoliza='+numPoliza+'&numConsignatario='+numConsignatario,
		    		dataType: 'xml',
		    		async: false,
		    		success: function(xml){
		    			conTarifas = false;
		    			
		    			$(xml).find('detalleCalculoSumaAsegurada').each(function(){
		    				
		    				
		    			    $('#tablaCalculo').append(
		    			    		'<tr>'+
			    		    			'<td class="ContenTabla">' + 
			    		    			'Vida' +
			    		    			'</td>'+
			    		    			'<td class="ContenTabla" style="text-align: right" nowrap>$  '+
			    		    				$(this).find("sumaSeguroVidaString").text()+
			    		    			'</td>'+
		    		    			'</tr>' + 
		    		    			'<tr>'+
			    		    			'<td class="ContenTabla">' + 
			    		    			'Gastos Funerarios (GF)' +
			    		    			'</td>'+
			    		    			'<td class="ContenTabla" style="text-align: right" nowrap>$  '+
			    		    				$(this).find("sumaGastosFunerariosString").text()+
			    		    			'</td>'+
	    		    				'</tr>' +
	    		    				'<tr>'+
			    		    			'<td class="ContenTabla">' + 
			    		    			'Enfermedades Graves (SEVI)' +
			    		    			'</td>'+
			    		    			'<td class="ContenTabla" style="text-align: right" nowrap>$  '+
			    		    				$(this).find("sumaSEVIString").text()+
			    		    			'</td>'+
    		    					'</tr>'+
	    		    					($(this).find("formatoAnterior").text() == "false"?
	    		    						'<tr>'+
	    			    		    			'<td class="ContenTabla">' + 
	    			    		    			'BAF' +
	    			    		    			'</td>'+
	    			    		    			'<td class="ContenTabla" style="text-align: right" nowrap>$  '+
	    			    		    				$(this).find("sumaBAFString").text()+
	    			    		    			'</td>'+
	        		    					'</tr>'	:""));
		    			    
		    			    
		    			    
		    			    
				    			    $(this).find('detalleCalculoBeneficio').each(function(){
				    			    	
				    			    	$('#tablaCalculo').append(	 
				    			    		
				    			    		'<tr>'+
					    		    			'<td class="ContenTabla">' + 
					    		    				$(this).find("descripcionBeneficio").text() +
					    		    			'</td>'+
					    		    			'<td class="ContenTabla" style="text-align: right" nowrap>$  '+
					    		    				$(this).find("montoCobertura").text()+
				    		    				'</td>'+
				    						'</tr>'
				    			    			
				    			    			
				    			    	);
				    			    	
				    			    });
		    			    
		    			    
    					
    					
	    		    				$('#tablaCalculo').append(	 
    		    					'<tr><td class="ContenTabla" colspan="2">&nbsp;</td></tr>'+
    		    				'<tr>'+
		    		    			'<td class="ContenTabla">' + 
		    		    				'Total de Protecci&oacute;n' +
		    		    			'</td>'+
		    		    			'<td class="ContenTabla" style="text-align: right" nowrap>$  '+
		    		    				$(this).find("sumaAseguradaTotalString").text()+
		    		    			'</td>'+
		    					'</tr>'
		    			    
		    			    		);
		    			    		
		    			});
		      		}
		    		
		    	});
        	   
           }
           

        </script>


<div id="detalleCalculo"  style="visibility:hidden;z-index: 900;position:fixed;background-color: #FFFFFF;" >
    	<table cellpadding="0" cellspacing="2" width="310px" style="line-height:normal;" id="tablaCalculo" >
    		<tr>
    			<td class="ContenTablaColor" colspan="2" >
    				Detalle del C&aacute;lculo de la Suma Asegurada Total
    			</td>
    		</tr>
    		
    	</table>
</div>