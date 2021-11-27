<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Teacher</title>
</head>
<body>

<h3>Create Teacher</h3>


<form method="POST" action="${pageContext.request.contextPath}/createTeacher">
    <table border="0">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${teacher.name}" /></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname" value="${teacher.surname}" /></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="salary" value="${teacher.salary}" /></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" value="${teacher.username}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="teacherList">Cancel</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
