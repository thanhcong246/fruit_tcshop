<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Trang lịch sử</title>

<body>
	<!-- toast -->
	<%-- 	<%@include file="/WEB-INF/views/admin/notification/toast.jsp"%> --%>
	<!-- toast -->

	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Lịch sử sản phẩm</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên</th>
										<th>Email</th>
										<th>Số điện thoại</th>
										<th>Địa chỉ</th>
										<th>Số lượng</th>
										<th>Tổng tiền</th>


									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${ historys }">
										<tr>
											<td>${item.id }</td>
											<td>${ item.display_name}</td>
											<td>${ item.user}</td>
											<td>${ item.phone}</td>
											<td>${ item.address}</td>
											<td>${ item.quanty}</td>
											<td>${ item.total}</td>
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
