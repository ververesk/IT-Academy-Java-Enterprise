

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Avg Salary</title>
</head>
<body>
<p>Average salary of teachers:</p>
<%
    String avgSalary = (String)request.getAttribute("avgSalary");
    out.println(avgSalary);
%>
<a href="teacherList" >Back</a>
</body>
</html>
