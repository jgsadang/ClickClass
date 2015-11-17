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
			<a href="${pageContext.request.contextPath}/logout"><img class="homeLogo" src="resources/images/home.jpg" alt="home" /></a>
       		<img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" />
		</div>
	</div>
	<div id="main">
	<section class="container">
		<!-- Add web content here -->
	  	<sf:form method="post" action="${pageContext.request.contextPath}/addCourse?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" commandName="course" class="form-horizontal" role="form">
		<fieldset>
			<legend>New Course</legend>
			<div class="form-group">
				<label class="control-label col-sm-2">Title:</label>
				<div class="col-sm-10">
				<sf:input name="title" path="title" type="text" size="20" maxlength="20"/> <sf:errors path="title" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-2">Category:</label>
				<div class="col-sm-10">
				<sf:select name="category" path="category">
					<c:forEach var="category" items="${categories}">
	    				<option>${category}</option>
					</c:forEach>
				</sf:select><sf:errors path="category" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Price:</label>
				<div class="col-sm-10">
				<sf:input name="price" path="price"  type="text" size="20" maxlength="20"/><sf:errors path="price" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Course Image:</label>
				<div class="col-sm-10">
				<input type="file" name="file"><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Course video:</label>
				<div class="col-sm-10">
				<input type="file" name="file"><br/>	
				</div>
			</div>	
			<div class="form-group">
				<label class="control-label col-sm-2">Description:</label>
				<div class="col-sm-10">
				<sf:textarea name="description" path="description"  cols="100" rows="8"/><sf:errors path="description" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input value="Add Course" type="submit"/>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</fieldset>
		</sf:form>
	</section>
	</div>
</body>
</html>