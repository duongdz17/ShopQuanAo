<%@page import="dao.DonHangDAO"%>
<%@page import="dao.KetNoiCSDL"%>

<%@page import="model.DonHang"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.GioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/UserAssets" var="url"></c:url>
  <%
  java.util.Date utilDate = new java.util.Date();
	 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
  DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
User user = (User) request.getSession().getAttribute("khachhang");
List<DonHang> donHangs = null;
if (user != null) {
    request.setAttribute("khachhang", user);
    DonHangDAO orderDao  = new DonHangDAO(KetNoiCSDL.getConnection());
	donHangs = orderDao.userOrders(user.getUserid());
}else{
	response.sendRedirect("dangNhap.jsp");
}

%>
<%
	ArrayList<GioHang> cart_list = (ArrayList<GioHang>) session.getAttribute("cart-list");
	
	if(cart_list != null){
		
		request.setAttribute("cart_list", cart_list);
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng</title>
<%@include file="phantachlayout/css.jsp" %>
</head>
<body>
<%@include file="phantachlayout/header.jsp" %>
<div class="container">
		<div class="card-header my-3">Đơn hàng của tôi</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Ngày đặt</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Hình ảnh</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Giá</th>
					
				</tr>
			</thead>
			<tbody>
			
			<%
			if(donHangs != null){
				for(DonHang o:donHangs){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getTensanpham()%></td>
						<td><img style="width: 100px; height: 50px" alt="" src="${url }/img/<%=o.getHinhanh()%>"></td>
						<td><%=o.getSoluong() %></td>
						<td><%=dcf.format(o.getGia()) %></td>
						
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
</body>
</html>