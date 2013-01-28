<%-- 
    Document   : SaveName.jsp
    Created on : Jan 28, 2013, 11:10:23 AM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="Login.checkLogin" scope="session"/>
<jsp:setProperty name="user" property="*"/> 
<HTML>
<BODY>
<A HREF=<%= user.checkLogin()%> >Continue</A>
</BODY>
</HTML>
