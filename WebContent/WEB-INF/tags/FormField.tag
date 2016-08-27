<%@ tag body-content="scriptless" %>
<%@ attribute name="type" required="true" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="size" required="false" %>
<%@ attribute name="tabindex" required="false" %>
<%@ attribute name="class" required="false" %>
<%@ attribute name="path" required="true" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty type}">
    <c:set var="type" value="text" scope="page" />
</c:if>

<spring:bind path="${path}">
    
        
            <label for="${status.expression}"
                   <c:if test="${status.error}">class="error"</c:if>>${name}:
            </label>
        
        
            <input type="${type}" id="${status.expression}" name="${status.expression}"
                   value="${status.value}" />
            
        
    
</spring:bind>