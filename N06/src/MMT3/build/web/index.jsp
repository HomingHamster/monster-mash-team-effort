<%-- 
    Document   : index
    Created on : Oct 6, 2012, 11:17:45 AM
    Author     : jamesslater
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Monster Mash Login</title>
        <link href="resources/template/css/bootstrap.min.css" rel="stylesheet" media="screen">
            <!-- jQuery files -->
            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
            <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>

            <script type="text/javascript"> 
                $(document).ready(function(){
                    $(".login").click(function(){
                        $(".registerDiv").slideToggle("slow");
                        $(".forgotDiv").slideUp("slow");
                    });
                });
            </script> 
            <script type="text/javascript"> 
                $(document).ready(function(){
                    $(".forgotPassword").click(function(){
                        $(".forgotDiv").slideToggle("slow");
                        $(".registerDiv").slideUp("slow");
                    });
                });
            </script> 

    </head>
    <body>
        <div id="header">
            <img src="resources/template/img/indexheader2.png" width="930px" class="img-polaroid">
        </div>
        <div class="mainbody" align="center">
            <FORM name="first" METHOD=POST ACTION="SaveName.jsp">
                UserName: <INPUT TYPE=TEXT NAME=username SIZE=20><BR>
                        Password: <INPUT TYPE=TEXT NAME=password SIZE=20><BR>
                                <P><INPUT TYPE=SUBMIT VALUE="Login"></p>
                                        </form>
                                        <div class="login"><input type="submit" name="register"value="Register"></div>
                                        <div class="forgotPassword"><input type="submit" name="forgotPassword" value="Forgot Password"></div>

                                        </div>


                                        <div class="registerDiv" align="center" style="display:none">
                                            <h1> Register </h1>
                                            <form name="second" method=POST action="CreateUser.jsp">
                                                <p> Username : <input type="text" name="regUsername"> </p>
                                                <p> Password: <input type="text" name="regPassword"></p>
                                                <p> e-mail : <input type="text" name="regEmail"> </p> 
                                                <input type="submit" value="Register" >
                                            </form>
                                        </div>

                                        <div class="forgotDiv" align="center" style="display:none">

                                            <p> Your username : <input type="text"> </p>
                                            <p> Your e-mail : <input type="text"> </p> 
                                            <input type="button" name="requestButton" value="Request Password">



                                        </div>
                                        </body>
                                        </html>
