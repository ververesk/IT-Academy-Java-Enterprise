
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
</head>
<body>


<h3>Update Student</h3>

<c:if test="${not empty student}">
    <form method="POST" action="${pageContext.request.contextPath}/updateStudent">
        <input type="hidden" name="id" value="${student.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${student.id}</td>
            </tr>
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
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/studentList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>
</body>
</html>
