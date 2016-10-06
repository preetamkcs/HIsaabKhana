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
		<script type="text/javascript" src="<%=basePath%>js/MD5.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/commonFunctions.js"></script>
		<script type="text/javascript">
	$(function() {
		$("#loginForm").submit(function() {
			if ($("#username").val().trim() == "") {
				alert("please enter proper username!")
				return false;
			}
			if ($("#password").val().trim() == "") {
				alert("please enter proper password!")
				return false;
			} else {
				$("#password").val(MD5($("#username").val()+":"+$("#password").val()))
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
							Login into HisaabKhana
						</h4>
						<hr />
						<s:if test="hasActionErrors()">
							<div class="error">
								<s:actionerror/>
							</div>
						</s:if>
						<form action="doLogin.exe" name="loginForm" id="loginForm"
							method="post">
							<div class="row">
								<div class="column">
									<s:textfield id="username" name="loginInfo.userName"
										required="required" cssClass="u-full-width" placeholder="username" />
								</div>
							</div>
							<div class="row">
								<div cssClass="column">
									<s:password id="password" name="loginInfo.passwordHash"
										required="" cssClass="u-full-width" placeholder="password" />
								</div>
							</div>
							<div class="row">
								<div class="column">
									<s:submit name="ping"  value="login" cssClass="u-full-width button-primary" />
								</div>
							</div>
						</form>
						<hr/>
						<p>You might need to <s:a action="register.exe">sign up first</s:a> in order to login.</p>
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
