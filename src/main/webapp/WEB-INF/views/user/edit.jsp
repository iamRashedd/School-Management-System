<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body align="center">

<h1>Edit User</h1>
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>

<form:form action="update" modelAttribute="userDto">
            <table align="center" style="font-size:2vw;">
				<tr>
					<td>
						<fieldset>
							<legend><b>Users: </b></legend>
                            <table align="center"  border='1' cellpadding='4' width='100%' style="background-color:LightGrey;">

                                <tr>
                                    <th>
                                        <label for="id">Id:</label>
                                    </th>
                                    <td>
                                        <form:input path="id" id="for" readonly="true"/>
                                    </td>
                                    <td>
                                        <form:errors path="id"/>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <label for="username">Name:</label>
                                    </th>
                                    <td>
                                        <form:input path="username" id="username" readonly="true"/>
                                    </td>
                                    <td>
                                        <form:errors path="username"/>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <label for="name">Full Name:</label>
                                    </th>
                                    <td>
                                        <form:input path="name" id="name"/>
                                    </td>
                                    <td>
                                        <form:errors path="name"/>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <label for="enabled">Full Name:</label>
                                    </th>
                                    <td>

                                        <form:select path="enabled" id="enabled">

                                            <option value="${1}">True</option>
                                            <option value="${0}">False</option>
                                        </form:select>
                                    </td>
                                    <td>
                                        <form:errors path="enabled"/>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <label for="createdOn">Created On:</label>
                                    </th>
                                    <td>
                                        <form:input type="date" path="createdOn" id="createdOn" readonly="true"/>
                                    </td>
                                    <td>
                                        <form:errors path="createdOn"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="userType">User Type:</label>
                                    </th>
                                    <td>
                                        <form:input path="userType" id="userType" readonly="true"/>
                                    </td>
                                    <td>
                                        <form:errors path="userType"/>
                                    </td>
                                </tr>

                                <tr>
                                    <th>
                                        <label for="password">Password:</label>
                                    </th>
                                    <td>
                                        <form:input path="password" id="password"/>
                                    </td>
                                    <td>
                                        <form:errors path="password"/>
                                    </td>
                                </tr>

                                <tr>
                                    <th></th>
                                    <td></td>
                                    <td>
                                        <input type="submit">
                                    </td>
                                </tr>
                             </table>
						</fieldset>
					</td>
				</tr>
			</table>
</form:form>

</body>
</html>
