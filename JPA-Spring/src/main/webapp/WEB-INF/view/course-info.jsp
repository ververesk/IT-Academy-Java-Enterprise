<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course info</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<h2>Course info</h2>
<form:form action="saveCourse" modelAttribute="course" method="post">
    <form:hidden path="courseId"></form:hidden>
    NAME   <form:input path="courseName"/>
    <form:errors path="courseName"/>
    <br><br>
    <input class="button" type="submit" value="OK">
</form:form>
<br><br>
<a href="${pageContext.request.contextPath}/" >Back</a>
</body>
</html>
