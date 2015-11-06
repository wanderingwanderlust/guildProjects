<%-- 
    Document   : entry
    Created on : Oct 24, 2015, 7:56:17 PM
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

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script type="text/javascript" src="unitJs.js"></script>



        <title>Unit Calculator</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="container">
                <div class="page-header text-align">
                    <h1>Welcome to the Unit Calculator</h1>
                </div>
            </div>
            <div class="container text-align">
                <div class="row col-lg-12">
                    <h2>We know it's hard to remember Unit Conversions</h2>
                    <h3>That's why we are here to help make you life easier.</h3>
                    <h4>Follow the directions below and we can help you convert the unit you would like</h4>
                </div>
            </div>
            <div class="container">
                <div class="row col-lg-6 text-align">
                    <form action="UnitCalculatorServlet" method="POST">
                        <p class="text-align"><strong>Please Select from one of the following Units to begin the conversion process.</strong></p>
                        <select name ="firstChoice" id="firstChoice">
                            <option selected value="base">Please Select</option>
                            <option value="temp">Temperature</option>
                            <option value="weight">Weight</option>
                            <option value="currency">Currency</option>
                            <option value="length">Length</option>
                        </select>
                        <br />
                        <br />

                        <input type="number" name="userValue" step="any" placeholder="Enter Value"><br /> 


                        <div class="secondChoice">
                            <br />
                            <p class="text-align"><strong>Please select unit to convert from</strong></p>
                            <select class="temp" name="temp1">
                                <option value="faren" selected="selected">&#x2109;</option>
                                <option value="cel">&#x2103;</option>
                            </select>

                            <select class="weight" name="weight1">

                                <option value="lbs" selected="selected">Pounds</option>
                                <option value="kg">Kilograms</option>
                            </select>

                            <select class="currency" name="currency1">

                                <option value="usd" selected="selected">US &#36;</option>
                                <option value="cny">Chinese Renminbi &#165;</option>
                            </select>

                            <select class="length" name="length1">
                                <option value="feet" selected="selected">Feet</option>
                                <option value="meter">Meter</option>
                            </select>
                            <br />
                        </div>

                        <div class="secondChoice">
                            <br />

                            <p class="text-align"><strong>Please select unit to convert to</strong></p>

                            <select class="temp" name="temp2">

                                <option value="faren">&#x2109;</option>
                                <option value="cel" selected="selected">&#x2103;</option>
                            </select>

                            <select class="weight" name="weight2">
                                <option value="lbs">Pounds</option>
                                <option value="kg" selected="selected">Kilograms</option>
                            </select>

                            <select class="currency" name="currency2">
                                <option value="usd">US &#36;</option>
                                <option value="cny" selected="selected">Chinese Renminbi &#165;</option>
                            </select>

                            <select class="length" name="length2">
                                <option value="feet">Feet</option>
                                <option value="meter" selected="selected">Meter</option>
                            </select>
                            <br />
                            <hr />
                            <button type="submit" name="add-button" class="btn btn-default">Convert</button>
                        </div>

                    </form>
                </div>
            </div>







        </div>
    </body>

</html>