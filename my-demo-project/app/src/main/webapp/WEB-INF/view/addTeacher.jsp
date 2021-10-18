<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>

<body>
    <%
    if (request.getAttribute("userSurname") != null) {
    out.println("<p>User '" + request.getAttribute("userSurname") + "' added!</p>");
    }
    %>
</body>
</html>