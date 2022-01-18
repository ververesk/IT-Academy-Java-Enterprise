<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher info</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<h2>Teacher info</h2>
<p>
<form:form action="saveTeacher" modelAttribute="teacher" method="post">
    <form:hidden path="id"></form:hidden>
    NAME   <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    SURNAME   <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    SALARY   <form:input path="salary"/>
    <br><br>
    COURSE <form:input path="course"/>
    <br><br>
    USERNAME   <form:input path="username"/>
    <br><br>
</p>
    <input class="button" type="submit" value="OK">
</form:form>
<br><br>
<a href="${pageContext.request.contextPath}/" >Back</a>
</body>
</html>
