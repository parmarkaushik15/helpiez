<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="com.kaushik.helpiez.client.model.EventClientModel"%>
<%@page import="com.kaushik.helpiez.client.model.NgoClientModel"%>
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
<%
String lat = (String) request.getParameter("lat");
String longi = (String) request.getParameter("longi");
%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"></script> 
<script src="<c:url value="/resources/js/bootstrap.js"/>"> </script>
<script src="<c:url value="/resources/js/modernizr.custom.js"/>"/>"></script>
<script src="<c:url value="/resources/js/move-top.js"/>"></script>
<script src="<c:url value="/resources/js/easing.js"/>"></script>
<script src="<c:url value="/resources/js/country.js"/>" ></script>

<script src="http://maps.google.com/maps/api/js?key=AIzaSyByA4d2YpcQrVwqYlsv2fRcx_gTbxMi5lQ&sensor=true"></script>
<script>
var myCenter=new google.maps.LatLng(<%=lat%>,<%=longi%>);
function initialize()
{
var mapProp = {
  center:myCenter,
  zoom:15,
  mapTypeId:google.maps.MapTypeId.ROADMAP
  };

var map=new google.maps.Map(document.getElementById("map"),mapProp);

var marker=new google.maps.Marker({
  position:myCenter,
  animation:google.maps.Animation.BOUNCE
  });

marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<% 
List<NgoClientModel> ngoClientModels = null;
List<EventClientModel> eventClientModels = null;

ngoClientModels = (List<NgoClientModel>) request.getAttribute("ngoList");
eventClientModels = (List<EventClientModel>) request.getAttribute("eventList");

%>

<body class="cbp-spmenu-push" onload="showlocation();">
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
					<form action="userLoginDataController" method="post">
						<input type="email" placeholder="Email Id" required="" name="loginEmailId">
						<input type="password" placeholder="Password" required="" name="loginPassword">
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

<!--
	<div id="helpz" class="top-header">
    	<div class="container">
        	<div class="col-lg-9">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
                <div class="imagesize">
                    <img src="images/Helpiez-Logo.png" class="img-responsive"  />
                </div>
            </div>
            <div class="col-lg-3">
            	
<ul class="nav navbar-nav">
<li>
		           <button type="button" class="btn btn-info">Register</button>
		        </li>
<li>
		           <button type="button" class="btn btn-danger">Login</button>
		        </li>
<li class="dropdown">
           <a href="#" class=" btn btn-default" data-toggle="dropdown"><i class="fa fa-tasks"></i></a>
		            <ul class="dropdown-menu">
			            <li><a href="">Jobs by Location</a></li>
			            <li><a href="">Jobs by Functional Area</a></li>
			            <li><a href="">Jobs by Roles</a></li>
			            <li><a href="">Jobs by Skills</a></li>
						<li><a href="">Jobs by Employers</a></li>
		            </ul>
		        </li>

</ul>
 </div>
           
            <div class="clearfix"></div>
        </div>
    </div>
   <section class="button">
		<button id="showLeftPush"><img src="images/menu-icon.png" alt="" class="img-responsive"></button>
    </section>
    <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
		<a href="index.html" class="active"><i class="fa fa-home"></i>&nbsp;&nbsp;Home</a>
        <a href="#"><i class="fa fa-user"></i>&nbsp;&nbsp;About Us</a>
        <a href="#"><i class="fa fa-file-text-o"></i>&nbsp;&nbsp;Contact Us</a>
        
	</nav>
    <script src="js/classie.js"></script>
	<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				showRightPush = document.getElementById( 'showRightPush' ),
				body = document.body;

			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showRightPush' );
			};

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
				if( button !== 'showRightPush' ) {
					classie.toggle( showRightPush, 'disabled' );
				}
			}
		</script>-->
  <%--   <div class="row banner-bottom">
    			<div id="myCarousel" class="carousel slide" data-ride="carousel">
            	<div class="carousel-caption">
                	<div class="col-lg-7">
                    	<div id="searchpanel" class="clearfix">
                        	<form>
                                <h1><b class="dif">Search </b>NGOs In World</h1>
                                  <div class="form-group row">
                                    <div class="col-lg-12">
                                    
                                        <select class="txtwidth4" id="country" onchange="print_state('state', this.selectedIndex);">
                                        </select>
                                    
                                        <select class="txtwidth3" id="state">
                                        <option value="Select State">Select State</option>
                                        </select>
                                    
                                    </div>
                                </div>
