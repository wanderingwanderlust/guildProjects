<%-- 
    Document   : addEditBlogPost
    Created on : Nov 17, 2015, 11:28:24 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog Post Editor</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <!--<link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">-->

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">


        <!-- tinyMCE  scripts -->


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

                        <!-- Begin add Blog post form -->
                        <h1>Add Blog Post</h1>
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="add-title">Title</label>
                                <br />
                                <input type="text" class="form-control" id="add-title">
                                <br/>
                                <br />
                            </div>

                            <div class="form-group">
                                <label for="mytextarea"> What's on your Mind?</label>
                                <textarea class="form-control" id="mytextarea"></textarea>

                            </div>

                            <button type="submit" id="add-button" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                                Submit Post
                            </button>

                            <button type="button" id="draftButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
                                Save Post As Draft
                            </button>

                        </form>
                    </div>


                    <!-- Right bar -->

                    <div class="col-md-2">



                        <!-- Categories -->


                        <div class="list-group" id="category-list">
                            <a href="#" class="list-group-item active">
                                Categories
                            </a>


                            <form action="action_page.php">
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Choose One
                                    <span class="caret"></span></button>
                                    <ul class="dropdown-menu" id="catList" role="menu" aria-labelledby="menu1">
                                        <li role="presentation" id="catRows"><a role="cat-item" tabindex="-1" href=""></a></li>
                                    </ul>
                                </div>
                                <br><br>
                            </form>



                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="list-group">
                                    <a href="#" class="list-group-item active">
                                        Tags
                                    </a>
                                    <a href="#" class="list-group-item">#dreambig</a>
                                </div>


                                <!-- calendar -->
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

                            <!-- add category form -->
                            
                            <div class="col-md-8 offset-4" id="addCategoryForm">
                                <form class="form-horizontal" role="form">
                                    <fieldset>
                                        <!-- Form Name -->
                                        <legend></legend>
                                        <!-- Text input-->
                                        <div class="form-group">
                                            <label control-label for="title" id="catText">Add Category</label>  
                                            <div class="col-md-12">
                                                <input id="category" name="category" type="text" placeholder="category" class="form-control">
                                            </div>
                                            </div>
                                        </div>
                                        <!-- Button -->
                                        <div class="form-group">
                                            <label class="col-md-12 control-label" for="add-category-button"></label>
                                            <div class="col-md-12">
                                                <button id="add-category-button" name="add-category-button" class="btn btn-primary">Add Category</button>
                                            </div>
                                        </div>

                                    </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/blogPostEditor.js"></script>
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/addEditPost.js"></script>


    </body>
</html>
