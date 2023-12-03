<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<!-- title -->
<title>About</title>

<body>


	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Chúng tôi bán trái cây tươi</p>
						<h1>About Us</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- featured section -->
	<div class="feature-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-7">
					<div class="featured-text">
						<h2 class="pb-3">
							Tại sao là <span class="orange-text">Fruit Shop</span>
						</h2>
						<div class="row">
							<c:forEach var="item" items="${supports }">
								<div class="col-lg-6 col-md-6 mb-4 mb-md-5">
									<div class="list-box d-flex">
										<div class="list-icon">
											<i class="${item.icon }"></i>
										</div>
										<div class="content">
											<h3>${item.name }</h3>
											<p>${item.description }</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end featured section -->

	<!-- shop banner -->
	<c:forEach var="item" items="${abouts }">
		<section class="shop-banner"
			style="background-image: url('<c:url value="/assets/uploads/abouts/${item.img }" />')">
			<div class="container">

				<h3>${item.title }</h3>
				<div class="sale-percent">
					<span>${item.description }</span>
				</div>

				<a href='<c:url value="/san-pham" />' class="cart-btn btn-lg">Sản
					phẩm</a>
			</div>
		</section>
	</c:forEach>
	<!-- end shop banner -->

	<!-- team section -->
	<div class="mt-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							Đội <span class="orange-text">Ngũ</span>
						</h3>
						<p>Đội ngũ nhân viên đóng góp và thực hiện.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="item" items="${ourteams }">
					<div class="col-lg-4 col-md-6">
						<div class="single-team-item">
							<div class="team-bg"
								style="background-image: url('<c:url value="/assets/uploads/ourteams/${item.img }" />')"></div>
							<h4>
								${item.name } <span>${item.nickname }</span>
							</h4>
							<ul class="social-link-team">
								<li><a href="#" target="_blank"><i
										class="fab fa-facebook-f"></i></a></li>
								<li><a href="#" target="_blank"><i
										class="fab fa-twitter"></i></a></li>
								<li><a href="#" target="_blank"><i
										class="fab fa-instagram"></i></a></li>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- end team section -->

	<!-- testimonail-section -->
	<div class="testimonail-section mt-80 mb-150">
		<div class="container">
			<div class="row"></div>
		</div>
	</div>
	<!-- end testimonail-section -->


</body>