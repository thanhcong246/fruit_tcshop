<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!-- Left Panel -->
<aside id="left-panel" class="left-panel">
	<nav class="navbar navbar-expand-sm navbar-default">
		<div id="main-menu" class="main-menu collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href='<c:url value="/admin/" />'><i
						class="menu-icon fa fa-laptop"></i>Trang chủ </a></li>
				<li class="menu-title">Quản lý</li>
				<!-- /.menu-title -->
				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Trang
						chủ
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="fa fa-bars" aria-hidden="true"></i><a
							href='<c:url value="/admin/menu" />'>Menus</a></li>
						<li><i class="fa fa-file-image-o" aria-hidden="true"></i><a
							href='<c:url value="/admin/slide" />'>Slide</a></li>
					</ul></li>
				<!-- /.menu-title -->
				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Sản
						phẩm
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="fa fa-bars" aria-hidden="true"></i><a
							href='<c:url value="/admin/category" />'>Phân loại sản phẩm</a></li>

						<li><i class="fa fa-bars" aria-hidden="true"></i><a
							href='<c:url value="/admin/product" />'>Sản phẩm</a></li>
					</ul></li>

				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Thông
						tin, tin tức
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="fa fa-bars" aria-hidden="true"></i><a
							href='<c:url value="/admin/new" />'>Tin tức</a></li>

					</ul></li>

				<li class="menu-item-has-children dropdown"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Thông tin liên hệ
				</a>
					<ul class="sub-menu children dropdown-menu">
						<li><i class="fa fa-bars" aria-hidden="true"></i><a
							href='<c:url value="/admin/contact" />'>Liên hệ</a></li>

					</ul></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
</aside>
<!-- /#left-panel -->