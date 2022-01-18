<%@page import="org.grigorovich.app.repositories.TeacherRepositoryJPA" %>
<%@page import="java.lang.String" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Average Teachers Salary</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<h2>Average salary of teachers:</h2>
<%
    String avgSalary = (String)request.getAttribute("avgSalary");
    out.println(avgSalary);
%>
<a href="${pageContext.request.contextPath}/allTeachers">Back</a>

</body>
</html>
