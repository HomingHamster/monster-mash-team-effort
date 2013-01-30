<jsp:include page="includes/header.jsp" />
		<!-- Body Content -->
		<h2>Farm</h2>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th width="120px">Monster</th>
					<th>Age</th>
					<th>Height</th>
					<th>Strength</th>
					<th>Aggression</th>
					<th>Breed?</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img src="http://bbrks.me/221/monsterid.php?seed=4"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td><input type="checkbox" /></td>
				</tr>
				<tr>
					<td><img src="http://bbrks.me/221/monsterid.php?seed=5"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td><input type="checkbox" /></td>
				</tr>
				<tr>
					<td><img src="http://bbrks.me/221/monsterid.php?seed=6"></td>
					<td>13</td>
					<td>0.7m</td>
					<td>3</td>
					<td>1</td>
					<td><input type="checkbox" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"></td>
					<td><input type="submit" class="btn btn-primary btn-block" value="Breed Selected" />
				</tr>
			</tfoot>
		</table>
<jsp:include page="includes/footer.jsp" />
