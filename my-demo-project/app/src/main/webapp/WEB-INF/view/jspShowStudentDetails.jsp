<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/xhtml">
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
        <li $(group) </li>
    </c:forEach>
</ul>
</body>
</html>