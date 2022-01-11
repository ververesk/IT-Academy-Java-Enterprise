<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Teachers</title>
</head>
<body>
<h2>All Teachers </h2>
<br>
    <table border="1" cellpadding="5" cellspacing="1" >
        <tr>
            <th>edit</th>
            <th>delete</th>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>salary</th>
            <th>course</th>
            <th>username</th>

    </tr>
    <c:forEach  var="t" items="${allTeach}">
        <c:url var="updateButton" value="/updateTeacher">
            <c:param name="tId" value="${t.id}"/>

        </c:url>
        <c:url var="deleteButton" value="/deleteTeacher">
            <c:param name="tId" value="${t.id}"/>

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
            <td>${t.id}</td>
            <td>${t.name}</td>
            <td>${t.surname}</td>
            <td>${t.salary}</td>
            <td>"${t.course.courseName}"</td>
            <td>${t.username}</td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="add"
       onclick="window.location.href='addNewTeacher'"/>



</body>
</html>
