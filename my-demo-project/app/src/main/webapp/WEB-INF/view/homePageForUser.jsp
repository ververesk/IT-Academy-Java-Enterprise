<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <title>Home Page</title>
</head>
<body>
<h1> Home page</h1>
<br>
<a href="listStudent">View a list of student's surnames</a>
<br>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>