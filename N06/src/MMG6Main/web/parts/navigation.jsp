<div class="navbar">
	<div class="navbar-inner">
		<a class="brand" href=".">Monster Mash</a>
		<ul class="nav">
			<%
				//if (!user.getUsername().equals("")) {
			%>
			<li><a href="login.jsp">Login</a></li>
			<%
				//} else if (user.getUsername()!="") {
			%>
			<li><a href="battle.jsp">Battle</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">Shop <b class="caret"></b></a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li><a tabindex="-1" href="shop_buy.jsp">Buy Monsters</a></li>
					<li><a tabindex="-1" href="shop_sell.jsp">Sell Monsters</a></li>
				</ul>
			</li>
			<li><a href="farm.jsp">Farm</a></li>
			<li><a href="about.jsp">About</a></li>
			<li><a href="logout.jsp">Logout</a></li>
			<%
				//}
			%>
		</ul>
	</div>
</div>
