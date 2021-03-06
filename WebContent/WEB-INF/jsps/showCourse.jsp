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
	<div id="main">
		<c:if test="${course != null}">
		<div class="courseVideos">
			<h2>${course.title}</h2>
    		<div class="courseSmallBox">
				<!-- <a href="showCourse?id=${course.id}"> -->
				<img src="resources/CourseImages/${course.thumburl}" alt="view" />
				<!-- </a> -->
				<div class="rating">
	    			<c:forEach begin="1" end="5" varStatus="loop">
						<c:if test="${course.rating == loop.count}">
							<input name="star3" type="radio" class="star" disabled="disabled" checked="checked"/>
						</c:if>
						<c:if test="${course.rating != loop.count}">
							<input name="star3" type="radio" class="star" disabled="disabled"/>
						</c:if>
					</c:forEach>
				</div>
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
		<section class="container">
		<h3>Comments</h3>
			<c:forEach var="comment" items="${comments}">
	    		<div class="comment"><label class="username">${comment.username}</label> ${comment.text}</div>
			</c:forEach>
		<hr>
		<c:if test="${student != null}">
		<form method="post" action="${pageContext.request.contextPath}/addComment">
			<fieldset>
				<input type="hidden" name="id" value="${course.id}"/>
				<legend>Add Comments</legend>
				<div class="form-group">
					<label class="control-label col-sm-2">Comment:</label>
					<div class="col-sm-10">
						<textarea name="comment" cols="50" rows="6"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<br/>
						<input value="Submit" type="submit"/>
					</div>
				</div>
			</fieldset>
			<input type="hidden" name="page" value="showCourse"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		</c:if>
		</section>
		<br/>
		</c:if>
	</div>
</body>
</html>