<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang Chủ</title>

<body>
	<!-- home page slider -->
	<div class="homepage-slider">
		<!-- single home slider -->
		<c:forEach var="item" items="${slides }">
			<div class="single-homepage-slider"
				style="background-image: url(<c:url value="/assets/uploads/slides/${item.img }" />)">
				<div class="container">
					<div class="row">
						<div class="col-md-12 col-lg-7 offset-lg-1 offset-xl-0">
							<div class="hero-text">
								<div class="hero-text-tablecell">
									<p class="subtitle">${item.caption }</p>
									<h1>${item.content}</h1>
									<div class="hero-btns">
										<a href='<c:url value="${item.url }" />' class="boxed-btn">${item.name }</a>
										<a href='<c:url value="${item.url2 }" />' class="bordered-btn">${item.name2 }</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- end home page slider -->

	<!-- features list section -->
	<div class="list-section pt-80 pb-80">
		<div class="container">

			<div class="row">
				<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
					<div class="list-box d-flex align-items-center">
						<div class="list-icon">
							<i class="fas fa-shipping-fast"></i>
						</div>
						<div class="content">
							<h3>Miễn phí ship</h3>
							<p>Khi mua hàng trên 200k</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
					<div class="list-box d-flex align-items-center">
						<div class="list-icon">
							<i class="fas fa-phone-volume"></i>
						</div>
						<div class="content">
							<h3>Hỗ trợ 24/7</h3>
							<p>Tư vấn cả ngày</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div
						class="list-box d-flex justify-content-start align-items-center">
						<div class="list-icon">
							<i class="fas fa-sync"></i>
						</div>
						<div class="content">
							<h3>Trả hàng</h3>
							<p>Nhận hoàn tiền trong vòng 3 ngày!</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- end features list section -->

	<!-- product new section -->
	<div class="product-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							<span class="orange-text">Sản phẩm</span> Mới
						</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach var="item" items="${new_products }" varStatus="loop">
					<div class="col-lg-4 col-md-6 text-center">
						<div class="single-product-item">
							<div class="product-image">
								<a
									href="<c:url value="/san-pham/chi-tiet-san-pham/${item.id }" />"><img
									src="<c:url value="/assets/uploads/products/${item.img }" />"
									alt=""></a>
							</div>
							<h3>${item.name }</h3>
							<p class="product-price">
								<span>${item.title }</span>
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${item.price }" />
								₫
							</p>
							<c:if test="${item.total_quality == 0 }">
								<a href="#" class="cart-btn"><i class="fas fa-shopping-cart"></i>
									Hết hàng</a>
							</c:if>
							<c:if test="${item.total_quality > 0 }">
								<a href="<c:url value="/AddCart/${item.id }" />"
									class="cart-btn"><i class="fas fa-shopping-cart"></i> Thêm
									vào giỏ hàng</a>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- end product new section -->

	<!-- product highlight section -->
	<div class="product-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							<span class="orange-text">Sản phẩm</span> Nổi bật
						</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach var="item" items="${hightlight_products }"
					varStatus="loop">
					<div class="col-lg-4 col-md-6 text-center">
						<div class="single-product-item">
							<div class="product-image">
								<a
									href="<c:url value="/san-pham/chi-tiet-san-pham/${item.id }" />"><img
									src="<c:url value="/assets/uploads/products/${item.img }" />"
									alt=""></a>
							</div>
							<h3>${item.name }</h3>
							<p class="product-price">
								<span>${item.title }</span>
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${item.price }" />
								₫
							</p>
							<c:if test="${item.total_quality == 0 }">
								<a href="#" class="cart-btn"><i class="fas fa-shopping-cart"></i>
									Hết hàng</a>
							</c:if>
							<c:if test="${item.total_quality > 0 }">
								<a href="<c:url value="/AddCart/${item.id }" />"
									class="cart-btn"><i class="fas fa-shopping-cart"></i> Thêm
									vào giỏ hàng</a>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- end product highlight section -->

	<!-- shop banner -->
	<c:forEach var="item" items="${abouts }">
		<section class="shop-banner" style="background-image: url('<c:url value="/assets/uploads/abouts/${item.img }" />')">
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

	<!-- latest news -->
	<div class="latest-news pt-150 pb-150">
		<div class="container">

			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							<span class="orange-text">Bảng</span> Tin
						</h3>
						<p>Những bảng tin mới nhất</p>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach var="item" items="${news }">
					<div class="col-lg-4 col-md-6">
						<div class="single-latest-news">
							<a href='<c:url value="/bang-tin/${item.id }" />'>
								<div class="latest-news-bg" style="background-image: url(<c:url value="/assets/uploads/news/${item.img }" />)"></div>
							</a>
							<div class="news-text-box">
								<h3>
									<a href='<c:url value="/bang-tin/${item.id }" />'>${item.title }</a>
								</h3>
								<p class="blog-meta">
									<span class="author"><i class="fas fa-user"></i>
										${item.name_user }</span> <span class="date"><i
										class="fas fa-calendar"></i> ${item.date }</span>
								</p>
								<p class="excerpt">${item.content }</p>
								<a href='<c:url value="/bang-tin/${item.id }" />'
									class="read-more-btn">Đọc thêm <i
									class="fas fa-angle-right"></i></a>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
			<div class="row">
				<div class="col-lg-12 text-center">
					<a href='<c:url value="/bang-tin" />' class="boxed-btn">Xem
						thêm</a>
				</div>
			</div>
		</div>
	</div>
	<!-- end latest news -->
</body>