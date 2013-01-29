<%-- 
    Document   : SaveName.jsp
    Created on : Jan 28, 2013, 11:10:23 AM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:setProperty name="user" property="*"/> 
<HTML>
    <head><meta http-equiv="Refresh" conent="0; url=<%=user.LoginUser()%>" /></head>
<BODY>
<A HREF=<%= user.LoginUser()%>>Continue</A>
</BODY>
</HTML>
