  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>  
  <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
 
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
          <div class="col-md-12 mb-0"><a href="trang-chu.htm">Home</a> <span class="mx-2 mb-0">/</span> <a href="cart.htm">Cart</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Checkout</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
       
<!--         <div class="row mb-5"> -->
<!--           <div class="col-md-12"> -->
<!--             <div class="border p-4 rounded" role="alert"> -->
<!--               Returning customer? <a href="#">Click here</a> to login -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->
        <form:form action="thankyou.htm" method="post"  modelAttribute="orderhave"> 
        	 <form:hidden  path="address.id"  value="${orderhave.getAddress().getId()}"/>
        	 <form:hidden  path="memberoder.id"  value="${orderhave.getMemberoder().getId()}"/>
        	 <form:hidden  path="total"  value="${orderhave.getTotal()}"/>
        	 <form:hidden  path="numberproduct"  value="${orderhave.getNumberproduct()}"/>
        <div class="row">
          <div class="col-md-6 mb-5 mb-md-0">
            <h2 class="h3 mb-3 text-black">Billing Details</h2>
			 <div class="p-3 p-lg-5 border">
           
              <div class="form-group row">
                <div class="col-md-6">
                  <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                  <form:input path="firstname" value="${orderhave.getMemberoder().getFirstname()}" class="form-control" id="c_fname" name="c_fname"/>
                </div>
                <div class="col-md-6">
                  <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                  <form:input  path="name"  value="${orderhave.getMemberoder().getNamemember()}" class="form-control" id="c_lname" name="c_lname"/>
                </div>
              </div>

		 

		              <div class="form-group row">
		                <div class="col-md-12">
		                  <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
		                   <form:select class="form-control" id="province" 
		                   name="province" path="address.province.id"  items="${provincetest}"
		                                            itemValue="id" itemLabel="name">               
		                  		<form:option value="${orderhave.address.getProvince().getId()}">${orderhave.address.getProvince().getName()}</form:option>          		
		                  </form:select> 
		                </div>
		              </div>

              <div class="form-group">     
              		<form:select class="form-control" id="district" name="district" path="address.district.id">
              			<form:option value="${orderhave.address.getDistrict().getId()}">${orderhave.address.getDistrict().getName()}</form:option>
              		</form:select>

              </div>
  				
  			<div class="form-group">    
               	 <form:select class="form-control" id="ward" name="ward" path="address.ward.id">  
               	 		<form:option value="${orderhave.address.getWard().getId()}">${orderhave.address.getWard().getName()}</form:option>  
               	 </form:select>
                
              </div>
          		
          		<div class="form-group">  
          		<form:input id="nameaddress" value="${orderhave.address.getNameaddress()}" path="address.nameaddress"  class="form-control" placeholder="Số nhà và tên đường"/>
              </div>
			
			
			
			
			
              <div class="form-group row mb-5">
                <div class="col-md-6">
                  <label for="c_email_address" class="text-black">Email Address <span class="text-danger">*</span></label>
                  <form:input path="email" value="${orderhave.getMemberoder().getEmail()}" class="form-control" id="c_email_address" name="c_email_address"/>
                </div>
                <div class="col-md-6">
                  <label for="c_phone" class="text-black">Phone <span class="text-danger">*</span></label>
                  <form:input path="phone"  value="${orderhave.getMemberoder().getPhone()}"  class="form-control" id="c_phone" name="c_phone" placeholder="Phone Number"/>
                </div>
              </div>
              <div class="form-group">
                <label for="c_order_notes" class="text-black">Order Notes</label>
                <form:textarea path="note" name="c_order_notes" id="c_order_notes" cols="30" rows="5" class="form-control" placeholder="Write your notes here..."></form:textarea>
              </div>		
			
			
			<%if(session.getAttribute("idmember") == null){ %>
              <div class="form-group">
                <label for="c_create_account" class="text-black" data-toggle="collapse" href="#create_an_account" role="button" aria-expanded="false" aria-controls="create_an_account"><input type="checkbox" value="1" id="c_create_account"> Create an account?</label>
                <div class="collapse" id="create_an_account">
                  <div class="py-2">
                    <p class="mb-3">Create an account by entering the information below. If you are a returning customer please login at the top of the page.</p>
                    <div class="form-group">
                      <label for="c_account_password" class="text-black">Account Password</label>
                      <input type="email" class="form-control" id="c_account_password" name="c_account_password" placeholder="">
                    </div>
                  </div>
                </div>
              </div>
			<%} %>	
			
			
<!-- 		<!-- New Address --> 
<%-- 		<form:form action="" method="post"  modelAttribute="Order"> 	              --%>
              
<!--               <div class="form-group"> -->
<!--                 <label for="c_ship_different_address" class="text-black" data-toggle="collapse" href="#ship_different_address" role="button" aria-expanded="false" aria-controls="ship_different_address"><input type="checkbox" value="1" id="c_ship_different_address"> Ship To A Different Address?</label> -->
<!--                 <div class="collapse" id="ship_different_address"> -->
<!--                   <div class="py-2"> -->
                 
