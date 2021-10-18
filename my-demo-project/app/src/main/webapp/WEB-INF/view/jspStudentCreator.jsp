<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<body xmlns:form="http://www.w3.org/1999/xhtml">
<h2> Please, create Student</h2>
<br>
<br>
<form:form action="showStudentDetails" modelAttribute="student">

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Age <form:input path="age"/>
    <form:errors path="age"/>
    <br>
    <br>
    Group(s)
    <form:checkboxes path="groups" items="${student.groupsList}"/>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
<a href="HomePage">Home Page</a>
</body>
</html>