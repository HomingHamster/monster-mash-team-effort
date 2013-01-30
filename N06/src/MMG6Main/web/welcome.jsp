<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="monsters" class="monsterMashGroupProject.UserController" scope="session"/>

<jsp:include page="includes/header.jsp" />
		<!-- Body Content -->
		<h2>Welcome <%=monsters.setTheUsr(user) %></h2>
		<p class="lead">Welcome</p>
        <% for(int x = 0; x < monsters.getNumOfMonsters();x++){ %>
            <p>Monster</p>
            <p>Name: <%= monsters.getMonster(x).getName() %> </p>
            <p>Strength: <%= monsters.getMonster(x).getStrength() %></p>
            <p>Age: <%= monsters.getMonster(x).getAge() %></p>
            <p>Aggression: <%= monsters.getMonster(x).getAggression() %></p>
        <% } %>
<jsp:include page="includes/footer.jsp" />
