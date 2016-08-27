<%@page import="org.acegisecurity.ui.AbstractProcessingFilter"%>
<%@page import="org.acegisecurity.ui.webapp.AuthenticationProcessingFilter"%>
<%@page import="org.acegisecurity.AuthenticationException"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/css/stilosForms.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/stilosCal.css" />" rel="stylesheet" type="text/css">
    <title>Login</title>
</head>

<body>
<center>
  <form name="w01" action="<c:url value="/j_acegi_security_check" />" method="POST">
    <table width="375"  border="0" align="center">
    <tr>
      <td height="45" ><div align="center"><img alt="Logo Estrategas" src="<c:url value="/img/estrategas.png"/>"></div></td>
    </tr>
    <tr>
       
      <td width="242" align="center">
      	<table width="200" border="0" bgcolor="#006699" align="center">
          <tr>
            <td>
            	<table width="200"  align="center" bgcolor="#DDDDDD" >
                <tr>
                  <td><label class="label80">Usuario:&nbsp;&nbsp;</label></td>
                  <td><input type='text' name='j_username' class="input" /></td>
                </tr>
                <tr>
                  <td><label class="label80">Contrase&ntilde;a:&nbsp;&nbsp;</label></td>
                  <td><input type='password' name='j_password' class="input" /></td>
                </tr>
                <tr>
                  <td><div align="center">
                      <input name="submit" class="input" type="submit" value="Enviar" />
                  </div></td>
                  <td><div align="center">
                      <input name="reset" class="input" type="reset" value="Limpiar" />
                  </div></td>
                </tr>
            </table>
          </td>
          </tr>
      </table>
     </td>
    </tr>
  </table>
  </form>
</center>
</body>
</html>





