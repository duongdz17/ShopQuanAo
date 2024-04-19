<%@page import="model.AnhNhaTaiTro"%>
<%@page import="dao.AnhNhaTaiTroDAO"%>
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
							<h5 class="card-title fw-semibold mb-4">Cập nhật ảnh</h5>
								<%
									int maanhntt = Integer.parseInt(request.getParameter("maanhntt"));
									AnhNhaTaiTroDAO anhNhaTaiTroDAO = new AnhNhaTaiTroDAO();
									AnhNhaTaiTro anhNhaTaiTro = anhNhaTaiTroDAO.getAnhNhaTaiTroById(maanhntt);
									
								%>
							<div class="card">
								<div class="card-body p-4">
									<form action="../updateAnhNTT" class="row g-3"
									method="post">
									<div class="col-12" hidden="">
										<label>Mã ảnh</label> <input type="text" readonly="readonly"
											name="maanhntt" value="<%=anhNhaTaiTro.getMaanhntt() %>" class="form-control" />
									</div>
									<div class="col-12">
										<label>Tên danh mục</label> <input type="text"
											name="tenanh" value="<%=anhNhaTaiTro.getTenanh() %>" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<label>Ảnh nhà tài trợ</label> <input type="file"
											name="anhnhatt" <%=anhNhaTaiTro.getAnhnhatt() %> class="form-control" required="required" />
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Cập nhật</button> |
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