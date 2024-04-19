<%@page import="model.SanPham"%>
<%@page import="java.util.List"%>
<%@page import="dao.SanPhamDAO"%>
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
<title>Quản lý sản phẩm</title>
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
							<h5 class="card-title fw-semibold mb-4">Danh sách sản phẩm</h5>
							<div class="card">
								<div class="card-body p-4">
									<a class="btn btn-danger mb-2"
										href="addSanPham.jsp">Thêm mới sản phẩm</a>
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
												<th>Mã sản phẩm</th>
												<th>Tên sản phẩm</th>
												<th>Mô tả</th>
												<th>Giá</th>
												<th>Giảm giá</th>
												<th>Hình ảnh</th>
												<th>Mã danh mục</th>
												<th>Ngày tạo</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<%
												SanPhamDAO sanPhamDAO = new SanPhamDAO();
												List<SanPham> sanPhams = sanPhamDAO.getAllSanPham();
												for(SanPham sanPham : sanPhams) {
 											%>
												<tr>
												<th><%=sanPham.getMasanpham() %></th>
												<th><%=sanPham.getTensanpham() %></th>
												<th><%=sanPham.getMota() %></th>
												<th><%=sanPham.getGia() %></th>
												<th><%=sanPham.getGiamgia() %></th>
												<td>
													<img style="width: 100px; height: 50px" alt="" src="${urluser }/img/<%=sanPham.getHinhanh() %>">
													</td>
												<th><%=sanPham.getMadanhmuc() %></th>
												<th><%=sanPham.getNgaytao() %></th>
													<td>
													<a href="updateSanPham.jsp?masanpham=<%=sanPham.getMasanpham() %>">
														<i class="fa-solid fa-pen-to-square"></i></a> |
													<a href="#" onclick="confirmDelete('<%=sanPham.getMasanpham() %>')">
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

		function confirmDelete(masanpham) {
            if (confirm("Bạn có chắc muốn xóa sản phẩm này?")) {
                window.location.href = "../deleteSanPham?masanpham=" + masanpham;
            }
        }
	</script>
</body>
</html>
