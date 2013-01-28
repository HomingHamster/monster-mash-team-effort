<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>Buy Monsters - Monster Mash</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
	<link href="resources/bootstrap/css/style.css" rel="stylesheet" />
	<link href="resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>
	<div class="container">
		<header>
			<img src="resources/template/img/indexheader2.png" class="img-rounded" style="width:100%;margin:10px 0" />
			<div class="navbar navbar-vertical-dividers">
				<div class="navbar-inner">
					<a class="brand" href="#">Monster Mash</a>
					<ul class="nav">
						<li><a href="#">Home</a></li>
						<!-- If Logged Out -->
						<li><a  href="login.jsp">Login</a></li>
						<!-- End If -->
						<!-- If  Logged In -->
						<li class="dropdown active">
							<a class="dropdown-toggle" id="dLabel" role="button" data-toggle="dropdown" data-target="#" href="/page.html">Shop<b class="caret"></b></a>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
								<li><a tabindex="-1" href="#anotherAction">Buy Monsters</a></li>
								<li><a tabindex="-1" href="#anotherAction">Sell Monsters</a></li>
							</ul>
						</li>
						<li><a href="#">Farm</a></li>
						<li><a href="#">Link</a></li>
						<!-- End If -->
					</ul>
				</div>
			</div>
		</header>
		<h2>Shop</h2>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="120px">Monster</th>
					<th>Age</th>
					<th>Height</th>
					<th>Strength</th>
					<th>Aggression</th>
					<th>Price</th>
					<th>Buy</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img src="http://blog.furred.net/MonsterID.ashx?seed=1"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td>350 &curren;</td>
					<td><button class="btn btn-primary">Buy</button></td>
				</tr>
				<tr>
					<td><img src="http://blog.furred.net/MonsterID.ashx?seed=2"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td>350 &curren;</td>
					<td><button class="btn btn-primary">Buy</button></td>
				</tr>
				<tr>
					<td><img src="http://blog.furred.net/MonsterID.ashx?seed=3"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td>350 &curren;</td>
					<td><button class="btn btn-primary">Buy</button></td>
				</tr>
			</tbody>
		</table>
		<hr>
		<footer>
			<p>&copy; Team Effort N06 2013</p>
		</footer>
	</div>


	<div id="addFriend" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">Add Friend</h3>
		</div>
		<div class="modal-body" style="height:300px;">
			<form action="">
				<!-- Populate from user database -->
				<input type="text" name="friendusername" data-provide="typeahead"	data-source='[
					"Fred",
					"Joe",
					"George",
					"Ben",
					"James",
					"Dan",
					"Felix",
					"Amy",
					"Sam",
					"Chris"
				]' />
			</form>
			<p class="muted">Search for a username above. The text area should list suggestions as you type.
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i> Close</button>
			<button class="btn btn-primary"><i class="icon-plus icon-white"></i> Add Friend</button>
		</div>
	</div>
	<div id="friendslist" class="dropdown-menu" style="padding:5px;position:fixed;bottom:0;right:25px;width:200px;display:block;border-radius:6px 6px 0 0;top:auto;left:auto;border-bottom:none;">
		<div id="friendscontainer" style="display:none;">
			<div id="friends" style="overflow:auto;max-height:300px">
				<ul style="list-style-type:none;margin:0;">
					<!-- JSP Loop through friends -->
					<li><a href="#"><i class="icon-user"></i> Ben</a></li>
					<li><a href="#"><i class="icon-user"></i> James</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<li><a href="#"><i class="icon-user"></i> Lorem Ipsum</a></li>
					<!-- If user has no friends: -->
					<!-- <li>You have no friends!</li> -->
				</ul>
			</div>
			<a href="#addFriend" role="button" class="btn btn-primary btn-block" data-toggle="modal"><i class="icon-plus icon-white"></i> Add Friend</a>
		</div>
		<div id="friendslistbutton" style="text-align:center;cursor:pointer;">
			<span><i class="icon-th-list"></i> Friends <b>(24)</b></span>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script>
		$("#friendslistbutton").click(function () {
			$("#friendscontainer").stop().slideToggle("slow");
		});
	</script>

	</body>
</html>
