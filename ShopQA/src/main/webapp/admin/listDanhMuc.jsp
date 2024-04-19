<%@page import="model.DanhMuc"%>
<%@page import="java.util.List"%>
<%@page import="dao.DanhMucDAO"%>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>
<title>Quản lý danh mục</title>
</head>
<body style="background-color: #9C9C9C">
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
							<h5 class="card-title fw-semibold mb-4">Danh sách danh mục
								sản phẩm</h5>
							<div class="card">
								<div class="card-body p-4">
									<a class="btn btn-danger mb-2"
										href="addDanhMuc.jsp">Thêm mới
										danh mục sản phẩm</a>
									<c:if test="${not empty succMsg}">
										<p class="text-center text-success">${succMsg }</p>
										<c:remove var="succMsg" scope="session" />
									</c:if>

									<c:if test="${not empty failedMsg}">
										<p class="text-center text-danger">${failedMsg }</p>
										<c:remove var="failedMsg" scope="session" />
									</c:if>
									<table class="table" id="myTable">
										<thead>
											<tr>
												<th>Mã loại sản phẩm</th>
												<th>Tên loại sản phẩm</th>
												<th>Ảnh loại sản phẩm</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<%
												DanhMucDAO danhMucDAO = new DanhMucDAO();
												List<DanhMuc> list = danhMucDAO.getAllDanhMuc();
												for(DanhMuc danhMuc : list) {
 											%>
												<tr>
													<td><%=danhMuc.getMadanhmuc() %></td>
													<td><%=danhMuc.getTendanhmuc() %></td>
													<td>
													<img style="width: 100px; height: 50px" alt="" src="${urluser }/img/<%=danhMuc.getAnhdanhmuc() %>">
													</td>
													<td>
													<a href="updateDanhMuc.jsp?madanhmuc=<%=danhMuc.getMadanhmuc() %>">
														<i class="fa-solid fa-pen-to-square"></i></a> | 
													<a href="../deleteDanhMuc?madanhmuc=<%=danhMuc.getMadanhmuc() %>"> 
													<i class="fa-solid fa-trash"></i></a></td>
												</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready( function () {
	    	$('#myTable').DataTable();
		} );
	</script>
</body>
</html>