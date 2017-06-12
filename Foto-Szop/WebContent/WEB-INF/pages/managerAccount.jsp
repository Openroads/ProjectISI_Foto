<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


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

<title>Foto-Szop | Konto</title>
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

<!--[if lt IE 9]>
    <script src="${respond}"></script>
    <script src="${html5shiv}"></script>
    <script src="${html5element}></script>
<![endif]-->


</head>
<body>

<nav class="main-nav-outer" id="test"><!--main-nav-start-->
	<div class="container">
        <ul class="main-nav">
        
   			<li><a href="${contextPath}/#" >Edycja Strony</a></li>
   			<li><a href="${contextPath}/employeeAdding" >Dodaj Pracownika</a></li>
            
            <li class="small-logo"><a href="#header"><img src="<c:url value="/resources/img/small-logo.png"/>"></a></li>
			<li><a href="#">Historia</a></li>
			<li><a href="logout">Wyloguj</a></li>	
        </ul>
        <a class="res-nav_click" href="#"><i class="fa-bars"></i></a>
    </div>
</nav><!--main-nav-end-->




<section class="main-section" id="konto"><!--main-section-start-->
	<div class="container">
    	<h2>Witamy w panelu managera</h2>
    	<h6>Tutaj znajdziesz informacje o swoim koncie</h6>
        <div class="row">
        	   <figure class="col-lg-8 col-sm-6  text-right wow fadeInUp delay-02s">
        	   <br>
        	   <br>
        	   <br>
            	<img src="<c:url value="/resources/img/photographer.png"/>">
            </figure>
        	<div class="col-lg-4 col-sm-6 wow fadeInLeft delay-05s">
            	<div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-user"></i>
                    </div>
                	<div class="service-list-col2">
                	
                        <p class="client-part-haead wow fadeInDown delay-05 caption" style="color : black;">${manager.getName()}</p>
                        <p class="client-part-haead wow fadeInDown delay-05 caption" style="color : black;">${manager.getSurname()}</p>
                        
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-info"></i>
                    </div>
                	<div class="service-list-col2">
                	
                     <p class="client-part-haead wow fadeInDown delay-05" style="color : black;">${manager.getIdentityNumber()}</p>
                 
                    </div>
                </div>
                
                
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-phone"></i>
                    </div>
                	<div class="service-list-col2">
                        
                       <p class="client-part-haead wow fadeInDown delay-05" style="color : black;">${manager.getPhoneNumber()}</p>
                   
                    </div>
                </div>
                
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-envelope"></i>
                    </div>
                	<div class="service-list-col2">
                        
                       <p class="client-part-haead wow fadeInDown delay-05 caption" style="color : black;">${manager.getEmail()}</p>
                   
                    </div>
                </div>
                
                
            </div>
         
        
        </div>
	</div>
</section><!--main-section-end-->


<section class="main-section client-part" id="zamowienia"><!--main-section client-part-start-->
	<div class="container">
		<b class="user wow fadeInDown delay-03"><i class="fa-camera"></i></b>
    	<div class="row">
        	<div class="col-lg-12">
            	<p class="client-part-haead wow fadeInDown delay-05">Historia płatnosci</p>
            </div>
        </div>
    	  <a class="link animated fadeInUp delay-1s" href="${contextPath}/#">Wejdź</a>
    </div>
</section><!--main-section client-part-end-->
<br>



<div class="c-logo-part" ><!--c-logo-part-start-->
	<div class="container" >
    	<ul>
        	<li><a href="#"><img src="<c:url value="/resources/img/c-liogo1.png"/>"></a></li>
            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo2.png"/>"></a></li>
            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo3.png"/>"></a></li>
            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo4.png"/>"></a></li>
            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo5.png"/>"></a></li>
    	</ul>
	</div>
</div><!--c-logo-part-end-->


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