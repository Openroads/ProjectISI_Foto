
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Page | Fotoszop</title>
</head>
<body>
	<h1>Edytuj konto</h1>
 	<h2>Jeśli nie chcesz edytować danego pola to pozostaw puste.</h2>
	<form:form method="post"  modelAttribute="editForm"  action="editClient">
		imię: <form:input path="name" required="required"></form:input><br/>
		nazwisko: <form:input path="surname" required="required"></form:input><br/>
		adres: <form:input path="address" required="required"/><br/>
		pesel: <form:input  path="identityNumber" pattern="[0-9]{11}" required="required"/><br/>
		hasło: <form:input type="password" path="password" required="required"/><br/>
		powtorz hasło: <form:input type="password" path="password2" required="required"/><br/>
		podaj telefon: <form:input  path="phoneNumber" required="required"/><br/>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>