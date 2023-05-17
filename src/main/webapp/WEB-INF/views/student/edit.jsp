<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>

<h1>Edit Student</h1>
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<form:form action="update" modelAttribute="student">

    <label for="id">Id:</label>
    <form:input path="id" id="for" readonly="true"/>
    <form:errors path="id"/>

    <br><br>

    <label for="user.username">Username:</label>
    <form:input path="user.username" id="user.username" readonly="true"/>
    <form:errors path="user.username"/>

    <br><br>

    <label for="user.name">Name:</label>
    <form:input path="user.name" id="user.name"/>
    <form:errors path="user.name"/>

    <br><br>

    <label for="dob">Date Of Birth:</label>
    <form:input type="date" path="dob" id="dob"/>
    <form:errors path="dob"/>

    <br><br>


    <label for="department">Department:</label>
    <form:input path="department" id="department"/>
    <form:errors path="department"/>

    <br><br>

    <label for="semester">Semester:</label>
    <form:input type="number" path="semester" id="semester"/>
    <form:errors path="semester"/>

    <br><br>

    <label for="completed_credits">Completed Credits:</label>
    <form:input type="number" path="completed_credits" id="completed_credits"/>
    <form:errors path="completed_credits"/>

    <br><br>

    <label for="user.password">Password:</label>
    <form:input path="user.password" id="user.password"/>
    <form:errors path="user.password"/>

    <br><br>

    <input type="submit">

</form:form>

</body>
</html>
