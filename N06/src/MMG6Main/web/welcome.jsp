<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="monsters" class="monsterMashGroupProject.UserController" scope="session"/>
<%= monsters.setTheUsr(user) %>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/sidebar.jsp" %>
		<!-- Body Content -->
		<h2>Welcome </h2>
		<p class="lead">Welcome</p>
        <% for(int x = 0; x < monsters.getNumOfMonsters();x++){ %>
            <p>Monster</p>
            <p>Name: <%= monsters.getMonster(x).getName() %> </p>
            <p>Strength: <%= monsters.getMonster(x).getStrength() %></p>
            <p>Age: <%= monsters.getMonster(x).getAge() %></p>
            <p>Aggression: <%= monsters.getMonster(x).getAggression() %></p>
        <% } %>
<%@ include file="includes/sidebarclose.jsp" %>
<%@ include file="includes/footer.jsp" %>
