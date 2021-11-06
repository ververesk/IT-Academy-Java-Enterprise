<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h3>Students</h3>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>age</th>

    </tr>


<c:forEach var="st" items="${requestScope.students}">
        <tr>
            <td>"${st.name}"</td>
            <td>"${st.surname}"</td>
            <td>"${st.age}"</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
