<!DOCTYPE html>
<html lang="en">
<head>
	<title>Monster Mash- Shop</title>
	<link href="resources/template/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" type="text/css" href="resources/template/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<div id="header">
			<img src="resources/template/img/indexheader2.png" width="930px" class="img-polaroid">
		</div>
		<div class="navigation">
			<div class="navbar">
				<div class="navbar-inner">
					<a class="brand" href="welcome.jsp">Monster Mash</a>
					<ul class="nav">
						<li><a href="welcome.jsp">Home</a></li>
						<li><a href="#">Login</a></li>
						<li><a href="#">Register</a></li>
						<li class="active"><a href="shop.jsp">Buy Monsters</a></li>
						<li><a href="#">Sell Monsters</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span2">
				<ul class="nav nav-list">
					<li><a href="farm.jsp"><img width="120px" src="resources/template/img/farm.png"></a></li>
					<li><a href="shop.jsp"><img width="120px" src="resources/template/img/shop.png"></a></li>
					<li><a href="friends.jsp"><img width="120px" src="resources/template/img/friends.png"></a></li>
				</ul>
			</div>
			<div id="table" style="text-align:center;">
				<form action="">
					<table border="3" class="span10">
						<thead>
							<tr>
								<th width="120px;">Monster</th>
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
								<td><input type="submit" name="$monsterid" value="Buy"></td>
							</tr>
							<tr>
								<td><img src="http://blog.furred.net/MonsterID.ashx?seed=2"></td>
								<td>18</td>
								<td>1.3m</td>
								<td>5</td>
								<td>2</td>
								<td>800 &curren;</td>
								<td><input type="submit" name="$monsterid" value="Buy"></td>
							</tr>
							<tr>
								<td><img src="http://blog.furred.net/MonsterID.ashx?seed=3"></td>
								<td>16</td>
								<td>2.2m</td>
								<td>7</td>
								<td>3</td>
								<td>1500 &curren;</td>
								<td><input type="submit" name="$monsterid" value="Buy"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
