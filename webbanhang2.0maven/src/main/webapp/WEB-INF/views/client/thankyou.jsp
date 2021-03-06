<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>  
  <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>ShopMax &mdash; Colorlib e-Commerce Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
     <link rel="stylesheet" href="FE/Mainthem/fonts/icomoon/style.css">

    <link rel="stylesheet" href="FE/Mainthem/css/bootstrap.min.css">
    <link rel="stylesheet" href="FE/Mainthem/css/magnific-popup.css">
    <link rel="stylesheet" href="FE/Mainthem/css/jquery-ui.css">
    <link rel="stylesheet" href="FE/Mainthem/css/owl.carousel.min.css">
    <link rel="stylesheet" href="FE/Mainthem/css/owl.theme.default.min.css">

    <link rel="stylesheet" href="FE/Mainthem/css/aos.css">

    <link rel="stylesheet" href="FE/Mainthem/css/style.css">
     <base href="${pageContext.servletContext.contextPath}/">
    
  </head>
  <body>
  
  <div class="site-wrap">
    
	<jsp:include page ="header.jsp" />
  
    
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.html">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Thank You</strong></div>
        </div>
      </div>
    </div>  

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <span class="icon-check_circle display-3 text-success"></span>
            <h2 class="display-3 text-black">Thank you!</h2>
            <p class="lead mb-5">You order was successfuly completed.</p>
            <p><a href="shop.html" class="btn btn-sm height-auto px-4 py-3 btn-primary">Back to shop</a></p>
          </div>
        </div>
      </div>
    </div>

    
   <!-- Begin footer -->
	<jsp:include page ="footer.jsp"/>
	<!-- End footer -->
  </div>


   	  <script src="FE/Mainthem/js/jquery-3.3.1.min.js"></script>
	  <script src="FE/Mainthem/js/jquery-ui.js"></script>
	  <script src="FE/Mainthem/js/popper.min.js"></script>
	  <script src="FE/Mainthem/js/bootstrap.min.js"></script>
	  <script src="FE/Mainthem/js/owl.carousel.min.js"></script>
	  <script src="FE/Mainthem/js/jquery.magnific-popup.min.js"></script>
	  <script src="FE/Mainthem/js/aos.js"></script>

      <script src="FE/Mainthem/js/main.js"></script>
    
  </body>
</html>