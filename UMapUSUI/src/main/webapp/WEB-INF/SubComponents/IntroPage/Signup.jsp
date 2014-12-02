<div id="signup" class="col-md-6 holder breadcrumb">
	<%@ include file="./SignupSuccess.jsp"%>
	<%@ include file="./SignupFailure.jsp"%>
	<h4>
		Sign up <small> and get started</small>
	</h4>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="familyname" class="col-sm-4 control-label"><span
				style="color: red">* </span>Family Name</label>
			<div class="col-offset-1 col-sm-7">
				<select id="familyname" data-live-search="true"
					data-style="btn-primary" class="form-control selectpicker">
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
			<label for="emailsignup" class="col-sm-4 control-label"> <span
				style="color: red">* </span>Email
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
					href="https://help.github.com/terms" target="_blank">terms of
					service</a> and <a href="https://help.github.com/privacy"
					target="_blank">privacy policy</a>.
			</p>
		</div>

	</form>

</div>
