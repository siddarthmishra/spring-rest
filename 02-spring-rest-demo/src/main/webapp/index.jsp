<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome - Spring REST Demo</h1>
	<hr>
	<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
	<hr>
	<a href="${pageContext.request.contextPath}/api/students">Get All Students</a>
</body>
</html>