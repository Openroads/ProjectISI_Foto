<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>Foto-Szop | Dodawanie pracownika</title>
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
<header><!--header-start-->
</header><!--header-end-->


<nav class="main-nav-outer" id="test"><!--main-nav-start-->
	<div class="container">
        <ul class="main-nav">
        	<li><a href="${contextPath}/managerReturn">Powrót</a></li>
            <li class="small-logo"><a href="#header"><img src="<c:url value="/resources/img/small-logo.png"/>"></a></li>		
        </ul>
        <a class="res-nav_click" href="#"><i class="fa-bars"></i></a>
    </div>
</nav><!--main-nav-end-->



<section class="main-section" id="oferta"><!--main-section-start-->
	<div class="container">
    	<h2>Dodawanie pracownika</h2>
        <div class="row">
        	<div class="col-lg-4 col-sm-6 wow fadeInLeft delay-05s">
            	<div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-user"></i>
                    </div>
                	<div class="service-list-col2">
                	 <div class="form">
                        <form:form method="post"  modelAttribute="AddEmpDTO" id="add-emp-form"  action="addEmployee" >							
                        	Imię: <form:input class="input-text" path="name" id="name-form" ></form:input>
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="iname"></div><br>
							Nazwisko: <form:input class="input-text" path="surname" id="surname-form" ></form:input>		
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="surname" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="isurname"></div><br>
							PESEL: <form:input class="input-text"  path="identityNumber" id="identity-number"/>
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="identityNumber" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="iidentity-number"></div><br>
							E-mail:<form:input class="input-text" type="email" path="email" id="email" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="email" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="iemail"></div><br>
							Hasło: <form:input class="input-text" type="password" path="password" id="password" />
	                     	<c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" 	 cssStyle="color: #ff0000;"/></c:if>
	                     	<div id="ipassword"></div><br>
	                     	Powtorz hasło: <form:input class="input-text"  type="password" id="password2" path="password2" />
                           <c:if test="${pageContext.request.method=='POST'}"> <form:errors path="password2" 	 cssStyle="color: #ff0000;"/></c:if>
                            <div id="ipassword2"></div><br>
                                Numer telefonu komórkowego: <form:input class="input-text" path="phoneNumber" id="phone-number" />
                               <c:if test="${pageContext.request.method=='POST'}"><form:errors path="phoneNumber" 	 cssStyle="color: #ff0000;"/></c:if>
                                <div id="iphone"></div><br>
                                <div style="text-align:center;">
                     		
                     		<input type="submit" id="submit" class="input-btn" value="Rejestruj">         
               			       </div>
				</form:form>
                    </div>
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-file"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>REGULAMIN</h3>
                        <p><a style="color: green;" href="#">Czytaj></a></p>
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-star"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>REKLAMA</h3>
                        <p><a style="color: green;" href="#">Czytaj></a></p>
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-envelope"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>RABATY</h3>
                        <p><a style="color: green;" href="#">Czytaj></a></p>
                    </div>
                </div>
            </div>
            <figure class="col-lg-8 col-sm-6  text-right wow fadeInUp delay-02s">
            	<img src="<c:url value="/resources/img/register.jpg"/>">
            </figure>
        
        </div>
	</div>
</section><!--main-section-end-->

</div>
<footer class="footer">
    <div class="container">
        <div class="footer-logo"><a href="#"><img src="<c:url value="/resources/img/footer-logo.png"/>"></a></div>
        <span class="copyright">Copyright © 2017 | <a href="#">Foto-szop</a></span>
    </div>
</footer>


<script type="text/javascript">
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


<script type="text/javascript">
	$(window).load(function(){
		
		$('.main-nav li a').bind('click',function(event){
			var $anchor = $(this);
			
			$('html, body').stop().animate({
				scrollTop: $($anchor.attr('href')).offset().top - 102
			}, 1500,'easeInOutExpo');
			/*
			if you don't want to use the easing effects:
			$('html, body').stop().animate({
				scrollTop: $($anchor.attr('href')).offset().top
			}, 1000);
			*/
			event.preventDefault();
		});
	})
</script>

<script type="text/javascript">

$(window).load(function(){
  
  
  var $container = $('.portfolioContainer'),
      $body = $('body'),
      colW = 375,
      columns = null;

  
  $container.isotope({
    // disable window resizing
    resizable: true,
    masonry: {
      columnWidth: colW
    }
  });
  
  $(window).smartresize(function(){
    // check if columns has changed
    var currentColumns = Math.floor( ( $body.width() -30 ) / colW );
    if ( currentColumns !== columns ) {
      // set new column count
      columns = currentColumns;
      // apply width to container manually, then trigger relayout
      $container.width( columns * colW )
        .isotope('reLayout');
    }
    
  }).smartresize(); // trigger resize to set container width
  $('.portfolioFilter a').click(function(){
        $('.portfolioFilter .current').removeClass('current');
        $(this).addClass('current');
 
        var selector = $(this).attr('data-filter');
        $container.isotope({
			
            filter: selector,
         });
         return false;
    });
  
});

</script>
</body>
</html>