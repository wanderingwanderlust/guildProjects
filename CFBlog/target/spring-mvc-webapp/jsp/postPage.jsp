<%-- 
    Document   : blogPost
    Created on : Nov 17, 2015, 11:28:52 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REPLACE THIS TEXT WITH BLOG POST TITLE + Counterfactual Simulation</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    </head>
    <body>



        <div class="container-fluid">
            <div class="container-fluid col-md-12">
                <header id="top" class="header">
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
                    <br>
                    <br>
                </header>



                <!-- begin blog main content below -->
                <div class="container-fluid">
                    <div class="container-fluid col-md-12">
                        <div class="primary-content t-border">
                            <div id="blog-post-content">
                                <h1>Replace this heading with the blog post title</h1>
                                <p class="intro">
                                    Typewriter single-origin coffee stumptown direct trade. Austin pickled neutra whatever, occaecat ea brunch slow-carb commodo hashtag nesciunt. Ennui hashtag pariatur nesciunt, est twee knausgaard asymmetrical pour-over offal mollit DIY chartreuse microdosing adipisicing. Dolor mixtape sapiente gentrify banjo gluten-free. Vinyl est waistcoat pork belly locavore, butcher crucifix blog elit vero chartreuse umami distillery. Forage fashion axe accusamus freegan squid semiotics, pop-up heirloom dolore hella enim ullamco dreamcatcher small batch. Williamsburg tousled ugh, 8-bit bitters messenger bag celiac normcore pariatur.
                                </p>

                            </div>

                            <hr>


                            <!-- COMMENTS -->
                            <div id="blog-post-comments">

                                <h2 id="comment-header">Leave a comment</h2>

                                <div id="comment_form" class="show">
                                     <form method="post" id="comment-form">

                                    <div>
                                        <input type="text" name="name" id="name" value="" placeholder="Name">
                                    </div>
                                    <div>
                                        <input type="email" name="email" id="email" value="" placeholder="Email">
                                    </div>
                                    <div>
                                        <input type="url" name="website" id="website" value="" placeholder="Website URL">
                                    </div>
                                    <div>
                                        <textarea rows="10" name="comment" id="comment" placeholder="Comment"></textarea>
                                    </div>
                                    <div>
                                        <button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                                    Submit Comment
                                </button>
                                       
                                    </div>
                                </form>
                                </div>

                            </div>


                        </div>

                        <footer class="main-footer">
                            <p>All rights reserved to the design team &#169;J&#94;2 & G</p>
                            <a href="#top">Back to top &raquo;</a>
                        </footer>
                    </div>
                </div>
            </div>    
        </div>

        <!-- Placed at end of document to load pages fast-->
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


    </body>
</html>
