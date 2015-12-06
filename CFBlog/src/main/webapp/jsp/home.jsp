<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Counterfactual Simulation</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
    </head>
    <body>
    <div class="container-fluid">
        <div class="container-fluid col-lg-12">
            <header id="top" class="main-header">
                <nav class="navbar navbar-inverse navbar-fixed-top">
                    <a class="navbar-brand" href="#">CFS</a>
                    <div class="container">
                        <ul class="nav nav-pills nav-justified">
                            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                            <li role="presentation" ><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
                            <li role="presentation"><a href="#myModal" data-toggle="modal" data-target="#myModal">Log-in</a></li>
                        </ul>
                    </div>
                </nav>
            <span class="home-title">Help Making Outlandish Dreams Come True</span>
            <h1 class="home-heading">Counterfactual Simulation</h1>
            <img class="arrow" src="img/arrow.svg" alt="Down arrow">
        </header>

                            <!--Here is where the tinymce from the dashboard will goo -->
        <div class="primary-content t-border">
            <!-- This is where the blogs populate-->
        <div class="row" id="blogsforfun">
            <div class="col-lg-12">
                <h2>My Blogs</h2>
                <table id="blogTable" class="table table-hover">
                    <tr>
                        <th width="60%">Title</th>
                    </tr>
                    <tbody id="contentRows"></tbody>
                            </table>
            </div>
        </div>
            <a class="callout" href="#more">Find out more</a>
                      <hr />
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
                            
            <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" 
            aria-labelledby="detailsModalLable" aria-hidden="true">
             <div class="modal-dialog">
                 <div class="modal-content">
                     <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal">
                             <span aria-hidden="true">&times;</span>
                             <span class="sr-only">Close</span>
                         </button>
                         <h4 class="modal-title" id="detailsModalLabel">Blog Posts</h4>
                     </div>
                     <div class="modal-body">
                         <h3 id="blog-post-id"></h3>
                         <table class="table table-bordered">
                            <tr><th></th><td id="blog-post-id"></td></tr>
                            <tr><th></th><td id="blog-title"></td></tr>
                            <tr><th></th><td id="blog-text"></td></tr>
                            
                         </table>
                     </div>
                 </div>
                 <div class="modal-footer">
                         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                     </div>
                 </div>
             </div> 
         </div>



        <footer class="main-footer">
            <p>All rights reserved to the design team &#169;J&#94;2 & G</p>
            <a href="#top">Back to top &raquo;</a>
        </footer>
    </div>

 



    <!-- Placed at end of document to load pages fast-->
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath}/js/blogPostEditor.js"></script>

</body>
</html>

