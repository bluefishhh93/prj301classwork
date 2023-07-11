<%-- 
    Document   : login
    Created on : Jun 13, 2023, 10:41:46 AM
    Author     : xuant
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <h3 style="color: red">${requestScope.error}</h3>
        <c:set var="cookie" value="pageContext.cookies"/>
        <form action="login" method="post">
            Enter username: <input type="text" name="user" value="${cookie.cuser.value}"><br/>
            Enter password: <input type="password" name="pass" value="${cookie.cpass.value}"><br/>
            <input type="checkbox" ${cookie.crem!= null ? 'checked':''} name="rem" value="ON">
            <input type="submit" value="Login">
        </form>
    </body>
</html>
