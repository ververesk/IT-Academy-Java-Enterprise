<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher's names</title>
</head>

<body>

<div>
    <div>
        <div>
            <h2>Teacher's names</h2>
        </div>
        <%
        List<String> names = (List<String>) request.getAttribute("userNames");

        if (names != null && !names.isEmpty()) {
        out.println("<ui>");
            for (String s : names) {
            out.println("<li>" + s + "</li>");
            }
            out.println("</ui>");
        } else out.println("<p>There are no users yet!</p>");
        %>
    </div>
</div>
<a href="avgTeachersSalary">View the average salary of teachers</a>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>

</body>
</html>