<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Home page</h1>
<p>
${message}
<a href="${pageContext.request.contextPath}/team/add.html">Add new team</a>
<a href="${pageContext.request.contextPath}/team/list.html">Team list</a>
</p>
</body>
</html>
