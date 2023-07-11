<%-- 
    Document   : list
    Created on : May 30, 2023, 10:09:48 AM
    Author     : xuant
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Do you want delete category with id =" + id)) {
                    window.location = "delete?id=" + id;
                }
            }

        </script>
    </head>
    <body>

    <Center>
        <c:set var="page" value="${requestScope.page}"/>
        <div class="pagination">
            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                <a href="list?page=${i}">${i}</a>
            </c:forEach>
        </div>
        <h1>List of categories</h1>

        <h3><a href="add.jsp">Add new</a></h3>

        <table border = "1px" width = "40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Gender</th>
                <th>DOB</th>
                <th>ACTION</th>
            </tr>
            <%--ben kia dat ten la data nen .data--%>
            <c:forEach items="${requestScope.data}" var="c">
                <c:set var="id" value="${c.id}"/>
                <tr>
                    <td>${id}</td>
                    <td>${c.name}</td>
                    <td>${c.gender ? 'male' : 'female'}</td>
                    <td>
                        <input type="date" id="dob" name="dob" value="${c.dob}" readonly>
                    </td>
                    <td>
                        <a href="update?id=${id}">Update</a> &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="#" onclick="doDelete('${id}')">Delete</a>
                    </td>   
                </tr>
            </c:forEach>

        </table>
    </Center>
</body>
</html>
