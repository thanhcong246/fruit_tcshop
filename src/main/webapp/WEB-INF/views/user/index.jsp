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

	<!-- cart banner section -->
	<section class="cart-banner pt-100 pb-100">
		<div class="container">
			<div class="row clearfix">
				<!--Image Column-->
				<div class="image-column col-lg-6">
					<div class="image">
						<div class="price-box">
							<div class="inner-price">
								<span class="price"> <strong>30%</strong> <br> off
									per kg
								</span>
							</div>
						</div>
						<img src="assets/img/a.jpg" alt="">
					</div>
				</div>
				<!--Content Column-->
				<div class="content-column col-lg-6">
					<h3>
						<span class="orange-text">Deal</span> of the month
					</h3>
					<h4>Hikan Strwaberry</h4>
					<div class="text">Quisquam minus maiores repudiandae nobis,
						minima saepe id, fugit ullam similique! Beatae, minima quisquam
						molestias facere ea. Perspiciatis unde omnis iste natus error sit
						voluptatem accusant</div>
					<!--Countdown Timer-->
					<div class="time-counter">
						<div class="time-countdown clearfix" data-countdown="2020/2/01">
							<div class="counter-column">
								<div class="inner">
									<span class="count">00</span>Days
								</div>
							</div>
							<div class="counter-column">
								<div class="inner">
									<span class="count">00</span>Hours
								</div>
							</div>
							<div class="counter-column">
								<div class="inner">
									<span class="count">00</span>Mins
								</div>
							</div>
							<div class="counter-column">
								<div class="inner">
									<span class="count">00</span>Secs
								</div>
							</div>
						</div>
					</div>
					<a href="cart.html" class="cart-btn mt-3"><i
						class="fas fa-shopping-cart"></i> Add to Cart</a>
				</div>
			</div>
		</div>
	</section>
	<!-- end cart banner section -->

	<!-- testimonail-section -->
	<div class="testimonail-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1 text-center">
					<div class="testimonial-sliders">
						<div class="single-testimonial-slider">
							<div class="client-avater">
								<img src="assets/img/avaters/avatar1.png" alt="">
							</div>
							<div class="client-meta">
								<h3>
									Saira Hakim <span>Local shop owner</span>
								</h3>
								<p class="testimonial-body">" Sed ut perspiciatis unde omnis
									iste natus error veritatis et quasi architecto beatae vitae
									dict eaque ipsa quae ab illo inventore Sed ut perspiciatis unde
									omnis iste natus error sit voluptatem accusantium "</p>
								<div class="last-icon">
									<i class="fas fa-quote-right"></i>
								</div>
							</div>
						</div>
						<div class="single-testimonial-slider">
							<div class="client-avater">
								<img src="assets/img/avaters/avatar2.png" alt="">
							</div>
							<div class="client-meta">
								<h3>
									David Niph <span>Local shop owner</span>
								</h3>
								<p class="testimonial-body">" Sed ut perspiciatis unde omnis
									iste natus error veritatis et quasi architecto beatae vitae
									dict eaque ipsa quae ab illo inventore Sed ut perspiciatis unde
									omnis iste natus error sit voluptatem accusantium "</p>
								<div class="last-icon">
									<i class="fas fa-quote-right"></i>
								</div>
							</div>
						</div>
						<div class="single-testimonial-slider">
							<div class="client-avater">
								<img src="assets/img/avaters/avatar3.png" alt="">
							</div>
							<div class="client-meta">
								<h3>
									Jacob Sikim <span>Local shop owner</span>
								</h3>
								<p class="testimonial-body">" Sed ut perspiciatis unde omnis
									iste natus error veritatis et quasi architecto beatae vitae
									dict eaque ipsa quae ab illo inventore Sed ut perspiciatis unde
									omnis iste natus error sit voluptatem accusantium "</p>
								<div class="last-icon">
									<i class="fas fa-quote-right"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end testimonail-section -->

	<!-- advertisement section -->
	<div class="abt-section mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<div class="abt-bg">
						<a href="https://www.youtube.com/watch?v=DBLlFWYcIGQ"
							class="video-play-btn popup-youtube"><i class="fas fa-play"></i></a>
					</div>
				</div>
				<div class="col-lg-6 col-md-12">
					<div class="abt-text">
						<p class="top-sub">Since Year 1999</p>
						<h2>
							We are <span class="orange-text">Fruitkha</span>
						</h2>
						<p>Etiam vulputate ut augue vel sodales. In sollicitudin neque
							et massa porttitor vestibulum ac vel nisi. Vestibulum placerat
							eget dolor sit amet posuere. In ut dolor aliquet, aliquet sapien
							sed, interdum velit. Nam eu molestie lorem.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Sapiente facilis illo repellat veritatis minus, et labore minima
							mollitia qui ducimus.</p>
						<a href="about.html" class="boxed-btn mt-4">know more</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end advertisement section -->

	<!-- shop banner -->
	<section class="shop-banner">
		<div class="container">
			<h3>
				December sale is on! <br> with big <span class="orange-text">Discount...</span>
			</h3>
			<div class="sale-percent">
				<span>Sale! <br> Upto
				</span>50% <span>off</span>
			</div>
			<a href="shop.html" class="cart-btn btn-lg">Shop Now</a>
		</div>
	</section>
	<!-- end shop banner -->

	<!-- latest news -->
	<div class="latest-news pt-150 pb-150">
		<div class="container">

			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							<span class="orange-text">Our</span> News
						</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Aliquid, fuga quas itaque eveniet beatae optio.</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="single-latest-news">
						<a href="single-news.html"><div
								class="latest-news-bg news-bg-1"></div></a>
						<div class="news-text-box">
							<h3>
								<a href="single-news.html">You will vainly look for fruit on
									it in autumn.</a>
							</h3>
							<p class="blog-meta">
								<span class="author"><i class="fas fa-user"></i> Admin</span> <span
									class="date"><i class="fas fa-calendar"></i> 27
									December, 2019</span>
							</p>
							<p class="excerpt">Vivamus lacus enim, pulvinar vel nulla
								sed, scelerisque rhoncus nisi. Praesent vitae mattis nunc,
								egestas viverra eros.</p>
							<a href="single-news.html" class="read-more-btn">read more <i
								class="fas fa-angle-right"></i></a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="single-latest-news">
						<a href="single-news.html"><div
								class="latest-news-bg news-bg-2"></div></a>
						<div class="news-text-box">
							<h3>
								<a href="single-news.html">A man's worth has its season,
									like tomato.</a>
							</h3>
							<p class="blog-meta">
								<span class="author"><i class="fas fa-user"></i> Admin</span> <span
									class="date"><i class="fas fa-calendar"></i> 27
									December, 2019</span>
							</p>
							<p class="excerpt">Vivamus lacus enim, pulvinar vel nulla
								sed, scelerisque rhoncus nisi. Praesent vitae mattis nunc,
								egestas viverra eros.</p>
							<a href="single-news.html" class="read-more-btn">read more <i
								class="fas fa-angle-right"></i></a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 offset-md-3 offset-lg-0">
					<div class="single-latest-news">
						<a href="single-news.html"><div
								class="latest-news-bg news-bg-3"></div></a>
						<div class="news-text-box">
							<h3>
								<a href="single-news.html">Good thoughts bear good fresh
									juicy fruit.</a>
							</h3>
							<p class="blog-meta">
								<span class="author"><i class="fas fa-user"></i> Admin</span> <span
									class="date"><i class="fas fa-calendar"></i> 27
									December, 2019</span>
							</p>
							<p class="excerpt">Vivamus lacus enim, pulvinar vel nulla
								sed, scelerisque rhoncus nisi. Praesent vitae mattis nunc,
								egestas viverra eros.</p>
							<a href="single-news.html" class="read-more-btn">read more <i
								class="fas fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 text-center">
					<a href="news.html" class="boxed-btn">More News</a>
				</div>
			</div>
		</div>
	</div>
	<!-- end latest news -->
</body>