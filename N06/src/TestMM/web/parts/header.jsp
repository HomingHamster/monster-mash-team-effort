<img src="resources/template/img/indexheader2.png" class="img-rounded" style="width:100%;margin:10px 0" />
			<div class="navbar navbar-vertical-dividers">
				<div class="navbar-inner">
					<a class="brand" href="#">Monster Mash</a>
					<ul class="nav">
						<li><a href="#">Home</a></li>
						<!-- <%
							//if (!user.isLoggedIn()) {
						%> -->
						<li><a  href="index.jsp">Login</a></li>
						<!-- <%
							//} //else if (user.isLoggedIn()) {
						%> -->
						<li><a href="battle.jsp">Battle</a></li>
						<li class="dropdown active">
							<a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="#">Shop <b class="caret"></b></a>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
								<li><a tabindex="-1" href="#anotherAction">Buy Monsters</a></li>
								<li><a tabindex="-1" href="#anotherAction">Sell Monsters</a></li>
							</ul>
						</li>
						<li><a href="farm.jsp">Farm</a></li>
						<li><a href="about.jsp">About</a></li>
						<!-- <%
							//}
						%> -->
					</ul>
				</div>
			</div>