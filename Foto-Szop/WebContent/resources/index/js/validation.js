$(document).ready(function(){
	
	
	$('#name-form').on('blur', function(){
		var input = $(this);
		var name_length = input.val().length;
		
		if(name_length > 2 && name_length <= 20){
			input.next('#iname').text("Wprowadzono poprawną nazwę.").removeClass("error").addClass("ok");
		}else{
			input.next('#iname').text("Nazwa musi mieć więcej niż 2 znaki i mniej niż 20 znaków!").removeClass("ok").addClass("error");
		}
	});
	
	$('#surname-form').on('blur', function(){
		var input = $(this);
		var name_length = input.val().length;
		
		if(name_length > 2 && name_length <= 20){
			input.next('#isurname').text("Wprowadzono poprawną nazwę.").removeClass("error").addClass("ok");
		}else{
			input.next('#isurname').text("Nazwisko musi mieć więcej niż 2 znaki i mniej niż 20 znaków!").removeClass("ok").addClass("error");
		}
	});
	
	
	$('#email').on('blur', function() {
		var input = $(this);
		var pattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		var is_email = pattern.test(input.val());
		if(is_email){			
			input.next('#iemail').text("Wprowadzono poprawny email.").removeClass("error").addClass("ok");
		}
		else{
			input.next('#iemail').text("Wprowadź poprawny email!").removeClass("ok").addClass("error");
		}
	});	
	
	
	$('#identity-number').on('blur', function(){
		var input = $(this);
		var identity = input.val();
		
		if(/^[0-9]{11}$/.test(+identity)){
			input.next('#iidentity-number').text("Wprowadzono poprawny pesel.").removeClass("error").addClass("ok");
		}else{
			input.next('#iidentity-number').text("Pesel posiada 11 znaków!").removeClass("ok").addClass("error");
		}
	});
	
	
	$('#address-form').on('blur', function() {
		var input = $(this);
		var message = $(this).val().length;
		if(message>10){
			input.next('#iaddress').text("Wprowadzono poprawny adres.").removeClass("error").addClass("ok");
		}
		else{
			input.next('#iaddress').text("Adres nie może być pusty!").removeClass("ok").addClass("error");
		}   
	});
	
	$('#password').on('blur', function() {
		var input = $(this);
		var password = $(this).val().length;
		if(password>5 && password<25){
			input.next('#ipassword').text("Wprowadzono poprawne hasło.").removeClass("error").addClass("ok");
		}
		else{
			input.next('#ipassword').text("Hasło musi posiadać nie mniej niż 6 znaków i nie więcej niż 24.").removeClass("ok").addClass("error");
		}   
	});
	
	$('#password2').on('blur', function() {
		var input = $(this);
		var password2 = $(this).val();
		var password2LEN= $(this).val().length;
		var password1 = $('#password').val();
		console.log(password1);
		console.log(password2);
		if((password1==password2) && (password2LEN>5 && password2LEN<25) ){
			input.next('#ipassword2').text("Hasła się zgadzają.").removeClass("error").addClass("ok");
		}
		else{
			input.next('#ipassword2').text("Hasła muszą się zgadzać oraz posiadać zadaną długość!").removeClass("ok").addClass("error");
		}   
	});
	
	$('#phone-number').on('blur', function(){
		var input = $(this);
		var identity = input.val();
		
		if(/^[0-9]{9}$/.test(+identity)){
			input.next('#iphone').text("Wprowadzono poprawny numer.").removeClass("error").addClass("ok");
		}else{
			input.next('#iphone').text("Numer telefonu komórkowego posiada 9 znaków!").removeClass("ok").addClass("error");
		}
	});
	
	
	$('#submit').click(function(event){
		
		var password = $('#ipassword');
		var password2 = $('#ipassword2');
		var phonenumber = $('#iphone');
		var identity = $('#iidentity-number');
		var surname = $('#isurname');
		var name = $('#iname');
		var email = $('#iemail');
		var address = $('#iaddress');
		
		
		if(password.hasClass("ok")
	   && password2.hasClass("ok")
	   && phonenumber.hasClass("ok")
	   && identity.hasClass("ok")
	   && surname.hasClass("ok")
	   && name.hasClass("ok")
	   && email.hasClass("ok")
	   && address.hasClass("ok")		
		){
			console.log("OK");
		}
		else {
			event.preventDefault();
			alert("Uzupełnij wszystkie pola!");	
		}
	});
	
});




		
	
	
