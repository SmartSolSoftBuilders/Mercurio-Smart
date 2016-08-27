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
        <title>Consultar Catálogo de Escuelas</title>
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
     
	        function cambioPagina(pagina){
	        
	            document.forms[0].paginaActual.value = pagina;
	            document.forms[0].submit();
	        }
	        function buscar(){
                document.forms[0].paginaActual.value = '';
                document.forms[0].submit();
            }
	        function buscarGrupoAsegurado(){
                launch('buscarGruposAsegs',
                'Listado de Grupos Asegurados -Seleccione un registro de la lista-',
                'Clave: :cveGrupoAsegurado:cveGrupoAsegurado:t:t,Grupo: :nombreGrupoAsegurado:descripcionGrupoAsegurado:t:t','',500,550);
            }

            function buscarSucursalesPorGrupo(){
                launch('obtenerSucursalesPorGrupo',
                'Sucursales del Grupo Asegurado -Seleccione un registro de la lista-',
                'Clave: :cveSucursal:cveSucursal:t:t,Deleg/Mpio: :sucursal'+'.'+'nombreSucursal:descripcionSucursal:t:t',
                'cveGrupoAsegurado:'+document.getElementById('cveGrupoAsegurado').value,500,550);
            }

            function buscarColoniasPorSucursal(){
                launch('obtenerColoniasPorSucursal',
                'Colonias de la sucursal -Seleccione un registro de la lista-',
                'Clave: :cveColonia:cveColonia:t:t,Colonia: :colonia'+'.'+'asentamiento:descripcionColonia:t:t',
                'cveSucursal:'+document.getElementById('cveSucursal').value+',cveGrupoAsegurado:'+document.getElementById('cveGrupoAsegurado').value,500,550);
            }
            
        </script>
    </head>
    <body >
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
    		<form action="<c:url value="/app/consultarCatalogoEscuelasController"/>" method="post">
    				
    				
    			
    				
             <c:if test="${not empty error }">
	              <div align="center" class="submit664">
		                   <span style="color:red;font-weight: bold;font-size: x-small; margin: 10px">
		                		${error }
		                	</span>
		          </div>
	              <br/>
	         </c:if>
	         <spring:nestedPath path="consultarCatalogoEscuelasCommand">
			<table cellpadding="2" cellspacing="2" width="800">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="4" class="TopTabla" align="center"><strong>ADMINISTRACI&Oacute;N DE ESCUELAS</strong></td>
                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="4" class="TopTabla" align="center"><strong>FILTROS PARA B&Uacute;SQUEDA</strong></td>
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
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>&nbsp;
                			
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
		                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                			</td>
                			<td class="labelRow" style="white-space: nowrap;">
                				Nombre de la Escuela: &nbsp;
                			</td>
                			<td class="fieldRow">
                				
		                         <spring:bind path="nombreEscuela">
		                            <input type="text"
		                                   name="${status.expression}"
		                                   id="${status.expression}"
		                                   size="15"
		                                   maxlength="30"
		                                   tabindex="1"
		                                   class="input" value="${status.value}"/>
		                         </spring:bind>

                			</td>
                		</tr>
                		<tr>
                			<td class="labelRow" style="text-align: center" colspan="4">
                					
                						<input type="button" value="Buscar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
				                         &nbsp;
				                         &nbsp;
				                         &nbsp;
				                         <a href="<c:url value="/app/consultarCatalogoEscuelasController"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>
                			</td>
                		</tr> 
                		
           </table>
           </spring:nestedPath>
          
          	<img alt="" src="<c:url value="/img/database_add.png"/>"> <a href="<c:url value="/app/agregarEscuelaController"/>">Agregar nueva escuela</a> 
          
           <c:if test="${empty resultado.resultados}">
           		<table cellpadding="0" cellspacing="2" width="800">
                		<tr>
                			<td class="fieldRow"  style="text-align:center;">
                				<strong>
                					No existen datos de Escuelas
                				</strong>
                			</td>
                		</tr>
           		</table>
           </c:if>
           <c:if test="${not empty resultado.resultados}">
	           <table cellpadding="2" cellspacing="2" width="900">
	           			<tr>
                            <td colspan="80" align="left" style="font-size:small;font-weight: bold;">

                                Total de registros: <fmt:formatNumber value="${resultado.totalResultados}" pattern="#,##0"/><br/>
                                 <c:if test="${resultado.paginaActual>2}">
                                	<a href="javascript:cambioPagina(1)" >&lt;&lt;</a>
                                </c:if> 
                                <c:if test="${resultado.paginaActual>1}">
                                	<a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual-1}"/>)" >&lt;</a>
                                </c:if> 
                               
                                P&aacute;gina <c:out value="${resultado.paginaActual}"/> de <c:out value="${resultado.totalPaginas}"/>
                                <c:if test="${resultado.paginaActual<resultado.totalPaginas}">
                                	<a href="javascript:cambioPagina(<c:out value="${resultado.paginaActual+1}"/>)" >&gt;</a>
                                </c:if>
                                <c:if test="${resultado.paginaActual<resultado.totalPaginas}">
                                	<a href="javascript:cambioPagina(<c:out value="${resultado.totalPaginas}"/>)" >&gt;&gt;</a>
                                </c:if>
                                <input type="hidden" name="totalResultados" value="<c:out value="${resultado.totalResultados}"/>"/>
                                <input type="hidden" name="paginaActual" value="<c:out value="${resultado.paginaActual}"/>"/>
                                <input type="hidden" name="totalPaginas" value="<c:out value="${resultado.totalPaginas}"/>"/>

                            </td>

                        </tr>
	           			<tr>
                			<td class="fieldRow"  style="text-align:center;" colspan="10">
                				<strong>
                					Resultado de la consulta
                				</strong>
                			</td>
                		</tr>
              			<tr>
              				<td align="center" class="ContenTablaColor" width="1px" >
              					&nbsp;
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Plaza
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Grupo<br/>Asegurado
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Sucursal
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Colonia
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Tipo Escuela
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Turno
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Nombre de la <br/>Escuela
              				</td>
              			
              			</tr>
               			<c:forEach items="${resultado.resultados}" var="registro">
               				<tr>
               					<td align="center" class="ContenTabla">
               						<a href="<c:url value="/app/agregarEscuelaController"/>?cveEmpresa=${registro.cveEmpresa}" style="border: 0px" alt="Editar Escuela" title="Editar Escuela"><img alt="Editar Escuela" src="<c:url value="/img/database_edit.png"/>"></a> 
               					</td>
                                <td class="ContenTabla" style="text-align: left;white-space: nowrap;"><c:out value="${registro.grupoAsegurado.plaza.cvePlaza}"/> - <c:out value="${registro.grupoAsegurado.plaza.nombrePlaza}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.grupoAsegurado.nombreGrupoAsegurado}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.sucursal.nombreSucursal}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.colonia.tipoAsentamiento}"/> <c:out value="${registro.colonia.asentamiento}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.tipoEmpresa.descripcionEmpresa}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.turnoEmpresa.nombreTurno}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.nombreEmpresa}"/></td>
               				</tr>
               			</c:forEach>
	           </table>
           </c:if>
           
        	</form>
    </body>
</html>
