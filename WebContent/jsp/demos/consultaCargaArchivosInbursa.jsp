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
    
        


        
        <title>Consulta de Cargas de Archivos de P&oacute;lizas de Inbursa</title>
        
    </head>
        
    <body>
      
      
            
            
            <form action="<c:url value="/app/consultaGeneralSolicitudesController"/>" method="post" name="w01">
               
                
                <div id="title589x16" align="center" style="margin-left: auto;margin-right: auto" >Consulta de Cargas de Archivos de P&oacute;lizas de Inbursa</div>
                
				<div class="row660">
                   <span class="field588"  >
                     &nbsp;&nbsp; Cargar nuevo archivo de p&oacute;lizas: &nbsp;&nbsp;
                      		<input type="file" class="input"/>
                            <input type="button" value = "  Cargar...  " class="input"/>
                        

                   </span>
                </div>
               
                 
                 
                <div align="center" >
                    <table width="600" border="0" cellpadding="5" cellspacing="1">
                          <tr>
                            <td colspan="80" align="left" style="font-size:x-small;font-weight: bold;">
                                Total de registros: 5 --  P&aacute;gina 1 de 1
                            </td>

                        </tr>
                        <tr align="left" valign="middle" height="20">
                            <td colspan="80" class="TopTabla" align="center"><strong>Resultado de la consulta</strong></td>
                        </tr>
                       
                        <tr>
                            <td class="ContenTablaColor">&nbsp;</td>
                           <td align="center" class="ContenTablaColor"><strong>Fecha de Carga</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Usuario</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Total Registros</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Registros V&aacute;lidos</strong></td>
                           <td align="center" class="ContenTablaColor"><strong>Registros Inv&aacute;lidos</strong></td>
                           
                            
                        </tr>
                        
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/></a>
										</td>
                                        <td class="ContenTabla">12/01/2012</td>
                                        <td class="ContenTabla">masterDir</td>
                                        <td class="ContenTabla">113</td>
                                        <td class="ContenTabla">112</td>
                                        <td class="ContenTabla">1</td>
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/></a>
										</td>
                                        <td class="ContenTabla">12/01/2012</td>
                                        <td class="ContenTabla">masterDir</td>
                                        <td class="ContenTabla">113</td>
                                        <td class="ContenTabla">112</td>
                                        <td class="ContenTabla">1</td>
                                
                                    </tr>
                                    <tr align="left" valign="middle">
                                        <td align="center" width="4%" class="ContenTabla">
	                                        <a href="" title="Detalle"><img border="0" src="<c:url value='/img/skin/onebit_02.png'/>" width="24" height="24"/></a>
										</td>
                                        <td class="ContenTabla">12/01/2012</td>
                                        <td class="ContenTabla">masterDir</td>
                                        <td class="ContenTabla">113</td>
                                        <td class="ContenTabla">112</td>
                                        <td class="ContenTabla">1</td>
                                
                                    </tr>
                                    

                      
                        
                    
                       
                        </table>




                </div>
            </form>
            
   
    </body>
    
</html>
