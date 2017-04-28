<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">

<title>Foto-Szop</title>
<link rel="icon" href="<c:url value="resources/index/favicon.png"/>">
<link rel="shortcut icon" href="<c:url value="favicon.ico"/>">

<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600' rel='stylesheet' type='text/css'>

<link href="<c:url value="/resources/index/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/index/css/style.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/index/css/font-awesome.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/index/css/responsive.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/index/css/animate.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/index/js/jquery.1.8.3.min.js"/>"></script>
<script src="<c:url value="/resources/index/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/index/js/jquery-scrolltofixed.js"/>"></script>
<script src="<c:url value="/resources/index/js/jquery.easing.1.3.js"/>"></script>
<script src="<c:url value="/resources/index/js/jquery.isotope.js"/>"></script>
<script src="<c:url value="/resources/index/js/wow.js"/>"></script>
<script src="<c:url value="/resources/index/js/classie.js"/>"></script>


<!--[if lt IE 9]>
    <script src="<c:url value="/resources/index/js/respond-1.1.0.min.js"/>"></script>
    <script src="<c:url value="/resources/index/js/html5shiv.js"/>"></script>
    <script src="<c:url value="/resources/index/js/html5element.js"/>"></script>
<![endif]-->


</head>
<body>
<div style="overflow:hidden;">
<header class="header" id="header"><!--header-start-->
	<div class="container">
    	<figure class="logo animated fadeInDown delay-07s">
        	<a href="#"><img src="<c:url value="/resources/img/logo.png"/>"></a>	
        </figure>	
        <h1 class="animated fadeInDown delay-07s">Witamy w Foto-Szopie</h1>
        <ul class="we-create animated fadeInUp delay-1s">
        	<li>Z NAMI ZDJĘCIA SĄ PIĘKNIEJSZE</li>
        </ul>
            <a class="link animated fadeInUp delay-1s" href="#test">Zaczynamy</a>
    </div>
</div>
</header><!--header-end-->


<nav class="main-nav-outer" id="test"><!--main-nav-start-->
	<div class="container">
        <ul class="main-nav">
        	<li><a href="#header">Strona Główna</a></li>
            <li><a href="#oferta">Oferta</a></li>
            <li><a href="#portfolio">Portfolio</a></li>
            <li class="small-logo"><a href="#header"><img src="<c:url value="/resources/img/small-logo.png"/>"></a></li>
			<li><a href="${contextPath}/register">Rejestracja</a></li>
			<li><a href="#zaloguj">Zaloguj</a></li>
            <li><a href="#kontakt">Kontakt</a></li>			
        </ul>
        <a class="res-nav_click" href="#"><i class="fa-bars"></i></a>
    </div>
</nav><!--main-nav-end-->



<section class="main-section" id="oferta"><!--main-section-start-->
	<div class="container">
    	<h2>Oferta</h2>
    	<h6>Oferujemy szereg usług fotograficznych o najwyższym standardzie.</h6>
        <div class="row">
        	<div class="col-lg-4 col-sm-6 wow fadeInLeft delay-05s">
            	<div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-paw"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>OBRÓBKA &amp; WYWOŁANIE</h3>
                        <p>Nasza drukarnia dużej rozdzielczości sprosta każdemu wymaganiu klienta.</p>
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-gear"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>SESJA ZDJĘCIOWA</h3>
                        <p>Oddajemy do Państwa dyspocyzji najlepszych fotografów.</p>
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-apple"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>SZYBKA DOSTAWA</h3>
                        <p>Najszybsza paczka którą dostarczyliśmy przebyła swoją drogę w mniej niż godzinę!</p>
                    </div>
                </div>
                <div class="service-list">
                	<div class="service-list-col1">
                    	<i class="fa-medkit"></i>
                    </div>
                	<div class="service-list-col2">
                        <h3>WSPARCIE GRAFICZNE</h3>
                        <p>Do państwa dyspozycji oddajemy także najlepszej klasy grafików, którzy nie pozwolą aby Państwa zdjęciom stała się krzywda.</p>
                    </div>
                </div>
            </div>
            <figure class="col-lg-8 col-sm-6  text-right wow fadeInUp delay-02s">
            	<img src="<c:url value="/resources/img/camera.png"/>">
            </figure>
        
        </div>
	</div>
