<%-- 
    Document   : Outcome
    Created on : Feb 1, 2013, 9:04:23 AM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>
<jsp:include page="includes/header.jsp"/>
<!-- Body Content -->
<h2>Battling ENEMYNAME</h2>
<div class="row">
    <div class="span4 offset1 well" style="text-align:center;">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th width="120px">Monster</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Strength</th>
                    <th>Aggression</th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td><img src=<%= usercontroller.getPicSrc(usercontroller.getWinner().getName())%>></td>
                    <td><%= usercontroller.getWinner().getName()%></td>
                    <td><%= usercontroller.getWinner().getAge()%></td>
                    <td><%= usercontroller.getWinner().getStrength()%></td>
                    <td><%= usercontroller.getWinner().getAggression()%></td>
                </tr>

            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4"></td>
                    <td>
                    </td>
                </tr>
            </tfoot>
        </table></div>

</div>
<jsp:include page="includes/footer.jsp" />
