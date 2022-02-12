<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Grades</title>
</head>
<body>


<h3>Update Grades</h3>

<c:if test="${not empty mathCourse}">
    <form method="POST" action="${pageContext.request.contextPath}/updateGrade">
        <input type="hidden" name="id" value="${mathCourse.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${mathCourse.id}</td>
            </tr>
            <tr>
                <td>grades</td>
                <td><input type="text" name="grades" value="${mathCourse.grades}" />
                    <form:errors path="grades"/></td>
            </tr>
            <tr>
                <td>studentName</td>
                <td><input type="text" name="studentName" value="${mathCourse.studentName}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/mathCourses">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
