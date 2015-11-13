<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
<title>Course Site</title>

</head>
<body>
	<div id="banner">
		<img src="resources/images/movielogo.png" alt="Spring Courses" />
	</div>
	<div id="main">
	<h2><a href="${pageContext.request.contextPath}/courses">Show courses</a></h2>
	<h2><a href="${pageContext.request.contextPath}/searchcourses">Search courses</a></h2>
	<h2><a href="${pageContext.request.contextPath}/addcourse">Add course</a></h2>
	<h2><a href="${pageContext.request.contextPath}/deletecourses">Delete courses</a></h2>
	<h2><a href="${pageContext.request.contextPath}/adduser">Add user</a></h2>
	<h2><a href="${pageContext.request.contextPath}/users">Show users</a></h2>
	</div>
</body>
</html>