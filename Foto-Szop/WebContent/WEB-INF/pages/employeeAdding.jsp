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
<spring:url value="resources/js/validation.js" var="validation"/>

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
        	<li><a href="${contextPath}/index">Powrót</a></li>
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
                        <form:form method="post"  modelAttribute="form" id="register-form"  action="addClient">	
							Imię: <form:input class="input-text" path="name" id="name-form" ></form:input>
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="iname"></div><br>
							Nazwisko: <form:input class="input-text" path="surname" id="surname-form" ></form:input>		
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="surname" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="isurname"></div><br>
							Adres: <form:input class="input-text" path="address" id="address-form" />
							<c:if test="${pageContext.request.method=='POST'}"><form:errors path="address" 	 cssStyle="color: #ff0000;"/></c:if>
							<div id="iaddress"></div><br>
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
                     		<label><input type="checkbox" class="input-text"  required id="rules"/>Akceptuję regulamin</label>
                     		<label><input type="checkbox" class="input-text"  value="adv" id="adv"/>Chcę otrzymywać reklamy.</label>
                     		<label><input type="checkbox" class="input-text"  value="promo" id="promo"/>Chcę otrzymywać rabaty.</label>
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






<section class="business-talking"><!--business-talking-start-->
	<div class="container">
        <h2>Klik i robisz co chcesz!</h2>
    </div>
