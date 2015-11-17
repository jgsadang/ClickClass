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
       		<a href="${pageContext.request.contextPath}/logout"><img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" /> </a>
		</div>
	</div>
	<div id="main">
	<c:forEach var="at" items="${stCourses}">
		<c:if test="${at != null}">
		<div class="courseVideos">
			<h2>${at.course.title}</h2>
    		<div class="courseSmallBox">
				<!-- <a href="showCourse?id=${course.id}"> -->
				<img src="resources/CourseImages/${at.course.thumburl}" alt="view" />
				<!-- </a> -->
				<p>Rating</p>
   			</div>
   			<div class="courseDetails">
   				<label>${at.course.title}</label><p>by ${at.course.instructor.firstName} ${at.course.instructor.lastName}</p>
	    		<form method="post" action="${pageContext.request.contextPath}/viewCourse">
	    			<label class="price">$${at.course.price}</label>
	    			<input type="hidden" name="id" value="${at.course.id}"/>
	    			<input value="View" type="submit"/>
	    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    		</form> 
   				<label>About the course</label><p>${at.course.description}</p> 
	    	</div>
		</div>
		<br/>
		</c:if>
		</c:forEach>
	</div>
</body>
</html>