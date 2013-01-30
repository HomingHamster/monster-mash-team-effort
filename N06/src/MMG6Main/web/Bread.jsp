<%-- 
    Document   : Bread
    Created on : Jan 29, 2013, 6:47:40 PM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="monsters" class="monsterMashGroupProject.UserController" scope="session"/>
<jsp:setProperty name="monsters" property="*"/> 
<html>
    <head>
        <HEAD><META http-equiv="Refresh" content="0; url=<%=monsters.bread()%>"/>
    </head>
    <body>
        <A HREF=<%= monsters.bread()%> >Continue</A>
    </body>
</html>
