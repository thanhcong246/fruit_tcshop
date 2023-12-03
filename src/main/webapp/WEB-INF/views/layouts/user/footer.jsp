<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>

<!-- logo carousel -->
<div class="logo-carousel-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="logo-carousel-inner">
					<div class="single-logo-item">
						<img
							src="<c:url value="/assets/user/assets/img/company-logos/1.png"/>"
							alt="">
					</div>
					<div class="single-logo-item">
						<img
							src="<c:url value="/assets/user/assets/img/company-logos/2.png"/>"
							alt="">
					</div>
					<div class="single-logo-item">
						<img
							src="<c:url value="/assets/user/assets/img/company-logos/3.png"/>"
							alt="">
					</div>
					<div class="single-logo-item">
						<img
							src="<c:url value="/assets/user/assets/img/company-logos/4.png"/>"
							alt="">
					</div>
					<div class="single-logo-item">
						<img
							src="<c:url value="/assets/user/assets/img/company-logos/5.png"/>"
							alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end logo carousel -->

<!-- footer -->
<div class="footer-area">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-6">
				<div class="footer-box about-widget">
					<h2 class="widget-title">Về chúng tôi</h2>
					<p>Chúng tôi cam kết sản phẩm ở trên là an toàn thực phẩm 100%.</p>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="footer-box get-in-touch">
					<h2 class="widget-title">Địa chỉ</h2>
					<ul>
						<c:forEach var="item" items="${contacts }">
							<li>${item.address }</li>
							<li>${item.email }</li>
							<li>+${item.phone }</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="footer-box pages">
					<h2 class="widget-title">Trang chính</h2>
					<ul>
						<c:forEach var="item" items="${menus }">
							<li><a href='<c:url value="${item.url }"/>'>${item.name }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="footer-box subscribe">
					<h2 class="widget-title">Đăng kí</h2>
					<p>Đăng kí tài khoản để nhận những thông tin mới nhất.</p>
					<c:if test="${empty LoginInfo}">
						<form action="<c:url value="/account/dang-ky"/>">
							<input type="email" placeholder="Email">
							<button type="submit">
								<i class="fas fa-paper-plane"></i>
							</button>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end footer -->

<!-- copyright -->
<div class="copyright">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-12">
				<p>
					Copyrights &copy; 2023 - <a href="#">Nguyễn Thành Công</a>, Đã đăng
					kí bản quyền.
				</p>
			</div>
			<div class="col-lg-6 text-right col-md-12">
				<div class="social-icons">
					<ul>
						<li><a href="#" target="_blank"><i
								class="fab fa-facebook-f"></i></a></li>
						<li><a href="#" target="_blank"><i class="fab fa-twitter"></i></a></li>
						<li><a href="#" target="_blank"><i
								class="fab fa-instagram"></i></a></li>
						<li><a href="#" target="_blank"><i
								class="fab fa-linkedin"></i></a></li>
						<li><a href="#" target="_blank"><i
								class="fab fa-dribbble"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end copyright -->