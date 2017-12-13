<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	    <link rel="stylesheet" href="/resources/demos/style.css">
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
    <!--main-nav-start-->
	<nav class="main-nav-outer" id="test">
	    <div class="container">
	        <ul class="main-nav">
	            <li><a href="${contextPath}/index">Powrót</a></li>
	            <li class="small-logo"><a href="#header"><img
	                    src="<c:url value="/resources/img/small-logo.png"/>"></a></li>
	            <li><a href="logout">Wyloguj</a></li>
	        </ul>
	        <a class="res-nav_click" href="#"><i class="fa-bars"></i></a>
	    </div>
	</nav>
	<!--main-nav-end-->
    <!--main-section-start-->
	<section class="main-section" id="konto">
	    <div class="container ">
	        <h2>Przyjmowanie zamówień</h2>
	        <p class="client-part-haead wow fadeInDown delay-05 caption"
	           style="color: black; text-align: center;">${employee.getName()}, nieprzyjęte zlecenia:</p>
	        <br/> <br/>
	        <br>
	        <br>
	        <h3 style="text-align: center;" class="wow animated fadeInDown delay-07s">Zlecenia sesji:</h3>
	        <div class="bootstrap-iso text-center ">
	            <div class="col-lg-12 wow animated fadeInDown delay-09s">
	                <table class="table table-hover table-hovered" style="text-align: center;">
	                    <thead>
	                    <tr>
	                    	<th style="text-align:center;">Data zamówienia</th>
	                        <th style="text-align:center;">Data realizacji</th>
	                        <th style="text-align:center;">Tematyka</th>
	                        <th style="text-align:center;">Miejsce</th>
	                        <th style="text-align:center;">Adres</th>
	                        <th style="text-align:center;">Klient</th>
	                        <th style="text-align:center;">Bonus</th>
	                    </tr>
	                    <thead>
	                    <tbody>
	                    <c:forEach items="${orderSessionList}" var="session" varStatus="status">
	          				<tr class="success">
	                            <td id="data">
	                                <c:out value="${session.dateOfOrder}"/>
	                            </td>
								 <td id="data">
	                                <c:out value="${session.realizationDate}"/>
	                            </td>
	                             <td id="tematyka">
	                                <c:out value="${session.orderTitle}"/>
	                            </td>
	                             <td id="miejsce">
	                                <c:out value="${session.orderPlace}"/>
	                            </td>
	                             <td id="adres">
	                                <c:out value="${session.orderAddress}"/>
	                            </td>
	                             <td id="klient">
	                                <c:out value="${session.idClient}"/>
	                            </td>
	                             <td id="bonus">
	                                <c:out value="${session.bonus}"/> %
	                            </td>
	                            <td id="operacja">
	                                <form action="acceptOrder" method="post">
	                                    <input type="hidden" name="orderId" value="${session.idOrder}"/>
	                                    <input class="btn btn-danger " type="submit" value="Przyjmij" name="add"/>
	                                </form>
	                            </td>
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </div>   
	        <br>
	        <br>
	        </div>
	        <br>
	        <br>
	        <h3 style="text-align: center;" class="wow animated fadeInDown delay-07s">Zlecenia obróbki zdjęć:</h3>
	   		<div class="bootstrap-iso text-center ">
	            <div class="col-lg-12 wow animated fadeInDown delay-09s">
	                <table class="table table-hover table-hovered" style="text-align: center;">
	                    <thead>
	                    <tr>
	                        <th style="text-align:center;">Data</th>
	                        <th style="text-align:center;">Data realizacji</th>
	                        <th style="text-align:center;">Rodzaj</th>
	                        <th style="text-align:center;">Adres dostawy</th>
	                        <th style="text-align:center;">Klient</th>
	                        <th style="text-align:center;">Bonus</th>
	                        
	                    </tr>
	                    <thead>
	                    <tbody>
	                    <c:forEach items="${orderPhotoList}" var="photo" varStatus="status">
	          				<tr class="success">
	                            <td id="data">
	                                <c:out value="${photo.dateOfOrder}"/>
	                            </td>
								 <td id="data">
	                                <c:out value="${photo.realizationDate}"/>
	                            </td>
	                             <td id="tematyka">
	                                <c:out value="${photo.orderTitle}"/>
	                            </td>
	                             <td id="adres">
	                                <c:out value="${photo.orderAddress}"/>
	                            </td>
	                             <td id="klient">
	                                <c:out value="${photo.idClient}"/>
	                            </td>
	                             <td id="bonus">
	                                <c:out value="${photo.bonus}"/> %
	                            </td>
	                            <td id="operacja">
	                                <form action="acceptOrder" method="post">
	                                    <input type="hidden" name="orderId" value="${photo.idOrder}"/>
	                                    <input class="btn btn-danger " type="submit" value="Przyjmij" name="add"/>
	                                </form>
	                            </td>
	                        </tr>
	                    </c:forEach>
	                    </tbody>
	                </table>
	            </div>
	        </div>
	    </div>
	</section>	
	<!--main-section-end-->
	<!--c-logo-part-start-->
	<div class="c-logo-part">
	    <div class="container">
	        <ul>
	            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo1.png"/>"></a></li>
	            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo2.png"/>"></a></li>
	            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo3.png"/>"></a></li>
	            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo4.png"/>"></a></li>
	            <li><a href="#"><img src="<c:url value="/resources/img/c-liogo5.png"/>"></a></li>
	        </ul>
	    </div>
	</div>
	<!--c-logo-part-end-->
	<footer class="footer">
	    <div class="container">
	        <div class="footer-logo">
	            <a href="#"><img src="<c:url value="/resources/img/footer-logo.png"/>"></a>
	        </div>
	        <span class="copyright">Copyright © 2017 | <a href="#">Foto-szop</a></span>
	    </div>
	</footer>
	
	<script type="text/javascript">
	    $(document).ready(function (e) {
	        $('#test').scrollToFixed();
	        $('.res-nav_click').click(function () {
	            $('.main-nav').slideToggle();
	            return false
	        });
	    });
	</script>
	
	<script>
	    wow = new WOW(
	        {
	            animateClass: 'animated',
	            offset: 100
	        }
	    );
	    wow.init();
	</script>
	
	<script type="text/javascript">
	    $(window).load(function () {
	        $('.main-nav li a').bind('click', function (event) {
	            var $anchor = $(this);
	            $('html, body').stop().animate({
	                scrollTop: $($anchor.attr('href')).offset().top - 102
	            }, 1500, 'easeInOutExpo');
	            event.preventDefault();
	        });
	    })
	</script>
	
	</body>
</html>