<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher info</title>
</head>
<body>
<h2>Teacher info</h2>
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

    <input type="submit" value="OK">
</form:form>

</body>
</html>