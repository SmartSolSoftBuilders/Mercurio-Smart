<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Catálogo de Escuelas - Capturar Datos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
        <style type="text/css">
            .form{

            }
            .field {
            height: 31px;
            display: block;
            float: left;
            margin: 0;
            margin-right: 2px;
            background: url(<c:url value="/"/>img/bg_textfieldspan3.gif) no-repeat;
            }
        </style>
        <script type="text/javascript">
        function buscarGrupoAsegurado(){
            launch('buscarGruposAsegs',
            'Listado de Grupos Asegurados -Seleccione un registro de la lista-',
            'Clave: :cveGrupoAsegurado:cveGrupoAsegurado:t:t,Grupo: :nombreGrupoAsegurado:descripcionGrupoAsegurado:t:t','',500,550);
        }

        function buscarSucursalesPorGrupo(){
            launch('obtenerSucursales',
            'Sucursales -Seleccione un registro de la lista-',
            'Clave: :cveSucursal:cveSucursal:t:t,Deleg/Mpio: :sucursal'+'.'+'nombreSucursal:descripcionSucursal:t:t',
            'cveGrupoAsegurado:'+document.getElementById('cveGrupoAsegurado').value,500,550);
        }

        function buscarColoniasPorSucursal(){
            launch('obtenerColonias',
            'Colonias -Seleccione un registro de la lista-',
            'Clave: :cveColonia:cveColonia:t:t,'+
            'Estado: :estado:estadoFrm:t:f,'+
            'Municipio / Delegación: :municipio:municipioFrm:t:f,'+
            'Tipo Asentamiento: :tipoAsentamiento:tipoAsentamientoFrm:t:f,'+
            'Colonia: :asentamiento:descripcionColonia:t:t',
            'cveSucursal:'+document.getElementById('cveSucursal').value+',cveGrupoAsegurado:'+document.getElementById('cveGrupoAsegurado').value,900,550);
        }
        
        function guardar(){
        	forma = document.forms[0];
        	
        	if(forma.cveGrupoAsegurado.value == ""){
        		alert("El Grupo Asegurado es un dato obligatorio");
        		return;
        	}
        	
        	if(forma.cveSucursal.value == ""){
        		alert("La Delegación / Municipio es un dato obligatorio");
        		return;
        	}
        	
        	if(forma.cveColonia.value == ""){
        		alert("La Colonia es un dato obligatorio");
        		return;
        	}
        	
        	if(forma.nombreEscuela.value == ""){
        		alert("El Nombre de la Escuela es un dato obligatorio");
        		return;
        	}
        	
        	forma.submit();
        	
        }
        function agregarSucursal(){
        	abrirVentana('<c:url value="/app/agregarSucursalController"/>',650,500);
        }
        function agregarColonia(){
        	abrirVentana('<c:url value="/app/agregarColoniaController"/>',650,500);
        }
        </script>
    </head>
    <body >
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
    		<form action="<c:url value="/app/agregarEscuelaController"/>" method="post">
             <c:if test="${not empty error }">
	              <div align="center" class="submit664">
		                   <span style="color:red;font-weight: bold;font-size: x-small; margin: 10px">
		                		${error }
		                	</span>
		          </div>
	              <br/>
	         </c:if>
	         <spring:nestedPath path="agregarEscuelaCommand">
	         <spring:bind path="cveEmpresa">
	         	<input type="hidden" name="${status.expression}" value="${status.value}"/>
	         </spring:bind>
			<table cellpadding="2" cellspacing="2" width="800">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="4" class="TopTabla" align="center"><strong>
                           <c:if test="${agregarEscuelaCommand.cveEmpresa == null or agregarEscuelaCommand.cveEmpresa == 0}">
                           		AGREGAR 
                           </c:if>
                           <c:if test="${agregarEscuelaCommand.cveEmpresa != null and agregarEscuelaCommand.cveEmpresa > 0}">
                           		EDITAR 
                           </c:if>
                            
                            ESCUELA</strong></td>
                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="4" class="TopTabla" align="center"><strong>CAPTURE LOS SIGUIENTES DATOS</strong></td>
                        </tr>
                        <tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Grupo Asegurado:&nbsp;
                			</td>
                			<td class="fieldRow">
                			  <spring:bind path="cveGrupoAsegurado">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                      </spring:bind>
		                      <spring:bind path="descripcionGrupoAsegurado">
		                          <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                      </spring:bind>
                             <a href="javascript:buscarGrupoAsegurado();" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                        
                         
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Delegaci&oacute;n/Municipio: &nbsp;
                         
                			<td class="fieldRow">
                				<spring:bind path="cveSucursal">
		                             <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                         </spring:bind>
		                         <spring:bind path="descripcionSucursal">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                         </spring:bind>
                             <a href="javascript:buscarSucursalesPorGrupo()" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>&nbsp;&nbsp;
                			<img alt="Agregar Delegación" src="<c:url value="/img/database_add.png"/>"><a href="javascript:agregarSucursal();">Agregar nueva Delegaci&oacute;n / Municipio</a> 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Colonia / Barrio: &nbsp;
                			</td>
                			<td class="fieldRow">
                				<spring:bind path="cveColonia">
		                            <input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}"/>
		                         </spring:bind>
		                         <spring:bind path="descripcionColonia">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   tabindex="1"
		                                   class="input" value="${status.value}" readonly/>
		                         </spring:bind>
		                             <a href="javascript:buscarColoniasPorSucursal();" tabindex="2">
		                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>&nbsp;&nbsp;
		                         <img alt="Agregar Colonia" src="<c:url value="/img/database_add.png"/>"><a href="javascript:agregarColonia();">Agregar nueva Colonia</a> 
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Tipo de Escuela: &nbsp;
                			</td>
                			<td class="fieldRow">
                					<form:select path="tipoEmpresa" cssClass="input">
                						<form:options items="${tiposEscuela}" itemLabel="descripcionEmpresa" itemValue="tipoEmpresa"/>
                					</form:select>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Turno: &nbsp;
                			</td>
                			<td class="fieldRow">
                					<form:select path="cveTurno" cssClass="input">
                						<form:options items="${turnosEscuela}" itemLabel="nombreTurno" itemValue="cveTurno"/>
                					</form:select>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="white-space: nowrap;">
                				Nombre de la Escuela: &nbsp;
                			</td>
                			<td class="fieldRow">
                				<form:input path="nombreEscuela" size="30" maxlength="60" cssClass="input"/>
                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="text-align: center" colspan="4">
                					
                						<input type="button" value="Guardar" class="input" name="btnGuardar" id="btnGuardar" onclick="javascript:guardar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/app/consultarCatalogoEscuelasController"/>"><input type="button" value="Regresar" class="input" name="btnCancelar" id="btnCancelar"  /></a>
                			</td>
                		</tr> 
                		
           </table>
           </spring:nestedPath>
          
          	
           
        	</form>
    </body>
</html>