<div class="form-group row">
                                
                                    <div class="col-lg-12">
                                        <input type="text" class="text txtwidth12" placeholder=" " value="Enter Keyword(s)" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Skills(s)';}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-lg-12">
                                    
                                        
                                    
                                        <button class="btn btn-danger btn-search"><i class="fa fa-search"></i>&nbsp;SEARCH</button>
                                    </div>
                                </div>
                            </form>
						</div>
                    </div>
                    <div class="col-lg-5">
                    	<div id="sidepanel" class="clearfix">
                        	<div id="map" style="width:100%; height:200px;" class="map"></div>

							</div>
                        </div>
                    </div>
                </div>
                <div class="clearfix bottom-btn">
					<a href="#welcome" class=""><i class="fa fa-angle-double-down fa-4x"></i></a>
               </div>
                <div class="carousel-inner" role="listbox">
                  <div class="item active">
                     <img class="img-responsive" src="<c:url value="/resources/images/header-bg.jpg"/>"/>
                  </div>
                  <div class="item">
                     <img class="img-responsive" src="<c:url value="/resources/images/header-bg.jpg" />"/>
                  </div>
               </div>
               <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a>
            </div>
    </div> --%>
    
    <div class="row banner-bottom">
    			<div id="myCarousel" class="carousel slide" data-ride="carousel">
            	<div class="carousel-caption">
                	<div class="col-lg-7">
                    	<div id="searchpanel" class="clearfix">
                        	<form>
                                <h1><b class="dif">Search </b>NGOs In World</h1>
                                  <div class="form-group row">
                                    <div class="col-lg-12">
                                    
                                        <select class="txtwidth4" id="country" onchange="print_state('state', this.selectedIndex);">
                                        </select>
                                    
                                        <select class="txtwidth3" id="state">
                                        <option value="Select State">Select State</option>
                                        </select>
                                    
                                    </div>
                                </div>
