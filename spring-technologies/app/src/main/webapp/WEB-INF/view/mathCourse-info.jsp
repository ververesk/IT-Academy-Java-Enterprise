<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Math-course info</title>
</head>
<body>
<h2>Math-course info</h2>
<form:form action="saveMathCourse" modelAttribute="mathCourse" method="post">
    <form:hidden path="id"></form:hidden>
    Grades   <form:input path="grades"/>
    <form:errors path="grades"/>
    <br><br>
    <form:hidden path="studentName"></form:hidden>

    <br><br>
    <input class="button" type="submit" value="OK">
</form:form>

</body>
</html>
