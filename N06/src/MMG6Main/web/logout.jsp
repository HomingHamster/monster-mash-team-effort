<%-- 
    Document   : logout
    Created on : Jan 30, 2013, 11:03:24 PM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>
<usercontroller:InvalidateSession />
<usercontroller:redirect url="login.jsp" />
<HTML>
    <HEAD><META http-equiv="Refresh" content="0; url= <%= usercontroller.logOut()%>" /></HEAD>
    <BODY>
        <jsp:include page="includes/header.jsp" />
		<!-- Body Content -->
		<div class="well" style="text-align:center;">
			<h2>Bye Bye</h2>
			<img src="resources/template/img/loading.gif" />
		</div>

<jsp:include page="includes/footer.jsp" />

    </BODY>
</html>
