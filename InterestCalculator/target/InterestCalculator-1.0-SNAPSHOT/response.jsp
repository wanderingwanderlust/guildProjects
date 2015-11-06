<%-- 
    Document   : response
    Created on : Oct 23, 2015, 4:07:47 PM
    Author     : aaron
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator Results</title>
    </head>
    <body>
        <h1>Interest Calculator Results</h1>

        <c:forEach var="YearResult" items="${listYearResults}">
            Year: <c:out value="${YearResult.currentYear}"/> <br/>
            Begin Year Balance: &#36;<c:out value="${YearResult.currentBalance}"/> <br/>
            Interest Earned for Year: &#36;<c:out value="${YearResult.interestEarned}"/> <br/>
            End Year Balance: &#36;<c:out value="${YearResult.endOfYearBalance}"/> <br/>
            <br/>
        </c:forEach>
    </body>
</html>
