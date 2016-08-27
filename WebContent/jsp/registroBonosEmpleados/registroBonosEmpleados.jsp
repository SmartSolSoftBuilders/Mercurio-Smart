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
        <title>Registro de Bonos Extraordinarios a Empleados</title>
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
        <tag:errors name="bonos" />
        <spring:nestedPath path="bonos">
            <form action="#" method="post" name="form">                
                    <div id="titleg664x16">Registro de Bonos Extraordinarios a Empleados</div>                                       
                        <div align="center" class="submit664">                            
                            <a href="javascript:launch('mostrarEmpleadosBonos','Listado de Empleados -Seleccione un registro de la lista-','Clave:cveEmpleado:cveEmpleado:cveEmpleadoFrm:f:t,Ap Paterno:apPaternoEmpleado:apPaternoEmpleado:apPaternoEmpleadoFrm:t:t,Apellido Materno:apMaternoEmpleado:apMaternoEmpleado:apMaternoEmpleadoFrm:t:t,Primer Nombre:nombre1Empleado:nombre1Empleado:nombre1EmpleadoFrm:t:t,Segundo Nombre:nombre2Empleado:nombre2Empleado:nombre2EmpleadoFrm:t:t,Puesto:nombrePuesto:puesto.nombrePuesto:nombrePuestoFrm:t:f','',500,550);" tabindex="2">
                                <input type="button" name="Submit" value="Consultar" class="input"/>
                            </a>
                            
                        </div>
                        <div id="titleg664x16">Datos del Empleado</div>                                                            
                                    <spring:bind path="bonoExtraEmpleado.cveEmpleado">
                                        <input type="hidden" name="${status.expression}" id="cveEmpleadoFrm" value="${status.value}" class="input"/>
                                    </spring:bind>
                                    <div class="row660">
                                        <label class="label135">Ap.Paterno:&nbsp;&nbsp;</label>
                                        <span class="field195">
                                            <input type="text" name="apPaternoEmpleado" id="apPaternoEmpleadoFrm" class="input" readonly/>
                                                                                                                                     </span>
                                        <label class="label135">Ap. Materno:&nbsp;&nbsp;</label>
                                        <span class="field195">       
                                            <input type="text" name="apMaternoEmpleado" id="apMaternoEmpleadoFrm" class="input" readonly/>
                                                                                                                                     </span>
                                        <label class="label135">Primer nombre:&nbsp;&nbsp;</label>
                                        <span class="field195">        
                                            <input type="text" name="nombre1Empleado" id="nombre1EmpleadoFrm" class="input" readonly/>
                                                                                                                                 </span>
                                        <label class="label135">Segundo nombre:&nbsp;&nbsp;</label>
                                        <span class="field195">       
                                            <input type="text" name="nombre2Empleado" id="nombre2EmpleadoFrm" class="input" readonly/>
                                                                                                                                 </span>
                                    </div>
                    <div class="row660" align="center">&nbsp;</div>
                    <div id="titleg664x16">Concepto del Bono</div>                                           
                        <div align="center">
                            <spring:bind path="bonoExtraEmpleado.conceptoBonoExtra">
                                <textarea name="${status.expression}" id="conceptoBonoExtraFrm" value="${status.value}" cols="90" rows="7" wrap="physical" class="input" onChange="javascript:this.value=this.value.toUpperCase();"></textarea>
                            </spring:bind>
                        </div>
                        <div class="row660">
                            <label class="label330">Total del bono:&nbsp;&nbsp;</label>
                                <span class="field330">
                                    <spring:bind path="bonoExtraEmpleado.importeBonoExtra">
                                        <input type="text" name="${status.expression}" id="importeBonoExtraFrm"  value="${status.value}" class="input"/>
                                    </spring:bind>
                                </span>
                            <label class="label330">Quincena de aplicaci&oacute;n:&nbsp;&nbsp;</label>
                                <span class="field330">
                                    <spring:bind path="bonoExtraEmpleado.numQuincenaAplicacion">
                                        <input type="text" name="${status.expression}" id="numQuincenaAplicacionFrm"  value="${status.value}" class="input"/>
                                    </spring:bind>
                                </span>
                            <label class="label330">Año quincena de aplicaci&oacute;n(aaaa):&nbsp;&nbsp;</label>
                                <span class="field330">
                                    <spring:bind path="bonoExtraEmpleado.anioQuincenaAplicacion">
                                        <input type="text" name="${status.expression}" id="anioQuincenaAplicacionFrm"  value="${status.value}" class="input"/>
                                    </spring:bind>
                                </span>
                        </div>                      
                        <div align="center" class="submit664">
                            <input type="submit"  value="Registrar" name="_finish" class="input"/>
                            <input type="reset" name="reset" value="Limpiar" class="input"/>
                            <a href="<c:url value="/"/>app/logoutcontroller">
                                <input type="button" value="Salir" class="input" tabindex="9"/>
                            </a>
                        </div>
            </form>
        </spring:nestedPath>
    </body>
</html>
