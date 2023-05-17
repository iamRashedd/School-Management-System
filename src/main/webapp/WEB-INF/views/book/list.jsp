<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body align="center" style="background-color:#6196cd; font-size:2vw;">

<h1>Books</h1>

<input type="button" value="Add Book" onclick="window.location.href='create';return false;">
<input align="center" type="button" value="Home" onclick="window.location.href='/school/';return false;">
<h5 align="right">
User: ${profile.name}<br>
Type: ${profile.userType}
</h5>
<table align="center" style="font-size:2vw;">
				<tr>
					<td>
						<fieldset>
							<legend><b>Books: </b></legend>
                            <table align="center"  border='1' cellpadding='4' width='100%' style="background-color:LightGrey;">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Available Copy</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <c:url var="updateLink" value="/books/edit">
                <c:param name="bookId" value="${book.id}" />
            </c:url>
            <c:url var="deleteLink" value="/books/delete">
                <c:param name="bookId" value="${book.id}" />
            </c:url>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.available_copy}</td>
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
