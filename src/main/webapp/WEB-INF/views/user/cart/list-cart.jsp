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
						<h1>Giỏ hàng</h1>
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
				<div class="col-lg-8 col-md-12">
					<div class="cart-table-wrap">
						<table class="cart-table">
							<thead class="cart-table-head">
								<tr class="table-head-row">
									<th class="product-remove"></th>
									<th class="product-image">Hình ảnh</th>
									<th class="product-name">Tên</th>
									<th class="product-price">Giá</th>
									<th class="product-quantity">Số lượng (Kg)</th>
									<th class="product-quantity">Còn (Kg)</th>
									<th class="product-total">Tổng tiền</th>
									<th class="product-total">Cập nhật</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${Cart }">
									<tr class="table-body-row">
										<td class="product-remove"><a
											href='<c:url value="/DeleteCart/${item.key }" />'
											type="button"><i class="far fa-window-close"></i></a></td>
										<td class="product-image"><img
											src="<c:url value="/assets/user/assets/img/products/${item.value.product.img }" />"
											alt=""></td>
										<td class="product-name">${item.value.product.name }</td>
										<td class="product-price"><fmt:formatNumber type="number"
												groupingUsed="true" value="${item.value.product.price }" />₫</td>
										<td class="product-quantity"><input
											id="quanty-cart-${item.key }" size="10" type="number" min="0"
											max="100" value="${item.value.quanty }"
											oninput="checkValue(this, ${item.value.product.total_quality})"></td>
										<td class="product-name">${item.value.product.total_quality }</td>
										<td class="product-total"><fmt:formatNumber type="number"
												groupingUsed="true" value="${item.value.totalPrice }" />₫</td>
										<td><button data-id="${item.key }"
												class="btn btn-mini btn-success edit-cart" type="button">
												<i class="fas fa-pen-square"></i>
											</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="col-lg-4">
					<div class="total-section">
						<table class="total-table">
							<thead class="total-table-head">
								<tr class="table-total-row">
									<th>Tổng cộng</th>
									<th>Giá</th>
								</tr>
							</thead>
							<tbody>
								<tr class="total-data">
									<td><strong>Tổng sản phẩm: </strong></td>
									<td><fmt:formatNumber type="number" groupingUsed="true"
											value="${TotalPriceCart }" />₫</td>
								</tr>
								<tr class="total-data">
									<td><strong>Phí Ship: </strong></td>
									<td>$45</td>
								</tr>
								<tr class="total-data">
									<td><strong>Tổng: </strong></td>
									<td>$545</td>
								</tr>
							</tbody>
						</table>
						<div class="cart-buttons">
							<a href='<c:url value="/san-pham" />' class="boxed-btn">Quay
								về</a> <a href="checkout.html" class="boxed-btn black">Thanh
								toán</a>
						</div>
					</div>

					<div class="coupon-section">
						<h3>Mã giảm giá</h3>
						<div class="coupon-form-wrap">
							<form action="index.html">
								<p>
									<input type="text" placeholder="...">
								</p>
								<p>
									<input type="submit" value="Áp dụng">
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end cart -->

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<content tag="script"> <script type="text/javascript">
		$(".edit-cart").on("click", function() {
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-" + id).val();
			window.location = "EditCart/" + id + "/" + quanty;
		});

		function checkValue(input, maxQuantity) {
			// Chuyển đổi giá trị thành số nguyên
			var value = parseInt(input.value);

			// Kiểm tra nếu giá trị nhỏ hơn 0 hoặc lớn hơn maxQuantity
			if (isNaN(value) || value < 0) {
				input.value = "0"; // Đặt giá trị về 0 nếu nhỏ hơn 0
			} else if (value > maxQuantity) {
				input.value = maxQuantity; // Đặt giá trị về maxQuantity nếu lớn hơn maxQuantity
			}
		}
	</script> </content>

</body>
