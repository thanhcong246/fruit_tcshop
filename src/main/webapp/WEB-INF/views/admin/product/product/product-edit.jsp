<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang sản phẩm</title>

<body>

	<div class="breadcrumbs">
		<div class="breadcrumbs-inner">
			<div class="row m-0">
				<div class="col-sm-4">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>Sản phẩm</h1>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="page-header float-right">
						<div class="page-title">
							<ol class="breadcrumb text-right">
								<li><a href="#">Trang chủ</a></li>
								<li><a href="#">sản phẩm</a></li>
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
		<!-- ----------------- -->
		<div class="row">
			<div class="col-lg-12">
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
										<div class="form-group">
											<div class="row">
												<div class="col-lg-6">
													<h5>Ảnh cũ</h5>
													<img alt="" height="150px"
														src="<c:url value="/assets/uploads/products/${product.img }" />"
														onclick="openModal('<c:url value="/assets/uploads/products/${product.img }" />')">
												</div>
												<div class="col-lg-6">
													<label for="img" class="control-label mb-1">Ảnh mới</label> <input
														type="file" id="img" name="img" class="form-control"
														accept="image/*" required>
												</div>
											</div>

										</div>
										<div class="form-group">
											<label for="id_category" class=" form-control-label">Loại</label>
											<select name="id_category" id="id_category"
												class="form-control">
												<c:forEach var="item" items="${category }">
													<option value="${item.id }">${item.name }</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label for="name" class="control-label mb-1">Tên</label> <input
												id="name" name="name" type="text" class="form-control"
												aria-required="true" aria-invalid="false"
												value="${product.name }">
										</div>
										<div class="row">
											<div class="col-lg-6">
												<div class="form-group">
													<label for="old_price" class="control-label mb-1">Giá
														cũ</label> <input id="old_price" name="old_price" type="number"
														class="form-control" aria-required="true"
														aria-invalid="false" value="${product.old_price }">
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label for="sale" class="control-label mb-1">Giảm
														giá (%)</label> <input id="sale" name="sale" type="number"
														class="form-control" aria-required="true"
														aria-invalid="false" value="${product.sale }">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="price" class="control-label mb-1">Giá mới</label>
											<input id="price" name="price" type="number"
												class="form-control" aria-required="true"
												aria-invalid="false" value="${product.price }">
										</div>
										<div class="form-group">
											<label for="total_quality" class="control-label mb-1">Số
												lượng (Kg)</label> <input id="total_quality" name="total_quality"
												type="number" class="form-control" aria-required="true"
												aria-invalid="false" value="${product.total_quality }">
										</div>
										<div class="form-group">
											<label class="form-control-label">Sản phẩm nổi bật:</label>
											<div class="form-check-inline form-check">
												<label class="form-check-label mr-4 ml-3"> <input
													type="radio" id="highlight-yes" name="highlight" value="1"
													class="form-check-input" checked="checked">Có
												</label> <label class="form-check-label"> <input
													type="radio" id="highlight-no" name="highlight" value="0"
													class="form-check-input">Không
												</label>
											</div>
										</div>

										<div class="form-group">
											<label class="form-control-label">Sản phẩm mới:</label>
											<div class="form-check-inline form-check">
												<label class="form-check-label mr-4 ml-3"> <input
													type="radio" id="newproduct-yes" name="new_product"
													value="1" class="form-check-input" checked="checked">Có
												</label> <label class="form-check-label"> <input
													type="radio" id="newproduct-no" name="new_product"
													value="0" class="form-check-input">Không
												</label>
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<label for="title" class="control-label mb-1">Tiêu đề</label>
											<input id="title" name="title" type="text"
												class="form-control" aria-required="true"
												aria-invalid="false" value="${product.title }">
										</div>
										<div class="form-group">
											<label for="details" class="control-label mb-1">Thông
												tin chi tiết</label>
											<textarea id="details" name="details" class="form-control"
												aria-required="true" aria-invalid="false">${product.details }</textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-2"></div>
									<div class="col-lg-4">
										<a href='<c:url value="/admin/product" />' id="payment-button"
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
	<!-- ckeditor -->
	<script src="<c:url value="/assets/ckeditor/ckeditor.js" />"></script>
	<script>
		CKEDITOR.replace('details');
	</script>

</body>
