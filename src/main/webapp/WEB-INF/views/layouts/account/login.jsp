<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/taglib.jsp"%>
<title>Đăng nhập</title>

<body>
	<form:form action="dang-nhap" method="POST" modelAttribute="user"
		class="login100-form validate-form">
		<span class="login100-form-title"> Đăng nhập </span>

		<div class="wrap-input100">
			<form:input type="email" class="input100" placeholder="Nhập email"
				path="user" />
			<span class="focus-input100"></span> <span class="symbol-input100">
				<i class="fa fa-envelope" aria-hidden="true"></i>
			</span>
		</div>

		<div class="wrap-input100">
			<form:input type="password" class="input100"
				placeholder="Nhập mật khẩu" path="password" />
			<span class="focus-input100"></span> <span class="symbol-input100">
				<i class="fa fa-lock" aria-hidden="true"></i>
			</span>
		</div>
		<c:if test="${not empty statusLogin}">
			<div style="color: red; margin-left: 40px; margin-top: 10px; font-size: 15px">${statusLogin}</div>
		</c:if>

		<div class="container-login100-form-btn">
			<button type="submit" class="login100-form-btn">Đăng nhập</button>
		</div>

		<div class="text-center p-t-12">
			<span class="txt1"> Quên </span> <a class="txt2" href="#"> Mật
				khẩu? </a>
		</div>
		<div class="text-center p-t-12">
			<span class="txt1"> Quay về </span> <a href='<c:url value="/" />'>
				Trang chủ </a>
		</div>

		<div class="text-center p-t-136">
			<a class="txt2" href="<c:url value="/account/dang-ky" />"> Tạo
				tại khoản <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
			</a>
		</div>
	</form:form>

</body>