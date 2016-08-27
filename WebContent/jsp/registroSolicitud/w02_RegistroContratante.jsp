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
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/calendario.js" />"></script>
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/AnchorPosition.js"/>"></script>
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/date.js"/>"></script>
        <script type="text/javascript" language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script language="JavaScript" type="text/javascript" src="<c:url value="/js/GUIHelper.js"/>"></script>
        <script language="javascript" type="text/javascript">
            function validarContratante(){

            var fieldnumCertificadoFrmValue = document.registroContratanteForm.numCertificadoFrm.value;
            if (fieldnumCertificadoFrmValue > 0){
                alert("El contratante cuenta con pólizas anteriores, marque en la solicitud el tipo de movimiento que corresponda");
                registroContratanteForm.val.type="hidden";
                registroContratanteForm.siguienteFrm.type="submit";
                registroContratanteForm.val.disabled=true;
                
            }

            else{
                if(vacio(document.registroContratanteForm.numNominaContratanteFrm.value)==false){
                    alert("Coloque el número de nómina del contratante en el campo correspondiente y consulte los registros previos")
                }
                else{
                    registroContratanteForm.val.type="hidden";
                    registroContratanteForm.siguienteFrm.type="submit";
                    registroContratanteForm.val.disabled=true;
                }

            }

            function vacio(q){
                for (i=0; i<q.length;i++){
                    if (q.charAt(i) != " "){
                        return true
                    }
                }
                return false
            }

          
        }



        </script>
        <title>Registro del Contratante</title>
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <tag:errors name="datosSolicitud"/>
        <!--spring:nestedPath path="datosContratante"-->
        <spring:nestedPath path="datosSolicitud">

            <form action="#" method="post" name="registroContratanteForm">
                <div>
                    <input type="hidden" name="_page1" value="1" />
                    <!--input type="hidden" name="_target2" value="true" /-->
                    <!--input type="hidden" name="_cancel" value="true" /-->
                </div>
                <div id="titleg664x16">Registro del Contratante</div>
                
                
                <div class="row660" ><label class="label330">No. de emp.(13 Digitos):&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.contratante.numNominaContratante">
                            <input type="text" name="${status.expression}" id="numNominaContratanteFrm" value="${status.value}" size="15"   maxlength="13"  tabindex="1" class="input" onChange="javascript:this.value=this.value.toUpperCase();" />&nbsp
                        </spring:bind>
                        <input type="button" value="Consultar registros previos" class="input" tabindex="9" id="validarFrm"
                           onclick="javascript:launch('buscarPolizasAnteriores','Polizas anteriores -Seleccione el resultado mostrado-','Plaza: :cvePlaza:cvePlazaFrm:t:f, Certificado: :numCertificado:numCertificadoFrm:t:t, Tarifa: :solicitud.tarifa.importeTarifa:importeTarifaFrm:t:f, Estatus segun pagos: :estatusPolizaPagos.descripcionEstatusPagosPoliza:descripcionEstatusPagosPolizaFrm:t:f','numNominaContratante:'+document.getElementById('numNominaContratanteFrm').value,400,600);"
                        />
                        <input type="hidden" name="${status.expression}" id="numCertificadoFrm" class="input" value="${status.value}"/>
                        <input type="hidden" name="${status.expression}" id="importeTarifaFrm" class="input" value="${status.value}"/>
                        <input type="hidden" name="${status.expression}" id="descripcionEstatusPagosPolizaFrm" class="input" value="${status.value}"/>
                    </span>	      
                </div>
                
                <div class="row660"><label class="label330">Apellido Paterno:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.contratante.apPaternoContratante">
                            <input type="text" name="${status.expression}" id="apPaternoContratanteFrm" class="input" value="${status.value}" size="25" tabindex="2" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        </spring:bind>
                    </span>	      
                </div>
                
                <div class="row660"><label class="label330">Apellido Materno:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.contratante.apMaternoContratante">
                            <input type="text" name="${status.expression}" id="apMaternoContratanteFrm" class="input" value="${status.value}" size="25" tabindex="3" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        </spring:bind>              
                    </span>	      
                </div>
                
                <div class="row660"><label class="label330">Primer Nombre:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.contratante.nombre1Contratante" >
                            <input type="text" name="${status.expression}" id="nombre1ContratanteFrm" class="input" value="${status.value}" size="25" tabindex="4" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        </spring:bind>
                    </span>
                </div>
                
                <div class="row660"><label class="label330">Segundo Nombre:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.contratante.nombre2Contratante">
                            <input type="text" name="${status.expression}" id="nombre2ContratanteFrm" class="input" value="${status.value}" size="25" tabindex="5" class="input" onChange="javascript:this.value=this.value.toUpperCase();"/>
                        </spring:bind>              
                    </span>
                </div>

                 <div align="center" class="submit664">
                    <input type="submit" value="Anterior." class="input" name="_target0" tabindex="6"/>
                    <input type="submit" value="Cancelar" class="input" name="_cancel" tabindex="7"/>
                    <input type="reset" value="Limpiar." class="input" tabindex="8" onClick="clearForm(this.form);"/>
                    <input type="button" class="input" id="val" value="Validar" onClick="validarContratante();"/>
                    <input type="hidden" value="Siguiente." class="input" name="_target2" tabindex="10" id="siguienteFrm"/>
                </div>
            </form>
        </spring:nestedPath>
    </body>
</html>
