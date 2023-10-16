<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang slide</title>

<body>

	<div class="breadcrumbs">
		<div class="breadcrumbs-inner">
			<div class="row m-0">
				<div class="col-sm-4">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>Slide</h1>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="page-header float-right">
						<div class="page-title">
							<ol class="breadcrumb text-right">
								<li><a href="#">Trang chủ</a></li>
								<li><a href="#">slide</a></li>
								<li class="active">thêm</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="row">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">Tạo thêm</strong>
					</div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<form:form method="POST" action="create" novalidate="novalidate" enctype="multipart/form-data">
								<div class="form-group">
									<label for="img" class="control-label mb-1">Ảnh</label> <input
										type="file" id="img" name="img" class="form-control"
										accept="image/*" required>
								</div>
								<div class="form-group">
									<label for="caption" class="control-label mb-1">Tiêu đề</label>
									<input id="caption" name="caption" type="text"
										class="form-control" aria-required="true" aria-invalid="false">
								</div>
								<div class="form-group">
									<label for="content" class="control-label mb-1">Nội
										dung</label> <input id="content" name="content" type="text"
										class="form-control" aria-required="true" aria-invalid="false">
								</div>
								<div class="form-group">
									<label for="name" class="control-label mb-1">Tên menu 1</label>
									<input id="name" name="name" type="text" class="form-control"
										aria-required="true" aria-invalid="false">
								</div>
								<div class="form-group">
									<label for="url" class="control-label mb-1">Đường dẫn
										menu 1</label> <input id="url" name="url" type="text"
										class="form-control" aria-required="true" aria-invalid="false">
								</div>
								<div class="form-group">
									<label for="name2" class="control-label mb-1">Tên menu
										2</label> <input id="name2" name="name2" type="text"
										class="form-control" aria-required="true" aria-invalid="false">
								</div>
								<div class="form-group">
									<label for="url2" class="control-label mb-1">Đường dẫn
										menu 2</label> <input id="url2" name="url2" type="text"
										class="form-control" aria-required="true" aria-invalid="false">
								</div>
								<div class="row">
									<div class="col-lg-2"></div>
									<div class="col-lg-4">
										<a href='<c:url value="/admin/slide" />' id="payment-button"
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
