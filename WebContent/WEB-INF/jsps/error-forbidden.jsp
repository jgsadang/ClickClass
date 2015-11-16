<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<% response.setStatus(403); %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>403 error</title>
  </head>
  <body>

<center>

<img src="<spring:url value="/resources/images/error_page.jpg"  htmlEscape="true" />" alt="Page not found  JSP!!!"  />

<H2>${requestScope['javax.servlet.error.message']}</H2>
 
 <div class="container">
			<p>
				<a href="<spring:url value="/" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> Home
				</a>
			</p>
		</div>
</center> 
  </body>
</html>