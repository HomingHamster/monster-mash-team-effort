<%-- 
    Document   : SendFriend
    Created on : Feb 1, 2013, 5:59:54 AM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="friendRequest" class="monsterMashGroupProject.FriendHandler" scope="session"/>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>
<HTML>
    <HEAD><META http-equiv="Refresh" content="0; url= <%= friendRequest.sendRequest(request.getParameter("friendUsername"), usercontroller.getTheUsr().getUsername(), request.getParameter("servers")) %>" /></HEAD>
    <BODY>
        <jsp:include page="includes/header.jsp" />
		<!-- Body Content -->
		<div class="well" style="text-align:center;">
			<h2>Handling your request</h2>
			<img src="resources/template/img/loading.gif" />
		</div>

<jsp:include page="includes/footer.jsp" />

    </BODY>
</html>
