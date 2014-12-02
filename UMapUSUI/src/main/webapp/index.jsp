<%@page import="com.sun.jersey.server.impl.container.servlet.Include"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>UMapUS</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Place favicon.ico and apple-touch-icon(s) in the root directory -->

<link rel="stylesheet" href="./css/vendor/normalize.css">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/vendor/bootstrap-theme.css">
<link rel="stylesheet" href="./css/vendor/bootstrap.min.css">
<link rel="stylesheet" href="./css/vendor/bootstrap-select.min.css">
<link rel="stylesheet" href="css/vendor/animate.css">
<script src="js/vendor/modernizr-2.7.1.min.js"></script>
<script src="js/Validators.js" type="text/javascript"></script>
<script src="js/Messages.js" type="text/javascript"></script>
</head>
<body>

	<%@ include file="./WEB-INF/SubComponents/IntroPage/Navigation.jsp"%>
	<%@ include
		file="./WEB-INF/SubComponents/IntroPage/ForgotPasswordModal.jsp"%>
	<div id="maincontainer">
		<section id="Container" class="container  ">

			<%@ include file="./WEB-INF/SubComponents/IntroPage/IntroPanel.jsp"%>
			<div id="midsection" class="row">
				<%@ include
					file="./WEB-INF/SubComponents/IntroPage/IntroCarousel.jsp"%>				
				<%@ include file="./WEB-INF/SubComponents/IntroPage/Signup.jsp"%>
			</div>
			<%@ include
				file="./WEB-INF/SubComponents/IntroPage/FooterContent.jsp"%>
		</section>
	</div>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')
	</script>
	<script src="js/plugins.js" type="text/javascript"></script>
	<script src="js/main.js" type="text/javascript"></script>
	<script src="js/vendor/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/vendor/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="js/Utility.js" type="text/javascript"></script>
	<script type="text/javascript">
		UMapUS.refdata.getListofFamilyNames();
	</script>
	<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
	<!--    <script>
		(function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
		function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
		e=o.createElement(i);r=o.getElementsByTagName(i)[0];
		e.src='//www.google-analytics.com/analytics.js';
		r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
		ga('create','UA-XXXXX-X');ga('send','pageview');
		</script>
		-->

	<!--  Modals for Sign up -->


</body>

</html>
