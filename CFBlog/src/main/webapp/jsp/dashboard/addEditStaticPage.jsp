<%-- 
    Document   : addEditStaticPage
    Created on : Nov 17, 2015, 11:28:37 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Static Page Editor</title>
        
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">


        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">    
        

        
    </head>
    <body>
        <div class="container-fluid" id="dashboardMargin">
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

        <div class="container-fluid" id="d">
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
                <div class="col-md-8">
                    <h1 id="staticPageHeadline">This text changes to "Add Page" or "Edit Page"</h1>
                    <form method="post">
                        <textarea id="mytextarea"></textarea>
                    </form>
                    <button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                        Publish Page
                    </button>

                    <script>
                        $('#myButton').on('click', function () {
                            var $btn = $(this).button('loading')
                            
                            $btn.button('reset')
                        })
                    </script>
                    <button type="button" id="draftButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                        Save Page As Draft
                    </button>
                    <script>
                        $('#draftButton').on('click', function () {
                            var $btn = $(this).button('loading')
                            // business logic...
                            $btn.button('reset')
                        })
                    </script>
                </div>
                        
                
                        
                        
                <div class="col-md-2">
                    <div class="list-group">
                        <a href="#" class="list-group-item active">
                            Categories
                        </a>
                        <a href="#" class="list-group-item">Family</a>
                        <a href="#" class="list-group-item">Travel</a>
                        <a href="#" class="list-group-item">Health</a>
                        <a href="#" class="list-group-item">Fitness</a>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="list-group">
                                <a href="#" class="list-group-item active">
                                    Tags
                                </a>
                                <a href="#" class="list-group-item">#dreambig</a>
                            </div>

                            <div class="row">
                                <div class="col-md-2">
                                    <p>
                                        <center>
                                            <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/calendar.js"></script>
                                        </center>
                                        <br/>
                                        </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>




        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
           
         <!-- tinyMCE  scripts -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/blogPostEditor.js"></script>

    </body>
</html>
