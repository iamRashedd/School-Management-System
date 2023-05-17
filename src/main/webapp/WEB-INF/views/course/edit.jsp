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
<form:form action="update" modelAttribute="course">


    <label for="id">Id:</label>
    <form:input path="id" id="for" readonly="true"/>
    <form:errors path="id"/>

    <br><br>

    <label for="name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>

    <br><br>

    <label for="start_time">Start Time:</label>
    <form:input type="date" path="start_time" id="start_time"/>
    <form:errors path="start_time"/>

    <br><br>

    <label for="finish_time">Finish Time:</label>
    <form:input type="date" path="finish_time" id="finish_time"/>
    <form:errors path="finish_time"/>

    <br><br>

    <form:select path="teacher">
        <c:forEach items="${teachers}" var="teacher">
            <form:option value="${teacher.id}" label="${teacher.user.name}" />
        </c:forEach>
    </form:select>

    <br><br>

    <input type="submit">

</form:form>

</body>
</html>
