<%-- 
    Document   : welcome
    Created on : Dec 8, 2012, 6:06:58 PM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<title>Monster Mash Welcome Page</title>
</head>
<body>
<div id="main">
<div class="header">
<img src="images/indexheader2.png" width="800px" >
<a href="index.jsp"><p style="float:right; margin-right:50px;"><input type="submit" value="Logout"></p></a>
<p > Your money : 666 </p>
</div>
<hr />
<div class="mainWindow">
<div class="Menu"  style="float:left; width:150px;" >

<a href="farm.jsp"><img src="images/farm.png"></a><br />
<a href="shop.jsp"><img src="images/shop.png"></a><br />
<a href="welcome.jsp"><img src="images/friends.png"></a><br />

</div>
<div class="friendsList">
<a href="friend.jsp"><p> FriendName </p></a>
<hr />
<p> FriendName </p>
<hr />
<p> FriendName </p>
<hr />
<p> FriendName </p>
<hr />

<p> FriendName </p>
<hr />
<p> FriendName </p>
<hr />
<p> FriendName </p>
<hr />

<input type="button" value="Add Friend">
</div>
 <div class="friendRequest" style="border-style:dashed;
	border-width:3px; width:824px;"> 
 <h1> You have a new friend request from :</h1> <a href="friend.html"> <p style="color:blue"> PlayerName </a><input type="submit" value="Accept"> <input type="submit" value="Decline"></p> 

 
 </div>
 
 <div class="fightRequest" style="border-style:dashed;
	border-width:3px;border-color:red;width:824px;">
	
	<h1> You have a new fight request from :</h1> <a href="friend.html"><p style="color:red"> PlayerName </a>  <input type="submit" value="Accept"> <input type="submit" value="Decline"></p> 
	
 
	</div>

</div>


</div>
</body>
</html>