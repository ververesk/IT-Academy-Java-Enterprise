<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Teacher</title>
</head>
<body>


<h3>Update Teacher</h3>

<c:if test="${not empty teacher}">
    <form method="POST" action="${pageContext.request.contextPath}/updateTeacher">
        <input type="hidden" name="id" value="${teacher.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:#002aff;">${teacher.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${teacher.name}" /></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><input type="text" name="surname" value="${teacher.surname}" /></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input type="text" name="salary" value="${teacher.salary}" /></td>
            </tr>
            <tr>
                <td>Course_ID</td>
                <td><input type="text" name="courseId" value="${teacher.courseId}" /></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" value="${teacher.username}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/teacherList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>