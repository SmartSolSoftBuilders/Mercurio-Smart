<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
        
        <script language="JavaScript" src="<c:url value="/js/PopupWindow.js"/>"></script>
        <script language="JavaScript" src="<c:url value="/js/GUIHelper.js"/>"></script>
        
        
        
        <title>Registrar descuentos aplicados a los asegurados</title>
        
    </head>
    
    <body>
    <jsp:include page="/jsp/menu.jsp"></jsp:include>
    				<br/><br/>
        <table width="712" height="205" border="1" align="center">
            
            <td width="776" height="22"><div align="center"><span class="Estilo12">Registrar descuentos aplicados a los asegurados </span></div></td>
            
            <tr>
                <td height="175"><table width="704" height="237" border="0" align="center">
                        <tr>
                            <td height="43"><label>
                                    <div align="center">
                                        <input type="submit" class="input" name="Submit" value="Generar formato de aplicaci&oacute;n de descuentos" />
                                    </div>
                                </label>
                            <label class="Estilo8"></label></td>
                        </tr>
                        <tr>
                            <td height="38"><div align="center">
                                    <label>
                                        <input type="submit" class="input" name="Submit4" value="Cargar archivo de aplicaci&oacute;n de descuentos" />
                                    </label>
                            </div></td>
                        </tr>
                        <tr>
                            <td height="55"><label>
                                    <div align="center">
                                        <input type="submit" class="input" name="Submit2" value="Generar reporte de descuentos aplicados  a los asegurados" />
                                    </div>
                            </label></td>
                        </tr>
                        <tr>
                            <td height="43"><table width="200" border="0" align="center">
                                    <tr>
                                        <td><label></label>
                                            <label>
                                                <div align="center">
                                                    <a href="<c:url value="/"/>">
                                                        <input type="button" class="input" name="Salir" value="Salir" />
                                                    </a>
                                        </div></label></td>
                                    </tr>
                                </table>
                            <label></label></td>
                        </tr>
                </table></td>
            </tr>
        </table>
    </body>
</html>

