<div class="navbar">
	<div class="navbar-inner">
		<a class="brand" href="/MMG6Main/">Monster Mash</a>
		<ul class="nav">
			<li><a href="/MMG6Main/">Home</a></li>
			<%
				//if (!user.getUsername().equals("")) {
			%>
			<li><a href="/MMG6Main/login.jsp">Login</a></li>
			<%
				//} else if (user.getUsername()!="") {
			%>
			<li><a href="/MMG6Main/battle.jsp">Battle</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">Shop <b class="caret"></b></a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li><a tabindex="-1" href="/MMG6Main/shop_buy.jsp">Buy Monsters</a></li>
					<li><a tabindex="-1" href="/MMG6Main/shop_sell.jsp">Sell Monsters</a></li>
				</ul>
			</li>
			<li><a href="/MMG6Main/farm.jsp">Farm</a></li>
			<li><a href="/MMG6Main/about.jsp">About</a></li>
			<li><a href="/MMG6Main/logout.jsp">Logout</a></li>
			<%
				//}
			%>
		</ul>
	</div>
</div>
