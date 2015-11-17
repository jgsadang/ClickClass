<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css"/>
<script src='https://jquery-star-rating-plugin.googlecode.com/svn/trunk/jquery.js' type="text/javascript"></script>
<script src='https://jquery-star-rating-plugin.googlecode.com/svn/trunk/jquery.MetaData.js' type="text/javascript" language="javascript"></script>
<script src='https://jquery-star-rating-plugin.googlecode.com/svn/trunk/jquery.rating.js' type="text/javascript" language="javascript"></script>
<link href='https://jquery-star-rating-plugin.googlecode.com/svn/trunk/jquery.rating.css' type="text/css" rel="stylesheet"/>
<script src="resources/script/myfile.js" type="text/javascript"></script>
<title>Click Class</title>

</head>
<body>
	<div id="banner">
		<img src="resources/images/cclogo.png" alt="ClickClass"/>
	</div>
		<div id="menu">
		<div class="menuRight">
		<sec:authorize access="hasRole('ROLE_INSTRUCTOR')" >
		<a href="${pageContext.request.contextPath}/myCourses">View Courses</a>
		<a href="#">  |  </a>
		<a href="${pageContext.request.contextPath}/addCourse">Upload Course</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_STUDENT')" >
		    <a href="${pageContext.request.contextPath}/studentCourses">Registered Courses </a>
		 </sec:authorize>
		 <sec:authorize access="hasRole('ROLE_ADMIN')" >
		    <a href="${pageContext.request.contextPath}/pendingCourses">Pending Courses </a>
		 </sec:authorize>
		 <h> <strong>Hi ${user.firstName}</strong></h>
			<a href="${pageContext.request.contextPath}/"><img class="homeLogo" src="resources/images/home.jpg" alt="home" /></a>
       		<a href="${pageContext.request.contextPath}/logout"><img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" /></a>
		</div>
	</div>
	<div >
		<c:if test="${course != null}">
			<h2 class="boxRate">${course.title}</h2><br/>
			<div id="viddeoPlayer">
				<video width="480" height="360"  controls>
	  				<source src="resources/CourseVideos/${course.video}" type="video/mp4"  >  					
					Your browser does not support the video tag.
				</video>
			</div>
			<form method="post" action="${pageContext.request.contextPath}/submitRating">
				<div class="boxRate">
					Rate this course: 
					<div class="ratingButton"><input value="submit" type="submit"/></div>
					<div class="rating1">
		    			<c:forEach begin="1" end="5" varStatus="loop">
							<c:if test="${attendance.rating == loop.count}">
								<input name="userRating" type="radio" class="star" value="${loop.count}" checked="checked"/>
							</c:if>
							<c:if test="${attendance.rating != loop.count}">
								<input name="userRating" type="radio" class="star" value="${loop.count}"/>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<input name="id" value="${course.id}" type="hidden"/>
			</form>
		</c:if>
	</div>
</body>
</html>