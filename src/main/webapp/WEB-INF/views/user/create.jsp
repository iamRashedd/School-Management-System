<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create User</title>
</head>
<body align="center">

<h1 align="center">Create User</h1>
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<table align="center">
				<tr>
					<td>
						<fieldset>
							<legend><b>Create user: </b></legend>
<form:form action="store" modelAttribute="user">

    <table align="center">
    <tr>
    <th>
    <label for="username">Username </th><td>:</td></label>
    <td>
    <form:input path="username" id="username"/>
    </td><td>
    <form:errors path="username"/>
    </td>
    </tr>


    <tr>
    <th>
    <label for="name">Full Name</th><td>:</td></label>
    <td>
    <form:input path="name" id="name"/>
    </td><td>
    <form:errors path="name"/>
    </td>
    </tr>



    <tr>
    <th>
    <label for="password">Password </th><td>:</td></label>
    <td>
    <form:input path="password" id="password"/>
    </td><td>
    <form:errors path="password"/>
    </td>
    </tr>


    <tr>
    <th></th><td></td><td>
    <input type="submit">
    </td>
</table>


						</fieldset>
					</td>
				</tr>
			</table>

</form:form>

</body>
</html>
