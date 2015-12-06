<%-- 
    Document   : approveComments
    Created on : Nov 23, 2015, 9:16:09 PM
    Author     : Jonathan Chiou, Greg Lindman, 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Comments</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- Custom css styles for CF blog -->
        <link href="${pageContext.request.contextPath}/css/cfblog.css" rel="stylesheet">

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

                    <!-- Begin Body -->        

                    <div class="col-md-8">
                        <h1>Approve Comments</h1>


                            <!--   COMMENT SNIPPET TEST    -->

                        <div class="row">
                            <div class="col-lg-8 col-sm-8 col-xs-12">
                                
                                <h3>Newest Comments awaiting approval.</h3>
                                <hr>
                                <ul class="media-list comments">
                                    <li class="media">
                                        <a class="pull-left" href="#">
                                            <img class="media-object img-circle img-thumbnail" src="http://www.gannett-cdn.com/-mm-/f36ccebc1dd390e670b65ddc1e314350f181358c/c=0-39-497-702&r=537&c=0-0-534-712/local/-/media/2015/05/26/Burlington/Burlington/635682343095546552-Sanders.jpg" width="64" alt="Generic placeholder image">
                                        </a>
                                        <div class="media-body">
                                            <h5 class="media-heading pull-left">Bernie Sanders</h5>
                                            <div class="comment-info pull-left">
                                                <div class="btn btn-primary btn-xs" data-toggle="tooltip" data-placement="top" title="Sent from ***0.0.1">Approve<i class="fa fa-user"></i></div>
                                                <div class="btn btn-danger btn-xs"><a class="fa fa-envelope white" href="mailto:loneswan@loneswan.net">Decline</a></div>
                                                <div class="btn btn-default btn-xs"><i class="fa fa-clock-o"></i> Posted 3 hours ago</div>
                                            </div>
                                            <br class="clearfix">
                                            <p class="well">Health care must be recognized as a right, not a privilege.</p>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <a class="pull-left" href="#">
                                            <img class="media-object img-circle img-thumbnail" src="http://dailysignal.com/wp-content/uploads/150227_DonaldTrump.jpg" width="64" alt="Generic placeholder image">
                                        </a>
                                        <div class="media-body">
                                            <h5 class="media-heading pull-left">Donald Trump</h5>
                                            <div class="comment-info pull-left">
                                                <div class="btn btn-primary btn-xs" data-toggle="tooltip" data-placement="top" title="Sent from ***0.0.1">Approve<i class="fa fa-user"></i></div>
                                                <div class="btn btn-danger btn-xs"><a class="fa fa-envelope white" href="mailto:loneswan@loneswan.net">Decline</a></div>
                                                <div class="btn btn-default btn-xs"><i class="fa fa-clock-o"></i> Posted 3 hours ago</div>
                                            </div>
                                            <br class="clearfix">
                                            <p class="well">The only way that's possible is by Bernie taxing you people' at 90 percent.</p>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <a class="pull-left" href="#">
                                            <img class="media-object img-circle img-thumbnail" src="http://www.arabianbusiness.com/incoming/article539707.ece/BINARY/Richard-Branson.jpg" width="64" alt="Generic placeholder image">
                                        </a>
                                        <div class="media-body">
                                            <h5 class="media-heading pull-left">Richard Branson</h5>
                                            <div class="comment-info pull-left">
                                                <div class="btn btn-primary btn-xs" data-toggle="tooltip" data-placement="top" title="Sent from ***0.0.1">Approve<i class="fa fa-user"></i></div>
                                                <div class="btn btn-danger btn-xs"><a class="fa fa-envelope white" href="mailto:loneswan@loneswan.net">Decline</a></div>
                                                <div class="btn btn-default btn-xs"><i class="fa fa-clock-o"></i> Posted 2 hours ago</div>
                                            </div>
                                            <br class="clearfix">
                                            <p class="well">Haha... Have faith Mr Trump.</p>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>



                            <!--  END COMMENT SNIPPET -->






                        <!-- each comment is it's own form. We may also want to nest everything inside a larger form witch check boxes so that the user can approve/deny multiple comments -->

                        <!-- 
                         <form method="post">
                             <div class="unapprovedComment">This is a super simple mockup of a sample comment</div>
                         </form>
                         <button type="button" id="approveButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off" style="background-color: lightgreen " >
                             Approve Comment
                         </button>
                         <button type="button" id="declineButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off" style="background-color:tomato">
                             Decline Comment
                         </button>
                         
                          <form method="post">
                             <div class="unapprovedComment">This is a super simple mockup of a sample comment</div>
                         </form>
                         <button type="button" id="approveButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off" style="background-color: lightgreen " >
                             Approve Comment
                         </button>
                         <button type="button" id="declineButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off" style="background-color:tomato">
                             Decline Comment
                         </button>
                         
                          <form method="post">
                             <div class="unapprovedComment">This is a super simple mockup of a sample comment</div>
                         </form>
                         <button type="button" id="approveButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off" style="background-color: lightgreen " >
                             Approve Comment
                         </button>
                         <button type="button" id="declineButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off" style="background-color:tomato">
                             Decline Comment
                         </button>
                          Trying a different comment form. -->

                    </div>


                    <!-- Begin right side bar... -->


                    <!-- Categories -->
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


                        <!-- Tags -->    
                        <div class="row">
                            <div class="col-md-12">
                                <div class="list-group">
                                    <a href="#" class="list-group-item active">
                                        Tags
                                    </a>
                                    <a href="#" class="list-group-item">#dreambig</a>
                                </div>


                                <!-- Calendar -->    
                                <div class="row">
                                    <div class="col-md-6">
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



        <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>                
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
