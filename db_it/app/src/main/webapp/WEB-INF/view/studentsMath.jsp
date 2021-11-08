<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Math</title>
</head>
<body>

<table>
    <h3> сделала для одного предмета для остальных всё делается по аналогии</h3>
    <th>Name</th><th>Surname</th><th>Course</th><th>Grades</th>
    <c:forEach var="studentsMath" items="${requestScope.studentsMath}">
        <tr>
            <td><c:out value="${studentsMath.name}"/></td>
            <td><c:out value="${studentsMath.surname}"/></td>
            <c:set value="${studentsMath.courseList}" scope="page" var="course"/>
            <c:forEach items="${course}" var="cour">
                <td><c:out value="${cour.courseName}"/></td>
            </c:forEach>
            <c:set value="${studentsMath.gradeList}" scope="page" var="grades"/>
            <c:forEach items="${grades}" var="grad">
                <td><c:out value="${grad.grades}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<a href="<c:url value='/logout' />">Logout</a>
</body>
</html>
