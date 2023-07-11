<%-- 
    Document   : index
    Created on : Jun 16, 2023, 12:56:13 PM
    Author     : xuant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Name" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- comment <h1>ClassWork 5</h1>

        <h4>list names String in array: ${names[0]},${names[1]},${names[2]}</h4
        <h4>list firstName of Name Object in array: ${requestScope.arrayName[0].firstName}, ${requestScope.arrayName[1].firstName}, ${requestScope.arrayName[2].firstName}</h4
        <br/>
        <h4>list lastName of Name Object in array: ${requestScope.arrayName[0].lastName},${requestScope.arrayName[1].lastName},${requestScope.arrayName[2].lastName}</h4
        <br/>
        <h4>list lastName of Name Object in arraylist: <br/>${requestScope.listOfName.get(0)}<br/>${requestScope.listOfName.get(1)}<br/>${requestScope.listOfName.get(2)}</h4

        <<h3>Employee information:</h3> <br/>
        <h4>${requestScope.listOfEmployee.get(0)}</h4><br/>
        <h4>${requestScope.listOfEmployee.get(1)}</h4><br/>
        <h4>${requestScope.listOfEmployee.get(2)}</h4><br/>
        -->
        
        <c:forEach items="${names}" var="name">
            <h1>${name}</h1>
        </c:forEach>
        
        

        
    
    </body>
</html>
