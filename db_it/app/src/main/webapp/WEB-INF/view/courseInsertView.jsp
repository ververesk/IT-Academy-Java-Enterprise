<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Course</title>
</head>
<body>

<h3>Create Course</h3>


<form method="POST" action="${pageContext.request.contextPath}/createCourse">
    <table border="0">
        <tr>
            <td>Name</td>
            <td><input type="text" name="courseName" value="${course.courseName}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="courseList">Cancel</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>