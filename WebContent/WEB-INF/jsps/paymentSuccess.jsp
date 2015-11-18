<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
<script src="resources/script/myfile.js" type="text/javascript"></script>
<title>Click Class</title>

</head>
<body>
	<div id="banner">
		<img src="resources/images/cclogo.png" alt="ClickClass"/>
	</div>
		<div id="menu">
		<div class="menuRight">
			<a href="${pageContext.request.contextPath}/"><img class="homeLogo" src="resources/images/home.jpg" alt="home" /></a>
       		<a href="${pageContext.request.contextPath}/logout"><img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" /></a>
		</div>
	</div>
	<div id="main">
		<section class="container">
		<h2>Payment Successful.</h2>
		<c:if test="${not empty createdPayment}">
			<h4>Created payment with id = ${createdPayment.id} and status = ${createdPayment.state}</h4>
		</c:if>
		<h4>Thank you for subscribing to the course..</h4>
	    <form method="post" action="${pageContext.request.contextPath}/viewCourse">
   			<input type="hidden" name="id" value="${course.id}"/>
   			<input value="View my course" type="submit"/>
   			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   		</form> 
   		</section>
	</div>
</body>
</html>