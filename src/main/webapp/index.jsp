<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>School Management System</title>
</head>
<body align="center" style="background-color:#6196cd; font-size:2vw;">
<h1 align="center">School Management System</h1>
<input align="center" type="button" value="Logout" onclick="window.location.href='/school/logout';return false;">
<h3 align="right"> ${profile.name}${profile.userType}</h3>
<table align="center">
    <tr>
        <td>
            <fieldset>
                <legend align="left">Admin</legend>

                <table>
                    <tr>
                        <th>
                        <input align="center" type="button" value="Users" onclick="window.location.href='${pageContext.request.contextPath}/users/list';return false;">
                        </th><th>
                        <input align="center" type="button" value="Teachers" onclick="window.location.href='${pageContext.request.contextPath}/teachers/list';return false;">
                        </th><th>
                        <input align="center" type="button" value="Students" onclick="window.location.href='${pageContext.request.contextPath}/students/list';return false;">
                        </th><th>
                        <input align="center" type="button" value="Courses" onclick="window.location.href='${pageContext.request.contextPath}/courses/list';return false;">
                        </th><th>
                        <input align="center" type="button" value="Books" onclick="window.location.href='${pageContext.request.contextPath}/books/list';return false;">
                        </th>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</table>

<br>
<table align="center">
    <tr>
        <td>
            <fieldset>
                <legend align="left">Teacher</legend>

                <table>
                    <tr>
                        <th>
                        <input align="center" type="button" value="Students" onclick="window.location.href='${pageContext.request.contextPath}/students/list';return false;">
                        </th><th>
                        <input align="center" type="button" value="Courses" onclick="window.location.href='${pageContext.request.contextPath}/courses/listByTeacher';return false;">
                        </th><th>
                        <input align="center" type="button" value="Books" onclick="window.location.href='${pageContext.request.contextPath}/books/list';return false;">
                        </th>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</table>

<br>
<table align="center">
    <tr>
        <td>
            <fieldset>
                <legend align="left">Student</legend>

                <table>
                    <tr>
                        <th>

                        <input align="center" type="button" value="Courses" onclick="window.location.href='${pageContext.request.contextPath}/courses/listByStudent';return false;">
                        </th><th>
                        <input align="center" type="button" value="Payments" onclick="window.location.href='${pageContext.request.contextPath}/payments/list';return false;">
                        </th><th>
                        <input align="center" type="button" value="Books" onclick="window.location.href='${pageContext.request.contextPath}/books/list';return false;">
                        </th>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</table>


</body>
</html>