<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Courses</title>
</head>
<body align="center" style="background-color:#6196cd; font-size:2vw;">

<h1>Courses</h1>

<input type="button" value="Add Course" onclick="window.location.href='create';return false;">
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<table align="center" style="font-size:2vw;">
				<tr>
					<td>
						<fieldset>
							<legend><b>Courses: </b></legend>
                            <table align="center"  border='1' cellpadding='4' width='100%' style="background-color:LightGrey;">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Start Time</th>
        <th>Finish Time</th>
        <th>Teacher</th>

        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <c:url var="updateLink" value="/courses/edit">
                <c:param name="courseId" value="${course.id}" />
            </c:url>
            <c:url var="deleteLink" value="/courses/delete">
                <c:param name="courseId" value="${course.id}" />
            </c:url>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.start_time}</td>
            <td>${course.finish_time}</td>
            <td>${course.teacher.user.name}</td>
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
