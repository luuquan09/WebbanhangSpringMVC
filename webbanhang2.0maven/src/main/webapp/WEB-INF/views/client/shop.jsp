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
    
  </head>
  <body>
  
  <div class="site-wrap">
    

    <!-- Begin header -->

	<jsp:include page ="header.jsp" />

	<!-- End header -->
  
    <div class="site-blocks-cover inner-page" data-aos="fade">
      <div class="container">
        <div class="row">
          <div class="col-md-6 ml-auto order-md-2 align-self-start">
            <div class="site-block-cover-content">
            <h2 class="sub-title">#New Summer Collection 2019</h2>
            <h1>Arrivals Sales</h1>
            <p><a href="#" class="btn btn-black rounded-0">Shop Now</a></p>
            </div>
          </div>
          <div class="col-md-6 order-1 align-self-end">
            <img src="FE/Mainthem/images/model_4.png" alt="Image" class="img-fluid">
          </div>
        </div>
      </div>
    </div>

    <div	 class="custom-border-bottom py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="trang-chu.htm">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Shop</strong></div>
        </div>
      </div>
    </div>


    <div class="site-section">
      <div class="container">

        <div class="row mb-5">
          <div class="col-md-9 order-1">

            <div class="row align">
              <div class="col-md-12 mb-5">
                <div class="float-md-left"><h2 class="text-black h5">Shop All</h2></div>
                <div class="d-flex">
                  <div class="dropdown mr-1 ml-md-auto">
                    <button type="button" class="btn btn-white btn-sm dropdown-toggle px-4" id="dropdownMenuOffset" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Latest
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                      <a class="dropdown-item" href="#">Men</a>
                      <a class="dropdown-item" href="#">Women</a>
                      <a class="dropdown-item" href="#">Children</a>
                    </div>
                  </div>
                  <div class="btn-group">
                    <button type="button" class="btn btn-white btn-sm dropdown-toggle px-4" id="dropdownMenuReference" data-toggle="dropdown">Reference</button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuReference">
                      <a class="dropdown-item" href="#">Relevance</a>
                      <a class="dropdown-item" href="#">Name, A to Z</a>
                      <a class="dropdown-item" href="#">Name, Z to A</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Price, low to high</a>
                      <a class="dropdown-item" href="#">Price, high to low</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="row mb-5">
		   			
		   			<c:forEach items="${listproduct}" var="listsp">
						<div class="col-lg-6 col-md-6 item-entry mb-4">
							<a href="shopsingle.htm?idpd=${listsp[0]}" class="product-item md-height bg-gray d-block"> <img
								src="${listsp[4]}" alt="Image"
								class="img-fluid">
							</a>
							<h2 class="item-title">
								<a href="shopsingle.htm?idpd=${listsp[0]}">${listsp[1]}</a>
							</h2>
							<strong class="item-price"><fmt:formatNumber value="${listsp[2]}" type="currency">
												</fmt:formatNumber></strong>
						</div>
					</c:forEach>
              
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/prod_2.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Gray Shoe</a></h2> -->
<!--                 <strong class="item-price">$20.00</strong> -->
<!--               </div> -->
              
              
              
              
              
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/prod_3.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Blue Shoe High Heels</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->
<!--               </div> -->

<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/model_5.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Denim Jacket</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->

<!--                 <div class="star-rating"> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                 </div> -->

<!--               </div> -->
            
            
            
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/prod_1.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Leather Green Bag</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->
<!--                 <div class="star-rating"> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                 </div> -->
<!--               </div> -->



<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/model_1.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Smooth Cloth</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->
<!--               </div> -->
          
          
          
          
          
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/model_7.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Yellow Jacket</a></h2> -->
<!--                 <strong class="item-price">$58.00</strong> -->
<!--               </div> -->
           
           
           
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/prod_2.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Gray Shoe</a></h2> -->
<!--                 <strong class="item-price">$20.00</strong> -->
<!--               </div> -->
            
            
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/prod_3.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Blue Shoe High Heels</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->
<!--               </div> -->

<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/model_5.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Denim Jacket</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->

<!--                 <div class="star-rating"> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                 </div> -->

<!--               </div> -->
              
              
              
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/prod_1.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Leather Green Bag</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->
<!--                 <div class="star-rating"> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                   <span class="icon-star2 text-warning"></span> -->
<!--                 </div> -->
<!--               </div> -->

