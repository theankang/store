<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add team page</title>
</head>
<body>
<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/add/process.html">
<table>
<tbody>
    <tr>
        <td>Name:</td>
        <td><form:input path="name"></form:input></td>
    </tr>
    <tr>
        <td>Rating:</td>
        <td><form:input path="rating"></form:input></td>
    </tr>
    <tr>
        <td><input value="Add" type="submit"></td>
        <td></td>
    </tr>
</tbody>
</table>
</form:form>
 
<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>