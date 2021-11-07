<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teachers</title>
</head>
<body>
<h3>Teachers</h3>

<a href="sumSalary" >total salary of teachers</a>
<br>
<br>
<a href="avgSalary" >average salary of teachers</a>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>salary</th>
        <th>course_ID</th>
        <th>username</th>
        <th>edit</th>
        <th>delete</th>
    </tr>


    <c:forEach var="teach" items="${requestScope.teachers}">
        <tr>
            <td>"${teach.id}"</td>
            <td>"${teach.name}"</td>
            <td>"${teach.surname}"</td>
            <td>"${teach.salary}"</td>
            <td>"${teach.courseId}"</td>
            <td>"${teach.username}"</td>
            <td>
                <a href="updateTeacher?id=${teach.id}">Edit</a>
            </td>
            <td>
                <a href="deleteTeacher?id=${teach.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="createTeacher" >Create Teacher</a>
</body>
</html>
