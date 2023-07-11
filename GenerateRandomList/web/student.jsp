<%-- 
    Document   : student
    Created on : May 23, 2023, 9:50:55 PM
    Author     : xuant
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
<form action="studentservlet" method="get">
    Number of Students: <input type="text" name="num" value="${num}">
    <input type="submit" value="generate">
</form>
<div>
    <center>
        <c:set var="page" value="${requestScope.page}"/>
        <div class="pagination">
            <c:set var="startPage" value="${page - 2}"/>
            <c:set var="endPage" value="${page + 2}"/>
            <c:if test="${startPage < 1}">
                <c:set var="startPage" value="1"/>
            </c:if>
            <c:if test="${endPage > requestScope.numOfPage}">
                <c:set var="endPage" value="${requestScope.numOfPage}"/>
            </c:if>

            <c:choose>
                <c:when test="${startPage > 1}">
                    <a href="page?page=1">First</a>
                </c:when>
                <c:otherwise>
                    <span class="disabled">First</span>
                </c:otherwise>
            </c:choose>

            <c:forEach begin="${startPage}" end="${endPage}" var="i">
                <c:choose>
                    <c:when test="${i == page}">
                        <span class="current">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="page?page=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:choose>
                <c:when test="${endPage < requestScope.numOfPage}">
                    <a href="page?page=${requestScope.numOfPage}">Last</a>
                </c:when>
                <c:otherwise>
                    <span class="disabled">Last</span>
                </c:otherwise>
            </c:choose>
        </div>
    </center>
</div>

<table border="1px" class="student-table">

    <c:if test="${not empty data}">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>GENDER</th>
            <th>DOB</th>
            <th>ACTION</th>
        </tr>
        <c:forEach items="${data}" var="student">
            <form action="change" method="post">
                <tr>
                    <td>
                        <input type="text" name="id" value="${student.id}" readonly>
                    </td>
                    <td>
                        <input type="text" name="name" value="${student.name}">
                    </td>
                    <td>
                        <input type="checkbox" id="gender" name="gender" value="male" ${student.gender ? 'checked' : ''} />
                    </td>
                    <td>
                        <input type="date" id="dob" name="dob" value="${student.dob}">
                    </td>
                    <td>
                        <!-- Buttons for update and delete -->
                        <input type="submit" name="action" value="update">
                        <input type="submit" name="action" value="delete">
                    </td>
                </tr>
            </form>
        </c:forEach>
    </c:if>

</table>

</body>
</html>
