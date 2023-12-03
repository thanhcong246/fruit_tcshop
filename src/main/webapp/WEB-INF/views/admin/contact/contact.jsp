<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang liên hệ</title>

<body>
	<style>
.map {
	position: relative;
	padding-bottom: 75%; /* Chỉnh chiều cao của bản đồ tại đây (vd: 75%) */
	padding-top: 30px;
	height: 0;
	overflow: hidden;
}

.map iframe {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>
	<!-- toast -->
	<%-- 	<%@include file="/WEB-INF/views/admin/notification/toast.jsp"%> --%>
	<!-- toast -->

	<div class="content">
		<div class="animated fadeIn">

			<div class="row">
				<div class="col-lg-3">
					<c:if test="${contacts.size() < 1 }">
						<a href='<c:url value="/admin/contact/create" />'
							id="payment-button" type="button"
							class="btn btn-lg btn-info btn-block "> <span
							id="payment-button-amount">Tạo trang liên hệ</span>
						</a>
					</c:if>
					<c:if test="${contacts.size() >= 1 }">
						<a href='#' id="payment-button" type="button"
							class="btn btn-lg btn-secondary btn-block "> <span
							id="payment-button-amount">Tạo trang liên hệ</span>
						</a>
					</c:if>
				</div>
				<c:forEach var="item" items="${contacts }">
					<div class="col-lg-3">
						<a href='<c:url value="/admin/contact/edit/${item.id }" />'
							id="payment-button" type="button"
							class="btn btn-lg btn-info btn-block "> <span
							id="payment-button-amount">Sửa trang liên hệ</span>
						</a>
					</div>
					<div class="col-lg-12 mt-4">
						<div class="card">
							<div class="card-header">
								<strong class="card-title">Liên hệ</strong>
							</div>
							<div class="row mt-4">
								<div class="col-lg-1"></div>
								<div class="col-lg-5">
									<div class="form-group">
										<label for="phone" class="control-label mb-1">Số điện
											thoại</label> <input id="phone" name="phone" type="text"
											disabled="disabled" class="form-control" aria-required="true"
											aria-invalid="false" value="${item.phone }">
									</div>
									<div class="form-group">
										<label for="email" class="control-label mb-1">Email</label> <input
											id="email" name="email" type="text" disabled="disabled"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${item.email }">
									</div>
									<div class="row">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="opening_time" class="control-label mb-1">Thời
													gian mở</label> <input id="opening_time" name="opening_time"
													type="text" disabled="disabled" class="form-control"
													aria-required="true" aria-invalid="false"
													value="${item.opening_time }">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label for="closing_time" class="control-label mb-1">Thời
													gian đóng</label> <input id="closing_time" name="closing_time"
													type="text" disabled="disabled" class="form-control"
													aria-required="true" aria-invalid="false"
													value="${item.closing_time }">
											</div>
										</div>
									</div>
									<div class="form-group">
										<label for="address" class="control-label mb-1">Địa
											chỉ</label> <input id="address" name="address" type="text"
											disabled="disabled" class="form-control" aria-required="true"
											aria-invalid="false" value="${item.address }">
									</div>
								</div>
								<div class="col-lg-5">
									<div class="card">
										<div class="card-header">
											<h4>Bản đồ</h4>
										</div>
										<div class="map">
											<iframe src="${item.address_map }" width="600" height="450"
												style="border: 0;" allowfullscreen="" loading="lazy"
												referrerpolicy="no-referrer-when-downgrade"></iframe>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<content tag="script"> </content>

</body>
