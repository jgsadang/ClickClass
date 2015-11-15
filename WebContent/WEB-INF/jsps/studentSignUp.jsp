<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/script/myfile.js" type="text/javascript"></script>
</head>

<body>
<body>
	<div id="banner">
		<img src="resources/images/cclogo.png" alt="ClickClass" />
	</div>
	<div id="menu">
		<div class="menuLeft">
			<form id="search" method="post"
				action="${pageContext.request.contextPath}/doSearch">
				<label>Course:</label> <input name="searchKey" type="text" size="20"
					maxlength="20" /> <input value="Search" type="submit" /> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
		<div class="menuRight">
			<img class="logoutLogo" src="resources/images/logout.jpg"
				alt="logout" /> <img class="profileLogo"
				src="resources/images/profile.jpg" alt="login" /> <img
				class="registerLogo" src="resources/images/register.jpg"
				alt="register" />
		</div>
	</div>
	<div id="main">
		<section class="container"> <form:form
			modelAttribute="student" class="form-horizontal" method="POST"
			enctype="utf8">
			<fieldset>
				<legend>New Student</legend>

				<%-- <form:errors path="*" cssClass="alert alert-danger" element="div"/> --%>

				<div class="form-group">
					<label class="control-label col-lg-2" for="username">User
						Name:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="username"
							path="user.username" value="" />
						<%-- <form:errors path="user.username" cssClass="text-danger" />  --%>
					</div>
				</div>

				<div class="form-group">

					<label class="control-label col-lg-2" for="password">Password:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="password"
							path="user.password" value="" type="password" />
						<%-- <form:errors path="password" cssClass="text-danger" /> --%>
					</div>
				</div>



				<div class="form-group">
					<label class="control-label col-sm-2" for="firstName">First
						Name:</label>
					<div class="col-sm-10">
						<form:input class="form:input-large" id="firstName"
							path="firstName" value="" />
						<%-- <form:errors path="firstName" cssClass="text-danger"/> --%>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last
						Name:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="lastName" path="lastName"
							value="" />
						<%-- <form:errors path="lastName" cssClass="text-danger" /> --%>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="email">Email:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="email" path="email"
							value="" />
						<%-- <form:errors path="email" cssClass="text-danger" />   --%>

					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country">Country:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="country"
							path="address.country" value="" type="text" />
						<%-- <form:errors path="address.country" cssClass="text-danger" />  --%>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="state">State:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="state"
							path="address.state" value="" type="text" />
						<%-- <form:errors path="address.street" cssClass="text-danger" />  --%>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="city">City:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="city" path="address.city"
							value="" type="text" />
						<%-- <form:errors path="address.city" cssClass="text-danger" />  --%>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="street">Street:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="street"
							path="address.street" value="" type="text" />
						<%-- <form:errors path="address.street" cssClass="text-danger" />  --%>
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="zipcode">Zip
						Code:</label>
					<div class="col-lg-10">
						<form:input class="form:input-large" id="zipcode"
							path="address.zipcode" value="" type="text" />
						<%-- <form:errors path="address.zipcode" cssClass="text-danger" />  --%>
					</div>
				</div>

				<!-- <label class="control-label col-lg-2" for="authority">Role</label> -->
				<form:hidden path="user.authority.authority" value="student" />
				<%-- <form:errors path="credentials.authority" cssClass="text-danger"/> --%>

				<%-- <form:hidden path="credentials.enabled" value="TRUE" /> --%>




				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Register" />
					</div>
				</div>

			</fieldset>
		</form:form> </section>
	</div>
</body>


</html>