<!DOCTYPE html>
<jsp:useBean id="user" class="monsterMashGroupProject.Login" scope="session"/>
<html lang="en">
    <head>
        <title>Monster Mash- Main Page</title>
        <link href="resources/template/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>

    <body>
        <div class="container">
            <div id="header">
                <img src="resources/template/img/indexheader2.png" width="930px" class="img-polaroid">
            </div>
            <div class="navigation">
                <div class="navbar">
                    <div class="navbar-inner">
                        <a class="brand" href="#">Monster Mash</a>
                        <ul class="nav">
                            <li class="active"><a href="welcome.jsp">Home</a></li>
                            <li><a href="#">Login</a></li>
                            <li><a href="#">Register</a></li>
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

                <div class="span10">
                    <h1>Welcome Page <%= user.user.getUsername()%> </h1>

                    <p>Placeholder placeholder placeholder</p>

                    <p>Placeholder placeholder placeholder</p>
                </div>
            </div>



        </div>

        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>

</html>