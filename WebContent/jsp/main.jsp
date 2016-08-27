<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
    <title>Login</title>
</head>
<body>
<center>
<form>
<table width="375"  border="0" align="center">
<tr>
    <td height="45" colspan="2"><div align="center"><img alt="Logo Estrategas" src="<c:url value="/img/estrategas.png"/>"></div></td>
</tr>
<tr>
<td width="123" height="152"><table width="139" border="0" align="center" bgcolor="#006699">
    <tr>
        <td width="133"><table width="129"  align="center" bgcolor="#DDDDDD">
            
            <tr>
                <td width="173">
                    <div align="center">
                        <a href="<c:url value="/jsp/main_dir.jsp" /> ">
                            <input name="Direccion" type="button" value="Direcci&oacute;n        ">
                        </a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <a href="<c:url value="/jsp/main_admin.jsp" /> ">
                            <input name="Administracion" type="button" value="Administraci&oacute;n">
                        </a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <a href="<c:url value="/jsp/main_vtas.jsp" /> ">
                            <input name="Ventas" type="button" value="Ventas           ">
                        </a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <a href="<c:url value="/jsp/main_op1.jsp" /> ">
                            <input name="Operaciones 1" type="button" value="Operaciones 1">
                        </a>
                    </div>
                </td>
            </tr>
            <tr>
            <td>
                <div align="center">
                    <a href="<c:url value="/jsp/main_op2.jsp" /> ">
                        <input name="Operaciones 2" type="button" value="Operaciones 2">
                    </a>
                </div>
            </td>
            
        </tr>
</table></td>
</tr>
</table></td>
<td width="242"><table width="200" border="0">
        <tr>
            <td><table width="200"  align="center" bgcolor="#DDDDDD">
                    <tr>
                        <td><label class="label80">Usuario:&nbsp;&nbsp;</label></td>
                        <td><input type='text' name='j_username' class="input" readonly/></td>
                    </tr>
                    <tr>
                        <td><label class="label80">Contrase&ntilde;a:&nbsp;&nbsp;</label></td>
                        <td><input type='password' name='j_password' class="input" readonly/></td>
                    </tr>
                    <tr>
                        <td><div align="center">
                                <input name="submit" class="input" type="submit" value="Enviar" disabled/>
                                                                                                 </div></td>
                        <td><div align="center">
                                <input name="reset" class="input" type="reset" value="Limpiar" disabled/>
                                                                                                </div></td>
                    </tr>
            </table></td>
        </tr>
</table>              </td>
</tr>
</table>
</form>
</center> 
</body>
</html>
