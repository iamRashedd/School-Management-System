<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Students</title>
</head>
<body align="center" style="background-color:#6196cd; font-size:2vw;">

<h1>Students</h1>

<input type="button" value="Add Student" onclick="window.location.href='create';return false;">
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<table align="center" style="font-size:2vw;">
        <tr>
            <td>
                <fieldset>
                    <legend><b>Students: </b></legend>
                    <table align="center"  border='1' cellpadding='4' width='100%' style="background-color:LightGrey;">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Username</th>
                            <th>Name</th>
                            <th>Department</th>
                            <th>Date of Birth</th>
                            <th>Semester</th>
                            <th>Completed Credits</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${students}" var="student">
                            <tr>
                                <c:url var="updateLink" value="/students/edit">
                                    <c:param name="studentId" value="${student.id}" />
                                </c:url>
                                <c:url var="deleteLink" value="/students/delete">
                                    <c:param name="studentId" value="${student.id}" />
                                </c:url>
                                <td>${student.id}</td>
                                <td>${student.user.username}</td>
                                <td>${student.user.name}</td>
                                <td>${student.department}</td>
                                <td>${student.dob}</td>
                                <td>${student.semester}</td>
                                <td>${student.completed_credits}</td>
                                <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </fieldset>
            </td>
        </tr>
</table>

</body>
</html>
