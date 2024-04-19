<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="phantachlayout/css.jsp"%>
<title>Quản lý người dùng</title>
</head>
<body>
	<div class="page-wrapper" id="main-wrapper" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed">
		<%@include file="phantachlayout/sidebar.jsp"%>

		<div class="body-wrapper">
			<%@include file="phantachlayout/header.jsp"%>

			<div class="container-fluid">
				<div class="container-fluid">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title fw-semibold mb-4">Thêm mới người dùng</h5>
							<div class="card">
								<div class="card-body p-4">
									<form action="../addUser" class="row g-3"
									method="post">
									<div class="col-12">
										<label>Họ tên</label> <input type="text"
											name="hoten" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<label>Tên đăng nhập</label> <input type="text"
											name="tendangnhap" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Mật khẩu</label> <input type="password"
											name="matkhau" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Email</label> <input type="email"
											name="email" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Số điện thoại</label> <input type="number"
											name="sodienthoai" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Địa chỉ</label> <input type="text"
											name="diachi" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Ngày sinh</label> <input type="date"
											name="ngaysinh" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Mã quyền truy cập</label> <input type="int"
											name="maquyentruycap" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Ảnh người dùng</label> <input type="file"
											name="anhnguoidung" class="form-control"/>
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Thêm
											mới</button> |
										<a href="listUser.jsp" class="btn btn-secondary">Quay lại</a>
									</div>
								</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>