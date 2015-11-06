<%-- 
    Document   : entry
    Created on : Oct 24, 2015, 6:32:32 PM
    Author     : apprentice
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="">
            <meta name="author" content="">
            <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">
            <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
            <link href="css/starter-template.css" rel="stylesheet" type="text/css">
            <link href="tipCss.css" rel="stylesheet" type="text/css">
            <title>Tip Calculator</title>
        </head>

        <body>
            <div class="container-fluid">

                <div class="page-header text-align">
                    <h1>Welcome to the Tip Calculator</h1>
                </div>
                <div class="container col-lg-12 text-align">
                    <h2> Have you ever been confused about how much to tip?</h2>
                    <h3> Please follow the directions and you will know exactly how to tip in every situation.</h3>
                </div>
                <div class="continer">
                   <div class="row col-lg-6">
                       <form action="TipCalculatorServlet" method="POST">
                        <br/><p class="text-align"><strong>What is the total of your bill?</strong></p>
                        <p class="text-align">&#36;<input type="number" name="totalBill" min="0" step="any" ><br/></p>
                    <p class="text-align"><strong>What is the percentage that you would like to tip?</strong></p>
                          <p class="text-align"><input type="number" name="tipPercent" min="0" step="any" >&#37;<br /></p> 
                          <p class="text-align"><input type="submit" value="tip"><br/></p>   
                       </form>   
                   </div>
                   <div class="row col-lg-6">
                       <img src="photos/o-TIP-JAR-facebook.jpg" id="resize">
                   </div>
                </div>



            </div>
        </body>

        </html>