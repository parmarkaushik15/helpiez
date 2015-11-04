<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.Iterator"%>
<%@page import="com.kaushik.helpiez.client.model.NgoClientCategory"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Helpiez</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />"/>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />"/>
<link rel="stylesheet" href="<c:url value="/resources/css/swipebox.css" />"/>
<link rel="stylesheet" href="<c:url value="/resources/css/component.css" />"/>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script> 
<script src="<c:url value="/resources/js/bootstrap.js"/>"> </script>
<script src="<c:url value="/resources/js/modernizr.custom.js"/>"/>"></script>
<script src="<c:url value="/resources/js/move-top.js"/>"></script>
<script src="<c:url value="/resources/js/easing.js"/>"></script>
<script src="<c:url value="/resources/js/country.js"/>" ></script>
</head>
<%
List<NgoClientCategory> ngoClientCategories = null;
ngoClientCategories = (List<NgoClientCategory>) request.getAttribute("categoryList");

%>
<body class="cbp-spmenu-push">
<div id="helpz">
<nav class="navbar navbar-default" role="navigation">
	<div class="container">

		
    <div class="navbar-header">
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="/helpiez/"><img src="<c:url value="/resources/images/Helpiez-logo.png"/>" class="imagesize" alt=""/></a>
	    </div>
	    <!--/.navbar-header-->
	    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;">
	        <div id="menu">
        	
			<ul class="nav navbar-nav">
		        <li>
		            <a href="registerDataController" class="btn btn-primary">Register</a>
		           
		        </li>
				<li>
		            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#loginform">Login</a>
		           
		        </li>
				<li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-tasks"></i></a>
		            <ul class="dropdown-menu">
			            <li><a href="jobs.html">Walk-ins</a></li>
			            <li><a href="jobs.html">Bpo Jobs</a></li>
			            <li><a href="jobs.html">Teaching Jobs</a></li>
			            <li><a href="jobs.html">Diploma Jobs</a></li>
			            <li><a href="jobs.html">Tech Support</a></li>
			            <li><a href="jobs.html">Finance Jobs</a></li>
			            <li><a href="jobs.html">Part time Jobs</a></li>
			            <li><a href="jobs.html">Health Care</a></li>
			            <li><a href="jobs.html">Hospitality</a></li>
			            <li><a href="jobs.html">Internships</a></li>
			            <li><a href="jobs.html">Research Jobs</a></li>
			            <li><a href="jobs.html">Defence Jobs</a></li>
		            </ul>
		        </li>
			</ul>
			</div>
			
			<div class="modal fade" id="loginform" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				 <div class="modal-dialog">
					<div class="modal-content">
					   <div class="modal-header">
						  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						  <h4 class="modal-title" id="myModalLabel">Login</h4>
					   </div>
					   <div class="modal-body">
						  <div class="well-lg">
							 <div class="login-info">
                    	<div class="main-pos">
                        <h3><i class="fa fa-user"></i></h3>
                        </div>
                        <div class="main-info1">
					<h3>Sign In</h3>
					<form>
						<input type="text" placeholder="Username" required=" ">
						<input type="password" placeholder="Password" required=" ">
						<input type="submit" value="Login">
					</form>
					<p>Forgot your password? <a href="#">Click Here</a></p>
				</div>
                    </div>
						  </div>
					   </div>
					</div>
				 </div>
			  </div>
			
		</div>
	    <div class="clearfix"> </div>
	  </div>
	  
	    <!--/.navbar-collapse-->
	</nav>

