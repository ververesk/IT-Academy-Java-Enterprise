<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student's surnames</title>
</head>

<body>

<div>
    <div>
        <div>
            <h2>Student's surnames</h2>
        </div>
        <%
        List<String> surnames = (List<String>) request.getAttribute("userSurnames");

        if (surnames != null && !surnames.isEmpty()) {
        out.println("<ui>");
            for (String s : surnames) {
            out.println("<li>" + s + "</li>");
            }
            out.println("</ui>");
        } else out.println("<p>There are no users yet!</p>");
        %>
    </div>
</div>
<a href="HomePage">Home Page</a>

</body>
</html>