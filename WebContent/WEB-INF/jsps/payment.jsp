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
		<section class="container">
		<!-- Add web content here -->
	  	<form method="post" action="${pageContext.request.contextPath}/submitPayment" class="form-horizontal" role="form">
		<fieldset>
			<legend>Payment: $${course.price} for ${course.title}</legend>
			<div class="form-group">
				<label class="control-label col-sm-2">Name on card:</label>
				<div class="col-sm-10">
				<input name="nameOnCard" type="text" size="20" maxlength="20" value="${student.firstName} ${student.lastName}"/> <br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Card type:</label>
				<div class="col-sm-10">
				<select name="type">
					<option>mastercard</option>
					<option>visa</option>
				</select>
				<br/>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-2">CC Number:</label>
				<div class="col-sm-10">
				<input name="ccNo" type="text" size="20" maxlength="20" value="${creditCard.ccNo}"/> <br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Expire Month:</label>
				<div class="col-sm-10">
				<input name="expireMonth" type="text" size="20" maxlength="20" value="${creditCard.expireMonth}"/><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Expire Year:</label>
				<div class="col-sm-10">
				<input name="expireYear" type="text" size="20" maxlength="20" value="${creditCard.expireYear}"/><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">CVV</label>
				<div class="col-sm-10">
				<input name="cvv"type="text" size="20" maxlength="20" value="${creditCard.cvv}"/><br/>
				</div>
			</div>
			<!-- Address -->
			<br/>
			<div class="form-group">
				<label class="control-label col-sm-2">Street:</label>
				<div class="col-sm-10">
				<input name="street" type="text" size="20" maxlength="20" value="${address.street}"/> <br/>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-2">Zip Code:</label>
				<div class="col-sm-10">
				<input name="zipcode" type="text" size="20" maxlength="20" value="${address.zipcode}"/><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">City:</label>
				<div class="col-sm-10">
				<input name="city" type="text" size="20" maxlength="20" value="${address.city}"/><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">State:</label>
				<div class="col-sm-10">
				<input name="state" type="text" size="20" maxlength="20" value="${address.state}"/><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Country:</label>
				<div class="col-sm-10">
				<input name="country" type="text" size="20" maxlength="20" value="${address.country}"/><br/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input value="Submit Payment" type="submit"/>
				</div>
			</div>
			<input type="hidden" name="id" value="${course.id}"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</fieldset>
		</form>
	</section>
	</div>
</body>
</html>