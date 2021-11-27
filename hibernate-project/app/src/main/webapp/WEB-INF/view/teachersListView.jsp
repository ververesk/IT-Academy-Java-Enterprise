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

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>edit</th>
        <th>delete</th>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>salary</th>
        <th>courses</th>
        <th>username</th>

    </tr>


    <c:forEach var="teach" items="${requestScope.teachers}">
        <tr>
            <td>
                <a href="updateTeacher?id=${teach.id}">Edit</a>
            </td>
            <td>
                <a href="deleteTeacher?id=${teach.id}">Delete</a>
            </td>
            <td>"${teach.id}"</td>
            <td>"${teach.name}"</td>
            <td>"${teach.surname}"</td>
            <td>"${teach.salary}"</td>
            <td>"${teach.course.courseName}"</td>
            <td>"${teach.username}"</td>
        </tr>
    </c:forEach>
</table>
<a href="createTeacher" >Create Teacher</a>
<br>
<br>
<a href="avgSalary" >Average Salary Of Teachers</a>
<br>
<br>
<a href="sumSalary" >Sum Salary Of Teachers</a>
<jsp:include page="homePage.jsp" />
</body>
</html>

