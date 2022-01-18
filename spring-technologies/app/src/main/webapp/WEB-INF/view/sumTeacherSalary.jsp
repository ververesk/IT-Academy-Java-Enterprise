
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum salary of teachers</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<body>
<H2>Sum salary of teachers:</H2>
<%
    Long sumSalary = (Long)request.getAttribute("sumSalaries");
    out.println(sumSalary);
%>
<br>
<br>
<a href="${pageContext.request.contextPath}/allTeachers">Back</a>
</body>
</html>
