<%-- 
    Document   : newjsp
    Created on : Jun 25, 2023, 11:02:50 AM
    Author     : xuant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/CustomAttribute.tld" prefix="at" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <at:CustomAttribute name="Thanh" time="02/03/2003"/>
        <at:RatingTag max="5" min="1" value="3"/>
        <rate
    </body>
</html>
