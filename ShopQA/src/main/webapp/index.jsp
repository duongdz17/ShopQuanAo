<%@page import="model.User"%>
<%@page import="model.GioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AnhNhaTaiTro"%>
<%@page import="dao.AnhNhaTaiTroDAO"%>
<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.DanhMuc"%>
<%@page import="java.util.List"%>
<%@page import="dao.DanhMucDAO"%>
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
	<c:if test="${not empty succMsg }">
		<p class="alert alert-success text-center" role="alert">${succMsg}</p>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failedMsg}">
										<p class="text-center text-danger">${failedMsg }</p>
										<c:remove var="failedMsg" scope="session" />
									</c:if>
	<%@include file="phantachlayout/header.jsp" %>
	
   
	<%
		DanhMucDAO danhMucDAO2 = new DanhMucDAO();
        List<DanhMuc> list2 = danhMucDAO.getAllDanhMuc();
	%>

    <!-- Categories Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5 pb-3">
            
            
           <% for(DanhMuc danhMuc : list2) { %>
            
            
            <div class="col-lg-4 col-md-6 pb-1">
                <div class="cat-item d-flex flex-column border mb-4" style="padding: 30px;">
                    
                    <a href="" class="cat-img position-relative overflow-hidden mb-3">
                        <img class="img-fluid" src="${url}/img/<%=danhMuc.getAnhdanhmuc() %>" alt="">
                    </a>
                    <h5 class="font-weight-semi-bold m-0"><%=danhMuc.getTendanhmuc() %></h5>
                </div>
            </div>
            <%} %>
        </div>
    </div>
    <!-- Categories End -->

	<%
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		List<SanPham> sanPhams = sanPhamDAO.getNewSanPham();
	%>
    


    <!-- Products Start -->
    <div class="container-fluid pt-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">HÀNG MỚI NHẤT</span></h2>
        </div>
        <div class="row px-xl-5 pb-3">
           <%for(SanPham sanPham : sanPhams) { %>
            <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                <div class="card product-item border-0 mb-4">
                    <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                        <img class="img-fluid w-100" src="${url}/img/<%=sanPham.getHinhanh() %>" alt="">
                    </div>
                    <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                        <h6 class="text-truncate mb-3"><%=sanPham.getTensanpham() %></h6>
                        <div class="d-flex justify-content-center">
                            <h6>$<%=sanPham.getGia() %></h6>
                        </div>
                    </div>
                    <div class="card-footer d-flex justify-content-between bg-light border">
                        <a href="chiTietSanPham.jsp?masanpham=<%=sanPham.getMasanpham() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>Chi tiết sản phẩm</a>
                        <a href="addGioHang?masanpham=<%=sanPham.getMasanpham() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Thêm vào giỏ hàng</a>
                    </div>
                </div>
            </div>
            <%} %>
        </div>
    </div>
    <!-- Products End -->


    <!-- Subscribe Start -->
    <div class="container-fluid bg-secondary my-5">
        <div class="row justify-content-md-center py-5 px-xl-5">
            <div class="col-md-6 col-12 py-5">
                <div class="text-center mb-2 pb-2">
                    <h2 class="section-title px-5 mb-3"><span class="bg-secondary px-2"> Ý KIẾN CỦA BẠN</span></h2>
                    <p>Nếu bạn có thắc mắc hay phàn nàn gì, hãy đóng góp ý kiến của bạn cho chúng tôi. Xin cảm ơn</p>
                </div>
                <form action="feedback" method="post">
                    <div class="input-group">
                        <input type="text" name="phanhoi" class="form-control border-white p-4" placeholder="Nhập ý kiến của bạn">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary px-4">Gửi</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Subscribe End -->

	<%
		AnhNhaTaiTroDAO anNhaTaiTroDAO = new AnhNhaTaiTroDAO();
		List<AnhNhaTaiTro> list3 = anNhaTaiTroDAO.getAllAnh();
	%>
    


    <!-- Vendor Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel vendor-carousel">
                <%for(AnhNhaTaiTro anhNhaTaiTro : list3) { %>
                    <div class="vendor-item border p-4">
                        <img src="${url}/img/<%=anhNhaTaiTro.getAnhnhatt() %>" alt="">
                    </div>
                    <%} %>
                </div>
            </div>
        </div>
    </div>
    <!-- Vendor End -->


    <%@include file="phantachlayout/footer.jsp" %>

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/${url}/js/bootstrap.bundle.min.js"></script>
    <script src="${url}/lib/easing/easing.min.js"></script>
    <script src="${url}/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="${url}/mail/jqBootstrapValidation.min.js"></script>
    <script src="${url}/mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="${url}/js/main.js"></script>
</body>

</html>