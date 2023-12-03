<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<!-- title -->
<title>Liên hệ</title>

<body>


	<!-- breadcrumb-section -->
	<div class="breadcrumb-section breadcrumb-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="breadcrumb-text">
						<h1>Thanh toán</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<!-- contact form -->
	<div class="contact-from-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 mb-5 mb-lg-0">
					<div id="form_status"></div>
					<div class="contact-form">
						<form action="checkout" method="POST">
							<p>
								<input type="text" placeholder="Nhập họ tên" name="display_name"
									id="display_name" required disabled="disabled"
									value="${LoginInfo.display_name }"> <input type="email"
									placeholder="Nhập email" name="user" id="user" required
									disabled="disabled" value="${LoginInfo.user }">
							</p>
							<p>
								<input type="hidden" placeholder="Nhập họ tên"
									name="display_name" id="display_name" required
									value="${LoginInfo.display_name }"> <input
									type="hidden" placeholder="Nhập email" name="user" id="user"
									required value="${LoginInfo.user }">
							</p>
							<p>
								<input type="text" placeholder="Nhập số điện thoại" name="phone"
									id="phone" required> <input type="text"
									placeholder="Nhập địa chỉ" name="address" id="address" required>
							</p>
							<p>
								<textarea placeholder="Nhập ghi chú" name="note" id="note"
									rows="5" cols="30" required></textarea>
							</p>
							<p>
								<input type="submit" name="submitAccount" value="Đặt hàng"
									class="shopBtn exclusive">
							</p>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end contact form -->

</body>