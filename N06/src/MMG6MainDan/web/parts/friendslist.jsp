<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<jsp:useBean id="usercontroller" class="monsterMashGroupProject.UserController" scope="session"/>

<div id="friendslist" class="dropdown-menu" style="padding:5px;position:fixed;bottom:0;right:25px;width:200px;display:block;border-radius:6px 6px 0 0;top:auto;left:auto;border-bottom:none;">
    <div id="friendscontainer" style="display:none;">
        <div id="friends" style="overflow:auto;max-height:300px">
            <ul style="list-style-type:none;margin:0;">
                <!-- JSP Loop through friends -->
                <!-- <li><a href="#"><i class="icon-user"></i> Username</a></li> -->
                <%
                    if (user.getUser().getFriends().size() == 0) {
                %>
                <!-- If user has no friends: -->
                <li><a href="#addFriend"><i class="icon-info-sign"></i> You have no friends! :(</a></li>
                <%                                } else {
                                    for (int i = 0; i < user.getUser().getFriends().size(); i++) {%>
                <li><a href="#"><i class="icon-user"></i> <%= user.getUser().getFriends().get(i).getUsername()%></a></li>
                <%
                        }
                    }
                %>
            </ul>
        </div>
        <a href="#addFriend" role="button" class="btn btn-primary btn-block" data-toggle="modal"><i class="icon-plus icon-white"></i> Add Friend</a>
    </div>
    <div id="friendslistbutton" style="text-align:center;cursor:pointer;">
        <span><i class="icon-th-list"></i> Friends <b>(<%= user.getUser().getFriends().size()%>)</b></span>
    </div>
</div>

<div id="addFriend" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
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
            <h3 id="myModalLabel">Select Server</h3>
            <select name="servers">
                <option value="http://193.60.15.159:8080/MMG6MainDan/"> Local Server </option>
                <option  value="192.168.1.1">Server One</option>
                <option  value="192.168.1.1">Server Three</option>
            </select>
        </form>
        <p class="muted">Search for a username above. The text area should list suggestions as you type.
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true"><i class="icon-remove"></i> Close</button>
        <button class="btn btn-primary"><i class="icon-plus icon-white"></i> Add Friend</button>
    </div>
</div>

<script>
    $("#friendslistbutton").click(function () {
        $("#friendscontainer").stop().slideToggle("slow");
    });
</script>
