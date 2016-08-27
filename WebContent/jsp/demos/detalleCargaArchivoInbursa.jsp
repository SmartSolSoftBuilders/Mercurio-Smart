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
        
        
        <!--agregue los nuevos campos del formulario-->
    
        


        
        <title>Detalle de Registros Cargados por Archivo de P&oacute;lizas de Inbursa</title>
        <script type="text/javascript" >
            function cambioPagina(pagina){
            
                document.forms[0].paginaActual.value = pagina;
                document.forms[0].submit();
            }

        </script>
   
   <style type="text/css">
   

div.fixedHeaderTable {
         position: relative;
}


div.fixedHeaderTable table {
    
    border-collapse: collapse;
    
}


div.fixedHeaderTable thead {
    
}


div.fixedHeaderTable tbody {
    
    overflow-y: auto;
    overflow-x: hidden;
}

div.fixedHeaderTable table th {
    
}

div.fixedHeaderTable table tr {
}
  

div.fixedHeaderTable table td {
   

}

 div.fixedHeaderTable thead td, div.fixedHeaderTable thead th {
     position:relative;
 }
   
   
   table#tablaResultados {
	overflow: auto;
	height: 800px; 
	}
	tr#m-header td {
	/*position: fixed*/
	}
   
   
   </style>
   
    </head>
        
    <body>
        <tag:errors name="datosPoliza"/>
        <spring:nestedPath path="consultaRegistrosPolizas">
            <!--tag:errors name="datosPoliza"/-->
            <!--spring:nestedPath path="datosPoliza"-->
            <div ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></div>
            <form action="<c:url value="/app/consultarRegistrosPendientesArchivoPolizasController"/>" method="post" name="w01">
                <input type="hidden" name="_page0" value="0" />
                
                <div align="center" >
                	<table width="100%">
                		<tr>
                			<td>
                				<div id="title589x16" align="left"  >Detalle de Registros Cargados por Archivo de P&oacute;lizas de Inbursa</div>
               					
               					<div class="row660" style="text-align: left;">
				                   <span class="field588" style="text-align: left;" >
				                     &nbsp;&nbsp; Archivo: &nbsp;&nbsp;
				                      		<b>poliza_inbursa_2223.txt</b>
				                   </span>
				                </div>
				                <div class="row660">
				                   <span class="field588" style="text-align: left;" >
				                     &nbsp;&nbsp; Fecha de Carga: &nbsp;&nbsp;
				                      		<b>21/12/2012 14:50</b>
				                   </span>
				                </div>
				                <div class="row660">
				                   <span class="field588" style="text-align: left;" >
				                     &nbsp;&nbsp; Usario: &nbsp;&nbsp;
				                      		<b>masterDir</b>
				                   </span>
				                </div>
				                <div class="row660">
				                   <span class="field588" style="text-align: left;" >
				                     &nbsp;&nbsp; Total Registros: &nbsp;&nbsp;
				                      		<b>115</b>
				                      &nbsp;&nbsp; Registros V&aacute;lidos: &nbsp;&nbsp;
				                      		<b>110</b>
				                       &nbsp;&nbsp; Registros Inv&aacute;lidos: &nbsp;&nbsp;
				                      		<b>5</b>
				                   </span>
				                </div>
				                <div class="row660">
				                   <span class="field588" style="text-align: left;" >
				                     &nbsp;&nbsp; Mostrar: &nbsp;&nbsp;
				                      		<select class="input">
				                      			<option>Todos</option>
				                      			<option>V&aacute;lidos</option>
				                      			<option>Inv&aacute;lidos</option>
				                      		</select>
				                        
				
				                   </span>
				                </div>
                				<table width="100%" border="0" cellpadding="0" cellspacing="1">
			                		<tr align="left" valign="middle" height="20">
			                            <td colspan="80" class="TopTabla" align="center"><strong>
												Registros cargados
										</strong></td>
			                        </tr>
			                	</table>
                			</td>
                		</tr>
                		<tr>
                			<td>
                					<div class="">
                    <table width="100%" border="0" cellpadding="5" cellspacing="1"  >
                 
                        <tr >
                            <td class="ContenTablaColor" id="header1">&nbsp;</td>
                            <td align="center" class="ContenTablaColor" ><strong>Folio Solicitud</strong></td>
                            <td align="center" class="ContenTablaColor" ><strong>Num. de Poliza</strong></td>
                            <td align="center" class="ContenTablaColor" ><strong>Grupo Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Paterno Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Materno Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Primer Nombre Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Segundo Nombre Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>RFC Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. N&oacute;mina Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Nacimiento Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Cve. Sexo Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Es Fumador Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Cve. Estado Civil Asegurado</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Calle</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. Exterior</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. Interior</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Cod. Postal</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Colonia</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Entidad Federativa</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Delegaci&oacute;n / Mpio.</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Paterno Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Ap. Materno Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Primer Nombre Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Segundo Nombre Contratante</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Num. Consignatario</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>CIS</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Fecha Solicitud</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Suma Asegurada Individual</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>BAF</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>SEVI</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Gastos Funerarios</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>CPF</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Paquete</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Plazo</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Importe Tarifa</strong></td>
                            <td align="center" class="ContenTablaColor"><strong>Promotor</strong></td>
                            
                            
                            
                        </tr>
                       
                         <tr >
                            <td class="ContenTabla" > <img border="0" src="<c:url value='/img/skin/onebit_36.png'/>" title="Inv&aacute;lido" width="24" height="24"/></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>SNTE</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>F</strong></td>
                            <td  class="ContenTabla"><strong>SI</strong></td>
                            <td  class="ContenTabla"><strong>1</strong></td>
                            <td  class="ContenTabla"><strong>Tlalpan</strong></td>
                            <td  class="ContenTabla"><strong>3900</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>443444</strong></td>
                            <td  class="ContenTabla"><strong>Portales</strong></td>
                            <td  class="ContenTabla"><strong>Distrito Federal</strong></td>
                            <td  class="ContenTabla"><strong>Benito Ju&aacute;rez</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>111089</strong></td>
                            <td  class="ContenTabla"><strong>223</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23,332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>3,355.00</strong></td>
                            <td  class="ContenTabla"><strong>34,566.00</strong></td>
                            <td  class="ContenTabla"><strong>33,000.00</strong></td>
                            <td  class="ContenTabla"><strong>VINT098</strong></td>
                            <td  class="ContenTabla"><strong>54</strong></td>
                            <td  class="ContenTabla"><strong>180.00</strong></td>
                            <td  class="ContenTabla"><strong>110677</strong></td>
                            
                            
                            
                        </tr>
                        <tr >
                            <td class="ContenTabla" ><img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="V&aacute;lido" width="24" height="24"/></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>SNTE</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>F</strong></td>
                            <td  class="ContenTabla"><strong>SI</strong></td>
                            <td  class="ContenTabla"><strong>1</strong></td>
                            <td  class="ContenTabla"><strong>Tlalpan</strong></td>
                            <td  class="ContenTabla"><strong>3900</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>443444</strong></td>
                            <td  class="ContenTabla"><strong>Portales</strong></td>
                            <td  class="ContenTabla"><strong>Distrito Federal</strong></td>
                            <td  class="ContenTabla"><strong>Benito Ju&aacute;rez</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>111089</strong></td>
                            <td  class="ContenTabla"><strong>223</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23,332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>3,355.00</strong></td>
                            <td  class="ContenTabla"><strong>34,566.00</strong></td>
                            <td  class="ContenTabla"><strong>33,000.00</strong></td>
                            <td  class="ContenTabla"><strong>VINT098</strong></td>
                            <td  class="ContenTabla"><strong>54</strong></td>
                            <td  class="ContenTabla"><strong>180.00</strong></td>
                            <td  class="ContenTabla"><strong>110677</strong></td>
                            
                            
                            
                        </tr>
                         <tr >
                            <td class="ContenTabla" ><img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="V&aacute;lido" width="24" height="24"/></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>SNTE</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>F</strong></td>
                            <td  class="ContenTabla"><strong>SI</strong></td>
                            <td  class="ContenTabla"><strong>1</strong></td>
                            <td  class="ContenTabla"><strong>Tlalpan</strong></td>
                            <td  class="ContenTabla"><strong>3900</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>443444</strong></td>
                            <td  class="ContenTabla"><strong>Portales</strong></td>
                            <td  class="ContenTabla"><strong>Distrito Federal</strong></td>
                            <td  class="ContenTabla"><strong>Benito Ju&aacute;rez</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>111089</strong></td>
                            <td  class="ContenTabla"><strong>223</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23,332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>3,355.00</strong></td>
                            <td  class="ContenTabla"><strong>34,566.00</strong></td>
                            <td  class="ContenTabla"><strong>33,000.00</strong></td>
                            <td  class="ContenTabla"><strong>VINT098</strong></td>
                            <td  class="ContenTabla"><strong>54</strong></td>
                            <td  class="ContenTabla"><strong>180.00</strong></td>
                            <td  class="ContenTabla"><strong>110677</strong></td>
                            
                            
                            
                        </tr>
                         <tr >
                            <td class="ContenTabla" ><img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="V&aacute;lido" width="24" height="24"/></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>SNTE</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>F</strong></td>
                            <td  class="ContenTabla"><strong>SI</strong></td>
                            <td  class="ContenTabla"><strong>1</strong></td>
                            <td  class="ContenTabla"><strong>Tlalpan</strong></td>
                            <td  class="ContenTabla"><strong>3900</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>443444</strong></td>
                            <td  class="ContenTabla"><strong>Portales</strong></td>
                            <td  class="ContenTabla"><strong>Distrito Federal</strong></td>
                            <td  class="ContenTabla"><strong>Benito Ju&aacute;rez</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>111089</strong></td>
                            <td  class="ContenTabla"><strong>223</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23,332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>3,355.00</strong></td>
                            <td  class="ContenTabla"><strong>34,566.00</strong></td>
                            <td  class="ContenTabla"><strong>33,000.00</strong></td>
                            <td  class="ContenTabla"><strong>VINT098</strong></td>
                            <td  class="ContenTabla"><strong>54</strong></td>
                            <td  class="ContenTabla"><strong>180.00</strong></td>
                            <td  class="ContenTabla"><strong>110677</strong></td>
                            
                            
                            
                        </tr>
                         <tr >
                            <td class="ContenTabla" ><img border="0" src="<c:url value='/img/skin/onebit_34.png'/>" title="V&aacute;lido" width="24" height="24"/></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>3123</strong></td>
                            <td  class="ContenTabla" ><strong>SNTE</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>NHDU4343434</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>F</strong></td>
                            <td  class="ContenTabla"><strong>SI</strong></td>
                            <td  class="ContenTabla"><strong>1</strong></td>
                            <td  class="ContenTabla"><strong>Tlalpan</strong></td>
                            <td  class="ContenTabla"><strong>3900</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>443444</strong></td>
                            <td  class="ContenTabla"><strong>Portales</strong></td>
                            <td  class="ContenTabla"><strong>Distrito Federal</strong></td>
                            <td  class="ContenTabla"><strong>Benito Ju&aacute;rez</strong></td>
                            <td  class="ContenTabla"><strong>GARCIA</strong></td>
                            <td  class="ContenTabla"><strong>ROBLE</strong></td>
                            <td  class="ContenTabla"><strong>GERARDO</strong></td>
                            <td  class="ContenTabla"><strong>&nbsp;</strong></td>
                            <td  class="ContenTabla"><strong>111089</strong></td>
                            <td  class="ContenTabla"><strong>223</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23/12/2000</strong></td>
                            <td  class="ContenTabla"><strong>23,332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>332,333.00</strong></td>
                            <td  class="ContenTabla"><strong>3,355.00</strong></td>
                            <td  class="ContenTabla"><strong>34,566.00</strong></td>
                            <td  class="ContenTabla"><strong>33,000.00</strong></td>
                            <td  class="ContenTabla"><strong>VINT098</strong></td>
                            <td  class="ContenTabla"><strong>54</strong></td>
                            <td  class="ContenTabla"><strong>180.00</strong></td>
                            <td  class="ContenTabla"><strong>110677</strong></td>
                            
                            
                            
                        </tr>
                    
                    
                      
                        </table>
					</div>
                			
                			</td>
                		</tr>
                	
                	</table>
                	
                	
                	



                </div>
               
               
                
                <!--Seccion de poliza individual-->


                
                  
            </form>
            
        </spring:nestedPath>
        <script type="text/javascript">
        	//document.getElementById("header1").style.position = "fixed";
        	//document.getElementById("header2").style.position = "fixed";
        	//document.getElementById("header3").style.position = "fixed";
        </script>
    </body>
</html>
