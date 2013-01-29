<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base>
		<!-- Body Content -->
		<div class="row">
			<div class="well span6 offset3">
			<h2>Login</h2>
			<form class="form-horizontal" name="loginform" method="post" action="SaveName.jsp">
				<div class="control-group">
					<label class="control-label" for="username">Username</label>
					<div class="controls">
						<input type="text" name="username" id="username" placeholder="Username" />
					</div>
				</div>
				<div class="control-group">
				  <label class="control-label" for="password">Password</label>
				  <div class="controls">
					<input type="password" name="password" id="password" placeholder="Password" />
					<!--<p><a href="forgottenpassword.jsp">Forgotten Password?</a></p>-->
				  </div>
				</div>
				<div class="control-group">
				  <div class="controls">
					<input type="submit" class="btn btn-neutral" value="Sign in" />
					<a href="#registerModal" role="button" class="btn btn-primary" data-toggle="modal">Register</a>
				  </div>
				</div>
			</form>
		</div>
		</div>

		<!-- Register Modal -->
		<div id="registerModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <form class="form-horizontal" name="registerform" method="post" action="registeruser.jsp">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">Register New User</h3>
		  </div>
		  <div class="modal-body">
				 <div class="control-group">
				  <label class="control-label" for="username">Username</label>
				  <div class="controls">
					<input type="text" name="username" id="username" placeholder="Username" />
				  </div>
				</div>
				<div class="control-group">
				  <label class="control-label" for="password">Password</label>
				  <div class="controls">
					<input type="password" name="password" id="password" placeholder="Password" />
					<!--<p><a href="forgottenpassword.jsp">Forgotten Password?</a></p>-->
				  </div>
				</div>
				<div class="control-group">
				  <div class="controls">
				  </div>
				</div>
		  </div>
		  <div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<input type="submit" class="btn btn-primary" value="Register New User" />
		  </div>
		  </form>
		</div>

</t:base>
