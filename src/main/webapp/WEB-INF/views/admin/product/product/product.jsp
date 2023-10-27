<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang sản phẩm</title>

<body>
	<!-- toast -->
	<%-- 	<%@include file="/WEB-INF/views/admin/notification/toast.jsp"%> --%>
	<!-- toast -->

	<div class="content">
		<!-- phóng to hình ảnh -->
		<div id="imageModal" class="modal">
			<span class="close" onclick="closeModal()">&times;</span> <img
				id="modalImage" class="modal-content" src="/path/to/placeholder.jpg">
		</div>
		<!-- ----------------- -->
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-lg-2">
					<a href='<c:url value="/admin/product/create" />'
						id="payment-button" type="button"
						class="btn btn-lg btn-info btn-block "> <span
						id="payment-button-amount">Thêm sản phẩm</span>
					</a>
				</div>
				<div class="col-lg-12 mt-4">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách sản phẩm</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Ảnh</th>
										<th>Loại</th>
										<th>Tên</th>
										<th>Giá ban đầu</th>
										<th>Giá</th>
										<th>Giảm giá</th>
										<th>Số lượng</th>
										<th>Tiêu đề</th>
										<th>Sản phẩm nổi bật</th>
										<th>Sản phẩm mới</th>
										<th>Thông tin chi tiết</th>
										<th>Chỉnh sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${products }">
										<tr>
											<td>${item.id }</td>
											<td><img alt="" height="50px"
												src="<c:url value="/assets/uploads/products/${item.img }" />"
												onclick="openModal('<c:url value="/assets/uploads/products/${item.img }" />')">
											</td>
											<td>${item.name_category }</td>
											<td>${item.name }</td>
											<td>${item.price }</td>
											<td>${item.price }</td>
											<td>${item.sale }</td>
											<td>${item.total_quality }</td>
											<td>${item.title }</td>
											<td>${item.highlight }</td>
											<td>${item.newProduct }</td>
											<td><c:out value="${item.details}" /></td>
											<td><a
												href='<c:url value="/admin/product/edit/${item.id }" />'
												type="button"><i
													class="fa fa-pencil-square text-success" aria-hidden="true"
													style="font-size: 22px;"></i></a></td>
											<td><form:form method="DELETE"
													action='product/delete/${item.id}'>
													<button type="submit" class="bg-danger text-white">
														<i class="fa fa-minus-circle" aria-hidden="true"></i>
													</button>
												</form:form></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<content tag="script"> </content>
	<script type="text/javascript">
		
	</script>
</body>
