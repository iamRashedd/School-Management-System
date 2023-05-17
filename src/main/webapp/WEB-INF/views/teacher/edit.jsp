<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Teacher</title>
</head>
<body align="center">

<h1>Edit Teacher</h1>
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<form:form action="update" modelAttribute="teacherDto">
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
                                            <label for="username">Username:</label>
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
                                            <label for="name">Name:</label>
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
                                            <label for="department">Department:</label>
                                        </th>
                                        </td>
                                        <td>
                                            <form:input path="department" id="department"/>
                                        </td>
                                        <td>
                                            <form:errors path="department"/>
                                        </td>
                                    </tr>

                                    <tr>
                                        <th>
                                            <label for="salary">Salary:</label>
                                        </th>
                                        <td>
                                            <form:input path="salary" id="salary"/>
                                        </td>
                                        <td>
                                            <form:errors path="salary"/>
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
