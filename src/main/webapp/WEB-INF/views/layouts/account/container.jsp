<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><decorator:title default="Master-layout" /></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<c:url value="/assets/account/images/icons/favicon.ico" />" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/vendor/bootstrap/css/bootstrap.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/fonts/font-awesome-4.7.0/css/font-awesome.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/vendor/animate/animate.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/vendor/css-hamburgers/hamburgers.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/vendor/select2/select2.min.css" />">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/css/util.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/account/css/main.css" />">
<!--===============================================================================================-->

<style type="text/css">
.elementsf {
	position: absolute;
	top: 5%;
	left: 25%;
}
</style>
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="<c:url value="/assets/account/images/img-01.png" />"
						alt="IMG">
				</div>

				<decorator:body />

			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script
		src='<c:url value="/assets/account/vendor/jquery/jquery-3.2.1.min.js" />'></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/account/vendor/bootstrap/js/popper.js" />"></script>
	<script
		src="<c:url value="/assets/account/vendor/bootstrap/js/bootstrap.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/account/vendor/select2/select2.min.js" />"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value="/assets/account/vendor/tilt/tilt.jquery.min.js" />"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="<c:url value="/assets/account/js/main.js" />"></script>

</body>
</html>