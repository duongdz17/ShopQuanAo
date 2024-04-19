<%@page import="model.QuyenTruyCap"%>
<%@page import="dao.QuyenTruyCapDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<c:url value="/UserAssets" var="urluser"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="phantachlayout/css.jsp"%>
<title>Quản lý quyền truy cập</title>
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
							<h5 class="card-title fw-semibold mb-4">Cập nhật quyền truy cập</h5>
								<%
									int maquyentruycap = Integer.parseInt(request.getParameter("maquyentruycap"));
									QuyenTruyCapDAO quyenTruyCapDAO = new QuyenTruyCapDAO();
									QuyenTruyCap quyenTruyCap = quyenTruyCapDAO.getQuyenTruyCapById(maquyentruycap);
								%>
							<div class="card">
								<div class="card-body p-4">
									<form action="../updateQuyenTruyCap" class="row g-3"
									method="post">
									<div class="col-12" hidden="">
										<label>Mã quyền truy cập</label> <input type="text" readonly="readonly"
											name="maquyentruycap" value="<%=quyenTruyCap.getMaquyentruycap()%>" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<label>Tên quyền truy cập</label> <input type="text"
											name="tenquyentruycap" value="<%=quyenTruyCap.getTenquyentruycap() %>" class="form-control" required="required" />
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-primary">Cập nhật</button> |
										<a href="listQuyenTruyCap.jsp" class="btn btn-secondary">Quay lại</a>
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