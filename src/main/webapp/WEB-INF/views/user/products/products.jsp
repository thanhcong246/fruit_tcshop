<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Sản phẩm</title>

<body>

	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Fresh and Organic</p>
						<h1>Sản phẩm</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- products -->
	<div class="product-section mt-150 mb-150">
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<div class="product-filters">
						<ul>
							<li class="hover_black nav-link-active-category"><a
								href='<c:url value="/san-pham" />'>Tất cả</a></li>

							<c:forEach var="item" items="${categorys}">
								<li class="hover_black nav-link-active-category"><a
									href='<c:url value="/san-pham/category/${item.id}" />'>${item.name}</a></li>
							</c:forEach>
						</ul>

					</div>
				</div>
			</div>


			<div class="row product-lists">
				<c:forEach var="item" items="${productsPaginate }">
					<div class="col-lg-4 col-md-6 text-center">
						<div class="single-product-item">
							<div class="product-image">
								<a href="single-product.html"><img
									src='<c:url value="/assets/user/assets/img/products/${item.img }" />'
									alt=""></a>
							</div>
							<h3>${item.name }</h3>
							<p class="product-price">
								<span>${item.title }</span>
								<fmt:formatNumber type="number" groupingUsed="true"
									value="${item.price }" />
								₫
							</p>
							<a href="cart.html" class="cart-btn"><i
								class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng</a>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="pagination-wrap">
						<ul>
							<c:if test="${paginateInfo.currentPage > 1}">
								<li><a
									href="<c:url value='/san-pham/trang/${paginateInfo.currentPage - 1}' />">Quay
										lại</a></li>
							</c:if>
							<c:forEach var="item" begin="1" end="${paginateInfo.totalPage}"
								varStatus="loop">
								<c:if test="${loop.index == paginateInfo.currentPage}">
									<li><a class="active" href="#"><c:out
												value="${loop.index}" /></a></li>
								</c:if>
								<c:if test="${loop.index != paginateInfo.currentPage}">
									<li><a href="<c:url value='/san-pham/trang/${loop.index}' />"><c:out
												value="${loop.index}" /></a></li>
								</c:if>
							</c:forEach>
							<c:if test="${paginateInfo.currentPage < paginateInfo.totalPage}">
								<li><a
									href="<c:url value='/san-pham/trang/${paginateInfo.currentPage + 1}' />">Tiếp</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end products -->

</body>
