<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student info</title>
</head>
<body>
<h2>Student info</h2>
<form:form action="saveStudent" modelAttribute="student" method="post">
    <form:hidden path="id"></form:hidden>
    NAME   <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    SURNAME   <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    AGE   <form:input path="age"/>
    <br><br>
    USERNAME   <form:input path="username"/>
    <br><br>
    Courses  <form:checkboxes path="courseList" items="${courses}"  />


    <br><br>
    <input class="button" type="submit" value="OK">
</form:form>
<a href="${pageContext.request.contextPath}/" >Back</a>
</body>
</html>
