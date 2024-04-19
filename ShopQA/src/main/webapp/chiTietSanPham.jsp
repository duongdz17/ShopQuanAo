<%@page import="model.GioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/UserAssets" var="url"></c:url>
<%
	ArrayList<GioHang> cart_list = (ArrayList<GioHang>) session.getAttribute("cart-list");
	
	if(cart_list != null){
		
		request.setAttribute("cart_list", cart_list);	
	}
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Shop quần áo</title>
    <%@include file="phantachlayout/css.jsp" %>
</head>
<body>
	<%@include file="phantachlayout/header.jsp" %>
	<%
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		SanPham sanPham = sanPhamDAO.getSanPhamById(Integer.parseInt(request.getParameter("masanpham")));
	%>
	<!-- Shop Detail Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col-lg-5 pb-5">
                <div id="product-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner border">
                        <div class="carousel-item active">
                            <img class="w-100 h-100" src="${url}/img/<%=sanPham.getHinhanh() %>" alt="Image">
                        </div>
                        
                    </div>
                    
                </div>
            </div>

            <div class="col-lg-7 pb-5">
                <h3 class="font-weight-semi-bold">Tên sản phẩm: <%=sanPham.getTensanpham() %></h3>
               
                <h3 class="font-weight-semi-bold mb-4">Giá: <%=sanPham.getGia() %><h3>
                
                <h3 class="font-weight-semi-bold mb-4">Mô tả: <%=sanPham.getMota() %><h3>
                
                
                <div class="d-flex align-items-center mb-4 pt-2">
                    
                    <a href="addgiohangchitiet?masanpham=<%=sanPham.getMasanpham() %>" class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Thêm vào giỏ hàng</a>
                </div>
                
            </div>
        </div>
        
    </div>
    <!-- Shop Detail End -->

</body>
</html>