<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<body>
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
    EN <form:checkbox path="groups" value="English"/>
    MATH <form:checkbox path="groups" value="Math"/>
    CS <form:checkbox path="groups" value="Computer Science"/>
    JEE <form:checkbox path="groups" value="JavaEE"/>
    SPRING <form:checkbox path="groups" value="Spring"/>
    DB <form:checkbox path="groups" value="Data Base"/>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>