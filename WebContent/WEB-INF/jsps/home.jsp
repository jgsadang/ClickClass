<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
<script src="resources/script/myfile.js" type="text/javascript"></script>
<title>Click Class</title>

</head>
<body>
	<div id="banner">
		<img src="resources/images/cclogo.png" alt="ClickClass"/>
	</div>
		<div id="menu">
		<div class="menuLeft">
			<form id="search" method="post" action="${pageContext.request.contextPath}/doSearch">
				<label>Course:</label> <input name="searchKey" type="text" size="20" maxlength="20"/> <input value="Search" type="submit"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
		<div class="menuRight">
       		<a href=" <spring:url value="/logout" />" ><img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" /> </a>
       		<a href=" <spring:url value="/login" />" ><img class="profileLogo" src="resources/images/profile.jpg" alt="login" /></a>
       		<a href=" <spring:url value="/studentSignUp" />" ><img class="registerLogo" src="resources/images/register.jpg" alt="register" /> </a>
		</div>
	</div>
	<div id="main">
		<!-- Add web content here -->
	</div>
</body>
</html>