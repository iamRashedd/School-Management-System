<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Teachers</title>
</head>
<body align="center" style="background-color:#6196cd; font-size:2vw;">

<h1>Teachers</h1>

<input type="button" value="Add Teacher" onclick="window.location.href='create';return false;">
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<table align="center" style="font-size:2vw;">
				<tr>
					<td>
						<fieldset>
							<legend><b>Teachers: </b></legend>
                            <table align="center"  border='1' cellpadding='4' width='100%' style="background-color:LightGrey;">
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Name</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <c:url var="updateLink" value="/teachers/edit">
                <c:param name="teacherId" value="${teacher.id}" />
            </c:url>
            <c:url var="deleteLink" value="/teachers/delete">
                <c:param name="teacherId" value="${teacher.id}" />
            </c:url>
            <td>${teacher.id}</td>
            <td>${teacher.user.username}</td>
            <td>${teacher.user.name}</td>
            <td>${teacher.department}</td>
            <td>${teacher.salary}</td>
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
