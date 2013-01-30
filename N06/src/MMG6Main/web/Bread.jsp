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
        <META http-equiv="Refresh" content="0; url=<%=monsters.bread()%>"/>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" />
		<!-- Body Content -->
		<div class="well" style="text-align:center;">
			<h2>Loading</h2>
			<img src="resources/template/img/loading.gif" />
		</div>

<jsp:include page="includes/footer.jsp" />

    </body>
</html>
