<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>INFO for Noah Smith</title>
</head>
<body>
<h2>INFO for Noah Smith</h2>
<br>
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
</body>
</html>
