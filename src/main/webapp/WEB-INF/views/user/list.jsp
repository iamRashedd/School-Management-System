<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body align="center" style="background-color:#6196cd; font-size:2vw;">

<h1 >Users</h1>

<input align="center" type="button" value="Add User" onclick="window.location.href='create';return false;">
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">

<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>

<table align="center" style="font-size:2vw;">
				<tr>
					<td>
						<fieldset>
							<legend><b>Users: </b></legend>
                            <table align="center"  border='1' cellpadding='4' width='100%' style="background-color:LightGrey;">

                                <thead>
                                <tr>

                                    <th>Id</th>
                                    <th>Username</th>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th>Authorized</th>
                                    <th colspan="4">Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <c:url var="updateLink" value="/users/edit">
                                            <c:param name="userId" value="${user.id}" />
                                        </c:url>
                                        <c:url var="deleteLink" value="/users/delete">
                                            <c:param name="userId" value="${user.id}" />
                                        </c:url>
                                        <c:url var="authorizeLink" value="/users/authorize">
                                            <c:param name="userId" value="${user.id}" />
                                        </c:url>
                                        <c:url var="unauthorizeLink" value="/users/unauthorize">
                                            <c:param name="userId" value="${user.id}" />
                                        </c:url>
                                        <td>${user.id}</td>
                                        <td>${user.username}</td>
                                        <td>${user.name}</td>
                                        <td>${user.userType}</td>
                                        <td>${user.enabled}</td>
                                        <td><a href="${authorizeLink}">Authorize</a> </td><td><a href="${unauthorizeLink}">Unauthorize</a> </td><td><a href="${updateLink}">Update</a> </td> <td> <a href="${deleteLink}">Delete</a></td>
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
