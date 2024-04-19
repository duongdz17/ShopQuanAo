<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="phantachlayout/css.jsp"%>
<title>Quản lý danh mục</title>
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
							<h5 class="card-title fw-semibold mb-4">Thêm mới danh mục
								sản phẩm</h5>
							<div class="card">
								<div class="card-body p-4">
									<form action="../addDanhMuc" class="row g-3"
									method="post">
									<div class="col-12">
										<label>Tên danh mục</label> <input type="text"
											name="tendanhmuc" class="form-control" />
									</div>
									<div class="col-12">
										<label>Ảnh danh mục</label> <input type="file"
											name="anhdanhmuc" class="form-control" />
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Thêm
											mới</button> |
										<a href="listDanhMuc.jsp" class="btn btn-secondary">Quay lại</a>
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