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
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
        <title>Identificar el Grupo asegurado</title>
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <tag:errors name="datosSolicitud" />
        <!--spring:nestedPath path="datosContratante"-->
        <spring:nestedPath path="datosSolicitud">
            <form action="#" method="post">
                <div>
                    <input type="hidden" name="_page2" value="2" />
                    <!--input type="hidden" name="_target3" value="true" /-->
                
                </div>
                <div id="titleg664x16">Identificar Grupo Asegurado.</div>
               
                
                <div class="row660">
                    <label class="label330">Grupo Asegurado:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.empresa.cveGrupoAsegurado">
                            <input type="hidden" name="${status.expression}"  id="cveGrupoAseguradoFrm" value="${status.value}"/>    
                        </spring:bind>
                        <input type="text" name="nombreGrupoAsegurado" id="nombreGrupoAseguradoFrm" value="${status.value}" class="input" size="35"  tabindex="1" readonly onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <a href="javascript:launch('buscarGruposAsegs','Listado de Grupos Asegurados -Seleccione un registro de la lista-','Clave:cveGrupoAsegurado:cveGrupoAsegurado:cveGrupoAseguradoFrm:f:t,Grupo:nombreGrupoAsegurado:nombreGrupoAsegurado:nombreGrupoAseguradoFrm:t:t','',500,550);" tabindex="2">
                        <img src="<c:url value="/"/>img/helper.png" /></a>
                    </span>	      
                </div>
                <div class="row660" align="center">&nbsp;</div>
                <div id="titleg664x16">Datos de la Empresa.</div>
                
                <div class="row660">
                    <label class="label330">Sucursal:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <spring:bind path="solicitud.empresa.cveSucursal">
                            <input type="hidden" name="${status.expression}" id="cveSucursalFrm" value="${status.value}" readonly/>
                        </spring:bind>
                        <input type="text" name="sucursal" id="nombreSucursalFrm" value="${status.value}" class="input"   size="30" tabindex="3" readonly onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <a href="javascript:launch('obtenerSucursalesPorGrupo','Sucursales del Grupo Asegurado -Seleccione un registro de la lista-','Clave: :cveSucursal:cveSucursalFrm:t:t, Deleg/Mpio: :sucursal'+'.'+'nombreSucursal:nombreSucursalFrm:t:t','cveGrupoAsegurado:'+document.getElementById('cveGrupoAseguradoFrm').value,500,550);" tabindex="4">
                        <img src="<c:url value="/"/>img/helper.png" /></a>
                    </span>	      
                </div>
                
                <div class="row660">
                    <label class="label330">Colonia/Barrio:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <input type="text" name="nombreColonia" id="nombreColoniaFrm" value="${status.value}" class="input" size="30" tabindex="5" readonly onChange="javascript:this.value=this.value.toUpperCase(); "/>
                        <a href="javascript:launch('obtenerColoniasPorSucursal','Colonias de la sucursal -Seleccione un registro de la lista-','Clave: :cveColonia:cveColoniaFrm:t:t,Colonia: :colonia'+'.'+'asentamiento:nombreColoniaFrm:t:t','cveSucursal:'+document.getElementById('cveSucursalFrm').value+',cveGrupoAsegurado:'+document.getElementById('cveGrupoAseguradoFrm').value,500,550);" tabindex="6">
                            <img src="<c:url value="/"/>img/helper.png" />
                        </a>
                        <spring:bind path="solicitud.empresa.cveColonia">
                            <input type="hidden" name="${status.expression}" id="cveColoniaFrm" value="${status.value}"/>
                        </spring:bind>
                    </span>
                </div>
                
                <div class="row660">
                    <label class="label330">Nombre de la Empresa:&nbsp;&nbsp;</label>
                    <span class="field330">
                        <!--input name="esNuevaEmpresa" type="checkbox" id="esNuevaEmpresa" tabindex="2" />Es nueva empresa.-->
                        <input type="text" name="nombreEmpresa" id="nombreEmpresaFrm" value="${status.value}" class="input" size="30" tabindex="7" readonly onChange="javascript:this.value=this.value.toUpperCase();"/>
                        <input type="hidden" name="nombreTurno" id="nombreTurnoFrm"/>
                        <input type="hidden" name="descripcionEmpresa" id="descripcionEmpresaFrm"/>
                        <a href="javascript:launch('obtenerEmpresasPorColonia','Empresas por colonia -Seleccione un registro de la lista-','Clave: :cveEmpresa:cveEmpresaFrm:t:t,Tipo: :tipoEmpresa'+'.'+'descripcionEmpresa:descripcionEmpresaFrm:t:f,Empresa: :nombreEmpresa:nombreEmpresaFrm:t:t,Turno: :turnoEmpresa'+'.'+'nombreTurno:nombreTurnoFrm:t:f','cveColonia:'+document.getElementById('cveColoniaFrm').value,500,550);" tabindex="8">
                            <img src="<c:url value="/"/>img/helper.png" />
                        </a>
                        <spring:bind path="solicitud.empresa.cveEmpresa">
                            <input type="hidden"  name="${status.expression}"  id="cveEmpresaFrm" value="${status.value}"/>
                        </spring:bind>
                    </span>          
                </div>
                
                <div align="center" class="submit664">
                    <input type="submit" value="Anterior."  width="52" height="19" border="0" class="input" name="_target1" tabindex="9"/>
                    <input type="submit" value="Cancelar." width="52" height="19" border="0" class="input" name="_cancel" tabindex="10"/>
                    <input type="reset" value="Limpiar." width="52" height="19" border="0" class="input" tabindex="11"/>
                    <input type="submit" value="Siguiente." width="52" height="19" border="0" class="input" name="_target3" tabindex="12"/>
                </div>
            </form>
        </spring:nestedPath>
    </body>
    
</html>

