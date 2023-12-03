<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Giỏ hàng</title>

<body>

	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<h1>Lịch sử</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- cart -->
	<div class="cart-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="cart-table-wrap">
						<table class="cart-table">
							<thead class="cart-table-head">
								<tr class="table-head-row">
									<th class="product-display_name">Tên</th>
									<th class="product-user">Email</th>
									<th class="product-phone">Số điện thoại</th>
									<th class="product-address">Địa chỉ</th>
									<th class="product-quantity">Số lượng</th>
									<th class="product-total">Tổng tiền</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${historys }">
									<tr class="table-body-row">
										<td class="product-display_name">${ item.display_name}</td>
										<td class="product-user">${ item.user}</td>
										<td class="product-phone">${ item.phone}</td>
										<td class="product-address">${ item.address}</td>
										<td class="product-quantity">${ item.quanty}</td>
										<td class="product-total">${ item.total}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="offset-md-10">

					<div class="cart-buttons">
						<a href='<c:url value="/" />' class="boxed-btn">Quay
							về</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end cart -->

</body>
