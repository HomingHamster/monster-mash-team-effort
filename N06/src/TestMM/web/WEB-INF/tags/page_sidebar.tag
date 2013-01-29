<@tag description="Page with Sidebar Menu" pageEncoding="UTF-8"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:base>
		<div class="row">
			<div class="span3" style="background:#f3f3f3;">
				<ul class="nav nav-list">
				  <li class="nav-header">Sidebar header</li>
				  <li class="active"><a href="#">Lorem</a></li>
				  <li><a href="#">Ipsum</a></li>
				</ul>
				<ul class="nav nav-list">
				  <li class="nav-header">Sidebar header</li>
				  <li class=""><a href="#">Lorem</a></li>
				  <li><a href="#">Ipsum</a></li>
				  <li><a href="#">Lorem</a></li>
				  <li><a href="#">Ipsum</a></li>
				  <li><a href="#">Lorem</a></li>
				  <li><a href="#">Ipsum</a></li>
				</ul>
			</div>
			<div class="span9">
				<!-- Page contents -->
				<jsp:doBody/>
			</div>
		</div>
</t:base>
