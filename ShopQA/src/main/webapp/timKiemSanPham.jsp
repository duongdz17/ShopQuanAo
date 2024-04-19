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
	<!-- Shop Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <!-- Shop Sidebar Start -->
            <div class="col-lg-3 col-md-12">
               
            </div>
            <!-- Shop Sidebar End -->
			<%
				SanPhamDAO sanPhamDAO = new SanPhamDAO();
                String timKiem = request.getParameter("timKiem");
                List<SanPham> sanPhams = sanPhamDAO.getTimKiemSanPham(timKiem);            		
                
			%>

            <!-- Shop Product Start -->
            <div class="col-lg-9 col-md-12">
                <div class="row pb-3">
                    
                    
                    
                    
                    <%for(SanPham sanPham : sanPhams) { %>
                    
           
                    
                    
                    <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                        <div class="card product-item border-0 mb-4">
                            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                <img class="img-fluid w-100" src="${url }/img/<%=sanPham.getHinhanh() %>" alt="">
                            </div>
                            <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                <h6 class="text-truncate mb-3"><%=sanPham.getTensanpham() %></h6>
                                <div class="d-flex justify-content-center">
                                    <h6><%=sanPham.getGia() %></h6>
                                    <!--<h6 class="text-muted ml-2"><del>$123.00</del></h6>  -->
                                </div>
                            </div>
                            <div class="card-footer d-flex justify-content-between bg-light border">
                               <a href="chiTietSanPham.jsp?masanpham=<%=sanPham.getMasanpham() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>Chi tiết sản phẩm</a>
                                <a href="addgiohangtimkiem?masanpham=<%=sanPham.getMasanpham() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                            </div>
                        </div>
                    </div>
                    <%} %>
                    <div class="col-12 pb-1">
                        <nav aria-label="Page navigation">
                          <ul class="pagination justify-content-center mb-3">
                            <li class="page-item disabled">
                              <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                              </a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                              <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                              </a>
                            </li>
                          </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Shop Product End -->
        </div>
    </div>
    <!-- Shop End -->
	<%@include file="phantachlayout/footer.jsp" %>
</body>
</html>