<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>  
  <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
	<link rel="icon" type="image/png" href="FontEnd/FElogin/images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="FE/FElogin/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/css/util.css">
	<link rel="stylesheet" type="text/css" href="FE/FElogin/css/main.css">
	<base href="${pageContext.servletContext.contextPath}/">
</head>
<body style="background-color: #666666;">
    
	<div class="limiter">
	
        <div class="wrap-login100">
            <form:form action="registrationcontroller.htm" method="post"  class="login100-form validate-form">                            
                <span class="login100-form-title p-b-43">
                    Registration
                </span>
	       		 
	       		  <div class="wrap-input100 validate-input" 
                 onkeyup="">
                   <form:input class="input100" path="firstname"/>
                    <span class="focus-input100"></span>
                    <span class="label-input100">FirstName</span>
                </div>
	       		 
	       		 <div class="wrap-input100 validate-input" 
                 onkeyup="">
                   <form:input class="input100" path="namemember"/>
                    <span class="focus-input100"></span>
                    <span class="label-input100">Name</span>
                </div>
	       		 
	       		 
                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz"
                 onkeyup="">
                   <form:input class="input100" path="email"/>
                    <span class="focus-input100"></span>
                    <span class="label-input100">Email</span>
                </div>

<!--                 <div class="wrap-input100 validate-input" data-validate="Password is required"> -->
<%--                      <form:input class="input100" type="password" path="pass"/> --%>
<!--                      <input class="input100" type="password" name="" id="" onkeyup=""> --> 
<!--                     <span class="focus-input100"></span> -->
<!--                     <span class="label-input100">Password</span> -->
<!--                 </div> -->

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <form:password class="input100"  path="password"/>                 
<!--                     <input class="input100" type="password" name="confirmpass" id="confirmpass" onkeyup="" > -->
                    <span class="focus-input100"></span>
                    <span class="label-input100">Password</span>
                </div>
                
                 <div style="margin-left: 20px;opacity: 0.8;" class="wrap validate-input" >
                 	
                     Male<form:radiobutton style="margin: 20px 10px;" path="sex" value="1" />
                     FeMale<form:radiobutton style="margin: 20px 10px;" path="sex" value="0"/>
<!--                      <input class="input100" type="radio" name="sex" id="" onkeyup="" > -->
<!--                      <input class="input100" type="radio" name="sex" id="" onkeyup="" > -->
                  
                    
                </div>
                
                <div class="wrap-input100 validate-input" >
                   	<form:input  class="input100"  path="phone"/>
<!--                     <input class="input100" type="text" name="phone" id="" onkeyup="" > -->
                    <span class="focus-input100"></span>
                    <span class="label-input100">Phone</span>
                </div>
                 
                 <div class="wrap-input100 validate-input">
<!--                     <input class="input100" type="combobox" name="confirmpass" id="confirmpass" onkeyup="" > -->
                   <form:input  class="input100"  path="address"/>
                    <span class="focus-input100"></span>
                    <span class="label-input100">Address</span>
                </div>
				
				<p style="color:red ;text-align: right;" id="warningpass"></p>
                <div class="flex-sb-m w-full p-t-3 p-b-32">
					<div class="contact100-form-checkbox">
						
						<input class="input-checkbox100" id="ckb1" type="checkbox"
							name="remember-me"> <label class="label-checkbox100"
							for="ckb1"> I accept the Quân shop </label>
					</div>
					
				 	<div>
						<a href="login.htm" class="txt1"> Login </a>
					</div>
				
				</div>
             
        
				<p id="returnRegistration" style="color:red; text-align:right;font-size:18px;">
				<%= request.getAttribute("msg") != null?request.getAttribute("msg"):" " %>
				</p>
                <div class="container-login100-form-btn">
                <!--      <button class="login100-form-btn" >
                        Ok
                    </button-->
                    
                    <input class="login100-form-btn" type="submit" value="OK">
                </div>
              
				</form:form>
            
        </div>

</div>
	<script >
		function ValidayRegistration(){
			var password = document.formRegistration.pass.value;
			var confirmpass = document.formRegistration.confirmpass.value;
			
			if(password != confirmpass){
			//	document.getElementById("returnRegistration").innerHTML="";
				document.getElementById("warningpass").innerHTML="Password nhập lại không đúng";
				return false;
			
			}
			else
			{
				//document.getElementById("returnRegistration").innerHTML="";
				document.getElementById("warningpass").innerHTML="";
			}
			
		
			
		}
	</script>
	<script>
		function Registrationagain(){
			var name = document.formRegistration.name.value;
			var email = document.formRegistration.email.value;
			var password = document.formRegistration.pass.value;
			var confirmpass = document.formRegistration.confirmpass.value;
			var a="";
			if(document.getElementById("").value != ""){
					if (name != a || email != a || password != a || confirmpass != a){
							document.getElementById("returnRegistration").innerHTML="";
					}
			}
		}
	</script>

	
	<script src="FE/FElogin/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="FE/FElogin/vendor/animsition/js/animsition.min.js"></script>
	<script src="FE/FElogin/vendor/bootstrap/js/popper.js"></script>
	<script src="FE/FElogin/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="FE/FElogin/vendor/select2/select2.min.js"></script>
	<script src="FE/FElogin/vendor/daterangepicker/moment.min.js"></script>
	<script src="FE/FElogin/vendor/daterangepicker/daterangepicker.js"></script>
	<script src="FE/FElogin/vendor/countdowntime/countdowntime.js"></script>
	<script src="FE/FElogin/js/main.js"></script>
</body>
</html>