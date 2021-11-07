<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Employees</title>
</head>
<body>

<table>
    <th>Name</th><th>Surname</th><th>Course</th>
    <c:forEach var="studentsMath" items="${requestScope.studentsMath}">
        <tr>
            <td><c:out value="${studentsMath.name}"/></td>
            <td><c:out value="${studentsMath.surname}"/></td>
            <c:set value="${studentsMath.courseList}" scope="page" var="course"/>
            <c:forEach items="${course}" var="cour">
                <td><c:out value="${cour.courseName}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
