<div class="navbar">
	<div class="navbar-inner">
		<a class="brand" href="/MMG6MainDan/index.jsp">Monster Mash</a>
		<ul class="nav">
			<li><a href="/MMG6MainDan/welcome.jsp">Home</a></li>
			<%
				//if (!user.getUsername().equals("")) {
			%>
			<li><a href="/MMG6MainDan/login.jsp">Login</a></li>
			<%
				//} else if (user.getUsername()!="") {
			%>
			<li><a href="/MMG6MainDan/battle.jsp">Battle</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">Shop <b class="caret"></b></a>
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li><a tabindex="-1" href="/MMG6MainDan/shop_buy.jsp">Buy Monsters</a></li>
					<li><a tabindex="-1" href="/MMG6MainDan/shop_sell.jsp">Sell Monsters</a></li>
				</ul>
			</li>
			<li><a href="/MMG6MainDan/farm.jsp">Farm</a></li>
			<li><a href="/MMG6MainDan/about.jsp">About</a></li>
			<li><a href="/MMG6MainDan/logout.jsp">Logout</a></li>
			<%
				//}
			%>
		</ul>
	</div>
</div>
