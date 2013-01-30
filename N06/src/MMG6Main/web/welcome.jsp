<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="monsters" class="monsterMashGroupProject.UserController" scope="session"/>

<t:page_sidebar>
		<!-- Body Content -->
		<h2>Welcome <%=monsters.setTheUsr(user) %></h2>
		<p class="lead">Welcome</p>
                <p> <% for(int x = 0; x < monsters.getNumOfMonsters();x++){%>
                    <p>Monster</p>
                    <p>Name: <%= monsters.getMonster(x).getName() %> </p>
                    <p>Strength: <%= monsters.getMonster(x).getStrength() %></p>
                    <p>Age: <%= monsters.getMonster(x).getAge() %></p>
                    <p>Aggression: <%= monsters.getMonster(x).getAggression() %></p>
                    
                    <%}%></p>
</t:page_sidebar>
