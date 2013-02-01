<%-- 
    Document   : processRequest
    Created on : Feb 01, 2013, 9:59:11 PM
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="handleRequest" class="monsterMashGroupProject.RequestController" scope="session"/>
<HTML>
    <HEAD><META http-equiv="Refresh" content="0; url= <%= handleRequest.controller(request.getParameter("reqId"), request.getParameter("acceptbtn"), request.getParameter("declinebtn"))%>" /></HEAD>
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
