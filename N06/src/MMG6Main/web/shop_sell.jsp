<jsp:useBean id="monsters" class="monsterMashGroupProject.UserController" scope="session"/>
<jsp:useBean id="shp" class="monsterMashGroupProject.ShopController" scope="session"/>
<jsp:include page="includes/header.jsp" />
<jsp:include page="includes/sidebar.jsp" />
<!-- Body Content -->
<h2>Sell Monsters</h2>
<table class="table table-striped table-bordered">
    <thead>
        <tr>
            <th width="120px">Monster</th>
            <th>Name</th>
            <th>Age</th>
            <th>Height</th>
            <th>Strength</th>
            <th>Aggression</th>
            <th>Price</th>
            <th>Buy</th>
        </tr>
    </thead>
    <tbody>
        <% for (int i = 0; i < monsters.getNumOfMonsters(); i++) {%>
        <tr>
            <td><img src="http://bbrks.me/221/monsterid.php?seed=1"></td>
            <td><%= monsters.getMonster(i).getName()%></td>
            <td><%= monsters.getMonster(i).getAge()%></td>
            <td><%= monsters.getMonster(i).getHeight()%></td>
            <td><%= monsters.getMonster(i).getStrength()%></td>
            <td><%= monsters.getMonster(i).getAggression()%></td>
            <td><%= monsters.getMonster(i).getWorth()%> &curren;</td>
            <td><form name="first" METHOD=POST ACTION="buyMonster.jsp">
                    <input type="hidden" name="monsterid" value=<%= shp.getShopMonsters(i).getId()%> />
                    <input type="hidden" name="userNam" value= <%= monsters.getTheUsr().getUsername()%> />
                    <input type="submit" class="btn btn-primary" value="Buy" />
                </form></td>
        </tr>
        <%}%>
    </tbody>
</table>
<jsp:include page="includes/sidebarclose.jsp" />
<jsp:include page="includes/footer.jsp" />
