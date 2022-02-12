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


<c:forEach var="st" items="${requestScope.students}">
        <tr>
            <td>
                <a href="updateStudent?id=${st.id}">Edit</a>
            </td>
            <td>
                <a href="deleteStudent?id=${st.id}">Delete</a>
            </td>
            <td>"${st.id}"</td>
            <td>"${st.name}"</td>
            <td>"${st.surname}"</td>
            <td>"${st.age}"</td>
            <td>"${st.username}"</td>
            <c:set value="${st.courseList}" scope="page" var="courseList"/>
            <c:forEach items="${courseList}" var="course">
                <td><c:out value="${empty course ? '---' : course.courseName}"/></td>
            </c:forEach>

        </tr>
    </c:forEach>
</table>
<a href="createStudent" >Create Student</a>
<br>
<br>
<jsp:include page="homePage.jsp" />
</body>
</html>
