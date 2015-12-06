<%-- 
    Document   : dashboard
    Created on : Nov 17, 2015, 11:26:44 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/blogJS.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Counterfactual Simulation Blog Dashboard</title>
    </head>
    <body>
        <!--This is the dashboard. It will allow the user/admin to manage their blog.-->
        <!-- This is the nav bar that allows the user to view the homepage and log out-->
    <div class="container-fluid">
        <header class="main-nav">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <ul class="nav navbar-nav ">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li>|</li>
                    <li role="presentation">{insert code to load preloaded phrases based on time}</li>
                    <li>|</li>
                    <li role="presentation">{insert code to load preloaded phrases based on user}</li>
                    <li>|</li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Log Out</a></li>
                </ul>
            </div>
        </nav>
        </header>
        <!-- Here are basic statistics that allow the user to be informed of his/her activitiy-->
        <div class="container" id="basicstats">
        <div class="row-fluid">
            <div class="col-md-10 .col-md-offset-4">
                <H3>Hello (user) you have:</H3>
                <p># of posts</p>
                <p># of comments</p>
                <p>* of pages</p>
                <p># of posts to be approved</p>
                <p># of comments to be approved</p>
            </div>
            <div class="col-md-2">
                <h3>Google Analytics</h3>
                <p># of page views</p>
                <p># of new views</p>
            </div>
            </div>
        </div>
        <!-- Here is the main body of the blog-->
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-md-2">
                    <ul class="list-group">
                        <a href="${pageContext.request.contextPath}/dashboard"  class="list-group-item">Blog Controller</a>
                        <a href="${pageContext.request.contextPath}/dashboard/addEditBlogPost"  class="list-group-item">Add New Post</a>
                        <a href="${pageContext.request.contextPath}/dashboard/editPost"  class="list-group-item">Edit Post</a>
                        <a href="#"  class="list-group-item">Drafts</a>
                        <a href="${pageContext.request.contextPath}/dashboard/approveComments"  class="list-group-item">Comments</a>
                        <a href="${pageContext.request.contextPath}/dashboard/addEditStaticPage"  class="list-group-item">Add New Page</a>
                        <a href="${pageContext.request.contextPath}/dashboard/addEditStaticPage"  class="list-group-item">Edit Page</a>
                        <a href="${pageContext.request.contextPath}/dashboard/addEditUser"  class="list-group-item">Add User</a>
                        <a href="${pageContext.request.contextPath}/dashboard/addEditUser"  class="list-group-item">Edit User</a>
                    </ul>
                </div>
                <div class="col-md-5">
                    <h1>RECENT ACTIVITY</h1>
                    <hr />
                    <h2>{today}|(code for user)</h2>
                    <p>(code to list 5 most recent blog posts)</p>
                </div>
                <div class="col-md-5">
                    <h1>Map of Users</h1>
                    <hr />
                    <p>insert interactive map here</p>
                    <script type="text/javascript" src="//ra.revolvermaps.com/0/0/6.js?i=0s1u7vm0zsn&amp;m=7&amp;s=320&amp;
                    c=e63100&amp;cr1=ffffff&amp;f=arial&amp;l=0&amp;bv=90&amp;lx=-420&amp;ly=420&amp;hi=20&amp;he=7&amp;hc=a8ddff&amp;rs=80"
                    async="async">
                    </script>
                </div>
            </div>
        </div>


    </div>


        <!-- Placed at end of document to load pages fast-->
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
