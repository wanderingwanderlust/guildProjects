<%-- 
    Document   : response
    Created on : Oct 23, 2015, 1:09:45 PM
    Author     : aaron
--%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">
                <title>Factorizer</title>
                <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
                <link href="css/starter-template.css" rel="stylesheet" type="text/css">
                <link href="factorCSS.css" type="text/css" rel="stylesheet" />
                <title>Factorizer Results</title>
            </head>

            <body>
                <div class="container-fluid">
                    <div class="container">
                        <div class="page-header text-center">
                            <h1>Factorizer Results</h1>
                        </div>
                    </div>
                <div class="container">
                   <div class="col-lg-12 text-center">
                    <p>There are ${counter} factors of ${numToFactor}.</p>
                    <p>The factors are:</p>
                    <p id="fcolor">
                    <c:forEach var="n" items="${factors}">
                        <c:out value="${n}" />
                        <br/>
                    </c:forEach>
                       </p>
                    <p>Perfect Number? ${perfectNum}</p>
                    <p>Prime Number? ${primeNum}</p>
</div>
</div>

                </div>
            </body>

            </html>