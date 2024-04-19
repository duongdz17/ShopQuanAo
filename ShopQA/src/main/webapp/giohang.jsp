<%@page import="model.User"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="model.GioHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/UserAssets" var="url"></c:url>
  <%
User user = (User) request.getSession().getAttribute("khachhang");
if (user != null) {
    request.setAttribute("khachhang", user);
}
%>
<%
	ArrayList<GioHang> cart_list = (ArrayList<GioHang>) session.getAttribute("cart-list");
	List<GioHang> cartProduct = null;
	if(cart_list != null){
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		cartProduct = sanPhamDAO.getGioHang(cart_list);
		double total= sanPhamDAO.getTotal(cart_list);
		request.setAttribute("cart_list", cart_list);
		request.setAttribute("total", total);
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<%@include file="phantachlayout/css.jsp" %>
</head>
<body>
<%@include file="phantachlayout/header.jsp" %>
	<!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Sản phẩm</th>
                            <th>Hình ảnh</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            
                            <th>Xóa</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <%if(cart_list!=null) {
			 for(GioHang c:cartProduct){%>
                        <tr>
                            <td class="align-middle"> <%=c.getTensanpham() %></td>
                            <td class="align-middle"><img src="${url }/img/<%=c.getHinhanh() %>" alt="" style="width: 50px;"></td>
                            <td class="align-middle">$<%=c.getGia() %></td>
                            <td class="align-middle">
                           
                            <input type="hidden" name="masanpham" value="<%=c.getMasanpham() %>" class="form-input">
                            
                            
                            <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <a href="tanggiam?action=giam&masanpham=<%=c.getMasanpham()%>" class="btn btn-sm btn-primary btn-minus" >
                                        <i class="fa fa-minus"></i>
                                        </a>
                                    </div>
                                    <input type="text" name="soluong" class="form-control form-control-sm bg-secondary text-center" value="<%=c.getSoluong() %>" readonly="readonly">
                                    <div class="input-group-btn">
                                        <a href="tanggiam?action=tang&masanpham=<%=c.getMasanpham()%>" class="btn btn-sm btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </a>
                                    </div>
                                </div>
                            
                            
                                
                                
                            </td>
                            
                            <td class="align-middle"><a href="xoagiohang?masanpham=<%=c.getMasanpham() %>" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a></td>
                        
                        </tr>
                   <% }
			 }
			%>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                               
                
               
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Đơn hàng của tôi</h4>
                    </div>
                    <div class="card-body">
                        <div class="d-flex justify-content-between mb-3 pt-1">
                            <h6 class="font-weight-medium">Thành tiền</h6>
                            <h6 class="font-weight-medium">$${total }</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Phí ship</h6>
                            <h6 class="font-weight-medium">$10</h6>
                        </div>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Tổng tiển</h5>
                            <h5 class="font-weight-bold">$${total + 10 }</h5>
                        </div>
                        <a href="checkout" type="submit" class="btn btn-block btn-primary my-3 py-3">Hoàn tất thanh toán</a>
                    </div>
                </div>
                
                
               
            </div>
        </div>
    </div>
    <!-- Cart End -->
    <%@include file="phantachlayout/footer.jsp" %>
</body>
</html>