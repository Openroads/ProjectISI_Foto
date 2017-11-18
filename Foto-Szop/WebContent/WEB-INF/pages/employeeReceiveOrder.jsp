<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<spring:url value="resources/index/js/respond-1.1.0.min.js"
            var="respond"/>
<spring:url value="resources/index/js/html5shiv.js" var="html5shiv"/>
<spring:url value="resources/index/js/html5element.js"
            var="html5element"/>

<spring:url
        value="http://fonts.googleapis.com/css?family=Montserrat:400,700"
        var="font1"/>
<spring:url
        value="http://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600"
        var="font2"/>

<spring:url value="resources/favicon.png" var="favicon"/>


<!-- For datepicker! -->
<spring:url value="https://formden.com/static/cdn/bootstrap-iso.css"
            var="bootstrapiso"/>
<spring:url
        value="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css"
        var="fontawesome"/>
<!-- END DATEPICKER -->


<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, maximum-scale=1">

    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>

    </script>


    <title>Foto-Szop | Konto</title>
    <link rel="icon" href="${favicon}">

    <!-- For datepicker! -->
    <link rel="stylesheet" href="${bootstrapiso}">
    <link rel="stylesheet" href="${fontawesome}">
    <!-- END DATEPICKER -->

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

<nav class="main-nav-outer" id="test">
    <!--main-nav-start-->
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


<section class="main-section" id="konto">
    <!--main-section-start-->
    <div class="container ">
        <h2>Przyjmowanie zamówień</h2>
        <p class="client-part-haead wow fadeInDown delay-05 caption"
           style="color: black; text-align: center;">${employee.getName()}, nieprzyjęte zlecenia:</p>

        <br/> <br/>
        <br>
        <br>
        <h3 style="text-align: center;" class="wow animated fadeInDown delay-07s">Zlecenia sesji:</h3>
        <div class="bootstrap-iso text-center ">
            <div class="col-lg-4 col-lg-offset-4 wow animated fadeInDown delay-09s">
                <table class="table table-hover table-hovered" style="text-align: center;">
                    <thead>
                    <tr>
                    	<th style="text-align:center;">Data zamówienia</th>
                        <th style="text-align:center;">Data realizacji</th>
                        <th style="text-align:center;">Tematyka</th>
                        <th style="text-align:center;">Miejsce</th>
                        <th style="text-align:center;">Adres</th>
                        <th style="text-align:center;">Klient</th>
                    </tr>
                    <thead>
                    <tbody>
                    <c:forEach items="" var="term" varStatus="status">
          
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
            <div class="col-lg-4 col-lg-offset-4 wow animated fadeInDown delay-09s">
                <table class="table table-hover table-hovered" style="text-align: center;">
                    <thead>
                    <tr>
                        <th style="text-align:center;">Data</th>
                        <th style="text-align:center;">Format</th>
                        <th style="text-align:center;">Rodzaj</th>
                        <th style="text-align:center;">Grafik</th>
                        <th style="text-align:center;">Adres dostawy</th>
                        <th style="text-align:center;">Zdjęcia</th>
                     
                    </tr>
                    <thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>




<!--main-section-end-->


<div class="c-logo-part">
    <!--c-logo-part-start-->
    <div class="container">
        <ul>
            <li><a href="#"><img
                    src="<c:url value="/resources/img/c-liogo1.png"/>"></a></li>
            <li><a href="#"><img
                    src="<c:url value="/resources/img/c-liogo2.png"/>"></a></li>
            <li><a href="#"><img
                    src="<c:url value="/resources/img/c-liogo3.png"/>"></a></li>
            <li><a href="#"><img
                    src="<c:url value="/resources/img/c-liogo4.png"/>"></a></li>
            <li><a href="#"><img
                    src="<c:url value="/resources/img/c-liogo5.png"/>"></a></li>
        </ul>
    </div>
</div>
<!--c-logo-part-end-->


<footer class="footer">
    <div class="container">
        <div class="footer-logo">
            <a href="#"><img
                    src="<c:url value="/resources/img/footer-logo.png"/>"></a>
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

    $(window).load(function () {


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

        $(window).smartresize(function () {
            // check if columns has changed
            var currentColumns = Math.floor(( $body.width() - 30 ) / colW);
            if (currentColumns !== columns) {
                // set new column count
                columns = currentColumns;
                // apply width to container manually, then trigger relayout
                $container.width(columns * colW)
                    .isotope('reLayout');
            }

        }).smartresize(); // trigger resize to set container width
        $('.portfolioFilter a').click(function () {
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


<!-- DATEPICKER -->
<script type="text/javascript"
        src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<script>
    $(document).ready(function () {
        var date_input = $('input[name="date"]'); //our date input has the name "date"
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy/mm/dd',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
</script>

<!-- DATEPICKER -->


</body>
</html>