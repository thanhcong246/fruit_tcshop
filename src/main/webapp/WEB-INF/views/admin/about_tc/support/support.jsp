<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang thông tin tcshop</title>

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
					<a href='<c:url value="/admin/support/create" />' id="payment-button"
						type="button" class="btn btn-lg btn-info btn-block "> <span
						id="payment-button-amount">Thêm thông tin</span>
					</a>
				</div>
				<div class="col-lg-12 mt-4">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Ảnh</th>
										<th>Icon</th>
										<th>Tiêu đề</th>
										<th>Nội dung</th>
										<th>Chỉnh sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${supports }">
										<tr>
											<td>${item.id }</td>
											<td><img alt="" height="50px"
												src="<c:url value="/assets/uploads/supports/${item.img }" />"
												onclick="openModal('<c:url value="/assets/uploads/supports/${item.img }" />')">
											</td>
											<td>${item.icon }</td>
											<td>${item.name }</td>
											<td>${item.description }</td>
											<td><a
												href='<c:url value="/admin/support/edit/${item.id }" />'
												type="button"><i
													class="fa fa-pencil-square text-success" aria-hidden="true"
													style="font-size: 22px;"></i></a></td>
											<td><form:form method="DELETE"
													action='support/delete/${item.id}'>
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
