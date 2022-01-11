<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course info</title>
</head>
<body>
<h2>Course info</h2>
<form:form action="saveCourse" modelAttribute="course" method="post">
    <form:hidden path="courseId"></form:hidden>
    NAME   <form:input path="courseName"/>
    <form:errors path="courseName"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>
