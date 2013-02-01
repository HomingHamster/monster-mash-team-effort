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
                <% for (int i = 0; i < usercontroller.getNumOfMonsters(); i++) {%>
                <tr>
                    <td><img src=<%= usercontroller.getPicSrc(usercontroller.getMonster(i).getName())%>></td>
                    <td><%= usercontroller.getMonster(i).getName()%></td>
                    <td><%= usercontroller.getMonster(i).getAge()%></td>
                    <td><%= usercontroller.getMonster(i).getStrength()%></td>
                    <td><%= usercontroller.getMonster(i).getAggression()%></td>
                    <td><%= i%> </td>
                </tr>
                <%}%>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4"></td>
                    <td>
                    </td>
                </tr>
            </tfoot>
        </table></div>
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
                <% for (int i = 0; i < usercontroller.getNumOfMonsters(); i++) {%>
                <tr>
                    <td><img src=<%= usercontroller.getPicSrc(usercontroller.getMonster(i).getName())%>></td>
                    <td><%= usercontroller.getMonster(i).getName()%></td>
                    <td><%= usercontroller.getMonster(i).getAge()%></td>
                    <td><%= usercontroller.getMonster(i).getStrength()%></td>
                    <td><%= usercontroller.getMonster(i).getAggression()%></td>
                    <td><%= i%> </td>
                </tr>
                <%}%>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="4"></td>
                    <td>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
    <div class="fightbutton" style="text-align:center;">
        <input type="submit" class="btn btn-danger btn-large" value="Start Battle" />
    </div>
    <FORM name="first" METHOD=POST ACTION="Bread.jsp">
        Monster 1: <INPUT TYPE=TEXT NAME=choice1 SIZE=20><BR>
        Monster 2: <INPUT TYPE=TEXT NAME=choice2 SIZE=20><BR>
        <P><INPUT TYPE=SUBMIT VALUE="Breed"></p>
    </form>
</div>
<jsp:include page="includes/footer.jsp" />
