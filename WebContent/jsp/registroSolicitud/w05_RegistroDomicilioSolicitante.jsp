<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

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
        <script language="JavaScript" src="<c:url value="/js/calendario.js" />"></script>
        <script language="JavaScript" src="<c:url value="/js/AnchorPosition.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/date.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        
        <script language="JavaScript">
            var cal18 = new CalendarPopup("testdiv1");
            cal18.setCssPrefix("TEST");
        </script>
        <title>Registro del Domicilio del Solicitante</title>
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <DIV ID="testdiv1" STYLE="position:absolute;visibility:hidden;background-color:white;"></DIV>
        <tag:errors name="datosSolicitud"/>
        <!--spring:nestedPath path="datosDomicilioSolicitante"-->
        <spring:nestedPath path="datosSolicitud">
            <form action="#" method="post">
                <div>
                    <input type="hidden" name="_page4" value="4" />
                    <!--input type="hidden" name="_target5" value="true" /-->
                    
                </div>
                <div id="title589x16">Domicilio del Solicitante.</div>
                <div class="row592">
                    <label class="label195x21">Calle:&nbsp;&nbsp;</label>
                    
                    <label class="label195x21">Edificio:&nbsp;&nbsp;</label>
                    
                    <label class="label195x21">No. ext./ No. int.:&nbsp;&nbsp;</label>    
                </div>
                
                <div class="row592">
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.calle">
                            <input type="text" name="${status.expression}" id="calleFrm" value="${status.value}" class="input" size="20" tabindex="1" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>
                    
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.edificio">
                            <input type="text" name="${status.expression}" id="edificioFrm" value="${status.value}" class="input" size="20" tabindex="2" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>	      
                    
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.numExtInt">
                            <input type="text" name="${status.expression}" id="numExtIntFrm" value="${status.value}" class="input" size="20" tabindex="3" />    
                        </spring:bind>
                    </span>	      
                </div>
                
                <div class="row592">
                    <label class="label195x21">Colonia/Fraccionamiento:&nbsp;&nbsp;</label>
                    
                    <label class="label195x21">C&oacute;digo Postal:&nbsp;&nbsp;</label>
                    
                    <label class="label195x21">Delegaci&oacute;n/Municipio:&nbsp;&nbsp;</label>    
                </div>
                
                <div class="row592">
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.colonia">
                            <input type="text" name="${status.expression}" id="coloniaFrm" value="${status.value}" class="input" size="20" tabindex="4" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>
                    
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.codPostal">
                            <input type="text" name="${status.expression}" id="codPosatalFrm" value="${status.value}" class="input" size="5" maxlength="5" tabindex="5" />    
                        </spring:bind>
                    </span>
                    
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.delegacionMpio">
                            <input type="text" name="${status.expression}" id="delegacionMpioFrm" value="${status.value}" class="input" size="20" tabindex="6" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>	      
                </div>
                
                <div class="row592">
                    <label class="label195x21">Ciudad/Poblaci&oacute;n:&nbsp;&nbsp;</label>
                    
                    <label class="label195x21">Entidad Federativa:&nbsp;&nbsp;</label>
                    
                    <label class="label195x21">e-mail:&nbsp;&nbsp;</label>    
                </div>
                
                <div class="row592">
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.ciudadPoblacion">
                            <input type="text" name="${status.expression}" id="ciudadPoblacionFrm" value="${status.value}" class="input" size="20" tabindex="7" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>
                    
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.entidadFederativa">
                            <input type="text" name="${status.expression}" id="entidadFederativaFrm" value="${status.value}" class="input" size="20" tabindex="8" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>	      
                    
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.email">
                            <input type="text" name="${status.expression}" id="emailFrm" value="${status.value}" class="input" size="23" tabindex="9" onChange="javascript:this.value=this.value.toUpperCase();"/>    
                        </spring:bind>
                    </span>	      
                </div>
                <div class="row660"></div>
                <div id="title589x16">N&uacute;mero Telef&oacute;nico.</div>
                <div class="row592">
                    <label class="label97x31">LADA:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.lada">
                            <input type="text" name="${status.expression}" id="ladaFrm" value="${status.value}" class="input" size="5" maxlength="10" tabindex="10" title="El formato solo acepta n&uacute;meros no introduzca letras ni caracteres especiales"/>    
                        </spring:bind>
                        (Solo n&uacute;meros)
                    </span>
                    <label class="label97x31">Tel&eacute;fono:&nbsp;&nbsp;</label>
                    <span class="field195">
                        <spring:bind path="solicitud.solicitante.telefono">
                            <input type="text" name="${status.expression}" id="telefonoFrm" value="${status.value}" class="input" size="10" maxlength="10" tabindex="11" title="Introduzca el telefono en el formato 00000000" />    
                        </spring:bind>
                        (Solo n&uacute;meros)
                    </span>	      
                </div>
                
                <div align="center" class="submitspan3">
                    <input type="submit" value="Anterior." width="52" height="19" border="0" class="input" name="_target3" tabindex="12"/>
                    <input type="submit" value="Cancelar." width="52" height="19" border="0" class="input" name="cancel"  tabindex="13"/>
                    <input type="reset" value="Limpiar." width="52" height="19" border="0" class="input" tabindex="14"/>
                    <!--input type="submit" value="Siguiente." width="52" height="19" border="0" class="input" name="_finish"/-->
                    <input type="submit" value="Siguiente." width="52" height="19" border="0" class="input" name="_target5" tabindex="15"/>
                </div>
            </form>
        </spring:nestedPath>
    </body>
</html>