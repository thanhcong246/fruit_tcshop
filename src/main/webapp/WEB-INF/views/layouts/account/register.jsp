<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>

<title>Đăng ký</title>

<body>
	<form:form class="login100-form validate-form" action="dang-ky"
		method="POST" modelAttribute="user">
		<span class="login100-form-title"> Đăng ký tài khoản </span>

		<div class="wrap-input100">
			<form:input type="email" class="input100" placeholder="Nhập email"
				path="user" />
			<span class="focus-input100"></span> <span class="symbol-input100">
				<i class="fa fa-envelope" aria-hidden="true"></i>
			</span>
		</div>
		<form:errors style="color: red; margin-left:30px; font-size:13px"
			path="user" />
		<c:if test="${not empty status }">
			<span style="color: red; margin-left: 30px; font-size: 13px">${status }</span>
		</c:if>

		<div class="wrap-input100 ">
			<form:input type="password" class="input100"
				placeholder="Nhập mật khẩu" path="password" />
			<span class="focus-input100"></span> <span class="symbol-input100">
				<i class="fa fa-lock" aria-hidden="true"></i>
			</span>
		</div>

		<form:errors path="password"
			style="color: red; margin-left:30px; font-size:13px;" />

		<div class="wrap-input100 ">
			<form:input type="password" class="input100"
				placeholder="Nhập lại mật khẩu" path="confirmPassword" />
			<span class="focus-input100"></span> <span class="symbol-input100">
				<i class="fa fa-lock" aria-hidden="true"></i>
			</span>
		</div>

		<form:errors path="confirmPassword"
			style="color: red; margin-left:30px; font-size:13px" />

		<div class="wrap-input100 ">
			<form:input type="text" class="input100" placeholder="Nhập họ và tên"
				path="display_name" />
			<span class="focus-input100"></span> <span class="symbol-input100">
				<i class="fa fa-user" aria-hidden="true"></i>
			</span>
		</div>

		<form:errors path="display_name"
			style="color: red; margin-left:30px; font-size:13px" />

		<div class="container-login100-form-btn">
			<button type="submit" class="login100-form-btn">Đăng ký</button>
		</div>
		<div class="text-center p-t-12">
			<span class="txt1"> Quay về </span> <a href='<c:url value="/" />'>
				Trang chủ </a>
		</div>

		<div class="text-center p-t-136">
			<a class="txt2" href='<c:url value="/account/dang-nhap" />'> Đăng
				nhập <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
			</a>
		</div>
	</form:form>

</body>