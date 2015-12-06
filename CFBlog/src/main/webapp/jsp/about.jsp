<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>About Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>

    </head>
    <body>
        <div class="container-fluid col-lg-12">
            <header id="top" class="main-about">
                <nav class="navbar navbar-inverse navbar-fixed-top">
                <!--    <a class="navbar-brand" href="#">CFS</a> -->
                    <div class="container">
                        <ul class="nav nav-pills nav-justified">
                            <li role="presentation" ><a href="${pageContext.request.contextPath}/home">Home</a></li>
                            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
                            <li role="presentation"><a href="#myModal" data-toggle="modal" data-target="#myModal">Log-in</a></li>
                        </ul>
                    </div>
                </nav>
                <!-- Modal Login Attempt above under nav  ---------------------------- -->

                
                <h1 class="main-heading">Counterfactual Simulation</h1>
                <span class="main-title">Making Dreams Come True Since 1853</span>
                
            </header>
            <!-- Header Ends -->
            
           <!--  Moonshot thinking picture <div align="middle"><img src="img/moonabout.jpg" class="img-responsive" alt="Motivational_About_Jpg" width="800" height="400">
            </div> -->

            <div class="container-fluid col-lg-12">

            <div class="primary-content t-border about-background">
                <div class="jumbotron">
                    <h1>Who we are</h1> 
                    <p>Bacon jerky landjaeger sirloin andouille pork chop frankfurter ham hock kevin spare ribs sausage picanha filet mignon. Porchetta picanha fatback, pastrami sirloin swine jowl shankle hamburger rump chuck pork loin
                        cupim boudin flank. Shank drumstick bresaola pork, tail alcatra pork chop swine shoulder tenderloin spare ribs t-bone doner ribeye kevin. 
                    </p> 
                    <a class="callout" href="/contact">Contact Us</a>
                </div>
            </div> 
            </div>

         

        <!-- Begin Login Modal -->
            <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Log-in</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="login-email">Email address</label>
                            <input class="form-control" id="login-email" placeholder="Enter email" type="email">
                        </div>
                        <div class="form-group">
                            <label for="login-password">Password</label>
                            <input class="form-control" id="login-password" placeholder="Password" type="password">
                        </div>
                        <p class="text-left"><a href="http://localhost:8080/CFBlog/jsp/signup.jsp">Create New Account</a></p>
                        <p class="text-right"><a href="#">Forgot password?</a></p>
                    </div>
                    <div class="modal-footer">
                        <a href="#" data-dismiss="modal" class="btn">Close</a>
                        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-primary" id=login-button">Log-in</a>
                    </div>
                </div>
            </div>
             
            <!-- End Login Modal -->   
            
            
            
            
               <!-- Starting Footer -->
            <footer class="main-footer">
                <p>All rights reserved to the design team - Counter Factual Simulation &#169;J&#94;2 & G</p>
                <a href="#top">Back to top &raquo;</a>
            </footer>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