</div>
	<div class="row banner">
    </div>
    <div class="row content contactus">
    	<div class="container">
        	<h1 class="head main-head">Login</h1>
            <div class="row register">
            	<div class="col-lg-3">
                	
                </div>
                <div class="col-lg-6">
	                <div class="login-info">
                    	
                    	<div class="main-info1">
                       		 <h3>Login</h3>
                        	<form action="userLoginDataController" method="post">
                        	<c:if test="${not empty error}">
							        	<div class="alert alert-danger fade in">
											<a href="#" class="close" data-dismiss="alert">&times;</a>
											<h4><span class="cut-icon-alert"></span><strong>Error!</strong>&nbsp;<c:out value="${error}" /></h4>
										</div>	
							        </c:if>
							        <c:if test="${not empty success}">
							        	<div class="alert alert-success fade in">
											<a href="#" class="close" data-dismiss="alert">&times;</a>
											<h4><span class="icomoon-icon-thumbs-up-2"></span><strong>WOW ! </strong>&nbsp;<c:out value="${success}" /></h4>
										</div>	
							        </c:if>
						<input type="email" placeholder="Email Id" required="" name="loginEmailId">
						<input type="password" placeholder="Password" required="" name="loginPassword">
						<input type="submit" value="Login">
					</form>
					<p>Forgot your password? <a href="#">Click Here</a></p>
                         </div>
                    </div>
               	</div>
				<div class="col-lg-3">
                	
                </div>
			</div>
        </div>
    </div>
    <div class="row footer">
	<div class="container">
    	 <div class="col-md-3 border-r">
         	<h4 class="media-heading">Navigate</h4>
                  <ul class="list-unstyled">
                     <li><a href="about.html">About Us</a>
                     </li>
                     <li><a href="partners.php">Partner</a>
                     </li>
                     <li><a href="termsconditions.php">Terms & Conditions</a>
                     </li>
                     <li><a href="sitemap.php">Sitemap</a>
                     </li>
                     <li><a href="contact.html">Contact Us</a>
                     </li>
                  </ul>
               </div>
               <div class="col-md-3 border-r">
               <h4 class="media-heading">Accounts</h4>
                  <ul class="list-unstyled">
                     <li><a href="signin.php">Log In / Sign Up</a>
                     </li>
                     <li><a href="products.php">Products</a>
                     </li>
                     <li><a href="faqs.php">FAQ's</a>
                     </li>
                     <li><a href="sitemap.php">WorkShop</a>
                     </li>
                  </ul>
               </div>
                <div class="col-md-3 border-r">
                <h4 class="media-heading">Sign up for our newsletter</h4>
                  <form>
                        <input type="text" class="form-control" placeholder="Enter your email">
                        <button type="button" class="btn red">Subscribe now!</button>
                    </form>
               </div>
               <div class="col-md-3">
                  <h4 class="media-heading">Join With Us</h4>
                  <ul class="list-inline social">
                     <li><a href="#"><i class="fa fa-facebook"></i></a>
                     </li>
                     <li><a href="#"><i class="fa fa-twitter"></i></a>
                     </li>
                     <li><a href="#"><i class="fa fa-linkedin"></i></a>
                     </li>
                     <li><a href="#"><i class="fa fa-youtube"></i></a>
                     </li>
                     <li><a href="#"><i class="fa fa-google-plus"></i></a>
                     </li>
                  </ul>
               </div>
    </div>
</div>

<script>
	print_country('country');
</script>
<script>
function checkNgoEmail(name) {
    $.ajax({
    	type: "POST",
		url : 'checkNgoEmailController',
		data: "emailId=" + name,
        success : function(data) {
        	var result = data;
        	if(result == "1")
        	{
            	document.getElementById("ngoEmail").style.border="1px solid red";
            	document.getElementById("ngoEmail").style.color="red";
            	
            	document.getElementById("ngoEmail").focus();
        	}
        	else
        	{
        		document.getElementById("ngoEmail").style.border="1px solid #999";
        		document.getElementById("ngoEmail").style.color="#999";
        	}
        }
    });
}
         $(window).scroll(function() {
             if ($(this).scrollTop() > 20) {
                 $('nav').addClass("sticky");
         
             } else {
                 $('nav').removeClass("sticky");
             }
         });
      </script>
      <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyByA4d2YpcQrVwqYlsv2fRcx_gTbxMi5lQ&sensor=false"></script>
    <script type="text/javascript">
    window.setTimeout(function() {
        $(".alert-danger").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove(); 
        });
    }, 10000);
    window.setTimeout(function() {
        $(".alert-success").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove(); 
        });
    }, 10000);
        function GetLocation(add) {
            var geocoder = new google.maps.Geocoder();
            var address = add;
            geocoder.geocode({ 'address': address }, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    var latitude = results[0].geometry.location.lat();
                    var longitude = results[0].geometry.location.lng();
                    document.getElementById("ngoLocationLongitude").value = longitude;
                    document.getElementById("ngoLocationLatitude").value = latitude;
                } else {
                	
                }
            });
        };
        
    </script>
</body>
</html>