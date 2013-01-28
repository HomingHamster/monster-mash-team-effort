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
            <script type="text/javascript" src="../css/menu/jquery/jquery.js"></script>
            <script type="text/javascript" src="../css/menu/jquery/jquery-ui.js"></script>

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
            <FORM METHOD=POST ACTION="SaveName.jsp.jsp">
                UserName: <INPUT TYPE=TEXT NAME=username SIZE=20 required="true"><BR>
                Password? <INPUT TYPE=TEXT NAME=password SIZE=20 required ="true"><BR>
                                    <P><INPUT TYPE=SUBMIT>
                                            <div class="login"><input type="submit" name="register"value="Register"></div>
                                            <div class="forgotPassword"><input type="submit" name="forgotPassword" value="Forgot Password"></div>

                                            </div>


                                            <div class="registerDiv" align="center" style="display:none">
                                                <h1> Register </h1>
                                                <p> Username : <input type="text"> </p>
                                                <p> Password: <input type="text"></p>
                                                <p> e-mail : <input type="text"> </p> 
                                                <input type="submit" value="Register" name="finishRegistration">
                                            </div>

                                            <div class="forgotDiv" align="center" style="display:none">

                                                <p> Your username : <input type="text"> </p>
                                                <p> Your e-mail : <input type="text"> </p> 
                                                <input type="button" name="requestButton" value="Request Password">



                                            </div>
                                            </body>
                                            </html>
