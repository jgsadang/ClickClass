<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
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
		<div class="menuLeft">
			<form id="search" method="post" action="${pageContext.request.contextPath}/doSearch">
				<label>Course:</label> <input name="searchKey" type="text" size="20" maxlength="20"/> <input value="Search" type="submit"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
		<div class="menuRight">
       		<a href=" <spring:url value="/logout" />" ><abbr title="Logout"><img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" /></abbr> </a>
       		<a href=" <spring:url value="/login" />" ><abbr title="Login"><img class="profileLogo" src="resources/images/profile.jpg" alt="login" /></abbr></a>
       		<a href=" <spring:url value="/studentSignUp" />" ><abbr title="Register"><img class="registerLogo" src="resources/images/register.jpg" alt="register" /></abbr> </a>
       		<a href=" <spring:url value="/instructorSignUp" />" ><abbr title="Become Instructor"><img class="instructorLogo" src="resources/images/instructor.png" alt="become instructor" /></abbr> </a>
		</div>
	</div>
	<div id="main">
		<c:if test="${courses.size() > 0}">
		<div class="courseVideos">
		<h2>Courses</h2>
		<c:forEach var="course" items="${courses}">
    		<div class="courseBox">
				<a href="showCourse?id=${course.id}">
				<img src="resources/CourseImages/${course.thumburl}" alt="view" />
				</a>
	    		<label>${course.title}</label><br/>
	    		<label>$${course.price}</label>
	    		<div class="rating">
	    			<c:forEach begin="1" end="5" varStatus="loop">
						<c:if test="${course.rating == loop.count}">
							<input name="${course.id}" type="radio" class="star" disabled="disabled" checked="checked"/>
						</c:if>
						<c:if test="${course.rating != loop.count}">
							<input name="${course.id}" type="radio" class="star" disabled="disabled"/>
						</c:if>
					</c:forEach>
				</div>
   			</div>
		</c:forEach>
		</div>
		<br/>
		</c:if>
	</div>
</body>
</html>