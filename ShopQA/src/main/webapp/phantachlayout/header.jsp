<%@page import="model.DanhMuc"%>
<%@page import="java.util.List"%>
<%@page import="dao.DanhMucDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<script>
        function kiemTraNhapThongTin() {
            // Lấy giá trị từ trường nhập liệu
            var timKiemValue = document.getElementById("timKiem").value;
            // Kiểm tra xem trường nhập liệu có rỗng không
            if (timKiemValue.trim() === "") {
                // Nếu rỗng, hiển thị thông báo
                alert("Vui lòng nhập thông tin sản phẩm cần tìm!");
            }
        }
    </script>
<!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark" href="">FAQs</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Help</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Support</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a class="text-dark pl-2" href="">
                        <i class="fab fa-youtube"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="index.jsp" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold">Shop Online</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="timKiemSanPham.jsp">
                    <div class="input-group">
    <input type="text" id="timKiem" name="timKiem" class="form-control" placeholder="Tìm kiếm sản phẩm">
                        <div class="input-group-append">
                            <button onclick="kiemTraNhapThongTin()" type="submit" class="fa fa-search"></button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                
                <a href="giohang.jsp" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">${cart_list.size() }</span>
                </a>
            </div>
        </div>
    </div>
    <!-- Topbar End -->

	<%
		DanhMucDAO danhMucDAO = new DanhMucDAO();
        List<DanhMuc> list = danhMucDAO.getAllDanhMuc();
	%>
    <!-- Navbar Start -->
    <div class="container-fluid mb-5">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Danh mục quần áo</h6>
                    
                </a>
                <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0" id="navbar-vertical">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        
                        <%for(DanhMuc danhMuc : list) { %>
                        <a href="shopbydanhmuc.jsp?madanhmuc=<%=danhMuc.getMadanhmuc() %>" class="nav-item nav-link"><%=danhMuc.getTendanhmuc() %></a>
                        <% } %>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="index.jsp" class="nav-item nav-link active">Home</a>
                            <a href="shop.jsp" class="nav-item nav-link">Shop</a>
                            
				
                            
                            
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                            <c:if test="${not empty khachhang }">
                             <a href="donhang.jsp" class="nav-item nav-link">Đơn hàng của tôi</a>
                            <a href="profileKhachHang.jsp"  class="nav-item nav-link">Hello ${khachhang.hoten }</a>
                            <a href="dangXuatKhachHang" class="nav-item nav-link">Đăng xuất</a>
                           </c:if>
                           <c:if test="${empty khachhang and empty admin }">
                            <a href="dangNhap.jsp" class="nav-item nav-link">Đăng nhập</a>
                            <a href="dangKy.jsp" class="nav-item nav-link">Đăng ký</a>
                           </c:if>
                           <c:if test="${not empty admin }">
                            <a href="#"  class="nav-item nav-link">Hello ${admin.hoten }</a>
                            <a href="admin/index.jsp" class="nav-item nav-link">Về trang admin</a>
                            <a href="dangxuatadmin" class="nav-item nav-link">Đăng xuất</a>
                           </c:if>
                           
                        </div>
                    </div>
                </nav>
                <div id="header-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active" style="height: 410px;">
                            <img class="img-fluid" src="${url}/img/carousel-1.jpg" alt="Image">
                            <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                <div class="p-3" style="max-width: 700px;">
                                    
                                    <h3 class="display-4 text-white font-weight-semi-bold mb-4">Welcome</h3>
                                    <a href="shop.jsp" class="btn btn-light py-2 px-3">Mua hàng ngay</a>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                                    </div>
            </div>
        </div>
    </div>
    <!-- Navbar End -->
   

