<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>
<jsp:include page="includes/header.jsp"/>
<jsp:include page="includes/sidebar.jsp" />
<!-- Body Content -->
<h2>Welcome <%= usercontroller.setTheUsr(user)%></h2>
<p class="lead">Attention</p>
Money: <%=usercontroller.getTheUsr().getVirtualMoney() %>
<table class="table table-striped table-bordered">
    <thead>
        <tr>
            <th>Type of request</th>
            <th>From user</th>
            <th>Accept/Decline</th>

        </tr>
    </thead>
    <tbody>
        <% for (int i = 0; i < usercontroller.getSizeOfRequests(); i++) {%>
        <tr>
            <td><%= usercontroller.getRequest(i).getType() %></td>
            <td><%= usercontroller.getRequest(i).getFromWho() %></td>
            <td><form name="first" METHOD=POST ACTION="processRequest.jsp">
                    <input type="hidden" name="reqId" value= <%= usercontroller.getRequest(i).getId() %> />
                    <input type="submit" class="btn btn-primary" name="acceptbtn" value="Accept" />
                    <input type="submit" class="btn btn-danger" name="declinebtn" value="Decline" />
                </form>
            </td>
        </tr>
        <%}%>
    </tbody>
</table>
<jsp:include page="includes/sidebarclose.jsp" />
<jsp:include page="includes/footer.jsp" />
