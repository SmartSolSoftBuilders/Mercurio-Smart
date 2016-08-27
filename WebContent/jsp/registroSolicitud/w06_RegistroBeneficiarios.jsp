<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/calendario.js"/>"></script>
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/AnchorPosition.js"/>"></script>
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/date.js"/>"></script>
        <script type="text/javascript"language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script type="text/javascript">
            var numeroDeBeneficiarios = 1;
        </script>
        <script language="JavaScript" type="text/javascript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
        </script>
        <script type="text/javascript" >

            function agregarBeneficiario() {
                //alert("Beneficiario_" + numeroDeBeneficiarios);
                if(numeroDeBeneficiarios < 8) {
		        	var beneficiario = document.getElementById(
                                    "Beneficiario_" + numeroDeBeneficiarios);
		        	beneficiario.style.display = 'block';
                	var numBenf = 
                            document.getElementById("numeroBeneficiariosFrm");
                	numeroDeBeneficiarios++;
                	numBenf.value = numeroDeBeneficiarios;
                	//alert("numBenf" + numBenf.value);
                }
            }

            function quitarBeneficiario() {
                //alert("Beneficiario_" + numeroDeBeneficiarios);
                if(numeroDeBeneficiarios > 1) {
                	numeroDeBeneficiarios--;
			        var beneficiario = 
                                    document.getElementById(
                                        "Beneficiario_" + numeroDeBeneficiarios);
			        beneficiario.style.display = 'none';
        	        var numBenf = 
                            document.getElementById("numeroBeneficiariosFrm");
            	    numBenf.value = numeroDeBeneficiarios;
                	//alert("numBenf" + numBenf.value);
                }
            }

          
            
            
            
        </script>
        <script type="text/javascript">
            function mostrarNumeroDeBeneficiarios(){
        	    var numBenf = document.getElementById("numeroBeneficiariosFrm") ;
                    alert("numBenf" + numBenf.value);
            }
        </script>
        
        <script type="text/javascript">
            function mostrarValidacion(){
        	    if(document.form.apPaternoBeneficiarioFrm_0.value != ""){
                        if ((document.form.nombre1BeneficiarioFrm_0.value !="")){
                            if((document.form.fechaNacimientoBeneficiarioFrm_0.value !="")){
                                if((document.form.parentescoFrm_0.value !="")){
                                    if((document.form.porcentajeAsignadoFrm_0.value !=0)){
                                        validaPorcentaje();
                                    }
                                    else{
                                            alert("el campo porcentaje esta vacio");
                                    }
                                }
                                else{
                                        alert("el campo parentesco esta vacio");
                                }
                            }
                            else{
                                    alert("el campo fecha de nacimiento esta vacio");
                            }
                        }
                        else{
                                alert("el campo primer nombre esta vacio");
                        }
                   }     
                   else{
                                alert("el campo apellido paterno esta vacio");
                   }
              }
        </script>
        <script type="text/javascript">
            function validaPorcentaje(){
            
            var porc1=isNaN(document.form.porcentajeAsignadoFrm_0.value) || document.form.porcentajeAsignadoFrm_0.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_0.value);
            //alert("porcentaje1"+porc1);
            var porc2=isNaN(document.form.porcentajeAsignadoFrm_1.value) || document.form.porcentajeAsignadoFrm_1.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_1.value);
           // alert("porcentaje2"+porc2);
            var porc3=isNaN(document.form.porcentajeAsignadoFrm_2.value) || document.form.porcentajeAsignadoFrm_2.value == ""
			?0:parseFloat(document.form.porcentajeAsignadoFrm_2.value);
           // alert("porcentaje3"+porc3);
            var porc4=isNaN(document.form.porcentajeAsignadoFrm_3.value) || document.form.porcentajeAsignadoFrm_3.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_3.value);
           // alert("porcentaje4"+porc4);
            var porc5=isNaN(document.form.porcentajeAsignadoFrm_4.value) || document.form.porcentajeAsignadoFrm_4.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_4.value);
           // alert("porcentaje5"+porc5);
            var porc6=isNaN(document.form.porcentajeAsignadoFrm_5.value) || document.form.porcentajeAsignadoFrm_5.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_5.value);
          //  alert("porcentaje6"+porc6);
            var porc7=isNaN(document.form.porcentajeAsignadoFrm_6.value) || document.form.porcentajeAsignadoFrm_6.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_6.value);
          //  alert("porcentaje7"+porc7);
            var porc8=isNaN(document.form.porcentajeAsignadoFrm_7.value) || document.form.porcentajeAsignadoFrm_7.value == ""
            ?0:parseFloat(document.form.porcentajeAsignadoFrm_7.value);
          //  alert("porcentaje8"+porc8);
            
            var totalPorc=0.0;
            totalPorc=porc1+porc2+porc3+porc4+porc5+porc6+porc7+porc8;
                     
            if (totalPorc !=100 )
            alert("porcentaje no valido");
            
            else
            alert("Porcentaje Correcto \n Para finalizar la captura de clic en el botón 'Guardar'");
            form.Save.disabled=false
            }
        </script>
        <script type="text/javascript">
        	function quitarLinkAgregar() {
        		   var divVinculos = document.getElementById("divVinculos");
				   if(document.form.porcentajeAsignadoFrm_0.value >= 100) {
					   divVinculos.style.display = "none";
				   }
				   else {
					   divVinculos.style.display = "block";
				   }
        	}
        </script>
        <title>Registro de Beneficiarios</title>
        
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <tag:errors name="datosSolicitud" />
        <spring:nestedPath path="datosSolicitud">
            <DIV ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;background-color:white;">
            </DIV>
            <form action="#" method="post" name="form">
                <div>
                    <input type="hidden" name="_page5" value="5" />
                    <!--input type="hidden" name="_finish" value="true" /-->
                    <spring:bind 
                        path="solicitud.beneficiario[0].numBeneficiarios">
                        <input type="hidden" 
                               name="${status.expression}" 
                               id="numeroBeneficiariosFrm" 
                               value="${status.value}" 
                               size="2"  
                        />
                    </spring:bind>                    
                </div>
                <div id="titleg664x16">Registro de beneficiario.</div>
                <div id="unused-sites">
                </div>
                <!-- Beneficiario 0 -->
                <div id="Beneficiario_0">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_0">
                        Primer Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_0">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[0].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="1" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_0">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_0">
                            <spring:bind 
                                path="solicitud.beneficiario[0].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="2"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-0">
                        <label class="label135" id="NombresLab_5_0-0">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-0">
                            <spring:bind 
                                path="solicitud.beneficiario[0].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="3"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[0].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="4"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco-0">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[0].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10"
                                       maxlength="10"
                                       tabindex="5"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_0,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[0].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="6"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo:   -->
                    <div class="row660" id="Porc_0">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[0].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_0" 
                                       value="${status.value}"
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                       tabindex="7"
									   onblur = "quitarLinkAgregar()"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_0">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[0].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="8" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" value=false tabindex="9" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>
                </div>
                
                <!-- Beneficiario 1 -->
                <div id="Beneficiario_1" style="display:none">
                    
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_1">
                        Segundo Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_1">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[1].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="10" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_1">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_1">
                            <spring:bind 
                                path="solicitud.beneficiario[1].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="11"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-1">
                        <label class="label135" id="NombresLab_5_0-1">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-1">
                            <spring:bind 
                                path="solicitud.beneficiario[1].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="12"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[1].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="13"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_1">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[1].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10"
                                       tabindex="14" 
                                       maxlength="10"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_1,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[1].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="15"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_1">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[1].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="16" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_1">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[1].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="17" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" 
                                       name="${status.expression}" 
                                       value=false 
                                       tabindex="18" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Beneficiario 2 -->
                <div id="Beneficiario_2" style="display:none">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_2">
                        Tercer Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_2">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[2].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="19" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_2">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_2">
                            <spring:bind 
                                path="solicitud.beneficiario[2].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-2">
                        <label class="label135" id="NombresLab_5_0-2">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-2">
                            <spring:bind 
                                path="solicitud.beneficiario[2].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="21"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[2].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="22"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_2">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[2].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10" 
                                       tabindex="23" 
                                       maxlength="10"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_2,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[2].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="24"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_2">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[2].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="22" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_2">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[2].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="26" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" 
                                       value=false tabindex="27" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Beneficiario 3 -->
                <div id="Beneficiario_3" style="display:none">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_3">
                        Cuarto Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_3">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[3].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="28"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                       
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_3">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_3">
                            <spring:bind 
                                path="solicitud.beneficiario[3].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="29"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-3">
                        <label class="label135" id="NombresLab_5_0-3">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-3">
                            <spring:bind 
                                path="solicitud.beneficiario[3].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="30"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[3].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="31"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_3">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[3].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10" 
                                       tabindex="31" 
                                       maxlength="10"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_3,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[3].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="32"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_3">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[3].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="33" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_3">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[3].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="34" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" 
                                       value=false tabindex="35" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Beneficiario 4 -->
                <div id="Beneficiario_4" style="display:none">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_4">
                        Quinto Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_4">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[4].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="36" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_4">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_4">
                            <spring:bind 
                                path="solicitud.beneficiario[4].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="37"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-4">
                        <label class="label135" id="NombresLab_5_0-4">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-4">
                            <spring:bind 
                                path="solicitud.beneficiario[4].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="38"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[4].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="39"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_4">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[4].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10" 
                                       tabindex="40"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_4,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[4].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="41"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_4">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[4].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="42" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_4">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[4].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="43" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" 
                                       value=false tabindex="44" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Beneficiario 5 -->
                <div id="Beneficiario_5" style="display:none">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_5">
                        Sexto Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_5">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[5].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="45" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_5">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_5">
                            <spring:bind 
                                path="solicitud.beneficiario[5].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="46"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-5">
                        <label class="label135" id="NombresLab_5_0-5">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-5">
                            <spring:bind 
                                path="solicitud.beneficiario[5].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="47"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[5].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="48"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_5">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[5].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10" 
                                       tabindex="49" 
                                       maxlength="10"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_5,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[5].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="50"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_5">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[5].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="51" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_5">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[5].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="52" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" 
                                       value=false tabindex="53" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Beneficiario 6 -->
                <div id="Beneficiario_6" style="display:none">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_6">
                        S&eacute;ptimo Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_6">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[6].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="54" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_6">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_6">
                            <spring:bind 
                                path="solicitud.beneficiario[6].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="55"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-6">
                        <label class="label135" id="NombresLab_5_0-6">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-6">
                            <spring:bind 
                                path="solicitud.beneficiario[6].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="56"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[6].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="57"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_6">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[6].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10" 
                                       tabindex="58" 
                                       maxlength="10"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_6,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[6].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="59"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_6">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[6].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="60" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_6">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[6].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="61" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" 
                                       value=false tabindex="62" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Beneficiario 7 -->
                <div id="Beneficiario_7" style="display:none">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_7">
                        Octavo Beneficiario
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_7">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[7].apPaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoBeneficiarioFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="63" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_7">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_7">
                            <spring:bind 
                                path="solicitud.beneficiario[7].apMaternoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoBeneficiarioFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="64"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-7">
                        <label class="label135" id="NombresLab_5_0-7">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_0-7">
                            <spring:bind 
                                path="solicitud.beneficiario[7].nombre1Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1BeneficiarioFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="65"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[7].nombre2Beneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2BeneficiarioFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="66"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="FNAC_y_parentesco_7">
                        <label class="label135">
                            Fecha de Nacimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[7].fechaNacimientoBeneficiario">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="fechaNacimientoBeneficiarioFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="10" 
                                       tabindex="67" 
                                       maxlength="10"
                                />
                                <A HREF="#" onClick="cal18.select(document.forms[0].fechaNacimientoBeneficiarioFrm_7,'anchor18','dd/MM/yyyy'); return false;" TITLE="cal18.select(document.forms[0].date18,'anchor1x','dd/MM/yyyy'); return false;" NAME="anchor18" ID="anchor18">
                                    <img alt="calendario"  src="<c:url value="/"/>img/calendario3.png" />
                                </A> 
                            </spring:bind>
                        </span>    
                        <label class="label135">
                            Parentesco:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="solicitud.beneficiario[7].parentesco">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="parentescoFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       tabindex="68"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="Porc_7">
                        <label class="label330">
                            Porcentaje asignado:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[7].porcentajeAsignado">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="porcentajeAsignadoFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       tabindex="69" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 6° Campo: Tipo de beneficiario -->
                    <div class="row660" id="tipoCheckbox_7">
                        <label class="label330">
                            Tipo de beneficiario:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="solicitud.beneficiario[7].tipoBeneficiario">
                                <input type="radio" name="${status.expression}" value=true
                                       <c:if test="${status.value != null && !status.value}">
                                           checked="checked" 
                                       </c:if>
                                       tabindex="71" />
                                <label>Revocable.&nbsp;&nbsp;</label>       
                                <input type="radio" name="${status.expression}" 
                                       value=false tabindex="72" />
                                <label>Irrevocable.&nbsp;&nbsp;</label>
                            </spring:bind>
                        </span>
                    </div>	
                </div>
                <!-- Vinculos para agregar y quitar beneficiarios -->
                <div id = "divVinculos" align="center" class="submit664">
					<c:if test="${document.form.porcentajeAsignadoFrm_0.value == 100}">
						quitarLinkAgregar();
					</c:if>
					<a href="javascript:agregarBeneficiario()">Agregar</a>
                    <a href="javascript:quitarBeneficiario()">Quitar</a>
                </div>
                <div align="center" class="submit664">
                    <input type="button" value="Validar Beneficiarios." 
                           class="input" id= "_finish" name="_finish"  tabindex="76"
                           onclick="javascript:mostrarValidacion();"/>
                </div>
                <br/>
                <!-- Botones de Anterior, Cancelar, Limpiar y Guardar beneficiario -->
                <div align="center" class="submit664">
                    <input type="submit" value="Anterior." 
                           class="input" name="_target4" tabindex="73"/>
                    <input type="submit" value="Cancelar." 
                           class="input" name="_cancel"  tabindex="74"/>
                    <input type="reset" value="Limpiar." 
                           class="input" tabindex="75"/>
                    <c:if test="${datosSolicitud.registroArchivoPolizaOrigen != null && 
         				datosSolicitud.registroArchivoPolizaOrigen > 0}">
                        <input type="submit" value="Siguiente."
                           id="Save"
                           class="input" name="_target6"  tabindex="76"
                           disabled/>
                    </c:if>
                    <c:if test="${  datosSolicitud.registroArchivoPolizaOrigen == null || 
         				datosSolicitud.registroArchivoPolizaOrigen < 0 || 
         				datosSolicitud.registroArchivoPolizaOrigen == 0}">
                        <input type="submit" value="Guardar."
                           id="Save"
                           class="input" name="_finish"  tabindex="76"
                           disabled/>
                    </c:if>

                                     
                </div>
            </form>
        </spring:nestedPath>
    </body>
</html>