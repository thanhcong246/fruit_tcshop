<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang thông tin tcshop</title>

<body>

	<div class="breadcrumbs">
		<div class="breadcrumbs-inner">
			<div class="row m-0">
				<div class="col-sm-4">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>Đội ngũ</h1>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="page-header float-right">
						<div class="page-title">
							<ol class="breadcrumb text-right">
								<li><a href="#">Trang chủ</a></li>
								<li><a href="#">đội ngũ</a></li>
								<li class="active">chỉnh sửa</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="content">
		<!-- phóng to hình ảnh -->
		<div id="imageModal" class="modal">
			<span class="close" onclick="closeModal()">&times;</span> <img
				id="modalImage" class="modal-content" src="/path/to/placeholder.jpg">
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">Chỉnh sửa</strong>
					</div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<form:form method="POST" action="#" novalidate="novalidate"
								enctype="multipart/form-data">
								<div class="row">
									<div class="col-lg-6">
										<h5>Ảnh cũ</h5>
										<img alt="" height="150px"
											src="<c:url value="/assets/uploads/ourteams/${ourteam.img }" />"
											onclick="openModal('<c:url value="/assets/uploads/ourteams/${ourteam.img }" />')">
									</div>
									<div class="col-lg-6">
										<label for="img" class="control-label mb-1">Chọn ảnh
											mới</label> <input type="file" id="img" name="img"
											class="form-control" accept="image/*" required>
									</div>
								</div>
								<div class="form-group">
									<label for="name" class="control-label mb-1">Tên</label> <input
										id="name" name="name" type="text" class="form-control"
										aria-required="true" aria-invalid="false"
										value="${ourteam.name }">
								</div>
								<div class="form-group">
									<label for="nickname" class="control-label mb-1">Tên biệt danh</label> <input
										id="nickname" name="nickname" type="text" class="form-control"
										aria-required="true" aria-invalid="false"
										value="${ourteam.nickname }">
								</div>
								<div class="form-group">
									<label for="interactively" class="control-label mb-1">Tương tác</label> <input
										id="interactively" name="interactively" type="text" class="form-control"
										aria-required="true" aria-invalid="false"
										value="${ourteam.interactively }">
								</div>
								<div class="row">
									<div class="col-lg-2"></div>
									<div class="col-lg-4">
										<a href='<c:url value="/admin/ourteam" />' id="payment-button"
											type="button" class="btn btn-lg btn-info btn-block "> <span
											id="payment-button-amount">Quay lại</span>
										</a>
									</div>
									<div class="col-lg-4">
										<button id="payment-button" type="submit"
											class="btn btn-lg btn-success btn-block">
											<span id="payment-button-amount">Xong</span> <span
												id="payment-button-sending" style="display: none;">Chờ
												đợi…</span>
										</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>

				</div>
			</div>
			<!-- .card -->
		</div>
	</div>

</body>
