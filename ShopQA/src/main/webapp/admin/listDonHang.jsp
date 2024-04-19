
<%@page import="dao.KetNoiCSDL"%>
<%@page import="model.DonHang"%>
<%@page import="java.util.List"%>
<%@page import="dao.DonHangDAO"%>
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
<title>Quản lý đơn hàng</title>
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
							<h5 class="card-title fw-semibold mb-4">Danh sách đơn hàng</h5>
							<div class="card">
								<div class="card-body p-4">
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
												<th>Mã đơn hàng</th>
												<th>Mã sản phẩm</th>
												<th>Mã người dùng</th>
												<th>Họ tên</th>
												<th>Email</th>
												<th>Số điện thoại</th>
												<th>Địa chỉ</th>
												<th>Số lượng</th>
												<th>Ngày đặt</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<%
											DonHangDAO donHangDAO = new DonHangDAO(KetNoiCSDL.getConnection());
											List<DonHang> list = donHangDAO.getAllDonHang();
											for(DonHang donHang : list) {
 											%>
												<tr>
													<td><%=donHang.getMadonhang() %></td>
													<td><%=donHang.getMasanpham() %></td>
													<td><%=donHang.getUserid() %></td>
													<td><%=donHang.getHoten() %></td>
													<td><%=donHang.getEmail() %></td>
													<td><%=donHang.getSodienthoai() %></td>
													<td><%=donHang.getDiachi() %></td>
													<td><%=donHang.getSoluong() %></td>
													<td><%=donHang.getDate() %></td>
													<td>
													<a href="../deleteDonHang?madonhang=<%=donHang.getMadonhang() %>"> 
													<i class="fa-solid fa-trash"></i></a></td>
													</td>
													
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