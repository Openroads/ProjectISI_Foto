
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
	<h1>Zarejestruj się</h1>
 
	<form:form method="post"  modelAttribute="form"  action="addClient">
		imię: <form:input path="name" required="required"></form:input><br/>
		nazwisko: <form:input path="surname" required="required"></form:input><br/>
		adres: <form:input path="address" required="required"/><br/>
		pesel: <form:input  path="identityNumber" pattern="[0-9]{11}" required="required"/><br/>
		e-mail:<form:input type="email" path="email" required="required"/><br/>
		hasło: <form:input type="password" path="password" required="required"/><br/>
		powtorz hasło: <form:input type="password" path="password2" required="required"/><br/>
		podaj telefon: <form:input  path="phoneNumber" required="required"/><br/>
		
		
		
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>