<%-- 
    Document   : login
    Created on : May 30, 2023, 12:33:54 PM
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

        <%
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String user_init = getServletContext().getInitParameter("user_init");
        String pass_init = getServletContext().getInitParameter("pass_init");
        if(user != null && pass != null)
        if (user.equals(user_init) && pass.equals(pass_init)) {
            request.getRequestDispatcher("welcome").forward(request, response);
        } else if (!user.equals(user_init)) {
        %>
        <h2 style="color: red">The user does not exist</h2>
        <%
        } else if (user.equals(user_init) && !pass.equals(pass_init)) {
        %>
        <h2 style="color: red">>You have entered incorrect password</h2>

        <%
        }
        %>
        <form>
            User: <input type="text" name="user" value="" required><br>
            Password: <input type="password" name="pass" value="" required><br>
            <input type="submit" value="login" >
        </form>
    </body>
</html>
