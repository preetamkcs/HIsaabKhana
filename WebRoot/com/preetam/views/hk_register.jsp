<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<title>HisaabKhana:Register Here</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="stylesheets/normalize.css">
		<link rel="stylesheet" href="stylesheets/skeleton.css">
		<link rel="stylesheet" href="stylesheets/custom_style.css">
		<link rel="shortcut icon" href="images/favicon.ico">
		<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
		<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/commonFunctions.js"></script>
		<script type="text/javascript">
	$(function() {
		$("#regForm").submit(
				function() {
					if ($("#username").val().trim() == "") {
						alert("please enter proper username!")
						return false;
					}
					if ($("#email").val().trim() == "") {
						alert("please enter proper email!")
						return false;
					}
					if ($("#password").val().trim() == "") {
						alert("please enter proper password!")
						return false;
					}
					if ($("#password").val() != $("#rePassword").val()) {
						alert("passwords do not match!")
						return false;
					}
					var chkUserAvl = _ajaxCallText("checkUserAvailable.exe",
							"regInfo.userName=" + $("#username").val()
									+ "&regInfo.email=" + $("#email").val());
					if (0 != chkUserAvl)
						if (4 == chkUserAvl) {
							alert("Username not available!");
							return false;
						} else if (2 == chkUserAvl) {
							alert("Email not available!");
							return false;
						} else if (6 == chkUserAvl) {
							alert("Username and Email not available!");
							return false;
						} else {
							alert("This user cannot register!");
							return false;
						}
				})
	})
	paramArr = window.location.search.replace("?", "").split("=");
	console.log(paramArr);
	if (paramArr.length == 2 && "" != paramArr[1].trim()
			&& paramArr[0] === "lastView") {
	}
</script>
	</head>
	<body>
		<div id="header" class="row">
			<div class="container">
				<div class="row">
					<div class="column">
							
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div id="regform" class="one-half column">
					<div class="container">
						<h4>
							Sign Up for HisaabKhana
						</h4>
						<hr />
						<form action="doRegister.exe" name="regForm" id="regForm"
							method="post">

							<div class="row">
								<s:textfield id="username" required="" cssClass="column"
									placeholder="username" name="regInfo.userName" />
							</div>
							<div class="row">
								<s:textfield type="email" id="email" name="regInfo.email"
									required="" cssClass="column" placeholder="user@domain.com" />
							</div>
							<div class="row">
								<s:password id="password" name="regInfo.password" required=""
									cssClass="column" placeholder="password" />
							</div>
							<div class="row">
								<s:password id="rePassword" name="" required=""
									cssClass="column" placeholder="retype password" />
							</div>
							<div class="row">
								<s:submit name="ping" value="signUp"
									cssClass="column button-primary" />
							</div>
						</form>
						<hr/>
						<p>If you already have an account just <s:a action="login.exe">login</s:a>.</p>
					</div>
				</div>
			</div>
		</div>
		<div id="footerShadow"></div>
		<div id="footer" class="row">
			<div class="column">
				<h6> (C)2016 Preetam Kumar.</h6>
			</div>
		</div>
	</body>
</html>
