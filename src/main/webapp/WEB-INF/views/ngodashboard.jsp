<%@page import="com.kaushik.helpiez.database.NgoRegistrationPojo"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<title>Helpiez</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="author" content="Kaushik Parmar" />
<meta name="description" content="Helpiez." />
<meta name="keywords" content="" />
<meta name="application-name" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Droid+Sans:400,700"
	rel="stylesheet" type="text/css">


<link href="<c:url value="/resources/ngopanel/css/icons.css" />" rel="stylesheet" />
<link href="<c:url value="/resources/ngopanel/css/bootstrap.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/ngopanel/css/plugins.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/ngopanel/css/main.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/ngopanel/css/custom.css"/>" rel="stylesheet" />

<link
	href="<c:url value="/resources/ngopanel/plugins/misc/qtip/jquery.qtip.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/ngopanel/plugins/forms/uniform/uniform.default.css"/>"
	type="text/css" rel="stylesheet" />

<meta name="msapplication-TileColor" content="#3399cc" />

</head>

<%
	NgoRegistrationPojo pojo = null;
	pojo = (NgoRegistrationPojo) session.getAttribute("ngoDetails");
%>

<body>
	<div id="header">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<img class="img-responsive" alt=""  src="/helpiez/resources/images/Helpiez-logo.png" style="width: 60%;padding: 20px;">
			</div>
			<div id="navbar-no-collapse" class="navbar-no-collapse">
				<ul class="nav navbar-right usernav">
					<li class="dropdown"><a href="#"
						class="dropdown-toggle avatar" data-toggle="dropdown"> <img
							src="<%=pojo.getNgoImageLogo() %>" alt="" class="image" />
							<span class="txt"><%=pojo.getNgoEmailId() %></span>
							<b class="caret"></b>
					</a>
						<ul class="dropdown-menu right">
							<li class="menu">
								<ul>
									<li><a href="ngoEditProfileController"><i class="s16 icomoon-icon-user-plus"></i>Edit
											profile</a></li>
									<li><a href="ngoChangePasswordController"><i class="s16 icomoon-icon-key"></i>Change
											Password</a></li>
								</ul>
							</li>
						</ul></li>
					<li><a href="login.html"><i class="s16 icomoon-icon-exit"></i><span
							class="txt"> Logout</span></a></li>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</nav>
		<!-- /navbar -->
	</div>
	<!-- / #header -->
	<div id="wrapper">
		<!-- #wrapper -->
		<!--Sidebar background-->
		<div id="sidebarbg" class="hidden-lg hidden-md hidden-sm hidden-xs"></div>
		<!--Sidebar content-->
		<div id="sidebar"
			class="page-sidebar hidden-lg hidden-md hidden-sm hidden-xs">
			<div class="shortcuts">
				<ul>
					<li><a href="#" title="Support section" class="tip"><i
							class="s24 icomoon-icon-support"></i></a></li>
					<li><a href="#" title="Database backup" class="tip"><i
							class="s24 icomoon-icon-database"></i></a></li>
					<li><a href="#" title="Sales statistics" class="tip"><i
							class="s24 icomoon-icon-pie-2"></i></a></li>
					<li><a href="#" title="Write post" class="tip"><i
							class="s24 icomoon-icon-pencil"></i></a></li>
				</ul>
			</div>
			
			
			<!-- End search -->
			<!-- Start .sidebar-inner -->
			<div class="sidebar-inner">
				<!-- Start .sidebar-scrollarea -->
				<div class="sidebar-scrollarea">
					<div class="sidenav">
						<div class="sidebar-widget mb0">
							<h6 class="title mb0">Navigation</h6>
						</div>
						<!-- End .sidenav-widget -->
						<div class="mainnav">
							<ul>
								<li><a href="getNgoAllDetailController"><span
										class="icon16 icomoon-icon-home"></span>Home</a> 
								<li><a href="eventRegistrationController"><span
										class="icon16  icomoon-icon-newspaper"></span>Event Registration</a> 
							</ul>
						</div>
					</div>
				</div>
				<!-- End .sidebar-scrollarea -->
			</div>
			<!-- End .sidebar-inner -->
		</div>

		<!--Body content-->
		<div id="content" class="page-content clearfix">
			<div class="contentwrapper">
				<!--Content wrapper-->
				<div class="heading">
					<!--  .heading-->
					<h3 style="text-transform: uppercase;">&nbsp;Home
						Page
					</h3>

				</div>
				<!-- End  / heading-s>-->
				
				<div class="row">
                        <!-- .row -->
                        <div class="col-md-8">
                            <!-- col-md-8 start here -->
                            <div class="row">
                                <!-- .row start -->
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <!-- .col-md-3 -->
                                    <a href="#" title="I`m with gradient" class="stats-btn tipB mb20">
                                        <i class="icon icomoon-icon-users"></i>
                                        <span class="txt">Members</span>
                                        <span class="notification">5</span>
                                    </a>
                                </div>
                                <!-- / .col-md-3 -->
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                    <!-- .col-md-3 -->
                                    <a href="#" class="stats-btn mb20">
                                        <i class="icon icomoon-icon-support"></i>
                                        <span class="txt">Events</span>
                                        <span class="notification blue">12</span>
                                    </a>
                                </div>
                                <!-- / .col-md-3 -->
                                
                                <!-- / .col-md-3 -->
                            </div>
                            <!-- / .row -->
                        </div>
                        <!-- col-md-8 end here -->
                        <div class="col-md-4">
                           </div>
                        <!-- col-md-4 end here -->
                    </div>
                    
				
				
				
				
				<div class="row">

					<div class="col-md-8">
						<div class="panel panel-default">
							<div class="panel-heading">

								<h4 class="panel-title">
									<i class="s16  icomoon-icon-library"></i> <span>MAP VIEW</span>
								</h4>
							</div>
							<div class="panel-body">
							<div id="map" style="width:100%; height:400px;"></div>

							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-default">
							<div class="panel-heading">

								<h4 class="panel-title">
									<i class="s16 icomoon-icon-vcard"></i> <span>PROFILE</span>
								</h4>
							</div>
							<div class="panel-body">

								<form class="form-horizontal" action="#" role="form">
									<div class="form-group">
										<div class="col-lg-3">
											<img src="<%=pojo.getNgoImageLogo() %>" alt=""
												style="width: 70px; height: 70px;" />
										</div>
										<div class="col-lg-9">
											Welcome,<%=pojo.getNgoName() %>

										</div>

									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-3 " for="focus">Email :</label>
										<div class="col-lg-9">
											<a href="mailto:<%=pojo.getNgoEmailId()%>"><%=pojo.getNgoEmailId()%></a>
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-3 " for="focus">Contact:</label>
										<div class="col-lg-9">
										<%=pojo.getNgoContactNumber()%>
										</div>
									</div>
									
								</form>

							</div>
						</div>
					</div>

				</div>




				<!-- End .row -->
			</div>
			<!-- End contentwrapper -->
		</div>

	</div>
	<!-- / #wrapper -->
	<!-- Back to top -->
	<div id="back-to-top">
		<a href="#">Back to Top</a>
	</div>

	<script
		src="<c:url value="/resources/ngopanel/plugins/core/pace/pace.min.js" />"></script>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="<c:url value="/resources/ngopanel/js/libs/jquery-2.1.1.min.js" />">\x3C/script>')
	</script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="<c:url value="/resources/ngopanel/js/libs/jquery-ui-1.10.4.min.js" />">\x3C/script>')
	</script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="<c:url value="/resources/ngopanel/js/libs/jquery-migrate-1.2.1.min.js" />">\x3C/script>')
	</script>
	

