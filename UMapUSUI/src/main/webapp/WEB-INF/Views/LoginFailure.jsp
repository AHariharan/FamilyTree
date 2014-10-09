<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>UMapUS</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Place favicon.ico and apple-touch-icon(s) in the root directory -->

<link rel="stylesheet" href="./css/vendor/normalize.css">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/vendor/bootstrap-theme.css">
<link rel="stylesheet" href="./css/vendor/bootstrap.min.css">
<link rel="stylesheet" href="./css/vendor/bootstrap-select.min.css">
<script src="js/vendor/modernizr-2.7.1.min.js"></script>
<script src="js/Validators.js" type="text/javascript"></script>
<script src="js/Messages.js" type="text/javascript"></script>
</head>
<body>
	<!--[if lt IE 8]>
		<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->

	<!-- Add your site or application content here -->
	<!-- <p>Hello world! This is HTML5 Boilerplate.</p> -->
	<div id="header" class="navbar navbar-default navbar-fixed-top"
		role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/UMapUSUI"> <img src="./images/Logo.png"
					height="50px" width="100px"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/UMapUSUI">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>

			<!-- 	<form action="/UMapUSUI/login"
					onsubmit="return account.loginValidation();"
					class="navbar-form navbar-right" role="form" method="post"
					enctype="application/x-www-form-urlencoded">
					<div class="form-group">
						<input id="loginemail" name="userName" placeholder="Email"
							class="form-control" type="text" />
					</div>
					<div class="form-group">
						<input id="loginpasswd" name="passWord" placeholder="Password"
							class="form-control" type="password" />
					</div>
					<button type="submit" value="Submit" class="btn btn-success">Sign
						in</button>

				</form> -->
				<div style="margin-top: 5px;" class="navbar-right"
					id="loginerrpanel"></div>

			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<div id="maincontainer">

		<section id="Container" class="container  ">
        <div id="loginfailure">
           <h4> Login failed invalid username/password</h4>
                    <div class="form-group">
						<input id="loginemail" name="userName" placeholder="Email"
							class="form-control" type="text" />
					</div>
					<div class="form-group">
						<input id="loginpasswd" name="passWord" placeholder="Password"
							class="form-control" type="password" />
					</div>
         
        </div>

			<!-- <div id="intro" class="row holder breadcrumb">
				<h2>
					Welcome to <span style="color: rgba(212, 57, 57, 1);">U</span>Map<span
						style="color: rgba(212, 57, 57, 1);">Us</span>
				</h2>
				<div class="row">
					<div class="col-md-4">
						<p>Build your family network</p>
						<p>Discover your extended family and invite</p>
						<p>Share news &amp; keep in touch</p>
					</div>
					<div class="col-md-offset-2 col-md-6">
						<h4>Search your family / extended family</h4>

						<div class="input-group">
							<input type="text" class="form-control"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">Lookup</button>
							</span>
						</div>
					</div>

				</div>

			</div>
 -->
			<!-- <div id="midsection" class="row">
				<div class="col-md-6">
					<div id="myCarousel" class="carousel slide">
						<div class="carousel-inner">
							<div class="item">
								<img src="./images/DSC_0818.JPG" alt="" height="500px">
								<div class="container">
									<div class="carousel-caption">
										<h1>UMapUS</h1>
										<p class="Lead">Connect with your family and maintain
											roots Discover extended family Let's stay connected</p>
										<a class="btn btn-large btn-primary" href="#">Learn more</a>
									</div>
								</div>
							</div>
							<div class="item active">
								<img src="./images/DSC_0728.JPG" alt="" height="500px">
								<div class="container">
									<div class="carousel-caption">
										<h1>UMapUS</h1>
										<p class="Lead">Connect with your family and maintain
											roots</p>

										<p class="Lead">Discover extended family</p>

										<p class="Lead">Let's stay connected</p>
										<a class="btn btn-large btn-primary" href="#">Learn more</a>
									</div>
								</div>
							</div>
							<div class="item">
								<img src="./images/UMapUSTree.png" alt="" height="500px">
								<div class="container">
									<div class="carousel-caption">
										<h1>Family Tree.</h1>
										<p class="lead">Build your family tree and trace the blood
											line.</p>
										<a class="btn btn-large btn-primary" href="#">Browse
											members</a>
									</div>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev">‹</a> <a class="right carousel-control"
							href="#myCarousel" data-slide="next">›</a>
					</div>
				</div>
				<div id="signup" class="col-md-6 holder breadcrumb">
					<h4>
						Sign up <small> and get started</small>
					</h4>
					<form class="form-horizontal">
						<div class="form-group">
							<label for="familyname" class="col-sm-4 control-label"><span
								style="color: red">* </span>Family Name</label>
							<div class="col-offset-1 col-sm-7">
								<select id="familyname" data-live-search="true" data-style="btn-primary"
									class="form-control selectpicker">
									<option>-Select-</option>
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-4 control-label"><span
								style="color: red">* </span>First Name</label>
							<div class="col-offset-1 col-sm-7">
								<input type="text" class="form-control" id="firstname"
									placeholder="First Name">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-4 control-label"><span
								style="color: red">* </span>Last Name</label>
							<div class="col-offset-1 col-sm-7">
								<input type="text" class="form-control" id="lastname"
									placeholder="Last Name">
							</div>
						</div>
						<div class="form-group">
							<label for="emailsignup" class="col-sm-4 control-label">
								<span style="color: red">* </span>Email
							</label>
							<div class="col-offset-1 col-sm-7">
								<input type="text" class="form-control" id="emailsignup"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="passwdsignup" class="col-sm-4 control-label"><span
								style="color: red">* </span>Password</label>
							<div class="col-offset-1 col-sm-7">
								<input type="password" class="form-control" id="passwdsignup"
									placeholder="Password">
							</div>
						</div>
						<div class="col-sm-offset-9 col-sm-3">
							<button class="btn btn-md btn-primary"
								onclick="account.accountSignup(event);">Sign up</button>
						</div>
						<div class="col-sm-offset-1 col-sm-11">
							<p class="text-muted">
								By clicking "Sign up for UMapUS", you agree to our <a
									href="https://help.github.com/terms" target="_blank">terms
									of service</a> and <a href="https://help.github.com/privacy"
									target="_blank">privacy policy</a>.
							</p>
						</div>

					</form>

				</div>
			</div> -->

			<div id="footer" class="row">
				<div id="copyright" class="col-md-3" style="color: black">
					Copyright @ 2014 UMapUS Inc.</div>
				<div id="social-block" class="col-md-offset-5 col-md-4">
					<div class="single-block">
						<h3>Stay Connected</h3>

						<ul style="display: inline">
							<li class="facebook"><a href="https://www.facebook.com"
								target="_blank"> <img src="./images/footer_fb.png"
									alt="facebook" class="product-logo">
							</a></li>
							<li class="twitter"><a href="https://twitter.com/"
								target="_blank"> <img src="./images/footer_twt.png"
									alt="twitter" class="product-logo">
							</a></li>
							<li class="linkedin"><a
								href="http://www.linkedin.com/company/" target="_blank"> <img
									src="./images/footer-linkedin.png" alt="linkedin"
									class="product-logo">
							</a></li>
						</ul>
					</div>
				</div>
			</div>

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