<div class="form-group row">
                                
                                    <div class="col-lg-12">
                                        <input type="text" class="text txtwidth12" placeholder=" " value="Enter Keyword(s)" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Skills(s)';}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-lg-12">
                                    
                                        
                                    
                                        <button class="btn btn-danger btn-search"><i class="fa fa-search"></i>&nbsp;SEARCH</button>
                                    </div>
                                </div>
                            </form>
						</div>
                    </div>
                    <div class="col-lg-5">
                    	<div id="sidepanel" class="clearfix">
                        	<div class="map" id="map" style="height:250px;">
                        	</div>
                        </div>
                    </div>
                </div>
                <div class="clearfix bottom-btn">
					<a href="#welcome" class=""><i class="fa fa-angle-double-down fa-4x"></i></a>
               </div>
                <div class="carousel-inner" role="listbox">
                  <div class="item active">
                     <img class="img-responsive" src="<c:url value="/resources/images/header-bg.jpg"/>"/>
                  </div>
                  <div class="item">
                     <img class="img-responsive" src="<c:url value="/resources/images/header-bg.jpg"/>"/>
                  </div>
               </div>
               <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a>
            </div>
    </div>
    
    <a class="welcome" id="welcome"></a>
    <div class="row content">
    	<div class="container">
        	<h1 class="head main-head">Why Helpiez???</h1>
            <div class="whyhelpz">
            <div class="row">
            	<div class="col-lg-4">
                	<div class="box">
                    <img src="<c:url value="/resources/images/1.png"/>" class="img-responsive txtwidth12" />
                    <h4>
                    	Connect with the NGOs which work for the causes you care about
                    </h4>
                    </div>
                </div>
                <div class="col-lg-4">
                	<div class="box">
                    <img src="<c:url value="/resources/images/2.png"/>" class="img-responsive txtwidth12" />
                    <h4>
                    	See detailed information of volunteering opportunities, events and NGOs
                    </h4>
                    </div>
                </div>
                <div class="col-lg-4">
                	<div class="box">
                    <img src="<c:url value="/resources/images/3.png"/>" class="img-responsive txtwidth12" />
                    <h4>
                    	Filter the NGOs according to region and area of work
                    </h4>
                    </div>
                </div>
            </div>
            <div class="row">
            	<div class="col-lg-4">
                	<div class="box">
                    <img src="<c:url value="/resources/images/4.png"/>" class="img-responsive txtwidth12" />
                    <h4>
                    	Follow the NGOs and causes for regular updates and reviews
                    </h4>
                    </div>
                </div>
                <div class="col-lg-4">
                	<div class="box">
                    <img src="<c:url value="/resources/images/5.png"/>" class="img-responsive txtwidth12" />
                    <h4>
                    	Create your own social presence by writing reliable reviews, ratings and experience
                    </h4>
                    </div>
                </div>
                <div class="col-lg-4">
                	<div class="box">
                    <img src="<c:url value="/resources/images/6.png"/>" class="img-responsive txtwidth12" />
                    <h4>
                    	Share your philanthropic journey with friends and relatives
                    </h4>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
    <div class="row content ngolist">
    	<div class="container">
        	<h1 class="head main-head">NGO</h1>
        	<div class="whyhelpz">
            
            <a class="left carousel-control" href="#myCarousel1" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#myCarousel1" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a>
            	<div id="myCarousel1" class="carousel slide" data-ride="carousel">
                     <div class="carousel-inner" role="listbox">

					<%
					if(ngoClientModels != null || ngoClientModels.size()>0)
					{
						
						int size = ngoClientModels.size();
						if(size<=4)
						{
							%>
							<div class="item active">
							<%
							for(int i=0;i<size;i++)
							{
								NgoClientModel model = ngoClientModels.get(i);
								%>
									<div class="col-lg-3">
	                                    <div style="background-image:url(<%=model.getNgoImage() %>);" class="grupcard">
	                                    	<i class="fa fa-plus-circle"></i>
	                                        <h1><%=model.getNgoName() %></h1>
	                                    </div>
	                                </div>
								
								<%
							}
							%>
							</div>
							<%
						}
						else
						{
							int l = size/4;
							int index = 0;
							for(int i = 0; i<l;i++)
							{
								if(i==1)
								{
									%>
									<div class="item active">
									<%
									for(int j = 0;j<4;j++)
									{
										NgoClientModel model = ngoClientModels.get(index);
										index++;
										%>
										<div class="col-lg-3">
		                                    <div style="background-image:url(<%=model.getNgoImage() %>);" class="grupcard">
		                                    	<i class="fa fa-plus-circle"></i>
		                                        <h1><%=model.getNgoName() %></h1>
		                                    </div>
		                                </div>
										<%
									}
									%>
									</div>
									<%
								}
								else
								{
									%>
									<div class="item">
									<%
									for(int j = 0;j<4;j++)
									{
										NgoClientModel model = ngoClientModels.get(index);
										index++;
										%>
										<div class="col-lg-3">
		                                    <div style="background-image:url(<%=model.getNgoImage() %>);" class="grupcard">
		                                    	<i class="fa fa-plus-circle"></i>
		                                        <h1><%=model.getNgoName() %></h1>
		                                    </div>
		                                </div>
										<%
									}
									%>	
									</div>
									<%
								}
								
							}
						}
					}
					%>
                     </div>
                     
                </div>
            </div>
            
            
        </div>
    </div>
    
    
    <div class="row content upevent">
    	<div class="container">
        	<h1 class="head main-head">Upcoming Events</h1>
        	<div class="whyhelpz">
            
            <a class="left carousel-control" href="#myCarousel1" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#myCarousel1" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a>
            	<div id="myCarousel1" class="carousel slide" data-ride="carousel">
                     <div class="carousel-inner" role="listbox">
                        <div class="item active">
                        	
                                <div class="col-lg-4">
                                    <div style="background-image:url(images/1.png);" class="grupcard">
                                    	<i class="fa fa-plus-circle"></i>
                                        <h1>hello</h1>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div style="background-image:url(images/2.png);" class="grupcard">
                                    <i class="fa fa-plus-circle"></i>
                                        <h1>hello</h1>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div style="background-image:url(images/3.png);" class="grupcard">
                                    <i class="fa fa-plus-circle"></i>
                                        <h1>hello</h1>
                                    </div>
                                </div>
                            
                            
                        </div>
                         <div class="item ">
                        	
                            <div class="col-lg-4">
                            	<div style="background-image:url(images/2.png);" class="grupcard">
                                <i class="fa fa-plus-circle"></i>
                            		<h1>Hello</h1>
                                </div>
                            </div>
                            <div class="col-lg-4">
                            	<div style="background-image:url(images/3.png);" class="grupcard">
                                <i class="fa fa-plus-circle"></i>
                            		<h1>hello</h1>
                                </div>
                            </div>
                            <div class="col-lg-4">
                            	<div style="background-image:url(images/4.png);" class="grupcard">
                                <i class="fa fa-plus-circle"></i>
                            		<h1>hello</h1>
                                </div>
                            </div>
                        </div>
                        
                     </div>
                     
                </div>
            </div>
            
            
        </div>
    </div>
    <div class="row content testimonials">
    	<div class="container">
        	<div class="wmuSlider example1">
            	<h1 class="head main-head testh3">Testimonials</h1>
            	<div id="myCarousel2" class="carousel slide" data-ride="carousel">
                	<div class="carousel-inner" role="listbox">
                        <div class="item active">
                        	<div class="col-lg-2">
                            	<img src="images/6.png" class="img-responsive img-circle" />
                            </div>
                            <div class="col-lg-10">
                            	<p>Garcinia cambogia is one of the main 
										components in one of the best-selling 
										supplemental weight loss products, 
										Hydroxycut., and researchers have 
										concluded that "the evidence for G. 
										cambogia is not compelling.</p>
                                        <h4><a href="#">annette Doe</a> | Abc Company</h4>
                            </div>
                        </div>
                        <div class="item">
                        	<div class="col-lg-2">
                            	<img src="images/3.png" class="img-responsive img-circle" />
                            </div>
                            <div class="col-lg-10">
                            	<p>Garcinia cambogia is one of the main 
										components in one of the best-selling 
										supplemental weight loss products, 
										Hydroxycut., and researchers have 
										concluded that "the evidence for G. 
										cambogia is not compelling.</p>
                                        <h4><a href="#">annette Doe</a> | Abc Company</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content contactus">
    	<div class="container">
        	<h1 class="head main-head">Contact Us</h1>
            <div id="contactform">
           	<form>
            	<div class="form-group row">
                        <div class="col-lg-6"><input class="form-control" placeholder="Your Name" type="text" required="required" name="" id=""/></div>
                        <div class="col-lg-6"><input class="form-control" placeholder="Your Email" type="email" required="required" name="" id=""/></div>
                </div>
               	<div class="form-group row">
                        <div class="col-lg-6"><input class="form-control" placeholder="Your Contact Number" type="text" required="required" name="" id=""/></div>
                         </div>
               	<div class="form-group row">
                        <div class="col-lg-12">
                        <textarea rows="10" placeholder="Your Message*" required="required" name="" id=""></textarea>
                        </div>
                 </div>
                 <div class="form-group">
                 	<div class="contactbutton">
                 	<button type="submit" class="btn btn-info"><i class="fa fa-paper-plane"></i>&nbsp;&nbsp;Send Message</button>
                    </div>
                 </div>
            </form>
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
         $(window).scroll(function() {
             if ($(this).scrollTop() > 20) {
                 $('nav').addClass("sticky");
         
             } else {
                 $('nav').removeClass("sticky");
             }
         });
      </script>
</body>
</html>