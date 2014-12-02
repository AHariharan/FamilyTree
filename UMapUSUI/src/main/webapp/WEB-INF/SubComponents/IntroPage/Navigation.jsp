
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
			<a class="navbar-brand" href="#"> <img src="./images/Logo.png"
				height="50px" width="100px"></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>

			<form:form action="/UMapUSUI/login"
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
				<button id="forgotpasswd" type="button" class="btn btn-link">
					Forgot Password ?</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
			<div style="margin-top: 5px;" class="navbar-right" id="loginerrpanel"></div>

		</div>
		<!--/.navbar-collapse -->
	</div>
</div>