<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/model_1.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Smooth Cloth</a></h2> -->
<!--                 <strong class="item-price"><del>$46.00</del> $28.00</strong> -->
<!--               </div> -->
            
            
            
<!--               <div class="col-lg-6 col-md-6 item-entry mb-4"> -->
<!--                 <a href="#" class="product-item md-height bg-gray d-block"> -->
<!--                   <img src="FE/Mainthem/images/model_7.png" alt="Image" class="img-fluid"> -->
<!--                 </a> -->
<!--                 <h2 class="item-title"><a href="#">Yellow Jacket</a></h2> -->
<!--                 <strong class="item-price">$58.00</strong> -->
<!--               </div> -->
           
           
            </div>
            
            <div class="row">
              <div class="col-md-12 text-center">
                <div class="site-block-27">
                  <ul>
                    <li><a href="shop.htm">&lt;</a></li>
<!--                     <li class="active"><span>1</span></li> -->
                    <c:forEach var = "i" begin = "1" end = "${numberpage}">
      					  	 		<c:choose>
      					  	 			<c:when test="${i == check}">
      					  	 				<li class="active"><a href="shoppage.htm?pageid=${i}">${i}</a></li>
      					  	 			</c:when>
      					  	 		 	<c:otherwise>
       										<li><a href="page.htm?pageid=${i}">${i}</a></li>
   								 		</c:otherwise>
   								 	</c:choose>  					  	 	
      				</c:forEach>                
                    <li><a href="page.htm?pageid=${numberpage}">&gt;</a></li>
                  </ul>
                </div>
              </div>
            </div>
          
          
          </div>

          <div class="col-md-3 order-2 mb-5 mb-md-0">
            <div class="border p-4 rounded mb-4">
              <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
              <ul class="list-unstyled mb-0">
                <li class="mb-1"><a href="#" class="d-flex"><span>Men</span> <span class="text-black ml-auto">(2,220)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>Women</span> <span class="text-black ml-auto">(2,550)</span></a></li>
                <li class="mb-1"><a href="#" class="d-flex"><span>Children</span> <span class="text-black ml-auto">(2,124)</span></a></li>
              </ul>
            </div>

            <div class="border p-4 rounded mb-4">
              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Filter by Price</h3>
                <div id="slider-range" class="border-primary"></div>
                <input type="text" name="text" id="amount" class="form-control border-0 pl-0 bg-white" disabled="" />
              </div>

              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Size</h3>
                <label for="s_sm" class="d-flex">
                  <input type="checkbox" id="s_sm" class="mr-2 mt-1"> <span class="text-black">Small (2,319)</span>
                </label>
                <label for="s_md" class="d-flex">
                  <input type="checkbox" id="s_md" class="mr-2 mt-1"> <span class="text-black">Medium (1,282)</span>
                </label>
                <label for="s_lg" class="d-flex">
                  <input type="checkbox" id="s_lg" class="mr-2 mt-1"> <span class="text-black">Large (1,392)</span>
                </label>
              </div>

              <div class="mb-4">
                <h3 class="mb-3 h6 text-uppercase text-black d-block">Color</h3>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-danger color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Red (2,429)</span>
                </a>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-success color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Green (2,298)</span>
                </a>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-info color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Blue (1,075)</span>
                </a>
                <a href="#" class="d-flex color-item align-items-center" >
                  <span class="bg-primary color d-inline-block rounded-circle mr-2"></span> <span class="text-black">Purple (1,075)</span>
                </a>
              </div>

            </div>
          </div>
        </div>

      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="title-section mb-5">
          <h2 class="text-uppercase"><span class="d-block">Discover</span> The Collections</h2>
        </div>
        <div class="row align-items-stretch">
          <div class="col-lg-8">
            <div class="product-item sm-height full-height bg-gray">
              <a href="#" class="product-category">Women <span>25 items</span></a>
              <img src="FE/Mainthem/images/model_4.png" alt="Image" class="img-fluid">
            </div>
          </div>
          <div class="col-lg-4">
            <div class="product-item sm-height bg-gray mb-4">
              <a href="#" class="product-category">Men <span>25 items</span></a>
              <img src="FE/Mainthem/images/model_5.png" alt="Image" class="img-fluid">
            </div>

            <div class="product-item sm-height bg-gray">
              <a href="#" class="product-category">Shoes <span>25 items</span></a>
              <img src="FE/Mainthem/images/model_6.png" alt="Image" class="img-fluid">
            </div>
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