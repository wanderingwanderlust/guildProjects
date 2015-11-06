<%-- 
    Document   : entry
    Created on : Oct 22, 2015, 1:34:49 PM
    Author     : aaron
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
        <title>Factorizer</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/starter-template.css" rel="stylesheet" type="text/css">
        <link href="factorCSS.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
       <div class="container-fluid">
        <div class="container"> 
           
            <div class="page-header">
               <div class= "row text-center"> 
                <h1>Welcome to Factorizer, where we factorize your number!!!</h1>
                </div>
            </div>
               <div class="container">
               <div class="col-lg-12 text-center">
                <form action="FactorizerServlet" method="POST">
                    <h2 id="funcolor">Which number would you like to factorize?</h2><br />
                    <input type="number" name="numToFactor" min="0" step="1" ><br/>
                   
                   <br/> <input type="submit" value="FACTORIZE"><br/>
                </form>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
