<div class="navbar">
	<div class="navbar-inner">
		<a class="brand" href="/Main/index.jsp">Monster Mash</a>
		<ul class="nav">
			<li><a href="/Main/welcome.jsp">Home</a></li>
			<%
				//if (!user.getUsername().equals("")) {
			%>
			<li><a href="/Main/login.jsp">Login</a></li>
			<%
				//} else if (user.getUsername()!="") {
			%>
			<li><a href="/Main/battle.jsp">Battle</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">Shop <b class="caret"></b></a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li><a tabindex="-1" href="/Main/shop_buy.jsp">Buy Monsters</a></li>
					<li><a tabindex="-1" href="/Main/shop_sell.jsp">Sell Monsters</a></li>
				</ul>
			</li>
			<li><a href="/Main/farm.jsp">Farm</a></li>
			<li><a href="/Main/about.jsp">About</a></li>
			<li><a href="/Main/logout.jsp">Logout</a></li>
			<%
				//}
			%>
		</ul>
	</div>
</div>