</section><!--business-talking-end-->
<div class="container">
<section class="main-section contact" id="kontakt">
	<h2>Zespół</h2>
        <h6>Oto nasz zespół. Poznajmy się!</h6>
        <div class="team-leader-block clearfix">
            <div class="team-leader-box">
                <div class="team-leader wow fadeInDown delay-03s"> 
                    <div class="team-leader-shadow"><a href="#"></a></div>
                    <img src="<c:url value="/resources/img/team-leader-pic1.jpg"/>">
                    <ul>
                        <li><a href="#" class="fa-twitter"></a></li>
                        <li><a href="#" class="fa-facebook"></a></li>
                        <li><a href="#" class="fa-pinterest"></a></li>
                        <li><a href="#" class="fa-google-plus"></a></li>
                    </ul>
                </div>
                <h3 class="wow fadeInDown delay-03s">Dariusz Szyszlak</h3>
                <span class="wow fadeInDown delay-03s">Scrum Master</span>
                <p class="wow fadeInDown delay-03s">Coś tam kodzi, marudzi że mu nie działa bo ma linuksa. Głowa zespołu myśli za trzech, robi za dwóch, krzyczy za czternastu. Takich dwóch jak on jeden to żaden.</p>
            </div>
            <div class="team-leader-box">
                <div class="team-leader  wow fadeInDown delay-06s"> 
                    <div class="team-leader-shadow"><a href="#"></a></div>
                    <img src="<c:url value="/resources/img/team-leader-pic2.jpg"/>">
                    <ul>
                        <li><a href="#" class="fa-twitter"></a></li>
                        <li><a href="#" class="fa-facebook"></a></li>
                        <li><a href="#" class="fa-pinterest"></a></li>
                        <li><a href="#" class="fa-google-plus"></a></li>
                    </ul>
                </div>
                <h3 class="wow fadeInDown delay-06s">Tomasz Mazur</h3>
                <span class="wow fadeInDown delay-06s">Programmer</span>
                <p class="wow fadeInDown delay-06s">Tomek na siłkę gna po szkole, łapie mole, polityków zna nie mało, rozmawia o nich śmiało. Takich  przygód jak Tomek to nawet najstarsi Indianie nie przeżyli.</p>
            </div>
            <div class="team-leader-box">
                <div class="team-leader wow fadeInDown delay-09s"> 
                    <div class="team-leader-shadow"><a href="#"></a></div>
                    <img src="<c:url value="/resources/img/team-leader-pic3.jpg"/>">
                    <ul>
                        <li><a href="#" class="fa-twitter"></a></li>
                        <li><a href="#" class="fa-facebook"></a></li>
                        <li><a href="#" class="fa-pinterest"></a></li>
                        <li><a href="#" class="fa-google-plus"></a></li>
                    </ul>
                </div>
                <h3 class="wow fadeInDown delay-09s">Szymon Matysik</h3>
                <span class="wow fadeInDown delay-09s">Programmer</span>
                <p class="wow fadeInDown delay-09s">Ten to tylko by na frontendzie siedział, czasem coś skodzi ale to tak żeby strona wyświetlała się w postaci błędów, najczęściej 404. Wie że dzwoni ale w którym pliku?</p>
            </div>
			<div class="team-leader-box">
                <div class="team-leader wow fadeInDown delay-09s"> 
                    <div class="team-leader-shadow"><a href="#"></a></div>
                    <img src="<c:url value="/resources/img/team-leader-pic4.jpg"/>">
                    <ul>
                        <li><a href="#" class="fa-twitter"></a></li>
                        <li><a href="#" class="fa-facebook"></a></li>
                        <li><a href="#" class="fa-pinterest"></a></li>
                        <li><a href="#" class="fa-google-plus"></a></li>
                    </ul>
                </div>
                <h3 class="wow fadeInDown delay-09s">Mariusz Grochowski</h3>
                <span class="wow fadeInDown delay-09s">Programmer</span>
                <p class="wow fadeInDown delay-09s">O nim to można by litanię napisać, a raczej zagrać... na perkusji. Kod trzepie jak na bębnach rytm piosenki... ale... czy nie brakuje rytmu?</p>
            </div>
			<div class="team-leader-box">
                <div class="team-leader wow fadeInDown delay-09s"> 
                    <div class="team-leader-shadow"><a href="#"></a></div>
					<img src="<c:url value="/resources/img/team-leader-pic6.jpg"/>">
                    <ul>
                        <li><a href="#" class="fa-twitter"></a></li>
                        <li><a href="#" class="fa-facebook"></a></li>
                        <li><a href="#" class="fa-pinterest"></a></li>
                        <li><a href="#" class="fa-google-plus"></a></li>
                    </ul>
                </div>
                <h3 class="wow fadeInDown delay-09s">Szop</h3>
                <span class="wow fadeInDown delay-09s">Pet</span>
                <p class="wow fadeInDown delay-09s">Wspiera nasze morale. Składa zamówienia, robi zdjęcia, obrabia obrazy, pobiera opłaty... Niezastąpiony członek zespołu.</p>
            </div>
			<div class="team-leader-box">
                <div class="team-leader wow fadeInDown delay-09s"> 
                    <div class="team-leader-shadow"><a href="#"></a></div>
                    <img src="<c:url value="/resources/img/team-leader-pic5.jpg"/>">
                    <ul>
                        <li><a href="#" class="fa-twitter"></a></li>
                        <li><a href="#" class="fa-facebook"></a></li>
                        <li><a href="#" class="fa-pinterest"></a></li>
                        <li><a href="#" class="fa-google-plus"></a></li>
                    </ul>
                </div>
                <h3 class="wow fadeInDown delay-09s">Piotr Makowiec</h3>
                <span class="wow fadeInDown delay-09s">Programmer</span>
                <p class="wow fadeInDown delay-09s">Spec od Windowsa, zna całą platformę. Od jakiegoś czasu zastanawiamy się skąd w naszym projekcie zamiast normalnych błędów zaczęły się pojawiać blue screeny...</p>
            </div>
        </div>
		<br/>
		<br/>
        <div class="row">
        	<div class="col-lg-6 col-sm-7 wow fadeInLeft">
            	<div class="contact-info-box address clearfix">
                	<h3><i class=" icon-map-marker"></i>Adres:</h3>
                	<span>Azory<br>Niebieski Przylądek, Kraków, Polska</span>
                </div>
                <div class="contact-info-box phone clearfix">
                	<h3><i class="fa-phone"></i>Telefon:</h3>
                	<span>133 721 370</span>
                </div>
                <div class="contact-info-box email clearfix">
                	<h3><i class="fa-pencil"></i>Email:</h3>
                	<span>foto-szop@szop.pl</span>
                </div>
            	<div class="contact-info-box hours clearfix">
                	<h3><i class="fa-clock-o"></i>Godziny:</h3>
                	<span><strong>Pon - Wt:</strong> 10 - 18<br><strong>Piątek:</strong> Pracujemy? <br><strong>Sobota - Niedziela:</strong> Lepiej nie pytać</span>
                </div>
                <ul class="social-link">
                	<li class="twitter"><a href="#"><i class="fa-twitter"></i></a></li>
                    <li class="facebook"><a href="#"><i class="fa-facebook"></i></a></li>
                    <li class="pinterest"><a href="#"><i class="fa-pinterest"></i></a></li>
                    <li class="gplus"><a href="#"><i class="fa-google-plus"></i></a></li>
                    <li class="dribbble"><a href="#"><i class="fa-dribbble"></i></a></li>
                </ul>
            </div>
        	<div class="col-lg-6 col-sm-5 wow fadeInUp delay-05s">
            	<div class="form">
                	<input class="input-text" type="text" name="" value="Imię *" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;">
                    <input class="input-text" type="text" name="" value="Twój e-mail *" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;">
                	<textarea class="input-text text-area" cols="0" rows="0" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;">Twoja wiadomość *</textarea>
                    <input class="input-btn" type="submit" value="Wyślij">
                </div>	
            </div>
        </div>
</section>
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