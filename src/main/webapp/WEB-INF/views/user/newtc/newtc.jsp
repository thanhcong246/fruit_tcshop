<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<!-- title -->
<title>Tin tức</title>

<body>


	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<p>Tin tức</p>
						<h1>Mỗi ngày</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- latest news -->
	<div class="latest-news mt-150 mb-150">
		<div class="container">
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
		</div>
	</div>
	<!-- end latest news -->

</body>