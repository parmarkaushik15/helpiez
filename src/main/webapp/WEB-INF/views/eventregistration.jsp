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
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">

								<h4 class="panel-title">
									<i class="s16  icomoon-icon-library"></i> <span>EVENT REGISTRATION</span>
								</h4>
							</div>
							<div class="panel-body" style="padding:50px">
								<div class="col-lg-8">
								<div class="row">
<form:form action="eventDataRegistrationController" method="post" class="form-horizontal">
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Title</label>
			<div class="col-lg-4 col-md-3">
				<input type="text" value="<%=pojo.getNgoId() %>" name="ngoId"  />
				<input id="" type="text" title="Enter Event Title" name="eventTitle" class="form-control" placeholder="Enter Event Title....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Logo</label>
			<div class="col-lg-4 col-md-3">
				<input id="" type="file" name="eventLogo" class="form-control" title="Enter Event Logo" placeholder="Enter Event Logo....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Description</label>
			<div class="col-lg-4 col-md-3">
				<textarea id="" title="Enter Description" name="eventDescription" class="form-control" placeholder="Enter Description....." required="required"></textarea>
 			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Date</label>
			<div class="col-lg-4 col-md-3">
				<input id="" type="date" title="Enter Date and Time" name="eventDate" class="form-control" placeholder="Enter Event Date & Time....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Organizer Name</label>
			<div class="col-lg-4 col-md-3">
				<input id="" type="text" title="Enter Event Organizer Name" name="eventOrganizerName" class="form-control" placeholder="Enter Event Organizer Name....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Organizer Email</label>
			<div class="col-lg-4 col-md-3">
				<input id="" type="text" title="Enter Organizer Email" name="eventOrganizerEmail" class="form-control" placeholder="Enter Event Organizer Email....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Organizer Contact</label>
			<div class="col-lg-4 col-md-3">
				<input id="" type="text" title="Enter Event Organizer Contact" name="eventOrganizerContact" class="form-control" placeholder="Enter Event Organizer Contact....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Alternative Contact</label>
			<div class="col-lg-4 col-md-3">
				<input id="text1" type="text" title="Enter Event Alternative Contact" name="eventAlternativeContact" class="form-control" placeholder="Enter Event Alternative Contact....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Location Address</label>
			<div class="col-lg-4 col-md-3">
				<textarea title="Event Location Address" id="adddress" name="eventAddress" class="form-control" placeholder="Enter Event Location Address....." required="required"></textarea>
 			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Address Country</label>
			<div class="col-lg-4 col-md-3">
				<select class="form-control" name="eventAddressCountry" id="country" onchange="print_state('state', this.selectedIndex);">
				
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Address State</label>
			<div class="col-lg-4 col-md-3">
				<select class="form-control" name="eventAddressState" id="state" > 
				
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Address City</label>
			<div class="col-lg-4 col-md-3">
				<input  type="text" title="Event Address City" name="eventAddressCity" id="city" class="form-control" placeholder="Enter Event Address City....." required="required" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label class="col-lg-3 col-md-4 form-label">Event Address Pincode</label>
			<div class="col-lg-4 col-md-3">
				<input type="text" title="Event Address Pincode" id="pincode" name="eventAddressPincode" class="form-control" placeholder="Enter Event Address Pincode....." required="required" onblur="GetLocation(this.value);"/>
				<input type="hidden" name="eventAddressLongitude" class="form-control" id="longitude"/>
				<input type="hidden" name="eventAddressLatitude" class="form-control" id="latitude"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
	        <div class="col-lg-offset-3">
	            <button class="btn btn-primary mr5 mb10" type="submit" ><i class="fa fa-plus mr5"></i>Add Event</button>
	        </div>
        </div>
    </div>
</form:form></div>
<div class="col-lg-4">
	<div class="datanotification">
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
     </div> 
</div>
								</div>
							
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
function GetLocation(add) {
    var geocoder = new google.maps.Geocoder();
    var address1 = document.getElementById("address").value;
    var city = document.getElementById("city").value;
    var state = document.getElementById("state").value;
    var country = document.getElementById("country").value
    var address = address1+","+city+","+state+","+country;
    alert(address);
    geocoder.geocode({ 'address': address }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var latitude = results[0].geometry.location.lat();
            var longitude = results[0].geometry.location.lng();
            alert(latitude+"--"+longitude);
            document.getElementById("longitude").value = longitude;
            document.getElementById("latitude").value = latitude;
        } else {
        	
        }
    });
};
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
	<script src="<c:url value="/resources/ngopanel/js/pages/forms-basic.js" />"></script>
<script src="<c:url value="/resources/js/country.js"/>" ></script>
	<script>
	print_country('country');
</script>
	
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
	</script>
	
</body>

</html>