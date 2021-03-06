<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>  
  <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ShopMax</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">

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



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<body style="background-color: #666666;">

	<div class="limiter">

		<div class="wrap-login100">
			<form:form action="logincontroller.htm" modelAttribute="member" method="POST" class="login100-form validate-form">
				<span class="login100-form-title p-b-43"> Logins </span>


				<div class="wrap-input100 validate-input"
					data-validate="Valid email is required: ex@abc.xyz">
<!-- 					<input id="email" class="input100" type="text" name="email">  -->
					<form:input  id="email" class="input100" type="text" path="email"/>
					<span class="focus-input100"></span> <span class="label-input100">Email</span>
				</div>
				<p id="warningemail" style=";color:red"></p>

				<div class="wrap-input100 validate-input"
					data-validate="Password is required">
<!-- 					<input id="pass" class="input100" type="password" name="pass">  -->
					<form:input  id="email" class="input100" type="password" path="password"/>
					<span class="focus-input100"></span> <span class="label-input100">Password</span>
				</div>
				<p id="warningpass" style=";color:red"></p>
				<div class="flex-sb-m w-full p-t-3 p-b-32">
					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox"
							name="remember-me"> <label class="label-checkbox100"
							for="ckb1"> Remember me </label>
					</div>

					<div>
						<a href="registration.htm" class="txt1"> Registration </a>
					</div>
				</div>
				<p style="color:red ;text-align: right;"><%= request.getAttribute("msg") != null?request.getAttribute("msg"):" " %></p>

				<div class="container-login100-form-btn">
					<button class="login100-form-btn" onclick="validateLogin()">Login</button>
				</div>

				<div class="text-center p-t-46 p-b-20">
					<span class="txt2"> or sign up using </span>
				</div>

				<div class="login100-form-social flex-c-m">
					<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
						<i class="fa fa-facebook-f" aria-hidden="true"></i>
					</a> <a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
						<i class="fa fa-twitter" aria-hidden="true"></i>
					</a>
				</div>
			</form:form>


		</div>

	</div>

	<script>
	function validateLogin(){
		var email, pass;
		var warningemail, warningpass;
		email = document.getElementById("email").value;
		pass = 	document.getElementById("pass").value;
		if(email == ""){
			warningemail="Email is incorrect";
			document.getElementById("warningemail").innerHTML = warningemail;
		}else{
			document.getElementById("warningemail").innerHTML = "";
		}
		
		if(pass == ""){
			warningpass="Pass is incorrect";
			document.getElementById("warningpass").innerHTML = warningpass;
		}else{
			document.getElementById("warningpass").innerHTML = "";
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