<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang category</title>

<body>
	<!-- toast -->
	<%-- 	<%@include file="/WEB-INF/views/admin/notification/toast.jsp"%> --%>
	<!-- toast -->

	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-lg-3">
					<a href='<c:url value="/admin/category/create" />' id="payment-button"
						type="button" class="btn btn-lg btn-info btn-block "> <span
						id="payment-button-amount">Thêm phân loại</span>
					</a>
				</div>
				<div class="col-lg-6">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách menu</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên</th>
										<th>Mô tả</th>
										<th>Chỉnh sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${categorys }">
										<tr>
											<td>${item.id }</td>
											<td>${item.name }</td>
											<td>${item.description	 }</td>
											<td><a
												href='<c:url value="/admin/category/edit/${item.id }" />'
												type="button"><i
													class="fa fa-pencil-square text-success" aria-hidden="true"
													style="font-size: 22px;"></i></a></td>
											<td><form:form method="DELETE"
													action='category/delete/${item.id}'>
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

</body>
