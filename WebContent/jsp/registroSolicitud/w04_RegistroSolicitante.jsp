<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Map, java.util.HashMap"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=iso-8859-1" />
        
        <link href="<c:url value="/css/stilosForms.css" />" 
              rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" 
              rel="stylesheet" type="text/css">
        <script type="text/javascript" language="JavaScript"
                src="<c:url value="/js/calendario.js" />">
        </script>
        <script type="text/javascript" language="JavaScript"
                src="<c:url value="/js/AnchorPosition.js"/>">
        </script>
        <script type="text/javascript" language="JavaScript"
                src="<c:url value="/js/date.js"/>">
        </script>
        <script type="text/javascript" language="JavaScript"
                src="<c:url value="/js/PopupWindow.js"/>">
        </script>
        
        <script type="text/javascript" language="JavaScript">
            
            function examenMedico(){
            var fechaNacLimite= new Date();
            fechaNacLimite.setFullYear(1937,0,1);
            var diaNacSolic;
            diaNacSolic=document.getElementById('fechaNacimientoSolicitanteFrm').value.substr(0,2),10;
             var mesNacSolic
                 mesNacSolic=document.getElementById('fechaNacimientoSolicitanteFrm').value.substr(3,2),10;
            var anioNacSolic=document.getElementById('fechaNacimientoSolicitanteFrm').value.substr(6);
             
            var fechaNacSolic=new Date();
            fechaNacSolic.setFullYear(anioNacSolic,(mesNacSolic-1),diaNacSolic);
            
            if(fechaNacSolic < fechaNacLimite)
            alert("El solicitante requiere examen m&eacute;dico");
        }
        </script>
        
        <script language="JavaScript" type="text/javascript">

	
          function examenMedico(){
		 var fechaNacLimite= new Date();
            fechaNacLimite.setFullYear(1937,0,1);
		//alert(fechaNacLimite);
            var fechaNacSolicForm=document.form.fechaNacimientoSolicitanteFrm.value;
		//alert("fechaNacSolicForm: "+fechaNacSolicForm);              
      
diaSol=parseInt(fechaNacSolicForm.substr(0,2),10);
mesSol=parseInt(fechaNacSolicForm.substr(3,2),10);
anioSol=parseInt(fechaNacSolicForm.substr(6));

//alert("el dia que quiero "+diaSol);
//alert("el mes que quiero "+mesSol);
//alert("el anio que quiero "+anioSol);

var fechaNacSolicJavaScript=new Date();
fechaNacSolicJavaScript.setFullYear(
					anioSol,
					mesSol-1,
					diaSol
				     );

//alert("fechaNacSolicJavaScript: "+fechaNacSolicJavaScript);

if(fechaNacSolicJavaScript < fechaNacLimite)
alert("El solicitante requiere exámen médico");
if (confirm("¿Desea continuar con la captura?")){
form.sig.disabled = false}
else{
alert("De click en el botón 'Cancelar' del formulario");}

        }

        </script>
        
        <script language="JavaScript" type="text/javascript">

	
          function mayorEdad(){
		 var fechaActual= new Date();
            var anioActual=parseInt(fechaActual.getFullYear());
	    var mesActual=parseInt(fechaActual.getMonth() + 1); 	
	    var diaActual=parseInt(fechaActual.getDate());		
		//alert(fechaActual);
            var fechaNacSolicForm=document.form.fechaNacimientoSolicitanteFrm.value;
		//alert("fechaNacSolicForm: "+fechaNacSolicForm);              
      
diaSol=parseInt(fechaNacSolicForm.substr(0,2),10);
mesSol=parseInt(fechaNacSolicForm.substr(3,2),10);
anioSol=parseInt(fechaNacSolicForm.substr(6));


/*alert("mi anio"+anioActual);
alert("mi mes"+mesActual);
alert("mi dia"+diaActual);*/
//alert("el dia que quiero "+diaSol);
//alert("el mes que quiero "+mesSol);
//alert("el anio que quiero "+anioSol);




var difAnios=anioActual - (anioSol);
//alert(difAnios);
var difMes=mesActual  - mesSol;
//alert(difMes);
var difDia=diaActual- diaSol;
//alert(difDia);


if(difMes < 0 ){
		edadReal=difAnios;
		//alert("edad0: "+edadReal);
	       }

else{
	if(difMes >0){
	        	var edadReal=difAnios+1;
			//alert("edadReal1: "+edadReal);
		     }
	else{
		if(difDia >= 0){
				edadReal=difAnios+1;			
				//alert("edadReal2: "+edadReal);
			       }

		else{
			edadReal=difAnios;
			//alert("edadReal3: "+edadReal);
		    }
     	    }

     }

if(edadReal < 18){
  alert("El solicitante no cumple con la edad mínima para contratar una Póliza");
  alert("De click en el boton 'Cancelar'");
        }
        
        else{
        alert("El solicitante cumple con la edad para realizar el trámite");
        examenMedico(); }
}
        </script>
        
        
        <script type="text/javascript" language="JavaScript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
        </script>
        <title>
            Registro del Solicitante
        </title>      
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <DIV ID="testdiv1" 
             STYLE="position:absolute;visibility:hidden;background-color:white;">
        </DIV>
        <tag:errors name="datosSolicitud"/>
        <!--spring:nestedPath path="datosSolicitante"-->
        <spring:nestedPath path="datosSolicitud">
            <div ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;background-color:white;">
            </div>
            <form action="#" method="post" name="form">
                <div>
                    <input type="hidden" name="_page3" value="3" />
                    <!--input type="hidden" name="_target4" value="true" /-->
                </div>
                <div id="titleg664x16">
                    Registro del Solicitante.
                </div>
                <!-- No. de Empleado -->
                <div class="row660">
                    <label class="label330">
                        No. de Empleado:&nbsp;&nbsp;
                    </label>
                    <span class="field330">
                        <spring:bind path="solicitud.contratante.numNominaContratante">
                            <c:choose>
                                <c:when test="${datosSolicitud.solicitud.tipoSolicitudNormal}" >
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="numNominaContratanteFrm" 
                                           class="input" 
                                           value="${datosSolicitud.solicitud.contratante.numNominaContratante}" 
                                           size="15" 
                                           tabindex="1"
                                           readonly="true"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:when>
                                <c:otherwise>
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="numNominaContratanteFrm" 
                                           class="input" 
                                           value="${status.value}" 
                                           size="15"  maxlength="13"
                                           tabindex="1" 
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:otherwise>
                            </c:choose>
                        </spring:bind>
                        <!--/c:if-->
                        
                    </span>
                </div>	
                <!-- Apellidos -->
                <div class="row660">
                    <label class="label135">
                        Apellido Paterno:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.apPaternoSolicitante">
                            <c:choose>
                                <c:when test="${datosSolicitud.solicitud.tipoSolicitudNormal}" >
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="apPaternoSolicitanteFrm" 
                                           class="input" 
                                           value="${datosSolicitud.solicitud.contratante.apPaternoContratante}" 
                                           size="20" 
                                           tabindex="2"
                                           readonly="true"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:when>
                                <c:otherwise>
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="apPaternoSolicitanteFrm" 
                                           class="input" 
                                           value="${status.value}" 
                                           size="20" 
                                           tabindex="2" 
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:otherwise>
                            </c:choose>
                        </spring:bind>
                    </span>
                    <label class="label135">
                        Apellido Materno:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.apMaternoSolicitante">
                            <c:choose>
                                <c:when test="${datosSolicitud.solicitud.tipoSolicitudNormal}" >
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="apMaternoSolicitanteFrm" 
                                           class="input" 
                                           value="${datosSolicitud.solicitud.contratante.apMaternoContratante}" 
                                           size="20" 
                                           tabindex="3"
                                           readonly="true"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:when>
                                <c:otherwise>
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="apMaternoSolicitanteFrm" 
                                           class="input" 
                                           value="${status.value}" 
                                           size="20" 
                                           tabindex="3"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:otherwise>
                            </c:choose>
                        </spring:bind>
                    </span>
                </div>
                <!-- Nombre(s) -->
                <div class="row660">
                    <label class="label135">
                        Primer Nombre:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.nombre1Solicitante">
                            <c:choose>
                                <c:when test="${datosSolicitud.solicitud.tipoSolicitudNormal}" >
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="nombre1SolicitanteFrm" 
                                           class="input" 
                                           value="${datosSolicitud.solicitud.contratante.nombre1Contratante}" 
                                           size="20" 
                                           tabindex="4"
                                           readonly="true"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:when>
                                <c:otherwise>
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="nombre1SolicitanteFrm" 
                                           class="input" 
                                           value="${status.value}" 
                                           size="20" 
                                           tabindex="4" 
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:otherwise>
                            </c:choose>
                        </spring:bind>
                    </span>
                    <label class="label135">
                        Segundo Nombre:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.nombre2Solicitante">
                            <c:choose>
                                <c:when test="${datosSolicitud.solicitud.tipoSolicitudNormal}" >
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="nombre2SolicitanteFrm" 
                                           class="input" 
                                           value="${datosSolicitud.solicitud.contratante.nombre2Contratante}" 
                                           size="20" 
                                           tabindex="5"
                                           readonly="true"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:when>
                                <c:otherwise>
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="nombre2SolicitanteFrm" 
                                           class="input" 
                                           value="${status.value}" 
                                           size="20" 
                                           tabindex="5"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:otherwise>
                            </c:choose>
                        </spring:bind>
                    </span>	
                </div>
                <!-- RFC y Fecha de Nacimiento -->
                <div class="row660">
                    <label class="label135">
                        RFC:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.RFCsolicitante">
                            <c:choose>
                                <c:when test="${datosSolicitud.solicitud.tipoSolicitudNormal}" >
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="RFCsolicitanteFrm" 
                                           class="input" 
                                           value="${datosSolicitud.solicitud.contratante.numNominaContratante}" 
                                           size="15" 
                                           tabindex="6"
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:when>
                                <c:otherwise>
                                    <input type="text" 
                                           name="${status.expression}" 
                                           id="RFCsolicitanteFrm" 
                                           class="input" 
                                           value="${status.value}" 
                                           size="15" maxlength="13" 
                                           tabindex="6" 
                                           onChange="javascript:this.value=this.value.toUpperCase();"/>
                                    
                                </c:otherwise>
                            </c:choose>
                        </spring:bind>
                    </span>                    
                    <label class="label135">
                        Fecha de Nacimiento:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.fechaNacimientoSolicitante">
                            <input type="text" 
                                   name="${status.expression}" 
                                   id="fechaNacimientoSolicitanteFrm" 
                                   class="input" 
                                   value="${status.value}"  
                                   size="10"  
                                   maxlength="10"
                                   tabindex="7"/>
                            <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoSolicitanteFrm,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                            </A> 
                            <input type="button" value="Valida"    class="input" onClick="mayorEdad();"/>
                        </spring:bind>
                        
                    </span>	
                </div>
                <!-- Puesto e Ingreso mensual -->
                <div class="row660">
                    <label class="label135">
                        Puesto:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.puestoSolicitante">
                            <input type="text" 
                                   name="${status.expression}" 
                                   id="puestoSolicitanteFrm" 
                                   class="input" 
                                   value="${status.value}"  
                                   size="20"
                                   maxlength="25" 
                                   tabindex="8" 
                                   onChange="javascript:this.value=this.value.toUpperCase();"/>
                        </spring:bind>
                    </span>
                    <label class="label135">
                        Ingreso Mensual:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.ingresoMensualSolicitante">
                            <input type="text" 
                                   name="${status.expression}" 
                                   id="ingresoMensualFrm" 
                                   class="input" 
                                   value="${status.value}" 
                                   size="5" 
                                   maxlength="5"
                                   tabindex="9" />
                        </spring:bind>
                    </span>	
                    
                </div>
                <!-- Sexo y Estado Civil -->
                <div class="row660">
                    <label class="label135">
                        Sexo:&nbsp;&nbsp;
                    </label>
                    <span class="field195">                                            
                        <spring:bind path="solicitud.solicitante.sexoSolicitanteMasculino">
                            <input type="radio" 
                                   name="${status.expression}" 
                                   value=true
                                   <c:if test="${status.value}">
                                       checked="checked" 
                                   </c:if>
                                   tabindex="10" />
                            <label>Masculino.&nbsp;&nbsp;</label>       
                            <input type="radio" 
                                   name="${status.expression}" 
                                   value=false
                                   <c:if test="${!status.value}">
                                       checked="checked"
                                   </c:if>
                                   tabindex="11" />
                            <label>Femenino.&nbsp;&nbsp;</label>
                        </spring:bind>
                    </span>	
                    <label class="label135">
                        Estado Civil:&nbsp;&nbsp;
                    </label>
                    <span class="field195">
                        <!--spring:bind path="DatosSolicitudCommand.indexofTheSelectedEdoCivil"-->
                        <%/*spring:bind path="solicitud.solicitante.estadoCivilSolicitante">
                        <select name="comboEdoCivil">
                        <c:forEach var="edoCivil" items="${optionsComboEstadoCivil}">
                        <OPTION value="<c:out value="${edoCivil.value}"/>"><c:out value="${edoCivil.label}"/>
                        </OPTION>
                        <!--option> 
                        
                        </option!!>
                        </c:forEach>
                        </select>
                        </spring:bind*/%>
                        <%/*!--select name="comboEdoCivil" class="select">
                        <option>Soltero</option>
                        <option>Casado</option>
                        <option>Divorciado</option>
                        <option>Viudo</option>
                        <option>Separado</option>
                        <option>Uni&oacute;n Libre</option>
                        </select-->                      
                        <!--/spring:bind-->
                        <!--form:form commandName="datosSolicitud"--*/%>
                        <%
                        /*String[] estadoCivil = new String[]{
                        "Soltero",
                        "Casado",
                        "Divorciado",
                        "Viudo",
                        "Separado",
                        "UniÃ³n Libre"
                        };*/
                        // El mugroso estadoCivilSolicitante es char:
                        //Map<String, Character> estadoCivil = new HashMap<String, Character>();
                        Map<String, Long> estadoCivil = new HashMap<String, Long>();
                        estadoCivil.put("Soltero", 1L);
                        estadoCivil.put("Casado", 2L);
                        estadoCivil.put("Divorciado", 3L);
                        estadoCivil.put("Viudo", 4L);
                        estadoCivil.put("Separado", 5L);
                        estadoCivil.put("Uni&oacute;n Libre", 6L);
                        %>
                        <spring:bind path="solicitud.solicitante.estadoCivilSolicitante">
                            <select name="${status.expression}" class="select" tabindex="12" >
                                <c:forEach var="estadoCivilItem" items="<%=estadoCivil%>">
                                    <!--c:forEach var="estadoCivilItem" 
                                    items="<{solicitudBusiness.estadoCivil}>"-->
                                    <option value="<c:out value='${estadoCivilItem.value}'/>"
                                            <c:if test="${status.value == estadoCivilItem.value}">
                                                selected="selected"
                                            </c:if>
                                    >
                                        <c:out value="${estadoCivilItem.key}"/>
                                    </option>
                                </c:forEach>
                            </select>
                            <%/*font color="red"><c:out value="${status.errorMessage}"/></font*/%>
                        </spring:bind>
                    </span>
                </div>
                <!-- Botones -->
                <div align="center" class="submit664">
                    <input type="submit" 
                           value="Anterior." 
                           class="input" 
                           name="_target2" 
                           tabindex="13"/>
                    <input type="submit" 
                           value="Cancelar." 
                           class="input" 
                           name="_cancel" 
                           tabindex="14"/>
                    <input type="reset" 
                           value="Limpiar." 
                           class="input" 
                           tabindex="15"/>
                    <input type="submit" 
                           id="sig"
                           value="Siguiente." 
                           class="input" 
                           name="_target4" 
                           tabindex="16" 
                           disabled/>
                             
                             
                         </div>
            </form>
        </spring:nestedPath>
    </body>
</html>