<!-- 	                    <div class="form-group row"> -->
<!-- 	                      <div class="col-md-6"> -->
<!-- 	                        <label for="c_diff_fname" class="text-black">First Name <span class="text-danger">*</span></label> -->
<%-- 	                       		<form:input path="memberoder.firstname" class="form-control" id="c_diff_fname" name="c_diff_fname"/>	                     	  --%>
<!-- 	                      </div> -->
<!-- 	                      <div class="col-md-6"> -->
<!-- 	                        <label for="c_diff_lname" class="text-black">Last Name <span class="text-danger">*</span></label> -->
<%-- 	                        <form:input path="memberoder.namemember" class="form-control" id="c_diff_lname" name="c_diff_lname"/> --%>
<!-- 	                      </div>	                     -->
<!-- 	                    </div>		 -->
<!-- 		                    <div class="form-group row"> -->
<!-- 		                      <div class="col-md-12"> -->
<!-- 		                      <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label> -->
<%-- 					             <form:select class="form-control" id="province2"  --%>
<%-- 					                   name="province2" path="address.province" items="${provincetest}" itemValue="id" itemLabel="name"/>                  --%>
<!-- 		                      </div> -->
<!-- 		                    </div>	 -->
<!-- 		                    <div class="form-group"> -->
<%-- 		                      <form:select class="form-control" id="district2" name="district2" path="address.district"/>	              	 --%>
<!-- 		                    </div> -->
<!-- 							<div class="form-group"> -->
<%-- 								<form:select class="form-control" id="ward2" name="ward2" path="address.ward"/>  	 --%>
			               
<!-- 							</div> -->
<!-- 				  <div class="form-group row mb-5"> -->
<!--                       <div class="col-md-6"> -->
<!--                         <label for="c_diff_email_address" class="text-black">Email Address <span class="text-danger">*</span></label> -->
<%--                         <form:input path="memberoder.email" class="form-control" id="c_diff_email_address" name="c_diff_email_address"/> --%>
<!--                       </div> -->
<!--                       <div class="col-md-6"> -->
<!--                         <label for="c_diff_phone" class="text-black">Phone <span class="text-danger">*</span></label> -->
<%--                         <form:input path="memberoder.phone" class="form-control" id="c_diff_phone" name="c_diff_phone" placeholder="Phone Number" /> --%>
<!--                       </div> -->
<!--                     </div> -->

<!--                   </div> -->

<!--                 </div> -->
<!--               </div> -->
			
<!--               <div class="form-group"> -->
<!--                 <label for="c_order_notes" class="text-black">Order Notes</label> -->
<%--                 <form:textarea path="note" name="c_order_notes" id="c_order_notes" cols="30" rows="5" class="form-control" placeholder="Write your notes here..."></form:textarea> --%>
<!--               </div>		 -->
         
         
<%--           </form:form> --%>
       
            </div>
          </div>
     
         
         
         
         
          <div class="col-md-6">

            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black">Coupon Code</h2>
                <div class="p-3 p-lg-5 border">
                  
                  <label for="c_code" class="text-black mb-3">Enter your coupon code if you have one</label>
                  <div class="input-group w-75">
                    <input type="text" value="${sessionScope.codename}" class="form-control" id="c_code" placeholder="Coupon Code" aria-label="Coupon Code" aria-describedby="button-addon2">
                    <div class="input-group-append">
                      <button onclick="return discountcost()"  class="btn btn-primary btn-sm px-4" type="button" id="button-addon2">Apply</button>
                    </div>
                  </div>

                </div>
              </div>
            </div>
            
           
           
            <div id="testt">
             <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black">Your Order</h2>
                <div class="p-3 p-lg-5 border">
                  <table class="table site-block-order-table mb-5">
                    <tr>
                      <th>Product</th>
                      <th>Total</th>
                    </tr>
                    <tbody>
                    <c:forEach items="${cart}" var="items">
                      <tr>
                        <td>${items.getProductitem().getName()}<strong class="mx-2">x</strong>${items.quantity}<strong class="mx-2">${items.size}</strong></td>
                        <td><fmt:formatNumber value="${items.getProductitem().getPrice()}" type="currency"/>
							</td>
                      </tr>
                      </c:forEach>
                      
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Ship</strong></td>
                       
                        <td class="text-black">														
                        	 <fmt:formatNumber value="${sessionScope.ship}" type="currency"/>
                        			              
                        </td>
                     
                      </tr>
                      	
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Discount</strong></td>
                        <td class="text-black">
                        	<fmt:formatNumber value="${sessionScope.c_codediscount}" type="currency"/>
							
                        </td>
                      </tr>
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                        <td class="text-black font-weight-bold">
                        <strong>   
                         <c:forEach items="${cart}" var="items">
                      		<c:set var="total" value="${total = total + (items.getProductitem().getPrice()*items.quantity)}"/>         		
                    		</c:forEach>   
                     		<fmt:formatNumber value="${total + sessionScope.ship - sessionScope.c_codediscount}" type="currency"/>
							
						</strong>
						</td>
                      </tr>
                    </tbody>
                  </table>

                  <div class="border p-3 mb-3">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsebank" role="button" aria-expanded="false" aria-controls="collapsebank">Direct Bank Transfer</a></h3>

                    <div class="collapse" id="collapsebank">
                      <div class="py-2">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>

                  <div class="border p-3 mb-3">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsecheque" role="button" aria-expanded="false" aria-controls="collapsecheque">Cheque Payment</a></h3>

                    <div class="collapse" id="collapsecheque">
                      <div class="py-2">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>

                  <div class="border p-3 mb-5">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsepaypal" role="button" aria-expanded="false" aria-controls="collapsepaypal">Paypal</a></h3>

                    <div class="collapse" id="collapsepaypal">
                      <div class="py-2">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                   <button class="btn btn-primary btn-lg btn-block">Place Order</button>                  
                  </div>

                </div>
           
            </div>
			</div>                       
               
            	</div>

          
          
          </div>
        </div>
     </form:form>
      </div>
    </div>

     <!-- Begin footer -->
	<jsp:include page ="footer.jsp"/>
	<!-- End footer -->
  </div>
  
  
