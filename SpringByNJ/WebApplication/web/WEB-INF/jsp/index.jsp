<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${process eq 'home'}">
    <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
    <p><i>To display a different welcome page for this project, modify</i>
    <tt>index.jsp</tt> <i>, or create your own welcome page then change
        the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
        welcome page and also update the welcome-file setting in</i>
    <tt>web.xml</tt>.</p></c:if>    
<c:if test="${process eq 'brainy'}"><h1>brainy</h1></c:if>    
<c:if test="${process eq 'brainer'}"><h1>brainer</h1></c:if>    
<c:if test="${process eq 'homePage'}"></c:if>    

