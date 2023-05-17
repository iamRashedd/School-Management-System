<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>

<h1>Edit Course</h1>
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<form:form action="update" modelAttribute="book">


    <label for="id">Id:</label>
    <form:input path="id" id="for" readonly="true"/>
    <form:errors path="id"/>

    <br><br>

    <label for="name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

    <label for="available_copy">Available Copy:</label>
    <form:input type="number" path="available_copy" id="available_copy"/>
    <form:errors path="available_copy"/>

    <br><br>



    <input type="submit">

</form:form>

</body>
</html>