<script type="text/javascript">
		
// 		function validateorder(){
			
// 			provinceid = $("#province").val();
// 			districtid = $("#district").val();
// 			wardid = $("#ward").val();
// 			nameaddress = $("#nameaddress").val();
// 			c_fname = $("#c_fname").val();
// 			c_lname = $("#c_lname").val();
// 			c_email_address = $("#c_email_address").val();
// 			c_phone = $("#c_phone").val();
			
// 			if(provinceid != "" && districtid != "" && ward !="" && nameaddress != "") {	
// 				$.get('validateorder.htm',{"provinceid":provinceid,
// 										   "districtid":districtid,
// 										   "wardid":wardid,
// 										   "nameaddress":nameaddress,
// 										   "c_fname":c_fname,
// 										   "c_lname":c_lname,
// 										   "c_email_address":c_email_address,
// 										   "c_phone":c_phone
// 										   },function(data){			
					
										   
										   
										   
										   
// 				});	
// 			}	
			
// 		}
	
	
		
		jQuery(document).ready(function($){
			$("#province").change(function(event){
				provinceid = $("#province").val();
				$.post('gethuyen.htm',{"provinceid":provinceid},function(data){			
					 $("#district").html(data);
				});			
			});
		});
		
		jQuery(document).ready(function($){
			$("#district").change(function(event){
				provinceid = $("#province").val();
				districtid = $("#district").val();
				$.post('getward.htm',{"provinceid":provinceid,"districtid":districtid},function(data){			
					 $("#ward").html(data);
					 shipp();
				});			
			});
		});
		
// 		jQuery(document.body).ready(function($){
// 			$("#district").change(function(event){
// 				provinceid = $("#province").val();
// 				districtid = $("#district").val();
// 				$.get('getshipcode.htm',{"provinceid":provinceid,"districtid":districtid},function(data){			
// 					//alert("luuquan");
// 					 $("#costtt").load(" #costtt > *");
// 				});			
// 			});
// 		});
		
		
		
// 		$('#district').on('change', function () {
// 			provinceid = $("#province").val();
// 			districtid = $("#district").val();
// 			$.get('getshipcode.htm',{"provinceid":provinceid,"districtid":districtid},function(data){			
// 				//alert("luuquan");
// 				// $("#costtt").load(" #costtt > *");
// 				//$("#costtt").html(data);
// 				$("#costtt").load(" #costtt > *");
// 			});	
// 		});
		
		
		
	</script>
	
	<script type="text/javascript">
	shipp();
	function shipp() {  
			provinceid = $("#province").val();
			districtid = $("#district").val();
			
		     xmlhttp = new XMLHttpRequest();
					                xmlhttp.onreadystatechange=function()
					            {
					                if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
					                	
					                	$("#testt").load(" #testt > *");
					            
					                }
					            }
					            xmlhttp.open("GET","getshipcode.htm?provinceid="+provinceid+"&districtid="+districtid,true);						           
					            xmlhttp.send(); 	

		
	 }
	
	
	
	
	
	</script>
	<script type="text/javascript">
	
	function discountcost(){
		c_code = $("#c_code").val();
		  if(c_code != ""){
		  xmlhttp = new XMLHttpRequest();
		  xmlhttp.onreadystatechange=function()
		      {
		          if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
		        	  
		        	  $("#testt").load(" #testt > *");
		      
		          }
		      }
      		 xmlhttp.open("GET","discountcode.htm?c_code="+c_code,true);						           
     		 xmlhttp.send(); 	
			}
		  else{
				
			alert("Bạn chưa nhập mã giảm giá !");	
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