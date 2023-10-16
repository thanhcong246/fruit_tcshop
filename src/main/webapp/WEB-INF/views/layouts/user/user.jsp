<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Website bán hoa quả">

<!-- title -->
<title><decorator:title default="Master-layout" /></title>

<!-- favicon -->
<link rel="shortcut icon" type="image/png"
	href="<c:url value="/assets/user/assets/img/favicon-shop.png"/>">
<!-- google font -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap"
	rel="stylesheet">
<!-- fontawesome -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/all.min.css"/>">
<!-- bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/bootstrap/css/bootstrap.min.css"/>">
<!-- owl carousel -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/owl.carousel.css"/>">
<!-- magnific popup -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/magnific-popup.css"/>">
<!-- animate css -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/animate.css"/>">
<!-- mean menu css -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/meanmenu.min.css"/>">
<!-- main style -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/main.css"/>">
<!-- responsive -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/assets/css/responsive.css"/>">

<!-- main style -->
<link rel="stylesheet" href="<c:url value="/assets/user/style.css"/>">

</head>
<body>

	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

	<decorator:body />

	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>


	<!--  -->
	<decorator:getProperty property="page.script"></decorator:getProperty>

	<!-- script -->
	<script type="text/javascript">
		// Xử lý active trang chủ
		document.addEventListener("DOMContentLoaded", function() {
			var currentPageURL = window.location.pathname;
			var navLinks = document.querySelectorAll(".nav-link-active");

			navLinks.forEach(function(link) {
				var linkURL = link.querySelector('a').getAttribute("href");
				console.log("Current Page URL:", currentPageURL); // In ra URL của trang hiện tại
				console.log("Link URL:", linkURL); // In ra URL của liên kết
				if (linkURL === currentPageURL) {
					link.classList.add("current-list-item");
				} else {
					link.classList.remove("current-list-item");
				}
			});
		});
	</script>

	<!-- js -->
	<script src="<c:url value="/assets/user/js.js"/>"></script>

	<!-- jquery -->
	<script
		src="<c:url value="/assets/user/assets/js/jquery-1.11.3.min.js"/>"></script>
	<!-- bootstrap -->
	<script
		src="<c:url value="/assets/user/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<!-- count down -->
	<script
		src="<c:url value="/assets/user/assets/js/jquery.countdown.js"/>"></script>
	<!-- isotope -->
	<script
		src="<c:url value="/assets/user/assets/js/jquery.isotope-3.0.6.min.js"/>"></script>
	<!-- waypoints -->
	<script src="<c:url value="/assets/user/assets/js/waypoints.js"/>"></script>
	<!-- owl carousel -->
	<script
		src="<c:url value="/assets/user/assets/js/owl.carousel.min.js"/>"></script>
	<!-- magnific popup -->
	<script
		src="<c:url value="/assets/user/assets/js/jquery.magnific-popup.min.js"/>"></script>
	<!-- mean menu -->
	<script
		src="<c:url value="/assets/user/assets/js/jquery.meanmenu.min.js"/>"></script>
	<!-- sticker js -->
	<script src="<c:url value="/assets/user/assets/js/sticker.js"/>"></script>
	<!-- main js -->
	<script src="<c:url value="/assets/user/assets/js/main.js"/>"></script>

</body>
</html>