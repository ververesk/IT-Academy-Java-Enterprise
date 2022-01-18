<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Math Course</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<h2>Math Course </h2>
<br>
    <table class="tg">
        <tr>
            <th>edit</th>
            <th>id</th>
            <th>grades</th>
            <th>studentName</th>

    </tr>
    <c:forEach  var="m" items="${mathCourseList}">
        <c:url var="updateButton" value="/updateMathCourse">
            <c:param name="id" value="${m.id}"/>
        </c:url>
        <tr>
            <td>
                <input class="button" type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">
            </td>
            <td>${m.id}</td>
            <td>${m.grades}</td>
            <td>${m.studentName}</td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/" >Back</a>
</body>
</html>
