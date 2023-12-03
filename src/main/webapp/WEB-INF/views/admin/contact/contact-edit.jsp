<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang liên hệ</title>

<body>

	<div class="breadcrumbs">
		<div class="breadcrumbs-inner">
			<div class="row m-0">
				<div class="col-sm-4">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>Liên hệ</h1>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="page-header float-right">
						<div class="page-title">
							<ol class="breadcrumb text-right">
								<li><a href="#">Trang chủ</a></li>
								<li><a href="#">liên hệ</a></li>
								<li class="active">chỉnh sửa</li>
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
						<strong class="card-title">Chỉnh sửa</strong>
					</div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<form action="#" method="post" novalidate="novalidate">
								<div class="form-group">
									<label for="phone" class="control-label mb-1">Số điện
										thoại</label> <input id="phone" name="phone" type="number"
										class="form-control" aria-required="true" aria-invalid="false"
										value="${contact.phone }">
								</div>
								<div class="form-group">
									<label for="email" class="control-label mb-1">Email</label> <input
										id="email" name="email" type="text" class="form-control"
										aria-required="true" aria-invalid="false"
										value="${contact.email }">
								</div>
								<div class="form-group">
									<label for="opening_time" class="control-label mb-1">Thời
										gian mở</label> <input id="opening_time" name="opening_time"
										type="text" class="form-control" aria-required="true"
										aria-invalid="false" value="${contact.opening_time }">
								</div>
								<div class="form-group">
									<label for="closing_time" class="control-label mb-1">Thời
										gian đóng</label> <input id="closing_time" name="closing_time"
										type="text" class="form-control" aria-required="true"
										aria-invalid="false" value="${contact.closing_time }">
								</div>
								<div class="form-group">
									<label for="address" class="control-label mb-1">Địa chỉ</label>
									<input id="address" name="address" type="text"
										class="form-control" aria-required="true" aria-invalid="false"
										value="${contact.address }">
								</div>
								<div class="form-group">
									<label for="address_map" class="control-label mb-1">Bản
										đồ</label>
									<textarea id="address_map" name="address_map"
										class="form-control" rows="5" aria-required="true"
										aria-invalid="false">${contact.address_map }</textarea>
								</div>

								<div class="row">
									<div class="col-lg-2"></div>
									<div class="col-lg-4">
										<a href='<c:url value="/admin/contact" />' id="payment-button"
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
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
