<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<body>
<h2> Please, create Teacher</h2>
<br>
<br>
<form:form action="showTeacherDetails" modelAttribute="teacher">

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
    Salary <form:input path="salary"/>
    <br>
    <br>
    Group <form:select path="group">
    <form:option value="English" label="EN"/>
    <form:option value="Math" label="MATH"/>
    <form:option value="Computer Science" label="CS"/>
    <form:option value="JavaEE" label="JEE"/>
    <form:option value="Spring" label="SPRING"/>
    <form:option value="Data Base" label="DB"/>
</form:select>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>