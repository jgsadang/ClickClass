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
	  	<sf:form method="post" action="${pageContext.request.contextPath}/submitPayment" commandName="creditCard" class="form-horizontal" role="form">
		<fieldset>
			<legend>Payment</legend>
			<div class="form-group">
				<label class="control-label col-sm-2">Name on card:</label>
				<div class="col-sm-10">
				<sf:input name="nameOnCard" path="nameOnCard" type="text" size="20" maxlength="20"/> <sf:errors path="nameOnCard" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-2">CC Number:</label>
				<div class="col-sm-10">
				<sf:input name="nameOnCard" path="nameOnCard" type="text" size="20" maxlength="20"/> <sf:errors path="nameOnCard" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Expire Month:</label>
				<div class="col-sm-10">
				<sf:input name="expireMonth" path="expireMonth"  type="text" size="20" maxlength="20"/><sf:errors path="expireMonth" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Expire Year:</label>
				<div class="col-sm-10">
				<sf:input name="expireYear" path="expireYear"  type="text" size="20" maxlength="20"/><sf:errors path="expireYear" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">CVV</label>
				<div class="col-sm-10">
				<sf:input name="cvv" path="cvv"  type="text" size="20" maxlength="20"/><sf:errors path="cvv" cssClass="error"></sf:errors><br/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input value="Submit Payment" type="submit"/>
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</fieldset>
		</sf:form>
	</section>
	</div>
</body>
</html>