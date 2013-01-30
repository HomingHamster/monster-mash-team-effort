<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>

<ul class="nav nav-list">
  <li class="nav-header">User Stats<%= usercontroller.setTheUsr(user) %></li>
  <li><i class="icon-user"></i> Username: <%=user.getUsername() %></li>
  <li><i class="icon-shopping-cart"></i> Money: <%=user.getUsername() %> &curren;</li>
  <hr />
  <li class="nav-header">Active Monster</li>
  <li><img src="http://bbrks.me/221/monsterid.php?seed=12837" /></li>
  <li><i class="icon-comment"></i> Name: <%= usercontroller.getMonster(0).getName() %></li>
  <li><i class="icon-time"></i> Age: <%= usercontroller.getMonster(0).getAge() %></li>
  <li><i class="icon-resize-vertical"></i> Height: <%= usercontroller.getMonster(0).getHeight() %>m</li>
  <li><i class="icon-fire"></i> Strength: <%= usercontroller.getMonster(0).getStrength() %></li>
  <li><i class="icon-warning-sign"></i> Aggression: <%= usercontroller.getMonster(0).getAggression() %></li>
  <li><i class="icon-shopping-cart"></i> Price: <%= usercontroller.getMoney() %> &curren;</li>
</ul>
