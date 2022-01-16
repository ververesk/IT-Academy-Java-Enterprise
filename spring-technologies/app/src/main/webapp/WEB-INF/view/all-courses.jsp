<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Courses</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<h2>All Courses </h2>
<br>
    <table class="tg" >
        <tr>
            <th>edit</th>
            <th>delete</th>
            <th>id</th>
            <th>name</th>
    </tr>
    <c:forEach  var="c" items="${courses}">
        <c:url var="updateButton" value="/updateCourse">
            <c:param name="cId" value="${c.courseId}"/>

        </c:url>
        <c:url var="deleteButton" value="/deleteCourse">
            <c:param name="cId" value="${c.courseId}"/>

        </c:url>
        <tr>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">
            </td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>
            <td>${c.courseId}</td>
            <td>${c.courseName}</td>
        </tr>
    </c:forEach>

</table>
<br>
<input class="button" type="button" value="add"
       onclick="window.location.href='addNewCourse'"/>



</body>
</html>