</section><!--main-section-end-->






<section class="main-section paddind" id="portfolio"><!--main-section-start-->
	<div class="container">
    	<h2>Portfolio</h2>
    	<h6>Najnowsze zdjęcia obrobione i wywołane w naszym zakładzie.</h6>
      <div class="portfolioFilter">  
        <ul class="Portfolio-nav wow fadeIn delay-02s">
        	<li><a href="#" data-filter="*" class="current" >All</a></li>
            <li><a href="#" data-filter=".branding" >RAW</a></li>
            <li><a href="#" data-filter=".webdesign" >Obróbka</a></li>
            <li><a href="#" data-filter=".printdesign" >Sesja zdjęciowa</a></li>
            <li><a href="#" data-filter=".photography" >Reklama</a></li>
        </ul>
       </div> 
        
	</div>
    <div class="portfolioContainer wow fadeInUp delay-04s">
            	<div class=" Portfolio-box printdesign">
                	<a href="#"><img src="<c:url value="/resources/img/Portfolio-pic1.jpg"/>"></a>	
                	<h3>Foto Album</h3>
                    <p>Print Design</p>
                </div>
                <div class="Portfolio-box webdesign">
                	<a href="#"><img src="<c:url value="/resources/img/Portfolio-pic2.jpg"/>"></a>	
                	<h3>Nike</h3>
                    <p>Branding</p>
                </div>
                <div class=" Portfolio-box branding">
                	<a href="#"><img src="<c:url value="/resources/img/Portfolio-pic3.jpg"/>"></a>	
                	<h3>Advertisment</h3>
                    <p>Branding</p>
                </div>
                <div class=" Portfolio-box photography" >
                	<a href="#"><img src="<c:url value="/resources/img/Portfolio-pic4.jpg"/>"></a>	
                	<h3>Vinyl Record</h3>
                    <p>Photography</p>
                </div>
                <div class=" Portfolio-box branding">
                	<a href="#"><img src="<c:url value="/resources/img/Portfolio-pic5.jpg"/>"></a>	
                	<h3>West Coast</h3>
                    <p>Branding</p>
                </div>
                <div class=" Portfolio-box photography">
                	<a href="#"><img src="<c:url value="/resources/img/Portfolio-pic6.jpg"/>"></a>	
                	<h3>Voyage</h3>
                    <p>Photography</p>
                </div>
    </div>
</section><!--main-section-end-->


<section class="main-section client-part" id="rejestracja"><!--main-section client-part-start-->
	<div class="container">
		<b class="user wow fadeInDown delay-03"><i class="fa-user"></i></b>
    	<div class="row">
        	<div class="col-lg-12">
            	<p class="client-part-haead wow fadeInDown delay-05">Dołącz do nas i ciesz się nieziemską jakością!</p>
            </div>
        </div>
    	  <a class="link animated fadeInUp delay-1s" href="${contextPath}/register">Zarejestruj się</a>
    </div>
</section><!--main-section client-part-end-->
<div class="c-logo-part"><!--c-logo-part-start-->
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
<section class="main-section team" id="zaloguj"><!--main-section team-start-->
	<div class="container">
<div class="form"style="width: 100%; text-align: center;">
                	<input style="width: 100%; text-align: center;" class="input-text" type="text" name="" value="Email *" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;">
                    <input style="width: 100%; text-align: center;"class="input-text" type="password" name="" value="Hasło *" onfocus="if(this.value==this.defaultValue)this.value='';" onblur="if(this.value=='')this.value=this.defaultValue;">
                    <input class="input-btn" type="submit" value="Zaloguj">
                </div>	

    </div>
</section><!--main-section team-end-->



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