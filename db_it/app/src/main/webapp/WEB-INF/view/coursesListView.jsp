<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<h3>Courses</h3>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>courseId</th>
        <th>name</th>
        <th>delete</th>
    </tr>


    <c:forEach var="course" items="${requestScope.courses}">
        <tr>
            <td>"${course.courseId}"</td>
            <td>"${course.courseName}"</td>
            <td>
                <a href="deleteCourse?courseId=${course.courseId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="createCourse" >Create Course</a>
</body>
</html>


</body>
</html>
