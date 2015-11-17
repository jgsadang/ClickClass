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
       		<img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" />
		</div>
	</div>
	<div id="main">
		<c:if test="${course != null}">
		<div class="courseVideos">
			<h2>${course.title}</h2>
    		<div class="courseSmallBox">
				<!-- <a href="showCourse?id=${course.id}"> -->
				<img src="resources/CourseImages/${course.thumburl}" alt="view" />
				<!-- </a> -->
				<p>Rating</p>
   			</div>
   			<div class="courseDetails">
   				<label>${course.title}</label><p>by ${instructor.firstName} ${instructor.lastName}</p>
	    		<form method="post" action="${pageContext.request.contextPath}/payCourse">
	    			<label class="price">$${course.price}</label>
	    			<input type="hidden" name="id" value="${course.id}"/>
	    			<input value="Take this course" type="submit"/>
	    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    		</form> 
   				<label>About the course</label><p>${course.description}</p> 
	    	</div>
		</div>
		<br/>
		</c:if>
	</div>
</body>
</html>