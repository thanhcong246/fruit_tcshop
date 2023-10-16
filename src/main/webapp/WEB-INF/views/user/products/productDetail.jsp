<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Sản phẩm chi tiết</title>

<body>
	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Chi tiết</p>
						<h1>Sản phẩm</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- single product -->
	<div class="single-product mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="single-product-img">
						<img
							src='<c:url value="/assets/user/assets/img/products/${productDetail.img }" />'
							alt="">
					</div>
				</div>
				<div class="col-md-7">
					<div class="single-product-content">
						<h3>${productDetail.name }</h3>
						<p class="single-product-pricing">
							<span>${productDetail.title }</span>
							<fmt:formatNumber type="number" groupingUsed="true"
								value="${productDetail.price }" />
							₫
						</p>
						<p>${productDetail.details }</p>
						<div>
							<c:if test="${productDetail.total_quality == 0 }">
								<a href="#" class="cart-btn"><i class="fas fa-shopping-cart"></i>
									Hết hàng</a>
							</c:if>
							<c:if test="${productDetail.total_quality > 0 }">
								<a href="<c:url value="/AddCart/${productDetail.id }" />"
									class="cart-btn"><i class="fas fa-shopping-cart"></i> Thêm
									vào giỏ hàng</a>
							</c:if>
							<p style="margin-top: 10px !important;">
								<strong>Loại: </strong>Fruits, Organic
							</p>
						</div>
						<h4>Chia sẻ:</h4>
						<ul class="product-share">
							<li><a href=""><i class="fab fa-facebook-f"></i></a></li>
							<li><a href=""><i class="fab fa-twitter"></i></a></li>
							<li><a href=""><i class="fab fa-google-plus-g"></i></a></li>
							<li><a href=""><i class="fab fa-linkedin"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end single product -->

	<!-- more products -->
	<div class="more-products mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							<span class="orange-text">Sản phẩm </span> khác
						</h3>
						<p>Các sản phẩm liên quan.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="item" items="${productByIdCategory }">
					<div class="col-lg-4 col-md-6 text-center">
						<div class="single-product-item">
							<div class="product-image">
								<a
									href="<c:url value="/san-pham/chi-tiet-san-pham/${item.id }" />"><img
									src="<c:url value="/assets/user/assets/img/products/${item.img }" />"
									alt=""></a>
							</div>
							<h3>${item.name }</h3>
							<p class="product-price">
								<span>${item.title }</span>
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${item.price }" />
								₫
							</p>
							<a href="<c:url value="/AddCart/${item.id }" />" class="cart-btn"><i
								class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- end more products -->
</body>