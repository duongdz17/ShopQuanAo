<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="phantachlayout/css.jsp"%>
<title>Quản lý ảnh nhà tài trợ</title>
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
							<h5 class="card-title fw-semibold mb-4">Thêm mới ảnh</h5>
							<div class="card">
								<div class="card-body p-4">
									<form action="../addAnhNTT" class="row g-3"
									method="post">
									<div class="col-12">
										<label>Tên ảnh</label> <input type="text"
											name="tenanh" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<label>Ảnh </label> <input type="file"
											name="anhnhatt" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Thêm
											mới</button> |
										<a href="listAnhNTT.jsp" class="btn btn-secondary">Quay lại</a>
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