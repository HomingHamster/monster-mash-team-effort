<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Monster Mash- Shop</title>
        <link href="resources/template/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="resources/template/css/style.css">
    </head>

    <body>
        <div class="container">
            <div id="header">
                <img src="resources/template/img/indexheader2.png" width="930px" class="img-polaroid">
            </div>
            <div class="navigation">
                <div class="navbar">
                    <div class="navbar-inner">
                        <a class="brand" href="welcome.jsp">Monster Mash</a>
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
                    <h1>Shop</h1>
                </div>
                <div class="navigation">
                    <div class="navbar">
                        <div class="navbar-inner">                       
                            <ul class="nav">
                                <li><a href="shop.jsp">Buy Monsters</a></li>
                                <li class="active"><a href="#">Sell Monsters</a></li>
                            </ul>
                            <div id="table">

                                <table border="3">
                                    <tbody>
                                        <tr>
                                            <td> Monster </td>
                                            <td> Class </td>
                                            <td> Aggression </td>
                                            <td> Deffense </td>
                                            <td> Level </td>
                                            <td> Age </td>
                                            <td> Price </td>
                                            <td> Select </td>

                                        </tr>
                                        <tr>
                                            <td><img width="80px" src="resources/template/img/battlebee.png"></td>
                                            <td> Air</td>
                                            <td>13</td>
                                            <td>7</td>
                                            <td>3</td>
                                            <td>1</td>
                                            <td>350</td>
                                            <td><input type=checkbox></td>
                                        </tr>
                                        <tr>
                                            <td><img width="70px" src="resources/template/img/fireye.jpg"></td>
                                            <td>Fire</td>
                                            <td>18</td>
                                            <td>13</td>
                                            <td>5</td>
                                            <td>2</td>
                                            <td>800</td>
                                            <td><input type=checkbox></td>
                                        </tr>
                                        <tr>
                                            <td><img width="80px" src="resources/template/img/rockm.png"></td>
                                            <td> Air</td>
                                            <td>16</td>
                                            <td>22</td>
                                            <td>7</td>
                                            <td>3</td>
                                            <td>1500</td>
                                            <td><input type=checkbox></td>
                                        </tr>
                                    <button type="submit" name="send"><p>Sell Monster(s)</p></button><p>&nbsp;</p>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>


                </span></p>

            </div>
        </div>
    </div>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>

</html>