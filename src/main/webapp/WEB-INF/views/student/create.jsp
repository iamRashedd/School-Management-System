<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>

<h1>Create Student</h1>
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<form:form action="store" modelAttribute="studentDto">
    <label for="username">Username:</label>
    <form:input path="username" id="username"/>
    <form:errors path="username"/>

    <br><br>

    <label for="name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

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

    <label for="password">Password:</label>
    <form:input path="password" id="password"/>
    <form:errors path="password"/>

    <br><br>


    <input type="submit">

</form:form>

</body>
</html>
