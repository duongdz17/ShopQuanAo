<%@page import="model.User"%>
<%@page import="dao.UserDAO"%>
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
							<h5 class="card-title fw-semibold mb-4">Cập nhật người dùng</h5>
								<%
								int userid = Integer.parseInt(request.getParameter("userid"));
								UserDAO userDAO = new UserDAO();
								User user = userDAO.getUserById(userid);
									
								%>
							<div class="card">
								<div class="card-body p-4">
									<form action="../updateUser" class="row g-3"
									method="post">
									<div class="col-12" hidden="">
										<label>Mã người dùng</label> <input type="text" readonly="readonly"
											name="userid" value="<%=user.getUserid() %>" class="form-control" />
									</div>
									<div class="col-12">
										<label>Họ tên</label> <input type="text"
											name="hoten" value="<%=user.getHoten() %>" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<label>Tên đăng nhập</label> <input type="text"
											name="tendangnhap" value="<%=user.getTendangnhap() %>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Mật khẩu</label> <input type="password"
											name="matkhau" value="<%=user.getMatkhau() %>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Email</label> <input type="email"
											name="email" value="<%=user.getEmail() %>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Số điện thoại</label> <input type="number"
											name="sodienthoai" value="<%=user.getSodienthoai() %>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Địa chỉ</label> <input type="text"
											name="diachi" value="<%=user.getDiachi()%>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Ngày sinh</label> <input type="date"
											name="ngaysinh" value="<%=user.getNgaysinh()%>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Mã quyền truy cập</label> <input type="int"
											name="maquyentruycap" value="<%=user.getMaquyentruycap() %>" class="form-control" required="required"/>
									</div>
									<div class="col-12">
										<label>Ảnh người dùng</label> <input type="file"
											name="anhnguoidung" value="<%=user.getAnhnguoidung() %>" class="form-control"/>
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Cập nhật</button> |
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