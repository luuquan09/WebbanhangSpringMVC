 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>  
  <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>

<title>Header</title>	

</head>
<body>
	<%
		if(session.getAttribute("namemember")==null && session.getAttribute("idmember")==null)
		{
	%>
    <div class="site-navbar bg-white py-2">
      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
            <input type="text" onkeyup="searchViaAjax(this.value)" id="namesearch" class="form-control" placeholder="Search keyword and hit enter...">        
        </div>
      	 <div id="ajax-response"> 	
		 </div>
		
      </div>
		
      <div class="container">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="trang-chu.htm" class="js-logo-clone">ShopMax</a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="has-children active">
                  <a href="trang-chu.htm">Home</a>
                  <ul class="dropdown">
                    <li><a href="#">Menu One</a></li>
                    <li><a href="#">Menu Two</a></li>
                    <li><a href="#">Menu Three</a></li>
                    <li class="has-children">
                      <a href="#">Sub Menu</a>
                      <ul class="dropdown">
                        <li><a href="#">Menu One</a></li>
                        <li><a href="#">Menu Two</a></li>
                        <li><a href="#">Menu Three</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
                
                <li><a href="shop.htm">Shop</a></li>
                <li><a href="#">Catalogue</a></li>
                <li><a href="#">New Arrivals</a></li>
                <li><a href="contact.html">Contact</a></li>
              </ul>
            </nav>
          </div>
          <div class="icons">
             <div class="icons-btn d-inline-block js-search-ope ">  
         			 <a href="login.htm">Login</a>  
          	</div>
            <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
            <a href="#" class="icons-btn d-inline-block"><span class="icon-heart-o"></span></a>
            <a href="cart.htm" class="icons-btn d-inline-block bag">
              <span class="icon-shopping-bag"></span>
              <span class="number">
              <%if(session.getAttribute("numberofCart") == null){
              %> 
              0
              <%}
              else{
              %>
              	<%=session.getAttribute("numberofCart")%>
              <%} %>
              </span>
            </a>
            <a href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span class="icon-menu"></span></a>
          </div>
        </div>
      </div>
    </div>
	<%
		}
		else{
			
	%>
	  <div class="site-navbar bg-white py-2">
      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
            <input type="text" onkeyup="searchViaAjax(this.value)" id="namesearch" class="form-control" placeholder="Search keyword and hit enter...">        
        </div>    
       <div id="ajax-response"> 	
		 </div>
      </div>
	
         	
          	
        
      <div class="container">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="trang-chu.htm" class="js-logo-clone">ShopMax</a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="has-children active">
                  <a href="trang-chu.htm">Home</a>
                  <ul class="dropdown">
                    <li><a href="#">Menu One</a></li>
                    <li><a href="#">Menu Two</a></li>
                    <li><a href="#">Menu Three</a></li>
                    <li class="has-children">
                      <a href="#">Sub Menu</a>
                      <ul class="dropdown">
                        <li><a href="#">Menu One</a></li>
                        <li><a href="#">Menu Two</a></li>
                        <li><a href="#">Menu Three</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
                
                <li><a href="shop.htm">Shop</a></li>
                <li><a href="#">Catalogue</a></li>
                <li><a href="#">New Arrivals</a></li>
                <li><a href="contact.html">Contact</a></li>
              </ul>
            </nav>
          </div>
          <div class="icons">
<!--              <div class="icons-btn d-inline-block js-search-ope ">   -->
         	<a class="icons-btn d-inline-block js-search-ope" style="font-weight:bold;font-size:17px;" href=""><%=session.getAttribute("namemember") %></a>  
<!--           	</div> -->
            <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
            <a href="#" class="icons-btn d-inline-block"><span class="icon-heart-o"></span></a>
            <a href="cart.htm" class="icons-btn d-inline-block bag">
              <span class="icon-shopping-bag"></span>
              <span class="number">
              <%if(session.getAttribute("numberofCart") == null){
              %> 
              0
              <%}
              else{
              %>
              	<%=session.getAttribute("numberofCart")%>
              <%} %>
              </span>
            </a>
            <a  href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span class="icon-menu"></span></a>
          	<a class="" href="logoutcontroller.htm">Log out</a>
          </div>
        </div>
      </div>
    </div>
	<%

		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript">
	
  function searchViaAjax(name) {
			
// 			if(name != ""){
// 			$.ajax({
// 				scriptCharset: "utf-8" , 
// 			    contentType: "application/json; charset=UTF-8",
// 				type : "GET",	
// 				url : "search.htm",
// 				data : {
// 					name : name
// 				},
// 				dataType : 'json',
// 				timeout : 100000,
// 				success : function(data) {
// 					console.log("SUCCESS: ", data);
// 					if (data != null) {
						
// 						var result = "";
// 						for(i in data){
// 						console.log(data[i][0]);
// 						result += "<div class='container' id='search'>"+
// 					 	"<h3 style='padding-left: 12px;opacity: 1.0;''>" +
// 					 	"<a href='shopsingle.htm?idpd="+data[i][0]+"'>"+data[i][1]+"</a></h3></div>";
// 						}
// 						$("#ajax-response").html(result);
// 					} else {
// 						var result = "";
// 						$("#ajax-response").html(result);
// 					}
// 				},
// 				error : function(e) {
// 					console.log("ERROR: ", e);
// 				}
// 			});
// 		}else {
// 			document.getElementById("ajax-response").innerHTML = "";
// 		}
// 		}
//   function searchViaAjax(name) {
			
			if(name != ""){
			     xmlhttp = new XMLHttpRequest();
	                xmlhttp.onreadystatechange=function()
	            {
	                if(xmlhttp.readyState==4 && xmlhttp.status == 200){	                  
	                    document.getElementById("ajax-response").innerHTML = xmlhttp.responseText;
	                }
	            }
	            xmlhttp.open("GET","search.htm?name="+name,true);
	            xmlhttp.send(); 	
			}
			else 
		{
			document.getElementById("ajax-response").innerHTML = "";
		}
		}



	</script>
	
	
</body>
</html>