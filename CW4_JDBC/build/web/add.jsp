<%-- 
    Document   : add
    Created on : May 30, 2023, 9:09:52 PM
    Author     : xuant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add a new Student</h1>
        <h3 style="color: red">${requestScope.error}</h3>
        <form action="add" method="get">
            Enter Name:<input type="text" name="name"><br>
            <input type="radio" name="gender" value="male"> Male
            <input type="radio" name="gender" value="female"> Female<br>
            Enter DOB:<input type="date" name="dob"><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
