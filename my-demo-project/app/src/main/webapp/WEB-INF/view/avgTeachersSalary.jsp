<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.demo.calc.Calculator" %>
<html>
<head>
    <title>average teacher's salary</title>
</head>

<body>

<div>
    <div>
        <div>
            <h2>average teacher's salary</h2>
        </div>
        <%
        List<Double> avgSalary = (List<Double>) request.getAttribute("teacherSalary");

        if (avgSalary != null && !avgSalary.isEmpty()) {
            out.println("<li>" + Calculator.averageSalaryOfTeachers(avgSalary) + "</li>");
            out.println("условных единиц");
        } else out.println("<p>There are no teachers yet!</p>");
        %>
    </div>
</div>
<br>
<a href="HomePage">Home Page</a>
</body>
</html>