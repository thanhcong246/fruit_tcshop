<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang slide</title>

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
					<a href='<c:url value="/admin/slide/create" />'
						id="payment-button" type="button"
						class="btn btn-lg btn-info btn-block "> <span
						id="payment-button-amount">Thêm Slide</span>
					</a>
				</div>
				<div class="col-lg-12 mt-4">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách menu</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Ảnh</th>
										<th>Tiêu đề</th>
										<th>Nội dung</th>
										<th>Tên menu 1</th>
										<th>Đường dẫn menu 1</th>
										<th>Tên menu 2</th>
										<th>Đường dẫn menu 2</th>
										<th>Chỉnh sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${slides }">
										<tr>
											<td>${item.id }</td>
											<td><img alt=""
												src="<c:url value="/assets/uploads/${item.img }" />"
												onclick="openModal('<c:url value="/assets/user/assets/img/${item.img }" />')">
											</td>
											<td>${item.caption }</td>
											<td>${item.content }</td>
											<td>${item.name }</td>
											<td>${item.url }</td>
											<td>${item.name2 }</td>
											<td>${item.url2 }</td>
											<td><a
												href='<c:url value="/admin/slide/edit/${item.id }" />'
												type="button"><i
													class="fa fa-pencil-square text-success" aria-hidden="true"
													style="font-size: 22px;"></i></a></td>
											<td><form:form method="DELETE"
													action='slide/delete/${item.id}'>
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
