<%-- 
    Document   : CreateUser
    Created on : Jan 28, 2013, 2:09:17 PM
    Author     : jamesslater
--%>

<%@page import="monsterMashGroupProject.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="regUser" class="monsterMashGroupProject.RegisterInfo" scope="session"/>
<jsp:setProperty name="regUser" property="*"/> 
<HTML>
<BODY>
    <A HREF=<%= regUser.addUser()%> >Continue</A>
</BODY>
</HTML>
