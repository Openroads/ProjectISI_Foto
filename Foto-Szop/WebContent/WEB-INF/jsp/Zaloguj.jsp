
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Zaloguj się</h1>
 
	<form:form method="post"  modelAttribute="form"  action="login">
		email: <form:input path="email" required="required"></form:input><br/>
		haslo: <form:input path="password" required="required"></form:input><br/>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>