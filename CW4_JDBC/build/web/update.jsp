<%-- 
    Document   : update
    Created on : Jun 2, 2023, 9:39:46 PM
    Author     : xuant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Student</h1>
        <c:set var="c" value="${requestScope.student}">

        </c:set>
        <form action="update" method="post">
            ID: <input type="text" name="id" value="${c.id}" readonly><br>
            Enter Name:<input type="text" name="name" value="${c.name}"><br>

            <input type="radio" name="gender" value="male"> Male
            <input type="radio" name="gender" value="female"> Female<br>

            Enter DOB:<input type="date" name="dob" value="${c.dob}"><br>
            <input type="submit" name="name" value="Update">
        </form>
    </body>
</html>
