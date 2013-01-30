<%-- 
    Document   : buyMonster
    Created on : Jan 29, 2013, 9:59:11 PM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="buyMon" class="monsterMashGroupProject.ShopController" scope="session"/>
<HTML>
    <HEAD><META http-equiv="Refresh" content="0; url= <%= buyMon.buyMonster(request.getParameter("monsterid"), request.getParameter("userNam"))%>"/></HEAD>
    <BODY>
        
    </BODY>
</html>
