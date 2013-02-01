<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>

<ul class="nav nav-list">
  <li class="nav-header">User Stats<%= usercontroller.setTheUsr(user) %></li>
  <li><i class="icon-user"></i> Username: <%=usercontroller.getTheUsr().getUsername() %></li>
  <li><i class="icon-shopping-cart"></i> Money: <%=usercontroller.getTheUsr().getVirtualMoney() %> &curren;</li>
  <hr />
  <li class="nav-header">Active Monster</li>
  <li><img src=<%= usercontroller.getPicSrc(usercontroller.getMonster(0).getName()) %> /></li>
  <li><i class="icon-comment"></i> Name: <%= usercontroller.getMonster(0).getName() %></li>
  <li><i class="icon-time"></i> Age: <%= usercontroller.getMonster(0).getAge() %></li>
  <li><i class="icon-resize-vertical"></i> Height: <%= usercontroller.getMonster(0).getHeight() %>m</li>
  <li><i class="icon-fire"></i> Strength: <%= usercontroller.getMonster(0).getStrength() %></li>
  <li><i class="icon-warning-sign"></i> Aggression: <%= usercontroller.getMonster(0).getAggression() %></li>
    <li><i class="icon-shopping-cart"></i> Worth: <%= usercontroller.getMonster(0).getWorth() %></li>
  <li><i class="icon-shopping-cart"></i> Money: <%= usercontroller.getMoney() %> &curren;</li>
</ul>
<jsp:include page="../parts/friendslist.jsp" />
