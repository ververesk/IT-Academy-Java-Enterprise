<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>MathCourse</title>
</head>
<body>
<h3>MathCourse</h3>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>id</th>
        <th>grades</th>
        <th>student name</th>
        <th>change grade</th>
    </tr>


    <c:forEach var="mathCourses" items="${requestScope.mathCourses}">
        <tr>
            <td>"${mathCourses.id}"</td>
            <td>"${mathCourses.grades}"</td>
            <td>"${mathCourses.studentName}"</td>
            <td>
                <a href="updateGrade?id=${mathCourses.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<a href="<c:url value='/logout' />">Logout</a>

</body>
</html>



