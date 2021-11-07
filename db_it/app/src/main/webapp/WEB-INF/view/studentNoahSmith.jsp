<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Noah Smith</title>
</head>
<body>

<table>
    <h3> сделала для одного студента для остальных всё делается по аналогии</h3>
    <th>Name</th><th>Surname</th><th>Course</th><th>Grades</th>
    <c:forEach var="noahSmith" items="${requestScope.noahSmith}">
        <tr>
            <td><c:out value="${noahSmith.name}"/></td>
            <td><c:out value="${noahSmith.surname}"/></td>
            <c:set value="${noahSmith.courseList}" scope="page" var="course"/>
            <c:forEach items="${course}" var="cour">
                <td><c:out value="${cour.courseName}"/></td>
            </c:forEach>
            <c:set value="${noahSmith.gradeList}" scope="page" var="grades"/>
            <c:forEach items="${grades}" var="grad">
                <td><c:out value="${grad.grades}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>