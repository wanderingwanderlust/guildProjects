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
        <title>Interest Calculator</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/starter-template.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container"> 
            <div class="starter-template"> 
                <h1>Welcome to the Interest Calculator!!!</h1>
                <form action="InterestCalculatorServlet" method="POST">
                    <p>What is the annual interest rate?</p>
                    <input type="number" name="interestRate" min="0" step="any"><br/>
                    <br/>
                
                    <p>How often is the interest compounded?</p>
                    <input type="radio" name="compundsPerYear" value="4" > Quarterly <br/>
                    <input type="radio" name="compundsPerYear" value="12" > Monthly <br/>
                    <input type="radio" name="compundsPerYear" value="365" > Daily <br/>
                    <br/>

                    <p>What is the initial principal amount?</p>
                    <input type="number" name="principal" min="0" step="any"><br/>
                    <br/>

                    <p>How many years will the money stay in the fund?</p>
                    <input type="number" name="years" min="0" step="1"><br/>
                    <br/>

                    <br/>
                    <input type="submit" value="CALCULATE"><br/>
                </form>

            </div>
        </div>

    </body>
</html>
