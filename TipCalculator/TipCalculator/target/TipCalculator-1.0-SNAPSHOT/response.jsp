<%-- 
    Document   : response
    Created on : Oct 24, 2015, 6:32:51 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Results</title>
    </head>
    <body>
        <div class="container-fluid">
        <div class="container">
        <div class="page-header text-align">
        <h1>Your Information</h1>
        </div>
        </div>
            <div>
                <h2>Bill: &#36;${totalBill}</h2>
                <h2> Tip &#37;${tipPercent}
                <h2>Tip Amount: &#36;${tipCalc}</h2>
                <h2>Total: &#36;${total}</h2>
                
            </div>
        </div>
            
    </body>
</html>
