<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Map, java.util.HashMap"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link href="<c:url value="/css/stilosForms.css" />" 
          rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/stilosCal.css" />" 
          rel="stylesheet" type="text/css">
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
    <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>">
    </script>
    
    <script type="text/javascript">
            function calcularImportePagoRegular() {
            var n1 = parseFloat(document.form.totalPrestamoFrm.value);
            var n2 = parseFloat(document.form.numPagosTotalesFrm.value);
            var r1=n1/n2;
            document.form.importePagosRegularFrm.value = roundTo(r1,2);
            }


            function roundTo(num,pow){ 
              if( isNaN( num ) )
              { 
                num = 0; 
              } 

              num *= Math.pow(10,pow); 
              num = (Math.round(num)/Math.pow(10,pow))+ "" ; 
              if(num.indexOf(".") == -1) 
                num += "." ; 
              while(num.length - num.indexOf(".") - 1 < pow) 
                num += "0" ; 

              return num; 
            } 
    </script>
    
    <script type="text/javascript">
           function validaPrestamo(){
            var param=document.form.marcaPrestamoLiquidadoFrm.value;
           // alert(param);
                if(param == "false"){
                alert("El empleado tiene un prestamo que aun no ha liquidado por lo tanto no se podra registrar uno nuevo");
                document.form.marcaPrestamoLiquidadoFrm.value=""
                document.form.totalPrestamoFrm1.value=""
               
                            }
                            
                            else{alert("Es posible registrar el prestamo,a continuacion de clic en el boton 'Registrar'");
                            form.registrar.disabled=false;
                            document.form.marcaPrestamoLiquidadoFrm.value=""
                            document.form.totalPrestamoFrm1.value=""
                            }
            }
            
            function desactiva(){
             form.veri1.disabled="true";
             
            }
            
            function desactiva2(){
             form.veri1.type="button";
             form.veri2.type="hidden";
            }
            
            function activa(){
            form.veri1.disabled=false;
            }
    </script>
    
    <script language="JavaScript" type="text/javascript">
           function validaPrestamos(){
            var param=document.w01.cveEmpleadoFrm.value;
            alert(param);
           // alert(param);
                if(param >1){
                alert("A continuación de clic en el boton 'Registrar' ");
                
                w01.val.type="hidden";
                w01.registrar.type="submit";
                w01.val.disabled=true;
                            }
                            
                            else{alert("La póliza no cuenta aún con descuentos aplicados");}
            }

        </script>
    
    <title>Registro de Pr&eacute;stamos a Empleados</title>
    <style type="text/css">
        <!--
.Estilo1 {
	color: #FFFFFF;
	font-weight: bold;
	font-family: "Century Gothic";
}
            -->
    </style>
</head>

<body>
 <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
