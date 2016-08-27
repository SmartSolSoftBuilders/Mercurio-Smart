<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
        <script language="JavaScript" src="<c:url value="/js/calendario.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/AnchorPosition.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/date.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script type="text/javascript">
            var numeroDeContratantes = 0;
        </script>        
        <script type="text/javascript" >

            function agregarContratante() {
                //alert("Contratante_" + numeroDeContratantes);
                if(numeroDeContratantes < 15) {
		        	var Contratante = document.getElementById(
                                    "Contratante_" + numeroDeContratantes);
		        	Contratante.style.display = 'block';
                	var numCtrs = 
                            document.getElementById("numeroContratantesFrm");
                	numeroDeContratantes++;
                	numCtrs.value = numeroDeContratantes;
                	//alert("numCtrs" + numCtrs.value);
                }
            }

            function quitarContratante() {
                //alert("Contratante_" + numeroDeContratantes);
                if(numeroDeContratantes > 1) {
                	numeroDeContratantes--;
			        var contratante = 
                                    document.getElementById(
                                        "Contratante_" + numeroDeContratantes);
			        contratante.style.display = 'none';
        	        var numCtrs = 
                            document.getElementById("numeroContratantesFrm");
            	    numCtrs.value = numeroDeContratantes;
                	//alert("numCtrs" + numCtrs.value);
                }
            }            
        </script>
        <script>
            function mostrarNumeroDeContratantes(){
        	    var numCtrs = document.getElementById("numeroContratantesFrm") ;
                    alert("numCtrs" + numCtrs.value);
            }
        </script>
        <title>Registro de Contratantes</title>
        
    </head>
    
    <body>
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <tag:errors name="movimientosDependencia" />
        <spring:nestedPath path="movimientosDependencia">
            <DIV ID="testdiv1" 
                 STYLE="position:absolute;visibility:hidden;
                 background:white;
                 ">
            </DIV>
            <form action="#" method="post" name="form">
                <div>
                    <input type="hidden" name="_page1" value="1" />
                    <!--input type="hidden" name="_finish" value="true" /-->
                    <spring:bind 
                        path="movimientosDependencia.movimientosDependencia.contratantes[0].numContratantes">
                        <input type="hidden" 
                               name="${status.expression}" 
                               id="numeroContratantesFrm" 
                               value="${status.value}" 
                               size="2"  
                        />
                    </spring:bind>                    
                </div>
                <div id="titleg664x16">Registro de contratante.</div>
                <div id="unused-sites">
                </div>
                <!-- Contratante 0 -->
                <div id="Contratante_0">
                    <!-- 1° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_0">
                        Primer Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_0">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22"                                        
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_0">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_0">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-0">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="13"
                                       maxlength="13"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22"                                      
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_0">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[0].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_0" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>         
                </div>
                
                <!-- Contratante 1 -->
                <div id="Contratante_1" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_1">
                        Segundo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_1">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_1">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_1">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-1">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-1">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22"                                      
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_1">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[1].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_1" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 2 -->
                <div id="Contratante_2" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_2">
                        Tercer Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_2">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_2">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_2">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-2">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-2">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22"                                      
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_2">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[2].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_2" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 3 -->
                <div id="Contratante_3" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_3">
                        Cuarto Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_3">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_3">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_3">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-3">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-3">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22"                                      
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_3">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[3].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_3" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 4 -->
                <div id="Contratante_4" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_4">
                        Quinto Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_4">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_4">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_4">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-4">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-4">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22"                                      
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_4">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[4].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_4" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 5 -->
                <div id="Contratante_5" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_5">
                        Sexto Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_5">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_5">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_5">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-5">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-5">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_5">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[5].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_5" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 6 -->
                <div id="Contratante_6" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_7">
                        Septimo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_6">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_6">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_6">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-6">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-6">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_6">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[6].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_6" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 7 -->
                <div id="Contratante_7" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_7">
                        Octavo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_7">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_7">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_7">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
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
                        <span class="field195" id="NombresSpan_5_1-7">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-7">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_7">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[7].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_7" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 8 -->
                <div id="Contratante_8" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_8">
                        Noveno Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_8">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_8">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_8">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-8">
                        <label class="label135" id="NombresLab_5_0-8">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-8">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-8">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_8">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[8].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_8" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 9 -->
                <div id="Contratante_9" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_9">
                        Decimo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_9">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_9">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_9">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-9">
                        <label class="label135" id="NombresLab_5_0-9">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-9">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-9">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_9">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[9].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_9" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 10 -->
                <div id="Contratante_10" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_10">
                        Onceavo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_10">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_10">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_10">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-10">
                        <label class="label135" id="NombresLab_5_0-10">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-10">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-10">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_10">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[10].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_10" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 11 -->
                <div id="Contratante_11" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_11">
                        Doceavo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_11">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_11">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_11">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-11">
                        <label class="label135" id="NombresLab_5_0-11">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-11">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-11">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_11">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[11].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_11" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 12 -->
                <div id="Contratante_12" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_12">
                        Treceavo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_12">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_12">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_12">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-12">
                        <label class="label135" id="NombresLab_5_0-12">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-12">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-12">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_12">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[12].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_12" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 13 -->
                <div id="Contratante_13" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_13">
                        Catorceavo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_13">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_13">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_13">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-13">
                        <label class="label135" id="NombresLab_5_0-13">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-13">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-13">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_13">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[13].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_13" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                
                <!-- Contratante 14 -->
                <div id="Contratante_14" style="display:none">
                    <!-- 2° DIV T&iacute;tulo Aux -->
                    <div id="titleaux_14">
                        Quinceavo Contratante
                    </div>
                    <!-- 2° Apellidos -->
                    <div class="row660" id="Apellidos_14">
                        <label class="label135">
                            Apellido Paterno:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].apPaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apPaternoContratanteFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />    
                            </spring:bind>
                        </span>
                        <label class="label135" id="ApellidoMaternoLabel_14">
                            Apellido Materno:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="ApellidoMaternoSpan_14">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].apMaternoContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="apMaternoContratanteFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 3° Nombre(s) -->
                    <div class="row660" id="NombresDiv_5-14">
                        <label class="label135" id="NombresLab_5_0-14">
                            Primer Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195" id="NombresSpan_5_1-14">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].nombre1Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre1ContratanteFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>
                        <label class="label135">
                            Segundo Nombre:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].nombre2Contratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="nombre2ContratanteFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />
                            </spring:bind>
                        </span>	
                    </div>
                    <!-- 4° Campo: Fecha de Nacimiento -->
                    <div class="row660" id="RFC_y_Tarifa-14">
                        <label class="label135">
                            RFC Contratante:&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].numNominaContratante">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="numNominaContratanteFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="20"
                                       maxlength="20"
                                       onChange="javascript:this.value=this.value.toUpperCase();"
                                />                                
                            </spring:bind>
                            
                        </span>    
                        <label class="label135">
                            Importe&nbsp;&nbsp;
                        </label>
                        <span class="field195">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].importeTarifa">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="importeTarifaFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="22" 
                                />
                            </spring:bind>
                        </span>
                    </div>
                    <!-- 5° Campo: Porcentaje -->
                    <div class="row660" id="TipoMov_14">
                        <label class="label330">
                            Tipo Movimiento:&nbsp;&nbsp;
                        </label>
                        <span class="field330">
                            <spring:bind 
                                path="movimientosDependencia.movimientosDependencia.contratantes[14].tipoMovimiento">
                                <input type="text" 
                                       name="${status.expression}" 
                                       id="tipoMovimientoFrm_14" 
                                       value="${status.value}" 
                                       class="input" 
                                       size="6" 
                                       maxlength="6"
                                />
                            </spring:bind>
                        </span>
                    </div>                    
                </div>
                <!-- Vinculos para agregar y quitar Contratantes -->
                <div align="center" class="submit664">
                    <a href="javascript:agregarContratante()">Agregar</a>
                    <a href="javascript:quitarContratante()">Quitar</a>
                </div>                
                <br/>
                <!-- Botones de Anterior, Cancelar, Limpiar y Guardar Contratante -->
                <div align="center" class="submit664">
                    <input type="submit" value="Anterior" 
                           width="52" height="19" border="0" 
                           class="input" name="_target0"/>                    
                    <input type="reset" value="Limpiar." 
                           width="52" height="19" border="0" 
                           class="input"/>
                    <input type="submit" value="Generar archivo" 
                           id="Save"
                           width="52" height="19" border="0" 
                           class="input" name="_finish"/>
                              
                    
                </div>
            </form>
        </spring:nestedPath>
    </body>
</html>