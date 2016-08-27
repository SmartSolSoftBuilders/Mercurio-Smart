<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map, java.util.HashMap"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" 
        content="text/html; charset=iso-8859-1" />
        
        <link href="<c:url value="/css/stilosForms.css" />" 
        rel="stylesheet" type="text/css"/>
        
        <link href="<c:url value="/css/stilosCal.css" />" 
        rel="stylesheet" type="text/css"/>
        
        <script language="JavaScript" 
        src="<c:url value="/js/calendario.js" />" type="text/javascript">
            </script>
            
        <script language="JavaScript" 
        src="<c:url value="/js/AnchorPosition.js"/>" type="text/javascript">
            </script>
            
        <script language="JavaScript" 
        src="<c:url value="/js/date.js"/>" type="text/javascript">
            </script>
            
        <script language="JavaScript" 
        src="<c:url value="/js/PopupWindow.js"/>" type="text/javascript">
            </script>
            
        <script language="JavaScript" 
        src="<c:url value="/js/GUIHelper.js"/>" type="text/javascript">
            </script>
            
        <script language="JavaScript" type="text/javascript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
        </script>
        
        <script type="text/javascript">
            function cambioValorTipoMovimiento(){ 
                document.getElementById("tipoMovimientoPolizaFrm").value = "C";
                document.forms[0].cambioPoliza.disabled=false;
            } 
        </script>
        <title>Registro de p&oacute;lizas de seguro emitidas</title>
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <tag:errors name="datosPoliza"/>
        <spring:nestedPath path="datosPoliza">
           <div ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;background-color:white;">
            </div>
            <form action="#" method="post" name="w01">
                <input type="hidden" name="_page1" value="1" />
                <div id="titleg664x16">Registro de p&oacute;lizas de seguro emitidas.</div>
                <div class="row660">
                    <label class="label330">Consignatario:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.numConsignatario">
                            <input type="text" name="${status.expression}" id="numConsignatarioFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="1"/>
                        </spring:bind>
                    </span>
                    <label class="label330">P&oacute;liza:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.numPoliza">
                            <input type="text" name="${status.expression}" id="numPolizaFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="2"/>    
                        </spring:bind>
                    </span>
                </div>
                <div class="row660">
                    <label class="label330">CIS:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.agrupacionCIS">
                            <input type="text" name="${status.expression}" id="agrupacionCIS" value="${status.value}" class="input" size="10" maxlength="10" tabindex="3"/>    
                        </spring:bind>
                    </span>
                   <label class="label330">Fecha de expedici&oacute;n:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.fechaExpedicion">
                            <input type="text" name="${status.expression}" id="fechaExpedicionFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="4"/>
                            <a href="#" onClick="cal18.select(document.forms[0].fechaExpedicionFrm,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18" tabindex="5">
                                <img src="<c:url value="/"/>img/calendario3.png" alt="calendario" />
                            </a>
                         </spring:bind>
                    </span>
                </div>
                <div class="row660">
                    <label class="label330">Fecha inicio vigencia:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.fechaInicioVigencia">
                            <input type="text" name="${status.expression}" id="fechaInicioVigenciaFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="6"/>
                            <a href="#" onClick="cal18.select(document.forms[0].fechaInicioVigenciaFrm,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18" tabindex="7">
                                <img src="<c:url value="/"/>img/calendario3.png" alt="calendario" />
                            </a>
                           </spring:bind>
                           
                    </span>
                    <label class="label330">Fecha fin vigencia:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.fechaFinVigencia">
                            <input type="text" name="${status.expression}" id="fechaFinVigenciaFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="8"/>
                            <a href="#" onClick="cal18.select(document.forms[0].fechaFinVigenciaFrm,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18" tabindex="9">
                                <img src="<c:url value="/"/>img/calendario3.png" alt="calendario" />
                            </a>
                        </spring:bind>
                            
                    </span>
                </div>
                <div class="row660">
                    <label class="label330">Suma BAF:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.sumaBAF">
                            <input type="text" name="${status.expression}" value="${status.value}" class="input" size=7 maxlength="7" tabindex="10" />
                        </spring:bind>
                    </span>
                </div>
                <div class="row660">
                    <label class="label330">Suma asegurada individual:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.sumaAseguradaIndividual">
                            <input type="text" name="${status.expression}" id="sumaAseguradaIndividualFrm" value="${status.value}" class="input" size=7 maxlength="7" tabindex="10" />
                        </spring:bind>
                    </span>

                    <label class="label330">Suma Gastos Funerarios:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.sumaGastosFunerarios">
                            <input type="text" name="${status.expression}" value="${status.value}" 
                            class="input" size="7" maxlength="7" tabindex="11" id="sumaGastosFunerariosFrm"/>
                        </spring:bind>
                    </span>
                </div>

                <div class="row660">
                    <label class="label330">Suma SEVI:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.sumaSEVI">
                            <input type="text" name="${status.expression}" 
                            id="sumaSEVIFrm"
                            value="${status.value}" class="input" size="7" maxlength="7" tabindex="12"/>
                        </spring:bind>
                    </span>

                    <label class="label330">Tipo de seguro:&nbsp;&nbsp;</label>
                    <span class="field330">
                        
                        <input type="text" name="nombrePaquete"  id="nombrePaqueteFrm" 
                        value="${datosPoliza.polizaIndividual.descripcionPaqueteVidadxn}${datosPoliza.polizaIndividual.descripcionTipoSeguro}"
                        class="input" size="15" tabindex="13" readonly />
                        
                        <a href="javascript:launch('obtenerTipoSeguro','Paquetes Descuento x Nomina -Seleccione un registro de la lista-','Id: :idPaqueteVidaDxN:tipoSeguroFrm:f:t,Paquete: :nombrePaquete:nombrePaqueteFrm:t:t,Descripcion: :descripcionPaquete:descripcionPaqueteFrm:t:f','',500,300);" tabindex="14">
                                <img src="<c:url value="/"/>img/helper.png" alt="Buscar Paquetes"/></a>
                        <spring:bind path="polizaIndividual.tipoSeguro">
                            <input type="hidden"
                                   name="${status.expression}"
                                   id="tipoSeguroFrm"
                                   value="${status.value}"
                                   size="10"
                                   class="input" readonly/>&nbsp;
                            </spring:bind>
                              <spring:bind path="polizaIndividual.tipoMovimientoPoliza">
				                     <input type="hidden" name="${status.expression}" id="tipoMovimientoPolizaFrm" 
				                     value="A" readonly class="input"/>
				                </spring:bind>
                
                    </span>
                    <label class="label330">Ahorro Mensual Adicional:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="polizaIndividual.importeAhorroAdicionalMensual">
                            <input type="text" name="${status.expression}" 
                            id="importeAhorroAdicionalMensualFrm"
                            value="${status.value}" class="input" size="7" maxlength="7" tabindex="14"/>
                        </spring:bind>
                    </span>
                </div>
                
               
              
                
               <span>&nbsp;</span>
            	<div id="titleg664x16">Registro de beneficios adicionales de p&oacute;liza.</div>
                <div class="row660">
                	<label class="label330">&nbsp;</label>
                	<span class="field330">&nbsp;&nbsp;Costo del Beneficio &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Monto de la Cobertura</span>
                </div>
                <c:forEach items="${datosPoliza.beneficiosPoliza}" var="beneficio" varStatus="iStatus">
                	<div class="row660">
	                  
	                    <label class="label330">${beneficio.descripcionBeneficio}:</label>
	                    <span class="field330">
	                            <spring:bind path="datosPoliza.beneficiosPoliza[${iStatus.index}].sumaBeneficio">
	                           	 <input type="text" name="${status.expression}" 
	                           	 size="13"
	                           	 id="${status.expression}" value="${status.value}" class="input"/>
	                           	 </spring:bind>
	                           	 &nbsp;&nbsp;
	                           	 <spring:bind path="datosPoliza.beneficiosPoliza[${iStatus.index}].montoCobertura">
	                           	 <input type="text" name="${status.expression}" 
	                           	 size="13"
	                           	 id="${status.expression}" value="${status.value}" class="input"/>
	                           	 </spring:bind>
	                       		 
	                    </span>
	                    
	               		 </div>
	               		
                
                </c:forEach>
                <span>&nbsp;</span>
                <div align="center" class="submit664">
                    <input type="reset" value="Limpiar." class="input" tabindex="15"/>
                    <input type="submit" value="Registrar." class="input" name="_finish"  tabindex="16"/>
                    <input type="submit" value="Cancelar." class="input" name="_cancel" tabindex="17"/>
                    <a href="<c:url value="/"/>app/logoutcontroller">
                        <input type="button" value="Salir" class="input" tabindex="18"/>
                        </a>
                </div>
             </form>
        </spring:nestedPath>
        <script type="text/javascript">
        esModificacion = ${datosPoliza.modificacion};
        if(esModificacion){
        	document.getElementById("numConsignatarioFrm").disabled=true;
        	document.getElementById("numPolizaFrm").disabled=true;
        	document.getElementById("agrupacionCIS").disabled=true;
        	document.getElementById("fechaExpedicionFrm").disabled=true;
        	document.getElementById("fechaInicioVigenciaFrm").disabled=true;
        	document.getElementById("fechaFinVigenciaFrm").disabled=true;
        	document.getElementById("sumaAseguradaIndividualFrm").disabled=true;
        	document.getElementById("sumaGastosFunerariosFrm").disabled=true;
        	document.getElementById("sumaSEVIFrm").disabled=true;
        	document.getElementById("nombrePaqueteFrm").disabled=true;
        }
        
        
        </script>
    </body>
</html>
