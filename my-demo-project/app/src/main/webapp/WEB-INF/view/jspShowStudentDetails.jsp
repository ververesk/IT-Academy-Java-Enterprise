<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>
<h2> information about student</h2>
<br>
<br>

name: ${student.name}
<br>
surname: ${student.surname}
<br>
age: ${student.age}
<br>
Group(s):
<ul>
    <c:forEach var="group" items="${student.groups}">
        <li <c:out value="${group}"/> </li>
    </c:forEach>
</ul>
<br>
<a href="listStudent">View a list of student's surnames</a>
<br>
<a href="StudentCreator">Add one more student</a>
<br>
<a href="homePage">Home Page</a>
</body>
</html>