<tag:errors name="prestamos" />
<spring:nestedPath path="prestamos">
<form action="#" method="post" name="form">
 <div id="titleg664x16">Registro de Pr&eacute;stamos a Empleados</div>
    
    <div align="center" class="submit664">   
            <a href="javascript:launch('mostrarEmpleados','Listado de Empleados -Seleccione un registro de la lista-','Clave:cveEmpleado:cveEmpleado:cveEmpleadoFrm:f:t,Ap Paterno:apPaternoEmpleado:apPaternoEmpleado:apPaternoEmpleadoFrm:t:t,Apellido Materno:apMaternoEmpleado:apMaternoEmpleado:apMaternoEmpleadoFrm:t:t,Primer Nombre:nombre1Empleado:nombre1Empleado:nombre1EmpleadoFrm:t:t,Segundo Nombre:nombre2Empleado:nombre2Empleado:nombre2EmpleadoFrm:t:t,Puesto:nombrePuesto:puesto.nombrePuesto:nombrePuestoFrm:t:f','',500,550);" tabindex="2">
                <input type="button" name="Submit" value="Consultar" class="input" onClick="activa();"/>
            </a>
        </div>
    
    <div id="titleg664x16">Datos del Empleado</div>
                
                   <spring:bind path="prestamoEmpleado.cveEmpleado">
                       <input type="hidden" name="${status.expression}" id="cveEmpleadoFrm" value="${status.value}" class="input"/>
                    </spring:bind>
                    <div class="row660">
                    <label class="label135">Apellido paterno:&nbsp;&nbsp;</label>                    
                    <span class="field195">
                        <input type="text" name="apPaternoEmpleado" id="apPaternoEmpleadoFrm" class="input" readonly/>
                                                                                                                 </span>
                    <label class="label135">Apellido materno:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <input type="text" name="apMaternoEmpleado" id="apMaternoEmpleadoFrm" class="input" readonly/>
                                                                                                                 </span>
                    </div>               
                    <div class="row660">    
                        <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                        <span class="field195">
                            <input type="text" name="nombre1Empleado" id="nombre1EmpleadoFrm" class="input" readonly/>
                                                                                                                 </span>
                        <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                        <span class="field195">
                            <input type="text" name="nombre2Empleado" id="nombre2EmpleadoFrm" class="input" readonly/>
                                                                                                                 </span>
                    </div>
                    <!--    <span class="field330">
                    <a href="javascript:launch('verificarPagoPrestamo','Prestamos otorgados al Empleado -Seleccione un registro de la lista-','Total del prestamo:totalPrestamo:totalPrestamo:totalPrestamoFrm1:t:t,Marca del prestamo:marcaPrestamoLiquidado:marcaPrestamoLiquidado:marcaPrestamoLiquidadoFrm:t:t','cveEmpleado:'+document.getElementById('cveEmpleadoFrm').value,500,550);" tabindex="2"> 
                        <input type="button" id="veri1" name="Submit" value="Verificar Pr&eacute;stamo" class="input" onClick="desactiva();" disabled/>
                                                                                                                                                      
                                                                                                                                                  </a> 
                </span>
                <span class="field330">
                    <input type="button" id="veri2" name="Submit" value="Verificar Pr&eacute;stamo" class="input" onClick="validaPrestamo();desactiva2();"/>
                </span>
                
                -->
                
                
                
               
               
                
                <div class="row660" align="center">&nbsp;</div> 
                    
                        <div id="titleg664x16">Tipo de Pr&eacute;stamo</div>
                        <div align="center" class="submit664"> 
                            <%
                            Map<String, Integer> clavePrestamoOp = new HashMap<String, Integer>();
                            clavePrestamoOp.put("Comision anticipada", 1);
                            clavePrestamoOp.put("Otro", 2);                        
                            %>                        
                            <spring:bind path="prestamoEmpleado.cvePrestamo">                            
                                <select name="${status.expression}" class="select" >
                                    <c:forEach var="clavePrestamoItem" items="<%=clavePrestamoOp%>">
                                        <option value="<c:out value='${clavePrestamoItem.value}'/>" 
                                                <c:if test="${status.value == clavePrestamoItem.value}"> 
                                                    selected="selected"                                            
                                                </c:if> 
                                        >
                                            <c:out value="${clavePrestamoItem.key}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </spring:bind>
                        </div>
                
                <div class="row660" align="center">&nbsp;</div> 
                <div id="titleg664x16">Condiciones</div>
       
        <div align="center">
            <spring:bind path="prestamoEmpleado.condicionPrestamo">
                <textarea name="${status.expression}" id="condicionPrestamoFrm" value="${status.value}" cols="90" rows="7" wrap="physical" class="input" onChange="javascript:this.value=this.value.toUpperCase();"></textarea>
            </spring:bind>
        </div>
    
    <div class="row660">
        <label class="label330">No de Quincena a Aplicar:&nbsp;&nbsp;</label>
        <span class="field330">
            <spring:bind path="prestamoEmpleado.numQuincenaAplicacion">
                <input type="text" name="${status.expression}" id="numQuincenaAplicacionFrm"  value="${status.value}" class="input"/>
            </spring:bind>
        </span>
        <label class="label330">Año de Quincena a Aplicar (aaaa):&nbsp;&nbsp;</label>
        <span class="field330">
            <spring:bind path="prestamoEmpleado.anioQuincenaAplicacion">
                <input type="text" name="${status.expression}" id="anioQuincenaAplicacionFrm"  value="${status.value}" class="input"/>
            </spring:bind>
        </span>
    </div>
    <div class="row660">
        <label class="label330">Total del pr&eacute;stamo:&nbsp;&nbsp;</label>
        <span class="field330">
            <spring:bind path="prestamoEmpleado.totalPrestamo">
                <input type="text" name="${status.expression}" id="totalPrestamoFrm"  value="${status.value}" class="input"/>
            </spring:bind>
        </span>
    </div>
    <div class="row660">
        <label class="label330">No. de pagos regulares:&nbsp;&nbsp;</label>
        <span class="field330">
            <spring:bind path="prestamoEmpleado.numPagosTotales">
                <input type="text" name="${status.expression}" value="${status.value}" id="numPagosTotalesFrm" class="input"/>
            </spring:bind>
        </span>
    </div>
    <div class="row660">
        <div align="center" class="submit664">
        <input type="button" value="Calcular importe Pago Regular" onclick="calcularImportePagoRegular()" class="input">   
        </div>
    </div>
    <div class="row660">
    <label class="label330">Importe pago regular:&nbsp;&nbsp;</label> 
    <span class="field330">
    <spring:bind path="prestamoEmpleado.importePagosRegular">
        <input type="text" name="${status.expression}" value="${status.value}"  id="importePagosRegularFrm" class="input" readonly/>
    </spring:bind>
    
    </span>
    </div>
        
   

<div align="center" class="submit664">
            <!--input type="button" class="input" id="val" value="Validar prestamos empleado" onClick="validaPrestamos();"/-->            
            <input type="submit" class="input"  name="_finish" id="registrar" value="Registrar"/>
            <input type="reset" name="reset" value="Limpiar" class="input"/>
            <a href="<c:url value="/"/>app/logoutcontroller">
                <input type="button" value="Salir" class="input" tabindex="9"/>
            </a>
        </div>
    
</form>
</spring:nestedPath>
</body>
</html>
