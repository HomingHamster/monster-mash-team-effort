<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="user" class="Login.checkLogin" scope="session"/>

<t:page_sidebar>
		<!-- Body Content -->
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
					<td><img src="http://bbrks.me/221/monsterid.php?seed=1"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td>350 &curren;</td>
					<td><button class="btn btn-primary">Buy</button></td>
				</tr>
				<tr>
					<td><img src="http://bbrks.me/221/monsterid.php?seed=2"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td>350 &curren;</td>
					<td><button class="btn btn-primary">Buy</button></td>
				</tr>
				<tr>
					<td><img src="http://bbrks.me/221/monsterid.php?seed=3"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td>350 &curren;</td>
					<td><button class="btn btn-primary">Buy</button></td>
				</tr>
			</tbody>
		</table>
</t:page_sidebar>