<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/css/stilosTablas.css" />" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/calendario.js" />">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/AnchorPosition.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/date.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/PopupWindow.js"/>">
        </script>
        <script language="JavaScript" type="text/javascript"
                src="<c:url value="/js/GUIHelper.js"/>">
        </script>
        
        <!--agregue los nuevos campos del formulario-->
    
        


        
        <title>B&uacute;squeda de Escuelas</title>
        <script type="text/javascript" >
            function cambioPagina(pagina){
            
                document.forms[0].paginaActual.value = pagina;
                document.forms[0].submit();
            }
            function buscarEstatusPoliza(){
                launch('obtenerEstatusPoliza',
                'Listado de Estados de P&oacute;liza -Seleccione un registro de la lista-',
                'ID Estado: :idEstatusPolizaSeguimiento:idEstatusPoliza:t:t,'+
                'Estado: :descripcionEstatusPoliza:descripcionEstatusPoliza:t:t','',700,700);
            }
            function buscarEstatusSolicitud(){
                launch('obtenerEstatusSolicitud',
                'Listado de Estados de Solicitud -Seleccione un registro de la lista-',
                'ID Estado: :idEstatusSolicitud:idEstatusSolicitud:t:t,'+
                'Estado: :descripcionEstatusSolicitud:descripcionEstatusSolicitud:t:t','',700,700);
            }
            function buscarAgente(){
                launch('buscarAgentes',
                'Listado de Agentes -Seleccione un registro de la lista-',
                    'ID Agente: :cveAgente:cveAgente:t:t,'+
                    '1er Nombre: :nombre1Empleado:nombre1AgenteFrm:t:f,'+
                    '2o Nombre: :nombre2Empleado:nombre2AgenteFrm:t:f,'+
                    'Apellido Paterno: :apPaternoEmpleado:apPaternoAgenteFrm:t:f,'+
                    'Apellido Materno: :apMaternoEmpleado:apMaternoAgenteFrm:t:f',
                '',700,700);
            }
            function buscarPlaza(){
                
                launch('buscarPlazas',
                'Listado de Plazas -Seleccione un registro de la lista-',
                    'ID Plaza: :idPlaza:idPlaza:t:t,'+
                    'Clave Plaza: :cvePlaza:descripcionPlaza:t:t,'+
                    'Nombre Plaza: :nombrePlaza: :t:f'
                    ,
                '',700,700);
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
            function buscarEmpresasPorColonia(){
                launch('obtenerEmpresasPorColonia',
                'Empresas por colonia -Seleccione un registro de la lista-',
                'Clave: :cveEmpresa:cveEmpresa:t:t,Tipo: :tipoEmpresa'+'.'+'descripcionEmpresa: :t:f,Empresa: :nombreEmpresa:descripcionEmpresa:t:t,Turno: :turnoEmpresa'+'.'+'nombreTurno: :t:f',
                'cveColonia:'+document.getElementById('cveColonia').value,500,550);
            }

            function buscar(){
                document.w01.paginaActual.value = '';

                document.w01.submit();
            }
            function detalle(numPoliza,emisor,folio,formatoSolicitud){

                urlBase     = '<c:url value="/app/consultaDetalleSolicitudController"/>';
                propiedades = 'width='+700+',height='+800+',toolbar=no,directories=no,menubar=no,scroll=yes,resizable=yes,status=yes,dependent=yes';
                params = 'numPoliza='+numPoliza+'&emisor='+emisor+'&folioSolicitud='+folio+'&formatoSolicitud='+formatoSolicitud;
                url    = urlBase + '?' + params;
                //alert('url: ' + url);
                vent   = window.open(url, "detalle", propiedades);
                isOpen = true;
            }



        </script>
        <script type="text/javascript" >
            function cambioPagina(pagina){

                document.w01.paginaActual.value = pagina;
                document.w01.submit();
            }
			function ordenarPor(iCol){
				document.w01.indiceOrden.value = iCol;
				document.w01.submit();
			}
        </script>
    </head>
        
    <body>
      
      
            
            
            <form action="<c:url value="/app/consultaGeneralSolicitudesController"/>" method="post" name="w01">
                <input type="hidden" name="indiceOrden"  />
                <spring:nestedPath path="criteriosBusqueda">
              
                
                
                <input type="hidden" name="_page0" value="0" />
                <div id="title589x16" align="center" style="margin-left: auto;margin-right: auto" >B&uacute;squeda de Escuelas</div>
                
                
              
                
                

                
                <div class="row660">
                   <span class="field588" style="margin-left: auto;margin-right: auto;text-align: center" >
                      Grupo Asegurado: &nbsp;&nbsp;
                      
                            <input type="hidden" name="grupoAsegurado" id="grupoAsegurado" value=""/>
                     
                     
                          <input type="text"
                                   name="descripcionGrupoAsegurado"
                                   id="descripcionGrupoAsegurado"
                                   size="15"
                                   tabindex="1"
                                   class="input" value="" readonly/>
                   
                             <a href="javascript:buscarGrupoAsegurado();" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                        &nbsp;&nbsp;&nbsp;
                         Delegaci&oacute;n/Municipio: &nbsp;&nbsp;&nbsp;
                        
                             <input type="hidden" name="cveSucursal" id="cveSucursal" value=""/>
                        
                       
                            <input type="text"
                                   name="descSucursal"
                                   id="descSucursal"
                                   size="15"
                                   tabindex="1"
                                   class="input" value="" readonly/>
                        
                             <a href="javascript:buscarSucursalesPorGrupo()" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>&nbsp;

                   </span>
                </div>
                 <div class="row660">
                   <span class="field588" style="margin-left: auto;margin-right: auto;text-align: center" >
                      Colonia / Barrio: &nbsp;&nbsp;

                         
                            <input type="hidden" name="cveColonia" id="cveColonia" value=""/>
                      
                         
                            <input type="text"
                                   name="descripcionColonia}"
                                   id="descripcionColonia"
                                   size="15"
                                   tabindex="1"
                                   class="input" value="" readonly/>
                         
                             <a href="javascript:buscarColoniasPorSucursal();" tabindex="2">
                                <img src="<c:url value="/img/helper.png"/>" alt="Buscar Agentes"/></a>
                        &nbsp;&nbsp;&nbsp;
                         Nombre de la Escuela: &nbsp;&nbsp;&nbsp;
                          
                            <input type="hidden" name="cveEmpresa" id="cveEmpresa" value=""/>
                         
                      
                            <input type="text"
                                   name="descripcionEmpresa"
                                   id="descripcionEmpresa"
                                   size="15"
                                   tabindex="1"
                                   class="input" value="CHUM" />
                        

                        

                   </span>
                </div>
                 <div class="row660">
                     <span class="field588" style="margin-left: auto;margin-right: auto;text-align: center" >
                         <input type="button" value="Buscar" class="input" name="btnBuscar" id="btnBuscar" onclick="javascript:buscar();"/>
                         &nbsp;
                         &nbsp;
                         &nbsp;
                         <a href="<c:url value="/app/consultaGeneralSolicitudesController"/>"><input type="button" value="Limpiar" class="input" name="btnLimpiar" id="btnLimpiar"  /></a>

                         &nbsp;
                         &nbsp;
                         &nbsp;
                         <a href="<c:url value="/"/>">
                          <input type="button" class="input" value="Cerrar" />
                        </a>
                          
                     </span>
                </div>
                <div align="center" >
                    <table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:small;font-weight: bold;">

                                Total de registros: 34                             P&aacute;gina 1 de 1
                                 

                            </td>

                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                            <td class="ContenTablaColor">&nbsp;</td>
                            
                            	
                                                      
                            
                           <td align="center" class="ContenTablaColor"><strong>Plaza</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Grupo Asegurado</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Sucursal</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Colonia</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Tipo Escuela</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Nombre de la Escuela</strong></td>
                          
<!--                            <td align="center" class="ContenTablaColor"><strong>Num. de Poliza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Fecha Inicio Vigencia</strong></td>                            -->
<!--                            <td align="center" class="ContenTablaColor"><strong>Seguimiento a P&oacute;liza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Pagos P&oacute;liza</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Paquete</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Grupo Asegurado</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Prima Mensual</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Escuela</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Sucursal</strong></td>-->
<!--                            <td align="center" class="ContenTablaColor"><strong>Agente</strong></td>-->
                            
                            
                        </tr>
                        
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla"><a href="javascript:void();" 
                                        onclick="javascript:detalle('${registro.numPoliza}','${registro.numConsignatario}','${registro.folioSolicitud}','${registro.formatoSolicitud}')">
										<input type="checkbox"/>
										</a></td>
                                        <td class="ContenTabla">TP - Tepic</td>
                                        <td class="ContenTabla">SNTE 49</td>
                                        <td class="ContenTabla">ACAPONETA</td>
                                        <td class="ContenTabla">Acaponeta Centro</td>
                                        <td class="ContenTabla">Jard&iacute;n de Niños</td>
                                        <td class="ContenTabla">7758 - ALI CHUMACERO</td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla"><a href="javascript:void();" 
                                        onclick="javascript:detalle('${registro.numPoliza}','${registro.numConsignatario}','${registro.folioSolicitud}','${registro.formatoSolicitud}')">
										<input type="checkbox"/>
										</a></td>
                                        <td class="ContenTabla">TP - Tepic</td>
                                        <td class="ContenTabla">SNTE 49</td>
                                        <td class="ContenTabla">ACAPONETA</td>
                                        <td class="ContenTabla">Acaponeta Centro</td>
                                        <td class="ContenTabla">Jard&iacute;n de Niños</td>
                                        <td class="ContenTabla">7758 - ALI CHUMACERO</td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla"><a href="javascript:void();" 
                                        onclick="javascript:detalle('${registro.numPoliza}','${registro.numConsignatario}','${registro.folioSolicitud}','${registro.formatoSolicitud}')">
										<input type="checkbox"/>
										</a></td>
                                        <td class="ContenTabla">TP - Tepic</td>
                                        <td class="ContenTabla">SNTE 49</td>
                                        <td class="ContenTabla">ACAPONETA</td>
                                        <td class="ContenTabla">Acaponeta Centro</td>
                                        <td class="ContenTabla">Jard&iacute;n de Niños</td>
                                        <td class="ContenTabla">7758 - ALI CHUMACERO</td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla"><a href="javascript:void();" 
                                        onclick="javascript:detalle('${registro.numPoliza}','${registro.numConsignatario}','${registro.folioSolicitud}','${registro.formatoSolicitud}')">
										<input type="checkbox"/>
										</a></td>
                                        <td class="ContenTabla">TP - Tepic</td>
                                        <td class="ContenTabla">SNTE 49</td>
                                        <td class="ContenTabla">ACAPONETA</td>
                                        <td class="ContenTabla">Acaponeta Centro</td>
                                        <td class="ContenTabla">Jard&iacute;n de Niños</td>
                                        <td class="ContenTabla">7758 - ALI CHUMACERO</td>
                                        
                                                                             
                                       
                                
                                    </tr>
                                    

                      
                        
                    
                       
                        </table>




                </div>
               
               
                
                <!--Seccion de poliza individual-->


                
                    </spring:nestedPath>
            </form>
            
    <script type="text/javascript" >
    esRolVentas = ${rolVentas};
    esRolAdministrador = ${rolAdministrador};
    //esconder la clave del agente
    if(esRolVentas){
    	
    	document.getElementById("camposAgente").style.display = "none";
    }
    
    //esconder la clave de plaza
    if(esRolAdministrador){
    	document.getElementById("camposPlaza").style.display = "none";
    }
    
    
    </script>
    </body>
    
</html>
