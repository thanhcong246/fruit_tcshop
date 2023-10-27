<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang tin tức</title>

<body>

	<div class="breadcrumbs">
		<div class="breadcrumbs-inner">
			<div class="row m-0">
				<div class="col-sm-4">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>Tin tức</h1>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="page-header float-right">
						<div class="page-title">
							<ol class="breadcrumb text-right">
								<li><a href="#">Trang chủ</a></li>
								<li><a href="#">tin tức</a></li>
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
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">Tạo thêm</strong>
					</div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<form:form method="POST" action="create" novalidate="novalidate"
								enctype="multipart/form-data">

								<div class="form-group">
									<label for="img" class="control-label mb-1">Ảnh</label> <input
										type="file" id="img" name="img" class="form-control"
										accept="image/*" required>
								</div>

								<input id="name_user" name="name_user" type="hidden"
									aria-required="true" aria-invalid="false" value="${LoginInfo.display_name }">

								<div class="form-group">
									<label for="title" class="control-label mb-1">Tiêu đề</label> <input
										id="title" name="title" type="text" class="form-control"
										aria-required="true" aria-invalid="false">
								</div>

								<div class="form-group">
									<label for="tag" class="control-label mb-1">Tag</label> <input
										id="tag" name="tag" type="text" class="form-control"
										aria-required="true" aria-invalid="false">
								</div>

								<div class="form-group">
									<label for="date" class="control-label mb-1">Thời gian</label>
									<input id="date" name="date" type="date" class="form-control"
										aria-required="true" aria-invalid="false">
								</div>
								<div class="form-group">
									<label for="description" class="control-label mb-1">Mô
										tả</label>
									<textarea id="description" name="description"
										class="form-control" aria-required="true" aria-invalid="false"></textarea>
								</div>


								<div class="row">
									<div class="col-lg-2"></div>
									<div class="col-lg-4">
										<a href='<c:url value="/admin/new" />' id="payment-button"
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
		CKEDITOR.replace('description');
	</script>

</body>
