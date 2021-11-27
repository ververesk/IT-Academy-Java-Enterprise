<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum Salary</title>
</head>
<body>
<p>Sum salary of teachers:</p>
<%
    Long sumSalary = (Long)request.getAttribute("sumSalaries");
    out.println(sumSalary);
%>
<a href="teacherList" >Back</a>
</body>
</html>