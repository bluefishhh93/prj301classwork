<%-- Document : calculator Created on : May 19, 2023, 10:46:53 PM Author : xuant --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
        <html>

        <head>
            <title>TODO supply a title</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <%-- <link rel="stylesheet" href="css/calculator.css" type="text/css"/> --%>
           
        </head>

        <body>
            <form action="cal" method="post">
                <label>First:</label> <input type="text" name="firstNum" value="${firstNum}"><br>
                <label>Second:</label> <input type="text" name="secondNum" value="${secondNum}"><br>
                <label>Operator:</label> <select name="operator" id="operator">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select><br>
                <input type="submit" value="compute"><br>
                <label>Result:</label> <input type="text" name="result" value="${result}"><br>
            </form>
            
        </body>

        </html>