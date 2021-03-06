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
    <link rel="stylesheet" href="fonts/icomoon/style.css">
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
    

     <!-- Begin header -->
	<div id="test">
	<jsp:include page ="header.jsp" />
	</div>
	<!-- End header -->
    
   

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="trang-chu.htm">Home</a> <span class="mx-2 mb-0">/</span> <a href="shop.htm">Shop</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Gray Shoe</strong></div>
        </div>
      </div>
    </div>  


	
	 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="item-entry">
              <a href="#" class="product-item md-height bg-gray d-block">
                <img src="${product.getimgavt()}" alt="Image" class="img-fluid">
              </a>
              
            </div>

          </div>
          <div class="col-md-6">
            <h2 class="text-black">${product.getName()}</h2>
            <p>${product.getDetail()}</p>
<!--             <p class="mb-4">Ex numquam veritatis debitis minima quo error quam eos dolorum quidem perferendis. Quos repellat dignissimos minus, eveniet nam voluptatibus molestias omnis reiciendis perspiciatis illum hic magni iste, velit aperiam quis.</p> -->
            <p><strong class="text-primary h4"><fmt:formatNumber value="${product.getPrice()}" type="currency">
												</fmt:formatNumber></strong></p>
            <div class="mb-1 d-flex">
             <c:forEach items="${product.getListsize()}" var="size">
              <label for="option-sm" class="d-flex mr-3 mb-3">
                <span class="d-inline-block mr-2" style="top:-2px; position: relative;"><input type="radio" id="option-sm" value="${size.getNameSize()}" name="shop-sizes"></span> <span class="d-inline-block text-black">${size.getNameSize()}</span>
              </label>
            </c:forEach>
            </div>
           	
            <div class="mb-5">
              <div class="input-group mb-3" style="max-width: 120px;">
              <div class="input-group-prepend">
                <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
              </div>             
              <input type="text" class="form-control text-center" name="num" value="1"  aria-label="Example text with button addon" aria-describedby="button-addon1">            	
              <div class="input-group-append">
                <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
              </div>
            </div>
            </div>           
               
			 <%if(session.getAttribute("idmember")!=null){%>   
            <p><a style="color:white;" onclick="return addcartViaAjax(${product.getId()})" class="buy-now btn btn-sm height-auto px-4 py-3 btn-primary">Add To Cart</a></p>
			<%}else{%>
			<p><a style="color:white;" href="login.htm" class="buy-now btn btn-sm height-auto px-4 py-3 btn-primary">Add To Cart</a></p>
			<%}%>
          </div>
        </div>
      </div>
    </div>
	



    <div class="site-section block-3 site-blocks-2">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-7 site-section-heading text-center pt-4">
            <h2>Featured Products</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 block-3">
            <div class="nonloop-block-3 owl-carousel">
              <div class="item">
                <div class="item-entry">
                  <a href="#" class="product-item md-height bg-gray d-block">
                    <img src="images/model_1.png" alt="Image" class="img-fluid">
                  </a>
                  <h2 class="item-title"><a href="#">Smooth Cloth</a></h2>
                  <strong class="item-price"><del>$46.00</del> $28.00</strong>
                  <div class="star-rating">
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="item-entry">
                  <a href="#" class="product-item md-height bg-gray d-block">
                    <img src="images/prod_3.png" alt="Image" class="img-fluid">
                  </a>
                  <h2 class="item-title"><a href="#">Blue Shoe High Heels</a></h2>
                  <strong class="item-price"><del>$46.00</del> $28.00</strong>

                  <div class="star-rating">
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="item-entry">
                  <a href="#" class="product-item md-height bg-gray d-block">
                    <img src="images/model_5.png" alt="Image" class="img-fluid">
                  </a>
                  <h2 class="item-title"><a href="#">Denim Jacket</a></h2>
                  <strong class="item-price"><del>$46.00</del> $28.00</strong>

                  <div class="star-rating">
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                  </div>

                </div>
              </div>
              <div class="item">
                <div class="item-entry">
                  <a href="#" class="product-item md-height bg-gray d-block">
                    <img src="images/prod_1.png" alt="Image" class="img-fluid">
                  </a>
                  <h2 class="item-title"><a href="#">Leather Green Bag</a></h2>
                  <strong class="item-price"><del>$46.00</del> $28.00</strong>
                  <div class="star-rating">
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="item-entry">
                  <a href="#" class="product-item md-height bg-gray d-block">
                    <img src="images/model_7.png" alt="Image" class="img-fluid">
                  </a>
                  <h2 class="item-title"><a href="#">Yellow Jacket</a></h2>
                  <strong class="item-price">$58.00</strong>
                  <div class="star-rating">
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                    <span class="icon-star2 text-warning"></span>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>

     <!-- Begin footer -->
	<jsp:include page ="footer.jsp"/>
	<!-- End footer -->
  
  </div>
  <script type="text/javascript">
  function addcartViaAjax(idpd) {  
	  try {
		  var size = document.querySelector('input[name="shop-sizes"]:checked').value; 
		  var number = document.querySelector('input[name="num"]').value;
		 		if(size!==null)
		 		{
		 			if(idpd != ""){
			  			
					     xmlhttp = new XMLHttpRequest();
			                xmlhttp.onreadystatechange=function()
			            {
			                if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
			                	$("#test").load(" #test > *");
			                }
			            }
			            xmlhttp.open("GET","addcart.htm?idpd="+idpd+"&number="+number+"&size="+size,true);	           
			            xmlhttp.send(); 	
					}
					else 
						{
						alert("Them san pham that bai !");
					}
		 		}		
		 
	    
	  } catch (e){
	     
	        alert("Bạn chưa nhập kích thước!");
	    }	
	 
	 

  }

	</script>

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