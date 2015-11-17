<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/script/myfile.js" type="text/javascript"></script>
<title>Click Class</title>

</head>
<body>
	<div id="banner">
		<img src="resources/images/cclogo.png" alt="ClickClass" />
	</div>
	<div id="menu">
		<div class="menuRight">
			<sec:authorize access="hasRole('ROLE_INSTRUCTOR')">
				<a href="${pageContext.request.contextPath}/myCourses">View
					Courses</a>
				<a href="#"> | </a>
				<a href="${pageContext.request.contextPath}/addCourse">Upload
					Course</a>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${pageContext.request.contextPath}/pendingCourses">Pending
					Courses </a>
			</sec:authorize>
			<%--  <h> <strong>Hi ${user.firstName}</strong></h> --%>
			<h> <strong>HI <%=session.getAttribute("user")%>
			</strong></h>
			<a href="${pageContext.request.contextPath}/"><img
				class="homeLogo" src="resources/images/home.jpg" alt="home" /></a> <a
				href="${pageContext.request.contextPath}/logout"><img
				class="logoutLogo" src="resources/images/logout.jpg" alt="logout" />
			</a>
		</div>
	</div>
	<div id="main">
		<section class="container">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}<br />
				</div>
			</c:if>
			<c:if test="${not empty noCourse}">
				<div class="alert alert-success">
					${noCourse}<br />
				</div>
			</c:if>

			<c:if test="${Courses != null}">
				<div class="courseVideos">
					<c:forEach var="course" items="${Courses}">
						<h2>${course.title}</h2>
						<div class="courseSmallBox">
							<!-- <a href="showCourse?id=${course.id}"> -->
							<img src="resources/CourseImages/${course.thumburl}" alt="view" />
							<!-- </a> -->
							<p>Rating</p>
						</div>
						<div class="courseDetails">
							<label>${course.title}</label>
							<p>by ${course.instructor.firstName}
								${course.instructor.lastName}</p>
							<form>
								<label class="price">$${course.price}</label> <input
									type="hidden" name="id" value="${course.id}" />
							</form>
							<label>About the course</label>
							<p>${course.description}</p>
							<p>
								<strong>Status :</strong><span class="label label-warning">
									${course.status}</span>
							</p>
							<sec:authorize access="hasRole('ROLE_INSTRUCTOR')">
								<a
									href="${pageContext.request.contextPath}/editCourse?id=${course.id}"
									class="btn btn-default"> <span
									class="glyphicon-hand-right glyphicon"></span> EDIT
								</a>
								<a
									href="${pageContext.request.contextPath}/deleteCourse?id=${course.id}"
									class="btn btn-default"> <span
									class="glyphicon-hand-right glyphicon"></span>DELETE
								</a>
							</sec:authorize>

							<sec:authorize access="hasRole('ROLE_ADMIN')">

								<a
									href="${pageContext.request.contextPath}/approveCourse?id=${course.id}"
									class="btn btn-default"> <span
									class="glyphicon-hand-right glyphicon"></span> APPROVE
								</a>
								<a
									href="${pageContext.request.contextPath}/disapproveCourse?id=${course.id}"
									class="btn btn-default"> <span
									class="glyphicon-hand-right glyphicon"></span> DISAPPROVE
								</a>


							</sec:authorize>
						</div>
					</c:forEach>
				</div>
				<br />
			</c:if>
		</section>
	</div>
</body>
</html>