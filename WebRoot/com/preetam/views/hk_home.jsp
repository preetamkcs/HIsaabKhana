<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta charset="utf-8">
		<title>HisaabKhana:Welcome</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="stylesheets/normalize.css">
		<link rel="stylesheet" href="stylesheets/skeleton.css">
		<link rel="shortcut icon" href="images/favicon.ico">
		<link rel="stylesheet" href="stylesheets/custom_style.css">
		<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
		<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/commonFunctions.js"></script>

	</head>
	<body>
		<div id="header" class="row">
			<div class="container">
				<div class="row">
					<div class="column">
						<nav class="navbar">
						<div class="container">
							<ul class="navbar-list">
								<li class="navbar-item">
									<a class="navbar-link" href="http://getskeleton.com/#intro">Intro</a>
								</li>
								<li class="navbar-item">
									<a class="navbar-link" href="http://getskeleton.com/#"
										data-popover="#codeNavPopover">Code</a>
									<div id="codeNavPopover" class="popover">
										<ul class="popover-list">
											<li class="popover-item">
												<a class="popover-link" href="http://getskeleton.com/#grid">Grid</a>
												<div id="codeNavPopover" class="popover">
										<ul class="popover-list">
											<li class="popover-item">
												<a class="popover-link" href="http://getskeleton.com/#grid">Grid</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="http://getskeleton.com/#typography">Typography</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="http://getskeleton.com/#buttons">Buttons</a>
											</li>
											<li class="popover-item">
												<a class="popover-link" href="http://getskeleton.com/#forms">Forms</a>
											</li>
											<li class="popover-item">
												<a class="popover-link" href="#lists">Lists</a>
											</li>
											<li class="popover-item">
												<a class="popover-link" href="#code">Code</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#tables">Tables</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#queries">Queries</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#utilities">Utilities</a>
											</li>
										</ul>
									</div>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#typography">Typography</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#buttons">Buttons</a>
											</li>
											<li class="popover-item">
												<a class="popover-link" href="#forms">Forms</a>
											</li>
											<li class="popover-item">
												<a class="popover-link" href="#lists">Lists</a>
											</li>
											<li class="popover-item">
												<a class="popover-link" href="#code">Code</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#tables">Tables</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#queries">Queries</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="#utilities">Utilities</a>
											</li>
										</ul>
									</div>
								</li>
								<li class="navbar-item">
									<a class="navbar-link" href="#examples">Examples</a>
								</li>
								<li class="navbar-item">
									<a class="navbar-link" href="#"
										data-popover="#moreNavPopover">More</a>
									<div id="moreNavPopover" class="popover">
										<ul class="popover-list">
											<li class="popover-item">
												<a class="popover-link"
													href="https://github.com/dhg/Skeleton">On Github</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="https://github.com/dhg/Skeleton#browser-support">Browsers</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="https://github.com/dhg/Skeleton#license">License</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="https://github.com/dhg/Skeleton#extensions">Extensions</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="https://github.com/dhg/Skeleton/releases">Versions</a>
											</li>
											<li class="popover-item">
												<a class="popover-link"
													href="https://github.com/dhg/Skeleton#colophon">Colophon</a>
											</li>
										</ul>
									</div>
								</li>
							</ul>
						</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				
			</div>
		</div>
		<div id="footerShadow"></div>
		<div id="footer" class="row">
			<div class="column">
				<h6>
					(C)2016 Preetam Kumar.
				</h6>
			</div>
		</div>
	</body>
</html>
