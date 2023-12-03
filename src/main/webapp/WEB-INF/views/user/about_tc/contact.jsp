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
						<p>Hỗ trợ 24/7</p>
						<h1>Liên hệ chúng tôi</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end breadcrumb section -->

	<c:forEach var="item" items="${contacts }">
		<!-- contact form -->
		<div class="contact-from-section mt-150 mb-150">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 mb-5 mb-lg-0">
						<div class="form-title">
							<h2>Đặt câu hỏi cho chúng tôi?</h2>
							<p>Bạn có thắc mặc hay có vấn đề gì cần giải quyết thì lên hệ
								với chúng tôi.</p>
						</div>
						<div id="form_status"></div>
						<div class="contact-form">
							<form type="POST" id="fruitkha-contact"
								onSubmit="return valid_datas( this );">
								<p>
									<input type="text" placeholder="Tên" name="name" id="name">
									<input type="email" placeholder="Email" name="email" id="email">
								</p>
								<p>
									<input type="tel" placeholder="Số điện thoại" name="phone"
										id="phone"> <input type="text" placeholder="Tiêu đề"
										name="subject" id="subject">
								</p>
								<p>
									<textarea name="message" id="message" cols="30" rows="10"
										placeholder="Nội dung cần gửi"></textarea>
								</p>
								<input type="hidden" name="token" value="FsWga4&@f6aw" />
								<p>
									<input type="submit" value="Gửi">
								</p>
							</form>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="contact-form-wrap">
							<div class="contact-form-box">
								<h4>
									<i class="fas fa-map"></i> Địa chỉ cửa hàng
								</h4>
								<p>${item.address }</p>
							</div>
							<div class="contact-form-box">
								<h4>
									<i class="far fa-clock"></i> Thời gian mở
								</h4>
								<p>
									Từ: ${item.opening_time } <br> Đến: ${item.closing_time }
								</p>
							</div>
							<div class="contact-form-box">
								<h4>
									<i class="fas fa-address-book"></i> Liên hệ
								</h4>
								<p>
									Số điện thoại: ${item.phone } <br> Email: ${item.email }
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end contact form -->

		<!-- find our location -->
		<div class="find-location blue-bg">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<p>
							<i class="fas fa-map-marker-alt"></i> Tìm vị trí của chúng tôi
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- end find our location -->

		<!-- google map section -->
		<div class="embed-responsive embed-responsive-21by9">
			<iframe src="${item.address_map }" width=" 600" height="450"
				frameborder="0" style="border: 0;" allowfullscreen=""
				class="embed-responsive-item"></iframe>
		</div>
		<!-- end google map section -->
	</c:forEach>

</body>