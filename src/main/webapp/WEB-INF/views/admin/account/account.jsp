<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang tài khoản</title>

<body>

	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-lg-4">
					<a href='#'
						id="payment-button" type="button"
						class="btn btn-lg btn-info btn-block "> <span
						id="payment-button-amount">Thêm tài khoản người dùng</span>
					</a>
				</div>
				<div class="col-lg-12 mt-4">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Danh sách tài khoản</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên</th>
										<th>Mật khẩu</th>
										<th>Biệt danh</th>
										<th>Địa chỉ</th>
										<th>Kích hoạt</th>
										<th>Chỉnh sửa</th>
										<th>Xóa</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${accounts }">
										<tr>
											<td>${item.id }</td>
											<td>${item.user }</td>
											<td>${item.password	 }</td>
											<td>${item.display_name	 }</td>
											<td>${item.address	 }</td>
											<td>${item.active	 }</td>
											<td><a
												href='<c:url value="/admin/account/edit/${item.id }" />'
												type="button"><i
													class="fa fa-pencil-square text-success" aria-hidden="true"
													style="font-size: 22px;"></i></a></td>
											<td><form:form method="DELETE"
													action='account/delete/${item.id}'>
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
