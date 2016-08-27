<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Consultar Bono de Pólizas para Agentes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
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
	        function detalle(id){
	
	            urlBase     = '<c:url value="/app/consultaDetalleProcesoCalculoBonoController"/>';
	            propiedades = 'width='+800+',height='+800+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes';
	            params = 'id='+id;
	            url    = urlBase + '?' + params;
	            vent   = window.open(url, "detalleBono", propiedades);
	            isOpen = true;
	        }
	        
	        function reporte(id){
	        	
	            urlBase     = '<c:url value="/app/generarReportesBonoController"/>';
	            propiedades = 'width='+800+',height='+800+',toolbar=no,directories=no,menubar=no,resizable=yes,status=yes,dependent=yes';
	            params = 'idResumenProcesoCalculoBono='+id;
	            url    = urlBase + '?' + params;
	            vent   = window.open(url, "reporteProceso", propiedades);
	            isOpen = true;
	        }
        </script>
    </head>
    <body >
     <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/> 
        <form action="<c:url value="/app/consultarBonoPolizaAgenteController"/>" method="POST"  id="formulario" >
            
                  
             <c:if test="${not empty error }">
	              <div align="center" class="submit664">
		                   <span style="color:red;font-weight: bold;font-size: x-small; margin: 10px">
		                		${error }
		                	</span>
		          </div>
	              <br/>
	         </c:if>
	         
			<table cellpadding="0" cellspacing="2" width="800">
                		<tr align="left" valign="middle" height="20">
                            <td colspan="6" class="TopTabla" align="center"><strong>Consultar Bono de Pólizas para Agentes</strong></td>
                        </tr>
                		
           </table>
           <c:if test="${empty listaResumenProceso}">
           		<table cellpadding="0" cellspacing="2" width="800">
                		<tr>
                			<td class="fieldRow"  style="text-align:center;">
                				<strong>
                					No existe ningún Bono Calculado
                				</strong>
                			</td>
                		</tr>
           		</table>
           </c:if>
           <c:if test="${not empty listaResumenProceso}">
	           <table cellpadding="0" cellspacing="1" width="800">
	           			<tr>
                			<td class="fieldRow"  style="text-align:center;" colspan="10">
                				<strong>
                					Resultado de los C&aacute;lculos de Bono para Agentes
                				</strong>
                			</td>
                		</tr>
              			<tr>
              				<td align="center" class="ContenTablaColor" width="1px" >
              					&nbsp;
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Fecha del C&aacute;lculo
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Usuario
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Plaza
              				</td>
              				<td align="center" class="ContenTablaColor">
              					Monto Total Calculado
              				</td>
              				<td align="center" class="ContenTablaColor">
              					&nbsp;
              				</td>
              			
              			</tr>
               			<c:forEach items="${listaResumenProceso}" var="registro">
               				<tr>
               					<td align="center" class="ContenTabla">
               						<a href="javascript:detalle('${registro.idResumenProcesoCalculoBono}')" title="Detalle">
                                      <img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/>
                                      </a>
               					</td>
                                <td class="ContenTabla" style="text-align: left;"><fmt:formatDate pattern="dd/MM/yyyy" value="${registro.fechaCalculo}"/></td>
                                <td class="ContenTabla"><c:out value="${registro.cveUsuario}"/></td>
                                <td class="ContenTabla"><c:if test="${ registro.idPlaza != null}">
                                							<c:out value="${registro.plaza.cvePlaza}"/> - 
                                							<c:out value="${registro.plaza.nombrePlaza}"/>
                                						</c:if>
                                						<c:if test="${ registro.idPlaza == null}">
                                							TODAS
                                						</c:if>
                                </td>
                                <td class="ContenTabla" style="text-align: right;"><fmt:formatNumber pattern="$ #,##0.00" value="${registro.montoTotal}"/></td>
                                <td align="center" class="ContenTabla">
               						<a href="javascript:reporte('${registro.idResumenProcesoCalculoBono}')" title="Generar Reporte">
                                      <img border="0" src="<c:url value='/img/skin/onebit_39.png'/>" width="24" height="24"/>
                                      </a>
               					</td>
                                
               				</tr>
               			</c:forEach>
	           </table>
           </c:if>
           
        </form>
    </body>
</html>
