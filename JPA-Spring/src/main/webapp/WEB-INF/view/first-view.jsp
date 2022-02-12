<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>First Page</title>
    <style>
        <%@include file="style.css"%>
    </style>
</head>
<blockuuote>
<h2> Choose the information you want to know
</h2>
<br>
<br>
<blockquote>
<c:out value="Current user is: ${requestScope.principal.name}"/>
    </blockquote>
<br>
<br>
<a href="${pageContext.request.contextPath}/allStudents">Students</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/allTeachers">Teachers</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/allCourses">Courses</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/noahSmith">Info for Noah Smith</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/allStudentsOfMath">Math Course</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>

</html>