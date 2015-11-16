<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content=
"text/html; charset=ISO-8859-1">

<title>Login</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
<script src="resources/script/myfile.js" type="text/javascript"></script>

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
       		<img class="logoutLogo" src="resources/images/logout.jpg" alt="logout" />
       		<img class="profileLogo" src="resources/images/profile.jpg" alt="login" />
       		<img class="registerLogo" src="resources/images/register.jpg" alt="register" />
		</div>
	</div>
	<div id="main">
 <div class="container">
				<c:if test="${not empty error}">
<div class="alert alert-danger"  >
${error}<br />
</div>
</c:if>
</div> 
		
<section class="container2">
<form action="<c:url value="/j_spring_security_check"></c:url>"  class="form-horizontal" method="post">
<fieldset class="fs">
	<legend>LogIn</legend>

<div class="form-group">
<label class="control-label col-lg-2" for="firstName">UserName:</label>
<div class="col-lg-10">
<input class="form:input-large" placeholder="User Name" name='j_username' type="text">
</div>
</div>

<div class="form-group">
<label class="control-label col-lg-2" for="firstName">Password:</label>
<div class="col-lg-10">
<input class="form:input-large" placeholder="Password" name='j_password' type="password" value="">
</div>
</div>

<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="LogIn"/>
					</div>
				</div>	
			</fieldset>
	</form>
	</section>
	</div>
</body>
</html>