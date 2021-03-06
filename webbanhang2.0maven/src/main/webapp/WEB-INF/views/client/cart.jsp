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
    
	<div id="reload">
    <!-- Begin header -->

	<jsp:include page ="header.jsp" />

	<!-- End header -->
    
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="trang-chu.htm">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Cart</strong></div>
        </div>
      </div>
    </div>
	
    <div class="site-section">
      <div class="container">
        <c:choose>
    			<c:when test="${cart.size()>0}">
       			    <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th class="product-thumbnail">Image</th>
                    <th class="product-name">Product</th>
                    <th class="product-size">Size</th>
                    <th class="product-price">Price</th>
                    <th class="product-quantity">Quantity</th>
                    <th class="product-total">Total</th>
                    <th class="product-remove">Remove</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${cart}" var="items">
                  <tr>
                    <td class="product-thumbnail">
                      <img src="${items.getProductitem().getimgavt()}" alt="Image" class="img-fluid">
                    </td>
                    <td class="product-name">
                      <h2 class="h5 text-black">${items.getProductitem().getName()}</h2>
                    </td>
                    <td class="product-name ">
                   	 
                      <h2 class="h6 text-black">${items.getSize()}</h2>
                    </td>
                    <td><fmt:formatNumber value="${items.getProductitem().getPrice()}" type="currency">
						</fmt:formatNumber></td>
                   	 <td>
                      <div class="input-group mb-3" style="max-width: 120px;">
                        <div class="input-group-prepend">
                          <button onclick="return updateminusquality(${items.getProductitem().getId()},'${items.getSize()}',${items.quantity})" class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
                        </div>
                        <input type="text" class="form-control text-center"  value="${items.quantity}" min="" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1" readonly="readonly">
                        <div class="input-group-append">
                          <button onclick="return updateaddquality(${items.getProductitem().getId()},'${items.getSize()}',${items.quantity})"  class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
                        
                        </div>
                      </div>

                    </td>
                    <td><fmt:formatNumber value="${items.getProductitem().getPrice()*items.quantity}" type="currency">
						</fmt:formatNumber></td>
                    <td><a onclick="return removecartViaAjax(${items.getProductitem().getId()},'${items.getSize()}')" class="btn btn-primary height-auto btn-sm">X</a></td>
                  </tr>
				</c:forEach>
                </tbody>
              </table>
            </div>
          </form>
        </div>
         <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
              <div class="col-md-6 mb-3 mb-md-0">
                <button class="btn btn-primary btn-sm btn-block">Update Cart</button>
              </div>
              <div class="col-md-6">
               <a href="shop.htm"><button class="btn btn-outline-primary btn-sm btn-block">Continue Shopping</button></a>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <label class="text-black h4" for="coupon">Coupon</label>
                <p>Enter your coupon code if you have one.</p>
              </div>
              <div class="col-md-8 mb-3 mb-md-0">
                <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
              </div>
              <div class="col-md-4">
                <button onclick="return applycoupon()" class="btn btn-primary btn-sm px-4">Apply Coupon</button>
              </div>
            </div>
          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 text-right border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-md-6">
                    <span class="text-black">Subtotal</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">                  
                      <c:forEach items="${cart}" var="items">
                      	<c:set var="total" value="${total = total + (items.getProductitem().getPrice()*items.quantity)}"/>         		
                    </c:forEach>   
                     <fmt:formatNumber value="${total}" type="currency">
						</fmt:formatNumber>                 
                    </strong>
                  </div>
                </div>
                
                 <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Discount</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">  
                         <c:if test= "${discount > 0 }"/> 
                  		 <fmt:formatNumber value="" type="currency">						
						</fmt:formatNumber>                  
                    </strong>
                  </div>
                </div>
                
                <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Total</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black">   
                  		 <fmt:formatNumber value="${total}" type="currency">
						
						</fmt:formatNumber>                  
                    </strong>
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-12">
                    <a href="checkout.htm"><button class="btn btn-primary btn-lg btn-block">Proceed To Checkout</button></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
 
    			</c:when>    
   		 	<c:otherwise>
       			<div class="row sm-12">
       				<h5 style="color:red;">Không có sản phẩm nào trong giỏ !</h5>	
       			</div>
    		</c:otherwise>
		</c:choose>
        
    
    

   
      </div>
    </div>
	</div>
   <!-- Begin footer -->
	<jsp:include page ="footer.jsp"/>
	<!-- End footer -->
  </div>
	<script type="text/javascript">
 	 function removecartViaAjax(idpd,size) {  
 		
	 			if(idpd != ""){
					  			
							     xmlhttp = new XMLHttpRequest();
					                xmlhttp.onreadystatechange=function()
					            {
					                if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
					                	$("#reload").load(" #reload > *");
					                }
					            }
					            xmlhttp.open("GET","removecart.htm?idpd="+idpd+"&size="+size,true);
					           
					            xmlhttp.send(); 	
							}
						
		  }
 	 function updateaddquality(idpd,size,num) {  
 		var number = Number(num) + 1;
 		 if(idpd != ""){
				  			
						     xmlhttp = new XMLHttpRequest();
				                xmlhttp.onreadystatechange=function()
				            {
				                if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
				                	$("#reload").load(" #reload > *");
				                }
				            }
				            xmlhttp.open("GET","updatequality.htm?idpd="+idpd+"&size="+size+"&quality="+number,true);       
				            xmlhttp.send(); 	
						}
					
	  }
	 function updateminusquality(idpd,size,num) {  
		 var number = Number(num) - 1;
	 		if(idpd != ""){
					  			
							     xmlhttp = new XMLHttpRequest();
					                xmlhttp.onreadystatechange=function()
					            {
					                if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
					                	$("#reload").load(" #reload > *");
					                }
					            }
					            xmlhttp.open("GET","updatequality.htm?idpd="+idpd+"&size="+size+"&quality="+number,true);
					           
					            xmlhttp.send(); 	
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