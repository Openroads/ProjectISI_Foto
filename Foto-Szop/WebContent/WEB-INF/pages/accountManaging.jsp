<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
<spring:url value="resources/css/style.css" var="style"/>
<spring:url value="resources/css/font-awesome.css" var="font"/>
<spring:url value="resources/css/responsive.css" var="responsive"/>
<spring:url value="resources/css/animate.css" var="animate"/>
<spring:url value="resources/js/jquery.1.8.3.min.js" var="jquery"/>
<spring:url value="resources/js/bootstrap.js" var="boot"/>
<spring:url value="resources/js/jquery-scrolltofixed.js" var="scroll"/>
<spring:url value="resources/js/jquery.easing.1.3.js" var="easing"/>
<spring:url value="resources/js/jquery.isotope.js" var="isotope"/>
<spring:url value="resources/js/wow.js" var="wow"/>
<spring:url value="resources/js/classie.js" var="classie"/>
<spring:url value="resources/index/js/respond-1.1.0.min.js" var="respond"/>
<spring:url value="resources/index/js/html5shiv.js" var="html5shiv"/>
<spring:url value="resources/index/js/html5element.js" var="html5element"/>
<spring:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700" var="font1"/>
<spring:url value="http://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600" var="font2"/>
<spring:url value="resources/favicon.png" var="favicon"/>

