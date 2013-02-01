<%-- 
    Document   : Fight
    Created on : Feb 1, 2013, 7:25:20 AM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>
<jsp:setProperty name="usercontroller" property="*"/> 
<html>
    <head>
        <META http-equiv="Refresh" content="0; url=<%=usercontroller.fight()%>"/>
    </head>
    <body>
        <jsp:include page="includes/header.jsp" />
		<!-- Body Content -->
		<div class="well" style="text-align:center;">
			<h2>Fighting</h2>
			<img src="resources/template/img/loading.gif" />
		</div>

<jsp:include page="includes/footer.jsp" />

    </body>
</html>
