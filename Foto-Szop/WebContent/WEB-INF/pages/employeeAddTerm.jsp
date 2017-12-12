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
<spring:url value="resources/js/jquery.easing.1.3.js" var="easing"/>
<spring:url value="resources/js/jquery.isotope.js" var="isotope"/>
<spring:url value="resources/js/wow.js" var="wow"/>
<spring:url value="resources/js/classie.js" var="classie"/>
<spring:url value="resources/index/js/respond-1.1.0.min.js"
            var="respond"/>
<spring:url value="resources/index/js/html5shiv.js" var="html5shiv"/>
<spring:url value="resources/index/js/html5element.js"
            var="html5element"/>
<spring:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700"
            var="font1"/>
<spring:url value="http://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600"
            var="font2"/>
<spring:url value="resources/favicon.png"
            var="favicon"/>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, maximum-scale=1">
    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
        <h2>Ustalanie terminów</h2>
        <p class="client-part-haead wow fadeInDown delay-05 caption"
           style="color: black; text-align: center;">${employee.getName()}, dodaj kolejne terminy:</p>
        <div class="bootstrap-iso text-center wow animated fadeInDown delay-09s">
            <div class="container-fluid ">
                <div class="row">
                    <div class="col-lg-4 col-lg-offset-4">
                        <form:form action="addTerm" modelAttribute="termForm"
                                   method="post">
                            <div class="form-group ">
                                <form:errors path="date" cssStyle="color: #ff0000;"/>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"> </i>
                                    </div>
                                    <form:input path="date" cssClass="form-control" id="datepicker"
                                                placeholder="YYYY/MM/DD" type="text" required="required"></form:input>   
                                </div>
                            </div>
                            <div class="form-group">
                                <div>
                                        ${termForm.setEmployeeId(employee.id) }
                                    <button class="btn btn-success " name="submit" type="submit">
                                        Dodaj
                                    </button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <h3 style="text-align: center;" class="wow animated fadeInDown delay-07s">Terminy w jakich udostępniasz
            możliwość zamówienia sesji:</h3>
        <div class="bootstrap-iso text-center ">
            <div class="col-lg-4 col-lg-offset-4 wow animated fadeInDown delay-09s">
                <table class="table table-hover table-hovered" style="text-align: center;">
                    <thead>
                    <tr>
                        <th style="text-align:center;">Data</th>
                        <th style="text-align:center;">Operacje</th>
                    </tr>
                    <thead>
                    <tbody>
                    <c:forEach items="${termList}" var="term" varStatus="status">
                        <tr class="success">
                            <td id="data">
                                <c:out value="${term.date}"/>
                            </td>

                            <td id="operacja">
                                <form action="deleteTerm" method="post">
                                    <input type="hidden" name="termToDelete" value="${term.id}"/>
                                    <input class="btn btn-danger " type="submit" value="Usuń"
                                           name="remove"/>
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
<script>
    wow = new WOW(
        {
            animateClass: 'animated',
            offset: 100
        }
    );
    wow.init();
</script>

 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
 <script>
 $(document).ready(function () {
    $("#datepicker").datepicker({ dateFormat: "yy/mm/dd"}).val();
 });
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