<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, maximum-scale=1">	
		<title>Foto-Szop | Zarzadzanie kontami</title>
		<link rel="icon" href="${favicon}">	
		<link href="${font1}" rel="stylesheet">
		<link href="${font2}" rel="stylesheet">
		<link href="${bootstrap}" rel="stylesheet"/>
		<link href="${style}" rel="stylesheet"/>
		<link href="${font}" rel="stylesheet"/>
		<link href="${responsive}" rel="stylesheet"/>
		<link href="${animate}" rel="stylesheet"/>
		<script src="${jquery}"></script>
		<script src="${boot}"></script>
		<script src="${scroll}"></script>
		<script src="${easing}"></script>
		<script src="${isotope}"></script>
		<script src="${wow}"></script>
		<script src="${classie}"></script>
		<script src="${validation}"></script>
		<!--[if lt IE 9]>
		<script src="${respond}"></script>
		<script src="${html5shiv}"></script>
		<script src="${html5element}></script>
		<![endif]-->
	</head>
	<body>
	<!--main-nav-start-->
	<nav class="main-nav-outer" id="test">
		<div class="container">
	        <ul class="main-nav">
	        	<li><a href="${contextPath}/managerReturn">Powrót</a></li>
	            <li class="small-logo"><a href="#header"><img src="<c:url value="/resources/img/small-logo.png"/>"></a></li>		
	        </ul>
	        <a class="res-nav_click" href="#"><i class="fa-bars"></i></a>
	    </div>
	</nav>
	<!--main-nav-end-->
	<div class="col-lg-4 col-lg-offset-4 wow animated fadeInDown delay-09s">
		<br><br>
	    <h2>Zarządzanie kontami</h2>
		<h3 style="text-align: center;" class="wow animated fadeInDown delay-07s">Konta możliwe do edycji:</h3>
		<table class="table table-hover table-hovered" style="text-align: center;">
			<thead>
				<tr>
				   <th style="text-align:center;">ID</th>
				   <th style="text-align:center;">Login</th>
				   <th style="text-align:center;">Data modyfikacji</th>
				</tr>
			<thead>
			<tbody>
				<c:forEach items="${accList}" var="acc" varStatus="status">
				  <tr class="success">
				      <td id="email">
				          <c:out value="${acc.accountId}"/>
				      </td>
				
				      <td id="name">
				          <c:out value="${acc.login}"/>
				      </td>
				                            
				      <td id="surname">
				           <c:out value="${acc.creationDate}"/>
				       </td>
					<td id="operacja">
				           <button onClick="getDetailsAboutAccount(${acc.accountId})" >Edytuj</button>
				     </td>
				  </tr>
			</c:forEach>
			</tbody>
			 </table>
    </div>
	<!--main-section-start-->
	<section class="main-section" id="oferta">
		<div class="container">
	        <div class="row">
	        	<div class="col-lg-4 col-sm-6 wow fadeInLeft delay-05s">
	            	<div class="service-list">
	                	<div class="service-list-col1">
	                    	<i class="fa-user"></i>
	                    </div>
	                	<div class="service-list-col2">
	                	 <div class="form">
	                        <form:form method="post"  modelAttribute="ManagerEditFormDTO" id="edit-acc-form"  action="editAccount" >	
	                        <br/><br/>	
	                        		<div id="addressDiv"> Adres: <form:input class="input-text" path="address" id="address-form"/>
	                                <div id="iaddress"></div> </div>

	                                Imię: <form:input class="input-text" path="name" id="name-form" ></form:input>
									<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="name" cssStyle="color: #ff0000;"/></c:if>
									<div id="iname"></div><br>
									
									Nazwisko: <form:input class="input-text" path="surname" id="surname-form" ></form:input>		
									<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="surname" cssStyle="color: #ff0000;"/></c:if>
									<div id="isurname"></div><br>
									
									PESEL: <form:input class="input-text"  path="identityNumber" id="identity-number"/>
									<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="identityNumber" cssStyle="color: #ff0000;"/></c:if>
									<div id="iidentity-number"></div><br>
									
									E-mail:<form:input class="input-text" disabled="true" type="email" path="email" id="email-form" />
									<c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="email" cssStyle="color: #ff0000;"/></c:if>
									<div id="iemail"></div><br>
									
									Hasło: <form:input class="input-text" type="password" path="password" id="password" autocomplete="on"/>
			                     	<c:if test="${pageContext.request.method=='POST'}">
			                     	<form:errors path="password" cssStyle="color: #ff0000;"/></c:if>
			                     	<div id="ipassword"></div><br>
			                     	
			                     	Powtorz hasło: <form:input class="input-text" autocomplete="on" type="password" id="password2" path="password2" />
		                           <c:if test="${pageContext.request.method=='POST'}"> 
		                           <form:errors path="password2" cssStyle="color: #ff0000;" /></c:if>
		                           <div id="ipassword2"></div><br>
		                            
	                                Numer Telefonu Komórkowego: <form:input class="input-text" path="phoneNumber" id="phone-number"/>
	                                <div id="iphone"></div> <br>
	                                <c:if test="${pageContext.request.method=='POST'}">
									<form:errors path="phoneNumber" cssStyle="color: #ff0000;"/></c:if>
	                                <div style="text-align:center;">
	                                    <input type="submit" id="submit" class="input-btn" value="edit">
	                                </div>  
	                                
	                                 <form:input type="hidden" id="personType" path="personType" />                     
							</form:form>
	                    </div>
	                    </div>
	                </div>
	            </div>
	            <figure class="col-lg-8 col-sm-6  text-right wow fadeInUp delay-02s">
	            	<img src="<c:url value="/resources/img/edit.png"/>">
	            </figure>
	        </div>
		</div>
	</section>
	<!--main-section-end-->
	<footer class="footer">
	    <div class="container">
	        <div class="footer-logo"><a href="#"><img src="<c:url value="/resources/img/footer-logo.png"/>"></a></div>
	        <span class="copyright">Copyright © 2017 | <a href="#">Foto-szop</a></span>
	    </div>
	</footer>
	
	<!-- Scripts -->

	<script>
	    $(document).ready(function(e) {
	        $('#test').scrollToFixed();
	        $('.res-nav_click').click(function(){
	            $('.main-nav').slideToggle();
	            return false    
	            
	        });
	        
	    });
	</script>
	
	<script>
	    wow = new WOW(
	      {
	        animateClass: 'animated',
	        offset:       100
	      }
	    );
	    wow.init();
	 
	</script>
	
	<script>
		$(window).load(function(){
			
			$('.main-nav li a').bind('click',function(event){
				var $anchor = $(this);
				
				$('html, body').stop().animate({
					scrollTop: $($anchor.attr('href')).offset().top - 102
				}, 1500,'easeInOutExpo');
				event.preventDefault();
			});
		})
		
		
		/************* AJAX FUNCTIONS **********/
		function getDetailsAboutAccount(accountId){
		        if (window.XMLHttpRequest) {
		            requester = new XMLHttpRequest();
		       } else if (window.ActiveXObject) {
		            requester = new ActiveXObject("Microsoft.XMLHTTP");
		       }
		  
		        requester.onreadystatechange = getAccountDetailsHandler;
		        requester.open("GET","http://localhost:8080/Foto-Szop/rest/account/"+accountId+"/withPerson");
		        requester.send(null); 
		    }
		
		function getAccountDetailsHandler(){
			if(this.readyState == 4 && this.status == 200){
		        var accountAndPerson = JSON.parse(this.responseText);
		        console.log(accountAndPerson);
		        if(accountAndPerson.person.type==='EMP'){
		       		document.getElementById("addressDiv").style.visibility = 'hidden';
		        }else if(accountAndPerson.person.type==='CLIENT'){
		        	document.getElementById("addressDiv").style.visibility = 'visible';
		        	document.getElementById("address-form").value=accountAndPerson.person.address;
		        }
		        document.getElementById("name-form").value=accountAndPerson.person.name;
		        document.getElementById("surname-form").value=accountAndPerson.person.surname;
		        document.getElementById("identity-number").value=accountAndPerson.person.identityNumber;
		        document.getElementById("email-form").value=accountAndPerson.person.email;
		        document.getElementById("phone-number").value=accountAndPerson.person.phoneNumber;
		        document.getElementById("personType").value=accountAndPerson.person.type;
		        
		     }        
			
		}
	</script>

	</body>
</html>