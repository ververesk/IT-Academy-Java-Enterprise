<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Students</title>
</head>
<body>
<h2>All Students </h2>
<br>
    <table border="1" cellpadding="5" cellspacing="1" >
        <tr>
            <th>edit</th>
            <th>delete</th>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>age</th>
            <th>username</th>
            <th>courses</th>
            <th>courses</th>
            <th>courses</th>
    </tr>
    <c:forEach  var="st" items="${allSt}">
        <c:url var="updateButton" value="/updateStudent">
            <c:param name="stId" value="${st.id}"/>

        </c:url>
        <c:url var="deleteButton" value="/deleteStudent">
            <c:param name="stId" value="${st.id}"/>

        </c:url>
        <tr>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">
            </td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>
            <td>${st.id}</td>
            <td>${st.name}</td>
            <td>${st.surname}</td>
            <td>${st.age}</td>
            <td>${st.username}</td>
            <c:set value="${st.courseList}" scope="page" var="courseList"/>
            <c:forEach items="${courseList}" var="course">
                <td><c:out value="${empty course ? '---' : course.courseName}"/></td>
            </c:forEach>

        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="add"
       onclick="window.location.href='addNewStudent'"/>



</body>
</html>
