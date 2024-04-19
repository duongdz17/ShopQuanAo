<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/UserAssets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<%@include file="phantachlayout/css.jsp" %>
</head>
<body>
<%@include file="phantachlayout/header.jsp" %>
<div class="container">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Đăng nhập tài khoản</h3>
						<c:if test="${not empty succMsg }">
							<p class="alert alert-success text-center" role="alert">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failedMsg }">
							<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
						<form action="dangNhapKhachHang" method="post">
							<div class="mb-3">
								<label>Tên đăng nhập</label> <input type="text"
									class="form-control"  name="tendangnhap">
							</div>
							<div class="mb-3">
								<label>Mật khẩu</label> <input type="password"
									class="form-control" name="matkhau">
							</div>
							<div class="mb-3" hidden="">
								<label>Role_id</label> <input type="text"
									class="form-control" required="required" value="2" name="maquyentruycap">
							</div>
							<div>
								<a href="forgotPassword.jsp">Quên mật khẩu?</a>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Đăng nhập</button>
								<br> <a href="dangKy.jsp"
									style="text-decoration: none">Tạo tài khoản</a>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>