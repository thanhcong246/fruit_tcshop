<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!--PreLoader-->
<div class="loader">
	<div class="loader-inner">
		<div class="circle"></div>
	</div>
</div>
<!--PreLoader Ends-->

<!-- header -->
<div class="top-header-area" id="sticker">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12 text-center">
				<div class="main-menu-wrap">
					<!-- logo -->
					<div class="site-logo">
						<a href='<c:url value="/" />'> <img
							src="<c:url value="/assets/user/assets/img/logo-shop.png" />" alt="">
						</a>
					</div>
					<!-- logo -->

					<!-- menu start -->
					<nav class="main-menu">
						<ul>
							<c:forEach var="item" items="${menus}">
								<c:choose>
									<c:when test="${item.url == '/san-pham'}">
										<!-- Điều kiện thêm vòng lặp bổ sung khi item.url là /san-pham -->
										<li class="nav-link-active"><a
											href="<c:url value="${item.url}" />">${item.name}</a>
											<ul class="sub-menu">
												<c:forEach var="subItem" items="${categorys}">
													<li><a
														href='<c:url value="/san-pham/category/${subItem.id }" />'>${subItem.name }</a></li>
												</c:forEach>
											</ul></li>
									</c:when>
									<c:otherwise>
										<!-- Điều kiện mặc định cho các trường hợp khác -->
										<li class="nav-link-active"><a
											href="<c:url value="${item.url}" />">${item.name}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${not empty LoginInfo}">
								<li><a href='#'><i class="fas fa-user mr-1"></i>
										${LoginInfo.display_name }</a>
									<ul class="sub-menu">
										<c:if test="${LoginInfo.active == 1 }">
											<li><a href='<c:url value="/admin/" />'>Trang quản
													trị admin</a></li>
										</c:if>
										<li><a href="#">Thông tin tài khoản</a></li>
										<li><a href='<c:url value="/lich-su-mua-hang" />'>Lịch sử mua hàng</a></li>
										<li><a href="<c:url value="/dang-xuat" />">Đăng xuất</a></li>
									</ul></li>
							</c:if>
							<c:if test="${empty LoginInfo}">
								<li><a href='<c:url value="/account/dang-nhap" />'><i
										class="fas fa-sign-in-alt mr-1"></i> Đăng nhập</a></li>
							</c:if>
							<li>
								<div class="header-icons">
									<a class="shopping-cart" href='<c:url value="/gio-hang"/>'><i
										class="fas fa-shopping-cart mr-1"></i> <c:if test="${not empty Cart }">${TotalQuantyCart }</c:if> </a> <a
										class="mobile-hide search-bar-icon" href="#"><i
										class="fas fa-search"></i></a>
								</div>
							</li>
						</ul>
					</nav>
					<a class="mobile-show search-bar-icon" href="#"><i
						class="fas fa-search"></i></a>
					<div class="mobile-menu"></div>
					<!-- menu end -->
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end header -->

<!-- search area -->
<div class="search-area">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<span class="close-btn"><i class="fas fa-window-close"></i></span>
				<div class="search-bar">
					<div class="search-bar-tablecell">
						<h3>Tìm sản phẩm theo ý bạn:</h3>
						<form action='/fruit_shop/san-pham' method="POST">
							<input type="text" name="keyword" placeholder="Nhập ...">
							<button type="submit">
								Tìm <i class="fas fa-search"></i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end search area -->





