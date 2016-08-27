<%@page import="mx.com.seguros.web.seguridad.util.SeguridadUtil"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/superfish.css'/>" media="screen"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/superfish-navbar.css'/>" media="screen"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/superfish-vertical.css'/>" media="screen"/>
		<script type="text/javascript" src="<c:url value='/js/jquery-1.5.1.js'/>"/>
		<script type="text/javascript" src="<c:url value='/js/hoverIntent.js'/>"/>
		<script type="text/javascript" src="<c:url value='/js/superfish.js'/>"/>
		<script type="text/javascript">

		// initialise plugins
		jQuery(function(){
			jQuery('ul.sf-menu').superfish();
		});

		</script>
    </head>
    <body>
    <!-- style="background-color: #BDD2FF;width: 100%; height: 45px; vertical-align: center;font-size: small;" -->
    <div  style="background-color: #BDD2FF;font-size: x-small;" >
    	<%=
SeguridadUtil.obtenerMenu(request)
%>
    </div>
    
    	
    </body>
</html>