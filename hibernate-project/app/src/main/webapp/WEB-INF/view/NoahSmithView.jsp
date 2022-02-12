<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>NoahSmith</title>
</head>
<body>
<h3>Noah Smith</h3>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>id</th>
        <th>grades</th>
        <th>course name</th>
    </tr>


    <c:forEach var="noahSmith" items="${requestScope.noahSmith}">
        <tr>
            <td>"${noahSmith.id}"</td>
            <td>"${noahSmith.grades}"</td>
            <td>"${noahSmith.courseName}"</td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<a href="<c:url value='/logout' />">Logout</a>

</body>
</html>
