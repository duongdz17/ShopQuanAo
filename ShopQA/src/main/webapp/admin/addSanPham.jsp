<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="phantachlayout/css.jsp"%>
<title>Quản lý sản phẩm</title>
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
							<h5 class="card-title fw-semibold mb-4">Thêm mới sản phẩm</h5>
							<div class="card">
								<div class="card-body p-4">
								<c:if test="${not empty succMsg }">
									<p class="alert alert-success text-center" role="alert">${succMsg}</p>
									<c:remove var="succMsg" scope="session" />
								</c:if>
								<c:if test="${not empty failedMsg }">
									<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
									<c:remove var="failedMsg" scope="session" />
								</c:if>
									<form action="../addSanPham" class="row g-3" method="post" onsubmit="return validateForm()">
									<div class="col-12">
										<label>Tên sản phẩm</label> <input type="text"
											name="tensanpham" class="form-control" />
									</div>
									<div class="col-12">
										<label>Mô tả</label> <input type="text"
											name="mota" class="form-control" />
									</div>
									<div class="col-12">
										<label>Giá</label> <input type="number"
											name="gia" class="form-control" />
									</div>
									<div class="col-12" >
										<label>Giảm giá</label> <input type="number"
											name="giamgia" class="form-control"  />
									</div>
									<div class="col-12">
										<label>Hình ảnh</label> <input type="text"
											name="hinhanh" class="form-control" />
									</div>
									<div class="col-12">
										<label>Mã danh mục</label> <input type="number"
											name="madanhmuc" class="form-control" />
									</div>
									<div class="col-12">
										<label>Ngày tạo</label> <input type="date"
											name="ngaytao" class="form-control" />
									</div>
									
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Thêm
											mới</button> |
										<a href="listSanPham.jsp" class="btn btn-secondary">Quay lại</a>
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
<script>
    function validateForm() {
        var tensanpham = document.forms[0]["tensanpham"].value;
        var mota = document.forms[0]["mota"].value;
        var gia = document.forms[0]["gia"].value;
        var giamgia = document.forms[0]["giamgia"].value;
        var hinhanh = document.forms[0]["hinhanh"].value;
        var madanhmuc = document.forms[0]["madanhmuc"].value;
        var ngaytao = document.forms[0]["ngaytao"].value;

        if (tensanpham == "" && mota == "" && gia == "" && giamgia == "" && hinhanh == "" && madanhmuc == "" && ngaytao == "") {
            alert("Vui lòng điền đầy đủ thông tin.");
            return false;
        }
    }
</script>
</html>