<script src="http://maps.google.com/maps/api/js?key=AIzaSyByA4d2YpcQrVwqYlsv2fRcx_gTbxMi5lQ&sensor=true"></script>
<script>
var myCenter=new google.maps.LatLng(<%=pojo.getNgoLocationLatitude()%>,<%=pojo.getNgoLocationLongitude()%>);
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

	<script src="<c:url value="/resources/ngopanel/js/bootstrap/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/ngopanel/js/libs/modernizr.custom.js" />"></script>
	<script src="<c:url value="/resources/ngopanel/js/jRespond.min.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/core/slimscroll/jquery.slimscroll.min.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/core/slimscroll/jquery.slimscroll.horizontal.min.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/core/fastclick/fastclick.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/core/velocity/jquery.velocity.min.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/core/quicksearch/jquery.quicksearch.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/ui/bootbox/bootbox.js" />"></script>
	<script
		src="<c:url value="/resources/ngopanel/plugins/charts/sparklines/jquery.sparkline.js" />"></script>
	<script src="<c:url value="/resources/ngopanel/js/jquery.supr.js" />"></script>
	<script src="<c:url value="/resources/ngopanel/js/main.js" />"></script>
	<script src="<c:url value="/resources/ngopanel/js/pages/blank.js" />"></script>
	
	
	
</body>

</html>