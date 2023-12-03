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
						<p>Chi tiết</p>
						<h1>Bảng tin</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- single article section -->
	<div class="mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="single-article-section">
						<div class="single-article-text">
							<div class="single-artcile-bg"
								style="background-image: url(<c:url value="/assets/uploads/news/${newdt.img }" />)"></div>
							<p class="blog-meta">
								<span class="author"><i class="fas fa-user"></i>
									${newdt.name_user }</span> <span class="date"><i
									class="fas fa-calendar"></i> ${newdt.date }</span>
							</p>
							<h2>${newdt.title }</h2>
							${newdt.description }
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="sidebar-section">
						<div class="recent-posts">
							<h4>Các bài viết khác</h4>
							<ul>
								<c:forEach var="item" items="${news }">
									<li><a href='<c:url value="/bang-tin/${item.id }" />'>${item.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						<div class="tag-section">
							<h4>Tags</h4>
							<ul>
								<li><a href="#">${newdt.tag }</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end single article section -->

</body>