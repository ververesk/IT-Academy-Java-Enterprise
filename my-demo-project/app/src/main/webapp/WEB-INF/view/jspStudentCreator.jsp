<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/xhtml">
<body>
<h2> Please, create Student</h2>
<br>
<br>
<form:form action="WEB-INF/view/jspShowStudentDetails.jsp" modelAttribute="student">

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Salary <form:input path="age"/>
    <form:errors path="age"/>
    <br>
    <br>
    Group(s)
    <form:checkboxes path="languages" items="${student.groupList}"/>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>