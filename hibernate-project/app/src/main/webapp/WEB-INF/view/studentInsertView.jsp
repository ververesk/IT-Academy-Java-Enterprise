<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Student</title>
</head>
<body>

<h3>Create Student</h3>


<form method="POST" action="${pageContext.request.contextPath}/createStudent">
    <table border="0">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${student.name}" /></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname" value="${student.surname}" /></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${student.age}" /></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" value="${student.username}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="studentList">Cancel</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>